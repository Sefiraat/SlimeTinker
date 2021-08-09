package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.SlimeTinker;
import me.mrCookieSlime.Slimefun.cscorelib2.data.PersistentDataAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.EntityTeleportEvent;

public class GeneralEntityEventListener implements Listener {

    @SuppressWarnings("unused")
    @EventHandler
    public void onEntityTeleport(EntityTeleportEvent event) {
        if (PersistentDataAPI.hasString(event.getEntity(), SlimeTinker.inst().getKeys().getToolFlagTeleport())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onChangeTarget(EntityTargetLivingEntityEvent event) {
        String id = PersistentDataAPI.getString(event.getEntity(), SlimeTinker.inst().getKeys().getArmourHappyPiglin());
        if (event.getTarget() instanceof Player) {
            Player p = (Player) event.getTarget();
            if (id != null && id.equals(p.getUniqueId().toString())) {
                event.setCancelled(true);
            }
        }
    }

}
