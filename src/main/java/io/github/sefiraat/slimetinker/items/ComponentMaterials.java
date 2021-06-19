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
        map.put(IDStrings.IRON, new ComponentMaterial(IDStrings.IRON,"#8c8c8c"));
        map.put(IDStrings.GOLD, new ComponentMaterial(IDStrings.GOLD,"#ffe138"));
        map.put(IDStrings.COPPER, new ComponentMaterial(IDStrings.COPPER,"#c99732"));
        map.put(IDStrings.LEAD, new ComponentMaterial(IDStrings.LEAD,"#9043ba"));
        map.put(IDStrings.SILVER, new ComponentMaterial(IDStrings.SILVER,"#d4d4d4"));
        map.put(IDStrings.ALUMINUM, new ComponentMaterial(IDStrings.ALUMINUM,"#b0b0b0"));
        map.put(IDStrings.TIN, new ComponentMaterial(IDStrings.TIN,"#a89b9b"));
        map.put(IDStrings.ZINC, new ComponentMaterial(IDStrings.ZINC,"#9ba8a6"));
        map.put(IDStrings.MAGNESIUM, new ComponentMaterial(IDStrings.MAGNESIUM,"#e8cef5"));
        map.put(IDStrings.COAL, new ComponentMaterial(IDStrings.COAL, "#2d2e2d"));
        map.put(IDStrings.STEEL, new ComponentMaterial(IDStrings.STEEL,"#d1d1d1"));
        map.put(IDStrings.DAMSTEEL, new ComponentMaterial(IDStrings.DAMSTEEL, "#a38c8c"));
        map.put(IDStrings.DURALIUM, new ComponentMaterial(IDStrings.DURALIUM, "#a3a089"));
        map.put(IDStrings.BRONZE, new ComponentMaterial(IDStrings.BRONZE, "#877435"));
        map.put(IDStrings.ALUBRONZE, new ComponentMaterial(IDStrings.ALUBRONZE, "#bdaa6d"));
        map.put(IDStrings.HARD, new ComponentMaterial(IDStrings.HARD, "#29251a"));
        map.put(IDStrings.CORBRONZE, new ComponentMaterial(IDStrings.CORBRONZE, "#8a6500"));
        map.put(IDStrings.SOLDER, new ComponentMaterial(IDStrings.SOLDER, "#b7afbd"));
        map.put(IDStrings.BILLON, new ComponentMaterial(IDStrings.BILLON, "#b0c2be"));
        map.put(IDStrings.BRASS, new ComponentMaterial(IDStrings.BRASS, "#dbcd4b"));
        map.put(IDStrings.ALUBRASS, new ComponentMaterial(IDStrings.ALUBRASS, "#dbd279"));
        map.put(IDStrings.NICKEL, new ComponentMaterial(IDStrings.NICKEL, "#ebebeb"));
        map.put(IDStrings.COBALT, new ComponentMaterial(IDStrings.COBALT, "#9e9e9e"));
        map.put(IDStrings.REINFORCED, new ComponentMaterial(IDStrings.REINFORCED, "#465899"));
        map.put(IDStrings.STRING, new ComponentMaterial(IDStrings.STRING, "#f5f5f5"));
        map.put(IDStrings.VINE, new ComponentMaterial(IDStrings.VINE, "#4ca86b"));
        map.put(IDStrings.ROOTRED, new ComponentMaterial(IDStrings.ROOTRED, "#b5365e"));
        map.put(IDStrings.ROOTGREEN, new ComponentMaterial(IDStrings.ROOTGREEN, "#36b549"));
        map.put(IDStrings.VINERED, new ComponentMaterial(IDStrings.VINERED, "#9c091d"));
        map.put(IDStrings.VINEGREEN, new ComponentMaterial(IDStrings.VINEGREEN, "#1b8045"));
    }

    public static ComponentMaterial getById(String id) {
        return map.get(id);
    }

}
