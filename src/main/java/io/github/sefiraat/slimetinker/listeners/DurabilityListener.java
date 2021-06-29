package io.github.sefiraat.slimetinker.listeners;

import io.github.mooy1.infinitylib.items.StackUtils;
import io.github.sefiraat.slimetinker.events.EventFriend;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMManager;
import io.github.sefiraat.slimetinker.items.templates.ToolTemplate;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.enums.TraitEventType;
import io.github.sefiraat.slimetinker.utils.enums.TraitPartType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class DurabilityListener implements Listener {

    @SuppressWarnings("unused")
    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent event) {

        ItemStack damagedItem = event.getItem();
        if (!ToolTemplate.isTool(damagedItem)) { // Not a tool, moving on!
            return;
        }

        // Properties
        ItemMeta im = event.getItem().getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        String matPropertyHead = ItemUtils.getToolHeadMaterial(c);
        String matPropertyBinding = ItemUtils.getToolBindingMaterial(c);
        String matPropertyRod = ItemUtils.getToolRodMaterial(c);

        EventFriend friend = new EventFriend();

        friend.setHeldItem(event.getItem());
        friend.setPlayer(event.getPlayer());

        TraitEventType traitEventType = TraitEventType.DURABILITY;
        CMManager.getMAP().get(matPropertyHead).runEvent(traitEventType, TraitPartType.HEAD, friend);
        CMManager.getMAP().get(matPropertyBinding).runEvent(traitEventType, TraitPartType.BINDER, friend);
        CMManager.getMAP().get(matPropertyRod).runEvent(traitEventType, TraitPartType.ROD, friend);

        // Mods
        modChecks(damagedItem, event);


        // Settle
        if (friend.isCancelEvent()) {
            event.setCancelled(true);
        }

        Damageable damageable = (Damageable) im;
        event.setDamage((int) Math.ceil(event.getDamage() * friend.getDurabilityMod())); // Modify the damage taken

        if ((damageable.getDamage() + event.getDamage()) >= event.getItem().getType().getMaxDurability()) { // This will break the tool, lets stop that!
            damageable.setDamage(event.getItem().getType().getMaxDurability() - 1);
            damagedItem.setItemMeta(im);
            event.setCancelled(true);
        }

    }

    @SuppressWarnings("unused")
    @EventHandler
    public void onItemBreak(PlayerItemBreakEvent event) { // Covering my bases here for anything else that can break a tool, may not be required?

        ItemStack damagedItem = event.getBrokenItem();
        if (!ToolTemplate.isTool(damagedItem)) { // Not a tool, moving on!
            return;
        }

        ItemStack newItem = damagedItem.clone();
        ItemMeta im = newItem.getItemMeta();
        assert im != null;

        Damageable damageable = (Damageable) im;
        damageable.setDamage(damagedItem.getType().getMaxDurability() - 1);
        event.getPlayer().getInventory().addItem(newItem);

    }

    private void modChecks(ItemStack damagedItem, PlayerItemDamageEvent event) {

        Map<String, Integer> modLevels = Modifications.getAllModLevels(damagedItem);

        if (modLevels.containsKey(StackUtils.getIDorType(Materials.MOD_PLATE))) { // PLATE
            modCheckPlate(damagedItem, modLevels.get(StackUtils.getIDorType(Materials.MOD_PLATE)), event);
        }

    }

    private void modCheckPlate(ItemStack damagedItem, int level, PlayerItemDamageEvent event) {

        ItemMeta im = damagedItem.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        String matPropertyRod = ItemUtils.getToolRodMaterial(c);

        if (matPropertyRod.equals(IDStrings.REINFORCED)) {
            level = level * 2;
        }

        int rnd = ThreadLocalRandom.current().nextInt(1,11);

        if (rnd <= level) {
            event.setCancelled(true);
        }

    }


}
