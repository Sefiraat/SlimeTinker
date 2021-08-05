package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.events.EntityDamageEvents;
import io.github.sefiraat.slimetinker.events.friend.EventFriend;
import io.github.sefiraat.slimetinker.events.friend.TraitEventType;
import io.github.sefiraat.slimetinker.events.friend.TraitPartType;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMManager;
import io.github.sefiraat.slimetinker.utils.GeneralUtils;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import org.apache.commons.lang.Validate;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.time.Instant;
import java.util.Objects;

import static io.github.sefiraat.slimetinker.events.friend.EventChannels.settlePotionEffects;

public class PlayerInteractListener implements Listener {

    @SuppressWarnings("unused")
    @EventHandler
    public void onEntityDamaged(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        ItemStack heldItem = player.getInventory().getItemInMainHand();

        int toolLevel = ItemUtils.getTinkerLevel(heldItem);

        EventFriend friend = new EventFriend();

        friend.setPlayer(player);
        friend.setEventType(TraitEventType.RIGHT_CLICK);

        // Properties
        checkTool(friend);
        checkArmour(friend);

        // Cancel if tool is broken (moved down here as we bypass if the duralium event fires)
        if (cancelIfBroken(heldItem)) {
            if (ItemUtils.worksWhenBroken(heldItem)) { // Run duralium as it will flag the duraliumCheck meaning we can bypass durability checks
                EntityDamageEvents.headDuralium(friend);
            }
            if (!friend.isDuraliumCheck()) {
                player.sendMessage(ThemeUtils.WARNING + "Your tool is broken, you should really repair it!");
                event.setCancelled(true);
                return;
            }
        }

        // Settle
        settlePotionEffects(friend);

    }

    private void checkTool(EventFriend friend) {

        if (!ItemUtils.isTool(friend.getTool())) {
            return;
        }

        ItemMeta im = friend.getTool().getItemMeta();
        Validate.notNull(im, "No item meta, failed isTool check - grr?");

        PersistentDataContainer c = im.getPersistentDataContainer();
        String matPropertyHead = ItemUtils.getToolHeadMaterial(c);
        String matPropertyBinding = ItemUtils.getToolBindingMaterial(c);
        String matPropertyRod = ItemUtils.getToolRodMaterial(c);

        CMManager.getMAP().get(matPropertyHead).runEvent(friend.getEventType(), TraitPartType.HEAD, friend);
        CMManager.getMAP().get(matPropertyBinding).runEvent(friend.getEventType(), TraitPartType.BINDER, friend);
        CMManager.getMAP().get(matPropertyRod).runEvent(friend.getEventType(), TraitPartType.ROD, friend);

    }

    private void checkArmour(EventFriend friend) {
        checkHelm(friend);
        checkChestplate(friend);
        checkLeggings(friend);
        checkBoots(friend);
    }

    private void checkHelm(EventFriend friend) {

        ItemStack i = friend.getPlayer().getInventory().getHelmet();

        if (!ItemUtils.isArmour(i)) {
            return;
        }

        friend.setHelmet(i);
        checkArmourPiece(friend, i);

    }

    private void checkChestplate(EventFriend friend) {

        ItemStack i = friend.getPlayer().getInventory().getChestplate();

        if (!ItemUtils.isArmour(i)) {
            return;
        }

        friend.setChestplate(i);
        checkArmourPiece(friend, i);

    }

    private void checkLeggings(EventFriend friend) {

        ItemStack i = friend.getPlayer().getInventory().getLeggings();

        if (!ItemUtils.isArmour(i)) {
            return;
        }

        friend.setLeggings(i);
        checkArmourPiece(friend, i);

    }

    private void checkBoots(EventFriend friend) {

        ItemStack i = friend.getPlayer().getInventory().getBoots();

        if (!ItemUtils.isArmour(i)) {
            return;
        }

        friend.setBoots(i);
        checkArmourPiece(friend, i);

    }

    private void checkArmourPiece(EventFriend friend, ItemStack itemStack) {

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

    private boolean cancelIfBroken(ItemStack itemStack) {
        Damageable damageable = (Damageable) itemStack.getItemMeta();
        assert damageable != null;
        return damageable.getDamage() == itemStack.getType().getMaxDurability() - 1;
    }



}
