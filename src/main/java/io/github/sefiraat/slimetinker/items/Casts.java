package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.DummySmeltery;
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

    public static final String DIE_DESC = "A die to create a cast from";
    public static final String CAST_DESC = "A cast for metals.";
    public static final String INPUT_DESC = "Input : ";
    public static final String OUTPUT_DESC = "Output : ";
    public static final String UNIT_DESC = " Units";
    
    // region Crafted Dies

    public static final SlimefunItemStack DIE_SHOVEL_HEAD =
            ThemeUtils.themedItemStack(
                    "DIE_SHOVEL_HEAD",
                    SkullTextures.PART_SHOVEL_HEAD,
                    ThemeUtils.ThemeItemType.CAST,
                    "Die: Stone Shovel Head",
                    ThemeUtils.PASSIVE + DIE_DESC
            );

    public static final SlimefunItemStack DIE_PICKAXE_HEAD =
            ThemeUtils.themedItemStack(
                    "DIE_PICKAXE_HEAD",
                    SkullTextures.PART_PICKAXE_HEAD,
                    ThemeUtils.ThemeItemType.CAST,
                    "Die: Stone Pickaxe Head",
                    ThemeUtils.PASSIVE + DIE_DESC
            );

    public static final SlimefunItemStack DIE_AXE_HEAD =
            ThemeUtils.themedItemStack(
                    "DIE_AXE_HEAD",
                    SkullTextures.PART_AXE_HEAD,
                    ThemeUtils.ThemeItemType.CAST,
                    "Die: Stone Axe Head",
                    ThemeUtils.PASSIVE + DIE_DESC
            );

    public static final SlimefunItemStack DIE_HOE_HEAD =
            ThemeUtils.themedItemStack(
                    "DIE_HOE_HEAD",
                    SkullTextures.PART_HOE_HEAD,
                    ThemeUtils.ThemeItemType.CAST,
                    "Die: Stone Hoe Head",
                    ThemeUtils.PASSIVE + DIE_DESC
            );

    public static final SlimefunItemStack DIE_SWORD_BLADE =
            ThemeUtils.themedItemStack(
                    "DIE_SWORD_BLADE",
                    SkullTextures.PART_SWORD_BLADE,
                    ThemeUtils.ThemeItemType.CAST,
                    "Die: Stone Axe Head",
                    ThemeUtils.PASSIVE + DIE_DESC
            );

    public static final SlimefunItemStack DIE_TOOL_ROD =
            ThemeUtils.themedItemStack(
                    "DIE_TOOL_ROD",
                    SkullTextures.PART_TOOL_ROD,
                    ThemeUtils.ThemeItemType.CAST,
                    "Die: Tool Rod",
                    ThemeUtils.PASSIVE + DIE_DESC
            );

    // region Casts

    public static final SlimefunItemStack CAST_NUGGET =
            ThemeUtils.themedItemStack(
                    "CAST_NUGGET",
                    Material.YELLOW_CARPET,
                    ThemeUtils.ThemeItemType.CAST,
                    "Cast: Metal Nugget",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + RecipeManager.AMOUNT_NUGGET + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Nugget"
            );

    public static final SlimefunItemStack CAST_BLOCK =
            ThemeUtils.themedItemStack(
                    "CAST_BLOCK",
                    Material.YELLOW_CARPET,
                    ThemeUtils.ThemeItemType.CAST,
                    "Cast: Metal Block",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + RecipeManager.AMOUNT_BLOCK + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Block"
            );

    public static final SlimefunItemStack CAST_INGOT =
            ThemeUtils.themedItemStack(
                    "CAST_INGOT",
                    Material.YELLOW_CARPET,
                    ThemeUtils.ThemeItemType.CAST,
                    "Cast: Metal Ingot",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + RecipeManager.AMOUNT_INGOT + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Block"
            );

    public static final SlimefunItemStack CAST_GEM =
            ThemeUtils.themedItemStack(
                    "CAST_GEM",
                    Material.YELLOW_CARPET,
                    ThemeUtils.ThemeItemType.CAST,
                    "Cast: Gem",
                    ThemeUtils.PASSIVE + "A cast for non-metallic liquids.",
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + RecipeManager.AMOUNT_GEM + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Gem"
            );

    public static final SlimefunItemStack CAST_SHOVELHEAD =
            ThemeUtils.themedItemStack(
                    "CAST_SHOVELHEAD",
                    Material.ORANGE_CARPET,
                    ThemeUtils.ThemeItemType.CAST,
                    "Cast: Shovel Head",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + RecipeManager.AMOUNT_SHOVELHEAD + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Shovel Head"
            );

    public static final SlimefunItemStack CAST_PICKAXEHEAD =
            ThemeUtils.themedItemStack(
                    "CAST_PICKAXEHEAD",
                    Material.ORANGE_CARPET,
                    ThemeUtils.ThemeItemType.CAST,
                    "Cast: Pickaxe Head",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + RecipeManager.AMOUNT_PICKAXEHEAD + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Pickaxe Head"
            );

    public static final SlimefunItemStack CAST_AXEHEAD =
            ThemeUtils.themedItemStack(
                    "CAST_AXE_HEAD",
                    Material.ORANGE_CARPET,
                    ThemeUtils.ThemeItemType.CAST,
                    "Cast: Axe Head",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + RecipeManager.AMOUNT_AXEHEAD + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Axe Head"
            );

    public static final SlimefunItemStack CAST_HOEHEAD =
            ThemeUtils.themedItemStack(
                    "CAST_HOEHEAD",
                    Material.ORANGE_CARPET,
                    ThemeUtils.ThemeItemType.CAST,
                    "Cast: Hoe Head",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + RecipeManager.AMOUNT_HOEHEAD + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Hoe Head"
            );

    public static final SlimefunItemStack CAST_SWORDBLADE =
            ThemeUtils.themedItemStack(
                    "CAST_SWORDBLADE",
                    Material.ORANGE_CARPET,
                    ThemeUtils.ThemeItemType.CAST,
                    "Cast: Sword Blade",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + RecipeManager.AMOUNT_SWORDBLADE + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Sword Blade"
            );

    public static final SlimefunItemStack CAST_TOOLROD =
            ThemeUtils.themedItemStack(
                    "CAST_TOOLROD",
                    Material.ORANGE_CARPET,
                    ThemeUtils.ThemeItemType.CAST,
                    "Cast: Tool Rod",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + RecipeManager.AMOUNT_TOOLROD + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Tool Rod"
            );


    // end region




    public static void set(SlimeTinker p) {

        new UnplaceableBlock(Categories.CASTS, DIE_SHOVEL_HEAD, RecipeType.ENHANCED_CRAFTING_TABLE, Recipes.DIE_SHOVEL_HEAD).register(p);
        new UnplaceableBlock(Categories.CASTS, DIE_PICKAXE_HEAD, RecipeType.ENHANCED_CRAFTING_TABLE, Recipes.DIE_PICKAXE_HEAD).register(p);
        new UnplaceableBlock(Categories.CASTS, DIE_AXE_HEAD, RecipeType.ENHANCED_CRAFTING_TABLE, Recipes.DIE_AXE_HEAD).register(p);
        new UnplaceableBlock(Categories.CASTS, DIE_HOE_HEAD, RecipeType.ENHANCED_CRAFTING_TABLE, Recipes.DIE_HOE_HEAD).register(p);
        new UnplaceableBlock(Categories.CASTS, DIE_SWORD_BLADE, RecipeType.ENHANCED_CRAFTING_TABLE, Recipes.DIE_SWORD_BLADE).register(p);
        new UnplaceableBlock(Categories.CASTS, DIE_TOOL_ROD , RecipeType.ENHANCED_CRAFTING_TABLE, Recipes.DIE_TOOL_ROD).register(p);

        new UnplaceableBlock(Categories.CASTS, CAST_NUGGET, DummySmeltery.TYPE, Recipes.CAST_NUGGET).register(p);
        new UnplaceableBlock(Categories.CASTS, CAST_INGOT, DummySmeltery.TYPE, Recipes.CAST_INGOT).register(p);
        new UnplaceableBlock(Categories.CASTS, CAST_BLOCK, DummySmeltery.TYPE, Recipes.CAST_BLOCK).register(p);
        new UnplaceableBlock(Categories.CASTS, CAST_GEM, DummySmeltery.TYPE, Recipes.CAST_GEM).register(p);
        new UnplaceableBlock(Categories.CASTS, CAST_SHOVELHEAD, DummySmeltery.TYPE, Recipes.CAST_SHOVEL_HEAD).register(p);
        new UnplaceableBlock(Categories.CASTS, CAST_PICKAXEHEAD, DummySmeltery.TYPE, Recipes.CAST_PICKAXE_HEAD).register(p);
        new UnplaceableBlock(Categories.CASTS, CAST_AXEHEAD, DummySmeltery.TYPE, Recipes.CAST_AXE_HEAD).register(p);
        new UnplaceableBlock(Categories.CASTS, CAST_HOEHEAD, DummySmeltery.TYPE, Recipes.CAST_HOE_HEAD).register(p);
        new UnplaceableBlock(Categories.CASTS, CAST_SWORDBLADE, DummySmeltery.TYPE, Recipes.CAST_SWORD_BLADE).register(p);
        new UnplaceableBlock(Categories.CASTS, CAST_TOOLROD, DummySmeltery.TYPE, Recipes.CAST_TOOL_ROD).register(p);

    }
}
