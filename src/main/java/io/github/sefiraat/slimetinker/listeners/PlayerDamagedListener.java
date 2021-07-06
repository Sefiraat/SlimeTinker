package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.events.EventFriend;
import io.github.sefiraat.slimetinker.items.componentmaterials.factories.CMManager;
import io.github.sefiraat.slimetinker.items.templates.ToolTemplate;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.sefiraat.slimetinker.utils.Experience;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.enums.TraitEventType;
import io.github.sefiraat.slimetinker.utils.enums.TraitPartType;
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

    @SuppressWarnings("unused")
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

        EventFriend friend = new EventFriend();

        friend.setHeldItem(heldItem);
        friend.setPlayer(player);
        friend.setToolLevel(toolLevel);
        friend.setCause(event.getCause());
        friend.setInitialDamage(event.getDamage());

        TraitEventType traitEventType = TraitEventType.PLAYER_DAMAGED;
        CMManager.getMAP().get(matPropertyHead).runEvent(traitEventType, TraitPartType.HEAD, friend);
        CMManager.getMAP().get(matPropertyBinding).runEvent(traitEventType, TraitPartType.BINDER, friend);
        CMManager.getMAP().get(matPropertyRod).runEvent(traitEventType, TraitPartType.ROD, friend);

        // Mods
        modChecks(event, heldItem);

        // Settle
        event.setDamage(event.getDamage() * friend.getDamageMod());
        if (friend.getDamageMod() == 0) {
            event.setCancelled(true);
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
            int rnd = ThreadLocalRandom.current().nextInt(1,11);
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
