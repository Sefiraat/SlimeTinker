package io.github.sefiraat.slimetinker.items.tinkermaterials.setup;

import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.tinkermaterials.TinkerMaterial;
import io.github.sefiraat.slimetinker.utils.Ids;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("SpellCheckingInspection")
public final class TinkersMaterialsCore {

    private TinkersMaterialsCore() {
        throw new UnsupportedOperationException("Utility Class");
    }

    private static final Map<String, TinkerMaterial> CM_MAP = new HashMap<>();

    private static final TinkerMaterial IRON = new TinkerMaterial(Ids.IRON, SlimefunItems.IRON_DUST, "#8c8c8c")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.CORE_IRON_HEAD)
        .setTraitToolRod(Traits.CORE_IRON_ROD)
        .setTraitArmorPlates(Traits.CORE_IRON_PLATES)
        .setTraitArmorLinks(Traits.CORE_IRON_LINKS)
        .setFormNugget(Material.IRON_NUGGET.toString())
        .setFormIngot(Material.IRON_INGOT.toString())
        .setFormBlock(Material.IRON_BLOCK.toString())
        .setFormOre(Material.IRON_ORE.toString())
        .setFormDust(SlimefunItems.IRON_DUST.getItemId())
        .setFormBoots(Material.IRON_BOOTS.toString())
        .setFormLeggings(Material.IRON_LEGGINGS.toString())
        .setFormChestplate(Material.IRON_CHESTPLATE.toString())
        .setFormHelmet(Material.IRON_HELMET.toString())
        .build();

    private static final TinkerMaterial GOLD = new TinkerMaterial(Ids.GOLD, SlimefunItems.GOLD_DUST, "#ffe138")
        .setLiquidTexture(SkullTextures.ALLOY_RED)
        .setTraitToolHead(Traits.CORE_GOLD_HEAD)
        .setTraitToolRod(Traits.CORE_GOLD_ROD)
        .setTraitArmorPlates(Traits.CORE_GOLD_PLATES)
        .setTraitArmorLinks(Traits.CORE_GOLD_LINKS)
        .setFormNugget(Material.GOLD_NUGGET.toString())
        .setFormIngot(Material.GOLD_INGOT.toString())
        .setFormBlock(Material.GOLD_BLOCK.toString())
        .setFormOre(Material.GOLD_ORE.toString())
        .setFormDust(SlimefunItems.GOLD_DUST.getItemId())
        .setFormBoots(Material.GOLDEN_BOOTS.toString())
        .setFormLeggings(Material.GOLDEN_LEGGINGS.toString())
        .setFormChestplate(Material.GOLDEN_CHESTPLATE.toString())
        .setFormHelmet(Material.GOLDEN_HELMET.toString())
        .build();

    private static final TinkerMaterial COPPER = new TinkerMaterial(Ids.COPPER, SlimefunItems.COPPER_DUST, "#c99732")
        .setLiquidTexture(SkullTextures.ALLOY_BROWN)
        .setTraitToolHead(Traits.CORE_COPPER_HEAD)
        .setTraitToolRod(Traits.CORE_COPPER_ROD)
        .setTraitArmorPlates(Traits.CORE_COPPER_PLATES)
        .setTraitArmorLinks(Traits.CORE_COPPER_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_COPPER.getItemId())
        .setFormIngot(SlimefunItems.COPPER_INGOT.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_COPPER.getItemId())
        .setFormDust(SlimefunItems.COPPER_DUST.getItemId())
        .build();

    private static final TinkerMaterial LEAD = new TinkerMaterial(Ids.LEAD, SlimefunItems.LEAD_DUST, "#9043ba")
        .setLiquidTexture(SkullTextures.ALLOY_PURPLE)
        .setTraitToolHead(Traits.CORE_LEAD_HEAD)
        .setTraitToolRod(Traits.CORE_LEAD_ROD)
        .setTraitArmorPlates(Traits.CORE_LEAD_PLATES)
        .setTraitArmorLinks(Traits.CORE_LEAD_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_LEAD.getItemId())
        .setFormIngot(SlimefunItems.LEAD_INGOT.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_LEAD.getItemId())
        .setFormDust(SlimefunItems.LEAD_DUST.getItemId())
        .build();

    private static final TinkerMaterial SILVER = new TinkerMaterial(Ids.SILVER, SlimefunItems.SILVER_DUST, "#d4d4d4")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.CORE_SILVER_HEAD)
        .setTraitToolRod(Traits.CORE_SILVER_ROD)
        .setTraitArmorPlates(Traits.CORE_SILVER_PLATES)
        .setTraitArmorLinks(Traits.CORE_SILVER_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_SILVER.getItemId())
        .setFormIngot(SlimefunItems.SILVER_INGOT.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_SILVER.getItemId())
        .setFormDust(SlimefunItems.SILVER_DUST.getItemId())
        .build();

    private static final TinkerMaterial ALUMINUM = new TinkerMaterial(Ids.ALUMINUM, SlimefunItems.ALUMINUM_DUST, "#b0b0b0")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.CORE_ALUMINUM_HEAD)
        .setTraitToolRod(Traits.CORE_ALUMINUM_ROD)
        .setTraitArmorPlates(Traits.CORE_ALUMINUM_PLATES)
        .setTraitArmorLinks(Traits.CORE_ALUMINUM_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_ALUMINUM.getItemId())
        .setFormIngot(SlimefunItems.ALUMINUM_INGOT.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_ALUMINUM.getItemId())
        .setFormDust(SlimefunItems.ALUMINUM_DUST.getItemId())
        .build();

    private static final TinkerMaterial TIN = new TinkerMaterial(Ids.TIN, SlimefunItems.TIN_DUST, "#a89b9b")
        .setLiquidTexture(SkullTextures.ALLOY_BLUE_PALE)
        .setTraitToolHead(Traits.CORE_TIN_HEAD)
        .setTraitToolRod(Traits.CORE_TIN_ROD)
        .setTraitArmorPlates(Traits.CORE_TIN_PLATES)
        .setTraitArmorLinks(Traits.CORE_TIN_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_TIN.getItemId())
        .setFormIngot(SlimefunItems.TIN_INGOT.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_TIN.getItemId())
        .setFormDust(SlimefunItems.TIN_DUST.getItemId())
        .build();

    private static final TinkerMaterial ZINC = new TinkerMaterial(Ids.ZINC, SlimefunItems.ZINC_DUST, "#9ba8a6")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.CORE_ZINC_HEAD)
        .setTraitToolRod(Traits.CORE_ZINC_ROD)
        .setTraitArmorPlates(Traits.CORE_ZINC_PLATES)
        .setTraitArmorLinks(Traits.CORE_ZINC_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_ZINC.getItemId())
        .setFormIngot(SlimefunItems.ZINC_INGOT.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_ZINC.getItemId())
        .setFormDust(SlimefunItems.ZINC_DUST.getItemId())
        .build();

    private static final TinkerMaterial MAGNESIUM = new TinkerMaterial(Ids.MAGNESIUM, SlimefunItems.MAGNESIUM_DUST, "#e8cef5")
        .setLiquidTexture(SkullTextures.ALLOY_PINK)
        .setTraitToolHead(Traits.CORE_MAGNESIUM_HEAD)
        .setTraitToolRod(Traits.CORE_MAGNESIUM_ROD)
        .setTraitArmorPlates(Traits.CORE_MAGNESIUM_PLATES)
        .setTraitArmorLinks(Traits.CORE_MAGNESIUM_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_MAGNESIUM.getItemId())
        .setFormIngot(SlimefunItems.MAGNESIUM_INGOT.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_MAGNESIUM.getItemId())
        .setFormDust(SlimefunItems.MAGNESIUM_DUST.getItemId())
        .build();

    private static final TinkerMaterial COAL = new TinkerMaterial(Ids.COAL, new ItemStack(Material.COAL), "#2d2e2d")
        .setLiquidTexture(SkullTextures.ALLOY_BROWN)
        .setFormNugget(Materials.NUGGET_CAST_COAL.getItemId())
        .setFormIngot(Material.COAL.toString())
        .setFormBlock(Material.COAL_BLOCK.toString())
        .build();

    private static final TinkerMaterial STEEL = new TinkerMaterial(Ids.STEEL, SlimefunItems.STEEL_INGOT, "#d1d1d1")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.CORE_STEEL_HEAD)
        .setTraitToolRod(Traits.CORE_STEEL_ROD)
        .setTraitArmorPlates(Traits.CORE_STEEL_PLATES)
        .setTraitArmorLinks(Traits.CORE_STEEL_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_STEEL.getItemId())
        .setFormIngot(SlimefunItems.STEEL_INGOT.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_STEEL.getItemId())
        .addAlloyRecipe(
            IRON.getLiquidItemStack(2),
            COAL.getLiquidItemStack(4)
        )
        .build();

    private static final TinkerMaterial DAMASCUS_STEEL = new TinkerMaterial(Ids.DAMASCUS_STEEL, SlimefunItems.DAMASCUS_STEEL_INGOT, "#a38c8c")
        .setLiquidTexture(SkullTextures.ALLOY_RED)
        .setTraitToolHead(Traits.CORE_DAMASCUS_STEEL_HEAD)
        .setTraitToolRod(Traits.CORE_DAMASCUS_STEEL_ROD)
        .setTraitArmorPlates(Traits.CORE_DAMASCUS_STEEL_PLATES)
        .setTraitArmorLinks(Traits.CORE_DAMASCUS_STEEL_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_DAMASCUS_STEEL.getItemId())
        .setFormIngot(SlimefunItems.DAMASCUS_STEEL_INGOT.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_DAMASCUS_STEEL.getItemId())
        .addAlloyRecipe(
            STEEL.getLiquidItemStack(1),
            IRON.getLiquidItemStack(2),
            COAL.getLiquidItemStack(8)
        )
        .build();

    private static final TinkerMaterial DURALUMIN = new TinkerMaterial(Ids.DURALUMIN, SlimefunItems.DURALUMIN_INGOT, "#a3a089")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.CORE_DURALUMIN_HEAD)
        .setTraitToolRod(Traits.CORE_DURALUMIN_ROD)
        .setTraitArmorPlates(Traits.CORE_DURALUMIN_PLATES)
        .setTraitArmorLinks(Traits.CORE_DURALUMIN_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_DURALIUM.getItemId())
        .setFormIngot(SlimefunItems.DURALUMIN_INGOT.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_DURALIUM.getItemId())
        .addAlloyRecipe(
            ALUMINUM.getLiquidItemStack(2),
            COPPER.getLiquidItemStack(1)
        )
        .build();

    private static final TinkerMaterial BRONZE = new TinkerMaterial(Ids.BRONZE, SlimefunItems.BRONZE_INGOT, "#877435")
        .setLiquidTexture(SkullTextures.ALLOY_BROWN)
        .setTraitToolHead(Traits.CORE_BRONZE_HEAD)
        .setTraitToolRod(Traits.CORE_BRONZE_ROD)
        .setTraitArmorPlates(Traits.CORE_BRONZE_PLATES)
        .setTraitArmorLinks(Traits.CORE_BRONZE_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_BRONZE.getItemId())
        .setFormIngot(SlimefunItems.BRONZE_INGOT.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_BRONZE.getItemId())
        .addAlloyRecipe(
            COPPER.getLiquidItemStack(2),
            TIN.getLiquidItemStack(1)
        )
        .build();

    private static final TinkerMaterial ALUMINUM_BRONZE = new TinkerMaterial(Ids.ALUMINUM_BRONZE, SlimefunItems.ALUMINUM_BRONZE_INGOT, "#bdaa6d")
        .setLiquidTexture(SkullTextures.ALLOY_TAN)
        .setTraitToolHead(Traits.CORE_ALUMINUM_BRONZE_HEAD)
        .setTraitToolRod(Traits.CORE_ALUMINUM_BRONZE_ROD)
        .setTraitArmorPlates(Traits.CORE_ALUMINUM_BRONZE_PLATES)
        .setTraitArmorLinks(Traits.CORE_ALUMINUM_BRONZE_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_ALU_BRONZE.getItemId())
        .setFormIngot(SlimefunItems.ALUMINUM_BRONZE_INGOT.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_ALU_BRONZE.getItemId())
        .addAlloyRecipe(
            ALUMINUM.getLiquidItemStack(2),
            BRONZE.getLiquidItemStack(1)
        )
        .build();

    private static final TinkerMaterial HARDENED_METAL = new TinkerMaterial(Ids.HARDENED_METAL, SlimefunItems.HARDENED_METAL_INGOT, "#29251a")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.CORE_HARDENED_METAL_HEAD)
        .setTraitToolRod(Traits.CORE_HARDENED_METAL_ROD)
        .setTraitArmorPlates(Traits.CORE_HARDENED_METAL_PLATES)
        .setTraitArmorLinks(Traits.CORE_HARDENED_METAL_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_HARD_METAL.getItemId())
        .setFormIngot(SlimefunItems.HARDENED_METAL_INGOT.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_HARD_METAL.getItemId())
        .addAlloyRecipe(
            ALUMINUM_BRONZE.getLiquidItemStack(1),
            DURALUMIN.getLiquidItemStack(1),
            DAMASCUS_STEEL.getLiquidItemStack(1),
            COAL.getLiquidItemStack(32)
        )
        .build();

    private static final TinkerMaterial CORINTHIAN_BRONZE = new TinkerMaterial(Ids.CORINTHIAN_BRONZE, SlimefunItems.CORINTHIAN_BRONZE_INGOT, "#8a6500")
        .setLiquidTexture(SkullTextures.ALLOY_BROWN)
        .setTraitToolHead(Traits.CORE_CORINTHIAN_BRONZE_HEAD)
        .setTraitToolRod(Traits.CORE_CORINTHIAN_BRONZE_ROD)
        .setTraitArmorPlates(Traits.CORE_CORINTHIAN_BRONZE_PLATES)
        .setTraitArmorLinks(Traits.CORE_CORINTHIAN_BRONZE_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_COR_BRONZE.getItemId())
        .setFormIngot(SlimefunItems.CORINTHIAN_BRONZE_INGOT.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_COR_BRONZE.getItemId())
        .addAlloyRecipe(
            BRONZE.getLiquidItemStack(1),
            GOLD.getLiquidItemStack(1),
            SILVER.getLiquidItemStack(1),
            COPPER.getLiquidItemStack(1)
        )
        .build();

    private static final TinkerMaterial SOLDER = new TinkerMaterial(Ids.SOLDER, SlimefunItems.SOLDER_INGOT, "#b7afbd")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.CORE_SOLDER_HEAD)
        .setTraitToolRod(Traits.CORE_SOLDER_ROD)
        .setTraitArmorPlates(Traits.CORE_SOLDER_PLATES)
        .setTraitArmorLinks(Traits.CORE_SOLDER_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_SOLDER.getItemId())
        .setFormIngot(SlimefunItems.SOLDER_INGOT.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_SOLDER.getItemId())
        .addAlloyRecipe(
            LEAD.getLiquidItemStack(2),
            TIN.getLiquidItemStack(1)
        )
        .build();

    private static final TinkerMaterial BILLON = new TinkerMaterial(Ids.BILLON, SlimefunItems.BILLON_INGOT, "#b0c2be")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.CORE_BILLON_HEAD)
        .setTraitToolRod(Traits.CORE_BILLON_ROD)
        .setTraitArmorPlates(Traits.CORE_BILLON_PLATES)
        .setTraitArmorLinks(Traits.CORE_BILLON_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_BILLON.getItemId())
        .setFormIngot(SlimefunItems.BILLON_INGOT.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_BILLON.getItemId())
        .addAlloyRecipe(
            SILVER.getLiquidItemStack(2),
            COPPER.getLiquidItemStack(1)
        )
        .build();

    private static final TinkerMaterial BRASS = new TinkerMaterial(Ids.BRASS, SlimefunItems.BRASS_INGOT, "#dbcd4b")
        .setLiquidTexture(SkullTextures.ALLOY_TAN)
        .setTraitToolHead(Traits.CORE_BRASS_HEAD)
        .setTraitToolRod(Traits.CORE_BRASS_ROD)
        .setTraitArmorPlates(Traits.CORE_BRASS_PLATES)
        .setTraitArmorLinks(Traits.CORE_BRASS_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_BRASS.getItemId())
        .setFormIngot(SlimefunItems.BRASS_INGOT.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_BRASS.getItemId())
        .addAlloyRecipe(
            COPPER.getLiquidItemStack(2),
            ZINC.getLiquidItemStack(1)
        )
        .build();

    private static final TinkerMaterial ALUMINUM_BRASS = new TinkerMaterial(Ids.ALUMINUM_BRASS, SlimefunItems.ALUMINUM_BRASS_INGOT, "#dbd279")
        .setLiquidTexture(SkullTextures.ALLOY_BROWN)
        .setTraitToolHead(Traits.CORE_ALUMINUM_BRASS_HEAD)
        .setTraitToolRod(Traits.CORE_ALUMINUM_BRASS_ROD)
        .setTraitArmorPlates(Traits.CORE_ALUMINUM_BRASS_PLATES)
        .setTraitArmorLinks(Traits.CORE_ALUMINUM_BRASS_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_ALU_BRASS.getItemId())
        .setFormIngot(SlimefunItems.ALUMINUM_BRASS_INGOT.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_ALU_BRASS.getItemId())
        .addAlloyRecipe(
            BRASS.getLiquidItemStack(1),
            ALUMINUM.getLiquidItemStack(2)
        )
        .build();

    private static final TinkerMaterial NICKEL = new TinkerMaterial(Ids.NICKEL, SlimefunItems.NICKEL_INGOT, "#ebebeb")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.CORE_NICKEL_HEAD)
        .setTraitToolRod(Traits.CORE_NICKEL_ROD)
        .setTraitArmorPlates(Traits.CORE_NICKEL_PLATES)
        .setTraitArmorLinks(Traits.CORE_NICKEL_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_NICKEL.getItemId())
        .setFormIngot(SlimefunItems.NICKEL_INGOT.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_NICKEL.getItemId())
        .addAlloyRecipe(
            IRON.getLiquidItemStack(2),
            COPPER.getLiquidItemStack(1)
        )
        .build();

    private static final TinkerMaterial COBALT = new TinkerMaterial(Ids.COBALT, SlimefunItems.COBALT_INGOT, "#9e9e9e")
        .setLiquidTexture(SkullTextures.ALLOY_BLUE)
        .setTraitToolHead(Traits.CORE_COBALT_HEAD)
        .setTraitToolRod(Traits.CORE_COBALT_ROD)
        .setTraitArmorPlates(Traits.CORE_COBALT_PLATES)
        .setTraitArmorLinks(Traits.CORE_COBALT_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_COBALT.getItemId())
        .setFormIngot(SlimefunItems.COBALT_INGOT.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_COBALT.getItemId())
        .addAlloyRecipe(
            IRON.getLiquidItemStack(1),
            NICKEL.getLiquidItemStack(1),
            COPPER.getLiquidItemStack(1)
        )
        .build();

    private static final TinkerMaterial REINFORCED_ALLOY = new TinkerMaterial(Ids.REINFORCED_ALLOY, SlimefunItems.REINFORCED_ALLOY_INGOT, "#465899")
        .setLiquidTexture(SkullTextures.ALLOY_PURPLE)
        .setTraitToolHead(Traits.CORE_REINFORCED_ALLOY_HEAD)
        .setTraitToolRod(Traits.CORE_REINFORCED_ALLOY_ROD)
        .setTraitArmorPlates(Traits.CORE_REINFORCED_ALLOY_PLATES)
        .setTraitArmorLinks(Traits.CORE_REINFORCED_ALLOY_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_REINFORCED.getItemId())
        .setFormIngot(SlimefunItems.REINFORCED_ALLOY_INGOT.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_REINFORCED.getItemId())
        .addAlloyRecipe(
            DAMASCUS_STEEL.getLiquidItemStack(1),
            HARDENED_METAL.getLiquidItemStack(1),
            CORINTHIAN_BRONZE.getLiquidItemStack(1),
            SOLDER.getLiquidItemStack(1),
            BILLON.getLiquidItemStack(1),
            GOLD.getLiquidItemStack(1)
        )
        .build();

    private static final TinkerMaterial STRING = new TinkerMaterial(Ids.STRING, new ItemStack(Material.STRING), "#f5f5f5")
        .setTraitToolBinder(Traits.CORE_STRING_BINDER)
        .setTraitArmorGambeson(Traits.CORE_STRING_GAMBESON)
        .build();

    private static final TinkerMaterial VINE = new TinkerMaterial(Ids.VINE, new ItemStack(Material.VINE), "#4ca86b")
        .setTraitToolBinder(Traits.CORE_VINE_BINDER)
        .setTraitArmorGambeson(Traits.CORE_VINE_GAMBESON)
        .build();

    private static final TinkerMaterial CRIMSON_ROOTS = new TinkerMaterial(Ids.CRIMSON_ROOTS, new ItemStack(Material.CRIMSON_ROOTS), "#b5365e")
        .setTraitToolBinder(Traits.CORE_CRIMSON_ROOT_BINDER)
        .setTraitArmorGambeson(Traits.CORE_CRIMSON_ROOT_GAMBESON)
        .build();

    private static final TinkerMaterial WARPED_ROOTS = new TinkerMaterial(Ids.WARPED_ROOTS, new ItemStack(Material.WARPED_ROOTS), "#36b549")
        .setTraitToolBinder(Traits.CORE_WARPED_ROOT_BINDER)
        .setTraitArmorGambeson(Traits.CORE_WARPED_ROOT_GAMBESON)
        .build();

    private static final TinkerMaterial WEEPING_VINES = new TinkerMaterial(Ids.WEEPING_VINES, new ItemStack(Material.WEEPING_VINES), "#9c091d")
        .setTraitToolBinder(Traits.CORE_WEEPING_VINE_BINDER)
        .setTraitArmorGambeson(Traits.CORE_WEEPING_VINE_GAMBESON)
        .build();

    private static final TinkerMaterial TWISTING_VINES = new TinkerMaterial(Ids.TWISTING_VINES, new ItemStack(Material.TWISTING_VINES), "#1b8045")
        .setTraitToolBinder(Traits.CORE_TWISTING_VINE_BINDER)
        .setTraitArmorGambeson(Traits.CORE_TWISTING_VINE_GAMBESON)
        .build();

    private static final TinkerMaterial SLIME = new TinkerMaterial(Ids.SLIME, new ItemStack(Material.SLIME_BALL), "#29e01f")
        .setLiquidTexture(SkullTextures.ALLOY_GREEN)
        .setTraitToolBinder(Traits.CORE_SLIME_BINDER)
        .setTraitArmorGambeson(Traits.CORE_SLIME_GAMBESON)
        .build();

    private static final TinkerMaterial REDSTONE = new TinkerMaterial(Ids.REDSTONE, new ItemStack(Material.REDSTONE), "#c4082e")
        .setLiquidTexture(SkullTextures.ALLOY_RED)
        .setFormBlock(Material.REDSTONE_BLOCK.toString())
        .setFormOre(Material.REDSTONE_ORE.toString())
        .setFormGem(Material.REDSTONE.toString())
        .build();

    private static final TinkerMaterial SILICON = new TinkerMaterial(Ids.SILICON, SlimefunItems.SILICON, "#f2f2f2")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolBinder(Traits.CORE_SILICON_BINDER)
        .setTraitArmorGambeson(Traits.CORE_SILICON_GAMBESON)
        .setFormIngot(Material.QUARTZ.toString())
        .setFormBlock(Material.QUARTZ_BLOCK.toString())
        .setFormOre(Material.NETHER_QUARTZ_ORE.toString())
        .setFormGem(SlimefunItems.SILICON.getItemId())
        .build();

    private static final TinkerMaterial LEATHER = new TinkerMaterial(Ids.LEATHER, new ItemStack(Material.LEATHER), "#918056")
        .setTraitToolBinder(Traits.CORE_LEATHER_BINDER)
        .setTraitArmorGambeson(Traits.CORE_LEATHER_GAMBESON)
        .build();

    private static final TinkerMaterial FERROSILICON = new TinkerMaterial(Ids.FERROSILICON, SlimefunItems.FERROSILICON, "#f2f2f2")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.CORE_FERROSILICON_HEAD)
        .setTraitArmorPlates(Traits.CORE_FERROSILICON_PLATES)
        .setTraitArmorLinks(Traits.CORE_FERROSILICON_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_FERROSILICON.getItemId())
        .setFormIngot(SlimefunItems.FERROSILICON.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_FERROSILICON.getItemId())
        .addAlloyRecipe(
            IRON.getLiquidItemStack(2),
            SILICON.getLiquidItemStack(1)
        )
        .build();

    private static final TinkerMaterial REDSTONE_ALLOY = new TinkerMaterial(Ids.REDSTONE_ALLOY, SlimefunItems.REDSTONE_ALLOY, "#700d21")
        .setLiquidTexture(SkullTextures.ALLOY_RED)
        .setTraitToolRod(Traits.CORE_REDSTONE_ALLOY_ROD)
        .setTraitArmorPlates(Traits.CORE_REDSTONE_ALLOY_PLATES)
        .setTraitArmorLinks(Traits.CORE_REDSTONE_ALLOY_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_REDSTONE_ALLOY.getItemId())
        .setFormIngot(SlimefunItems.REDSTONE_ALLOY.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_REDSTONE_ALLOY.getItemId())
        .addAlloyRecipe(
            REDSTONE.getLiquidItemStack(10),
            FERROSILICON.getLiquidItemStack(1),
            HARDENED_METAL.getLiquidItemStack(1)
        )
        .build();

    private static final TinkerMaterial DIAMOND = new TinkerMaterial(Ids.DIAMOND, new ItemStack(Material.DIAMOND), "#5fdde8")
        .setLiquidTexture(SkullTextures.ALLOY_BLUE)
        .setFormBlock(Material.DIAMOND_BLOCK.toString())
        .setFormOre(Material.DIAMOND_ORE.toString())
        .setFormGem(Material.DIAMOND.toString())
        .build();

    private static final TinkerMaterial DRACONIC = new TinkerMaterial(Ids.DRACONIC, new ItemStack(Material.DRAGON_BREATH), "#9532a8")
        .setLiquidTexture(SkullTextures.ALLOY_PURPLE_DEEP)
        .setFormGem(Material.DRAGON_BREATH.toString())
        .build();

    private static final TinkerMaterial BOOMERITE = new TinkerMaterial(Ids.BOOMERITE, Materials.INGOT_CAST_BOOMERITE, "#d94c00")
        .setLiquidTexture(SkullTextures.ALLOY_PURPLE)
        .setTraitToolHead(Traits.CORE_BOOMERITE_HEAD)
        .setTraitArmorPlates(Traits.CORE_BOOMERITE_PLATES)
        .setFormNugget(Materials.NUGGET_CAST_BOOMERITE.getItemId())
        .setFormIngot(Materials.INGOT_CAST_BOOMERITE.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_BOOMERITE.getItemId())
        .addAlloyRecipe(
            REINFORCED_ALLOY.getLiquidItemStack(1),
            CORINTHIAN_BRONZE.getLiquidItemStack(1),
            HARDENED_METAL.getLiquidItemStack(1),
            COPPER.getLiquidItemStack(5)
        )
        .build();

    private static final TinkerMaterial SEFIRITE = new TinkerMaterial(Ids.SEFIRITE, Materials.INGOT_CAST_SEFIRITE, "#9beb34")
        .setLiquidTexture(SkullTextures.ALLOY_GREEN)
        .setTraitArmorPlates(Traits.CORE_SEFIRITE_PLATES)
        .setFormNugget(Materials.NUGGET_CAST_SEFIRITE.getItemId())
        .setFormIngot(Materials.INGOT_CAST_SEFIRITE.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_SEFIRITE.getItemId())
        .build();

    private static final TinkerMaterial LIQUID_CHRISTMAS = new TinkerMaterial(Ids.LIQUID_CHRISTMAS, SlimefunItems.CHRISTMAS_PRESENT, "#00cc36")
        .setLiquidTexture(SkullTextures.ALLOY_GREEN)
        .setFormIngot(SlimefunItems.CHRISTMAS_PRESENT.getItemId())
        .build();

    private static final TinkerMaterial CRINGLEIUM = new TinkerMaterial(Ids.CRINGLEIUM, Materials.INGOT_CAST_CRINGLEIUM, "#00cc36")
        .setLiquidTexture(SkullTextures.ALLOY_GREEN)
        .setTraitArmorLinks(Traits.CORE_CRINGLEIUM_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_CRINGLEIUM.getItemId())
        .setFormIngot(Materials.INGOT_CAST_CRINGLEIUM.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_CRINGLEIUM.getItemId())
        .addAlloyRecipe(
            REINFORCED_ALLOY.getLiquidItemStack(2),
            LIQUID_CHRISTMAS.getLiquidItemStack(3),
            MAGNESIUM.getLiquidItemStack(2)
        )
        .build();

    private static final TinkerMaterial FLOWING_FONDNESS = new TinkerMaterial(Ids.FLOWING_FONDNESS, SlimefunItems.RAINBOW_GLASS_VALENTINE, "#eb34d2")
        .setLiquidTexture(SkullTextures.ALLOY_PINK)
        .setFormNugget(Materials.NUGGET_CAST_FONDNESS.getItemId())
        .setFormIngot(Materials.INGOT_CAST_FONDNESS.getItemId())
        .setFormBlock(SlimefunItems.RAINBOW_GLASS_VALENTINE.getItemId())
        .build();

    private static final TinkerMaterial DETAILED_DEVOTION = new TinkerMaterial(Ids.DETAILED_DEVOTION, SlimefunItems.RAINBOW_CONCRETE_VALENTINE, "#e68cd9")
        .setLiquidTexture(SkullTextures.ALLOY_PINK)
        .setFormNugget(Materials.NUGGET_CAST_DEVOTION.getItemId())
        .setFormIngot(Materials.INGOT_CAST_DEVOTION.getItemId())
        .setFormBlock(SlimefunItems.RAINBOW_CONCRETE_VALENTINE.getItemId())
        .build();

    private static final TinkerMaterial PURIFIED_PASSION = new TinkerMaterial(Ids.PURIFIED_PASSION, SlimefunItems.RAINBOW_GLAZED_TERRACOTTA_VALENTINE, "#471240")
        .setLiquidTexture(SkullTextures.ALLOY_PINK)
        .setFormNugget(Materials.NUGGET_CAST_PASSION.getItemId())
        .setFormIngot(Materials.INGOT_CAST_PASSION.getItemId())
        .setFormBlock(SlimefunItems.RAINBOW_GLAZED_TERRACOTTA_VALENTINE.getItemId())
        .build();

    private static final TinkerMaterial LIQUID_LOVE = new TinkerMaterial(Ids.LIQUID_LOVE, Materials.INGOT_CAST_LOVE, "#eb34d2")
        .setLiquidTexture(SkullTextures.ALLOY_PINK)
        .setFormNugget(Materials.NUGGET_CAST_LOVE.getItemId())
        .setFormIngot(Materials.INGOT_CAST_LOVE.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_LOVE.getItemId())
        .setTraitArmorLinks(Traits.CORE_LOVE_LINKS)
        .addAlloyRecipe(
            FLOWING_FONDNESS.getLiquidItemStack(1),
            DETAILED_DEVOTION.getLiquidItemStack(1),
            PURIFIED_PASSION.getLiquidItemStack(1)
        )
        .build();

    private static final TinkerMaterial NICEINIUM = new TinkerMaterial(Ids.NICEINIUM, Materials.INGOT_CAST_NICE, "#80550d")
        .setLiquidTexture(SkullTextures.ALLOY_TAN)
        .setFormNugget(Materials.NUGGET_CAST_NICE.getItemId())
        .setFormIngot(Materials.INGOT_CAST_NICE.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_NICE.getItemId())
        .setTraitToolHead(Traits.CORE_NICEINIUM_HEAD)
        .addAlloyRecipe(
            REINFORCED_ALLOY.getLiquidItemStack(3),
            HARDENED_METAL.getLiquidItemStack(3),
            REDSTONE.getLiquidItemStack(10),
            DIAMOND.getLiquidItemStack(5)
        )
        .build();

    static {
        CM_MAP.put(Ids.IRON, IRON);
        CM_MAP.put(Ids.GOLD, GOLD);
        CM_MAP.put(Ids.COPPER, COPPER);
        CM_MAP.put(Ids.LEAD, LEAD);
        CM_MAP.put(Ids.SILVER, SILVER);
        CM_MAP.put(Ids.ALUMINUM, ALUMINUM);
        CM_MAP.put(Ids.TIN, TIN);
        CM_MAP.put(Ids.ZINC, ZINC);
        CM_MAP.put(Ids.MAGNESIUM, MAGNESIUM);
        CM_MAP.put(Ids.COAL, COAL);
        CM_MAP.put(Ids.STEEL, STEEL);
        CM_MAP.put(Ids.DAMASCUS_STEEL, DAMASCUS_STEEL);
        CM_MAP.put(Ids.DURALUMIN, DURALUMIN);
        CM_MAP.put(Ids.BRONZE, BRONZE);
        CM_MAP.put(Ids.ALUMINUM_BRONZE, ALUMINUM_BRONZE);
        CM_MAP.put(Ids.HARDENED_METAL, HARDENED_METAL);
        CM_MAP.put(Ids.CORINTHIAN_BRONZE, CORINTHIAN_BRONZE);
        CM_MAP.put(Ids.SOLDER, SOLDER);
        CM_MAP.put(Ids.BILLON, BILLON);
        CM_MAP.put(Ids.BRASS, BRASS);
        CM_MAP.put(Ids.ALUMINUM_BRASS, ALUMINUM_BRASS);
        CM_MAP.put(Ids.NICKEL, NICKEL);
        CM_MAP.put(Ids.COBALT, COBALT);
        CM_MAP.put(Ids.REINFORCED_ALLOY, REINFORCED_ALLOY);
        CM_MAP.put(Ids.STRING, STRING);
        CM_MAP.put(Ids.VINE, VINE);
        CM_MAP.put(Ids.CRIMSON_ROOTS, CRIMSON_ROOTS);
        CM_MAP.put(Ids.WARPED_ROOTS, WARPED_ROOTS);
        CM_MAP.put(Ids.WEEPING_VINES, WEEPING_VINES);
        CM_MAP.put(Ids.TWISTING_VINES, TWISTING_VINES);
        CM_MAP.put(Ids.SLIME, SLIME);
        CM_MAP.put(Ids.REDSTONE, REDSTONE);
        CM_MAP.put(Ids.SILICON, SILICON);
        CM_MAP.put(Ids.LEATHER, LEATHER);
        CM_MAP.put(Ids.FERROSILICON, FERROSILICON);
        CM_MAP.put(Ids.REDSTONE_ALLOY, REDSTONE_ALLOY);
        CM_MAP.put(Ids.DIAMOND, DIAMOND);
        CM_MAP.put(Ids.DRACONIC, DRACONIC);
        CM_MAP.put(Ids.BOOMERITE, BOOMERITE);
        CM_MAP.put(Ids.SEFIRITE, SEFIRITE);
        CM_MAP.put(Ids.LIQUID_CHRISTMAS, LIQUID_CHRISTMAS);
        CM_MAP.put(Ids.CRINGLEIUM, CRINGLEIUM);
        CM_MAP.put(Ids.FLOWING_FONDNESS, FLOWING_FONDNESS);
        CM_MAP.put(Ids.DETAILED_DEVOTION, DETAILED_DEVOTION);
        CM_MAP.put(Ids.PURIFIED_PASSION, PURIFIED_PASSION);
        CM_MAP.put(Ids.LIQUID_LOVE, LIQUID_LOVE);
        CM_MAP.put(Ids.NICEINIUM, NICEINIUM);
    }

    public static Map<String, TinkerMaterial> getCmMap() {
        return CM_MAP;
    }
}
