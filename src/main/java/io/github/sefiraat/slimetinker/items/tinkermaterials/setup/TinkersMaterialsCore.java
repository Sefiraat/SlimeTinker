package io.github.sefiraat.slimetinker.items.tinkermaterials.setup;

import io.github.sefiraat.slimetinker.events.BlockBreakEvents;
import io.github.sefiraat.slimetinker.events.DurabilityEvents;
import io.github.sefiraat.slimetinker.events.EntityDamageEvents;
import io.github.sefiraat.slimetinker.events.PlayerDamagedEvents;
import io.github.sefiraat.slimetinker.events.RightClickEvents;
import io.github.sefiraat.slimetinker.events.TickEvents;
import io.github.sefiraat.slimetinker.events.friend.TraitEventType;
import io.github.sefiraat.slimetinker.events.friend.TraitPartType;
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
        .setTraitToolRod(Traits.CORE_ALUMINUM_ROD)
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
        );

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
        .build();

    private static final TinkerMaterial LIQUID_CHRISTMAS = new TinkerMaterial(Ids.LIQUID_CHRISTMAS, SlimefunItems.CHRISTMAS_PRESENT, "#00cc36")
        .setLiquidTexture(SkullTextures.ALLOY_GREEN)
        .setFormIngot(SlimefunItems.CHRISTMAS_PRESENT.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_SEFIRITE.getItemId())
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
        CM_MAP.put(Ids.BOOMERITE, BOOMERITE);
        CM_MAP.put(Ids.SEFIRITE, SEFIRITE);
        CM_MAP.put(Ids.LIQUID_CHRISTMAS, LIQUID_CHRISTMAS);
        CM_MAP.put(Ids.CRINGLEIUM, CRINGLEIUM);

        setupToolConsumers();
        setupArmourConsumers();
    }

    public static void setupToolConsumers() {

        CM_MAP.get(Ids.ALUMINUM_BRASS).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headAluBrass);          // Abra
        CM_MAP.get(Ids.GOLD).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodGold);                                      // All that glitters
        CM_MAP.get(Ids.TWISTING_VINES).addEvent(TraitEventType.TICK, TraitPartType.BINDER, TickEvents::binderTwistingVine);               // Attraction
        CM_MAP.get(Ids.COPPER).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headCopper);              // Brains not brawn - Damage
        CM_MAP.get(Ids.COPPER).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headCopper);                   // Brains not brawn - Block Break
        CM_MAP.get(Ids.ALUMINUM_BRONZE).addEvent(TraitEventType.DURABILITY, TraitPartType.ROD, DurabilityEvents::rodAluBronze);                // Brittle
        CM_MAP.get(Ids.REINFORCED_ALLOY).addEvent(TraitEventType.DURABILITY, TraitPartType.HEAD, DurabilityEvents::explosive);                 // Bulky (explosive)
        CM_MAP.get(Ids.TIN).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodTin);                                        // Can
        CM_MAP.get(Ids.SEFIRITE).addEvent(TraitEventType.RIGHT_CLICK, TraitPartType.HEAD, RightClickEvents::headSefirite);               // Celebrate
        CM_MAP.get(Ids.NICKEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::charged);                 // Charged A (Head)
        CM_MAP.get(Ids.NICKEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::charged);                  // Charged A (Rod)
        CM_MAP.get(Ids.COBALT).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::charged);                 // Charged B (Head)
        CM_MAP.get(Ids.COBALT).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::charged);                  // Charged B (Rod)
        // Conductive (Special case - in Experience.java, should be moved out)
        CM_MAP.get(Ids.CRIMSON_ROOTS).addEvent(TraitEventType.TICK, TraitPartType.BINDER, TickEvents::binderCrimsonRoot);                // Decay
        CM_MAP.get(Ids.WEEPING_VINES).addEvent(TraitEventType.TICK, TraitPartType.BINDER, TickEvents::binderWeepingVine);                // Doom
        CM_MAP.get(Ids.DURALUMIN).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headDuralium);          // Durable - Entity Damage - Damage Reduction + No Exp
        CM_MAP.get(Ids.DURALUMIN).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headDuralium);               // Durable - Block Break -  No Exp
        CM_MAP.get(Ids.DURALUMIN).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headDuralium);                            // Durable - Tick
        // Easy Fix (Special case - in RepairBench.java. Will have to stay there)
        // Enchanting (Special case - in Experience.java - could be moved if I raise an event)
        CM_MAP.get(Ids.BILLON).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headBillon);                                // Fast
        CM_MAP.get(Ids.MAGNESIUM).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headMagnesium);        // Flammable
        CM_MAP.get(Ids.CORINTHIAN_BRONZE).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headCorbronze);             // Flaming Hot
        // Fused (Special Case - in EntityKilledListener.java and DropItemListener.java - likely wont move
        CM_MAP.get(Ids.GOLD).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headGold);                  // Golden Veil - Damage
        CM_MAP.get(Ids.GOLD).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headGold);                                    // Golden Veil - Tick
        CM_MAP.get(Ids.ZINC).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headZinc);                                    // Graceful
        CM_MAP.get(Ids.VINE).addEvent(TraitEventType.TICK, TraitPartType.BINDER, TickEvents::binderVine);                                // Growth
        CM_MAP.get(Ids.HARDENED_METAL).addEvent(TraitEventType.DURABILITY, TraitPartType.ROD, DurabilityEvents::explosive);                        // Heavy (explosive)
        CM_MAP.get(Ids.SOLDER).addEvent(TraitEventType.DURABILITY, TraitPartType.HEAD, DurabilityEvents::headSolder);                    // Hidden - Durability
        CM_MAP.get(Ids.SOLDER).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headSolder);                                // Hidden - Tick
        CM_MAP.get(Ids.FERROSILICON).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.HEAD, PlayerDamagedEvents::headFerrosilicon); // Hydrogen
        CM_MAP.get(Ids.BRONZE).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodBronze);                                  // Ingheights
        CM_MAP.get(Ids.BOOMERITE).addEvent(TraitEventType.RIGHT_CLICK, TraitPartType.HEAD, RightClickEvents::headBoomerite);             // Ladder Simulator™
        CM_MAP.get(Ids.LEAD).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodLead);                                      // Leech
        CM_MAP.get(Ids.REDSTONE_ALLOY).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodRedstoneAlloy); // Lightning Rod
        CM_MAP.get(Ids.STEEL).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodSteel);                                    // Lightweight
        CM_MAP.get(Ids.MAGNESIUM).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodMagnesium);                            // Magnetisium
        CM_MAP.get(Ids.TIN).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headTin);                    // Malleable - Damage
        CM_MAP.get(Ids.TIN).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headTin);                                      // Malleable - Tick
        CM_MAP.get(Ids.DAMASCUS_STEEL).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodDamsteel);                              // Night Stalker
        CM_MAP.get(Ids.BRASS).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodBrass);                                    // Oxygenated
        CM_MAP.get(Ids.LEAD).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headLead);                  // Poisonous
        CM_MAP.get(Ids.ALUMINUM).addEvent(TraitEventType.DURABILITY, TraitPartType.HEAD, DurabilityEvents::headAluminum);                // Recycleable
        CM_MAP.get(Ids.WARPED_ROOTS).addEvent(TraitEventType.TICK, TraitPartType.BINDER, TickEvents::bindWarpedRoot);                    // Refreshing
        // Reinforced (Special Case - nested within plate mod. Will be moved when mods are changed to consumers)
        CM_MAP.get(Ids.BRONZE).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headBronze);                                // Resistant
        CM_MAP.get(Ids.IRON).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodIron);                                      // Sharp I
        CM_MAP.get(Ids.ALUMINUM_BRONZE).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headAlubronze);                          // Sharp II
        CM_MAP.get(Ids.SILICON).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.BINDER, BlockBreakEvents::bindSilicon);               // Slow Learner
        CM_MAP.get(Ids.SLIME).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.BINDER, PlayerDamagedEvents::bindSlime);             // Slimey
        CM_MAP.get(Ids.ALUMINUM).addEvent(TraitEventType.DURABILITY, TraitPartType.ROD, DurabilityEvents::rodAluminum);                  // Soft - Durability
        CM_MAP.get(Ids.ALUMINUM).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodAluminum);            // Soft - Damage
        CM_MAP.get(Ids.ALUMINUM).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.ROD, BlockBreakEvents::rodAluminum);                 // Soft - Block Break
        CM_MAP.get(Ids.SILVER).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodSilver);                                  // Soft Touch
        CM_MAP.get(Ids.BILLON).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodBillon);                                  // Springs
        // Stability (Special Case, doesn't do anything, just here for consistency)
        CM_MAP.get(Ids.STEEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headSteel);                // Stainless
        CM_MAP.get(Ids.BRASS).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headBrass);                // Stiff - Damage
        CM_MAP.get(Ids.BRASS).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headBrass);                                  // Stiff - Tick
        CM_MAP.get(Ids.ALUMINUM_BRASS).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodAlubrass);            // Studious - Damage
        CM_MAP.get(Ids.ALUMINUM_BRASS).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.ROD, BlockBreakEvents::rodAluBrass);                 // Studious - Block Break
        CM_MAP.get(Ids.ZINC).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodZinc);                                      // Super Light Weight
        CM_MAP.get(Ids.LEATHER).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.BINDER, EntityDamageEvents::binderLeather);        // Thick - Exp Entity Damage
        CM_MAP.get(Ids.LEATHER).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.BINDER, BlockBreakEvents::binderLeather);             // Thick - Exp Block Break
        CM_MAP.get(Ids.CORINTHIAN_BRONZE).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodCorbronze);                            // Too Hot to Handle
        CM_MAP.get(Ids.HARDENED_METAL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::headHard);                   // Tuff Stuff
        CM_MAP.get(Ids.DAMASCUS_STEEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headDamsteel);          // Vampirism
        // Works (Special Case, doesn't do anything, just here for consistency)
    }

    public static void setupArmourConsumers() {

        CM_MAP.get(Ids.ZINC).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksZinc);               // Acupuncture
        CM_MAP.get(Ids.TWISTING_VINES).addEvent(TraitEventType.TICK, TraitPartType.GAMBESON, TickEvents::gambesonTwistingWines);          // Attraction
        CM_MAP.get(Ids.BRASS).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateBrass);             // Band
        CM_MAP.get(Ids.BRASS).addEvent(TraitEventType.DURABILITY, TraitPartType.PLATE, DurabilityEvents::plateBrass);                    // Band
        CM_MAP.get(Ids.GOLD).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksGold);                                  // Barter
        CM_MAP.get(Ids.ALUMINUM_BRONZE).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateAluBronze);                        // Beautiful
        CM_MAP.get(Ids.COPPER).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateCopper);           // Beginner - Damage mod
        CM_MAP.get(Ids.COPPER).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.PLATE, EntityDamageEvents::plateCopper);            // Beginner - EXP Gain
        CM_MAP.get(Ids.TIN).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksTin);                 // Boost
        CM_MAP.get(Ids.SLIME).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.GAMBESON, PlayerDamagedEvents::gambesonSlime);       // Bouncy
        CM_MAP.get(Ids.FERROSILICON).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::brightBurn);                         // Brightburn
        CM_MAP.get(Ids.BRASS).addEvent(TraitEventType.DURABILITY, TraitPartType.LINKS, DurabilityEvents::linksBrass);                    // Brittle
        CM_MAP.get(Ids.DAMASCUS_STEEL).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateDamSteel);                          // Compounding
        CM_MAP.get(Ids.SILVER).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateSilver);           // Conductive
        CM_MAP.get(Ids.CRIMSON_ROOTS).addEvent(TraitEventType.TICK, TraitPartType.GAMBESON, TickEvents::gambesonCrimsonRoots);           // Decay
        CM_MAP.get(Ids.WEEPING_VINES).addEvent(TraitEventType.TICK, TraitPartType.GAMBESON, TickEvents::gambesonWeepingVines);           // Doom
        CM_MAP.get(Ids.DURALUMIN).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateDuralium);       // Durable (Working trait is done via ItemUtils#doesNotUnequip(ItemStack)
        CM_MAP.get(Ids.HARDENED_METAL).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.LINKS, BlockBreakEvents::linksHardened);                 // Dwarven Skills
        // Easily Shaped (In RepairBench)
        CM_MAP.get(Ids.ALUMINUM_BRONZE).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksAluBronze);     // Eject!
        // Enchanting (Experience)
        CM_MAP.get(Ids.ALUMINUM_BRASS).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksAluBrass);       // Escape
        CM_MAP.get(Ids.BRONZE).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.PLATE, BlockBreakEvents::plateBronze);                 // Farmer
        CM_MAP.get(Ids.CRINGLEIUM).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksCringleium);                      // Feeling Festive
        CM_MAP.get(Ids.ALUMINUM).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateAluminum);       // Foil 50% damage
        CM_MAP.get(Ids.ALUMINUM).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateAluminum);                          // Foil +1 speed
        // Fused
        CM_MAP.get(Ids.BOOMERITE).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateBoomerite);                        // Go Boomer
        CM_MAP.get(Ids.VINE).addEvent(TraitEventType.TICK, TraitPartType.GAMBESON, TickEvents::gambesonVine);                            // Growth
        CM_MAP.get(Ids.STEEL).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateSteel);             // Hardy
        CM_MAP.get(Ids.BILLON).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksBillon);           // Heat Conductor
        CM_MAP.get(Ids.BRASS).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksBrass);             // Help
        CM_MAP.get(Ids.MAGNESIUM).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.PLATE, EntityDamageEvents::plateMagnesium);      // Light - Player Damage
        CM_MAP.get(Ids.MAGNESIUM).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateMagnesium);                        // Light - Speed
        CM_MAP.get(Ids.MAGNESIUM).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksMagnesium);                        // Magnesight
        CM_MAP.get(Ids.COBALT).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateCobalt);                              // Magnetic -
        CM_MAP.get(Ids.COBALT).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksCobalt);                              // Magnetic -
        CM_MAP.get(Ids.NICKEL).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateNickel);                              // Magnetic +
        CM_MAP.get(Ids.NICKEL).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksNickel);                              // Magnetic +
        CM_MAP.get(Ids.ALUMINUM_BRASS).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateAluBrass);       // Magus
        CM_MAP.get(Ids.TIN).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateTin);                 // Non-corrosive
        CM_MAP.get(Ids.REDSTONE_ALLOY).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateRedstoneAlloy);               // Powered On
        CM_MAP.get(Ids.GOLD).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateGold);               // Prosperous
        CM_MAP.get(Ids.WARPED_ROOTS).addEvent(TraitEventType.TICK, TraitPartType.GAMBESON, TickEvents::gambesonWarpedRoots);             // Refreshing
        // Reinforcable (Special Case - nested within plate mod. Will be moved when mods are changed to consumers)
        CM_MAP.get(Ids.IRON).addEvent(TraitEventType.TICK, TraitPartType.LINKS, EntityDamageEvents::linksIron);                          // Rusty
        CM_MAP.get(Ids.DURALUMIN).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksDuralium);       // Shock Absorbant
        CM_MAP.get(Ids.LEAD).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateLead);                                  // Sickly (plate)
        CM_MAP.get(Ids.LEAD).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksLead);                                  // Sickly (links)
        CM_MAP.get(Ids.SILICON).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.GAMBESON, EntityDamageEvents::gambesonSilicon);    // Slow Learner
        CM_MAP.get(Ids.ZINC).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.PLATE, EntityDamageEvents::plateZinc);                // Sneaky
        CM_MAP.get(Ids.DAMASCUS_STEEL).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksDamSteel);       // Snroht
        CM_MAP.get(Ids.SOLDER).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateSolder);           // Soft Landing
        CM_MAP.get(Ids.FERROSILICON).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateFerrosilicon);                  // Solar Powered
        CM_MAP.get(Ids.IRON).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateIron);               // Steadfast
        CM_MAP.get(Ids.STEEL).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksSteel);                                // Strong
        CM_MAP.get(Ids.CORINTHIAN_BRONZE).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateCorBronze);                        // SuperHot
        CM_MAP.get(Ids.COPPER).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.LINKS, EntityDamageEvents::linksCopper);            // Tarnished
        CM_MAP.get(Ids.LEATHER).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.GAMBESON, EntityDamageEvents::gambesonLeather);    // Thick Hide
        CM_MAP.get(Ids.HARDENED_METAL).addEvent(TraitEventType.DURABILITY, TraitPartType.PLATE, DurabilityEvents::plateHardened);                  // Toughened
        CM_MAP.get(Ids.CORINTHIAN_BRONZE).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksCorBronze);                        // Warm Blooded
        CM_MAP.get(Ids.BILLON).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.PLATE, EntityDamageEvents::plateBillon);            // WHM
        CM_MAP.get(Ids.REDSTONE_ALLOY).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksRedstoneAlloy);               // Who needs pressure plates
        CM_MAP.get(Ids.REINFORCED_ALLOY).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksReinforced);   // Witherproof
        // Works
    }

    public static Map<String, TinkerMaterial> getCmMap() {
        return CM_MAP;
    }
}
