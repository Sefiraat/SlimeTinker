package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class DropItemListener implements Listener {


    @SuppressWarnings("unused")
    @EventHandler
    public void onDropItem(PlayerDropItemEvent event) {
        ItemStack itemStack = event.getItemDrop().getItemStack();
        if (ItemUtils.cannotDrop(itemStack)) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ThemeUtils.WARNING + "This cannot be dropped.");
        }

    }


}
