package io.github.sefiraat.slimetinker.items.machines.workbench;

import io.github.mooy1.infinitylib.recipes.RecipeMap;
import io.github.mooy1.infinitylib.recipes.ShapedRecipe;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class DummyWorkbench {

    private DummyWorkbench() {
        throw new IllegalStateException("Utility class");
    }

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "DUMMY_TINKERS_SMELTERY",
            Material.CHISELED_POLISHED_BLACKSTONE,
            ThemeUtils.ITEM_MACHINE + "Workbench",
            "",
            ThemeUtils.PASSIVE + "This item is crafted in the workbench.",
            "",
            ThemeUtils.LORE_TYPE_MACHINE
    );

    private static final RecipeMap<ItemStack> RECIPES = new RecipeMap<>(ShapedRecipe::new);
    public static final RecipeType TYPE = new RecipeType(new NamespacedKey(SlimeTinker.inst(), "dummy-workbench"), STACK, RECIPES::put);

}
