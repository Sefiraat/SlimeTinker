package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.utils.BlockUtils;
import io.github.thebusybiscuit.slimefun4.api.events.BlockPlacerPlaceEvent;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    @SuppressWarnings("unused")
    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockPlace(BlockPlaceEvent event) {
        if (!event.isCancelled() && !(event.getBlock().getBlockData() instanceof Ageable)) { // Don't want crops to be marked, they are checked when broken against their age
            BlockUtils.getStateMap().put(event.getBlock().getLocation(), true);
        }
    }

    @SuppressWarnings("unused")
    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockPlacerPlace(BlockPlacerPlaceEvent event) {
        if (!event.isCancelled()) {
            BlockUtils.getStateMap().put(event.getBlock().getLocation(), true);
        }
    }
}
