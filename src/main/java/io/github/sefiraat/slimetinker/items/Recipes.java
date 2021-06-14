package io.github.sefiraat.slimetinker.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class Recipes {

    private Recipes() {
        throw new IllegalStateException("Utility class");
    }

    // region Molten Metals

    protected static final ItemStack[] MOLTEN_IRON = new ItemStack[] {
            null,   null,                                           null,
            null,   new ItemStack(Material.IRON_INGOT, 4),   null,
            null,   null,                                           null
    };

    protected static final ItemStack[] MOLTEN_GOLD = new ItemStack[] {
            null,   null,                                           null,
            null,   new ItemStack(Material.GOLD_INGOT, 4),   null,
            null,   null,                                           null
    };

    // endregion

    // region Machines

    protected static final ItemStack[] TINKERS_SMELTERY_CORE = new ItemStack[] {
            null,   null,   null,
            null,   null,   null,
            null,   null,   null
    };


    // endregion

    // region Dies

    protected static final ItemStack[] DIE_AXE_HEAD = new ItemStack[] {
            new ItemStack(Material.COBBLESTONE),    new ItemStack(Material.COBBLESTONE),    null,
            new ItemStack(Material.COBBLESTONE),    null,                                   null,
            null,                                   null,                                   null
    };

    //

    // region Casts

    protected static final ItemStack[] CAST_NUGGET = new ItemStack[] {
            new ItemStack(Material.GOLD_INGOT, 2),   new ItemStack(Material.IRON_NUGGET),   null,
            null,                                           null,   null,
            null,                                           null,   null
    };

    protected static final ItemStack[] CAST_INGOT = new ItemStack[] {
            new ItemStack(Material.GOLD_INGOT, 2),   new ItemStack(Material.IRON_INGOT),   null,
            null,                                           null,   null,
            null,                                           null,   null
    };

    protected static final ItemStack[] CAST_BLOCK = new ItemStack[] {
            new ItemStack(Material.GOLD_INGOT, 2),   new ItemStack(Material.STONE),   null,
            null,                                           null,   null,
            null,                                           null,   null
    };

    protected static final ItemStack[] CAST_GEM = new ItemStack[] {
            new ItemStack(Material.GOLD_INGOT, 2),   new ItemStack(Material.DIAMOND),   null,
            null,                                           null,   null,
            null,                                           null,   null
    };

    protected static final ItemStack[] CAST_AXEHEAD = new ItemStack[] {
            new ItemStack(Material.GOLD_INGOT, 2),   Casts.DIE_AXEHEAD,   null,
            null,                                           null,   null,
            null,                                           null,   null
    };

    // endregion

    protected static ItemStack[] getDummyCastRecipe(ItemStack cast) {
        return new ItemStack[]{
                null, null, null,
                null, cast, null,
                null, null, null
        };
    }

}
