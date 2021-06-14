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
    }

    public static Liquid getById(String id) {
        return map.get(id);
    }

}
