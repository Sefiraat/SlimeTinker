package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.events.friend.EventFriend;
import io.github.sefiraat.slimetinker.events.friend.TraitEventType;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.sefiraat.slimetinker.utils.GeneralUtils;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import org.apache.commons.lang.Validate;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Map;

import static io.github.sefiraat.slimetinker.events.friend.EventChannels.checkBoots;
import static io.github.sefiraat.slimetinker.events.friend.EventChannels.checkChestplate;
import static io.github.sefiraat.slimetinker.events.friend.EventChannels.checkHelm;
import static io.github.sefiraat.slimetinker.events.friend.EventChannels.checkLeggings;
import static io.github.sefiraat.slimetinker.events.friend.EventChannels.checkTool;
import static io.github.sefiraat.slimetinker.events.friend.EventChannels.settlePotionEffects;

public class DurabilityListener implements Listener {

    @SuppressWarnings("unused")
    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent event) {

        ItemStack damagedItem = event.getItem();
        EventFriend friend = new EventFriend(event.getPlayer(), TraitEventType.DURABILITY);
        String armourTypeName = ItemUtils.getArmourTypeName(damagedItem);

        if (ItemUtils.isTinkers(damagedItem)) {
            if (ItemUtils.isTool(damagedItem)) {
                checkTool(friend);
            } else if (armourTypeName != null) {
                switch (armourTypeName) {
                    case IDStrings.HELMET:
                        checkHelm(friend);
                        break;
                    case IDStrings.CHESTPLATE:
                        checkChestplate(friend);
                        break;
                    case IDStrings.LEGGINGS:
                        checkLeggings(friend);
                        break;
                    case IDStrings.BOOTS:
                        checkBoots(friend);
                        break;
                    default:
                        return;
                }
            }
        } else {
            return;
        }

        // Mods
        modChecks(damagedItem, event);

        // Settle
        settlePotionEffects(friend);
        if (friend.isCancelEvent()) {
            event.setCancelled(true);
        }

        ItemMeta im = event.getItem().getItemMeta();
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
        if (!ItemUtils.isTool(damagedItem)) { // Not a tool, moving on!
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

        if (modLevels.containsKey(ItemUtils.getIdOrType(Materials.MOD_PLATE))) { // PLATE
            modCheckPlate(damagedItem, modLevels.get(ItemUtils.getIdOrType(Materials.MOD_PLATE)), event);
        }

    }

    private void modCheckPlate(ItemStack damagedItem, int level, PlayerItemDamageEvent event) {

        ItemMeta im = damagedItem.getItemMeta();
        Validate.notNull(im, "Meta is null, mod check failed");

        if (ItemUtils.isReinforced(damagedItem)) {
            level = level * 2;
        }

        if (GeneralUtils.testChance(level, 10)) {
            event.setCancelled(true);
        }

    }

}
