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
    private final PlayerDamagedListener playerDamagedListener = new PlayerDamagedListener();
    private final DropItemListener dropItemListener = new DropItemListener();
    private final GeneralEntityEventListener generalEntityEventListener = new GeneralEntityEventListener();
    private final PlayerInteractListener playerInteractListener = new PlayerInteractListener();

    public ListenerManager(SlimeTinker plugin, PluginManager manager) {
        manager.registerEvents(durabilityListener, plugin);
        manager.registerEvents(blockBreakListener, plugin);
        manager.registerEvents(blockPlaceListener, plugin);
        manager.registerEvents(entityDamagedListener, plugin);
        manager.registerEvents(entityKilledListener, plugin);
        manager.registerEvents(playerDamagedListener, plugin);
        manager.registerEvents(dropItemListener, plugin);
        manager.registerEvents(generalEntityEventListener, plugin);
        manager.registerEvents(playerInteractListener, plugin);
    }

}
