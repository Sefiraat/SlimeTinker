package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.events.friend.EventChannels;
import io.github.sefiraat.slimetinker.events.friend.EventFriend;
import io.github.sefiraat.slimetinker.events.friend.TraitEventType;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.sefiraat.slimetinker.utils.EntityUtils;
import io.github.sefiraat.slimetinker.utils.Experience;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.github.sefiraat.slimetinker.events.friend.EventChannels.checkArmour;
import static io.github.sefiraat.slimetinker.events.friend.EventChannels.checkTool;
import static io.github.sefiraat.slimetinker.events.friend.EventChannels.settlePotionEffects;

public class EntityKilledListener implements Listener {

    protected final Map<Player, List<ItemStack>> heldItems = new HashMap<>();

    @SuppressWarnings("unused")
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player p = event.getEntity();
        List<ItemStack> list = new ArrayList<>();
        if (heldItems.containsKey(p)) {
            list.addAll(heldItems.get(p));
        }

        for (ItemStack i : event.getDrops()) {
            if (ItemUtils.cannotDrop(i)) {
                list.add(i);
            }
        }
        for (ItemStack i : list) {
            event.getDrops().remove(i);
        }
        heldItems.put(p, list);

    }

    @SuppressWarnings("unused")
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

    @SuppressWarnings("unused")
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        LivingEntity dyingEntity = event.getEntity();

        if (dyingEntity.getKiller() == null || isInvalidEvent(event)) {
            return;
        }

        Player player = dyingEntity.getKiller();
        ItemStack heldItem = player.getInventory().getItemInMainHand();

        EventFriend friend = new EventFriend(player, TraitEventType.ENTITY_DAMAGED);

        friend.setDamagedEntity(dyingEntity);

        // Properties
        checkTool(friend);
        checkArmour(friend);


        if (friend.isActionTaken()) {
            // Mods
            modChecks(event, heldItem);

            // Settle
            settlePotionEffects(friend);
            int rawExp = event.getDroppedExp();
            event.setDroppedExp((int) Math.ceil(event.getDroppedExp() * friend.getPlayerExpMod()));
            if (event.getDroppedExp() > 0 && friend.isMetalCheck()) {
                Experience.addExp(heldItem, (int) Math.ceil(event.getDroppedExp() / 10D), player, true);
                event.setDroppedExp(0);
            } else {
                EventChannels.provideKillExp(friend, rawExp);
            }
        }
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
                Location location = entity.getLocation().clone().add(0.5, 0.5, 0.5);
                entity.getWorld().dropItemNaturally(location, additionalDrop);
                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.BLUE, 2);
                entity.getWorld().spawnParticle(Particle.REDSTONE, location, 10, 0.2, 0.2, 0.2, 0.5, dustOptions);
            }
        }
    }

    private boolean isInvalidEvent(EntityDeathEvent event) {
        final LivingEntity entity = event.getEntity();
        return EntityUtils.isTrainingDummy(entity)
            || EntityUtils.shouldIgnoreDamage(entity);
    }
}
