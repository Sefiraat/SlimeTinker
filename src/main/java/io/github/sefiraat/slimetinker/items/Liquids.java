package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.items.materials.Liquid;

import java.util.HashMap;
import java.util.Map;

public final class Liquids {

    private Liquids() {
        throw new IllegalStateException("Utility class");
    }

    public static Map<String, Liquid> LIQUIDS = new HashMap<>();

    static {
        LIQUIDS.put("IRON", new Liquid("IRON","#d4d4d4"));
        LIQUIDS.put("GOLD", new Liquid("GOLD","#ffe138"));
    }

}
