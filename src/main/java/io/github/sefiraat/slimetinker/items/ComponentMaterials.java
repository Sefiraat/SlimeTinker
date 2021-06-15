package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.items.materials.ComponentMaterial;
import io.github.sefiraat.slimetinker.items.recipes.RecipeManager;

import java.util.HashMap;
import java.util.Map;

public final class ComponentMaterials {

    private ComponentMaterials() {
        throw new IllegalStateException("Utility class");
    }

    protected static final Map<String, ComponentMaterial> map = new HashMap<>();

    static {
        map.put(RecipeManager.ID_IRON, new ComponentMaterial(RecipeManager.ID_IRON,"#8c8c8c"));
        map.put(RecipeManager.ID_GOLD, new ComponentMaterial(RecipeManager.ID_GOLD,"#ffe138"));
        map.put(RecipeManager.ID_COPPER, new ComponentMaterial(RecipeManager.ID_COPPER,"#c99732"));
        map.put(RecipeManager.ID_LEAD, new ComponentMaterial(RecipeManager.ID_LEAD,"#9043ba"));
        map.put(RecipeManager.ID_SILVER, new ComponentMaterial(RecipeManager.ID_SILVER,"#d4d4d4"));
        map.put(RecipeManager.ID_ALUMINIUM, new ComponentMaterial(RecipeManager.ID_ALUMINIUM,"#b0b0b0"));
        map.put(RecipeManager.ID_TIN, new ComponentMaterial(RecipeManager.ID_TIN,"#a89b9b"));
        map.put(RecipeManager.ID_ZINC, new ComponentMaterial(RecipeManager.ID_ZINC,"#9ba8a6"));
        map.put(RecipeManager.ID_MAGNESIUM, new ComponentMaterial(RecipeManager.ID_MAGNESIUM,"#e8cef5"));
        map.put(RecipeManager.ID_COAL, new ComponentMaterial(RecipeManager.ID_COAL, "#2d2e2d"));
        map.put(RecipeManager.ID_STEEL, new ComponentMaterial(RecipeManager.ID_STEEL,"#d1d1d1"));
        map.put(RecipeManager.ID_DAMSTEEL, new ComponentMaterial(RecipeManager.ID_DAMSTEEL, "#a38c8c"));
        map.put(RecipeManager.ID_DURALIUM, new ComponentMaterial(RecipeManager.ID_DURALIUM, "#a3a089"));
        map.put(RecipeManager.ID_BRONZE, new ComponentMaterial(RecipeManager.ID_BRONZE, "#877435"));
        map.put(RecipeManager.ID_ALUBRONZE, new ComponentMaterial(RecipeManager.ID_ALUBRONZE, "#bdaa6d"));
        map.put(RecipeManager.ID_HARD, new ComponentMaterial(RecipeManager.ID_HARD, "#29251a"));
        map.put(RecipeManager.ID_CORBRONZE, new ComponentMaterial(RecipeManager.ID_CORBRONZE, "#8a6500"));
        map.put(RecipeManager.ID_SOLDER, new ComponentMaterial(RecipeManager.ID_SOLDER, "#b7afbd"));
        map.put(RecipeManager.ID_BILLON, new ComponentMaterial(RecipeManager.ID_BILLON, "#b0c2be"));
        map.put(RecipeManager.ID_BRASS, new ComponentMaterial(RecipeManager.ID_BRASS, "#dbcd4b"));
        map.put(RecipeManager.ID_ALUBRASS, new ComponentMaterial(RecipeManager.ID_ALUBRASS, "#dbd279"));
        map.put(RecipeManager.ID_NICKEL, new ComponentMaterial(RecipeManager.ID_NICKEL, "#ebebeb"));
        map.put(RecipeManager.ID_COBALT, new ComponentMaterial(RecipeManager.ID_COBALT, "#9e9e9e"));
        map.put(RecipeManager.ID_REINFORCED, new ComponentMaterial(RecipeManager.ID_REINFORCED, "#465899"));
        map.put(RecipeManager.ID_STRING, new ComponentMaterial(RecipeManager.ID_STRING, "#f5f5f5"));
        map.put(RecipeManager.ID_VINE, new ComponentMaterial(RecipeManager.ID_VINE, "#4ca86b"));
        map.put(RecipeManager.ID_ROOTRED, new ComponentMaterial(RecipeManager.ID_ROOTRED, "#b5365e"));
        map.put(RecipeManager.ID_ROOTGREEN, new ComponentMaterial(RecipeManager.ID_ROOTGREEN, "#36b549"));
        map.put(RecipeManager.ID_VINERED, new ComponentMaterial(RecipeManager.ID_VINERED, "#9c091d"));
        map.put(RecipeManager.ID_VINEGREEN, new ComponentMaterial(RecipeManager.ID_VINEGREEN, "#1b8045"));
    }

    public static ComponentMaterial getById(String id) {
        return map.get(id);
    }

}
