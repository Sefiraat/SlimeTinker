package io.github.sefiraat.slimetinker.items.workstations.armourtable;

import io.github.mooy1.infinitylib.recipes.RecipeMap;
import io.github.mooy1.infinitylib.recipes.ShapedRecipe;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class DummyArmourTable {

    private DummyArmourTable() {
        throw new IllegalStateException("Utility class");
    }

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "DUMMY_TINKERS_ARMOUR_TABLE",
            Material.CHISELED_NETHER_BRICKS,
            ThemeUtils.ITEM_MACHINE + "Tinker's Armour Table",
            "",
            ThemeUtils.PASSIVE + "This item is made on a Tinker's Armour Table.",
            "",
            ThemeUtils.LORE_TYPE_MACHINE
    );

    private static final RecipeMap<ItemStack> RECIPES = new RecipeMap<>(ShapedRecipe::new);
    public static final RecipeType TYPE = new RecipeType(SlimeTinker.inst().getKeys().getWsDummyArmourTable(), STACK, RECIPES::put);

}
