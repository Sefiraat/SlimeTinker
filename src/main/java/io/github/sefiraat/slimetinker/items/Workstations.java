package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.workstations.modificationstation.ModificationStation;
import io.github.sefiraat.slimetinker.items.workstations.repairbench.RepairBench;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.TinkersSmeltery;
import io.github.sefiraat.slimetinker.items.workstations.table.Table;
import io.github.sefiraat.slimetinker.items.workstations.workbench.Workbench;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class Workstations {

    private Workstations() {
        throw new IllegalStateException("Utility class");
    }

    // TODO Placeholder Recipes
    protected static final ItemStack[] RECIPE_TINKERS_SMELTERY_CORE = new ItemStack[] {
            null,   null,   null,
            null,   null,   null,
            null,   null,   null
    };
    protected static final ItemStack[] RECIPE_TINKERS_WORKBENCH = new ItemStack[] {
            null,   null,   null,
            null,   null,   null,
            null,   null,   null
    };
    protected static final ItemStack[] RECIPE_TINKERS_TABLE = new ItemStack[] {
            null,   null,   null,
            null,   null,   null,
            null,   null,   null
    };
    protected static final ItemStack[] RECIPE_TINKERS_REPAIR_BENCH = new ItemStack[] {
            null,   null,   null,
            null,   null,   null,
            null,   null,   null
    };
    protected static final ItemStack[] RECIPE_TINKERS_MOD_STATION = new ItemStack[] {
            null,   null,   null,
            null,   null,   null,
            null,   null,   null
    };

    // Tinkers Smeltery
    public static final SlimefunItemStack TINKERS_SMELTERY_CORE =
            ThemeUtils.themedItemStack(
                    "TINKERS_SMELTERY_CORE",
                    Material.CHISELED_POLISHED_BLACKSTONE,
                    ThemeUtils.ThemeItemType.MACHINE,
                    "Tinker's Smeltery Core",
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
                    "Tinker's Workbench",
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
                    "Tinker's Table",
                    "Combines parts into tools."
            );

    // Repair
    public static final SlimefunItemStack TINKERS_REPAIR_BENCH =
            ThemeUtils.themedItemStack(
                    "TINKERS_REPAIR_BENCH",
                    Material.CARTOGRAPHY_TABLE,
                    ThemeUtils.ThemeItemType.MACHINE,
                    "Tinker's Repair Bench",
                    "Repairs tools and weapons."
            );

    // Modification
    public static final SlimefunItemStack TINKERS_MOD_STATION =
            ThemeUtils.themedItemStack(
                    "TINKERS_MOD_STATION",
                    Material.GRINDSTONE,
                    ThemeUtils.ThemeItemType.MACHINE,
                    "Tinker's Modification Station",
                    "Applies modifications to tools and weapons."
            );

    public static void set(SlimeTinker p) {

        new Workbench(Categories.WORKSTATIONS, TINKERS_WORKBENCH, RecipeType.ENHANCED_CRAFTING_TABLE, RECIPE_TINKERS_WORKBENCH).register(p);
        new TinkersSmeltery(Categories.WORKSTATIONS, TINKERS_SMELTERY_CORE, Workbench.TYPE, RECIPE_TINKERS_SMELTERY_CORE).register(p);
        new Table(Categories.WORKSTATIONS, TINKERS_TABLE, Workbench.TYPE, RECIPE_TINKERS_TABLE).register(p);
        new RepairBench(Categories.WORKSTATIONS, TINKERS_REPAIR_BENCH, Workbench.TYPE, RECIPE_TINKERS_REPAIR_BENCH).register(p);
        new ModificationStation(Categories.WORKSTATIONS, TINKERS_MOD_STATION, Workbench.TYPE, RECIPE_TINKERS_MOD_STATION).register(p);

    }


}
