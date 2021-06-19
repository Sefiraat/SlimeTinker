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

import static io.github.sefiraat.slimetinker.utils.IDStrings.ALUBRASS;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ALUBRONZE;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ALUMINUM;
import static io.github.sefiraat.slimetinker.utils.IDStrings.AXE;
import static io.github.sefiraat.slimetinker.utils.IDStrings.BILLON;
import static io.github.sefiraat.slimetinker.utils.IDStrings.BRASS;
import static io.github.sefiraat.slimetinker.utils.IDStrings.BRONZE;
import static io.github.sefiraat.slimetinker.utils.IDStrings.COAL;
import static io.github.sefiraat.slimetinker.utils.IDStrings.COBALT;
import static io.github.sefiraat.slimetinker.utils.IDStrings.COPPER;
import static io.github.sefiraat.slimetinker.utils.IDStrings.CORBRONZE;
import static io.github.sefiraat.slimetinker.utils.IDStrings.DAMSTEEL;
import static io.github.sefiraat.slimetinker.utils.IDStrings.DURALIUM;
import static io.github.sefiraat.slimetinker.utils.IDStrings.GOLD;
import static io.github.sefiraat.slimetinker.utils.IDStrings.HARD;
import static io.github.sefiraat.slimetinker.utils.IDStrings.HEAD;
import static io.github.sefiraat.slimetinker.utils.IDStrings.HOE;
import static io.github.sefiraat.slimetinker.utils.IDStrings.IRON;
import static io.github.sefiraat.slimetinker.utils.IDStrings.LEAD;
import static io.github.sefiraat.slimetinker.utils.IDStrings.MAGNESIUM;
import static io.github.sefiraat.slimetinker.utils.IDStrings.NICKEL;
import static io.github.sefiraat.slimetinker.utils.IDStrings.PICKAXE;
import static io.github.sefiraat.slimetinker.utils.IDStrings.REINFORCED;
import static io.github.sefiraat.slimetinker.utils.IDStrings.REPAIR;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ROD;
import static io.github.sefiraat.slimetinker.utils.IDStrings.SHOVEL;
import static io.github.sefiraat.slimetinker.utils.IDStrings.SILVER;
import static io.github.sefiraat.slimetinker.utils.IDStrings.SOLDER;
import static io.github.sefiraat.slimetinker.utils.IDStrings.STEEL;
import static io.github.sefiraat.slimetinker.utils.IDStrings.SWORD;
import static io.github.sefiraat.slimetinker.utils.IDStrings.TIN;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ZINC;

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
        MAP_DIE_NUGGET.put(ComponentMaterials.getById(GOLD), Casts.CAST_NUGGET);
        MAP_DIE_INGOT.put(ComponentMaterials.getById(GOLD), Casts.CAST_INGOT);
        MAP_DIE_BLOCK.put(ComponentMaterials.getById(GOLD), Casts.CAST_BLOCK);
        MAP_DIE_GEM.put(ComponentMaterials.getById(GOLD), Casts.CAST_GEM);
        MAP_DIE_REPAIRKIT.put(ComponentMaterials.getById(GOLD), Casts.CAST_REPAIRKIT);
        MAP_DIE_SHOVELHEAD.put(ComponentMaterials.getById(BRASS), Casts.CAST_SHOVELHEAD);
        MAP_DIE_PICKAXEHEAD.put(ComponentMaterials.getById(BRASS), Casts.CAST_PICKAXEHEAD);
        MAP_DIE_AXEHEAD.put(ComponentMaterials.getById(BRASS), Casts.CAST_AXEHEAD);
        MAP_DIE_HOEHEAD.put(ComponentMaterials.getById(BRASS), Casts.CAST_HOEHEAD);
        MAP_DIE_SWORDBLADE.put(ComponentMaterials.getById(BRASS), Casts.CAST_SWORDBLADE);
        MAP_DIE_TOOLROD.put(ComponentMaterials.getById(BRASS), Casts.CAST_TOOLROD);

        // Nuggets
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(IRON), new ItemStack(Material.IRON_NUGGET));
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(GOLD), new ItemStack(Material.GOLD_NUGGET));
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(COPPER), Materials.NUGGET_CAST_COPPER);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(SILVER), Materials.NUGGET_CAST_SILVER);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(TIN), Materials.NUGGET_CAST_TIN);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(MAGNESIUM), Materials.NUGGET_CAST_MAGNESIUM);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ALUMINUM), Materials.NUGGET_CAST_ALUMINUM);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(LEAD), Materials.NUGGET_CAST_LEAD);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ZINC), Materials.NUGGET_CAST_ZINC);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(COAL), Materials.NUGGET_CAST_COAL);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(STEEL), Materials.NUGGET_CAST_STEEL);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(DAMSTEEL), Materials.NUGGET_CAST_DAMASCUS_STEEL);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(DURALIUM), Materials.NUGGET_CAST_DURALIUM);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(BRONZE), Materials.NUGGET_CAST_BRONZE);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ALUBRONZE), Materials.NUGGET_CAST_ALU_BRONZE);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(HARD), Materials.NUGGET_CAST_HARD_METAL);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(CORBRONZE), Materials.NUGGET_CAST_COR_BRONZE);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(SOLDER), Materials.NUGGET_CAST_SOLDER);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(BILLON), Materials.NUGGET_CAST_BILLON);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(BRASS), Materials.NUGGET_CAST_BRASS);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(ALUBRASS), Materials.NUGGET_CAST_ALU_BRASS);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(NICKEL), Materials.NUGGET_CAST_NICKEL);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(COBALT), Materials.NUGGET_CAST_COBALT);
        MAP_CAST_NUGGET.put(ComponentMaterials.getById(REINFORCED), Materials.NUGGET_CAST_REINFORCED);

        // Ingots
        MAP_CAST_INGOT.put(ComponentMaterials.getById(IRON), new ItemStack(Material.IRON_INGOT));
        MAP_CAST_INGOT.put(ComponentMaterials.getById(GOLD), new ItemStack(Material.GOLD_INGOT));
        MAP_CAST_INGOT.put(ComponentMaterials.getById(COPPER), SlimefunItems.COPPER_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(SILVER), SlimefunItems.SILVER_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(TIN), SlimefunItems.TIN_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(MAGNESIUM), SlimefunItems.MAGNESIUM_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ALUMINUM), SlimefunItems.ALUMINUM_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(LEAD), SlimefunItems.LEAD_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ZINC), SlimefunItems.ZINC_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(STEEL), SlimefunItems.STEEL_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(DAMSTEEL), SlimefunItems.DAMASCUS_STEEL_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(DURALIUM), SlimefunItems.DURALUMIN_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(BRONZE), SlimefunItems.BRONZE_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ALUBRONZE), SlimefunItems.ALUMINUM_BRONZE_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(HARD), SlimefunItems.HARDENED_METAL_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(CORBRONZE), SlimefunItems.CORINTHIAN_BRONZE_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(SOLDER), SlimefunItems.SOLDER_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(BILLON), SlimefunItems.BILLON_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(BRASS), SlimefunItems.BRASS_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(ALUBRASS), SlimefunItems.ALUMINUM_BRASS_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(NICKEL), SlimefunItems.NICKEL_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(COBALT), SlimefunItems.COBALT_INGOT);
        MAP_CAST_INGOT.put(ComponentMaterials.getById(REINFORCED), SlimefunItems.REINFORCED_ALLOY_INGOT);

        // Blocks
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(IRON), new ItemStack(Material.IRON_BLOCK));
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(GOLD), new ItemStack(Material.GOLD_BLOCK));
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(COPPER), Materials.BLOCK_CAST_COPPER);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(SILVER), Materials.BLOCK_CAST_SILVER);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(TIN), Materials.BLOCK_CAST_TIN);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(MAGNESIUM), Materials.BLOCK_CAST_MAGNESIUM);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ALUMINUM), Materials.BLOCK_CAST_ALUMINUM);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(LEAD), Materials.BLOCK_CAST_LEAD);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ZINC), Materials.BLOCK_CAST_ZINC);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(COAL), new ItemStack(Material.COAL_BLOCK));
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(STEEL), Materials.BLOCK_CAST_STEEL);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(DAMSTEEL), Materials.BLOCK_CAST_DAMASCUS_STEEL);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(DURALIUM), Materials.BLOCK_CAST_DURALIUM);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(BRONZE), Materials.BLOCK_CAST_BRONZE);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ALUBRONZE), Materials.BLOCK_CAST_ALU_BRONZE);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(HARD), Materials.BLOCK_CAST_HARD_METAL);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(CORBRONZE), Materials.BLOCK_CAST_COR_BRONZE);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(SOLDER), Materials.BLOCK_CAST_SOLDER);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(BILLON), Materials.BLOCK_CAST_BILLON);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(BRASS), Materials.BLOCK_CAST_BRASS);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(ALUBRASS), Materials.BLOCK_CAST_ALU_BRASS);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(NICKEL), Materials.BLOCK_CAST_NICKEL);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(COBALT), Materials.BLOCK_CAST_COBALT);
        MAP_CAST_BLOCK.put(ComponentMaterials.getById(REINFORCED), Materials.BLOCK_CAST_REINFORCED);

        // Gems
        MAP_CAST_GEM.put(ComponentMaterials.getById(COAL), new ItemStack(Material.COAL));
        
        // Repair Kits
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(IRON), Parts.REPAIR_KIT.getStack(IRON, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(GOLD), Parts.REPAIR_KIT.getStack(GOLD, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(COPPER), Parts.REPAIR_KIT.getStack(COPPER, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(SILVER), Parts.REPAIR_KIT.getStack(SILVER, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(TIN), Parts.REPAIR_KIT.getStack(TIN, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(MAGNESIUM), Parts.REPAIR_KIT.getStack(MAGNESIUM, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ALUMINUM), Parts.REPAIR_KIT.getStack(ALUMINUM, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(LEAD), Parts.REPAIR_KIT.getStack(LEAD, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ZINC), Parts.REPAIR_KIT.getStack(ZINC, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(COAL), Parts.REPAIR_KIT.getStack(COAL, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(STEEL), Parts.REPAIR_KIT.getStack(STEEL, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(DAMSTEEL), Parts.REPAIR_KIT.getStack(DAMSTEEL, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(DURALIUM), Parts.REPAIR_KIT.getStack(DURALIUM, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(BRONZE), Parts.REPAIR_KIT.getStack(BRONZE, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ALUBRONZE), Parts.REPAIR_KIT.getStack(ALUBRONZE, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(HARD), Parts.REPAIR_KIT.getStack(HARD, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(CORBRONZE), Parts.REPAIR_KIT.getStack(CORBRONZE, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(SOLDER), Parts.REPAIR_KIT.getStack(SOLDER, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(BILLON), Parts.REPAIR_KIT.getStack(BILLON, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(BRASS), Parts.REPAIR_KIT.getStack(BRASS, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(ALUBRASS), Parts.REPAIR_KIT.getStack(ALUBRASS, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(NICKEL), Parts.REPAIR_KIT.getStack(NICKEL, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(COBALT), Parts.REPAIR_KIT.getStack(COBALT, REPAIR));
        MAP_CAST_REPAIRKIT.put(ComponentMaterials.getById(REINFORCED), Parts.REPAIR_KIT.getStack(REINFORCED, REPAIR));
        
        // Shovel Heads
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(IRON), Parts.SHOVEL_HEAD.getStack(IRON, HEAD, SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(GOLD), Parts.SHOVEL_HEAD.getStack(GOLD, HEAD, SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(COPPER), Parts.SHOVEL_HEAD.getStack(COPPER, HEAD, SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(SILVER), Parts.SHOVEL_HEAD.getStack(SILVER, HEAD, SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(TIN), Parts.SHOVEL_HEAD.getStack(TIN, HEAD, SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(MAGNESIUM), Parts.SHOVEL_HEAD.getStack(MAGNESIUM, HEAD, SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ALUMINUM), Parts.SHOVEL_HEAD.getStack(ALUMINUM, HEAD, SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(LEAD), Parts.SHOVEL_HEAD.getStack(LEAD, HEAD, SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ZINC), Parts.SHOVEL_HEAD.getStack(ZINC, HEAD, SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(STEEL), Parts.SHOVEL_HEAD.getStack(STEEL, HEAD, SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(DAMSTEEL), Parts.SHOVEL_HEAD.getStack(DAMSTEEL, HEAD, SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(DURALIUM), Parts.SHOVEL_HEAD.getStack(DURALIUM, HEAD, SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(BRONZE), Parts.SHOVEL_HEAD.getStack(BRONZE, HEAD, SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ALUBRONZE), Parts.SHOVEL_HEAD.getStack(ALUBRONZE, HEAD, SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(HARD), Parts.SHOVEL_HEAD.getStack(HARD, HEAD, SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(CORBRONZE), Parts.SHOVEL_HEAD.getStack(CORBRONZE, HEAD, SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(SOLDER), Parts.SHOVEL_HEAD.getStack(SOLDER, HEAD, SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(BILLON), Parts.SHOVEL_HEAD.getStack(BILLON, HEAD, SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(BRASS), Parts.SHOVEL_HEAD.getStack(BRASS, HEAD, SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(ALUBRASS), Parts.SHOVEL_HEAD.getStack(ALUBRASS, HEAD, SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(NICKEL), Parts.SHOVEL_HEAD.getStack(NICKEL, HEAD, SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(COBALT), Parts.SHOVEL_HEAD.getStack(COBALT, HEAD, SHOVEL));
        MAP_CAST_SHOVELHEAD.put(ComponentMaterials.getById(REINFORCED), Parts.SHOVEL_HEAD.getStack(REINFORCED, HEAD, SHOVEL));

        // Pickaxe Heads
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(IRON), Parts.PICKAXE_HEAD.getStack(IRON, HEAD, PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(GOLD), Parts.PICKAXE_HEAD.getStack(GOLD, HEAD, PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(COPPER), Parts.PICKAXE_HEAD.getStack(COPPER, HEAD, PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(SILVER), Parts.PICKAXE_HEAD.getStack(SILVER, HEAD, PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(TIN), Parts.PICKAXE_HEAD.getStack(TIN, HEAD, PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(MAGNESIUM), Parts.PICKAXE_HEAD.getStack(MAGNESIUM, HEAD, PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ALUMINUM), Parts.PICKAXE_HEAD.getStack(ALUMINUM, HEAD, PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(LEAD), Parts.PICKAXE_HEAD.getStack(LEAD, HEAD, PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ZINC), Parts.PICKAXE_HEAD.getStack(ZINC, HEAD, PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(STEEL), Parts.PICKAXE_HEAD.getStack(STEEL, HEAD, PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(DAMSTEEL), Parts.PICKAXE_HEAD.getStack(DAMSTEEL, HEAD, PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(DURALIUM), Parts.PICKAXE_HEAD.getStack(DURALIUM, HEAD, PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(BRONZE), Parts.PICKAXE_HEAD.getStack(BRONZE, HEAD, PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ALUBRONZE), Parts.PICKAXE_HEAD.getStack(ALUBRONZE, HEAD, PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(HARD), Parts.PICKAXE_HEAD.getStack(HARD, HEAD, PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(CORBRONZE), Parts.PICKAXE_HEAD.getStack(CORBRONZE, HEAD, PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(SOLDER), Parts.PICKAXE_HEAD.getStack(SOLDER, HEAD, PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(BILLON), Parts.PICKAXE_HEAD.getStack(BILLON, HEAD, PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(BRASS), Parts.PICKAXE_HEAD.getStack(BRASS, HEAD, PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(ALUBRASS), Parts.PICKAXE_HEAD.getStack(ALUBRASS, HEAD, PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(NICKEL), Parts.PICKAXE_HEAD.getStack(NICKEL, HEAD, PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(COBALT), Parts.PICKAXE_HEAD.getStack(COBALT, HEAD, PICKAXE));
        MAP_CAST_PICKAXEHEAD.put(ComponentMaterials.getById(REINFORCED), Parts.PICKAXE_HEAD.getStack(REINFORCED, HEAD, PICKAXE));

        // Axe Heads
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(IRON), Parts.AXE_HEAD.getStack(IRON, HEAD, AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(GOLD), Parts.AXE_HEAD.getStack(GOLD, HEAD, AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(COPPER), Parts.AXE_HEAD.getStack(COPPER, HEAD, AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(SILVER), Parts.AXE_HEAD.getStack(SILVER, HEAD, AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(TIN), Parts.AXE_HEAD.getStack(TIN, HEAD, AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(MAGNESIUM), Parts.AXE_HEAD.getStack(MAGNESIUM, HEAD, AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ALUMINUM), Parts.AXE_HEAD.getStack(ALUMINUM, HEAD, AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(LEAD), Parts.AXE_HEAD.getStack(LEAD, HEAD, AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ZINC), Parts.AXE_HEAD.getStack(ZINC, HEAD, AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(STEEL), Parts.AXE_HEAD.getStack(STEEL, HEAD, AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(DAMSTEEL), Parts.AXE_HEAD.getStack(DAMSTEEL, HEAD, AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(DURALIUM), Parts.AXE_HEAD.getStack(DURALIUM, HEAD, AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(BRONZE), Parts.AXE_HEAD.getStack(BRONZE, HEAD, AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ALUBRONZE), Parts.AXE_HEAD.getStack(ALUBRONZE, HEAD, AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(HARD), Parts.AXE_HEAD.getStack(HARD, HEAD, AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(CORBRONZE), Parts.AXE_HEAD.getStack(CORBRONZE, HEAD, AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(SOLDER), Parts.AXE_HEAD.getStack(SOLDER, HEAD, AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(BILLON), Parts.AXE_HEAD.getStack(BILLON, HEAD, AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(BRASS), Parts.AXE_HEAD.getStack(BRASS, HEAD, AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(ALUBRASS), Parts.AXE_HEAD.getStack(ALUBRASS, HEAD, AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(NICKEL), Parts.AXE_HEAD.getStack(NICKEL, HEAD, AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(COBALT), Parts.AXE_HEAD.getStack(COBALT, HEAD, AXE));
        MAP_CAST_AXEHEAD.put(ComponentMaterials.getById(REINFORCED), Parts.AXE_HEAD.getStack(REINFORCED, HEAD, AXE));

         // Hoe Heads
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(IRON), Parts.HOE_HEAD.getStack(IRON, HEAD, HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(GOLD), Parts.HOE_HEAD.getStack(GOLD, HEAD, HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(COPPER), Parts.HOE_HEAD.getStack(COPPER, HEAD, HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(SILVER), Parts.HOE_HEAD.getStack(SILVER, HEAD, HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(TIN), Parts.HOE_HEAD.getStack(TIN, HEAD, HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(MAGNESIUM), Parts.HOE_HEAD.getStack(MAGNESIUM, HEAD, HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ALUMINUM), Parts.HOE_HEAD.getStack(ALUMINUM, HEAD, HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(LEAD), Parts.HOE_HEAD.getStack(LEAD, HEAD, HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ZINC), Parts.HOE_HEAD.getStack(ZINC, HEAD, HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(STEEL), Parts.HOE_HEAD.getStack(STEEL, HEAD, HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(DAMSTEEL), Parts.HOE_HEAD.getStack(DAMSTEEL, HEAD, HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(DURALIUM), Parts.HOE_HEAD.getStack(DURALIUM, HEAD, HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(BRONZE), Parts.HOE_HEAD.getStack(BRONZE, HEAD, HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ALUBRONZE), Parts.HOE_HEAD.getStack(ALUBRONZE, HEAD, HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(HARD), Parts.HOE_HEAD.getStack(HARD, HEAD, HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(CORBRONZE), Parts.HOE_HEAD.getStack(CORBRONZE, HEAD, HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(SOLDER), Parts.HOE_HEAD.getStack(SOLDER, HEAD, HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(BILLON), Parts.HOE_HEAD.getStack(BILLON, HEAD, HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(BRASS), Parts.HOE_HEAD.getStack(BRASS, HEAD, HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(ALUBRASS), Parts.HOE_HEAD.getStack(ALUBRASS, HEAD, HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(NICKEL), Parts.HOE_HEAD.getStack(NICKEL, HEAD, HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(COBALT), Parts.HOE_HEAD.getStack(COBALT, HEAD, HOE));
        MAP_CAST_HOEHEAD.put(ComponentMaterials.getById(REINFORCED), Parts.HOE_HEAD.getStack(REINFORCED, HEAD, HOE));

         // Sword Blades
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(IRON), Parts.SWORD_BLADE.getStack(IRON, HEAD, SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(GOLD), Parts.SWORD_BLADE.getStack(GOLD, HEAD, SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(COPPER), Parts.SWORD_BLADE.getStack(COPPER, HEAD, SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(SILVER), Parts.SWORD_BLADE.getStack(SILVER, HEAD, SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(TIN), Parts.SWORD_BLADE.getStack(TIN, HEAD, SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(MAGNESIUM), Parts.SWORD_BLADE.getStack(MAGNESIUM, HEAD, SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ALUMINUM), Parts.SWORD_BLADE.getStack(ALUMINUM, HEAD, SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(LEAD), Parts.SWORD_BLADE.getStack(LEAD, HEAD, SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ZINC), Parts.SWORD_BLADE.getStack(ZINC, HEAD, SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(STEEL), Parts.SWORD_BLADE.getStack(STEEL, HEAD, SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(DAMSTEEL), Parts.SWORD_BLADE.getStack(DAMSTEEL, HEAD, SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(DURALIUM), Parts.SWORD_BLADE.getStack(DURALIUM, HEAD, SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(BRONZE), Parts.SWORD_BLADE.getStack(BRONZE, HEAD, SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ALUBRONZE), Parts.SWORD_BLADE.getStack(ALUBRONZE, HEAD, SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(HARD), Parts.SWORD_BLADE.getStack(HARD, HEAD, SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(CORBRONZE), Parts.SWORD_BLADE.getStack(CORBRONZE, HEAD, SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(SOLDER), Parts.SWORD_BLADE.getStack(SOLDER, HEAD, SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(BILLON), Parts.SWORD_BLADE.getStack(BILLON, HEAD, SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(BRASS), Parts.SWORD_BLADE.getStack(BRASS, HEAD, SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(ALUBRASS), Parts.SWORD_BLADE.getStack(ALUBRASS, HEAD, SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(NICKEL), Parts.SWORD_BLADE.getStack(NICKEL, HEAD, SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(COBALT), Parts.SWORD_BLADE.getStack(COBALT, HEAD, SWORD));
        MAP_CAST_SWORDBLADE.put(ComponentMaterials.getById(REINFORCED), Parts.SWORD_BLADE.getStack(REINFORCED, HEAD, SWORD));

        // Tool Rods
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(IRON), Parts.TOOL_ROD.getStack(IRON, ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(GOLD), Parts.TOOL_ROD.getStack(GOLD, ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(COPPER), Parts.TOOL_ROD.getStack(COPPER, ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(SILVER), Parts.TOOL_ROD.getStack(SILVER, ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(TIN), Parts.TOOL_ROD.getStack(TIN, ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(MAGNESIUM), Parts.TOOL_ROD.getStack(MAGNESIUM, ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ALUMINUM), Parts.TOOL_ROD.getStack(ALUMINUM, ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(LEAD), Parts.TOOL_ROD.getStack(LEAD, ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ZINC), Parts.TOOL_ROD.getStack(ZINC, ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(STEEL), Parts.TOOL_ROD.getStack(STEEL, ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(DAMSTEEL), Parts.TOOL_ROD.getStack(DAMSTEEL, ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(DURALIUM), Parts.TOOL_ROD.getStack(DURALIUM, ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(BRONZE), Parts.TOOL_ROD.getStack(BRONZE, ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ALUBRONZE), Parts.TOOL_ROD.getStack(ALUBRONZE, ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(HARD), Parts.TOOL_ROD.getStack(HARD, ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(CORBRONZE), Parts.TOOL_ROD.getStack(CORBRONZE, ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(SOLDER), Parts.TOOL_ROD.getStack(SOLDER, ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(BILLON), Parts.TOOL_ROD.getStack(BILLON, ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(BRASS), Parts.TOOL_ROD.getStack(BRASS, ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(ALUBRASS), Parts.TOOL_ROD.getStack(ALUBRASS, ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(NICKEL), Parts.TOOL_ROD.getStack(NICKEL, ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(COBALT), Parts.TOOL_ROD.getStack(COBALT, ROD, null));
        MAP_CAST_TOOLROD.put(ComponentMaterials.getById(REINFORCED), Parts.TOOL_ROD.getStack(REINFORCED, ROD, null));

    }

    public RecipeManager() {
        
        // region Melting Recipes

        // IRON
        meltingRecipes.put(Material.IRON_NUGGET.toString(), new MoltenResult(ComponentMaterials.getById(IRON), AMOUNT_NUGGET));
        meltingRecipes.put(Material.IRON_INGOT.toString(), new MoltenResult(ComponentMaterials.getById(IRON), AMOUNT_INGOT));
        meltingRecipes.put(Material.IRON_ORE.toString(), new MoltenResult(ComponentMaterials.getById(IRON), AMOUNT_ORE));
        meltingRecipes.put(Material.IRON_BLOCK.toString(), new MoltenResult(ComponentMaterials.getById(IRON), AMOUNT_BLOCK));
        meltingRecipes.put(Material.IRON_BOOTS.toString(), new MoltenResult(ComponentMaterials.getById(IRON), AMOUNT_BOOT));
        meltingRecipes.put(Material.IRON_LEGGINGS.toString(), new MoltenResult(ComponentMaterials.getById(IRON), AMOUNT_LEG));
        meltingRecipes.put(Material.IRON_CHESTPLATE.toString(), new MoltenResult(ComponentMaterials.getById(IRON), AMOUNT_CHEST));
        meltingRecipes.put(Material.IRON_HELMET.toString(), new MoltenResult(ComponentMaterials.getById(IRON), AMOUNT_HEAD));
        meltingRecipes.put(SlimefunItems.IRON_DUST.getItemId(), new MoltenResult(ComponentMaterials.getById(IRON), AMOUNT_DUST));

        // GOLD
        meltingRecipes.put(Material.GOLD_NUGGET.toString(), new MoltenResult(ComponentMaterials.getById(GOLD), AMOUNT_NUGGET));
        meltingRecipes.put(Material.GOLD_INGOT.toString(), new MoltenResult(ComponentMaterials.getById(GOLD), AMOUNT_INGOT));
        meltingRecipes.put(Material.GOLD_ORE.toString(), new MoltenResult(ComponentMaterials.getById(GOLD), AMOUNT_ORE));
        meltingRecipes.put(Material.GOLD_BLOCK.toString(), new MoltenResult(ComponentMaterials.getById(GOLD), AMOUNT_BLOCK));
        meltingRecipes.put(Material.GOLDEN_BOOTS.toString(), new MoltenResult(ComponentMaterials.getById(GOLD), AMOUNT_BOOT));
        meltingRecipes.put(Material.GOLDEN_LEGGINGS.toString(), new MoltenResult(ComponentMaterials.getById(GOLD), AMOUNT_LEG));
        meltingRecipes.put(Material.GOLDEN_CHESTPLATE.toString(), new MoltenResult(ComponentMaterials.getById(GOLD), AMOUNT_CHEST));
        meltingRecipes.put(Material.GOLDEN_HELMET.toString(), new MoltenResult(ComponentMaterials.getById(GOLD), AMOUNT_HEAD));
        meltingRecipes.put(SlimefunItems.GOLD_DUST.getItemId(), new MoltenResult(ComponentMaterials.getById(GOLD), AMOUNT_DUST));

        // COPPER
        meltingRecipes.put(SlimefunItems.COPPER_DUST.getItemId(), new MoltenResult(ComponentMaterials.getById(COPPER), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.COPPER_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(COPPER), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_COPPER.getItemId(), new MoltenResult(ComponentMaterials.getById(COPPER), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_COPPER.getItemId(), new MoltenResult(ComponentMaterials.getById(COPPER), AMOUNT_BLOCK));

        // SILVER
        meltingRecipes.put(SlimefunItems.SILVER_DUST.getItemId(), new MoltenResult(ComponentMaterials.getById(SILVER), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.SILVER_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(SILVER), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_SILVER.getItemId(), new MoltenResult(ComponentMaterials.getById(SILVER), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_SILVER.getItemId(), new MoltenResult(ComponentMaterials.getById(SILVER), AMOUNT_BLOCK));

        // TIN
        meltingRecipes.put(SlimefunItems.TIN_DUST.getItemId(), new MoltenResult(ComponentMaterials.getById(TIN), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.TIN_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(TIN), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_TIN.getItemId(), new MoltenResult(ComponentMaterials.getById(TIN), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_TIN.getItemId(), new MoltenResult(ComponentMaterials.getById(TIN), AMOUNT_BLOCK));

        // MAGNESIUM
        meltingRecipes.put(SlimefunItems.MAGNESIUM_DUST.getItemId(), new MoltenResult(ComponentMaterials.getById(MAGNESIUM), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.MAGNESIUM_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(MAGNESIUM), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_MAGNESIUM.getItemId(), new MoltenResult(ComponentMaterials.getById(MAGNESIUM), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_MAGNESIUM.getItemId(), new MoltenResult(ComponentMaterials.getById(MAGNESIUM), AMOUNT_BLOCK));

        // ALUMINUM
        meltingRecipes.put(SlimefunItems.ALUMINUM_DUST.getItemId(), new MoltenResult(ComponentMaterials.getById(ALUMINUM), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.ALUMINUM_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ALUMINUM), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_ALUMINUM.getItemId(), new MoltenResult(ComponentMaterials.getById(ALUMINUM), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_ALUMINUM.getItemId(), new MoltenResult(ComponentMaterials.getById(ALUMINUM), AMOUNT_BLOCK));

        // LEAD
        meltingRecipes.put(SlimefunItems.LEAD_DUST.getItemId(), new MoltenResult(ComponentMaterials.getById(LEAD), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.LEAD_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(LEAD), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_LEAD.getItemId(), new MoltenResult(ComponentMaterials.getById(LEAD), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_LEAD.getItemId(), new MoltenResult(ComponentMaterials.getById(LEAD), AMOUNT_BLOCK));

        // ZINC
        meltingRecipes.put(SlimefunItems.ZINC_DUST.getItemId(), new MoltenResult(ComponentMaterials.getById(ZINC), AMOUNT_DUST));
        meltingRecipes.put(SlimefunItems.ZINC_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ZINC), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_ZINC.getItemId(), new MoltenResult(ComponentMaterials.getById(ZINC), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_ZINC.getItemId(), new MoltenResult(ComponentMaterials.getById(ZINC), AMOUNT_BLOCK));

        // COAL
        meltingRecipes.put(Material.COAL.toString(), new MoltenResult(ComponentMaterials.getById(COAL), AMOUNT_GEM));
        meltingRecipes.put(Materials.NUGGET_CAST_COAL.getItemId(), new MoltenResult(ComponentMaterials.getById(COAL), AMOUNT_NUGGET));
        meltingRecipes.put(Material.COAL_BLOCK.toString(), new MoltenResult(ComponentMaterials.getById(COAL), AMOUNT_BLOCK));

        // STEEL
        meltingRecipes.put(SlimefunItems.STEEL_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(STEEL), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_STEEL.getItemId(), new MoltenResult(ComponentMaterials.getById(STEEL), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_STEEL.getItemId(), new MoltenResult(ComponentMaterials.getById(STEEL), AMOUNT_BLOCK));

        // DAMASCUS STEEL
        meltingRecipes.put(SlimefunItems.DAMASCUS_STEEL_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(DAMSTEEL), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_DAMASCUS_STEEL.getItemId(), new MoltenResult(ComponentMaterials.getById(DAMSTEEL), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_DAMASCUS_STEEL.getItemId(), new MoltenResult(ComponentMaterials.getById(DAMSTEEL), AMOUNT_BLOCK));

        // DURALIUM
        meltingRecipes.put(SlimefunItems.DURALUMIN_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(DURALIUM), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_DURALIUM.getItemId(), new MoltenResult(ComponentMaterials.getById(DURALIUM), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_DURALIUM.getItemId(), new MoltenResult(ComponentMaterials.getById(DURALIUM), AMOUNT_BLOCK));

        // BRONZE
        meltingRecipes.put(SlimefunItems.BRONZE_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(BRONZE), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_BRONZE.getItemId(), new MoltenResult(ComponentMaterials.getById(BRONZE), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_BRONZE.getItemId(), new MoltenResult(ComponentMaterials.getById(BRONZE), AMOUNT_BLOCK));

        // ALU_BRONZE
        meltingRecipes.put(SlimefunItems.ALUMINUM_BRONZE_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ALUBRONZE), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_ALU_BRONZE.getItemId(), new MoltenResult(ComponentMaterials.getById(ALUBRONZE), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_ALU_BRONZE.getItemId(), new MoltenResult(ComponentMaterials.getById(ALUBRONZE), AMOUNT_BLOCK));

        // HARDENED METAL
        meltingRecipes.put(SlimefunItems.HARDENED_METAL_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(HARD), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_HARD_METAL.getItemId(), new MoltenResult(ComponentMaterials.getById(HARD), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_HARD_METAL.getItemId(), new MoltenResult(ComponentMaterials.getById(HARD), AMOUNT_BLOCK));

        // COR BRONZE
        meltingRecipes.put(SlimefunItems.CORINTHIAN_BRONZE_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(CORBRONZE), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_COR_BRONZE.getItemId(), new MoltenResult(ComponentMaterials.getById(CORBRONZE), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_COR_BRONZE.getItemId(), new MoltenResult(ComponentMaterials.getById(CORBRONZE), AMOUNT_BLOCK));

        // SOLDER
        meltingRecipes.put(SlimefunItems.SOLDER_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(SOLDER), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_SOLDER.getItemId(), new MoltenResult(ComponentMaterials.getById(SOLDER), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_SOLDER.getItemId(), new MoltenResult(ComponentMaterials.getById(SOLDER), AMOUNT_BLOCK));

        // BILLON
        meltingRecipes.put(SlimefunItems.BILLON_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(BILLON), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_BILLON.getItemId(), new MoltenResult(ComponentMaterials.getById(BILLON), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_BILLON.getItemId(), new MoltenResult(ComponentMaterials.getById(BILLON), AMOUNT_BLOCK));

        // BRASS
        meltingRecipes.put(SlimefunItems.BRASS_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(BRASS), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_BRASS.getItemId(), new MoltenResult(ComponentMaterials.getById(BRASS), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_BRASS.getItemId(), new MoltenResult(ComponentMaterials.getById(BRASS), AMOUNT_BLOCK));

        // ALU BRASS
        meltingRecipes.put(SlimefunItems.ALUMINUM_BRASS_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(ALUBRASS), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_ALU_BRASS.getItemId(), new MoltenResult(ComponentMaterials.getById(ALUBRASS), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_ALU_BRASS.getItemId(), new MoltenResult(ComponentMaterials.getById(ALUBRASS), AMOUNT_BLOCK));

        // NICKEL
        meltingRecipes.put(SlimefunItems.NICKEL_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(NICKEL), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_NICKEL.getItemId(), new MoltenResult(ComponentMaterials.getById(NICKEL), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_NICKEL.getItemId(), new MoltenResult(ComponentMaterials.getById(NICKEL), AMOUNT_BLOCK));

        // COBALT
        meltingRecipes.put(SlimefunItems.COBALT_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(COBALT), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_COBALT.getItemId(), new MoltenResult(ComponentMaterials.getById(COBALT), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_COBALT.getItemId(), new MoltenResult(ComponentMaterials.getById(COBALT), AMOUNT_BLOCK));

         // COBALT
        meltingRecipes.put(SlimefunItems.REINFORCED_ALLOY_INGOT.getItemId(), new MoltenResult(ComponentMaterials.getById(REINFORCED), AMOUNT_INGOT));
        meltingRecipes.put(Materials.NUGGET_CAST_REINFORCED.getItemId(), new MoltenResult(ComponentMaterials.getById(REINFORCED), AMOUNT_NUGGET));
        meltingRecipes.put(Materials.BLOCK_CAST_REINFORCED.getItemId(), new MoltenResult(ComponentMaterials.getById(REINFORCED), AMOUNT_BLOCK));

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
