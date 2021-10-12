package io.github.sefiraat.slimetinker.items.workstations.workbench;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.sefiraat.slimetinker.utils.enums.ThemeItemType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;

public final class DummyWorkbench {

    public static final SlimefunItemStack STACK = ThemeUtils.themedItemStack(
        "DUMMY_TINKERS_SMELTERY",
        Material.FLETCHING_TABLE,
        ThemeItemType.MACHINE,
        "ToolTable",
        "This item is crafted in the workbench."
    );
    public static final RecipeType TYPE = new RecipeType(SlimeTinker.inst().getKeys().getWsDummyWorkbench(), STACK);

    private DummyWorkbench() {
        throw new IllegalStateException("Utility class");
    }

}
