package io.github.sefiraat.slimetinker.items.workstations.smeltery;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;

public final class DummySmelteryMolten {

    private DummySmelteryMolten() {
        throw new IllegalStateException("Utility class");
    }

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "DUMMY_TINKERS_SMELTERY_MOLTEN",
            Material.CHISELED_POLISHED_BLACKSTONE,
            ThemeUtils.ITEM_MACHINE + "Tinker's Smeltery",
            "",
            ThemeUtils.PASSIVE + "Molten metals are made by putting",
            ThemeUtils.PASSIVE + "items made from the metal into the",
            ThemeUtils.PASSIVE + "Smeltery. Items melt when provided",
            ThemeUtils.PASSIVE + "enough lava as a heat source.",
            "",
            ThemeUtils.LORE_TYPE_MACHINE
    );

    public static final RecipeType TYPE = new RecipeType(SlimeTinker.inst().getKeys().getWsDummySmelteryM(), STACK, "");

}
