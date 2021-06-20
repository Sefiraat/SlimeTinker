package io.github.sefiraat.slimetinker.events;

import org.bukkit.potion.PotionEffectType;

import java.util.Map;

public class EventsTick {

    public static void rodGold(EventFriend friend) {
        increaseEffect(PotionEffectType.GLOWING, friend.getPotionEffects());
    }




















    private static void increaseEffect(PotionEffectType potionEffectType, Map<PotionEffectType, Integer> potionEffects) {
        if (potionEffects.containsKey(potionEffectType)) {
            potionEffects.put(potionEffectType, potionEffects.get(potionEffectType) + 1);
        } else {
            potionEffects.put(potionEffectType, 0);
        }
    }

    private static void increaseEffect(PotionEffectType potionEffectType, Map<PotionEffectType, Integer> potionEffects, int amount) {
        if (potionEffects.containsKey(potionEffectType)) {
            potionEffects.put(potionEffectType, potionEffects.get(potionEffectType) + amount);
        } else {
            potionEffects.put(potionEffectType, amount);
        }
    }

}
