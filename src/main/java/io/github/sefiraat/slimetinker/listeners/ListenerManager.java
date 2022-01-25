package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.SlimeTinker;
import org.bukkit.plugin.PluginManager;

import javax.annotation.Nonnull;

public class ListenerManager {

    private final DurabilityListener durabilityListener = new DurabilityListener();
    private final BlockBreakListener blockBreakListener = new BlockBreakListener();
    private final BlockPlaceListener blockPlaceListener = new BlockPlaceListener();
    private final EntityDamagedListener entityDamagedListener = new EntityDamagedListener();
    private final EntityKilledListener entityKilledListener = new EntityKilledListener();
    private final PlayerDamagedListener playerDamagedListener = new PlayerDamagedListener();
    private final DropItemListener dropItemListener = new DropItemListener();
    private final GeneralEntityEventListener generalEntityEventListener = new GeneralEntityEventListener();
    private final PlayerInteractListener playerInteractListener = new PlayerInteractListener();

    public ListenerManager(@Nonnull SlimeTinker plugin, @Nonnull PluginManager manager) {
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

    public DurabilityListener getDurabilityListener() {
        return durabilityListener;
    }

    public BlockBreakListener getBlockBreakListener() {
        return blockBreakListener;
    }

    public BlockPlaceListener getBlockPlaceListener() {
        return blockPlaceListener;
    }

    public EntityDamagedListener getEntityDamagedListener() {
        return entityDamagedListener;
    }

    public EntityKilledListener getEntityKilledListener() {
        return entityKilledListener;
    }

    public PlayerDamagedListener getPlayerDamagedListener() {
        return playerDamagedListener;
    }

    public DropItemListener getDropItemListener() {
        return dropItemListener;
    }

    public GeneralEntityEventListener getGeneralEntityEventListener() {
        return generalEntityEventListener;
    }

    public PlayerInteractListener getPlayerInteractListener() {
        return playerInteractListener;
    }
}
