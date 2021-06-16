package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.items.materials.ComponentMaterial;
import io.github.sefiraat.slimetinker.utils.IDStrings;

import java.util.HashMap;
import java.util.Map;

public final class ComponentMaterials {

    private ComponentMaterials() {
        throw new IllegalStateException("Utility class");
    }

    protected static final Map<String, ComponentMaterial> map = new HashMap<>();

    static {
        map.put(IDStrings.ID_IRON, new ComponentMaterial(IDStrings.ID_IRON,"#8c8c8c"));
        map.put(IDStrings.ID_GOLD, new ComponentMaterial(IDStrings.ID_GOLD,"#ffe138"));
        map.put(IDStrings.ID_COPPER, new ComponentMaterial(IDStrings.ID_COPPER,"#c99732"));
        map.put(IDStrings.ID_LEAD, new ComponentMaterial(IDStrings.ID_LEAD,"#9043ba"));
        map.put(IDStrings.ID_SILVER, new ComponentMaterial(IDStrings.ID_SILVER,"#d4d4d4"));
        map.put(IDStrings.ID_ALUMINUM, new ComponentMaterial(IDStrings.ID_ALUMINUM,"#b0b0b0"));
        map.put(IDStrings.ID_TIN, new ComponentMaterial(IDStrings.ID_TIN,"#a89b9b"));
        map.put(IDStrings.ID_ZINC, new ComponentMaterial(IDStrings.ID_ZINC,"#9ba8a6"));
        map.put(IDStrings.ID_MAGNESIUM, new ComponentMaterial(IDStrings.ID_MAGNESIUM,"#e8cef5"));
        map.put(IDStrings.ID_COAL, new ComponentMaterial(IDStrings.ID_COAL, "#2d2e2d"));
        map.put(IDStrings.ID_STEEL, new ComponentMaterial(IDStrings.ID_STEEL,"#d1d1d1"));
        map.put(IDStrings.ID_DAMSTEEL, new ComponentMaterial(IDStrings.ID_DAMSTEEL, "#a38c8c"));
        map.put(IDStrings.ID_DURALIUM, new ComponentMaterial(IDStrings.ID_DURALIUM, "#a3a089"));
        map.put(IDStrings.ID_BRONZE, new ComponentMaterial(IDStrings.ID_BRONZE, "#877435"));
        map.put(IDStrings.ID_ALUBRONZE, new ComponentMaterial(IDStrings.ID_ALUBRONZE, "#bdaa6d"));
        map.put(IDStrings.ID_HARD, new ComponentMaterial(IDStrings.ID_HARD, "#29251a"));
        map.put(IDStrings.ID_CORBRONZE, new ComponentMaterial(IDStrings.ID_CORBRONZE, "#8a6500"));
        map.put(IDStrings.ID_SOLDER, new ComponentMaterial(IDStrings.ID_SOLDER, "#b7afbd"));
        map.put(IDStrings.ID_BILLON, new ComponentMaterial(IDStrings.ID_BILLON, "#b0c2be"));
        map.put(IDStrings.ID_BRASS, new ComponentMaterial(IDStrings.ID_BRASS, "#dbcd4b"));
        map.put(IDStrings.ID_ALUBRASS, new ComponentMaterial(IDStrings.ID_ALUBRASS, "#dbd279"));
        map.put(IDStrings.ID_NICKEL, new ComponentMaterial(IDStrings.ID_NICKEL, "#ebebeb"));
        map.put(IDStrings.ID_COBALT, new ComponentMaterial(IDStrings.ID_COBALT, "#9e9e9e"));
        map.put(IDStrings.ID_REINFORCED, new ComponentMaterial(IDStrings.ID_REINFORCED, "#465899"));
        map.put(IDStrings.ID_STRING, new ComponentMaterial(IDStrings.ID_STRING, "#f5f5f5"));
        map.put(IDStrings.ID_VINE, new ComponentMaterial(IDStrings.ID_VINE, "#4ca86b"));
        map.put(IDStrings.ID_ROOTRED, new ComponentMaterial(IDStrings.ID_ROOTRED, "#b5365e"));
        map.put(IDStrings.ID_ROOTGREEN, new ComponentMaterial(IDStrings.ID_ROOTGREEN, "#36b549"));
        map.put(IDStrings.ID_VINERED, new ComponentMaterial(IDStrings.ID_VINERED, "#9c091d"));
        map.put(IDStrings.ID_VINEGREEN, new ComponentMaterial(IDStrings.ID_VINEGREEN, "#1b8045"));
    }

    public static ComponentMaterial getById(String id) {
        return map.get(id);
    }

}
