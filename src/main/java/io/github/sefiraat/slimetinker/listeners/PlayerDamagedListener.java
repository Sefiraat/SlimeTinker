package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.events.PlayerDamagedEventFriend;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMManager;
import io.github.sefiraat.slimetinker.items.materials.ComponentMaterial;
import io.github.sefiraat.slimetinker.items.templates.ToolTemplate;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.sefiraat.slimetinker.utils.Experience;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class PlayerDamagedListener implements Listener {

    @EventHandler
    public void onPlayerDamaged(EntityDamageEvent event) {

        if (!(event.getEntity() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getEntity();
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

        PlayerDamagedEventFriend friend = new PlayerDamagedEventFriend(heldItem, player, toolLevel, event.getCause());

        for (Map.Entry<String, ComponentMaterial> mat : CMManager.getMAP().entrySet()) {
            if (mat.getValue().isEventPlayerDamagedHead() && matPropertyHead.equals(mat.getKey())) {
                mat.getValue().getPlayerDamagedConsumerHead().accept(friend);
            }
            if (mat.getValue().isEventPlayerDamagedBind() && matPropertyBinding.equals(mat.getKey())) {
                mat.getValue().getPlayerDamagedConsumerBind().accept(friend);
            }
            if (mat.getValue().isEventPlayerDamagedRod() && matPropertyRod.equals(mat.getKey())) {
                mat.getValue().getPlayerDamagedConsumerRod().accept(friend);
            }
        }

        // Mods
        modChecks(event, heldItem);

        // Settle
        event.setDamage(event.getDamage() * friend.getDamageMod());
    }

    private void modChecks(EntityDamageEvent event, ItemStack heldItem) { // Entity Damaging player

        Map<String, Integer> modLevels = Modifications.getAllModLevels(heldItem);

        if (event instanceof EntityDamageByEntityEvent && modLevels.containsKey(Material.DIAMOND.toString())) { // DIAMOND
            modCheckDiamond((EntityDamageByEntityEvent) event, modLevels.get(Material.DIAMOND.toString()));
        }

    }

    private void modCheckDiamond(EntityDamageByEntityEvent event, int level) {
        int rnd = ThreadLocalRandom.current().nextInt(1,11);
        if (rnd <= (level)) {
            Entity e = event.getDamager();
            LivingEntity l = (LivingEntity) e;
            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.TEAL, 1);
            e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 50, 1.5, 1.5, 1.5, 1, dustOptions);
            l.damage(event.getDamage());
            event.setCancelled(true);
        }
    }

}
