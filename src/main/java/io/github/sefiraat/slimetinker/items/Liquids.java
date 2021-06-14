package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.items.materials.Liquid;
import io.github.sefiraat.slimetinker.items.recipes.RecipeManager;

import java.util.HashMap;
import java.util.Map;

public final class Liquids {

    private Liquids() {
        throw new IllegalStateException("Utility class");
    }

    protected static final Map<String, Liquid> map = new HashMap<>();

    static {
        map.put(RecipeManager.ID_IRON, new Liquid(RecipeManager.ID_IRON,"#8c8c8c"));
        map.put(RecipeManager.ID_GOLD, new Liquid(RecipeManager.ID_GOLD,"#ffe138"));
        map.put(RecipeManager.ID_COPPER, new Liquid(RecipeManager.ID_COPPER,"#c99732"));
        map.put(RecipeManager.ID_LEAD, new Liquid(RecipeManager.ID_LEAD,"#9043ba"));
        map.put(RecipeManager.ID_SILVER, new Liquid(RecipeManager.ID_SILVER,"#d4d4d4"));
        map.put(RecipeManager.ID_ALUMINIUM, new Liquid(RecipeManager.ID_ALUMINIUM,"#b0b0b0"));
        map.put(RecipeManager.ID_TIN, new Liquid(RecipeManager.ID_TIN,"#a89b9b"));
        map.put(RecipeManager.ID_ZINC, new Liquid(RecipeManager.ID_ZINC,"#9ba8a6"));
        map.put(RecipeManager.ID_MAGNESIUM, new Liquid(RecipeManager.ID_MAGNESIUM,"#e8cef5"));
        map.put(RecipeManager.ID_COAL, new Liquid(RecipeManager.ID_COAL, "#2d2e2d"));
        map.put(RecipeManager.ID_STEEL, new Liquid(RecipeManager.ID_STEEL,"#d1d1d1"));
        map.put(RecipeManager.ID_DAM_STEEL, new Liquid(RecipeManager.ID_DAM_STEEL, "#a38c8c"));
        map.put(RecipeManager.ID_DURALIUM, new Liquid(RecipeManager.ID_DURALIUM, "#a3a089"));
        map.put(RecipeManager.ID_BRONZE, new Liquid(RecipeManager.ID_BRONZE, "#877435"));
        map.put(RecipeManager.ID_ALUBRONZE, new Liquid(RecipeManager.ID_ALUBRONZE, "#bdaa6d"));
        map.put(RecipeManager.ID_HARD, new Liquid(RecipeManager.ID_HARD, "#29251a"));
        map.put(RecipeManager.ID_CORBRONZE, new Liquid(RecipeManager.ID_CORBRONZE, "#8a6500"));
        map.put(RecipeManager.ID_SOLDER, new Liquid(RecipeManager.ID_SOLDER, "#b7afbd"));
        map.put(RecipeManager.ID_BILLON, new Liquid(RecipeManager.ID_BILLON, "#b0c2be"));
        map.put(RecipeManager.ID_BRASS, new Liquid(RecipeManager.ID_BRASS, "#dbcd4b"));
        map.put(RecipeManager.ID_ALUBRASS, new Liquid(RecipeManager.ID_ALUBRASS, "#dbd279"));
        map.put(RecipeManager.ID_NICKEL, new Liquid(RecipeManager.ID_NICKEL, "#ebebeb"));
        map.put(RecipeManager.ID_COBALT, new Liquid(RecipeManager.ID_COBALT, "#9e9e9e"));
        map.put(RecipeManager.ID_REINFORCED, new Liquid(RecipeManager.ID_REINFORCED, "#465899"));
    }

    public static Liquid getById(String id) {
        return map.get(id);
    }

}
