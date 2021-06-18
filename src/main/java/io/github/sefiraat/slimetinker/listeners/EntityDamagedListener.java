package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.items.templates.ToolTemplate;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.sefiraat.slimetinker.utils.Experience;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

import java.util.Map;

public class EntityDamagedListener implements Listener {

    @EventHandler
    public void onEntityDamaged(EntityDamageByEntityEvent event) {

        if (!(event.getDamager() instanceof Player) || event.isCancelled()) {
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

        Experience.addToolExp(heldItem, (int) event.getDamage(), player);

        modCheckQuartz(event, heldItem);

    }

    private boolean cancelIfBroken(ItemStack itemStack) {
        Damageable damageable = (Damageable) itemStack.getItemMeta();
        assert damageable != null;
        return damageable.getDamage() == itemStack.getType().getMaxDurability() - 1;
    }

    private void modCheckQuartz(EntityDamageByEntityEvent event, ItemStack heldItem) {

        Map<String, Integer> modLevels = Modifications.getAllModLevels(heldItem);

        if (!modLevels.containsKey(Material.QUARTZ.toString())) { // The tools must have the quartz mod
            return;
        }

        int quartzLevel = modLevels.get(Material.QUARTZ.toString());
        event.setDamage(event.getDamage() * (quartzLevel * 0.2));

    }

}
