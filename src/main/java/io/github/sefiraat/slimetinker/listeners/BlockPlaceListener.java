package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.thebusybiscuit.slimefun4.api.events.BlockPlacerPlaceEvent;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class BlockPlaceListener implements Listener {


    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockPlace(BlockPlaceEvent event) {
        if (!event.isCancelled()) {
            if (!(event.getBlock().getBlockData() instanceof Ageable)) { // Don't want crops to be marked, they are checked when broken against their age
                event.getBlock().setMetadata(IDStrings.ID_PLACED, new FixedMetadataValue(SlimeTinker.inst(), "y"));
            }
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockPlacerPlace(BlockPlacerPlaceEvent event) {
        if (!event.isCancelled()) {
            event.getBlock().setMetadata(IDStrings.ID_PLACED, new FixedMetadataValue(SlimeTinker.inst(), "y"));
        }
    }



}
