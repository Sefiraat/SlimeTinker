package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.events.EntityDamageEventFriend;
import io.github.sefiraat.slimetinker.items.ComponentMaterials;
import io.github.sefiraat.slimetinker.items.materials.ComponentMaterial;
import io.github.sefiraat.slimetinker.items.templates.ToolTemplate;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.sefiraat.slimetinker.utils.Experience;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityKilledListener implements Listener {

    protected Map<Player, List<ItemStack>>  heldItems = new HashMap<>();

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player p = event.getEntity();
        List<ItemStack> list = new ArrayList<>();
        if (heldItems.containsKey(p)) {
            list.addAll(heldItems.get(p));
        }
        for (ItemStack i : event.getDrops()) {
            if (!ToolTemplate.isTool(i) || !ItemUtils.getToolRodMaterial(i.getItemMeta().getPersistentDataContainer()).equals(IDStrings.SOLDER)) {
                continue;
            }
            list.add(i);
        }
        for (ItemStack i : list) {
            event.getDrops().remove(i);
        }
        heldItems.put(p, list);

    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player p = event.getPlayer();
        if (heldItems.containsKey(p)) {
            for (ItemStack i : heldItems.get(p)) {
                p.getInventory().addItem(i);
            }
        }
        heldItems.remove(p);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        LivingEntity dyingEntity = event.getEntity();

        if (dyingEntity.getKiller() == null) {
            return;
        }

        Player player = dyingEntity.getKiller();
        ItemStack heldItem = player.getInventory().getItemInMainHand();

        if (!ToolTemplate.isTool(heldItem)) { // Not a Tinker's tool, so we don't care
            return;
        }

        // Properties
        ItemMeta im = heldItem.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        String matPropertyHead = ItemUtils.getToolHeadMaterial(c);
        String matPropertyBinding = ItemUtils.getToolBindingMaterial(c);
        String matPropertyRod = ItemUtils.getToolRodMaterial(c);
        int toolLevel = Experience.getToolLevel(c);

        EntityDamageEventFriend friend = new EntityDamageEventFriend(heldItem, player, dyingEntity, toolLevel);

        for (Map.Entry<String, ComponentMaterial> mat : ComponentMaterials.getMap().entrySet()) {
            if (mat.getValue().isEventEntityDamagedHead() && matPropertyHead.equals(mat.getKey())) {
                mat.getValue().getEntityDamagedConsumerHead().accept(friend);
            }
            if (mat.getValue().isEventEntityDamagedBind() && matPropertyBinding.equals(mat.getKey())) {
                mat.getValue().getEntityDamagedConsumerBind().accept(friend);
            }
            if (mat.getValue().isEventEntityDamagedRod() && matPropertyRod.equals(mat.getKey())) {
                mat.getValue().getEntityDamagedConsumerRod().accept(friend);
            }
        }

        // Mods
        modChecks(event, heldItem);

        // Settle
        event.setDroppedExp((int) Math.ceil(event.getDroppedExp() * friend.getPlayerExpMod()));


    }

    private void modChecks(EntityDeathEvent event, ItemStack heldItem) {
        modCheckLapis(event, heldItem);
    }


    private void modCheckLapis(EntityDeathEvent event, ItemStack heldItem) {

        Map<String, Integer> modLevels = Modifications.getAllModLevels(heldItem);

        if (!modLevels.containsKey(Material.LAPIS_LAZULI.toString())) { // The tools must have the lapis mod
            return;
        }

        int lapisLevel = modLevels.get(Material.LAPIS_LAZULI.toString());

        LivingEntity entity = event.getEntity();

        for (ItemStack drop : event.getDrops()) {
            int additionalAmount = (int) Math.floor(drop.getAmount() * (lapisLevel * 0.1));
            if (additionalAmount > 0) {
                ItemStack additionalDrop = new ItemStack(drop.getType());
                additionalDrop.setAmount(additionalAmount);
                Location location = entity.getLocation().clone().add(0.5,0.5,0.5);
                entity.getWorld().dropItemNaturally(location, additionalDrop);
                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.BLUE, 2);
                entity.getWorld().spawnParticle(Particle.REDSTONE, location, 10, 0.2, 0.2, 0.2, 0.5, dustOptions);
            }
        }
    }

}
