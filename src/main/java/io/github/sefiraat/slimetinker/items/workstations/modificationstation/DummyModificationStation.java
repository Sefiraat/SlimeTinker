package io.github.sefiraat.slimetinker.items.workstations.modificationstation;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.sefiraat.slimetinker.utils.enums.ThemeItemType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;

public final class DummyModificationStation {

    private DummyModificationStation() {
        throw new IllegalStateException("Utility class");
    }

    public static final SlimefunItemStack STACK = ThemeUtils.themedItemStack(
            "DUMMY_MODIFICATION_STATION",
            Material.GRINDSTONE,
            ThemeItemType.MACHINE,
            "Tinker's Modification Station",
            "Tools are augmented on the Modification",
            "station using the appropriate material.",
            "Once enough material has been added, the",
            "modification will level."
    );

    public static final RecipeType TYPE = new RecipeType(SlimeTinker.inst().getKeys().getWsDummyToolTable(), STACK);

}
