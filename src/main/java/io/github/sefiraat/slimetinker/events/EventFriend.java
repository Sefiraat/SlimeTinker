package io.github.sefiraat.slimetinker.events;

import lombok.Data;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;

@Data
public class EventFriend {

    private double toolExpMod = 1;
    private double damageMod = 1;
    private double durabilityMod = 1;
    private double playerExpMod = 1;
    private Map<PotionEffectType, Integer> potionEffects = new HashMap<>();

}
