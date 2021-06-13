package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.machines.TinkersSmeltery;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;

public final class Machines {

    private Machines() {
        throw new IllegalStateException("Utility class");
    }

    // Tinkers Smeltery
    public static final SlimefunItemStack SMELTERY_CORE =
            ThemeUtils.themedItemStack(
                    "TINKERS_SMELTERY_CORE",
                    Material.SMITHING_TABLE,
                    ThemeUtils.SimpleItemType.MACHINE,
                    "Tinkers Smeltery Core",
                    "Melts down metals into liquids.",
                    "Metals can then be alloyed and",
                    "cast out into various forms.",
                    "Requires lava as fuel"
            );

    public static void set(SlimeTinker p) {

        new TinkersSmeltery(Categories.MACHINES, SMELTERY_CORE, RecipeType.ENHANCED_CRAFTING_TABLE, Recipes.MOLTEN_IRON).register(p);

    }


}
