package io.github.sefiraat.slimetinker.runnables;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.events.TickEvents;
import io.github.sefiraat.slimetinker.events.friend.EventFriend;
import io.github.sefiraat.slimetinker.events.friend.TraitEventType;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

import static io.github.sefiraat.slimetinker.events.friend.EventChannels.checkArmour;
import static io.github.sefiraat.slimetinker.events.friend.EventChannels.checkTool;
import static io.github.sefiraat.slimetinker.events.friend.EventChannels.settlePotionEffects;

public class EffectTick extends BukkitRunnable {

    @Override
    public void run() {
        for (Player player : SlimeTinker.inst().getServer().getOnlinePlayers()) {
            ItemStack heldItem = player.getInventory().getItemInMainHand();

            Map<PotionEffectType, Integer> potionEffects = new HashMap<>();
            EventFriend friend = new EventFriend();

            friend.setHeldItem(heldItem);
            friend.setPlayer(player);
            friend.setEventType(TraitEventType.TICK);

            // Properties
            checkTool(friend);
            checkArmour(friend);

            // Mods
            checkModifications(heldItem, player, potionEffects);

            // Settle if not cancelled
            if (!friend.isCancelEvent()) {
                settlePotionEffects(friend);
            }

            // TODO remove with modification changes
            for (Map.Entry<PotionEffectType, Integer> entry : potionEffects.entrySet()) {
                player.addPotionEffect(new PotionEffect(entry.getKey(), SlimeTinker.RUNNABLE_TICK_RATE + 5, entry.getValue(), false, true, true));
            }
            TickEvents.magnetic(friend);
        }
    }

    private void checkModifications(ItemStack heldItem, Player player, Map<PotionEffectType, Integer> potionEffects) {

        if (!ItemUtils.isTool(heldItem)) {
            return;
        }

        Map<String, Integer> modLevels = Modifications.getAllModLevels(heldItem);
        for (Map.Entry<String, Integer> entry : modLevels.entrySet()) {
            if (Material.REDSTONE.toString().equals(entry.getKey())) {
                modRedstone(entry.getValue(), potionEffects);
            }
        }

    }

    private void modRedstone(int level, Map<PotionEffectType, Integer> potionEffects) {
        if (potionEffects.containsKey(PotionEffectType.FAST_DIGGING)) {
            potionEffects.put(PotionEffectType.FAST_DIGGING, potionEffects.get(PotionEffectType.FAST_DIGGING) + level);
        } else {
            potionEffects.put(PotionEffectType.FAST_DIGGING, level);
        }
    }

}
