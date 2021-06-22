package io.github.sefiraat.slimetinker.items.componentmaterials;

import io.github.sefiraat.slimetinker.items.materials.ComponentMaterial;
import io.github.sefiraat.slimetinker.managers.SupportedPluginsManager;
import lombok.Getter;
import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class CMManager {

    @Getter
    private static final Map<String, ComponentMaterial> MAP = new HashMap<>();

    static {

        MAP.putAll(CMCore.getMap()); // We always need core

        if (SupportedPluginsManager.INFINITY_EXPANSION) {
            MAP.putAll(CMInfinity.getMap());
        }

    }

    public static ComponentMaterial getById(String id) {
        return MAP.get(id);
    }

}
