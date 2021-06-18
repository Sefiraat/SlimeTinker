package io.github.sefiraat.slimetinker.runnables;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.templates.ToolTemplate;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Map;

public class EffectRunnable extends BukkitRunnable {

    @Override
    public void run() {
        for (Player player : SlimeTinker.inst().getServer().getOnlinePlayers()) {
            ItemStack heldItem = player.getInventory().getItemInMainHand();
            if (!ToolTemplate.isTool(heldItem) || ItemUtils.isToolBroken(heldItem)) { // Either not a ST Tool or it is one, but broken
                return;
            }
            Map<String, Integer> modLevels = Modifications.getAllModLevels(heldItem);
            for (Map.Entry<String, Integer> entry : modLevels.entrySet()) {
                if (Material.REDSTONE.toString().equals(entry.getKey())) {
                    processRedstone(player, entry.getValue());
                }
                return;
            }
        }
    }

    private void processRedstone(Player player, int level) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, SlimeTinker.RUNNABLE_TICK_RATE + 5, level, false, false, false));
    }

}
