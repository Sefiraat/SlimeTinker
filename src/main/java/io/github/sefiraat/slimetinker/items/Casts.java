package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.machines.DummySmeltery;
import io.github.sefiraat.slimetinker.items.machines.TinkersSmeltery;
import io.github.sefiraat.slimetinker.items.recipes.RecipeManager;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.ChatColor;
import org.bukkit.Material;


public final class Casts {

    private Casts() {
        throw new IllegalStateException("Utility class");
    }

    public static final SlimefunItemStack CAST_BLOCK =
            ThemeUtils.themedItemStack(
                    "CAST_BLOCK",
                    Material.YELLOW_STAINED_GLASS_PANE,
                    ThemeUtils.ThemeItemType.CAST,
                    "Cast: Metal Block",
                    ThemeUtils.PASSIVE + "A cast for metals.",
                    "",
                    ThemeUtils.CLICK_INFO + "Input : " + ChatColor.WHITE + RecipeManager.AMOUNT_BLOCK + " Units",
                    ThemeUtils.CLICK_INFO + "Output : " + ChatColor.WHITE + "1 Block"
            );



    public static void set(SlimeTinker p) {

        new TinkersSmeltery(Categories.CASTS, CAST_BLOCK, DummySmeltery.TYPE, Recipes.CAST_BLOCK).register(p);

    }
}
