package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.DummySmeltery;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.TinkersSmeltery;
import io.github.sefiraat.slimetinker.items.workstations.workbench.Workbench;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

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

    public static final SlimefunItemStack NUGGET_CAST_ALUMINUM =
            ThemeUtils.themedItemStack(
                    "NUGGET_CAST_ALUMINUM",
                    Material.IRON_NUGGET,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Aluminum Nugget",
                    "A nugget made from solid aluminum"
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

    public static final SlimefunItemStack NUGGET_CAST_STEEL =
            ThemeUtils.themedItemStack(
                    "NUGGET_CAST_STEEL",
                    Material.IRON_NUGGET,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Steel Nugget",
                    "A nugget made from solid steel"
            );

    public static final SlimefunItemStack NUGGET_CAST_DAMASCUS_STEEL =
            ThemeUtils.themedItemStack(
                    "NUGGET_CAST_DAMASCUS_STEEL",
                    Material.IRON_NUGGET,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Damascus Steel Nugget",
                    "A nugget made from damascus steel"
            );

    public static final SlimefunItemStack NUGGET_CAST_DURALIUM =
            ThemeUtils.themedItemStack(
                    "NUGGET_CAST_DURALIUM",
                    Material.IRON_NUGGET,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Duralium Nugget",
                    "A nugget made from duralium"
            );

    public static final SlimefunItemStack NUGGET_CAST_BRONZE =
           ThemeUtils.themedItemStack(
                   "NUGGET_CAST_BRONZE",
                   Material.IRON_NUGGET,
                   ThemeUtils.ThemeItemType.CRAFTING,
                   "Bronze Nugget",
                   "A nugget made from bronze"
           );

    public static final SlimefunItemStack NUGGET_CAST_ALU_BRONZE =
          ThemeUtils.themedItemStack(
                  "NUGGET_CAST_ALU_BRONZE",
                  Material.IRON_NUGGET,
                  ThemeUtils.ThemeItemType.CRAFTING,
                  "Aluminum Bronze Nugget",
                  "A nugget made from aluminum bronze"
          );

    public static final SlimefunItemStack NUGGET_CAST_HARD_METAL =
            ThemeUtils.themedItemStack(
                    "NUGGET_CAST_HARD_METAL",
                    Material.IRON_NUGGET,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Hardened Metal Nugget",
                    "A nugget made from hardened metal"
            );

    public static final SlimefunItemStack NUGGET_CAST_COR_BRONZE =
            ThemeUtils.themedItemStack(
                    "NUGGET_CAST_COR_BRONZE",
                    Material.IRON_NUGGET,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Corinthian Bronze Nugget",
                    "A nugget made from corinthian bronze"
            );

    public static final SlimefunItemStack NUGGET_CAST_SOLDER =
            ThemeUtils.themedItemStack(
                    "NUGGET_CAST_SOLDER",
                    Material.IRON_NUGGET,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Solder Nugget",
                    "A nugget made from solder"
            );

    public static final SlimefunItemStack NUGGET_CAST_BILLON =
            ThemeUtils.themedItemStack(
                    "NUGGET_CAST_BILLON",
                    Material.IRON_NUGGET,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Billon Nugget",
                    "A nugget made from billon"
            );

    public static final SlimefunItemStack NUGGET_CAST_BRASS =
            ThemeUtils.themedItemStack(
                    "NUGGET_CAST_BRASS",
                    Material.IRON_NUGGET,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Brass Nugget",
                    "A nugget made from brass"
            );

    public static final SlimefunItemStack NUGGET_CAST_ALU_BRASS =
            ThemeUtils.themedItemStack(
                    "NUGGET_CAST_ALU_BRASS",
                    Material.IRON_NUGGET,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Aluminum Brass Nugget",
                    "A nugget made from aluminum brass"
            );

    public static final SlimefunItemStack NUGGET_CAST_NICKEL =
            ThemeUtils.themedItemStack(
                    "NUGGET_CAST_NICKEL",
                    Material.IRON_NUGGET,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Nickel Nugget",
                    "A nugget made from nickel"
            );

    public static final SlimefunItemStack NUGGET_CAST_COBALT =
            ThemeUtils.themedItemStack(
                    "NUGGET_CAST_COBALT",
                    Material.IRON_NUGGET,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Cobalt Nugget",
                    "A nugget made from cobalt"
            );

    public static final SlimefunItemStack NUGGET_CAST_REINFORCED =
            ThemeUtils.themedItemStack(
                    "NUGGET_CAST_REINFORCED",
                    Material.IRON_NUGGET,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Reinforced Alloy Nugget",
                    "A nugget made from reinforced alloy"
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

    public static final SlimefunItemStack BLOCK_CAST_ALUMINUM =
            ThemeUtils.themedItemStack(
                    "BLOCK_CAST_ALUMINUM",
                    Material.IRON_BLOCK,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Aluminum Block",
                    "A block made from solid aluminum"
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

    public static final SlimefunItemStack BLOCK_CAST_STEEL =
            ThemeUtils.themedItemStack(
                    "BLOCK_CAST_STEEL",
                    Material.IRON_BLOCK,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Steel Block",
                    "A block made from solid steel"
            );

    public static final SlimefunItemStack BLOCK_CAST_DAMASCUS_STEEL =
            ThemeUtils.themedItemStack(
                    "BLOCK_CAST_DAMASCUS_STEEL",
                    Material.IRON_BLOCK,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Damascus Steel Block",
                    "A block made from damascus steel"
            );

    public static final SlimefunItemStack BLOCK_CAST_DURALIUM =
            ThemeUtils.themedItemStack(
                    "BLOCK_CAST_DURALIUM",
                    Material.IRON_BLOCK,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Duralium Block",
                    "A block made from duralium"
            );

    public static final SlimefunItemStack BLOCK_CAST_BRONZE =
            ThemeUtils.themedItemStack(
                    "BLOCK_CAST_BRONZE",
                    Material.TERRACOTTA,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Bronze Block",
                    "A block made from bronze"
            );

    public static final SlimefunItemStack BLOCK_CAST_ALU_BRONZE =
            ThemeUtils.themedItemStack(
                    "BLOCK_CAST_ALU_BRONZE",
                    Material.TERRACOTTA,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Aluminum Bronze Block",
                    "A block made from aluminum bronze"
            );

    public static final SlimefunItemStack BLOCK_CAST_HARD_METAL =
            ThemeUtils.themedItemStack(
                    "BLOCK_CAST_HARD_METAL",
                    Material.IRON_BLOCK,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Hardened Metal Block",
                    "A block made from hardened metal"
            );
    public static final SlimefunItemStack BLOCK_CAST_COR_BRONZE =
            ThemeUtils.themedItemStack(
                    "BLOCK_CAST_COR_BRONZE",
                    Material.TERRACOTTA,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Corinthian Bronze Block",
                    "A block made from corinthian bronze"
            );

    public static final SlimefunItemStack BLOCK_CAST_SOLDER =
            ThemeUtils.themedItemStack(
                    "BLOCK_CAST_SOLDER",
                    Material.IRON_BLOCK,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Solder Block",
                    "A block made from solder"
            );

    public static final SlimefunItemStack BLOCK_CAST_BILLON =
            ThemeUtils.themedItemStack(
                    "BLOCK_CAST_BILLON",
                    Material.IRON_BLOCK,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Billon Block",
                    "A block made from billon"
            );

    public static final SlimefunItemStack BLOCK_CAST_BRASS =
            ThemeUtils.themedItemStack(
                    "BLOCK_CAST_BRASS",
                    Material.IRON_BLOCK,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Brass Block",
                    "A block made from brass"
            );

    public static final SlimefunItemStack BLOCK_CAST_ALU_BRASS =
            ThemeUtils.themedItemStack(
                    "BLOCK_CAST_ALU_BRASS",
                    Material.IRON_BLOCK,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Aluminum Brass Block",
                    "A block made from aluminum brass"
            );

    public static final SlimefunItemStack BLOCK_CAST_NICKEL =
            ThemeUtils.themedItemStack(
                    "BLOCK_CAST_NICKEL",
                    Material.IRON_BLOCK,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Nickel Block",
                    "A block made from nickel"
            );

    public static final SlimefunItemStack BLOCK_CAST_COBALT =
            ThemeUtils.themedItemStack(
                    "BLOCK_CAST_COBALT",
                    Material.IRON_BLOCK,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Cobalt Block",
                    "A block made from cobalt"
            );

    public static final SlimefunItemStack BLOCK_CAST_REINFORCED =
            ThemeUtils.themedItemStack(
                    "BLOCK_CAST_REINFORCED",
                    Material.IRON_BLOCK,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Reinforced Alloy Block",
                    "A block made from reinforced alloy"
            );

    public static final SlimefunItemStack MOD_PLATE =
            ThemeUtils.themedItemStack(
                    "MOD_PLATE",
                    Material.OBSIDIAN,
                    ThemeUtils.ThemeItemType.MOD,
                    "Reinforced Plate",
                    ThemeUtils.PASSIVE + "A modification for tools that gives.",
                    ThemeUtils.PASSIVE + "a chance to ignore tool damage."
            );

    public static final SlimefunItemStack GROUT =
            ThemeUtils.themedItemStack(
                    "GROUT",
                    Material.GRAVEL,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Grout",
                    ThemeUtils.PASSIVE + "Used to make seared bricks."
            );


    public static final SlimefunItemStack SEARED_BRICK =
            ThemeUtils.themedItemStack(
                    "SEARED_BRICK",
                    Material.BRICK,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Seared Brick",
                    ThemeUtils.PASSIVE + "Used in crafting smeltery blocks."
            );

    public static final SlimefunItemStack SMELTERY_CONTROLLER =
            ThemeUtils.themedItemStack(
                    "SMELTERY_CONTROLLER",
                    Material.CHISELED_POLISHED_BLACKSTONE,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Smeltery Controller",
                    ThemeUtils.PASSIVE + "Used in crafting smeltery blocks."
            );

    public static final SlimefunItemStack SEARED_TANK =
            ThemeUtils.themedItemStack(
                    "SEARED_TANK",
                    Material.BLACKSTONE_WALL,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Seared Tank",
                    ThemeUtils.PASSIVE + "Used in building the smeltery."
            );

    public static final SlimefunItemStack SPOUT =
            ThemeUtils.themedItemStack(
                    "SPOUT",
                    Material.POLISHED_BLACKSTONE_BRICK_WALL,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Seared Spout",
                    ThemeUtils.PASSIVE + "Used in building the smeltery."
            );

    public static final SlimefunItemStack SEARED_BRICK_BLOCK =
            ThemeUtils.themedItemStack(
                    "SEARED_BRICK_BLOCK",
                    Material.POLISHED_BLACKSTONE_BRICKS,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Seared Brick Block",
                    ThemeUtils.PASSIVE + "Used in building the smeltery."
            );

    protected static final ItemStack[] RECIPE_GROUT = new ItemStack[] {
            new ItemStack(Material.CLAY), new ItemStack(Material.SAND),  new ItemStack(Material.SAND),
            new ItemStack(Material.SAND), new ItemStack(Material.SAND), new ItemStack(Material.GRAVEL),
            new ItemStack(Material.GRAVEL), new ItemStack(Material.GRAVEL),  new ItemStack(Material.GRAVEL)
    };

    protected static final ItemStack[] RECIPE_SEARED_BRICK = new ItemStack[] {
            Materials.GROUT, null, null,
            null, null, null,
            null, null, null
    };

    protected static final ItemStack[] RECIPE_SEARED_BRICK_BLOCK = new ItemStack[] {
            Materials.SEARED_BRICK, Materials.SEARED_BRICK, null,
            Materials.SEARED_BRICK, Materials.SEARED_BRICK, null,
            null, null, null
    };

    protected static final ItemStack[] RECIPE_SMELTERY_CONTROLLER = new ItemStack[] {
            Materials.SEARED_BRICK,   Materials.SEARED_BRICK,   Materials.SEARED_BRICK,
            Materials.SEARED_BRICK,   null,                     Materials.SEARED_BRICK,
            Materials.SEARED_BRICK,   Materials.SEARED_BRICK,   Materials.SEARED_BRICK
    };

    protected static final ItemStack[] RECIPE_SMELTERY_SPOUT = new ItemStack[] {
            Materials.SEARED_BRICK,   null,   Materials.SEARED_BRICK,
            Materials.SEARED_BRICK,   null,   Materials.SEARED_BRICK,
            Materials.SEARED_BRICK,   null,   Materials.SEARED_BRICK
    };

    protected static final ItemStack[] RECIPE_SMELTERY_TANK = new ItemStack[] {
            Materials.SEARED_BRICK,   new ItemStack(Material.GLASS),   Materials.SEARED_BRICK,
            Materials.SEARED_BRICK,   new ItemStack(Material.GLASS),   Materials.SEARED_BRICK,
            Materials.SEARED_BRICK,   new ItemStack(Material.GLASS),   Materials.SEARED_BRICK
    };

    protected static final ItemStack[] RECIPE_REINFORCED_PLATE = new ItemStack[] {
            Materials.BLOCK_CAST_REINFORCED, Materials.BLOCK_CAST_REINFORCED,  Materials.BLOCK_CAST_REINFORCED,
            Materials.BLOCK_CAST_REINFORCED, new ItemStack(Material.OBSIDIAN), Materials.BLOCK_CAST_REINFORCED,
            Materials.BLOCK_CAST_REINFORCED, Materials.BLOCK_CAST_REINFORCED,  Materials.BLOCK_CAST_REINFORCED
    };





    // endregion

    public static void set(SlimeTinker p) {

        new UnplaceableBlock(Categories.MATERIALS, GROUT, Workbench.TYPE, RECIPE_GROUT).register(p);
        new UnplaceableBlock(Categories.MATERIALS, SEARED_BRICK, RecipeType.SMELTERY, RECIPE_SEARED_BRICK).register(p);
        new TinkersSmeltery(Categories.MATERIALS, SMELTERY_CONTROLLER, Workbench.TYPE, RECIPE_SMELTERY_CONTROLLER).register(p);
        new SlimefunItem(Categories.MATERIALS, SEARED_TANK, Workbench.TYPE, RECIPE_SMELTERY_TANK).register(p);
        new SlimefunItem(Categories.MATERIALS, SPOUT, Workbench.TYPE, RECIPE_SMELTERY_SPOUT).register(p);
        new SlimefunItem(Categories.MATERIALS, SEARED_BRICK_BLOCK, Workbench.TYPE, RECIPE_SEARED_BRICK_BLOCK).register(p);

        new UnplaceableBlock(Categories.MATERIALS, MOD_PLATE, Workbench.TYPE, RECIPE_REINFORCED_PLATE).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_COPPER, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_COPPER, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_LEAD, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_LEAD, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_SILVER, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_SILVER, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_ALUMINUM, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_ALUMINUM, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_MAGNESIUM, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_MAGNESIUM, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_ZINC, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_ZINC, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_TIN, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_TIN, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_STEEL, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_STEEL, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_DAMASCUS_STEEL, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_DAMASCUS_STEEL, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_DURALIUM, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_DURALIUM, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_BRONZE, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_BRONZE, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_ALU_BRONZE, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_ALU_BRONZE, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_HARD_METAL, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_HARD_METAL, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_COR_BRONZE, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_COR_BRONZE, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_SOLDER, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_SOLDER, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_BILLON, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_BILLON, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_BRASS, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_BRASS, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_ALU_BRASS, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_ALU_BRASS, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_NICKEL, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_NICKEL, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_COBALT, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_COBALT, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_REINFORCED, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(Categories.MATERIALS, BLOCK_CAST_REINFORCED, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(Categories.MATERIALS, NUGGET_CAST_COAL, DummySmeltery.TYPE, Parts.getDummyCastRecipe(Casts.CAST_NUGGET)).register(p);


    }


}
