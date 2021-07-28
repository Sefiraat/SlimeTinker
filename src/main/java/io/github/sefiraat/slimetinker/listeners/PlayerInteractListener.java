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

        if (!ItemUtils.isTool(heldItem)) { // Not a Tinker's tool, so we don't care
            return;
        }

        // Properties
        ItemMeta im = heldItem.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        String matPropertyHead = ItemUtils.getToolHeadMaterial(c);
        String matPropertyBinding = ItemUtils.getToolBindingMaterial(c);
        String matPropertyRod = ItemUtils.getToolRodMaterial(c);
        int toolLevel = ItemUtils.getTinkerLevel(c);

        EventFriend friend = new EventFriend();

        friend.setPlayer(player);
        friend.setEventType(TraitEventType.TICK);

        // Properties
        checkTool(friend);
        checkArmour(friend);

        // Cancel if tool is broken (moved down here as we bypass if the duralium event fires)
        if (cancelIfBroken(heldItem)) {
            if (matPropertyHead.equals(IDStrings.DURALIUM) || matPropertyRod.equals(IDStrings.TITANIUM)) { // Run duralium as it will flag the duraliumCheck meaning we can bypass durability checks
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
        if (friend.getHypercube() == 2) {
            processHyperCube(event);
        }


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

    private void processHyperCube(PlayerInteractEvent event) {

        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        Player p = event.getPlayer();
        ItemStack i = p.getInventory().getItemInMainHand();
        ItemMeta im = i.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        long time = System.currentTimeMillis();

        NamespacedKey keyCd = SlimeTinker.inst().getKeys().getTraitsCooldownHypercube();
        NamespacedKey keyLoc = SlimeTinker.inst().getKeys().getTraitsHypercubeLocation();

        if (p.isSneaking()) {
            // Setting location
            c.set(keyLoc, PersistentDataType.STRING, GeneralUtils.serializeLocation(p.getLocation()));
            p.sendMessage(ThemeUtils.SUCCESS + "Location set!");
        } else {
            // Actioning location
            if (c.has(keyCd, PersistentDataType.LONG)) {
                Long cd = c.get(keyCd, PersistentDataType.LONG);
                assert cd != null;
                if (cd > time) {
                    p.sendMessage(ThemeUtils.WARNING + "Recall is on cooldown!");
                    return;
                }
            }
            if (!c.has(keyLoc, PersistentDataType.STRING)) {
                p.sendMessage(ThemeUtils.WARNING + "You have not yet set a location to recall to!");
                return;
            }
            p.teleport(GeneralUtils.deserializeLocation(Objects.requireNonNull(c.get(keyLoc, PersistentDataType.STRING))));
            p.sendMessage(ThemeUtils.SUCCESS + "Whoosh!");
            Instant cd = Instant.ofEpochMilli(time).plusSeconds(300);
            c.set(keyCd, PersistentDataType.LONG, cd.toEpochMilli());
        }

        i.setItemMeta(im);

    }

}
