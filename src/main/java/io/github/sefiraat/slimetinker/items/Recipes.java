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

    protected static final ItemStack[] TINKERS_SMELTERY = new ItemStack[] {
            null,   null,   null,
            null,   null,   null,
            null,   null,   null
    };


    // endregion

}
