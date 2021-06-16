package io.github.sefiraat.slimetinker.items.recipes;

import io.github.sefiraat.slimetinker.items.materials.Alloy;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Alloys {

    private Alloys() {
        throw new IllegalStateException("Utility class");
    }

    protected static final Map<String, Integer> RECIPE_STEEL = new HashMap<>();
    protected static final Map<String, Integer> RECIPE_DAM_STEEL = new HashMap<>();
    protected static final Map<String, Integer> RECIPE_DURALIUM = new HashMap<>();
    protected static final Map<String, Integer> RECIPE_BRONZE = new HashMap<>();
    protected static final Map<String, Integer> RECIPE_ALU_BRONZE = new HashMap<>();
    protected static final Map<String, Integer> RECIPE_HARD_METAL = new HashMap<>();
    protected static final Map<String, Integer> RECIPE_COR_BRONZE = new HashMap<>();
    protected static final Map<String, Integer> RECIPE_SOLDER = new HashMap<>();
    protected static final Map<String, Integer> RECIPE_BILLON = new HashMap<>();
    protected static final Map<String, Integer> RECIPE_BRASS = new HashMap<>();
    protected static final Map<String, Integer> RECIPE_ALU_BRASS = new HashMap<>();
    protected static final Map<String, Integer> RECIPE_NICKEL = new HashMap<>();
    protected static final Map<String, Integer> RECIPE_COBALT = new HashMap<>();
    protected static final Map<String, Integer> RECIPE_REINFORCED = new HashMap<>();

    @Getter
    protected static final List<Alloy> ALLOY_LIST = new ArrayList<>();

    static {

        RECIPE_STEEL.put(IDStrings.ID_IRON, 2);
        RECIPE_STEEL.put(IDStrings.ID_COAL, 1);

        RECIPE_DAM_STEEL.put(IDStrings.ID_STEEL, 1);
        RECIPE_DAM_STEEL.put(IDStrings.ID_IRON, 2);
        RECIPE_DAM_STEEL.put(IDStrings.ID_COAL, 1);

        RECIPE_DURALIUM.put(IDStrings.ID_ALUMINUM, 2);
        RECIPE_DURALIUM.put(IDStrings.ID_COPPER, 1);

        RECIPE_BRONZE.put(IDStrings.ID_COPPER, 2);
        RECIPE_BRONZE.put(IDStrings.ID_TIN, 1);

        RECIPE_ALU_BRONZE.put(IDStrings.ID_ALUMINUM, 2);
        RECIPE_ALU_BRONZE.put(IDStrings.ID_BRONZE, 1);

        RECIPE_HARD_METAL.put(IDStrings.ID_ALUBRASS, 1);
        RECIPE_HARD_METAL.put(IDStrings.ID_DURALIUM, 1);
        RECIPE_HARD_METAL.put(IDStrings.ID_DAMSTEEL, 1);
        RECIPE_HARD_METAL.put(IDStrings.ID_COAL, 4);

        RECIPE_COR_BRONZE.put(IDStrings.ID_BRONZE, 1);
        RECIPE_COR_BRONZE.put(IDStrings.ID_GOLD, 1);
        RECIPE_COR_BRONZE.put(IDStrings.ID_SILVER, 1);
        RECIPE_COR_BRONZE.put(IDStrings.ID_COPPER, 1);

        RECIPE_SOLDER.put(IDStrings.ID_LEAD, 2);
        RECIPE_SOLDER.put(IDStrings.ID_TIN, 1);

        RECIPE_BILLON.put(IDStrings.ID_SILVER, 2);
        RECIPE_BILLON.put(IDStrings.ID_COPPER, 1);

        RECIPE_BRASS.put(IDStrings.ID_COPPER, 2);
        RECIPE_BRASS.put(IDStrings.ID_ZINC, 1);

        RECIPE_ALU_BRASS.put(IDStrings.ID_BRASS, 1);
        RECIPE_ALU_BRASS.put(IDStrings.ID_ALUMINUM, 2);

        RECIPE_NICKEL.put(IDStrings.ID_IRON, 2);
        RECIPE_NICKEL.put(IDStrings.ID_COPPER, 1);

        RECIPE_COBALT.put(IDStrings.ID_NICKEL, 1);
        RECIPE_COBALT.put(IDStrings.ID_IRON, 1);
        RECIPE_COBALT.put(IDStrings.ID_COPPER, 1);

        RECIPE_REINFORCED.put(IDStrings.ID_DAMSTEEL, 1);
        RECIPE_REINFORCED.put(IDStrings.ID_HARD, 1);
        RECIPE_REINFORCED.put(IDStrings.ID_CORBRONZE, 1);
        RECIPE_REINFORCED.put(IDStrings.ID_SOLDER, 1);
        RECIPE_REINFORCED.put(IDStrings.ID_BILLON, 1);
        RECIPE_REINFORCED.put(IDStrings.ID_GOLD, 1);

        ALLOY_LIST.add(new Alloy(IDStrings.ID_STEEL, RECIPE_STEEL));
        ALLOY_LIST.add(new Alloy(IDStrings.ID_DAMSTEEL, RECIPE_DAM_STEEL));
        ALLOY_LIST.add(new Alloy(IDStrings.ID_DURALIUM, RECIPE_DURALIUM));
        ALLOY_LIST.add(new Alloy(IDStrings.ID_BRONZE, RECIPE_BRONZE));
        ALLOY_LIST.add(new Alloy(IDStrings.ID_ALUBRONZE, RECIPE_ALU_BRONZE));
        ALLOY_LIST.add(new Alloy(IDStrings.ID_HARD, RECIPE_HARD_METAL));
        ALLOY_LIST.add(new Alloy(IDStrings.ID_CORBRONZE, RECIPE_COR_BRONZE));
        ALLOY_LIST.add(new Alloy(IDStrings.ID_SOLDER, RECIPE_SOLDER));
        ALLOY_LIST.add(new Alloy(IDStrings.ID_BILLON, RECIPE_BILLON));
        ALLOY_LIST.add(new Alloy(IDStrings.ID_BRASS, RECIPE_BRASS));
        ALLOY_LIST.add(new Alloy(IDStrings.ID_ALUBRASS, RECIPE_ALU_BRASS));
        ALLOY_LIST.add(new Alloy(IDStrings.ID_NICKEL, RECIPE_NICKEL));
        ALLOY_LIST.add(new Alloy(IDStrings.ID_COBALT, RECIPE_COBALT));
        ALLOY_LIST.add(new Alloy(IDStrings.ID_REINFORCED, RECIPE_REINFORCED));

    }

}
