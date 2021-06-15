package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.machines.smeltery.TinkersSmeltery;
import io.github.sefiraat.slimetinker.items.machines.workbench.Workbench;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;

public final class Machines {

    private Machines() {
        throw new IllegalStateException("Utility class");
    }

    // Tinkers Smeltery
    public static final SlimefunItemStack TINKERS_SMELTERY_CORE =
            ThemeUtils.themedItemStack(
                    "TINKERS_SMELTERY_CORE",
                    Material.CHISELED_POLISHED_BLACKSTONE,
                    ThemeUtils.ThemeItemType.MACHINE,
                    "Tinkers Smeltery Core",
                    "Melts down metals into liquids.",
                    "Metals can then be alloyed and",
                    "cast out into various forms.",
                    "Requires lava as fuel"
            );

    // Workbench
    public static final SlimefunItemStack TINKERS_WORKBENCH =
            ThemeUtils.themedItemStack(
                    "TINKERS_WORKBENCH",
                    Material.CRAFTING_TABLE,
                    ThemeUtils.ThemeItemType.MACHINE,
                    "Tinkers Workbench",
                    "Used for crafting various items",
                    "and parts for Tinker's tools and",
                    "constructions."
            );

    public static void set(SlimeTinker p) {

        new TinkersSmeltery(Categories.MACHINES, TINKERS_SMELTERY_CORE, RecipeType.ENHANCED_CRAFTING_TABLE, Recipes.MOLTEN_IRON).register(p);
        new Workbench(Categories.MACHINES, TINKERS_WORKBENCH, RecipeType.ENHANCED_CRAFTING_TABLE, Recipes.MOLTEN_IRON).register(p);

    }


}
