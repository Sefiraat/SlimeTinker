package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.events.friend.EventFriend;
import io.github.sefiraat.slimetinker.events.friend.TraitEventType;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.sefiraat.slimetinker.utils.EntityUtils;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static io.github.sefiraat.slimetinker.events.friend.EventChannels.checkArmour;
import static io.github.sefiraat.slimetinker.events.friend.EventChannels.checkTool;
import static io.github.sefiraat.slimetinker.events.friend.EventChannels.settlePotionEffects;

public class EntityDamagedListener implements Listener {

    @SuppressWarnings("unused")
    @EventHandler
    public void onEntityDamaged(EntityDamageByEntityEvent event) {

        if (isValidEvent(event)) {
            return;
        }

        Player player = (Player) event.getDamager();
        ItemStack heldItem = player.getInventory().getItemInMainHand();

        EventFriend friend = new EventFriend(player, TraitEventType.ENTITY_DAMAGED);

        friend.setDamagedEntity(event.getEntity());
        friend.setInitialDamage(event.getDamage());

        // Properties
        checkTool(friend);
        checkArmour(friend);

        if (friend.isActionTaken()) {
            // Mods
            modChecks(event, heldItem, friend);

            // Settle
            if (friend.isCancelEvent()) {
                event.setCancelled(true);
                return;
            }
            settlePotionEffects(friend);
            LivingEntity e = (LivingEntity) friend.getDamagedEntity();

            if (friend.getSegganesson() == 10) {
                event.setDamage(event.getDamage() + friend.getSegganessonDamage());
                friend.setSegganesson(0);
                friend.setSegganessonDamage(0);
                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(50, 120, 200), 5);
                e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 50, 1, 1, 1, 0.5, dustOptions, true);
            }

            if (friend.getCharged() >= 2) { // Special case for Charged - event is dependant on two materials, consumers up a value to trigger this
                int rnd = ThreadLocalRandom.current().nextInt(1,6);
                if (rnd == 1) {
                    friend.setDamageMod(friend.getDamageMod() * 3);
                    Particle.DustOptions dustOptions = new Particle.DustOptions(Color.YELLOW, 5);
                    e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 50, 1, 1, 1, 0.5, dustOptions, true);
                    PotionEffect potionEffect = new PotionEffect(PotionEffectType.SLOW, 40,99);
                    e.addPotionEffect(potionEffect);
                }
            }

            event.setDamage(friend.getDamageOverride() == null ? event.getDamage() * friend.getDamageMod() : friend.getDamageOverride());

        }

    }

    private void modChecks(EntityDamageByEntityEvent event, ItemStack heldItem, EventFriend friend) { // Player damaging entity

        Map<String, Integer> modLevels = Modifications.getAllModLevels(heldItem);

        if (modLevels.containsKey(Material.QUARTZ.toString())) { // QUARTZ
            modCheckQuartz(modLevels.get(Material.QUARTZ.toString()), friend);
        }

    }

    private void modCheckQuartz(int level, EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() + (level * 0.2));
    }

    private boolean isValidEvent(EntityDamageByEntityEvent event) {
        return  !(event.getDamager() instanceof Player)
                || event.isCancelled()
                || !(event.getEntity() instanceof LivingEntity)
                || EntityUtils.isTrainingDummy(event.getEntity());
    }

}
