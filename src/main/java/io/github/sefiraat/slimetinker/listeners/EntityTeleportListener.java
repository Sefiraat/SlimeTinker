package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.SlimeTinker;
import me.mrCookieSlime.Slimefun.cscorelib2.data.PersistentDataAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.persistence.PersistentDataType;

public class EntityTeleportListener implements Listener {

    @SuppressWarnings("unused")
    @EventHandler
    public void onEntityTeleport(EntityTeleportEvent event) {
        if (PersistentDataAPI.hasString(event.getEntity(), SlimeTinker.inst().getKeys().getToolFlagTeleport())) {
            event.setCancelled(true);
        }
    }

}
