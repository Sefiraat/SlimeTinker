package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.SlimeTinker;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.persistence.PersistentDataType;

public class EntityTeleportListener implements Listener {

    @SuppressWarnings("unused")
    @EventHandler
    public void onEntityTeleport(EntityTeleportEvent event) {
        if (event.getEntity().getPersistentDataContainer().has(SlimeTinker.inst().getKeys().getToolFlagTeleport(), PersistentDataType.STRING)) {
            event.setCancelled(true);
        }
    }

}
