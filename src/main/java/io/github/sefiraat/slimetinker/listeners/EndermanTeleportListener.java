package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.SlimeTinker;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.persistence.PersistentDataType;

public class EndermanTeleportListener implements Listener {

    @SuppressWarnings("unused")
    @EventHandler
    public void onEndermanTeleport(EntityTeleportEvent event) {
        if (event.getEntity().getPersistentDataContainer().has(new NamespacedKey(SlimeTinker.inst(), "ST_STOP_TELEPORT"), PersistentDataType.STRING)) {
            event.setCancelled(true);
        }
    }

}
