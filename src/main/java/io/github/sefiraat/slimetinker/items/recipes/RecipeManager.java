package io.github.sefiraat.slimetinker.items.recipes;

import io.github.mooy1.infinitylib.items.StackUtils;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.Casts;
import io.github.sefiraat.slimetinker.items.ComponentMaterials;
import io.github.sefiraat.slimetinker.items.Dies;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.Parts;
import io.github.sefiraat.slimetinker.items.materials.ComponentMaterial;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_ALUBRASS;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_ALUBRONZE;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_ALUMINUM;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_AXE;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_BILLON;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_BRASS;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_BRONZE;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_COAL;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_COBALT;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_COPPER;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_CORBRONZE;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_DAMSTEEL;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_DURALIUM;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_GOLD;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_HARD;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_HEAD;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_HOE;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_IRON;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_LEAD;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_MAGNESIUM;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_NICKEL;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_PICKAXE;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_REINFORCED;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_REPAIR;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_ROD;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_SHOVEL;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_SILVER;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_SOLDER;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_STEEL;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_SWORD;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_TIN;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ID_ZINC;

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
    public static final int AMOUNT_KIT = AMOUNT_INGOT * 3;

    public static final int AMOUNT_SHOVELHEAD = AMOUNT_INGOT;
    public static final int AMOUNT_PICKAXEHEAD = AMOUNT_INGOT * 3;
    public static final int AMOUNT_AXEHEAD = AMOUNT_INGOT * 3;
    public static final int AMOUNT_HOEHEAD = AMOUNT_INGOT * 2;
    public static final int AMOUNT_SWORDBLADE = AMOUNT_INGOT * 2;
    public static final int AMOUNT_TOOLROD = AMOUNT_INGOT;

    public final Map<String, MoltenResult> meltingRecipes = new HashMap<>();
    public final Map<String, CastResult> castingRecipes = new HashMap<>();

    // Dies (Items that makes casts and then burn away)
    protected static final Map<ComponentMaterial, ItemStack> MAP_DIE_NUGGET = new HashMap<>();
    protected static final Map<ComponentMaterial, ItemStack> MAP_DIE_INGOT = new HashMap<>();
    protected static final Map<ComponentMaterial, ItemStack> MAP_DIE_BLOCK = new HashMap<>();
    protected static final Map<ComponentMaterial, ItemStack> MAP_DIE_GEM = new HashMap<>();
    protected static final Map<ComponentMaterial, ItemStack> MAP_DIE_SHOVELHEAD = new HashMap<>();
    protected static final Map<ComponentMaterial, ItemStack> MAP_DIE_PICKAXEHEAD = new HashMap<>();
    protected static final Map<ComponentMaterial, ItemStack> MAP_DIE_AXEHEAD = new HashMap<>();
    protected static final Map<ComponentMaterial, ItemStack> MAP_DIE_HOEHEAD = new HashMap<>();
    protected static final Map<ComponentMaterial, ItemStack> MAP_DIE_SWORDBLADE = new HashMap<>();
    protected static final Map<ComponentMaterial, ItemStack> MAP_DIE_TOOLROD = new HashMap<>();
    protected static final Map<ComponentMaterial, ItemStack> MAP_DIE_REPAIRKIT = new HashMap<>();

    // Casts (Items that cast metals and remain)
    protected static final Map<ComponentMaterial, ItemStack> MAP_CAST_NUGGET = new HashMap<>();
    protected static final Map<ComponentMaterial, ItemStack> MAP_CAST_INGOT = new HashMap<>();
    protected static final Map<ComponentMaterial, ItemStack> MAP_CAST_BLOCK = new HashMap<>();
    protected static final Map<ComponentMaterial, ItemStack> MAP_CAST_GEM = new HashMap<>();
    protected static final Map<ComponentMaterial, ItemStack> MAP_CAST_SHOVELHEAD = new HashMap<>();
    protected static final Map<ComponentMaterial, ItemStack> MAP_CAST_PICKAXEHEAD = new HashMap<>();
    protected static final Map<ComponentMaterial, ItemStack> MAP_CAST_AXEHEAD = new HashMap<>();
    protected static final Map<ComponentMaterial, ItemStack> MAP_CAST_HOEHEAD = new HashMap<>();
    protected static final Map<ComponentMaterial, ItemStack> MAP_CAST_SWORDBLADE = new HashMap<>();
    protected static final Map<ComponentMaterial, ItemStack> MAP_CAST_TOOLROD = new HashMap<>();
    protected static final Map<ComponentMaterial, ItemStack> MAP_CAST_REPAIRKIT = new HashMap<>();

    static {

        // Casts
        MAP_DIE_NUGGET.put(ComponentMaterials.getById(ID_GOLD), Casts.CAST_NUGGET);
        MAP_DIE_INGOT.put(ComponentMaterials.getById(ID_GOLD), Casts.CAST_INGOT);
        MAP_DIE_BLOCK.put(ComponentMaterials.getById(ID_GOLD), Casts.CAST_BLOCK);
        MAP_DIE_GEM.put(ComponentMaterials.getById(ID_GOLD), Casts.CAST_GEM);
        MAP_DIE_REPAIRKIT.put(ComponentMaterials.getById(ID_GOLD), Casts.CAST_REPAIRKIT);
        MAP_DIE_SHOVELHEAD.put(ComponentMaterials.getById(ID_BRASS), Casts.CAST_SHOVELHEAD);
        MAP_DIE_PICKAXEHEAD.put(ComponentMaterials.getById(ID_BRASS), Casts.CAST_PICKAXEHEAD);
        MAP_DIE_AXEHEAD.put(ComponentMaterials.getById(ID_BRASS), Casts.CAST_AXEHEAD);
        MAP_DIE_HOEHEAD.put(ComponentMaterials.getById(ID_BRASS), Casts.CAST_HOEHEAD);
        MAP_DIE_SWORDBLADE.put(ComponentMaterials.getById(ID_BRASS), Casts.CAST_SWORDBLADE);
        MAP_DIE_TOOLROD.put(ComponentMaterials.getById(ID_BRASS), Casts.CAST_TOOLROD);

        // Nuggets
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_IRON), new ItemStack(Material.IRON_NUGGET));
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_GOLD), new ItemStack(Material.GOLD_NUGGET));
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_COPPER), Materials.NUGGET_CAST_COPPER);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_SILVER), Materials.NUGGET_CAST_SILVER);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_TIN), Materials.NUGGET_CAST_TIN);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_MAGNESIUM), Materials.NUGGET_CAST_MAGNESIUM);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_ALUMINUM), Materials.NUGGET_CAST_ALUMINUM);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_LEAD), Materials.NUGGET_CAST_LEAD);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_ZINC), Materials.NUGGET_CAST_ZINC);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_COAL), Materials.NUGGET_CAST_COAL);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_STEEL), Materials.NUGGET_CAST_STEEL);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_DAMSTEEL), Materials.NUGGET_CAST_DAMASCUS_STEEL);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_DURALIUM), Materials.NUGGET_CAST_DURALIUM);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_BRONZE), Materials.NUGGET_CAST_BRONZE);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_ALUBRONZE), Materials.NUGGET_CAST_ALU_BRONZE);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_HARD), Materials.NUGGET_CAST_HARD_METAL);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_CORBRONZE), Materials.NUGGET_CAST_COR_BRONZE);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_SOLDER), Materials.NUGGET_CAST_SOLDER);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_BILLON), Materials.NUGGET_CAST_BILLON);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_BRASS), Materials.NUGGET_CAST_BRASS);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_ALUBRASS), Materials.NUGGET_CAST_ALU_BRASS);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_NICKEL), Materials.NUGGET_CAST_NICKEL);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_COBALT), Materials.NUGGET_CAST_COBALT);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ID_REINFORCED), Materials.NUGGET_CAST_REINFORCED);

        // Ingots
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_IRON), new ItemStack(Material.IRON_INGOT));
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_GOLD), new ItemStack(Material.GOLD_INGOT));
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_COPPER), SlimefunItems.COPPER_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_SILVER), SlimefunItems.SILVER_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_TIN), SlimefunItems.TIN_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_MAGNESIUM), SlimefunItems.MAGNESIUM_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_ALUMINUM), SlimefunItems.ALUMINUM_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_LEAD), SlimefunItems.LEAD_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_ZINC), SlimefunItems.ZINC_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_STEEL), SlimefunItems.STEEL_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_DAMSTEEL), SlimefunItems.DAMASCUS_STEEL_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_DURALIUM), SlimefunItems.DURALUMIN_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_BRONZE), SlimefunItems.BRONZE_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_ALUBRONZE), SlimefunItems.ALUMINUM_BRONZE_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_HARD), SlimefunItems.HARDENED_METAL_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_CORBRONZE), SlimefunItems.CORINTHIAN_BRONZE_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_SOLDER), SlimefunItems.SOLDER_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_BILLON), SlimefunItems.BILLON_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_BRASS), SlimefunItems.BRASS_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_ALUBRASS), SlimefunItems.ALUMINUM_BRASS_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_NICKEL), SlimefunItems.NICKEL_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_COBALT), SlimefunItems.COBALT_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ID_REINFORCED), SlimefunItems.REINFORCED_ALLOY_INGOT);

        // Blocks
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_IRON), new ItemStack(Material.IRON_BLOCK));
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_GOLD), new ItemStack(Material.GOLD_BLOCK));
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_COPPER), Materials.BLOCK_CAST_COPPER);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_SILVER), Materials.BLOCK_CAST_SILVER);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_TIN), Materials.BLOCK_CAST_TIN);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_MAGNESIUM), Materials.BLOCK_CAST_MAGNESIUM);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_ALUMINUM), Materials.BLOCK_CAST_ALUMINUM);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_LEAD), Materials.BLOCK_CAST_LEAD);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_ZINC), Materials.BLOCK_CAST_ZINC);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_COAL), new ItemStack(Material.COAL_BLOCK));
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_STEEL), Materials.BLOCK_CAST_STEEL);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_DAMSTEEL), Materials.BLOCK_CAST_DAMASCUS_STEEL);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_DURALIUM), Materials.BLOCK_CAST_DURALIUM);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_BRONZE), Materials.BLOCK_CAST_BRONZE);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_ALUBRONZE), Materials.BLOCK_CAST_ALU_BRONZE);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_HARD), Materials.BLOCK_CAST_HARD_METAL);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_CORBRONZE), Materials.BLOCK_CAST_COR_BRONZE);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_SOLDER), Materials.BLOCK_CAST_SOLDER);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_BILLON), Materials.BLOCK_CAST_BILLON);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_BRASS), Materials.BLOCK_CAST_BRASS);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_ALUBRASS), Materials.BLOCK_CAST_ALU_BRASS);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_NICKEL), Materials.BLOCK_CAST_NICKEL);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_COBALT), Materials.BLOCK_CAST_COBALT);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ID_REINFORCED), Materials.BLOCK_CAST_REINFORCED);

        // Gems
        MAP_CAST_GEM.put(ComponentMaterials.getById(ID_COAL), new ItemStack(Material.COAL));
        
        // Repair Kits
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_IRON), Parts.REPAIR_KIT.getStack(ID_IRON, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_GOLD), Parts.REPAIR_KIT.getStack(ID_GOLD, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_COPPER), Parts.REPAIR_KIT.getStack(ID_COPPER, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_SILVER), Parts.REPAIR_KIT.getStack(ID_SILVER, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_TIN), Parts.REPAIR_KIT.getStack(ID_TIN, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_MAGNESIUM), Parts.REPAIR_KIT.getStack(ID_MAGNESIUM, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_ALUMINUM), Parts.REPAIR_KIT.getStack(ID_ALUMINUM, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_LEAD), Parts.REPAIR_KIT.getStack(ID_LEAD, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_ZINC), Parts.REPAIR_KIT.getStack(ID_ZINC, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_COAL), Parts.REPAIR_KIT.getStack(ID_COAL, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_STEEL), Parts.REPAIR_KIT.getStack(ID_STEEL, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_DAMSTEEL), Parts.REPAIR_KIT.getStack(ID_DAMSTEEL, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_DURALIUM), Parts.REPAIR_KIT.getStack(ID_DURALIUM, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_BRONZE), Parts.REPAIR_KIT.getStack(ID_BRONZE, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_ALUBRONZE), Parts.REPAIR_KIT.getStack(ID_ALUBRONZE, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_HARD), Parts.REPAIR_KIT.getStack(ID_HARD, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_CORBRONZE), Parts.REPAIR_KIT.getStack(ID_CORBRONZE, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_SOLDER), Parts.REPAIR_KIT.getStack(ID_SOLDER, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_BILLON), Parts.REPAIR_KIT.getStack(ID_BILLON, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_BRASS), Parts.REPAIR_KIT.getStack(ID_BRASS, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_ALUBRASS), Parts.REPAIR_KIT.getStack(ID_ALUBRASS, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_NICKEL), Parts.REPAIR_KIT.getStack(ID_NICKEL, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_COBALT), Parts.REPAIR_KIT.getStack(ID_COBALT, ID_REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ID_REINFORCED), Parts.REPAIR_KIT.getStack(ID_REINFORCED, ID_REPAIR));
        
        // Shovel Heads
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_IRON), Parts.SHOVEL_HEAD.getStack(ID_IRON, ID_HEAD, ID_SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_GOLD), Parts.SHOVEL_HEAD.getStack(ID_GOLD, ID_HEAD, ID_SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_COPPER), Parts.SHOVEL_HEAD.getStack(ID_COPPER, ID_HEAD, ID_SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_SILVER), Parts.SHOVEL_HEAD.getStack(ID_SILVER, ID_HEAD, ID_SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_TIN), Parts.SHOVEL_HEAD.getStack(ID_TIN, ID_HEAD, ID_SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_MAGNESIUM), Parts.SHOVEL_HEAD.getStack(ID_MAGNESIUM, ID_HEAD, ID_SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_ALUMINUM), Parts.SHOVEL_HEAD.getStack(ID_ALUMINUM, ID_HEAD, ID_SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_LEAD), Parts.SHOVEL_HEAD.getStack(ID_LEAD, ID_HEAD, ID_SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_ZINC), Parts.SHOVEL_HEAD.getStack(ID_ZINC, ID_HEAD, ID_SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_STEEL), Parts.SHOVEL_HEAD.getStack(ID_STEEL, ID_HEAD, ID_SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_DAMSTEEL), Parts.SHOVEL_HEAD.getStack(ID_DAMSTEEL, ID_HEAD, ID_SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_DURALIUM), Parts.SHOVEL_HEAD.getStack(ID_DURALIUM, ID_HEAD, ID_SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_BRONZE), Parts.SHOVEL_HEAD.getStack(ID_BRONZE, ID_HEAD, ID_SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_ALUBRONZE), Parts.SHOVEL_HEAD.getStack(ID_ALUBRONZE, ID_HEAD, ID_SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_HARD), Parts.SHOVEL_HEAD.getStack(ID_HARD, ID_HEAD, ID_SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_CORBRONZE), Parts.SHOVEL_HEAD.getStack(ID_CORBRONZE, ID_HEAD, ID_SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_SOLDER), Parts.SHOVEL_HEAD.getStack(ID_SOLDER, ID_HEAD, ID_SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_BILLON), Parts.SHOVEL_HEAD.getStack(ID_BILLON, ID_HEAD, ID_SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_BRASS), Parts.SHOVEL_HEAD.getStack(ID_BRASS, ID_HEAD, ID_SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_ALUBRASS), Parts.SHOVEL_HEAD.getStack(ID_ALUBRASS, ID_HEAD, ID_SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_NICKEL), Parts.SHOVEL_HEAD.getStack(ID_NICKEL, ID_HEAD, ID_SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_COBALT), Parts.SHOVEL_HEAD.getStack(ID_COBALT, ID_HEAD, ID_SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ID_REINFORCED), Parts.SHOVEL_HEAD.getStack(ID_REINFORCED, ID_HEAD, ID_SHOVEL));

        // Pickaxe Heads
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_IRON), Parts.PICKAXE_HEAD.getStack(ID_IRON, ID_HEAD, ID_PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_GOLD), Parts.PICKAXE_HEAD.getStack(ID_GOLD, ID_HEAD, ID_PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_COPPER), Parts.PICKAXE_HEAD.getStack(ID_COPPER, ID_HEAD, ID_PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_SILVER), Parts.PICKAXE_HEAD.getStack(ID_SILVER, ID_HEAD, ID_PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_TIN), Parts.PICKAXE_HEAD.getStack(ID_TIN, ID_HEAD, ID_PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_MAGNESIUM), Parts.PICKAXE_HEAD.getStack(ID_MAGNESIUM, ID_HEAD, ID_PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_ALUMINUM), Parts.PICKAXE_HEAD.getStack(ID_ALUMINUM, ID_HEAD, ID_PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_LEAD), Parts.PICKAXE_HEAD.getStack(ID_LEAD, ID_HEAD, ID_PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_ZINC), Parts.PICKAXE_HEAD.getStack(ID_ZINC, ID_HEAD, ID_PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_STEEL), Parts.PICKAXE_HEAD.getStack(ID_STEEL, ID_HEAD, ID_PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_DAMSTEEL), Parts.PICKAXE_HEAD.getStack(ID_DAMSTEEL, ID_HEAD, ID_PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_DURALIUM), Parts.PICKAXE_HEAD.getStack(ID_DURALIUM, ID_HEAD, ID_PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_BRONZE), Parts.PICKAXE_HEAD.getStack(ID_BRONZE, ID_HEAD, ID_PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_ALUBRONZE), Parts.PICKAXE_HEAD.getStack(ID_ALUBRONZE, ID_HEAD, ID_PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_HARD), Parts.PICKAXE_HEAD.getStack(ID_HARD, ID_HEAD, ID_PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_CORBRONZE), Parts.PICKAXE_HEAD.getStack(ID_CORBRONZE, ID_HEAD, ID_PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_SOLDER), Parts.PICKAXE_HEAD.getStack(ID_SOLDER, ID_HEAD, ID_PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_BILLON), Parts.PICKAXE_HEAD.getStack(ID_BILLON, ID_HEAD, ID_PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_BRASS), Parts.PICKAXE_HEAD.getStack(ID_BRASS, ID_HEAD, ID_PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_ALUBRASS), Parts.PICKAXE_HEAD.getStack(ID_ALUBRASS, ID_HEAD, ID_PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_NICKEL), Parts.PICKAXE_HEAD.getStack(ID_NICKEL, ID_HEAD, ID_PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_COBALT), Parts.PICKAXE_HEAD.getStack(ID_COBALT, ID_HEAD, ID_PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ID_REINFORCED), Parts.PICKAXE_HEAD.getStack(ID_REINFORCED, ID_HEAD, ID_PICKAXE));

        // Axe Heads
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_IRON), Parts.AXE_HEAD.getStack(ID_IRON, ID_HEAD, ID_AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_GOLD), Parts.AXE_HEAD.getStack(ID_GOLD, ID_HEAD, ID_AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_COPPER), Parts.AXE_HEAD.getStack(ID_COPPER, ID_HEAD, ID_AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_SILVER), Parts.AXE_HEAD.getStack(ID_SILVER, ID_HEAD, ID_AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_TIN), Parts.AXE_HEAD.getStack(ID_TIN, ID_HEAD, ID_AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_MAGNESIUM), Parts.AXE_HEAD.getStack(ID_MAGNESIUM, ID_HEAD, ID_AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_ALUMINUM), Parts.AXE_HEAD.getStack(ID_ALUMINUM, ID_HEAD, ID_AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_LEAD), Parts.AXE_HEAD.getStack(ID_LEAD, ID_HEAD, ID_AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_ZINC), Parts.AXE_HEAD.getStack(ID_ZINC, ID_HEAD, ID_AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_STEEL), Parts.AXE_HEAD.getStack(ID_STEEL, ID_HEAD, ID_AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_DAMSTEEL), Parts.AXE_HEAD.getStack(ID_DAMSTEEL, ID_HEAD, ID_AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_DURALIUM), Parts.AXE_HEAD.getStack(ID_DURALIUM, ID_HEAD, ID_AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_BRONZE), Parts.AXE_HEAD.getStack(ID_BRONZE, ID_HEAD, ID_AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_ALUBRONZE), Parts.AXE_HEAD.getStack(ID_ALUBRONZE, ID_HEAD, ID_AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_HARD), Parts.AXE_HEAD.getStack(ID_HARD, ID_HEAD, ID_AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_CORBRONZE), Parts.AXE_HEAD.getStack(ID_CORBRONZE, ID_HEAD, ID_AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_SOLDER), Parts.AXE_HEAD.getStack(ID_SOLDER, ID_HEAD, ID_AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_BILLON), Parts.AXE_HEAD.getStack(ID_BILLON, ID_HEAD, ID_AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_BRASS), Parts.AXE_HEAD.getStack(ID_BRASS, ID_HEAD, ID_AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_ALUBRASS), Parts.AXE_HEAD.getStack(ID_ALUBRASS, ID_HEAD, ID_AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_NICKEL), Parts.AXE_HEAD.getStack(ID_NICKEL, ID_HEAD, ID_AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_COBALT), Parts.AXE_HEAD.getStack(ID_COBALT, ID_HEAD, ID_AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ID_REINFORCED), Parts.AXE_HEAD.getStack(ID_REINFORCED, ID_HEAD, ID_AXE));

         // Hoe Heads
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_IRON), Parts.HOE_HEAD.getStack(ID_IRON, ID_HEAD, ID_HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_GOLD), Parts.HOE_HEAD.getStack(ID_GOLD, ID_HEAD, ID_HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_COPPER), Parts.HOE_HEAD.getStack(ID_COPPER, ID_HEAD, ID_HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_SILVER), Parts.HOE_HEAD.getStack(ID_SILVER, ID_HEAD, ID_HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_TIN), Parts.HOE_HEAD.getStack(ID_TIN, ID_HEAD, ID_HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_MAGNESIUM), Parts.HOE_HEAD.getStack(ID_MAGNESIUM, ID_HEAD, ID_HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_ALUMINUM), Parts.HOE_HEAD.getStack(ID_ALUMINUM, ID_HEAD, ID_HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_LEAD), Parts.HOE_HEAD.getStack(ID_LEAD, ID_HEAD, ID_HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_ZINC), Parts.HOE_HEAD.getStack(ID_ZINC, ID_HEAD, ID_HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_STEEL), Parts.HOE_HEAD.getStack(ID_STEEL, ID_HEAD, ID_HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_DAMSTEEL), Parts.HOE_HEAD.getStack(ID_DAMSTEEL, ID_HEAD, ID_HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_DURALIUM), Parts.HOE_HEAD.getStack(ID_DURALIUM, ID_HEAD, ID_HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_BRONZE), Parts.HOE_HEAD.getStack(ID_BRONZE, ID_HEAD, ID_HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_ALUBRONZE), Parts.HOE_HEAD.getStack(ID_ALUBRONZE, ID_HEAD, ID_HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_HARD), Parts.HOE_HEAD.getStack(ID_HARD, ID_HEAD, ID_HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_CORBRONZE), Parts.HOE_HEAD.getStack(ID_CORBRONZE, ID_HEAD, ID_HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_SOLDER), Parts.HOE_HEAD.getStack(ID_SOLDER, ID_HEAD, ID_HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_BILLON), Parts.HOE_HEAD.getStack(ID_BILLON, ID_HEAD, ID_HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_BRASS), Parts.HOE_HEAD.getStack(ID_BRASS, ID_HEAD, ID_HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_ALUBRASS), Parts.HOE_HEAD.getStack(ID_ALUBRASS, ID_HEAD, ID_HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_NICKEL), Parts.HOE_HEAD.getStack(ID_NICKEL, ID_HEAD, ID_HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_COBALT), Parts.HOE_HEAD.getStack(ID_COBALT, ID_HEAD, ID_HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ID_REINFORCED), Parts.HOE_HEAD.getStack(ID_REINFORCED, ID_HEAD, ID_HOE));

         // Sword Blades
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_IRON), Parts.SWORD_BLADE.getStack(ID_IRON, ID_HEAD, ID_SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_GOLD), Parts.SWORD_BLADE.getStack(ID_GOLD, ID_HEAD, ID_SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_COPPER), Parts.SWORD_BLADE.getStack(ID_COPPER, ID_HEAD, ID_SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_SILVER), Parts.SWORD_BLADE.getStack(ID_SILVER, ID_HEAD, ID_SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_TIN), Parts.SWORD_BLADE.getStack(ID_TIN, ID_HEAD, ID_SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_MAGNESIUM), Parts.SWORD_BLADE.getStack(ID_MAGNESIUM, ID_HEAD, ID_SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_ALUMINUM), Parts.SWORD_BLADE.getStack(ID_ALUMINUM, ID_HEAD, ID_SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_LEAD), Parts.SWORD_BLADE.getStack(ID_LEAD, ID_HEAD, ID_SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_ZINC), Parts.SWORD_BLADE.getStack(ID_ZINC, ID_HEAD, ID_SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_STEEL), Parts.SWORD_BLADE.getStack(ID_STEEL, ID_HEAD, ID_SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_DAMSTEEL), Parts.SWORD_BLADE.getStack(ID_DAMSTEEL, ID_HEAD, ID_SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_DURALIUM), Parts.SWORD_BLADE.getStack(ID_DURALIUM, ID_HEAD, ID_SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_BRONZE), Parts.SWORD_BLADE.getStack(ID_BRONZE, ID_HEAD, ID_SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_ALUBRONZE), Parts.SWORD_BLADE.getStack(ID_ALUBRONZE, ID_HEAD, ID_SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_HARD), Parts.SWORD_BLADE.getStack(ID_HARD, ID_HEAD, ID_SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_CORBRONZE), Parts.SWORD_BLADE.getStack(ID_CORBRONZE, ID_HEAD, ID_SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_SOLDER), Parts.SWORD_BLADE.getStack(ID_SOLDER, ID_HEAD, ID_SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_BILLON), Parts.SWORD_BLADE.getStack(ID_BILLON, ID_HEAD, ID_SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_BRASS), Parts.SWORD_BLADE.getStack(ID_BRASS, ID_HEAD, ID_SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_ALUBRASS), Parts.SWORD_BLADE.getStack(ID_ALUBRASS, ID_HEAD, ID_SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_NICKEL), Parts.SWORD_BLADE.getStack(ID_NICKEL, ID_HEAD, ID_SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_COBALT), Parts.SWORD_BLADE.getStack(ID_COBALT, ID_HEAD, ID_SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ID_REINFORCED), Parts.SWORD_BLADE.getStack(ID_REINFORCED, ID_HEAD, ID_SWORD));

        // Tool Rods
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_IRON), Parts.TOOL_ROD.getStack(ID_IRON, ID_ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_GOLD), Parts.TOOL_ROD.getStack(ID_GOLD, ID_ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_COPPER), Parts.TOOL_ROD.getStack(ID_COPPER, ID_ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_SILVER), Parts.TOOL_ROD.getStack(ID_SILVER, ID_ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_TIN), Parts.TOOL_ROD.getStack(ID_TIN, ID_ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_MAGNESIUM), Parts.TOOL_ROD.getStack(ID_MAGNESIUM, ID_ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_ALUMINUM), Parts.TOOL_ROD.getStack(ID_ALUMINUM, ID_ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_LEAD), Parts.TOOL_ROD.getStack(ID_LEAD, ID_ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_ZINC), Parts.TOOL_ROD.getStack(ID_ZINC, ID_ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_STEEL), Parts.TOOL_ROD.getStack(ID_STEEL, ID_ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_DAMSTEEL), Parts.TOOL_ROD.getStack(ID_DAMSTEEL, ID_ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_DURALIUM), Parts.TOOL_ROD.getStack(ID_DURALIUM, ID_ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_BRONZE), Parts.TOOL_ROD.getStack(ID_BRONZE, ID_ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_ALUBRONZE), Parts.TOOL_ROD.getStack(ID_ALUBRONZE, ID_ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_HARD), Parts.TOOL_ROD.getStack(ID_HARD, ID_ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_CORBRONZE), Parts.TOOL_ROD.getStack(ID_CORBRONZE, ID_ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_SOLDER), Parts.TOOL_ROD.getStack(ID_SOLDER, ID_ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_BILLON), Parts.TOOL_ROD.getStack(ID_BILLON, ID_ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_BRASS), Parts.TOOL_ROD.getStack(ID_BRASS, ID_ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_ALUBRASS), Parts.TOOL_ROD.getStack(ID_ALUBRASS, ID_ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_NICKEL), Parts.TOOL_ROD.getStack(ID_NICKEL, ID_ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_COBALT), Parts.TOOL_ROD.getStack(ID_COBALT, ID_ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ID_REINFORCED), Parts.TOOL_ROD.getStack(ID_REINFORCED, ID_ROD, null));

    }

    public RecipeManager() {
        
        // region Melting Recipes

        // IRON
        meltingRecipes.put(Material.IRON_NUGGET.toString(), new MoltenResult(ComponentMaterials.getById(ID_IRON), AMOUNT_NUGGET));
        meltingRecipes.put(Material.IRON_INGOT.toString(), new MoltenResult(ComponentMaterials.getById(ID_IRON), AMOUNT_INGOT));
        meltingRecipes.put(Material.IRON_ORE.toString(), new MoltenResult(ComponentMaterials.getById(ID_IRON), AMOUNT_ORE));
        meltingRecipes.put(Material.IRON_BLOCK.toString(), new MoltenResult(ComponentMaterials.getById(ID_IRON), AMOUNT_BLOCK));
        meltingRecipes.put(Material.IRON_BOOTS.toString(), new MoltenResult(ComponentMaterials.getById(ID_IRON), AMOUNT_BOOT));
        meltingRecipes.put(Material.IRON_LEGGINGS.toString(), new MoltenResult(ComponentMaterials.getById(ID_IRON), AMOUNT_LEG));
        meltingRecipes.put(Material.IRON_CHESTPLATE.toString(), new MoltenResult(ComponentMaterials.getById(ID_IRON), AMOUNT_CHEST));
        meltingRecipes.put(Material.IRON_HELMET.toString(), new MoltenResult(ComponentMaterials.getById(ID_IRON), AMOUNT_HEAD));
        meltingRecipes.put(SlimefunItems.IRON_DUST.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_IRON), AMOUNT_DUST));

        // GOLD
        meltingRecipes.put(Material.GOLD_NUGGET.toString(), new MoltenResult(ComponentMaterials.getById(ID_GOLD), AMOUNT_NUGGET));
        meltingRecipes.put(Material.GOLD_INGOT.toString(), new MoltenResult(ComponentMaterials.getById(ID_GOLD), AMOUNT_INGOT));
        meltingRecipes.put(Material.GOLD_ORE.toString(), new MoltenResult(ComponentMaterials.getById(ID_GOLD), AMOUNT_ORE));
        meltingRecipes.put(Material.GOLD_BLOCK.toString(), new MoltenResult(ComponentMaterials.getById(ID_GOLD), AMOUNT_BLOCK));
        meltingRecipes.put(Material.GOLDEN_BOOTS.toString(), new MoltenResult(ComponentMaterials.getById(ID_GOLD), AMOUNT_BOOT));
        meltingRecipes.put(Material.GOLDEN_LEGGINGS.toString(), new MoltenResult(ComponentMaterials.getById(ID_GOLD), AMOUNT_LEG));
        meltingRecipes.put(Material.GOLDEN_CHESTPLATE.toString(), new MoltenResult(ComponentMaterials.getById(ID_GOLD), AMOUNT_CHEST));
        meltingRecipes.put(Material.GOLDEN_HELMET.toString(), new MoltenResult(ComponentMaterials.getById(ID_GOLD), AMOUNT_HEAD));
        meltingRecipes.put(SlimefunItems.GOLD_DUST.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_GOLD), AMOUNT_DUST));

        // COPPER
        meltingRecipes.put(SlimefunItems.COPPER_DUST.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_COPPER), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.COPPER_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_COPPER), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_COPPER.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_COPPER), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_COPPER.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_COPPER), AMOUNT_BLOCK));

        // SILVER
        meltingRecipes.put(SlimefunItems.SILVER_DUST.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_SILVER), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.SILVER_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_SILVER), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_SILVER.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_SILVER), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_SILVER.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_SILVER), AMOUNT_BLOCK));

        // TIN
        meltingRecipes.put(SlimefunItems.TIN_DUST.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_TIN), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.TIN_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_TIN), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_TIN.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_TIN), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_TIN.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_TIN), AMOUNT_BLOCK));

        // MAGNESIUM
        meltingRecipes.put(SlimefunItems.MAGNESIUM_DUST.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_MAGNESIUM), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.MAGNESIUM_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_MAGNESIUM), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_MAGNESIUM.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_MAGNESIUM), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_MAGNESIUM.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_MAGNESIUM), AMOUNT_BLOCK));

        // ALUMINUM
        meltingRecipes.put(SlimefunItems.ALUMINUM_DUST.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_ALUMINUM), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.ALUMINUM_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_ALUMINUM), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_ALUMINUM.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_ALUMINUM), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_ALUMINUM.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_ALUMINUM), AMOUNT_BLOCK));

        // LEAD
        meltingRecipes.put(SlimefunItems.LEAD_DUST.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_LEAD), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.LEAD_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_LEAD), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_LEAD.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_LEAD), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_LEAD.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_LEAD), AMOUNT_BLOCK));

        // ZINC
        meltingRecipes.put(SlimefunItems.ZINC_DUST.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_ZINC), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.ZINC_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_ZINC), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_ZINC.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_ZINC), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_ZINC.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_ZINC), AMOUNT_BLOCK));

        // COAL
        meltingRecipes.put(Material.COAL.toString(), new MoltenResult(ComponentMaterials.getById(ID_COAL), AMOUNT_GEM));
        meltingRecipes.put(Materials.NUGGET_CAST_COAL.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_COAL), AMOUNT_NUGGET));
        meltingRecipes.put(Material.COAL_BLOCK.toString(), new MoltenResult(ComponentMaterials.getById(ID_COAL), AMOUNT_BLOCK));

        // STEEL
        meltingRecipes.put(SlimefunItems.STEEL_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_STEEL), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_STEEL.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_STEEL), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_STEEL.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_STEEL), AMOUNT_BLOCK));

        // DAMASCUS STEEL
        meltingRecipes.put(SlimefunItems.DAMASCUS_STEEL_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_DAMSTEEL), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_DAMASCUS_STEEL.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_DAMSTEEL), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_DAMASCUS_STEEL.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_DAMSTEEL), AMOUNT_BLOCK));

        // DURALIUM
        meltingRecipes.put(SlimefunItems.DURALUMIN_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_DURALIUM), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_DURALIUM.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_DURALIUM), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_DURALIUM.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_DURALIUM), AMOUNT_BLOCK));

        // BRONZE
        meltingRecipes.put(SlimefunItems.BRONZE_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_BRONZE), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_BRONZE.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_BRONZE), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_BRONZE.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_BRONZE), AMOUNT_BLOCK));

        // ALU_BRONZE
        meltingRecipes.put(SlimefunItems.ALUMINUM_BRONZE_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_ALUBRONZE), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_ALU_BRONZE.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_ALUBRONZE), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_ALU_BRONZE.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_ALUBRONZE), AMOUNT_BLOCK));

        // HARDENED METAL
        meltingRecipes.put(SlimefunItems.HARDENED_METAL_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_HARD), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_HARD_METAL.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_HARD), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_HARD_METAL.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_HARD), AMOUNT_BLOCK));

        // COR BRONZE
        meltingRecipes.put(SlimefunItems.CORINTHIAN_BRONZE_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_CORBRONZE), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_COR_BRONZE.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_CORBRONZE), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_COR_BRONZE.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_CORBRONZE), AMOUNT_BLOCK));

        // SOLDER
        meltingRecipes.put(SlimefunItems.SOLDER_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_SOLDER), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_SOLDER.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_SOLDER), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_SOLDER.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_SOLDER), AMOUNT_BLOCK));

        // BILLON
        meltingRecipes.put(SlimefunItems.BILLON_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_BILLON), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_BILLON.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_BILLON), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_BILLON.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_BILLON), AMOUNT_BLOCK));

        // BRASS
        meltingRecipes.put(SlimefunItems.BRASS_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_BRASS), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_BRASS.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_BRASS), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_BRASS.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_BRASS), AMOUNT_BLOCK));

        // ALU BRASS
        meltingRecipes.put(SlimefunItems.ALUMINUM_BRASS_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_ALUBRASS), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_ALU_BRASS.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_ALUBRASS), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_ALU_BRASS.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_ALUBRASS), AMOUNT_BLOCK));

        // NICKEL
        meltingRecipes.put(SlimefunItems.NICKEL_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_NICKEL), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_NICKEL.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_NICKEL), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_NICKEL.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_NICKEL), AMOUNT_BLOCK));

        // COBALT
        meltingRecipes.put(SlimefunItems.COBALT_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_COBALT), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_COBALT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_COBALT), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_COBALT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_COBALT), AMOUNT_BLOCK));

         // COBALT
        meltingRecipes.put(SlimefunItems.REINFORCED_ALLOY_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_REINFORCED), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_REINFORCED.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_REINFORCED), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_REINFORCED.getItemId(), new MoltenResult(ComponentMaterials.getById(ID_REINFORCED), AMOUNT_BLOCK));

        // endregion

        // region Casting (Creating Casts)

        castingRecipes.put(Material.IRON_NUGGET.toString(), new CastResult(Material.IRON_NUGGET.toString(), AMOUNT_CAST, MAP_DIE_NUGGET, true));
        castingRecipes.put(Material.BRICK.toString(), new CastResult(Material.BRICK.toString(), AMOUNT_CAST, MAP_DIE_INGOT, true));
        castingRecipes.put(Material.STONE.toString(), new CastResult(Material.STONE.toString(), AMOUNT_CAST, MAP_DIE_BLOCK, true));
        castingRecipes.put(Material.DIAMOND.toString(), new CastResult(Material.DIAMOND.toString(), AMOUNT_CAST, MAP_DIE_GEM, true));
        castingRecipes.put(Dies.DIE_REPAIR_KIT.getItemId(), new CastResult(Dies.DIE_REPAIR_KIT.getItemId(), AMOUNT_CAST, MAP_DIE_REPAIRKIT, true));
        castingRecipes.put(Dies.DIE_SHOVEL_HEAD.getItemId(), new CastResult(Dies.DIE_SHOVEL_HEAD.getItemId(), AMOUNT_CAST, MAP_DIE_SHOVELHEAD, true));
        castingRecipes.put(Dies.DIE_PICKAXE_HEAD.getItemId(), new CastResult(Dies.DIE_PICKAXE_HEAD.getItemId(), AMOUNT_CAST, MAP_DIE_PICKAXEHEAD, true));
        castingRecipes.put(Dies.DIE_AXE_HEAD.getItemId(), new CastResult(Dies.DIE_AXE_HEAD.getItemId(), AMOUNT_CAST, MAP_DIE_AXEHEAD, true));
        castingRecipes.put(Dies.DIE_HOE_HEAD.getItemId(), new CastResult(Dies.DIE_HOE_HEAD.getItemId(), AMOUNT_CAST, MAP_DIE_HOEHEAD, true));
        castingRecipes.put(Dies.DIE_SWORD_BLADE.getItemId(), new CastResult(Dies.DIE_SWORD_BLADE.getItemId(), AMOUNT_CAST, MAP_DIE_SWORDBLADE, true));
        castingRecipes.put(Dies.DIE_TOOL_ROD.getItemId(), new CastResult(Dies.DIE_TOOL_ROD.getItemId(), AMOUNT_CAST, MAP_DIE_TOOLROD, true));

        // endregion

        // region Casting (Casting Items)

        castingRecipes.put(Casts.CAST_NUGGET.getItemId(), new CastResult(Casts.CAST_NUGGET.getItemId(), AMOUNT_NUGGET, MAP_CAST_NUGGET, false));
        castingRecipes.put(Casts.CAST_INGOT.getItemId(), new CastResult(Casts.CAST_INGOT.getItemId(), AMOUNT_INGOT, MAP_CAST_INGOT, false));
        castingRecipes.put(Casts.CAST_BLOCK.getItemId(), new CastResult(Casts.CAST_BLOCK.getItemId(), AMOUNT_BLOCK, MAP_CAST_BLOCK, false));
        castingRecipes.put(Casts.CAST_GEM.getItemId(), new CastResult(Casts.CAST_GEM.getItemId(), AMOUNT_GEM, MAP_CAST_GEM, false));
        castingRecipes.put(Casts.CAST_REPAIRKIT.getItemId(), new CastResult(Casts.CAST_REPAIRKIT.getItemId(), AMOUNT_KIT, MAP_CAST_REPAIRKIT, false));
        castingRecipes.put(Casts.CAST_SHOVELHEAD.getItemId(), new CastResult(Casts.CAST_SHOVELHEAD.getItemId(), AMOUNT_SHOVELHEAD, MAP_CAST_SHOVELHEAD, false));
        castingRecipes.put(Casts.CAST_PICKAXEHEAD.getItemId(), new CastResult(Casts.CAST_PICKAXEHEAD.getItemId(), AMOUNT_PICKAXEHEAD, MAP_CAST_PICKAXEHEAD, false));
        castingRecipes.put(Casts.CAST_AXEHEAD.getItemId(), new CastResult(Casts.CAST_AXEHEAD.getItemId(), AMOUNT_AXEHEAD, MAP_CAST_AXEHEAD, false));
        castingRecipes.put(Casts.CAST_HOEHEAD.getItemId(), new CastResult(Casts.CAST_HOEHEAD.getItemId(), AMOUNT_HOEHEAD, MAP_CAST_HOEHEAD, false));
        castingRecipes.put(Casts.CAST_SWORDBLADE.getItemId(), new CastResult(Casts.CAST_SWORDBLADE.getItemId(), AMOUNT_SWORDBLADE, MAP_CAST_SWORDBLADE, false));
        castingRecipes.put(Casts.CAST_TOOLROD.getItemId(), new CastResult(Casts.CAST_TOOLROD.getItemId(), AMOUNT_TOOLROD, MAP_CAST_TOOLROD, false));

        // endregion
    }

    public boolean isMeltable(ItemStack itemStack) {
        return SlimeTinker.inst().getRecipeManager().meltingRecipes.containsKey(StackUtils.getIDorType(itemStack));
    }

    public MoltenResult getResult(ItemStack itemStack) {
        return meltingRecipes.get(StackUtils.getIDorType(itemStack));
    }

}
