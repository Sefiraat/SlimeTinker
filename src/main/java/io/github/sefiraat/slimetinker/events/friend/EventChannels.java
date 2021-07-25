package io.github.sefiraat.slimetinker.events.friend;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMManager;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import org.apache.commons.lang.Validate;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Map;

public class EventChannels {

    public static void settlePotionEffects(EventFriend friend) {
        for (Map.Entry<PotionEffectType, Integer> entry : friend.getPotionEffects().entrySet()) {
            friend.getPlayer().addPotionEffect(new PotionEffect(entry.getKey(), SlimeTinker.RUNNABLE_TICK_RATE + 5, entry.getValue(), false, true, true));
        }
    }

    public static void checkTool(EventFriend friend) {

        if (!ItemUtils.isTool(friend.getHeldItem())) {
            return;
        }

        friend.setActiveFriendElement(ActiveFriendElement.TOOL);
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

        friend.setActiveFriendElement(ActiveFriendElement.HELMET);
        friend.setHelmet(i);
        checkArmourPiece(friend, i);

    }

    public static void checkChestplate(EventFriend friend) {

        ItemStack i = friend.getPlayer().getInventory().getChestplate();

        if (!ItemUtils.isArmour(i)) {
            return;
        }

        friend.setActiveFriendElement(ActiveFriendElement.CHESTPLATE);
        friend.setChestplate(i);
        checkArmourPiece(friend, i);

    }

    public static void checkLeggings(EventFriend friend) {

        ItemStack i = friend.getPlayer().getInventory().getLeggings();

        if (!ItemUtils.isArmour(i)) {
            return;
        }

        friend.setActiveFriendElement(ActiveFriendElement.LEGGINGS);
        friend.setLeggings(i);
        checkArmourPiece(friend, i);

    }

    public static void checkBoots(EventFriend friend) {

        ItemStack i = friend.getPlayer().getInventory().getBoots();

        if (!ItemUtils.isArmour(i)) {
            return;
        }

        friend.setActiveFriendElement(ActiveFriendElement.BOOTS);
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
