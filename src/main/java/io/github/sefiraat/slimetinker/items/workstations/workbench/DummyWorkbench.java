package io.github.sefiraat.slimetinker.items.workstations.workbench;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;

public final class DummyWorkbench {

    private DummyWorkbench() {
        throw new IllegalStateException("Utility class");
    }

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "DUMMY_TINKERS_SMELTERY",
            Material.FLETCHING_TABLE,
            ThemeUtils.ITEM_MACHINE + "ToolTable",
            "",
            ThemeUtils.PASSIVE + "This item is crafted in the workbench.",
            "",
            ThemeUtils.LORE_TYPE_MACHINE
    );

    public static final RecipeType TYPE = new RecipeType(SlimeTinker.inst().getKeys().getWsDummyWorkbench(), STACK, "");

}
