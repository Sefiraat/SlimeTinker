package io.github.sefiraat.slimetinker.listeners;

import com.google.common.base.Preconditions;
import io.github.sefiraat.slimetinker.events.friend.EventFriend;
import io.github.sefiraat.slimetinker.events.friend.TraitEventType;
import io.github.sefiraat.slimetinker.utils.Experience;
import io.github.sefiraat.slimetinker.utils.Ids;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static io.github.sefiraat.slimetinker.events.friend.EventChannels.checkArmour;
import static io.github.sefiraat.slimetinker.events.friend.EventChannels.checkTool;
import static io.github.sefiraat.slimetinker.events.friend.EventChannels.settlePotionEffects;

public class PlayerInteractListener implements Listener {

    @SuppressWarnings("unused")
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        ItemStack heldItem = player.getInventory().getItemInMainHand();

        EventFriend friend = new EventFriend(player, TraitEventType.INTERACT);
        friend.setBlock(event.getClickedBlock());
        friend.setAction(event.getAction());
        // Properties
        checkTool(friend);
        checkArmour(friend);

        // Settle
        if (friend.isActionTaken()) {
            settlePotionEffects(friend);
        }
    }

    @EventHandler
    public void onTillOrPath(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack itemStack = event.getItem();
            if (eventIsTinkersTillOrPath(itemStack, event.getClickedBlock())) {
                if (ItemUtils.isTinkersBroken(itemStack)) {
                    event.setCancelled(true);
                    event.getPlayer()
                         .sendMessage(ThemeUtils.WARNING + "Your tool is broken, you should really repair it!");
                } else {
                    Experience.addExp(itemStack, 1, event.getPlayer(), true);
                }
            }
        }
    }

    public boolean eventIsTinkersTillOrPath(ItemStack itemStack, Block block) {
        if (ItemUtils.isTool(itemStack)) {
            String type = ItemUtils.getToolTypeName(itemStack);
            Preconditions.checkNotNull(type, "Item is tool but without a type? /sf cheat or other error has happened.");
            return ((type.equals(Ids.HOE) || type.equals(Ids.SHOVEL))
                && (block.getType() == Material.DIRT || block.getType() == Material.GRASS_BLOCK));
        } else {
            return false;
        }
    }
}
