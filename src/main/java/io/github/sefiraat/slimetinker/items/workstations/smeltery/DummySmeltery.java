package io.github.sefiraat.slimetinker.items.workstations.smeltery;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.sefiraat.slimetinker.utils.enums.ThemeItemType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;

public final class DummySmeltery {

    private DummySmeltery() {
        throw new IllegalStateException("Utility class");
    }

    public static final SlimefunItemStack STACK = ThemeUtils.themedItemStack(
            "DUMMY_TINKERS_SMELTERY",
            Material.CHISELED_POLISHED_BLACKSTONE,
            ThemeItemType.MACHINE,
            "Tinker's Smeltery",
            "This item is cast out from the",
            "tinkers smeltery using the",
            "relevant cast and metal/liquid."
    );

    public static final RecipeType TYPE = new RecipeType(SlimeTinker.inst().getKeys().getWsDummySmeltery(), STACK);

}
