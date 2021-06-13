package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;

public final class Materials {

    private Materials() {
        throw new IllegalStateException("Utility class");
    }

    // region Molten Metals

    // Molten Iron
    public static final SlimefunItemStack MOLTEN_IRON =
            ThemeUtils.themedItemStack(
                    "MOLTEN_IRON",
                    SkullTextures.BUCKET_WHITE,
                    ThemeUtils.SimpleItemType.MOLTEN_METAL,
                    "Molten Iron",
                    "A bucket of Molten Iron.",
                    "How on earth are you holding this?"
            );

    // Molten Gold
    public static final SlimefunItemStack MOLTEN_GOLD =
            ThemeUtils.themedItemStack(
                    "MOLTEN_GOLD",
                    SkullTextures.BUCKET_YELLOW,
                    ThemeUtils.SimpleItemType.MOLTEN_METAL,
                    "Molten Gold",
                    "A bucket of Molten Gold.",
                    "Costly, be careful not to spill it!"
            );

    // endregion

    public static final SlimefunItemStack SEARED_STONE =
            ThemeUtils.themedItemStack(
                    "SEARED_STONE",
                    Material.POLISHED_BASALT,
                    ThemeUtils.SimpleItemType.MOLTEN_METAL,
                    "Seared Stone",
                    "A heat-resistant stone that can",
                    "be used to make up the walls of a smeltery."
            );

    public static void set(SlimeTinker p) {
        new UnplaceableBlock(Categories.METALS, MOLTEN_IRON, RecipeType.ENHANCED_CRAFTING_TABLE, Recipes.MOLTEN_IRON).register(p);
        new UnplaceableBlock(Categories.METALS, MOLTEN_GOLD, RecipeType.ENHANCED_CRAFTING_TABLE, Recipes.MOLTEN_GOLD).register(p);
    }


}
