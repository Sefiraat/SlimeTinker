package io.github.sefiraat.slimetinker.items.recipes;

import io.github.mooy1.infinitylib.items.StackUtils;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.CastParts;
import io.github.sefiraat.slimetinker.items.Casts;
import io.github.sefiraat.slimetinker.items.Liquids;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.materials.Liquid;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class RecipeManager {

    // Base
    public static final int AMOUNT_NUGGET = 1;

    // Calculated
    public static final int AMOUNT_INGOT = AMOUNT_NUGGET * 9;
    public static final int AMOUNT_BUCKET = AMOUNT_INGOT;
    public static final int AMOUNT_ORE = AMOUNT_INGOT * 2;
    public static final int AMOUNT_BLOCK = AMOUNT_INGOT * 9;
    public static final int AMOUNT_BOOT = AMOUNT_INGOT * 4;
    public static final int AMOUNT_LEG = AMOUNT_INGOT * 7;
    public static final int AMOUNT_CHEST = AMOUNT_INGOT * 8;
    public static final int AMOUNT_HEAD = AMOUNT_INGOT * 5;
    public static final int AMOUNT_DUST = AMOUNT_INGOT;
    public static final int AMOUNT_GEM = AMOUNT_INGOT;
    public static final int AMOUNT_CAST = AMOUNT_INGOT * 2;

    public static final int AMOUNT_AXEHEAD = AMOUNT_INGOT * 3;

    public static final String ID_IRON = "IRON";
    public static final String ID_GOLD = "GOLD";
    public static final String ID_COPPER = "COPPER";
    public static final String ID_SILVER = "SILVER";
    public static final String ID_TIN = "TIN";
    public static final String ID_MAGNESIUM = "MAGNESIUM";
    public static final String ID_ALUMINIUM = "ALUMINIUM";
    public static final String ID_LEAD = "LEAD";
    public static final String ID_ZINC = "ZINC";
    public static final String ID_COAL = "COAL";
    public static final String ID_STEEL = "STEEL";
    public static final String ID_DAM_STEEL = "DAMASCUS_STEEL";

    public final Map<String, MoltenResult> meltingRecipes = new HashMap<>();
    public final Map<String, CastResult> castingRecipes = new HashMap<>();

    // Dies (Items that makes casts and then burn away)
    protected static final Map<Liquid, ItemStack> MAP_DIE_NUGGET = new HashMap<>();
    protected static final Map<Liquid, ItemStack> MAP_DIE_INGOT = new HashMap<>();
    protected static final Map<Liquid, ItemStack> MAP_DIE_BLOCK = new HashMap<>();
    protected static final Map<Liquid, ItemStack> MAP_DIE_GEM = new HashMap<>();
    protected static final Map<Liquid, ItemStack> MAP_DIE_AXEHEAD = new HashMap<>();

    // Casts (Items that cast metals and remain)
    protected static final Map<Liquid, ItemStack> MAP_CAST_NUGGET = new HashMap<>();
    protected static final Map<Liquid, ItemStack> MAP_CAST_INGOT = new HashMap<>();
    protected static final Map<Liquid, ItemStack> MAP_CAST_BLOCK = new HashMap<>();
    protected static final Map<Liquid, ItemStack> MAP_CAST_GEM = new HashMap<>();
    protected static final Map<Liquid, ItemStack> MAP_CAST_AXEHEAD = new HashMap<>();

    static {

        // Casts
        MAP_DIE_NUGGET.put(Liquids.getById(ID_GOLD), Casts.CAST_NUGGET);
        MAP_DIE_INGOT.put(Liquids.getById(ID_GOLD), Casts.CAST_INGOT);
        MAP_DIE_BLOCK.put(Liquids.getById(ID_GOLD), Casts.CAST_BLOCK);
        MAP_DIE_GEM.put(Liquids.getById(ID_GOLD), Casts.CAST_GEM);
        MAP_DIE_AXEHEAD.put(Liquids.getById(ID_GOLD), Casts.CAST_AXEHEAD);

        // Nuggets
        MAP_CAST_NUGGET.put(Liquids.getById(ID_IRON), new ItemStack(Material.IRON_NUGGET));
        MAP_CAST_NUGGET.put(Liquids.getById(ID_GOLD), new ItemStack(Material.GOLD_NUGGET));
        MAP_CAST_NUGGET.put(Liquids.getById(ID_COPPER), Materials.NUGGET_CAST_COPPER);
        MAP_CAST_NUGGET.put(Liquids.getById(ID_SILVER), Materials.NUGGET_CAST_SILVER);
        MAP_CAST_NUGGET.put(Liquids.getById(ID_TIN), Materials.NUGGET_CAST_TIN);
        MAP_CAST_NUGGET.put(Liquids.getById(ID_MAGNESIUM), Materials.NUGGET_CAST_MAGNESIUM);
        MAP_CAST_NUGGET.put(Liquids.getById(ID_ALUMINIUM), Materials.NUGGET_CAST_ALUMINIUM);
        MAP_CAST_NUGGET.put(Liquids.getById(ID_LEAD), Materials.NUGGET_CAST_LEAD);
        MAP_CAST_NUGGET.put(Liquids.getById(ID_ZINC), Materials.NUGGET_CAST_ZINC);
        MAP_CAST_NUGGET.put(Liquids.getById(ID_COAL), Materials.NUGGET_CAST_COAL);
        MAP_CAST_NUGGET.put(Liquids.getById(ID_STEEL), Materials.NUGGET_CAST_STEEL);
        MAP_CAST_NUGGET.put(Liquids.getById(ID_DAM_STEEL), Materials.NUGGET_CAST_DAMASCUS_STEEL);

        // Ingots
        MAP_CAST_INGOT.put(Liquids.getById(ID_IRON), new ItemStack(Material.IRON_INGOT));
        MAP_CAST_INGOT.put(Liquids.getById(ID_GOLD), new ItemStack(Material.GOLD_INGOT));
        MAP_CAST_INGOT.put(Liquids.getById(ID_COPPER), SlimefunItems.COPPER_INGOT);
        MAP_CAST_INGOT.put(Liquids.getById(ID_SILVER), SlimefunItems.SILVER_INGOT);
        MAP_CAST_INGOT.put(Liquids.getById(ID_TIN), SlimefunItems.TIN_INGOT);
        MAP_CAST_INGOT.put(Liquids.getById(ID_MAGNESIUM), SlimefunItems.MAGNESIUM_INGOT);
        MAP_CAST_INGOT.put(Liquids.getById(ID_ALUMINIUM), SlimefunItems.ALUMINUM_INGOT);
        MAP_CAST_INGOT.put(Liquids.getById(ID_LEAD), SlimefunItems.LEAD_INGOT);
        MAP_CAST_INGOT.put(Liquids.getById(ID_ZINC), SlimefunItems.ZINC_INGOT);
        MAP_CAST_INGOT.put(Liquids.getById(ID_STEEL), SlimefunItems.STEEL_INGOT);
        MAP_CAST_INGOT.put(Liquids.getById(ID_DAM_STEEL), SlimefunItems.DAMASCUS_STEEL_INGOT);

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
        MAP_CAST_BLOCK.put(Liquids.getById(ID_COAL), new ItemStack(Material.COAL_BLOCK));
        MAP_CAST_BLOCK.put(Liquids.getById(ID_STEEL), Materials.BLOCK_CAST_STEEL);
        MAP_CAST_BLOCK.put(Liquids.getById(ID_DAM_STEEL), Materials.BLOCK_CAST_DAMASCUS_STEEL);

        // Gems
        MAP_CAST_GEM.put(Liquids.getById(ID_COAL), new ItemStack(Material.COAL));
        
        // Axe Heads

        MAP_CAST_AXEHEAD.put(Liquids.getById(ID_IRON), CastParts.AXE_HEAD.getStack(ID_IRON));
        MAP_CAST_AXEHEAD.put(Liquids.getById(ID_GOLD), CastParts.AXE_HEAD.getStack(ID_GOLD));
        MAP_CAST_AXEHEAD.put(Liquids.getById(ID_COPPER), CastParts.AXE_HEAD.getStack(ID_COPPER));
        MAP_CAST_AXEHEAD.put(Liquids.getById(ID_SILVER), CastParts.AXE_HEAD.getStack(ID_SILVER));
        MAP_CAST_AXEHEAD.put(Liquids.getById(ID_TIN), CastParts.AXE_HEAD.getStack(ID_TIN));
        MAP_CAST_AXEHEAD.put(Liquids.getById(ID_MAGNESIUM), CastParts.AXE_HEAD.getStack(ID_MAGNESIUM));
        MAP_CAST_AXEHEAD.put(Liquids.getById(ID_ALUMINIUM), CastParts.AXE_HEAD.getStack(ID_ALUMINIUM));
        MAP_CAST_AXEHEAD.put(Liquids.getById(ID_LEAD), CastParts.AXE_HEAD.getStack(ID_LEAD));
        MAP_CAST_AXEHEAD.put(Liquids.getById(ID_ZINC), CastParts.AXE_HEAD.getStack(ID_ZINC));
        MAP_CAST_AXEHEAD.put(Liquids.getById(ID_STEEL), CastParts.AXE_HEAD.getStack(ID_STEEL));
        MAP_CAST_AXEHEAD.put(Liquids.getById(ID_DAM_STEEL), CastParts.AXE_HEAD.getStack(ID_DAM_STEEL));

    }

    public RecipeManager() {
        
        // region Melting Recipes

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
        meltingRecipes.put(Materials.NUGGET_CAST_COPPER.getItemId(), new MoltenResult(Liquids.getById(ID_COPPER), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_COPPER.getItemId(), new MoltenResult(Liquids.getById(ID_COPPER), AMOUNT_BLOCK));

        // SILVER
        meltingRecipes.put(SlimefunItems.SILVER_DUST.getItemId(), new MoltenResult(Liquids.getById(ID_SILVER), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.SILVER_INGOT.getItemId(), new MoltenResult(Liquids.getById(ID_SILVER), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_SILVER.getItemId(), new MoltenResult(Liquids.getById(ID_SILVER), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_SILVER.getItemId(), new MoltenResult(Liquids.getById(ID_SILVER), AMOUNT_BLOCK));

        // TIN
        meltingRecipes.put(SlimefunItems.TIN_DUST.getItemId(), new MoltenResult(Liquids.getById(ID_TIN), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.TIN_INGOT.getItemId(), new MoltenResult(Liquids.getById(ID_TIN), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_TIN.getItemId(), new MoltenResult(Liquids.getById(ID_TIN), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_TIN.getItemId(), new MoltenResult(Liquids.getById(ID_TIN), AMOUNT_BLOCK));

        // MAGNESIUM
        meltingRecipes.put(SlimefunItems.MAGNESIUM_DUST.getItemId(), new MoltenResult(Liquids.getById(ID_MAGNESIUM), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.MAGNESIUM_INGOT.getItemId(), new MoltenResult(Liquids.getById(ID_MAGNESIUM), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_MAGNESIUM.getItemId(), new MoltenResult(Liquids.getById(ID_MAGNESIUM), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_MAGNESIUM.getItemId(), new MoltenResult(Liquids.getById(ID_MAGNESIUM), AMOUNT_BLOCK));

        // ALUMINIUM
        meltingRecipes.put(SlimefunItems.ALUMINUM_DUST.getItemId(), new MoltenResult(Liquids.getById(ID_ALUMINIUM), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.ALUMINUM_INGOT.getItemId(), new MoltenResult(Liquids.getById(ID_ALUMINIUM), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_ALUMINIUM.getItemId(), new MoltenResult(Liquids.getById(ID_ALUMINIUM), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_ALUMINIUM.getItemId(), new MoltenResult(Liquids.getById(ID_ALUMINIUM), AMOUNT_BLOCK));

        // LEAD
        meltingRecipes.put(SlimefunItems.LEAD_DUST.getItemId(), new MoltenResult(Liquids.getById(ID_LEAD), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.LEAD_INGOT.getItemId(), new MoltenResult(Liquids.getById(ID_LEAD), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_LEAD.getItemId(), new MoltenResult(Liquids.getById(ID_LEAD), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_LEAD.getItemId(), new MoltenResult(Liquids.getById(ID_LEAD), AMOUNT_BLOCK));

        // ZINC
        meltingRecipes.put(SlimefunItems.ZINC_DUST.getItemId(), new MoltenResult(Liquids.getById(ID_ZINC), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.ZINC_INGOT.getItemId(), new MoltenResult(Liquids.getById(ID_ZINC), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_ZINC.getItemId(), new MoltenResult(Liquids.getById(ID_ZINC), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_ZINC.getItemId(), new MoltenResult(Liquids.getById(ID_ZINC), AMOUNT_BLOCK));

        // COAL
        meltingRecipes.put(Material.COAL.toString(), new MoltenResult(Liquids.getById(ID_COAL), AMOUNT_GEM));
        meltingRecipes.put(Materials.NUGGET_CAST_COAL.getItemId(), new MoltenResult(Liquids.getById(ID_COAL), AMOUNT_NUGGET));
        meltingRecipes.put(Material.COAL_BLOCK.toString(), new MoltenResult(Liquids.getById(ID_COAL), AMOUNT_BLOCK));

        // STEEL
        meltingRecipes.put(SlimefunItems.STEEL_INGOT.getItemId(), new MoltenResult(Liquids.getById(ID_STEEL), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_STEEL.getItemId(), new MoltenResult(Liquids.getById(ID_STEEL), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_STEEL.getItemId(), new MoltenResult(Liquids.getById(ID_STEEL), AMOUNT_BLOCK));

        // DAMASCUS STEEL
        meltingRecipes.put(SlimefunItems.DAMASCUS_STEEL_INGOT.getItemId(), new MoltenResult(Liquids.getById(ID_DAM_STEEL), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_DAMASCUS_STEEL.getItemId(), new MoltenResult(Liquids.getById(ID_DAM_STEEL), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_DAMASCUS_STEEL.getItemId(), new MoltenResult(Liquids.getById(ID_DAM_STEEL), AMOUNT_BLOCK));

        // endregion

        // region Casting (Creating Casts)

        castingRecipes.put(Material.IRON_NUGGET.toString(), new CastResult(Material.IRON_NUGGET.toString(), AMOUNT_CAST, MAP_DIE_NUGGET, true));
        castingRecipes.put(Material.BRICK.toString(), new CastResult(Material.BRICK.toString(), AMOUNT_CAST, MAP_DIE_INGOT, true));
        castingRecipes.put(Material.STONE.toString(), new CastResult(Material.STONE.toString(), AMOUNT_CAST, MAP_DIE_BLOCK, true));
        castingRecipes.put(Material.DIAMOND.toString(), new CastResult(Material.DIAMOND.toString(), AMOUNT_CAST, MAP_DIE_GEM, true));
        castingRecipes.put(Casts.DIE_AXEHEAD.getItemId(), new CastResult(Casts.DIE_AXEHEAD.getItemId(), AMOUNT_CAST, MAP_DIE_AXEHEAD, true));

        // endregion

        // region Casting (Casting Items)

        castingRecipes.put(Casts.CAST_NUGGET.getItemId(), new CastResult(Casts.CAST_NUGGET.getItemId(), AMOUNT_NUGGET, MAP_CAST_NUGGET, false));
        castingRecipes.put(Casts.CAST_INGOT.getItemId(), new CastResult(Casts.CAST_INGOT.getItemId(), AMOUNT_INGOT, MAP_CAST_INGOT, false));
        castingRecipes.put(Casts.CAST_BLOCK.getItemId(), new CastResult(Casts.CAST_BLOCK.getItemId(), AMOUNT_BLOCK, MAP_CAST_BLOCK, false));
        castingRecipes.put(Casts.CAST_GEM.getItemId(), new CastResult(Casts.CAST_GEM.getItemId(), AMOUNT_GEM, MAP_CAST_GEM, false));
        castingRecipes.put(Casts.CAST_AXEHEAD.getItemId(), new CastResult(Casts.CAST_AXEHEAD.getItemId(), AMOUNT_AXEHEAD, MAP_CAST_AXEHEAD, false));

        // endregion
    }

    public boolean isMeltable(ItemStack itemStack) {
        return SlimeTinker.inst().getRecipeManager().meltingRecipes.containsKey(StackUtils.getIDorType(itemStack));
    }

    public MoltenResult getResult(ItemStack itemStack) {
        return meltingRecipes.get(StackUtils.getIDorType(itemStack));
    }

}
