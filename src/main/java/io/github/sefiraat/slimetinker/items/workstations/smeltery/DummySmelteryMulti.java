package io.github.sefiraat.slimetinker.items.workstations.smeltery;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class DummySmelteryMulti {

    private DummySmelteryMulti() {
        throw new IllegalStateException("Utility class");
    }

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "DUMMY_TINKERS_SMELTERY_MULTI",
            Material.CHISELED_POLISHED_BLACKSTONE,
            ThemeUtils.ITEM_MACHINE + "Tinker's Smeltery",
            "",
            "This is a multiblock, build in the world",
            "as shown here.",
            ThemeUtils.LORE_TYPE_MACHINE
    );

    public static final RecipeType TYPE = new RecipeType(SlimeTinker.inst().getKeys().getWsDummySmelteryA(), STACK, "");

}
