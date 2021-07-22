package io.github.sefiraat.slimetinker.events.friend;

import io.github.sefiraat.slimetinker.items.componentmaterials.CMManager;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import org.apache.commons.lang.Validate;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;

public class EventChannels {

    public static void checkTool(EventFriend friend) {

        if (!ItemUtils.isTool(friend.getHeldItem())) {
            return;
        }

        ItemMeta im = friend.getHeldItem().getItemMeta();
        Validate.notNull(im, "No item meta, failed isTool check - grr?");

        PersistentDataContainer c = im.getPersistentDataContainer();
        String matPropertyHead = ItemUtils.getToolHeadMaterial(c);
        String matPropertyBinding = ItemUtils.getToolBindingMaterial(c);
        String matPropertyRod = ItemUtils.getToolRodMaterial(c);

        CMManager.getMAP().get(matPropertyHead).runEvent(friend.getEventType(), TraitPartType.HEAD, friend);
        CMManager.getMAP().get(matPropertyBinding).runEvent(friend.getEventType(), TraitPartType.BINDER, friend);
        CMManager.getMAP().get(matPropertyRod).runEvent(friend.getEventType(), TraitPartType.ROD, friend);

    }

    public static void checkArmour(EventFriend friend) {
        checkHelm(friend);
        checkChestplate(friend);
        checkLeggings(friend);
        checkBoots(friend);
    }

    public static void checkHelm(EventFriend friend) {

        ItemStack i = friend.getPlayer().getInventory().getHelmet();

        if (!ItemUtils.isArmour(i)) {
            return;
        }

        friend.setHelmet(i);
        checkArmourPiece(friend, i);

    }

    public static void checkChestplate(EventFriend friend) {

        ItemStack i = friend.getPlayer().getInventory().getChestplate();

        if (!ItemUtils.isArmour(i)) {
            return;
        }

        friend.setChestplate(i);
        checkArmourPiece(friend, i);

    }

    public static void checkLeggings(EventFriend friend) {

        ItemStack i = friend.getPlayer().getInventory().getLeggings();

        if (!ItemUtils.isArmour(i)) {
            return;
        }

        friend.setLeggings(i);
        checkArmourPiece(friend, i);

    }

    public static void checkBoots(EventFriend friend) {

        ItemStack i = friend.getPlayer().getInventory().getBoots();

        if (!ItemUtils.isArmour(i)) {
            return;
        }

        friend.setBoots(i);
        checkArmourPiece(friend, i);

    }

    public static void checkArmourPiece(EventFriend friend, ItemStack itemStack) {

        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "No item meta, failed isTool check - grr?");

        PersistentDataContainer c = im.getPersistentDataContainer();
        String matPropertyHead = ItemUtils.getArmourPlateMaterial(c);
        String matPropertyBinding = ItemUtils.getArmourGambesonMaterial(c);
        String matPropertyRod = ItemUtils.getArmourLinksMaterial(c);

        CMManager.getMAP().get(matPropertyHead).runEvent(friend.getEventType(), TraitPartType.PLATE, friend);
        CMManager.getMAP().get(matPropertyBinding).runEvent(friend.getEventType(), TraitPartType.GAMBESON, friend);
        CMManager.getMAP().get(matPropertyRod).runEvent(friend.getEventType(), TraitPartType.LINKS, friend);
    }

}
