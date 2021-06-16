package io.github.sefiraat.slimetinker.modifiers;

import lombok.Data;
import org.bukkit.NamespacedKey;

import java.util.Map;

@Data
public class Mod {

    private final Map<Integer, Integer> requirementMap;
    private final NamespacedKey levelKey;

    public Mod(Map<Integer, Integer> map, NamespacedKey levelKey) {
        requirementMap = map;
        this.levelKey = levelKey;
    }

}
