package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.items.templates.ToolTemplate;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class EntityKilledListener implements Listener {

    @EventHandler
    public void onEntityDamaged(EntityDeathEvent event) {

        Player player = event.getEntity().getKiller();
        ItemStack heldItem = player.getInventory().getItemInMainHand();

        if (!ToolTemplate.isTool(heldItem)) { // Not a Tinker's tool, so we don't care
            return;
        }

        modCheckLapis(event, heldItem);

    }

    private void modCheckLapis(EntityDeathEvent event, ItemStack heldItem) {

        Map<String, Integer> modLevels = Modifications.getAllModLevels(heldItem);

        if (!modLevels.containsKey(Material.LAPIS_LAZULI.toString())) { // The tools must have the lapis mod
            return;
        }

        int lapisLevel = modLevels.get(Material.LAPIS_LAZULI.toString());

        LivingEntity entity = event.getEntity();

        for (ItemStack drop : event.getDrops()) {
            int additionalAmount = (int) Math.floor(drop.getAmount() * (lapisLevel * 0.1));
            if (additionalAmount > 0) {
                ItemStack additionalDrop = new ItemStack(drop.getType());
                additionalDrop.setAmount(additionalAmount);
                Location location = entity.getLocation().clone().add(0.5,0.5,0.5);
                entity.getWorld().dropItemNaturally(location, additionalDrop);
                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.BLUE, 2);
                entity.getWorld().spawnParticle(Particle.REDSTONE, location, 10, 0.2, 0.2, 0.2, 0.5, dustOptions);
            }
        }
    }

}
