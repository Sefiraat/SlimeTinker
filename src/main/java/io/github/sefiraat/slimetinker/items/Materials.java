package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.machines.DummySmeltery;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;

public final class Materials {

    private Materials() {
        throw new IllegalStateException("Utility class");
    }

    // region Molten Bucketed Metals

    // Molten Iron
    public static final SlimefunItemStack MOLTEN_IRON =
            ThemeUtils.themedItemStack(
                    "MOLTEN_IRON",
                    SkullTextures.BUCKET_WHITE,
                    ThemeUtils.ThemeItemType.MOLTEN_METAL,
                    "Molten Iron",
                    "A bucket of Molten Iron.",
                    "How on earth are you holding this?"
            );

    // Molten Gold
    public static final SlimefunItemStack MOLTEN_GOLD =
            ThemeUtils.themedItemStack(
                    "MOLTEN_GOLD",
                    SkullTextures.BUCKET_YELLOW,
                    ThemeUtils.ThemeItemType.MOLTEN_METAL,
                    "Molten Gold",
                    "A bucket of Molten Gold.",
                    "Costly, be careful not to spill it!"
            );

    // endregion


    // region Crafting Materials

    public static final SlimefunItemStack SEARED_STONE =
            ThemeUtils.themedItemStack(
                    "SEARED_STONE",
                    Material.POLISHED_BASALT,
                    ThemeUtils.ThemeItemType.MOLTEN_METAL,
                    "Seared Stone",
                    "A heat-resistant stone that can",
                    "be used to make up the walls of a smeltery."
            );

    // endregion
    
    // region Custom Cast Nuggets

    public static final SlimefunItemStack NUGGET_CAST_COPPER =
            ThemeUtils.themedItemStack(
                    "NUGGET_CAST_COPPER",
                    Material.IRON_NUGGET,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Copper Nugget",
                    "A nugget made from solid copper"
            );

    public static final SlimefunItemStack NUGGET_CAST_TIN =
            ThemeUtils.themedItemStack(
                    "NUGGET_CAST_TIN",
                    Material.IRON_NUGGET,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Tin Nugget",
                    "A nugget made from solid tin"
            );

    public static final SlimefunItemStack NUGGET_CAST_ZINC =
            ThemeUtils.themedItemStack(
                    "NUGGET_CAST_ZINC",
                    Material.IRON_NUGGET,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Zinc Nugget",
                    "A nugget made from solid zinc"
            );

    public static final SlimefunItemStack NUGGET_CAST_ALUMINIUM =
            ThemeUtils.themedItemStack(
                    "NUGGET_CAST_ALUMINIUM",
                    Material.IRON_NUGGET,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Aluminium Nugget",
                    "A nugget made from solid aluminium"
            );

    public static final SlimefunItemStack NUGGET_CAST_MAGNESIUM =
            ThemeUtils.themedItemStack(
                    "NUGGETCAST_MAGNESIUM",
                    Material.IRON_NUGGET,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Magnesium Nugget",
                    "A nugget made from solid magnesium"
            );

    public static final SlimefunItemStack NUGGET_CAST_LEAD =
            ThemeUtils.themedItemStack(
                    "NUGGET_CAST_LEAD",
                    Material.IRON_NUGGET,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Lead Nugget",
                    "A nugget made from solid lead"
            );

    public static final SlimefunItemStack NUGGET_CAST_SILVER =
            ThemeUtils.themedItemStack(
                    "NUGGET_CAST_SILVER",
                    Material.IRON_NUGGET,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Silver Nugget",
                    "A nugget made from solid silver"
            );

    public static final SlimefunItemStack NUGGET_CAST_COAL =
            ThemeUtils.themedItemStack(
                    "NUGGET_CAST_COAL",
                    Material.INK_SAC,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Coal Nugget",
                    "A nugget made from liquifacted coal"
            );


    // endregion

    // region Custom Cast Blocks
        
    public static final SlimefunItemStack BLOCK_CAST_COPPER =
            ThemeUtils.themedItemStack(
                    "BLOCK_CAST_COPPER",
                    Material.TERRACOTTA,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Copper Block",
                    "A block made from solid copper"
            );

    public static final SlimefunItemStack BLOCK_CAST_TIN =
            ThemeUtils.themedItemStack(
                    "BLOCK_CAST_TIN",
                    Material.IRON_BLOCK,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Tin Block",
                    "A block made from solid tin"
            );

    public static final SlimefunItemStack BLOCK_CAST_ZINC =
            ThemeUtils.themedItemStack(
                    "BLOCK_CAST_ZINC",
                    Material.IRON_BLOCK,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Zinc Block",
                    "A block made from solid zinc"
            );

    public static final SlimefunItemStack BLOCK_CAST_ALUMINIUM =
            ThemeUtils.themedItemStack(
                    "BLOCK_CAST_ALUMINIUM",
                    Material.IRON_BLOCK,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Aluminium Block",
                    "A block made from solid aluminium"
            );

    public static final SlimefunItemStack BLOCK_CAST_MAGNESIUM =
            ThemeUtils.themedItemStack(
                    "BLOCK_CAST_MAGNESIUM",
                    Material.PINK_TERRACOTTA,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Magnesium Block",
                    "A block made from solid magnesium"
            );

    public static final SlimefunItemStack BLOCK_CAST_LEAD =
            ThemeUtils.themedItemStack(
                    "BLOCK_CAST_LEAD",
                    Material.PURPLE_TERRACOTTA,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Lead Block",
                    "A block made from solid lead"
            );

    public static final SlimefunItemStack BLOCK_CAST_SILVER =
            ThemeUtils.themedItemStack(
                    "BLOCK_CAST_SILVER",
                    Material.IRON_BLOCK,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Silver Block",
                    "A block made from solid silver"
            );


    // endregion

    public static void set(SlimeTinker p) {

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_COPPER, DummySmeltery.TYPE, Recipes.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_COPPER, DummySmeltery.TYPE, Recipes.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_LEAD, DummySmeltery.TYPE, Recipes.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_LEAD, DummySmeltery.TYPE, Recipes.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_SILVER, DummySmeltery.TYPE, Recipes.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_SILVER, DummySmeltery.TYPE, Recipes.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_ALUMINIUM, DummySmeltery.TYPE, Recipes.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_ALUMINIUM, DummySmeltery.TYPE, Recipes.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_MAGNESIUM, DummySmeltery.TYPE, Recipes.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_MAGNESIUM, DummySmeltery.TYPE, Recipes.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_ZINC, DummySmeltery.TYPE, Recipes.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_ZINC, DummySmeltery.TYPE, Recipes.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_TIN, DummySmeltery.TYPE, Recipes.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_TIN, DummySmeltery.TYPE, Recipes.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

    }


}
