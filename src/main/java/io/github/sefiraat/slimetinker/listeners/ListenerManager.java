package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.SlimeTinker;
import lombok.Data;
import org.bukkit.plugin.PluginManager;

@Data
public class ListenerManager {

    private final DurabilityListener durabilityListener = new DurabilityListener();
    private final BlockBreakListener blockBreakListener = new BlockBreakListener();
    private final BlockPlaceListener blockPlaceListener = new BlockPlaceListener();
    private final EntityDamagedListener entityDamagedListener  = new EntityDamagedListener();
    private final EntityKilledListener entityKilledListener = new EntityKilledListener();

    public ListenerManager(SlimeTinker plugin, PluginManager manager) {
        manager.registerEvents(durabilityListener, plugin);
        manager.registerEvents(blockBreakListener, plugin);
        manager.registerEvents(blockPlaceListener, plugin);
        manager.registerEvents(entityDamagedListener, plugin);
        manager.registerEvents(entityKilledListener, plugin);
    }

}
