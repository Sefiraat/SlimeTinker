package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.SlimeTinker;
import lombok.Data;

@Data
public class ListenerManager {

    private final DurabilityListener durabilityListener = new DurabilityListener();
    private final BlockBreakListener blockBreakListener = new BlockBreakListener();
    private final BlockPlaceListener blockPlaceListener = new BlockPlaceListener();
    private final EntityDamagedListener entityDamagedListener  = new EntityDamagedListener();
    private final EntityKilledListener entityKilledListener = new EntityKilledListener();

    public ListenerManager() {
        SlimeTinker.inst().getServer().getPluginManager().registerEvents(durabilityListener, SlimeTinker.inst());
        SlimeTinker.inst().getServer().getPluginManager().registerEvents(blockBreakListener, SlimeTinker.inst());
        SlimeTinker.inst().getServer().getPluginManager().registerEvents(blockPlaceListener, SlimeTinker.inst());
        SlimeTinker.inst().getServer().getPluginManager().registerEvents(entityDamagedListener, SlimeTinker.inst());
        SlimeTinker.inst().getServer().getPluginManager().registerEvents(entityKilledListener, SlimeTinker.inst());
    }

}
