package io.github.sefiraat.slimetinker.managers;

import io.github.mooy1.infinitylib.items.StackUtils;
import io.github.sefiraat.slimetinker.items.Casts;
import io.github.sefiraat.slimetinker.items.Dies;
import io.github.sefiraat.slimetinker.items.Parts;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMManager;
import io.github.sefiraat.slimetinker.items.materials.ComponentMaterial;
import io.github.sefiraat.slimetinker.items.recipes.CastResult;
import io.github.sefiraat.slimetinker.items.recipes.MoltenResult;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

import static io.github.sefiraat.slimetinker.utils.IDStrings.BRASS;
import static io.github.sefiraat.slimetinker.utils.IDStrings.GOLD;
import static io.github.sefiraat.slimetinker.utils.IDStrings.HEAD;
import static io.github.sefiraat.slimetinker.utils.IDStrings.HOE;
import static io.github.sefiraat.slimetinker.utils.IDStrings.PICKAXE;
import static io.github.sefiraat.slimetinker.utils.IDStrings.REPAIR;
import static io.github.sefiraat.slimetinker.utils.IDStrings.ROD;
import static io.github.sefiraat.slimetinker.utils.IDStrings.SHOVEL;
import static io.github.sefiraat.slimetinker.utils.IDStrings.SWORD;

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

    public RecipeManager() {

        // Set up all the CMCore

        for (Map.Entry<String, ComponentMaterial> entry : CMManager.getMAP().entrySet()) {

            // Tools and Kits (referenced through dummy)
            if (entry.getValue().isValidToolRod()) MAP_CAST_TOOLROD.put(entry.getValue(), Parts.TOOL_ROD.getStack(entry.getKey(), ROD, null));
            if (entry.getValue().isValidToolHead()) MAP_CAST_SWORDBLADE.put(entry.getValue(), Parts.SWORD_BLADE.getStack(entry.getKey(), HEAD, SWORD));
            if (entry.getValue().isValidToolHead()) MAP_CAST_HOEHEAD.put(entry.getValue(), Parts.HOE_HEAD.getStack(entry.getKey(), HEAD, HOE));
            if (entry.getValue().isValidToolHead()) MAP_CAST_PICKAXEHEAD.put(entry.getValue(), Parts.PICKAXE_HEAD.getStack(entry.getKey(), HEAD, PICKAXE));
            if (entry.getValue().isValidToolHead()) MAP_CAST_SHOVELHEAD.put(entry.getValue(), Parts.SHOVEL_HEAD.getStack(entry.getKey(), HEAD, SHOVEL));
            if (entry.getValue().isValidToolHead()) MAP_CAST_REPAIRKIT.put(entry.getValue(), Parts.REPAIR_KIT.getStack(entry.getKey(), REPAIR)); // We use HEAD here are repair always goes by head material
            // Gems
            if (entry.getValue().getFormGem() != null) {
                ItemStack i = StackUtils.getItemByID(entry.getValue().getFormGem());
                if (i == null) {
                    i = new ItemStack(Material.valueOf(entry.getValue().getFormGem()));
                }
                MAP_CAST_GEM.put(entry.getValue(), i);
                meltingRecipes.put(entry.getValue().getFormGem(), new MoltenResult(entry.getValue(), AMOUNT_GEM));
            }
            // Blocks
            if (entry.getValue().getFormBlock() != null) {
                ItemStack i = StackUtils.getItemByID(entry.getValue().getFormBlock());
                if (i == null) {
                    i = new ItemStack(Material.valueOf(entry.getValue().getFormBlock()));
                }
                MAP_CAST_BLOCK.put(entry.getValue(), i);
                meltingRecipes.put(entry.getValue().getFormBlock(), new MoltenResult(entry.getValue(), AMOUNT_BLOCK));
            }
            // Ingots
            if (entry.getValue().getFormIngot() != null) {
                ItemStack i = StackUtils.getItemByID(entry.getValue().getFormIngot());
                if (i == null) {
                    i = new ItemStack(Material.valueOf(entry.getValue().getFormIngot()));
                }
                MAP_CAST_INGOT.put(entry.getValue(), i);
                meltingRecipes.put(entry.getValue().getFormIngot(), new MoltenResult(entry.getValue(), AMOUNT_INGOT));
            }
            // Nuggets
            if (entry.getValue().getFormNugget() != null) {
                ItemStack i = StackUtils.getItemByID(entry.getValue().getFormNugget());
                if (i == null) {
                    i = new ItemStack(Material.valueOf(entry.getValue().getFormNugget()));
                }
                MAP_CAST_NUGGET.put(entry.getValue(), i);
                meltingRecipes.put(entry.getValue().getFormNugget(), new MoltenResult(entry.getValue(), AMOUNT_NUGGET));
            }
            // Ores
            if (entry.getValue().getFormOre() != null) {
                meltingRecipes.put(entry.getValue().getFormOre(), new MoltenResult(entry.getValue(), AMOUNT_ORE));
            }
            // Dusts
            if (entry.getValue().getFormDust() != null) {
                meltingRecipes.put(entry.getValue().getFormDust(), new MoltenResult(entry.getValue(), AMOUNT_DUST));
            }
            // Helm
            if (entry.getValue().getFormHelm() != null) {
                meltingRecipes.put(entry.getValue().getFormHelm(), new MoltenResult(entry.getValue(), AMOUNT_HEAD));
            }
            // Chest
            if (entry.getValue().getFormChest() != null) {
                meltingRecipes.put(entry.getValue().getFormChest(), new MoltenResult(entry.getValue(), AMOUNT_CHEST));
            }
            // Leg
            if (entry.getValue().getFormLeg() != null) {
                meltingRecipes.put(entry.getValue().getFormLeg(), new MoltenResult(entry.getValue(), AMOUNT_LEG));
            }
            // Boot
            if (entry.getValue().getFormBoot() != null) {
                meltingRecipes.put(entry.getValue().getFormBoot(), new MoltenResult(entry.getValue(), AMOUNT_BOOT));
            }
        }

        // Set up the dies for creating casts

        MAP_DIE_NUGGET.put(CMManager.getById(GOLD), Casts.CAST_NUGGET);
        MAP_DIE_INGOT.put(CMManager.getById(GOLD), Casts.CAST_INGOT);
        MAP_DIE_BLOCK.put(CMManager.getById(GOLD), Casts.CAST_BLOCK);
        MAP_DIE_GEM.put(CMManager.getById(GOLD), Casts.CAST_GEM);
        MAP_DIE_REPAIRKIT.put(CMManager.getById(GOLD), Casts.CAST_REPAIRKIT);
        MAP_DIE_SHOVELHEAD.put(CMManager.getById(BRASS), Casts.CAST_SHOVELHEAD);
        MAP_DIE_PICKAXEHEAD.put(CMManager.getById(BRASS), Casts.CAST_PICKAXEHEAD);
        MAP_DIE_AXEHEAD.put(CMManager.getById(BRASS), Casts.CAST_AXEHEAD);
        MAP_DIE_HOEHEAD.put(CMManager.getById(BRASS), Casts.CAST_HOEHEAD);
        MAP_DIE_SWORDBLADE.put(CMManager.getById(BRASS), Casts.CAST_SWORDBLADE);
        MAP_DIE_TOOLROD.put(CMManager.getById(BRASS), Casts.CAST_TOOLROD);

        // Recipes for creating casts from dies

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

    }

}
