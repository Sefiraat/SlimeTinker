package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.itemgroups.ItemGroups;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.DummySmeltery;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.TinkersSmeltery;
import io.github.sefiraat.slimetinker.items.workstations.workbench.Workbench;
import io.github.sefiraat.slimetinker.managers.SupportedPluginsManager;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.sefiraat.slimetinker.utils.enums.ThemeItemType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class Materials {

    private Materials() {
        throw new UnsupportedOperationException("Utility Class");
    }

    // region Vanilla + Core SF

    // region Nuggets
    public static final SlimefunItemStack NUGGET_CAST_COPPER = ThemeUtils.themedItemStack(
        "NUGGET_CAST_COPPER",
        Material.ACACIA_BUTTON,
        ThemeItemType.CRAFTING,
        "Copper Nugget",
        "A nugget made from solid copper"
    );

    public static final SlimefunItemStack NUGGET_CAST_TIN = ThemeUtils.themedItemStack(
        "NUGGET_CAST_TIN",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Tin Nugget",
        "A nugget made from solid tin"
    );

    public static final SlimefunItemStack NUGGET_CAST_ZINC = ThemeUtils.themedItemStack(
        "NUGGET_CAST_ZINC",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Zinc Nugget",
        "A nugget made from solid zinc"
    );

    public static final SlimefunItemStack NUGGET_CAST_ALUMINUM = ThemeUtils.themedItemStack(
        "NUGGET_CAST_ALUMINUM",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Aluminum Nugget",
        "A nugget made from solid aluminum"
    );

    public static final SlimefunItemStack NUGGET_CAST_MAGNESIUM = ThemeUtils.themedItemStack(
        "NUGGET_CAST_MAGNESIUM",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Magnesium Nugget",
        "A nugget made from solid magnesium"
    );

    public static final SlimefunItemStack NUGGET_CAST_LEAD = ThemeUtils.themedItemStack(
        "NUGGET_CAST_LEAD",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Lead Nugget",
        "A nugget made from solid lead"
    );

    public static final SlimefunItemStack NUGGET_CAST_SILVER = ThemeUtils.themedItemStack(
        "NUGGET_CAST_SILVER",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Silver Nugget",
        "A nugget made from solid silver"
    );

    public static final SlimefunItemStack NUGGET_CAST_COAL = ThemeUtils.themedItemStack(
        "NUGGET_CAST_COAL",
        Material.POLISHED_BLACKSTONE_BUTTON,
        ThemeItemType.CRAFTING,
        "Coal Nugget",
        "A nugget made from liquifacted coal"
    );

    public static final SlimefunItemStack NUGGET_CAST_STEEL = ThemeUtils.themedItemStack(
        "NUGGET_CAST_STEEL",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Steel Nugget",
        "A nugget made from solid steel"
    );

    public static final SlimefunItemStack NUGGET_CAST_DAMASCUS_STEEL = ThemeUtils.themedItemStack(
        "NUGGET_CAST_DAMASCUS_STEEL",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Damascus Steel Nugget",
        "A nugget made from damascus steel"
    );

    public static final SlimefunItemStack NUGGET_CAST_DURALIUM = ThemeUtils.themedItemStack(
        "NUGGET_CAST_DURALIUM",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Duralium Nugget",
        "A nugget made from duralium"
    );

    public static final SlimefunItemStack NUGGET_CAST_BRONZE = ThemeUtils.themedItemStack(
        "NUGGET_CAST_BRONZE",
        Material.ACACIA_BUTTON,
        ThemeItemType.CRAFTING,
        "Bronze Nugget",
        "A nugget made from bronze"
    );

    public static final SlimefunItemStack NUGGET_CAST_ALU_BRONZE = ThemeUtils.themedItemStack(
        "NUGGET_CAST_ALU_BRONZE",
        Material.GOLD_NUGGET,
        ThemeItemType.CRAFTING,
        "Aluminum Bronze Nugget",
        "A nugget made from aluminum bronze"
    );

    public static final SlimefunItemStack NUGGET_CAST_HARD_METAL = ThemeUtils.themedItemStack(
        "NUGGET_CAST_HARD_METAL",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Hardened Metal Nugget",
        "A nugget made from hardened metal"
    );

    public static final SlimefunItemStack NUGGET_CAST_COR_BRONZE = ThemeUtils.themedItemStack(
        "NUGGET_CAST_COR_BRONZE",
        Material.GOLD_NUGGET,
        ThemeItemType.CRAFTING,
        "Corinthian Bronze Nugget",
        "A nugget made from corinthian bronze"
    );

    public static final SlimefunItemStack NUGGET_CAST_SOLDER = ThemeUtils.themedItemStack(
        "NUGGET_CAST_SOLDER",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Solder Nugget",
        "A nugget made from solder"
    );

    public static final SlimefunItemStack NUGGET_CAST_BILLON = ThemeUtils.themedItemStack(
        "NUGGET_CAST_BILLON",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Billon Nugget",
        "A nugget made from billon"
    );

    public static final SlimefunItemStack NUGGET_CAST_BRASS = ThemeUtils.themedItemStack(
        "NUGGET_CAST_BRASS",
        Material.GOLD_NUGGET,
        ThemeItemType.CRAFTING,
        "Brass Nugget",
        "A nugget made from brass"
    );

    public static final SlimefunItemStack NUGGET_CAST_ALU_BRASS = ThemeUtils.themedItemStack(
        "NUGGET_CAST_ALU_BRASS",
        Material.GOLD_NUGGET,
        ThemeItemType.CRAFTING,
        "Aluminum Brass Nugget",
        "A nugget made from aluminum brass"
    );

    public static final SlimefunItemStack NUGGET_CAST_NICKEL = ThemeUtils.themedItemStack(
        "NUGGET_CAST_NICKEL",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Nickel Nugget",
        "A nugget made from nickel"
    );

    public static final SlimefunItemStack NUGGET_CAST_COBALT = ThemeUtils.themedItemStack(
        "NUGGET_CAST_COBALT",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Cobalt Nugget",
        "A nugget made from cobalt"
    );

    public static final SlimefunItemStack NUGGET_CAST_REINFORCED = ThemeUtils.themedItemStack(
        "NUGGET_CAST_REINFORCED",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Reinforced Alloy Nugget",
        "A nugget made from reinforced alloy"
    );

    public static final SlimefunItemStack NUGGET_CAST_FERROSILICON = ThemeUtils.themedItemStack(
        "NUGGET_CAST_FERROSILICON",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Ferrosilicon Nugget",
        "A nugget made from ferrosilicon"
    );

    public static final SlimefunItemStack NUGGET_CAST_REDSTONE_ALLOY = ThemeUtils.themedItemStack(
        "NUGGET_CAST_REDSTONE_ALLOY",
        Material.ACACIA_BUTTON,
        ThemeItemType.CRAFTING,
        "Redstone Alloy Nugget",
        "A nugget made from redstone alloy"
    );

    public static final SlimefunItemStack NUGGET_CAST_BOOMERITE = ThemeUtils.themedItemStack(
        "NUGGET_CAST_BOOMERITE",
        Material.ACACIA_BUTTON,
        ThemeItemType.CRAFTING,
        "Boomerite Nugget",
        "A nugget made from boomerite"
    );

    public static final SlimefunItemStack NUGGET_CAST_SEFIRITE = ThemeUtils.themedItemStack(
        "NUGGET_CAST_SEFIRITE",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Sefirite Nugget",
        "A nugget made from sefirite"
    );
    public static final SlimefunItemStack NUGGET_CAST_CRINGLEIUM = ThemeUtils.themedItemStack(
        "NUGGET_CAST_CRINGLEIUM",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Cringleium Nugget",
        "A nugget made from Cringleium."
    );
    public static final SlimefunItemStack NUGGET_CAST_FONDNESS = ThemeUtils.themedItemStack(
        "NUGGET_CAST_FONDNESS",
        Material.PINK_DYE,
        ThemeItemType.CRAFTING,
        "Fondness Nugget",
        "A nugget made from the concept",
        "of fondness."
    );
    public static final SlimefunItemStack NUGGET_CAST_DEVOTION = ThemeUtils.themedItemStack(
        "NUGGET_CAST_DEVOTION",
        Material.PINK_DYE,
        ThemeItemType.CRAFTING,
        "Devotion Nugget",
        "A nugget made from the concept",
        "of devotion."
    );
    public static final SlimefunItemStack NUGGET_CAST_PASSION = ThemeUtils.themedItemStack(
        "NUGGET_CAST_PASSION",
        Material.PINK_DYE,
        ThemeItemType.CRAFTING,
        "Passion Nugget",
        "A nugget made from the concept",
        "of passion."
    );
    public static final SlimefunItemStack NUGGET_CAST_LOVE = ThemeUtils.themedItemStack(
        "NUGGET_CAST_LOVE",
        Material.PINK_DYE,
        ThemeItemType.CRAFTING,
        "Love Nugget",
        "A nugget that exudes nothing but",
        "pure and unadulterated love."
    );
    public static final SlimefunItemStack NUGGET_CAST_NICE = ThemeUtils.themedItemStack(
        "NUGGET_CAST_NICE",
        Material.GOLD_NUGGET,
        ThemeItemType.CRAFTING,
        "Nice Nugget",
        "Nice"
    );
    public static final SlimefunItemStack NUGGET_CAST_SMITHIUM = ThemeUtils.themedItemStack(
        "NUGGET_CAST_SMITHIUM",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Smithium Nugget",
        "A straight-forward metal with various uses",
        "in core industry tasks."
    );
    public static final SlimefunItemStack NUGGET_CAST_ANNIVERSARIUM = ThemeUtils.themedItemStack(
        "NUGGET_CAST_ANNIVERSARIUM",
        Material.GOLD_NUGGET,
        ThemeItemType.CRAFTING,
        "Anniversarium Nugget",
        "10 Years of (Slime)fun!"
    );
    public static final SlimefunItemStack NUGGET_CAST_REINFORCED_DRACONIUM = ThemeUtils.themedItemStack(
        "NUGGET_CAST_REINFORCED_DRACONIUM",
        Material.CRIMSON_BUTTON,
        ThemeItemType.CRAFTING,
        "Reinforced Draconium Nugget",
        "An ingot that just teems with an",
        "unrivalled fury."
    );
    // endregion

    // region Ingots
    public static final SlimefunItemStack INGOT_CAST_BOOMERITE = ThemeUtils.themedItemStack(
        "INGOT_CAST_BOOMERITE",
        Material.BRICK,
        ThemeItemType.CRAFTING,
        "Boomerite Ingot",
        "A very rare ingot. Origins unknown."
    );
    public static final SlimefunItemStack INGOT_CAST_SEFIRITE = ThemeUtils.themedItemStack(
        "INGOT_CAST_SEFIRITE",
        Material.IRON_INGOT,
        ThemeItemType.CRAFTING,
        "Sefirite Ingot",
        "An ingot that's only available for a short time."
    );
    public static final SlimefunItemStack INGOT_CAST_CRINGLEIUM = ThemeUtils.themedItemStack(
        "INGOT_CAST_CRINGLEIUM",
        Material.IRON_INGOT,
        ThemeItemType.CRAFTING,
        "Cringleium Ingot",
        "A festive ingot that's only available for a short time."
    );
    public static final SlimefunItemStack INGOT_CAST_FONDNESS = ThemeUtils.themedItemStack(
        "INGOT_CAST_FONDNESS",
        Material.BRICK,
        ThemeItemType.CRAFTING,
        "Fondness Ingot",
        "An ingot made from the concept",
        "of fondness."
    );
    public static final SlimefunItemStack INGOT_CAST_DEVOTION = ThemeUtils.themedItemStack(
        "INGOT_CAST_DEVOTION",
        Material.BRICK,
        ThemeItemType.CRAFTING,
        "Devotion Ingot",
        "An ingot made from the concept",
        "of devotion."
    );
    public static final SlimefunItemStack INGOT_CAST_PASSION = ThemeUtils.themedItemStack(
        "INGOT_CAST_PASSION",
        Material.BRICK,
        ThemeItemType.CRAFTING,
        "Passion Ingot",
        "An ingot made from the concept",
        "of passion."
    );
    public static final SlimefunItemStack INGOT_CAST_LOVE = ThemeUtils.themedItemStack(
        "INGOT_CAST_LOVE",
        Material.BRICK,
        ThemeItemType.CRAFTING,
        "Love Ingot",
        "An ingot that exudes nothing but",
        "pure and unadulterated love."
    );
    public static final SlimefunItemStack INGOT_CAST_NICE = ThemeUtils.themedItemStack(
        "INGOT_CAST_NICE",
        Material.GOLD_INGOT,
        ThemeItemType.CRAFTING,
        "Nice Ingot",
        "Nice"
    );
    public static final SlimefunItemStack INGOT_CAST_SMITHIUM = ThemeUtils.themedItemStack(
        "INGOT_CAST_SMITHIUM",
        Material.IRON_INGOT,
        ThemeItemType.CRAFTING,
        "Smithium Ingot",
        "A straight-forward metal with various uses",
        "in core industry tasks."
    );
    public static final SlimefunItemStack INGOT_CAST_ANNIVERSARIUM = ThemeUtils.themedItemStack(
        "INGOT_CAST_ANNIVERSARIUM",
        Material.GOLD_INGOT,
        ThemeItemType.CRAFTING,
        "Anniversarium Ingot",
        "10 Years of (Slime)fun!"
    );
    public static final SlimefunItemStack INGOT_CAST_REINFORCED_DRACONIUM = ThemeUtils.themedItemStack(
        "INGOT_CAST_REINFORCED_DRACONIUM",
        Material.BRICK,
        ThemeItemType.CRAFTING,
        "Reinforced Draconium Ingot",
        "An ingot that just teems with an",
        "unrivalled fury."
    );
    // endregion

    // region Blocks
    public static final SlimefunItemStack BLOCK_CAST_COPPER = ThemeUtils.themedItemStack(
        "BLOCK_CAST_COPPER",
        Material.TERRACOTTA,
        ThemeItemType.CRAFTING,
        "Copper Block",
        "A block made from solid copper"
    );

    public static final SlimefunItemStack BLOCK_CAST_TIN = ThemeUtils.themedItemStack(
        "BLOCK_CAST_TIN",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Tin Block",
        "A block made from solid tin"
    );

    public static final SlimefunItemStack BLOCK_CAST_ZINC = ThemeUtils.themedItemStack(
        "BLOCK_CAST_ZINC",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Zinc Block",
        "A block made from solid zinc"
    );

    public static final SlimefunItemStack BLOCK_CAST_ALUMINUM = ThemeUtils.themedItemStack(
        "BLOCK_CAST_ALUMINUM",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Aluminum Block",
        "A block made from solid aluminum"
    );

    public static final SlimefunItemStack BLOCK_CAST_MAGNESIUM = ThemeUtils.themedItemStack(
        "BLOCK_CAST_MAGNESIUM",
        Material.PINK_TERRACOTTA,
        ThemeItemType.CRAFTING,
        "Magnesium Block",
        "A block made from solid magnesium"
    );

    public static final SlimefunItemStack BLOCK_CAST_LEAD = ThemeUtils.themedItemStack(
        "BLOCK_CAST_LEAD",
        Material.PURPLE_TERRACOTTA,
        ThemeItemType.CRAFTING,
        "Lead Block",
        "A block made from solid lead"
    );

    public static final SlimefunItemStack BLOCK_CAST_SILVER = ThemeUtils.themedItemStack(
        "BLOCK_CAST_SILVER",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Silver Block",
        "A block made from solid silver"
    );

    public static final SlimefunItemStack BLOCK_CAST_STEEL = ThemeUtils.themedItemStack(
        "BLOCK_CAST_STEEL",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Steel Block",
        "A block made from solid steel"
    );

    public static final SlimefunItemStack BLOCK_CAST_DAMASCUS_STEEL = ThemeUtils.themedItemStack(
        "BLOCK_CAST_DAMASCUS_STEEL",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Damascus Steel Block",
        "A block made from damascus steel"
    );

    public static final SlimefunItemStack BLOCK_CAST_DURALIUM = ThemeUtils.themedItemStack(
        "BLOCK_CAST_DURALIUM",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Duralium Block",
        "A block made from duralium"
    );

    public static final SlimefunItemStack BLOCK_CAST_BRONZE = ThemeUtils.themedItemStack(
        "BLOCK_CAST_BRONZE",
        Material.TERRACOTTA,
        ThemeItemType.CRAFTING,
        "Bronze Block",
        "A block made from bronze"
    );

    public static final SlimefunItemStack BLOCK_CAST_ALU_BRONZE = ThemeUtils.themedItemStack(
        "BLOCK_CAST_ALU_BRONZE",
        Material.TERRACOTTA,
        ThemeItemType.CRAFTING,
        "Aluminum Bronze Block",
        "A block made from aluminum bronze"
    );

    public static final SlimefunItemStack BLOCK_CAST_HARD_METAL = ThemeUtils.themedItemStack(
        "BLOCK_CAST_HARD_METAL",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Hardened Metal Block",
        "A block made from hardened metal"
    );
    public static final SlimefunItemStack BLOCK_CAST_COR_BRONZE = ThemeUtils.themedItemStack(
        "BLOCK_CAST_COR_BRONZE",
        Material.TERRACOTTA,
        ThemeItemType.CRAFTING,
        "Corinthian Bronze Block",
        "A block made from corinthian bronze"
    );

    public static final SlimefunItemStack BLOCK_CAST_SOLDER = ThemeUtils.themedItemStack(
        "BLOCK_CAST_SOLDER",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Solder Block",
        "A block made from solder"
    );

    public static final SlimefunItemStack BLOCK_CAST_BILLON = ThemeUtils.themedItemStack(
        "BLOCK_CAST_BILLON",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Billon Block",
        "A block made from billon"
    );

    public static final SlimefunItemStack BLOCK_CAST_BRASS = ThemeUtils.themedItemStack(
        "BLOCK_CAST_BRASS",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Brass Block",
        "A block made from brass"
    );

    public static final SlimefunItemStack BLOCK_CAST_ALU_BRASS = ThemeUtils.themedItemStack(
        "BLOCK_CAST_ALU_BRASS",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Aluminum Brass Block",
        "A block made from aluminum brass"
    );

    public static final SlimefunItemStack BLOCK_CAST_NICKEL = ThemeUtils.themedItemStack(
        "BLOCK_CAST_NICKEL",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Nickel Block",
        "A block made from nickel"
    );

    public static final SlimefunItemStack BLOCK_CAST_COBALT = ThemeUtils.themedItemStack(
        "BLOCK_CAST_COBALT",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Cobalt Block",
        "A block made from cobalt"
    );

    public static final SlimefunItemStack BLOCK_CAST_REINFORCED = ThemeUtils.themedItemStack(
        "BLOCK_CAST_REINFORCED",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Reinforced Alloy Block",
        "A block made from reinforced alloy"
    );

    public static final SlimefunItemStack BLOCK_CAST_FERROSILICON = ThemeUtils.themedItemStack(
        "BLOCK_CAST_FERROSILICON",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Ferrosilicon Block",
        "A block made from ferrosilicon"
    );

    public static final SlimefunItemStack BLOCK_CAST_REDSTONE_ALLOY = ThemeUtils.themedItemStack(
        "BLOCK_CAST_REDSTONE_ALLOY",
        Material.TERRACOTTA,
        ThemeItemType.CRAFTING,
        "Redstone Alloy Block",
        "A block made from redstone alloy"
    );

    public static final SlimefunItemStack BLOCK_CAST_BOOMERITE = ThemeUtils.themedItemStack(
        "BLOCK_CAST_BOOMERITE",
        Material.TERRACOTTA,
        ThemeItemType.CRAFTING,
        "Boomerite Block",
        "A block made from boomerite"
    );

    public static final SlimefunItemStack BLOCK_CAST_SEFIRITE = ThemeUtils.themedItemStack(
        "BLOCK_CAST_SEFIRITE",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Sefirite Block",
        "A block made from sefirite"
    );
    public static final SlimefunItemStack BLOCK_CAST_CRINGLEIUM = ThemeUtils.themedItemStack(
        "BLOCK_CAST_CRINGLEIUM",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Cringleium Block",
        "A block made from Cringleium"
    );
    public static final SlimefunItemStack BLOCK_CAST_LOVE = ThemeUtils.themedItemStack(
        "BLOCK_CAST_LOVE",
        Material.PINK_DYE,
        ThemeItemType.CRAFTING,
        "Love Block",
        "A block that exudes nothing but",
        "pure and unadulterated love."
    );
    public static final SlimefunItemStack BLOCK_CAST_NICE = ThemeUtils.themedItemStack(
        "BLOCK_CAST_NICE",
        Material.GOLD_BLOCK,
        ThemeItemType.CRAFTING,
        "Nice Block",
        "Nice"
    );

    public static final SlimefunItemStack BLOCK_CAST_SMITHIUM = ThemeUtils.themedItemStack(
        "BLOCK_CAST_SMITHIUM",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Smithium Block",
        "A straight-forward metal with various uses",
        "in core industry tasks."
    );
    public static final SlimefunItemStack BLOCK_CAST_ANNIVERSARIUM = ThemeUtils.themedItemStack(
        "BLOCK_CAST_ANNIVERSARIUM",
        Material.GOLD_BLOCK,
        ThemeItemType.CRAFTING,
        "Anniversarium Block",
        "10 Years of (Slime)fun!"
    );
    public static final SlimefunItemStack BLOCK_CAST_REINFORCED_DRACONIUM = ThemeUtils.themedItemStack(
        "BLOCK_CAST_REINFORCED_DRACONIUM",
        Material.RED_CONCRETE,
        ThemeItemType.CRAFTING,
        "Reinforced Draconium Block",
        "A block that just teems with an",
        "unrivalled fury."
    );
    // endregion

    // region Crafts
    public static final SlimefunItemStack MOD_PLATE = ThemeUtils.themedItemStack(
        "MOD_PLATE",
        Material.OBSIDIAN,
        ThemeItemType.MOD,
        "Reinforced Plate",
        ThemeUtils.PASSIVE + "A modification for tools that gives.",
        ThemeUtils.PASSIVE + "a chance to ignore tool damage."
    );

    public static final SlimefunItemStack GROUT = ThemeUtils.themedItemStack(
        "GROUT",
        Material.GRAVEL,
        ThemeItemType.CRAFTING,
        "Grout",
        ThemeUtils.PASSIVE + "Used to make seared bricks."
    );


    public static final SlimefunItemStack SEARED_BRICK = ThemeUtils.themedItemStack(
        "SEARED_BRICK",
        Material.BRICK,
        ThemeItemType.CRAFTING,
        "Seared Brick",
        ThemeUtils.PASSIVE + "Used in crafting smeltery blocks."
    );

    public static final SlimefunItemStack SMELTERY_CONTROLLER = ThemeUtils.themedItemStack(
        "SMELTERY_CONTROLLER",
        Material.CHISELED_POLISHED_BLACKSTONE,
        ThemeItemType.MACHINE,
        "Smeltery Controller",
        ThemeUtils.PASSIVE + "Used in crafting smeltery blocks."
    );

    public static final SlimefunItemStack SEARED_TANK = ThemeUtils.themedItemStack(
        "SEARED_TANK",
        Material.RED_NETHER_BRICK_WALL,
        ThemeItemType.CRAFTING,
        "Seared Tank",
        ThemeUtils.PASSIVE + "Used in building the smeltery."
    );

    public static final SlimefunItemStack SPOUT = ThemeUtils.themedItemStack(
        "SPOUT",
        Material.POLISHED_BLACKSTONE_BRICK_WALL,
        ThemeItemType.CRAFTING,
        "Seared Spout",
        ThemeUtils.PASSIVE + "Used in building the smeltery."
    );

    public static final SlimefunItemStack SEARED_BRICK_BLOCK = ThemeUtils.themedItemStack(
        "SEARED_BRICK_BLOCK",
        Material.POLISHED_BLACKSTONE_BRICKS,
        ThemeItemType.CRAFTING,
        "Seared Brick Block",
        ThemeUtils.PASSIVE + "Used in building the smeltery."
    );
    // endregion

    // endregion

    // region Infinity Expansion

    // region Nuggets
    public static final SlimefunItemStack NUGGET_CAST_INFINITY = ThemeUtils.themedItemStack(
        "NUGGET_CAST_INFINITY",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Infinity Nugget",
        "A nugget made from solid infinity... yup!"
    );

    public static final SlimefunItemStack NUGGET_CAST_MAGSTEEL = ThemeUtils.themedItemStack(
        "NUGGET_CAST_MAGSTEEL",
        Material.ACACIA_BUTTON,
        ThemeItemType.CRAFTING,
        "MagSteel Nugget",
        "A nugget made from solid MagSteel"
    );

    public static final SlimefunItemStack NUGGET_CAST_TITANIUM = ThemeUtils.themedItemStack(
        "NUGGET_CAST_TITANIUM",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Titanium Nugget",
        "A nugget made from solid Titanium"
    );

    public static final SlimefunItemStack NUGGET_CAST_MYTHRIL = ThemeUtils.themedItemStack(
        "NUGGET_CAST_MYTHRIL",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Mythril Nugget",
        "A nugget made from solid Mythril"
    );

    public static final SlimefunItemStack NUGGET_CAST_ADAMANTITE = ThemeUtils.themedItemStack(
        "NUGGET_CAST_ADAMANTITE",
        Material.ACACIA_BUTTON,
        ThemeItemType.CRAFTING,
        "Adamantite Nugget",
        "A nugget made from solid Adamantite"
    );

    public static final SlimefunItemStack NUGGET_CAST_MAGNONIUM = ThemeUtils.themedItemStack(
        "NUGGET_CAST_MAGNONIUM",
        Material.CRIMSON_BUTTON,
        ThemeItemType.CRAFTING,
        "Magnonium Nugget",
        "A nugget made from solid Magnonium"
    );

    // endregion

    // region Blocks
    public static final SlimefunItemStack BLOCK_CAST_VOID = ThemeUtils.themedItemStack(
        "BLOCK_CAST_VOID",
        Material.NETHERITE_BLOCK,
        ThemeItemType.CRAFTING,
        "Void Block",
        "A block made from ... void?"
    );

    public static final SlimefunItemStack BLOCK_CAST_INFINITY = ThemeUtils.themedItemStack(
        "BLOCK_CAST_INFINITY",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Infinity Block",
        "A block made from *sigh* infinity."
    );

    public static final SlimefunItemStack BLOCK_CAST_MAGSTEEL = ThemeUtils.themedItemStack(
        "BLOCK_CAST_MAGSTEEL",
        Material.TERRACOTTA,
        ThemeItemType.CRAFTING,
        "MagSteel Block",
        "A block made from MagSteel."
    );

    public static final SlimefunItemStack BLOCK_CAST_TITANIUM = ThemeUtils.themedItemStack(
        "BLOCK_CAST_TITANIUM",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Titanium Block",
        "A block made from Titanium."
    );

    public static final SlimefunItemStack BLOCK_CAST_MYTHRIL = ThemeUtils.themedItemStack(
        "BLOCK_CAST_MYTHRIL",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Mythril Block",
        "A block made from Mythril."
    );

    public static final SlimefunItemStack BLOCK_CAST_ADAMANTITE = ThemeUtils.themedItemStack(
        "BLOCK_CAST_ADAMANTITE",
        Material.TERRACOTTA,
        ThemeItemType.CRAFTING,
        "Adamanitite Block",
        "A block made from Adamanitite."
    );

    public static final SlimefunItemStack BLOCK_CAST_MAGNONIUM = ThemeUtils.themedItemStack(
        "BLOCK_CAST_MAGNONIUM",
        Material.PURPLE_TERRACOTTA,
        ThemeItemType.CRAFTING,
        "Magnonium Block",
        "A block made from Magnonium."
    );

    // endregion

    // endregion

    // region SFWarfare

    // region Nuggets
    public static final SlimefunItemStack NUGGET_CAST_SLIMESTEEL = ThemeUtils.themedItemStack(
        "NUGGET_CAST_SLIMESTEEL",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Slimesteel Nugget",
        "A nugget of slimesteel"
    );

    public static final SlimefunItemStack NUGGET_CAST_REINFORCED_SLIMESTEEL = ThemeUtils.themedItemStack(
        "NUGGET_CAST_REINFORCED_SLIMESTEEL",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Reinforced Slimesteel Nugget",
        "A nugget of reinforced slimesteel"
    );

    public static final SlimefunItemStack NUGGET_CAST_OSMIUM = ThemeUtils.themedItemStack(
        "NUGGET_CAST_OSMIUM",
        Material.WARPED_BUTTON,
        ThemeItemType.CRAFTING,
        "Osmium Nugget",
        "A nugget of osmium"
    );

    public static final SlimefunItemStack NUGGET_CAST_OSMIUM_SUPER_ALLOY = ThemeUtils.themedItemStack(
        "NUGGET_CAST_OSMIUM_SUPER_ALLOY",
        Material.WARPED_BUTTON,
        ThemeItemType.CRAFTING,
        "Osmium Superalloy Nugget",
        "A nugget of osmium superalloy"
    );

    public static final SlimefunItemStack NUGGET_CAST_UNPATENTABILUM = ThemeUtils.themedItemStack(
        "NUGGET_CAST_UNPATENTABILUM",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Unpatentabilum Nugget",
        "A nugget of unpatentabilum"
    );

    // endregion

    // region Blocks
    public static final SlimefunItemStack BLOCK_CAST_SLIMESTEEL = ThemeUtils.themedItemStack(
        "BLOCK_CAST_SLIMESTEEL",
        Material.SLIME_BLOCK,
        ThemeItemType.CRAFTING,
        "Slimesteel Block",
        "A block of slimesteel"
    );

    public static final SlimefunItemStack BLOCK_CAST_REINFORCED_SLIMESTEEL = ThemeUtils.themedItemStack(
        "BLOCK_CAST_REINFORCED_SLIMESTEEL",
        Material.SLIME_BLOCK,
        ThemeItemType.CRAFTING,
        "Reinforced Slimesteel Block",
        "A block of reinforced slimesteel"
    );

    public static final SlimefunItemStack BLOCK_CAST_OSMIUM = ThemeUtils.themedItemStack(
        "BLOCK_CAST_OSMIUM",
        Material.LIGHT_BLUE_TERRACOTTA,
        ThemeItemType.CRAFTING,
        "Osmium Block",
        "A block of osmium"
    );

    public static final SlimefunItemStack BLOCK_CAST_OSMIUM_SUPER_ALLOY = ThemeUtils.themedItemStack(
        "BLOCK_CAST_OSMIUM_SUPER_ALLOY",
        Material.BLUE_TERRACOTTA,
        ThemeItemType.CRAFTING,
        "Osmium Superalloy Block",
        "A block of osmium superalloy"
    );

    public static final SlimefunItemStack BLOCK_CAST_UNPATENTABILUM = ThemeUtils.themedItemStack(
        "BLOCK_CAST_UNPATENTABILUM",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Unpatentabilum Block",
        "A block of unpatentabilum"
    );

    // endregion

    // endregion

    // region DynaTech

    // region Nuggets
    public static final SlimefunItemStack NUGGET_CAST_STAINLESSSTEEL = ThemeUtils.themedItemStack(
        "NUGGET_CAST_STAINLESSSTEEL",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Stainless Steel Nugget",
        "A nugget of stainless steel"
    );

    // endregion

    // region Blocks
    public static final SlimefunItemStack BLOCK_CAST_STAINLESSSTEEL = ThemeUtils.themedItemStack(
        "BLOCK_CAST_STAINLESSSTEEL",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Stainless Steel Block",
        "A block of stainless"
    );

    // endregion

    // endregion

    // region LiteXpansion

    // region Nuggets
    public static final SlimefunItemStack NUGGET_CAST_REFINED_IRON = ThemeUtils.themedItemStack(
        "NUGGET_CAST_REFINED_IRON",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Refined Iron Nugget",
        "A nugget of refined iron"
    );

    public static final SlimefunItemStack NUGGET_CAST_MIXED_METAL = ThemeUtils.themedItemStack(
        "NUGGET_CAST_MIXED_METAL",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Mixed Metal Nugget",
        "A nugget of mixed metal"
    );

    public static final SlimefunItemStack NUGGET_CAST_ADVANCED_ALLOY = ThemeUtils.themedItemStack(
        "NUGGET_CAST_ADVANCED_ALLOY",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Advanced Alloy Nugget",
        "A nugget of advanced alloy"
    );

    public static final SlimefunItemStack NUGGET_CAST_MAG_THOR = ThemeUtils.themedItemStack(
        "NUGGET_CAST_MAG_THOR",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Mag-Thor Nugget",
        "A nugget of mag-thor"
    );

    public static final SlimefunItemStack NUGGET_CAST_SCRAP = ThemeUtils.themedItemStack(
        "NUGGET_CAST_SCRAP",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Scrap Nugget",
        "A nugget of scrap"
    );

    public static final SlimefunItemStack NUGGET_CAST_IRIDIUM = ThemeUtils.themedItemStack(
        "NUGGET_CAST_IRIDIUM",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Iridium Nugget",
        "A nugget of Iridium"
    );

    // endregion

    // region Blocks
    public static final SlimefunItemStack BLOCK_CAST_REFINED_IRON = ThemeUtils.themedItemStack(
        "BLOCK_CAST_REFINED_IRON",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Refined Iron Block",
        "A block of refined iron"
    );

    public static final SlimefunItemStack BLOCK_CAST_MIXED_METAL = ThemeUtils.themedItemStack(
        "BLOCK_CAST_MIXED_METAL",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Mixed Metal Block",
        "A block of mixed metal"
    );

    public static final SlimefunItemStack BLOCK_CAST_ADVANCED_ALLOY = ThemeUtils.themedItemStack(
        "BLOCK_CAST_ADVANCED_ALLOY",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Advanced Alloy Block",
        "A block of advacned alloy"
    );

    public static final SlimefunItemStack BLOCK_CAST_MAG_THOR = ThemeUtils.themedItemStack(
        "BLOCK_CAST_MAG_THOR",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Mag-Thor Block",
        "A block of mag-thor"
    );

    public static final SlimefunItemStack BLOCK_CAST_SCRAP = ThemeUtils.themedItemStack(
        "BLOCK_CAST_SCRAP",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Scrap Block",
        "A block of scrap"
    );

    public static final SlimefunItemStack BLOCK_CAST_IRIDIUM = ThemeUtils.themedItemStack(
        "BLOCK_CAST_IRIDIUM",
        Material.IRON_BLOCK,
        ThemeItemType.CRAFTING,
        "Iridium Block",
        "A block of iridium"
    );

    // endregion

    // endregion

    // region TranscEndance

    // region Nuggets
    public static final SlimefunItemStack NUGGET_CAST_DAXI_STRENGTH = ThemeUtils.themedItemStack(
        "NUGGET_CAST_DAXI_STRENGTH",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Nugget of Strength Daxi",
        "A nugget of Daxi emanating strength."
    );

    public static final SlimefunItemStack NUGGET_CAST_DAXI_ABSORPTION = ThemeUtils.themedItemStack(
        "NUGGET_CAST_DAXI_ABSORPTION",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Nugget of Absorption Daxi",
        "A nugget of Daxi emanating resolution."
    );

    public static final SlimefunItemStack NUGGET_CAST_DAXI_FORTITUDE = ThemeUtils.themedItemStack(
        "NUGGET_CAST_DAXI_FORTITUDE",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Nugget of Fortitude Daxi",
        "A nugget of Daxi emanating defiance."
    );

    public static final SlimefunItemStack NUGGET_CAST_DAXI_SATURATION = ThemeUtils.themedItemStack(
        "NUGGET_CAST_DAXI_SATURATION",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Nugget of Saturation Daxi",
        "A nugget of Daxi emanating warmth."
    );

    public static final SlimefunItemStack NUGGET_CAST_DAXI_REGENERATION = ThemeUtils.themedItemStack(
        "NUGGET_CAST_DAXI_REGENERATION",
        Material.IRON_NUGGET,
        ThemeItemType.CRAFTING,
        "Nugget of Regeneration Daxi",
        "A nugget of Daxi emanating kindness."
    );

    // endregion

    // region Ingots

    public static final SlimefunItemStack INGOT_CAST_DAXI_STRENGTH = ThemeUtils.themedItemStack(
        "INGOT_CAST_DAXI_STRENGTH",
        Material.IRON_INGOT,
        ThemeItemType.CRAFTING,
        "Ingot of Strength Daxi",
        "An ingot of Daxi emanating strength."
    );

    public static final SlimefunItemStack INGOT_CAST_DAXI_ABSORPTION = ThemeUtils.themedItemStack(
        "INGOT_CAST_DAXI_ABSORPTION",
        Material.IRON_INGOT,
        ThemeItemType.CRAFTING,
        "Ingot of Absorption Daxi",
        "An ingot of Daxi emanating resolution."
    );

    public static final SlimefunItemStack INGOT_CAST_DAXI_FORTITUDE = ThemeUtils.themedItemStack(
        "INGOT_CAST_DAXI_FORTITUDE",
        Material.IRON_INGOT,
        ThemeItemType.CRAFTING,
        "Ingot of Fortitude Daxi",
        "An ingot of Daxi emanating defiance."
    );

    public static final SlimefunItemStack INGOT_CAST_DAXI_SATURATION = ThemeUtils.themedItemStack(
        "INGOT_CAST_DAXI_SATURATION",
        Material.IRON_INGOT,
        ThemeItemType.CRAFTING,
        "Ingot of Saturation Daxi",
        "An ingot of Daxi emanating warmth."
    );

    public static final SlimefunItemStack INGOT_CAST_DAXI_REGENERATION = ThemeUtils.themedItemStack(
        "INGOT_CAST_DAXI_REGENERATION",
        Material.IRON_INGOT,
        ThemeItemType.CRAFTING,
        "Ingot of Regeneration Daxi",
        "An ingot of Daxi emanating kindness."
    );

    // endregion

    // endregion

    private static final ItemStack[] RECIPE_GROUT = new ItemStack[]{
        new ItemStack(Material.CLAY), new ItemStack(Material.SAND), new ItemStack(Material.SAND),
        new ItemStack(Material.SAND), new ItemStack(Material.SAND), new ItemStack(Material.GRAVEL),
        new ItemStack(Material.GRAVEL), new ItemStack(Material.GRAVEL), new ItemStack(Material.GRAVEL)
    };

    private static final ItemStack[] RECIPE_SEARED_BRICK = new ItemStack[]{
        Materials.GROUT, null, null,
        null, null, null,
        null, null, null
    };

    private static final ItemStack[] RECIPE_SEARED_BRICK_BLOCK = new ItemStack[]{
        Materials.SEARED_BRICK, Materials.SEARED_BRICK, null,
        Materials.SEARED_BRICK, Materials.SEARED_BRICK, null,
        null, null, null
    };

    private static final ItemStack[] RECIPE_SMELTERY_CONTROLLER = new ItemStack[]{
        Materials.SEARED_BRICK, Materials.SEARED_BRICK, Materials.SEARED_BRICK,
        Materials.SEARED_BRICK, null, Materials.SEARED_BRICK,
        Materials.SEARED_BRICK, Materials.SEARED_BRICK, Materials.SEARED_BRICK
    };

    private static final ItemStack[] RECIPE_SMELTERY_SPOUT = new ItemStack[]{
        Materials.SEARED_BRICK, null, Materials.SEARED_BRICK,
        Materials.SEARED_BRICK, null, Materials.SEARED_BRICK,
        Materials.SEARED_BRICK, null, Materials.SEARED_BRICK
    };

    private static final ItemStack[] RECIPE_SMELTERY_TANK = new ItemStack[]{
        Materials.SEARED_BRICK, new ItemStack(Material.GLASS), Materials.SEARED_BRICK,
        Materials.SEARED_BRICK, new ItemStack(Material.GLASS), Materials.SEARED_BRICK,
        Materials.SEARED_BRICK, new ItemStack(Material.GLASS), Materials.SEARED_BRICK
    };

    private static final ItemStack[] RECIPE_REINFORCED_PLATE = new ItemStack[]{
        Materials.BLOCK_CAST_REINFORCED, Materials.BLOCK_CAST_REINFORCED, Materials.BLOCK_CAST_REINFORCED,
        Materials.BLOCK_CAST_REINFORCED, new ItemStack(Material.OBSIDIAN), Materials.BLOCK_CAST_REINFORCED,
        Materials.BLOCK_CAST_REINFORCED, Materials.BLOCK_CAST_REINFORCED, Materials.BLOCK_CAST_REINFORCED
    };

    public static void set(SlimeTinker p) {

        // Vanilla + Core SF + Tinker's General
        new UnplaceableBlock(ItemGroups.MATERIALS, GROUT, Workbench.TYPE, RECIPE_GROUT).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, SEARED_BRICK, RecipeType.SMELTERY, RECIPE_SEARED_BRICK).register(p);
        new TinkersSmeltery(ItemGroups.MATERIALS, SMELTERY_CONTROLLER, Workbench.TYPE, RECIPE_SMELTERY_CONTROLLER).register(p);
        new SlimefunItem(ItemGroups.MATERIALS, SEARED_TANK, Workbench.TYPE, RECIPE_SMELTERY_TANK).register(p);
        new SlimefunItem(ItemGroups.MATERIALS, SPOUT, Workbench.TYPE, RECIPE_SMELTERY_SPOUT).register(p);
        new SlimefunItem(ItemGroups.MATERIALS, SEARED_BRICK_BLOCK, Workbench.TYPE, RECIPE_SEARED_BRICK_BLOCK).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, MOD_PLATE, Workbench.TYPE, RECIPE_REINFORCED_PLATE).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_COPPER, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_COPPER, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_LEAD, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_LEAD, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_SILVER, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_SILVER, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_ALUMINUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_ALUMINUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_MAGNESIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_MAGNESIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_ZINC, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_ZINC, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_TIN, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_TIN, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_STEEL, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_STEEL, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_DAMASCUS_STEEL, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_DAMASCUS_STEEL, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_DURALIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_DURALIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_BRONZE, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_BRONZE, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_ALU_BRONZE, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_ALU_BRONZE, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_HARD_METAL, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_HARD_METAL, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_COR_BRONZE, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_COR_BRONZE, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_SOLDER, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_SOLDER, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_BILLON, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_BILLON, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_BRASS, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_BRASS, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_ALU_BRASS, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_ALU_BRASS, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_NICKEL, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_NICKEL, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_COBALT, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_COBALT, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_REINFORCED, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_REINFORCED, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_FERROSILICON, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_FERROSILICON, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_REDSTONE_ALLOY, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_REDSTONE_ALLOY, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_BOOMERITE, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, INGOT_CAST_BOOMERITE, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_INGOT)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_BOOMERITE, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_SEFIRITE, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, INGOT_CAST_SEFIRITE, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_INGOT)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_SEFIRITE, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_CRINGLEIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, INGOT_CAST_CRINGLEIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_INGOT)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_CRINGLEIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_FONDNESS, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, INGOT_CAST_FONDNESS, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_INGOT)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_DEVOTION, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, INGOT_CAST_DEVOTION, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_INGOT)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_PASSION, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, INGOT_CAST_PASSION, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_INGOT)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_LOVE, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, INGOT_CAST_LOVE, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_INGOT)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_LOVE, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_NICE, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, INGOT_CAST_NICE, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_INGOT)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_NICE, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_SMITHIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, INGOT_CAST_SMITHIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_INGOT)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_SMITHIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_ANNIVERSARIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, INGOT_CAST_ANNIVERSARIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_INGOT)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_ANNIVERSARIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_REINFORCED_DRACONIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, INGOT_CAST_REINFORCED_DRACONIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_INGOT)).register(p);
        new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_REINFORCED_DRACONIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

        new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_COAL, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);

        // Infinity Expansion
        if (SupportedPluginsManager.INFINITY_EXPANSION) {
            new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_VOID, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_INFINITY, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_INFINITY, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_MAGSTEEL, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_MAGSTEEL, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_TITANIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_TITANIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_MYTHRIL, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_MYTHRIL, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_ADAMANTITE, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_ADAMANTITE, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_MAGNONIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_MAGNONIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);
        }

        // SFWarfare
        if (SupportedPluginsManager.SLIMEFUN_WARFARE) {
            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_SLIMESTEEL, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_SLIMESTEEL, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_REINFORCED_SLIMESTEEL, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_REINFORCED_SLIMESTEEL, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_OSMIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_OSMIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_OSMIUM_SUPER_ALLOY, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_OSMIUM_SUPER_ALLOY, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_UNPATENTABILUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_UNPATENTABILUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);
        }

        // DynaTech
        if (SupportedPluginsManager.DYNATECH) {
            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_STAINLESSSTEEL, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_STAINLESSSTEEL, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);
        }

        // LiteXpansion
        if (SupportedPluginsManager.LITEXPANSION) {
            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_REFINED_IRON, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_REFINED_IRON, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_MIXED_METAL, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_MIXED_METAL, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_ADVANCED_ALLOY, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_ADVANCED_ALLOY, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_MAG_THOR, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_MAG_THOR, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_SCRAP, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_SCRAP, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);

            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_IRIDIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, BLOCK_CAST_IRIDIUM, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_BLOCK)).register(p);
        }

        // TranscEndence
        if (SupportedPluginsManager.TRANSCENDENCE) {
            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_DAXI_STRENGTH, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, INGOT_CAST_DAXI_STRENGTH, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_INGOT)).register(p);

            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_DAXI_ABSORPTION, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, INGOT_CAST_DAXI_ABSORPTION, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_INGOT)).register(p);

            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_DAXI_FORTITUDE, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, INGOT_CAST_DAXI_FORTITUDE, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_INGOT)).register(p);

            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_DAXI_SATURATION, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, INGOT_CAST_DAXI_SATURATION, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_INGOT)).register(p);

            new UnplaceableBlock(ItemGroups.MATERIALS, NUGGET_CAST_DAXI_REGENERATION, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_NUGGET)).register(p);
            new UnplaceableBlock(ItemGroups.MATERIALS, INGOT_CAST_DAXI_REGENERATION, DummySmeltery.TYPE, ItemUtils.getMiddleOnlyRecipe(Casts.CAST_INGOT)).register(p);
        }
    }
}
