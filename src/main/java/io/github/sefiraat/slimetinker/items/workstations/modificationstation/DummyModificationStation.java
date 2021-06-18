package io.github.sefiraat.slimetinker.items.workstations.modificationstation;

import io.github.mooy1.infinitylib.recipes.RecipeMap;
import io.github.mooy1.infinitylib.recipes.ShapedRecipe;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class DummyModificationStation {

    private DummyModificationStation() {
        throw new IllegalStateException("Utility class");
    }

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "DUMMY_MODIFICATION_STATION",
            Material.GRINDSTONE,
            ThemeUtils.ITEM_MACHINE + "Tinker's Modification Station",
            "",
            ThemeUtils.PASSIVE + "Tools are augmented on the Modification",
            ThemeUtils.PASSIVE + "station using the appropriate material.",
            ThemeUtils.PASSIVE + "Once enough material has been added, the",
            ThemeUtils.PASSIVE + "modification will level.",
            "",
            ThemeUtils.LORE_TYPE_MACHINE
    );

    private static final RecipeMap<ItemStack> RECIPES = new RecipeMap<>(ShapedRecipe::new);
    public static final RecipeType TYPE = new RecipeType(SlimeTinker.inst().getKeys().getWsDummyTable(), STACK, RECIPES::put);

}
