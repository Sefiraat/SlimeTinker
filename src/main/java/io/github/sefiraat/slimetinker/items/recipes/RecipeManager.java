package io.github.sefiraat.slimetinker.items.recipes;

import io.github.mooy1.infinitylib.items.StackUtils;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.Casts;
import io.github.sefiraat.slimetinker.items.Liquids;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.machines.TinkersSmeltery;
import io.github.sefiraat.slimetinker.items.materials.Liquid;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class RecipeManager {

    // Base
    public static int AMOUNT_NUGGET = 1;

    // Calculated
    public static int AMOUNT_INGOT = AMOUNT_NUGGET * 9;
    public static int AMOUNT_BUCKET = AMOUNT_INGOT;
    public static int AMOUNT_ORE = AMOUNT_INGOT * 2;
    public static int AMOUNT_BLOCK = AMOUNT_INGOT * 9;
    public static int AMOUNT_BOOT = AMOUNT_INGOT * 4;
    public static int AMOUNT_LEG = AMOUNT_INGOT * 7;
    public static int AMOUNT_CHEST = AMOUNT_INGOT * 8;
    public static int AMOUNT_HEAD = AMOUNT_INGOT * 5;
    public static int AMOUNT_DUST = AMOUNT_INGOT;
    public static int AMOUNT_CAST = AMOUNT_INGOT * 2;

    public static int AXE_HEAD_AMOUNT = AMOUNT_INGOT * 3;

    public static String ID_IRON = "IRON";
    public static String ID_GOLD = "GOLD";
    public static String ID_COPPER = "COPPER";
    public static String ID_SILVER = "SILVER";
    public static String ID_TIN = "TIN";
    public static String ID_MAGNESIUM = "MAGNESIUM";
    public static String ID_ALUMINIUM = "ALUMINIUM";
    public static String ID_LEAD = "LEAD";
    public static String ID_ZINC = "ZINC";

    public Map<String, MoltenResult> meltingRecipes = new HashMap<>();
    public Map<String, CastResult> castingRecipes = new HashMap<>();


    // Dies (Items that makes casts and then burn away)
    public static Map<Liquid, ItemStack> MAP_DIE_BLOCK = new HashMap<>();

    // Casts (Items that cast metals and remain)
    public static Map<Liquid, ItemStack> MAP_CAST_BLOCK = new HashMap<>();



    static {

        // Casts
        MAP_DIE_BLOCK.put(Liquids.getById(ID_GOLD), Casts.CAST_BLOCK);

        // Blocks
        MAP_CAST_BLOCK.put(Liquids.getById(ID_IRON), new ItemStack(Material.IRON_BLOCK));
        MAP_CAST_BLOCK.put(Liquids.getById(ID_GOLD), new ItemStack(Material.GOLD_BLOCK));
        MAP_CAST_BLOCK.put(Liquids.getById(ID_COPPER), Materials.BLOCK_CAST_COPPER);
        MAP_CAST_BLOCK.put(Liquids.getById(ID_SILVER), Materials.BLOCK_CAST_SILVER);
        MAP_CAST_BLOCK.put(Liquids.getById(ID_TIN), Materials.BLOCK_CAST_TIN);
        MAP_CAST_BLOCK.put(Liquids.getById(ID_MAGNESIUM), Materials.BLOCK_CAST_MAGNESIUM);
        MAP_CAST_BLOCK.put(Liquids.getById(ID_ALUMINIUM), Materials.BLOCK_CAST_ALUMINIUM);
        MAP_CAST_BLOCK.put(Liquids.getById(ID_LEAD), Materials.BLOCK_CAST_LEAD);
        MAP_CAST_BLOCK.put(Liquids.getById(ID_ZINC), Materials.BLOCK_CAST_ZINC);
    }

    public RecipeManager() {
        // region Melting

        // IRON
        meltingRecipes.put(Material.IRON_NUGGET.toString(), new MoltenResult(Liquids.getById(ID_IRON), AMOUNT_NUGGET));
        meltingRecipes.put(Material.IRON_INGOT.toString(), new MoltenResult(Liquids.getById(ID_IRON), AMOUNT_INGOT));
        meltingRecipes.put(Material.IRON_ORE.toString(), new MoltenResult(Liquids.getById(ID_IRON), AMOUNT_ORE));
        meltingRecipes.put(Material.IRON_BLOCK.toString(), new MoltenResult(Liquids.getById(ID_IRON), AMOUNT_BLOCK));
        meltingRecipes.put(Material.IRON_BOOTS.toString(), new MoltenResult(Liquids.getById(ID_IRON), AMOUNT_BOOT));
        meltingRecipes.put(Material.IRON_LEGGINGS.toString(), new MoltenResult(Liquids.getById(ID_IRON), AMOUNT_LEG));
        meltingRecipes.put(Material.IRON_CHESTPLATE.toString(), new MoltenResult(Liquids.getById(ID_IRON), AMOUNT_CHEST));
        meltingRecipes.put(Material.IRON_HELMET.toString(), new MoltenResult(Liquids.getById(ID_IRON), AMOUNT_HEAD));
        meltingRecipes.put(SlimefunItems.IRON_DUST.getItemId(), new MoltenResult(Liquids.getById(ID_IRON), AMOUNT_DUST));

        // GOLD
        meltingRecipes.put(Material.GOLD_NUGGET.toString(), new MoltenResult(Liquids.getById(ID_GOLD), AMOUNT_NUGGET));
        meltingRecipes.put(Material.GOLD_INGOT.toString(), new MoltenResult(Liquids.getById(ID_GOLD), AMOUNT_INGOT));
        meltingRecipes.put(Material.GOLD_ORE.toString(), new MoltenResult(Liquids.getById(ID_GOLD), AMOUNT_ORE));
        meltingRecipes.put(Material.GOLD_BLOCK.toString(), new MoltenResult(Liquids.getById(ID_GOLD), AMOUNT_BLOCK));
        meltingRecipes.put(Material.GOLDEN_BOOTS.toString(), new MoltenResult(Liquids.getById(ID_GOLD), AMOUNT_BOOT));
        meltingRecipes.put(Material.GOLDEN_LEGGINGS.toString(), new MoltenResult(Liquids.getById(ID_GOLD), AMOUNT_LEG));
        meltingRecipes.put(Material.GOLDEN_CHESTPLATE.toString(), new MoltenResult(Liquids.getById(ID_GOLD), AMOUNT_CHEST));
        meltingRecipes.put(Material.GOLDEN_HELMET.toString(), new MoltenResult(Liquids.getById(ID_GOLD), AMOUNT_HEAD));
        meltingRecipes.put(SlimefunItems.GOLD_DUST.getItemId(), new MoltenResult(Liquids.getById(ID_GOLD), AMOUNT_DUST));

        // COPPER
        meltingRecipes.put(SlimefunItems.COPPER_DUST.getItemId(), new MoltenResult(Liquids.getById(ID_COPPER), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.COPPER_INGOT.getItemId(), new MoltenResult(Liquids.getById(ID_COPPER), AMOUNT_INGOT));
        meltingRecipes.put(Materials.BLOCK_CAST_COPPER.getItemId(), new MoltenResult(Liquids.getById(ID_COPPER), AMOUNT_BLOCK));

        // SILVER
        meltingRecipes.put(SlimefunItems.SILVER_DUST.getItemId(), new MoltenResult(Liquids.getById(ID_SILVER), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.SILVER_INGOT.getItemId(), new MoltenResult(Liquids.getById(ID_SILVER), AMOUNT_INGOT));
        meltingRecipes.put(Materials.BLOCK_CAST_SILVER.getItemId(), new MoltenResult(Liquids.getById(ID_SILVER), AMOUNT_BLOCK));

        // TIN
        meltingRecipes.put(SlimefunItems.TIN_DUST.getItemId(), new MoltenResult(Liquids.getById(ID_TIN), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.TIN_INGOT.getItemId(), new MoltenResult(Liquids.getById(ID_TIN), AMOUNT_INGOT));
        meltingRecipes.put(Materials.BLOCK_CAST_TIN.getItemId(), new MoltenResult(Liquids.getById(ID_TIN), AMOUNT_BLOCK));

        // MAGNESIUM
        meltingRecipes.put(SlimefunItems.MAGNESIUM_DUST.getItemId(), new MoltenResult(Liquids.getById(ID_MAGNESIUM), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.MAGNESIUM_INGOT.getItemId(), new MoltenResult(Liquids.getById(ID_MAGNESIUM), AMOUNT_INGOT));
        meltingRecipes.put(Materials.BLOCK_CAST_MAGNESIUM.getItemId(), new MoltenResult(Liquids.getById(ID_MAGNESIUM), AMOUNT_BLOCK));

        // ALUMINIUM
        meltingRecipes.put(SlimefunItems.ALUMINUM_DUST.getItemId(), new MoltenResult(Liquids.getById(ID_ALUMINIUM), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.MAGNESIUM_INGOT.getItemId(), new MoltenResult(Liquids.getById(ID_ALUMINIUM), AMOUNT_INGOT));
        meltingRecipes.put(Materials.BLOCK_CAST_ALUMINIUM.getItemId(), new MoltenResult(Liquids.getById(ID_ALUMINIUM), AMOUNT_BLOCK));

        // LEAD
        meltingRecipes.put(SlimefunItems.LEAD_DUST.getItemId(), new MoltenResult(Liquids.getById(ID_LEAD), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.LEAD_INGOT.getItemId(), new MoltenResult(Liquids.getById(ID_LEAD), AMOUNT_INGOT));
        meltingRecipes.put(Materials.BLOCK_CAST_LEAD.getItemId(), new MoltenResult(Liquids.getById(ID_LEAD), AMOUNT_BLOCK));

        // ZINC
        meltingRecipes.put(SlimefunItems.ZINC_DUST.getItemId(), new MoltenResult(Liquids.getById(ID_ZINC), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.ZINC_INGOT.getItemId(), new MoltenResult(Liquids.getById(ID_ZINC), AMOUNT_INGOT));
        meltingRecipes.put(Materials.BLOCK_CAST_ZINC.getItemId(), new MoltenResult(Liquids.getById(ID_ZINC), AMOUNT_BLOCK));

        // endregion

        // region Casting

        castingRecipes.put(Material.STONE.toString(), new CastResult(Material.STONE.toString(), AMOUNT_CAST, MAP_DIE_BLOCK, true));
        castingRecipes.put(Casts.CAST_BLOCK.getItemId(), new CastResult(Casts.CAST_BLOCK.getItemId(), AMOUNT_BLOCK, MAP_CAST_BLOCK, false));

        // endregion
    }

    public boolean isMeltable(ItemStack itemStack) {
        return SlimeTinker.inst().getRecipeManager().meltingRecipes.containsKey(StackUtils.getIDorType(itemStack));
    }

    public MoltenResult getResult(ItemStack itemStack) {
        return meltingRecipes.get(StackUtils.getIDorType(itemStack));
    }

}
