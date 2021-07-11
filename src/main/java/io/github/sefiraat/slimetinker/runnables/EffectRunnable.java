package io.github.sefiraat.slimetinker.runnables;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.events.EventFriend;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMManager;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.enums.TraitEventType;
import io.github.sefiraat.slimetinker.utils.enums.TraitPartType;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public class EffectRunnable extends BukkitRunnable {

    @Override
    public void run() {
        for (Player player : SlimeTinker.inst().getServer().getOnlinePlayers()) {

            ItemStack heldItem = player.getInventory().getItemInMainHand();

            if (!ItemUtils.isTool(heldItem)) {
                return;
            }
            Map<PotionEffectType, Integer> potionEffects = new HashMap<>();
            EventFriend friend = new EventFriend();

            friend.setHeldItem(heldItem);
            friend.setPlayer(player);

            // Properties
            ItemMeta im = heldItem.getItemMeta();
            assert im != null;
            PersistentDataContainer c = im.getPersistentDataContainer();
            String matPropertyHead = ItemUtils.getToolHeadMaterial(c);
            String matPropertyBinding = ItemUtils.getToolBindingMaterial(c);
            String matPropertyRod = ItemUtils.getToolRodMaterial(c);

            TraitEventType traitEventType = TraitEventType.TICK;
            CMManager.getMAP().get(matPropertyHead).runEvent(traitEventType, TraitPartType.HEAD, friend);
            CMManager.getMAP().get(matPropertyBinding).runEvent(traitEventType, TraitPartType.BINDER, friend);
            CMManager.getMAP().get(matPropertyRod).runEvent(traitEventType, TraitPartType.ROD, friend);

            // Mods
            checkModifications(heldItem, player, potionEffects);

            // Settle
            for (Map.Entry<PotionEffectType, Integer> entry : friend.getPotionEffects().entrySet()) {
                player.addPotionEffect(new PotionEffect(entry.getKey(), SlimeTinker.RUNNABLE_TICK_RATE + 5, entry.getValue(), false, true, true));
            }
            // TODO remove with modification changes
            for (Map.Entry<PotionEffectType, Integer> entry : potionEffects.entrySet()) {
                player.addPotionEffect(new PotionEffect(entry.getKey(), SlimeTinker.RUNNABLE_TICK_RATE + 5, entry.getValue(), false, true, true));
            }
        }
    }


    private void checkModifications(ItemStack heldItem, Player player, Map<PotionEffectType, Integer> potionEffects) {

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
