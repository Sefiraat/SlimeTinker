package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.items.tools.ToolTemplate;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

public class EntityDamagedListener implements Listener {

    @EventHandler
    public void onEntityDamaged(EntityDamageByEntityEvent event) {

        if (!(event.getDamager() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getDamager();

        ItemStack heldItem = player.getInventory().getItemInMainHand();

        if (!ToolTemplate.isTool(heldItem)) { // Not a Tinker's tool, so we don't care
            return;
        }

        if (cancelIfBroken(heldItem)) {
            player.sendMessage(ThemeUtils.WARNING + "Your weapon is broken, you should really repair it!");
            event.setCancelled(true);
            return;
        }

    }

    private boolean cancelIfBroken(ItemStack itemStack) {
        Damageable damageable = (Damageable) itemStack.getItemMeta();
        assert damageable != null;
        if (damageable.getDamage() == itemStack.getType().getMaxDurability() - 1) { // Tool is 'broken'
            return true;
        }
        return false;
    }

}
