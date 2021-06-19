package io.github.sefiraat.slimetinker.listeners;

import io.github.mooy1.infinitylib.items.StackUtils;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.templates.ToolTemplate;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
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

    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent event) {

        ItemStack damagedItem = event.getItem();
        if (!ToolTemplate.isTool(damagedItem)) { // Not a tool, moving on!
            return;
        }

        ItemMeta im = event.getItem().getItemMeta();
        Damageable damageable = (Damageable) im;
        assert damageable != null;
        EventResult eventResult = new EventResult();

        propertyChecks(damagedItem, eventResult, event);
        modChecks(damagedItem, eventResult, event);

        event.setDamage((int) Math.ceil(event.getDamage() * eventResult.getDurabilityMod())); // Modify the damage taken
        if ((damageable.getDamage() + event.getDamage()) >= event.getItem().getType().getMaxDurability()) { // This will break the tool, lets stop that!
            damageable.setDamage(event.getItem().getType().getMaxDurability() - 1);
            damagedItem.setItemMeta(im);
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void onItemBreak(PlayerItemBreakEvent event) { // Covering my bases here for anything else that can break a tool, may not be required?

        ItemStack damagedItem = event.getBrokenItem();
        if (!ToolTemplate.isTool(damagedItem)) { // Not a tool, moving on!
            return;
        }

        ItemStack newItem = damagedItem.clone();
        ItemMeta im = newItem.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        String matPropertyHead = ItemUtils.getToolHeadMaterial(c);
        String matPropertyRod = ItemUtils.getToolRodMaterial(c);

        Damageable damageable = (Damageable) im;
        damageable.setDamage(damagedItem.getType().getMaxDurability() - 1);
        event.getPlayer().getInventory().addItem(newItem);

    }

    private void propertyChecks(ItemStack damagedItem, EventResult eventResult, PlayerItemDamageEvent event) {

        ItemMeta im = damagedItem.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        String matPropertyHead = ItemUtils.getToolHeadMaterial(c);
        String matPropertyBinding = ItemUtils.getToolBindingMaterial(c);
        String matPropertyRod = ItemUtils.getToolRodMaterial(c);

        if (matPropertyRod.equals(IDStrings.ALUBRONZE)) { // BRITTLE
            propHeadAluBronze(eventResult);
        }

        if (matPropertyHead.equals(IDStrings.SOLDER)) { // HIDDEN
            propHeadSolder(damagedItem, event);
        }

        if (matPropertyHead.equals(IDStrings.ALUMINUM)) { // RECYCLABLE
            propHeadAluminum(damagedItem, event);
        }

        if (matPropertyRod.equals(IDStrings.ALUMINUM)) { // SOFT
            propRodAluminum(eventResult);
        }

        if (matPropertyHead.equals(IDStrings.REINFORCED) || matPropertyRod.equals(IDStrings.HARD)) { // Explosive pair
            propExplosive(eventResult);
        }

    }

    private void propHeadAluBronze(EventResult eventResult) {
        eventResult.setDurabilityMod(eventResult.getDurabilityMod() + 1);
    }

    private void propHeadSolder(ItemStack itemStack, PlayerItemDamageEvent event) {
        ItemMeta im = itemStack.getItemMeta();
        assert im != null;
        Damageable damageable = (Damageable) im;
        damageable.setDamage(itemStack.getType().getMaxDurability() - 1);
        itemStack.setItemMeta(im);
        event.setCancelled(true);
    }

    private void propHeadAluminum(ItemStack itemStack, PlayerItemDamageEvent event) {
        if (ThreadLocalRandom.current().nextInt(1,4) == 1) {
            ItemUtils.incrementRepair(itemStack, 1);
            event.setCancelled(true);
        }
    }

    private void propRodAluminum(EventResult eventResult) {
        eventResult.setDurabilityMod(eventResult.getDurabilityMod() + 1);
    }

    private void propExplosive(EventResult eventResult) {
        eventResult.setDurabilityMod(eventResult.getDurabilityMod() + 17);
    }

    private void modChecks(ItemStack damagedItem, EventResult eventResult, PlayerItemDamageEvent event) {

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
