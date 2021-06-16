package io.github.sefiraat.slimetinker.items.workstations.table;

import io.github.mooy1.infinitylib.recipes.RecipeMap;
import io.github.mooy1.infinitylib.recipes.ShapedRecipe;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class DummyTable {

    private DummyTable() {
        throw new IllegalStateException("Utility class");
    }

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "DUMMY_TINKERS_TABLE",
            Material.SMITHING_TABLE,
            ThemeUtils.ITEM_MACHINE + "Tinker's Table",
            "",
            ThemeUtils.PASSIVE + "This item is made on a Tinker's Table.",
            "",
            ThemeUtils.LORE_TYPE_MACHINE
    );

    private static final RecipeMap<ItemStack> RECIPES = new RecipeMap<>(ShapedRecipe::new);
    public static final RecipeType TYPE = new RecipeType(SlimeTinker.inst().getKeys().getWsDummyTable(), STACK, RECIPES::put);

}
