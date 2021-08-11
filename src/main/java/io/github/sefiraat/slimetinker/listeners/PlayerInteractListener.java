package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.events.friend.EventFriend;
import io.github.sefiraat.slimetinker.events.friend.TraitEventType;
import io.github.sefiraat.slimetinker.utils.Experience;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

import static io.github.sefiraat.slimetinker.events.friend.EventChannels.checkArmour;
import static io.github.sefiraat.slimetinker.events.friend.EventChannels.checkTool;
import static io.github.sefiraat.slimetinker.events.friend.EventChannels.settlePotionEffects;

public class PlayerInteractListener implements Listener {

    @SuppressWarnings("unused")
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        ItemStack heldItem = player.getInventory().getItemInMainHand();

        EventFriend friend = new EventFriend(player, TraitEventType.RIGHT_CLICK);

        // Properties
        checkTool(friend);
        checkArmour(friend);

        // Settle
        settlePotionEffects(friend);

    }

    private boolean cancelIfBroken(ItemStack itemStack) {
        Damageable damageable = (Damageable) itemStack.getItemMeta();
        assert damageable != null;
        return damageable.getDamage() == itemStack.getType().getMaxDurability() - 1;
    }

    @EventHandler
    public void onTillOrPath(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack itemStack = event.getItem();
            if (eventIsTinkersTillOrPath(itemStack, event.getClickedBlock())) {
                if (ItemUtils.isTinkersBroken(itemStack)) {
                    event.setCancelled(true);
                    event.getPlayer().sendMessage(ThemeUtils.WARNING + "Your tool is broken, you should really repair it!");
                } else {
                    Experience.addExp(itemStack, 1, event.getPlayer(), true);
                }
            }
        }
    }

    public boolean eventIsTinkersTillOrPath(ItemStack itemStack, Block block) {
        if (ItemUtils.isTool(itemStack)) {
            String type = ItemUtils.getToolTypeName(itemStack);
            Validate.notNull(type, "Item is tool but without a type? /sf cheat or other error has happened.");
            return ((type.equals(IDStrings.HOE) || type.equals(IDStrings.SHOVEL))
                    && (block.getType() == Material.DIRT || block.getType() == Material.GRASS_BLOCK));
        } else {
            return false;
        }
    }



}
