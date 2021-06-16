package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.DummySmeltery;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class Alloys {

    protected static final ItemStack[] RECIPE_ALLOY_STEEL = new ItemStack[] {
            new ItemStack(Material.IRON_INGOT, 2),   new ItemStack(Material.COAL), null,
            null,                                           null,               null,
            null,                                           null,               null
    };

    protected static final ItemStack[] RECIPE_ALLOY_DAM_STEEL = new ItemStack[] {
            SlimefunItems.STEEL_INGOT,   new ItemStack(Material.IRON_INGOT, 2), new ItemStack(Material.COAL),
            null,                                           null,               null,
            null,                                           null,               null
    };

    protected static final ItemStack[] RECIPE_ALLOY_DURALIUM = new ItemStack[] {
            new SlimefunItemStack(SlimefunItems.ALUMINUM_INGOT,2),   SlimefunItems.COPPER_INGOT, null,
            null,                                           null,               null,
            null,                                           null,               null
    };

    protected static final ItemStack[] RECIPE_ALLOY_BRONZE = new ItemStack[] {
            new SlimefunItemStack(SlimefunItems.COPPER_INGOT,2),   SlimefunItems.TIN_INGOT, null,
            null,                                           null,               null,
            null,                                           null,               null
    };

    protected static final ItemStack[] RECIPE_ALLOY_ALU_BRONZE = new ItemStack[] {
            new SlimefunItemStack(SlimefunItems.ALUMINUM_INGOT,2),   SlimefunItems.BRONZE_INGOT, null,
            null,                                           null,               null,
            null,                                           null,               null
    };

    protected static final ItemStack[] RECIPE_ALLOY_HARD_METAL = new ItemStack[] {
            SlimefunItems.ALUMINUM_BRASS_INGOT,   SlimefunItems.DURALUMIN_INGOT, SlimefunItems.DAMASCUS_STEEL_INGOT,
            new ItemStack(Material.COAL, 4),         null,               null,
            null,                                           null,               null
    };

    protected static final ItemStack[] RECIPE_ALLOY_COR_BRONZE = new ItemStack[] {
            SlimefunItems.BRONZE_INGOT,   new ItemStack(Material.GOLD_INGOT), SlimefunItems.SILVER_INGOT,
            SlimefunItems.COPPER_INGOT,                                           null,               null,
            null,                                           null,               null
    };

    protected static final ItemStack[] RECIPE_ALLOY_SOLDER = new ItemStack[] {
            new SlimefunItemStack(SlimefunItems.LEAD_INGOT,2),   SlimefunItems.TIN_INGOT, null,
            null,                                           null,               null,
            null,                                           null,               null
    };

    protected static final ItemStack[] RECIPE_ALLOY_BILLON = new ItemStack[] {
            new SlimefunItemStack(SlimefunItems.SILVER_INGOT,2),   SlimefunItems.COPPER_INGOT, null,
            null,                                           null,               null,
            null,                                           null,               null
    };

    protected static final ItemStack[] RECIPE_ALLOY_BRASS = new ItemStack[] {
            new SlimefunItemStack(SlimefunItems.COPPER_INGOT,2), SlimefunItems.ZINC_INGOT, null,
            null,                                           null,               null,
            null,                                           null,               null
    };

    protected static final ItemStack[] RECIPE_ALLOY_ALU_BRASS = new ItemStack[] {
            SlimefunItems.BRASS_INGOT,   new SlimefunItemStack(SlimefunItems.ALUMINUM_INGOT,2), null,
            null,                                           null,               null,
            null,                                           null,               null
    };

    protected static final ItemStack[] RECIPE_ALLOY_NICKEL = new ItemStack[] {
            new ItemStack(Material.IRON_INGOT, 2),   SlimefunItems.COPPER_INGOT, null,
            null,                                           null,               null,
            null,                                           null,               null
    };

    protected static final ItemStack[] RECIPE_ALLOY_COBALT = new ItemStack[] {
            new ItemStack(Material.IRON_INGOT, 1),   SlimefunItems.NICKEL_INGOT, SlimefunItems.COPPER_INGOT,
            null,                                           null,               null,
            null,                                           null,               null
    };

    protected static final ItemStack[] RECIPE_ALLOY_REINFORCED = new ItemStack[] {
            SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.HARDENED_METAL_INGOT, SlimefunItems.CORINTHIAN_BRONZE_INGOT,
            SlimefunItems.SOLDER_INGOT,         SlimefunItems.BILLON_INGOT,         new ItemStack(Material.GOLD_INGOT),
            null,                                           null,               null
    };

    public static void set(SlimeTinker p) {
        new UnplaceableBlock(Categories.ALLOYS, new SlimefunItemStack(SlimefunItems.STEEL_INGOT, 1), DummySmeltery.TYPE, RECIPE_ALLOY_STEEL).register(p);
        new UnplaceableBlock(Categories.ALLOYS, SlimefunItems.DAMASCUS_STEEL_INGOT, DummySmeltery.TYPE, RECIPE_ALLOY_DAM_STEEL).register(p);
        new UnplaceableBlock(Categories.ALLOYS, SlimefunItems.DURALUMIN_INGOT, DummySmeltery.TYPE, RECIPE_ALLOY_DURALIUM).register(p);
        new UnplaceableBlock(Categories.ALLOYS, SlimefunItems.BRONZE_INGOT, DummySmeltery.TYPE, RECIPE_ALLOY_BRONZE).register(p);
        new UnplaceableBlock(Categories.ALLOYS, SlimefunItems.ALUMINUM_BRONZE_INGOT, DummySmeltery.TYPE, RECIPE_ALLOY_ALU_BRONZE).register(p);
        new UnplaceableBlock(Categories.ALLOYS, SlimefunItems.HARDENED_METAL_INGOT, DummySmeltery.TYPE, RECIPE_ALLOY_HARD_METAL).register(p);
        new UnplaceableBlock(Categories.ALLOYS, SlimefunItems.CORINTHIAN_BRONZE_INGOT, DummySmeltery.TYPE, RECIPE_ALLOY_COR_BRONZE).register(p);
        new UnplaceableBlock(Categories.ALLOYS, SlimefunItems.SOLDER_INGOT, DummySmeltery.TYPE, RECIPE_ALLOY_SOLDER).register(p);
        new UnplaceableBlock(Categories.ALLOYS, SlimefunItems.BILLON_INGOT, DummySmeltery.TYPE, RECIPE_ALLOY_BILLON).register(p);
        new UnplaceableBlock(Categories.ALLOYS, SlimefunItems.BRASS_INGOT, DummySmeltery.TYPE, RECIPE_ALLOY_BRASS).register(p);
        new UnplaceableBlock(Categories.ALLOYS, SlimefunItems.ALUMINUM_BRASS_INGOT, DummySmeltery.TYPE, RECIPE_ALLOY_ALU_BRASS).register(p);
        new UnplaceableBlock(Categories.ALLOYS, SlimefunItems.NICKEL_INGOT, DummySmeltery.TYPE, RECIPE_ALLOY_NICKEL).register(p);
        new UnplaceableBlock(Categories.ALLOYS, SlimefunItems.COBALT_INGOT, DummySmeltery.TYPE, RECIPE_ALLOY_COBALT).register(p);
        new UnplaceableBlock(Categories.ALLOYS, SlimefunItems.REINFORCED_ALLOY_INGOT, DummySmeltery.TYPE, RECIPE_ALLOY_REINFORCED).register(p);

    }

}
