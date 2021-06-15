package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.items.tools.ToolTemplate;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        ItemStack heldItem = event.getPlayer().getInventory().getItemInMainHand();

        if (!ToolTemplate.isTool(heldItem)) { // Not a Tinker's tool, so we don't care
            return;
        }

        if (cancelIfBroken(heldItem)) {
            event.getPlayer().sendMessage(ThemeUtils.WARNING + "Your tool is broken, you should really repair it!");
            event.setCancelled(true);
            return;
        }

    }

    private boolean cancelIfBroken(ItemStack itemStack) {
        Damageable damageable = (Damageable) itemStack.getItemMeta();
        assert damageable != null;
        if (damageable.getDamage() == itemStack.getType().getMaxDurability() - 1) { // Tool is 'broken'
            return true;
        }
        return false;
    }



}
