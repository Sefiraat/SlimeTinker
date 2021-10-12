package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.events.friend.EventFriend;
import io.github.sefiraat.slimetinker.events.friend.TraitEventType;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
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

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static io.github.sefiraat.slimetinker.events.friend.EventChannels.checkArmour;
import static io.github.sefiraat.slimetinker.events.friend.EventChannels.checkTool;
import static io.github.sefiraat.slimetinker.events.friend.EventChannels.settlePotionEffects;

public class PlayerDamagedListener implements Listener {

    @SuppressWarnings("unused")
    @EventHandler
    public void onPlayerDamaged(EntityDamageEvent event) {

        if (!(event.getEntity() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getEntity();

        EventFriend friend = new EventFriend(player, TraitEventType.PLAYER_DAMAGED);

        friend.setCause(event.getCause());
        friend.setInitialDamage(event.getDamage());

        // Properties
        checkTool(friend);
        checkArmour(friend);

        // Mods
        modChecks(event, player.getInventory().getItemInMainHand());

        // Settle
        settlePotionEffects(friend);
        event.setDamage(event.getDamage() * friend.getDamageMod());
        if (friend.getDamageMod() == 0 || friend.isCancelEvent()) {
            event.setCancelled(true);
        }
    }

    @SuppressWarnings("unused")
    @EventHandler
    public void onPlayerDamagedByEntity(EntityDamageByEntityEvent event) {

        if (!(event.getEntity() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getEntity();

        EventFriend friend = new EventFriend(player, TraitEventType.PLAYER_DAMAGED);

        friend.setDamagingEntity(event.getDamager());
        friend.setCause(event.getCause());
        friend.setInitialDamage(event.getDamage());

        // Properties
        checkTool(friend);
        checkArmour(friend);

        if (friend.isActionTaken()) {
            // Mods
            modChecks(event, player.getInventory().getItemInMainHand());

            // Settle
            settlePotionEffects(friend);
            event.setDamage(event.getDamage() * friend.getDamageMod());
            if (friend.getDamageMod() == 0 || friend.isCancelEvent()) {
                event.setCancelled(true);
            }
        }

    }

    private void modChecks(EntityDamageEvent event, ItemStack heldItem) { // Entity Damaging player

        Map<String, Integer> modLevels = Modifications.getAllModLevels(heldItem);

        if (event instanceof EntityDamageByEntityEvent && modLevels.containsKey(Material.DIAMOND.toString())) { // DIAMOND
            modCheckDiamond((EntityDamageByEntityEvent) event, modLevels.get(Material.DIAMOND.toString()));
        }

    }

    private void modCheckDiamond(EntityDamageByEntityEvent event, int level) {
        if (event.getDamager() instanceof LivingEntity) {
            LivingEntity l = (LivingEntity) event.getDamager();
            int rnd = ThreadLocalRandom.current().nextInt(1, 11);
            if (rnd <= (level)) {
                Entity e = event.getDamager();
                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.TEAL, 1);
                e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 50, 1.5, 1.5, 1.5, 1, dustOptions);
                l.damage(event.getDamage());
                event.setCancelled(true);
            }
        }
    }

}
