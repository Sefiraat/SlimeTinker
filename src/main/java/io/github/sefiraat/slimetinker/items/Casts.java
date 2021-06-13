package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.items.recipes.RecipeManager;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.Locale;

public final class Casts {

    private Casts() {
        throw new IllegalStateException("Utility class");
    }

    public static final SlimefunItemStack CAST_BLOCK =
            ThemeUtils.themedItemStack(
                    "CAST_BLOCK",
                    Material.YELLOW_STAINED_GLASS_PANE,
                    ThemeUtils.SimpleItemType.CAST,
                    "Cast: Metal Block",
                    "",
                    ThemeUtils.PASSIVE + "A cast for metals.",
                    "",
                    ThemeUtils.CLICK_INFO + "Input : " + ChatColor.WHITE + RecipeManager.AMOUNT_BLOCK + " Units",
                    ThemeUtils.CLICK_INFO + "Output : " + ChatColor.WHITE + "1 Block",
                    "",
                    ThemeUtils.LORE_CAST
            );

}
