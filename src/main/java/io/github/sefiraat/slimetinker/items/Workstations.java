package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.TinkersSmeltery;
import io.github.sefiraat.slimetinker.items.workstations.table.Table;
import io.github.sefiraat.slimetinker.items.workstations.workbench.Workbench;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;

public final class Workstations {

    private Workstations() {
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
                    Material.FLETCHING_TABLE,
                    ThemeUtils.ThemeItemType.MACHINE,
                    "Tinkers Workbench",
                    "Used for crafting various items",
                    "and parts for Tinker's tools and",
                    "constructions."
            );

    // Table
    public static final SlimefunItemStack TINKERS_TABLE =
            ThemeUtils.themedItemStack(
                    "TINKERS_TABLE",
                    Material.SMITHING_TABLE,
                    ThemeUtils.ThemeItemType.MACHINE,
                    "Tinkers Table",
                    "Combines parts into tools."
            );

    public static void set(SlimeTinker p) {

        new Workbench(Categories.WORKSTATIONS, TINKERS_WORKBENCH, RecipeType.ENHANCED_CRAFTING_TABLE, Recipes.TINKERS_WORKBENCH).register(p);
        new TinkersSmeltery(Categories.WORKSTATIONS, TINKERS_SMELTERY_CORE, Workbench.TYPE, Recipes.TINKERS_SMELTERY_CORE).register(p);
        new Table(Categories.WORKSTATIONS, TINKERS_TABLE, Workbench.TYPE, Recipes.TINKERS_TABLE).register(p);

    }


}
