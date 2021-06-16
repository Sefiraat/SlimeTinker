package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.items.templates.ToolTemplate;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.meta.Damageable;

public class DurabilityListener implements Listener {

    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent event) {
        if (!ToolTemplate.isTool(event.getItem())) {
            return;
        }
        Damageable damageable = (Damageable) event.getItem().getItemMeta();
        if ((damageable.getDamage() + event.getDamage()) >= event.getItem().getType().getMaxDurability()) { // This will break the tool
            damageable.setDamage(event.getItem().getType().getMaxDurability() - 1);
            event.setCancelled(true);
        }
    }

}
