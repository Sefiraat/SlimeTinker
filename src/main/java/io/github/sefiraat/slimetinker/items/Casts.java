package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.machines.DummySmeltery;
import io.github.sefiraat.slimetinker.items.recipes.RecipeManager;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.ChatColor;
import org.bukkit.Material;


public final class Casts {

    private Casts() {
        throw new IllegalStateException("Utility class");
    }

    // region Crafted Dies

    public static final SlimefunItemStack DIE_AXEHEAD =
            ThemeUtils.themedItemStack(
                    "DIE_AXEHEAD",
                    SkullTextures.PART_AXE_HEAD,
                    ThemeUtils.ThemeItemType.CAST,
                    "Die: Stone Axe Head",
                    ThemeUtils.PASSIVE + "A die to create a cast from"
            );

    // region Casts

    public static final SlimefunItemStack CAST_NUGGET =
            ThemeUtils.themedItemStack(
                    "CAST_NUGGET",
                    Material.YELLOW_STAINED_GLASS_PANE,
                    ThemeUtils.ThemeItemType.CAST,
                    "Cast: Metal Nugget",
                    ThemeUtils.PASSIVE + "A cast for metals.",
                    "",
                    ThemeUtils.CLICK_INFO + "Input : " + ChatColor.WHITE + RecipeManager.AMOUNT_NUGGET + " Units",
                    ThemeUtils.CLICK_INFO + "Output : " + ChatColor.WHITE + "1 Nugget"
            );

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

    public static final SlimefunItemStack CAST_INGOT =
            ThemeUtils.themedItemStack(
                    "CAST_INGOT",
                    Material.YELLOW_STAINED_GLASS_PANE,
                    ThemeUtils.ThemeItemType.CAST,
                    "Cast: Metal Ingot",
                    ThemeUtils.PASSIVE + "A cast for metals.",
                    "",
                    ThemeUtils.CLICK_INFO + "Input : " + ChatColor.WHITE + RecipeManager.AMOUNT_INGOT + " Units",
                    ThemeUtils.CLICK_INFO + "Output : " + ChatColor.WHITE + "1 Block"
            );

    public static final SlimefunItemStack CAST_GEM =
            ThemeUtils.themedItemStack(
                    "CAST_GEM",
                    Material.YELLOW_STAINED_GLASS_PANE,
                    ThemeUtils.ThemeItemType.CAST,
                    "Cast: Gem",
                    ThemeUtils.PASSIVE + "A cast for non-metallic liquids.",
                    "",
                    ThemeUtils.CLICK_INFO + "Input : " + ChatColor.WHITE + RecipeManager.AMOUNT_GEM + " Units",
                    ThemeUtils.CLICK_INFO + "Output : " + ChatColor.WHITE + "1 Gem"
            );

    public static final SlimefunItemStack CAST_AXEHEAD =
            ThemeUtils.themedItemStack(
                    "CAST_AXEHEAD",
                    Material.YELLOW_STAINED_GLASS_PANE,
                    ThemeUtils.ThemeItemType.CAST,
                    "Cast: Axe Head",
                    ThemeUtils.PASSIVE + "A cast for metals.",
                    "",
                    ThemeUtils.CLICK_INFO + "Input : " + ChatColor.WHITE + RecipeManager.AMOUNT_AXEHEAD + " Units",
                    ThemeUtils.CLICK_INFO + "Output : " + ChatColor.WHITE + "1 Axe Head"
            );

    // end region




    public static void set(SlimeTinker p) {

        new UnplaceableBlock(Categories.CASTS, DIE_AXEHEAD, RecipeType.ENHANCED_CRAFTING_TABLE, Recipes.DIE_AXE_HEAD).register(p);

        new UnplaceableBlock(Categories.CASTS, CAST_NUGGET, DummySmeltery.TYPE, Recipes.CAST_NUGGET).register(p);
        new UnplaceableBlock(Categories.CASTS, CAST_INGOT, DummySmeltery.TYPE, Recipes.CAST_INGOT).register(p);
        new UnplaceableBlock(Categories.CASTS, CAST_BLOCK, DummySmeltery.TYPE, Recipes.CAST_BLOCK).register(p);
        new UnplaceableBlock(Categories.CASTS, CAST_GEM, DummySmeltery.TYPE, Recipes.CAST_GEM).register(p);
        new UnplaceableBlock(Categories.CASTS, CAST_AXEHEAD, DummySmeltery.TYPE, Recipes.CAST_AXEHEAD).register(p);

    }
}
