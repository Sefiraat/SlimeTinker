package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.events.EntityDamageEvents;
import io.github.sefiraat.slimetinker.events.EventFriend;
import io.github.sefiraat.slimetinker.items.componentmaterials.factories.CMManager;
import io.github.sefiraat.slimetinker.items.templates.ToolTemplate;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.sefiraat.slimetinker.utils.Experience;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.sefiraat.slimetinker.utils.enums.TraitEventType;
import io.github.sefiraat.slimetinker.utils.enums.TraitPartType;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class EntityDamagedListener implements Listener {

    @EventHandler
    public void onEntityDamaged(EntityDamageByEntityEvent event) {

        if (!(event.getDamager() instanceof Player) || event.isCancelled() || !(event.getEntity() instanceof LivingEntity)) {
            return;
        }

        Player player = (Player) event.getDamager();
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
        friend.setDamagedEntity(event.getEntity());
        friend.setToolLevel(toolLevel);
        friend.setInitialDamage(event.getDamage());

        TraitEventType traitEventType = TraitEventType.ENTITY_DAMAGED;
        CMManager.getMAP().get(matPropertyHead).runEvent(traitEventType, TraitPartType.HEAD, friend);
        CMManager.getMAP().get(matPropertyBinding).runEvent(traitEventType, TraitPartType.BINDER, friend);
        CMManager.getMAP().get(matPropertyRod).runEvent(traitEventType, TraitPartType.ROD, friend);

        // Cancel if tool is broken (moved down here as we bypass if the duralium event fires)
        if (cancelIfBroken(heldItem)) {
            if (matPropertyHead.equals(IDStrings.DURALIUM) || matPropertyRod.equals(IDStrings.TITANIUM)) { // Run duraluim as it will flag the duraliumCheck meaning we can bypass durability checks
                EntityDamageEvents.headDuralium(friend);
            }
            if (!friend.isDuraliumCheck()) {
                player.sendMessage(ThemeUtils.WARNING + "Your weapon is broken, you should really repair it!");
                event.setCancelled(true);
                return;
            }
        }

        // Mods
        modChecks(event, heldItem, friend);

        // Settle

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

        event.setDamage(event.getDamage() * friend.getDamageMod());
        Experience.addToolExp(heldItem, (int) Math.ceil(event.getDamage() * friend.getToolExpMod()), player, false);

    }

    private boolean cancelIfBroken(ItemStack itemStack) {
        Damageable damageable = (Damageable) itemStack.getItemMeta();
        assert damageable != null;
        return damageable.getDamage() == itemStack.getType().getMaxDurability() - 1;
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


}
