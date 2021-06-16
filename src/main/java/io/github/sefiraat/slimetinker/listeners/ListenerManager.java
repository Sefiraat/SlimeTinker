package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.SlimeTinker;

public class ListenerManager {

    DurabilityListener durabilityListener = new DurabilityListener();
    BlockBreakListener blockBreakListener = new BlockBreakListener();
    BlockPlaceListener blockPlaceListener = new BlockPlaceListener();
    EntityDamagedListener entityDamagedListener  = new EntityDamagedListener();

    public ListenerManager() {
        SlimeTinker.inst().getServer().getPluginManager().registerEvents(durabilityListener, SlimeTinker.inst());
        SlimeTinker.inst().getServer().getPluginManager().registerEvents(blockBreakListener, SlimeTinker.inst());
        SlimeTinker.inst().getServer().getPluginManager().registerEvents(blockPlaceListener, SlimeTinker.inst());
        SlimeTinker.inst().getServer().getPluginManager().registerEvents(entityDamagedListener, SlimeTinker.inst());
    }

}
