package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.items.materials.Liquid;
import io.github.sefiraat.slimetinker.items.recipes.RecipeManager;

import java.util.HashMap;
import java.util.Map;

public final class Liquids {

    private Liquids() {
        throw new IllegalStateException("Utility class");
    }

    public static Map<String, Liquid> LIQUIDS = new HashMap<>();

    static {
        LIQUIDS.put(RecipeManager.ID_IRON, new Liquid(RecipeManager.ID_IRON,"#8c8c8c"));
        LIQUIDS.put(RecipeManager.ID_GOLD, new Liquid(RecipeManager.ID_GOLD,"#ffe138"));
        LIQUIDS.put(RecipeManager.ID_COPPER, new Liquid(RecipeManager.ID_COPPER,"#c99732"));
        LIQUIDS.put(RecipeManager.ID_LEAD, new Liquid(RecipeManager.ID_LEAD,"#9043ba"));
        LIQUIDS.put(RecipeManager.ID_SILVER, new Liquid(RecipeManager.ID_SILVER,"#d4d4d4"));
        LIQUIDS.put(RecipeManager.ID_ALUMINIUM, new Liquid(RecipeManager.ID_ALUMINIUM,"#b0b0b0"));
        LIQUIDS.put(RecipeManager.ID_TIN, new Liquid(RecipeManager.ID_TIN,"#a89b9b"));
        LIQUIDS.put(RecipeManager.ID_ZINC, new Liquid(RecipeManager.ID_ZINC,"#9ba8a6"));
        LIQUIDS.put(RecipeManager.ID_MAGNESIUM, new Liquid(RecipeManager.ID_MAGNESIUM,"#e8cef5"));
    }

    public static Liquid getById(String id) {
        return LIQUIDS.get(id);
    }

}
