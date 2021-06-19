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

        RECIPE_STEEL.put(IDStrings.IRON, 2);
        RECIPE_STEEL.put(IDStrings.COAL, 1);

        RECIPE_DAM_STEEL.put(IDStrings.STEEL, 1);
        RECIPE_DAM_STEEL.put(IDStrings.IRON, 2);
        RECIPE_DAM_STEEL.put(IDStrings.COAL, 1);

        RECIPE_DURALIUM.put(IDStrings.ALUMINUM, 2);
        RECIPE_DURALIUM.put(IDStrings.COPPER, 1);

        RECIPE_BRONZE.put(IDStrings.COPPER, 2);
        RECIPE_BRONZE.put(IDStrings.TIN, 1);

        RECIPE_ALU_BRONZE.put(IDStrings.ALUMINUM, 2);
        RECIPE_ALU_BRONZE.put(IDStrings.BRONZE, 1);

        RECIPE_HARD_METAL.put(IDStrings.ALUBRASS, 1);
        RECIPE_HARD_METAL.put(IDStrings.DURALIUM, 1);
        RECIPE_HARD_METAL.put(IDStrings.DAMSTEEL, 1);
        RECIPE_HARD_METAL.put(IDStrings.COAL, 4);

        RECIPE_COR_BRONZE.put(IDStrings.BRONZE, 1);
        RECIPE_COR_BRONZE.put(IDStrings.GOLD, 1);
        RECIPE_COR_BRONZE.put(IDStrings.SILVER, 1);
        RECIPE_COR_BRONZE.put(IDStrings.COPPER, 1);

        RECIPE_SOLDER.put(IDStrings.LEAD, 2);
        RECIPE_SOLDER.put(IDStrings.TIN, 1);

        RECIPE_BILLON.put(IDStrings.SILVER, 2);
        RECIPE_BILLON.put(IDStrings.COPPER, 1);

        RECIPE_BRASS.put(IDStrings.COPPER, 2);
        RECIPE_BRASS.put(IDStrings.ZINC, 1);

        RECIPE_ALU_BRASS.put(IDStrings.BRASS, 1);
        RECIPE_ALU_BRASS.put(IDStrings.ALUMINUM, 2);

        RECIPE_NICKEL.put(IDStrings.IRON, 2);
        RECIPE_NICKEL.put(IDStrings.COPPER, 1);

        RECIPE_COBALT.put(IDStrings.NICKEL, 1);
        RECIPE_COBALT.put(IDStrings.IRON, 1);
        RECIPE_COBALT.put(IDStrings.COPPER, 1);

        RECIPE_REINFORCED.put(IDStrings.DAMSTEEL, 1);
        RECIPE_REINFORCED.put(IDStrings.HARD, 1);
        RECIPE_REINFORCED.put(IDStrings.CORBRONZE, 1);
        RECIPE_REINFORCED.put(IDStrings.SOLDER, 1);
        RECIPE_REINFORCED.put(IDStrings.BILLON, 1);
        RECIPE_REINFORCED.put(IDStrings.GOLD, 1);

        ALLOY_LIST.add(new Alloy(IDStrings.STEEL, RECIPE_STEEL));
        ALLOY_LIST.add(new Alloy(IDStrings.DAMSTEEL, RECIPE_DAM_STEEL));
        ALLOY_LIST.add(new Alloy(IDStrings.DURALIUM, RECIPE_DURALIUM));
        ALLOY_LIST.add(new Alloy(IDStrings.BRONZE, RECIPE_BRONZE));
        ALLOY_LIST.add(new Alloy(IDStrings.ALUBRONZE, RECIPE_ALU_BRONZE));
        ALLOY_LIST.add(new Alloy(IDStrings.HARD, RECIPE_HARD_METAL));
        ALLOY_LIST.add(new Alloy(IDStrings.CORBRONZE, RECIPE_COR_BRONZE));
        ALLOY_LIST.add(new Alloy(IDStrings.SOLDER, RECIPE_SOLDER));
        ALLOY_LIST.add(new Alloy(IDStrings.BILLON, RECIPE_BILLON));
        ALLOY_LIST.add(new Alloy(IDStrings.BRASS, RECIPE_BRASS));
        ALLOY_LIST.add(new Alloy(IDStrings.ALUBRASS, RECIPE_ALU_BRASS));
        ALLOY_LIST.add(new Alloy(IDStrings.NICKEL, RECIPE_NICKEL));
        ALLOY_LIST.add(new Alloy(IDStrings.COBALT, RECIPE_COBALT));
        ALLOY_LIST.add(new Alloy(IDStrings.REINFORCED, RECIPE_REINFORCED));

    }

}
