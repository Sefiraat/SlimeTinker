package io.github.sefiraat.slimetinker.items.recipes;

import io.github.mooy1.infinitylib.items.StackUtils;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.Casts;
import io.github.sefiraat.slimetinker.items.Liquids;
import io.github.sefiraat.slimetinker.items.materials.Liquid;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.EnumMap;
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

    public static int AXE_HEAD_AMOUNT = AMOUNT_INGOT * 3;

    public static String ID_IRON = "IRON";
    public static String ID_GOLD = "GOLD";

    public Map<String, MoltenResult> meltingRecipes = new HashMap<>();
    public Map<ItemStack, CastResult> castingRecipes = new HashMap<>();


    public RecipeManager() {
        // region Melting
        // IRON
        meltingRecipes.put(Material.IRON_NUGGET.toString(), new MoltenResult(Liquids.LIQUIDS.get(ID_IRON), AMOUNT_NUGGET));
        meltingRecipes.put(Material.IRON_INGOT.toString(), new MoltenResult(Liquids.LIQUIDS.get(ID_IRON), AMOUNT_INGOT));
        meltingRecipes.put(Material.IRON_ORE.toString(), new MoltenResult(Liquids.LIQUIDS.get(ID_IRON), AMOUNT_ORE));
        meltingRecipes.put(Material.IRON_BLOCK.toString(), new MoltenResult(Liquids.LIQUIDS.get(ID_IRON), AMOUNT_BLOCK));
        meltingRecipes.put(Material.IRON_BOOTS.toString(), new MoltenResult(Liquids.LIQUIDS.get(ID_IRON), AMOUNT_BOOT));
        meltingRecipes.put(Material.IRON_LEGGINGS.toString(), new MoltenResult(Liquids.LIQUIDS.get(ID_IRON), AMOUNT_LEG));
        meltingRecipes.put(Material.IRON_CHESTPLATE.toString(), new MoltenResult(Liquids.LIQUIDS.get(ID_IRON), AMOUNT_CHEST));
        meltingRecipes.put(Material.IRON_HELMET.toString(), new MoltenResult(Liquids.LIQUIDS.get(ID_IRON), AMOUNT_HEAD));
        meltingRecipes.put(SlimefunItems.IRON_DUST.getItemId(), new MoltenResult(Liquids.LIQUIDS.get(ID_IRON), AMOUNT_DUST));
        // GOLD
        meltingRecipes.put(Material.GOLD_NUGGET.toString(), new MoltenResult(Liquids.LIQUIDS.get(ID_GOLD), AMOUNT_NUGGET));
        meltingRecipes.put(Material.GOLD_INGOT.toString(), new MoltenResult(Liquids.LIQUIDS.get(ID_GOLD), AMOUNT_INGOT));
        meltingRecipes.put(Material.GOLD_ORE.toString(), new MoltenResult(Liquids.LIQUIDS.get(ID_GOLD), AMOUNT_ORE));
        meltingRecipes.put(Material.GOLD_BLOCK.toString(), new MoltenResult(Liquids.LIQUIDS.get(ID_GOLD), AMOUNT_BLOCK));
        meltingRecipes.put(Material.GOLDEN_BOOTS.toString(), new MoltenResult(Liquids.LIQUIDS.get(ID_GOLD), AMOUNT_BOOT));
        meltingRecipes.put(Material.GOLDEN_LEGGINGS.toString(), new MoltenResult(Liquids.LIQUIDS.get(ID_GOLD), AMOUNT_LEG));
        meltingRecipes.put(Material.GOLDEN_CHESTPLATE.toString(), new MoltenResult(Liquids.LIQUIDS.get(ID_GOLD), AMOUNT_CHEST));
        meltingRecipes.put(Material.GOLDEN_HELMET.toString(), new MoltenResult(Liquids.LIQUIDS.get(ID_GOLD), AMOUNT_HEAD));
        meltingRecipes.put(SlimefunItems.GOLD_DUST.getItemId(), new MoltenResult(Liquids.LIQUIDS.get(ID_GOLD), AMOUNT_DUST));
        // endregion

        // region Casting
        castingRecipes.put(Casts.CAST_BLOCK, new CastResult(AMOUNT_BLOCK, new HashMap<Liquid, ItemStack>(){
            {
                put(Liquids.LIQUIDS.get(ID_IRON), new ItemStack(Material.IRON_BLOCK));
                put(Liquids.LIQUIDS.get(ID_GOLD), new ItemStack(Material.GOLD_BLOCK));
            }
        }));
        // endregion
    }

    public boolean isMeltable(ItemStack itemStack) {
        return SlimeTinker.inst().getRecipeManager().meltingRecipes.containsKey(StackUtils.getIDorType(itemStack));
    }

    public MoltenResult getResult(ItemStack itemStack) {
        return meltingRecipes.get(StackUtils.getIDorType(itemStack));
    }

}
