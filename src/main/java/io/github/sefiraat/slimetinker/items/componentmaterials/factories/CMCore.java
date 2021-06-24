package io.github.sefiraat.slimetinker.items.componentmaterials.factories;

import io.github.sefiraat.slimetinker.events.BlockBreakEvents;
import io.github.sefiraat.slimetinker.events.DurabilityEvents;
import io.github.sefiraat.slimetinker.events.EntityDamageEvents;
import io.github.sefiraat.slimetinker.events.TickEvents;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMAlloy;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMForms;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMLiquid;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMToolMakeup;
import io.github.sefiraat.slimetinker.items.componentmaterials.ComponentMaterial;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
public final class CMCore {

    @Getter
    private static final Map<String, ComponentMaterial> map = new HashMap<>();

    static {
        map.put(IDStrings.IRON,
                new ComponentMaterial
                        (
                                IDStrings.IRON,
                                "#8c8c8c",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Material.IRON_NUGGET.toString(),
                                    Material.IRON_INGOT.toString(),
                                    Material.IRON_BLOCK.toString(),
                                    Material.IRON_ORE.toString(),
                                    null,
                                    SlimefunItems.IRON_DUST.getItemId(),
                                    Material.IRON_BOOTS.toString(),
                                    Material.IRON_LEGGINGS.toString(),
                                    Material.IRON_CHESTPLATE.toString(),
                                    Material.IRON_HELMET.toString()
                                ),
                                new CMLiquid(
                                        IDStrings.IRON,
                                        SkullTextures.ALLOY_SILVER,
                                        new ItemStack(Material.IRON_INGOT)
                                ),
                                null
                        ));
        map.put(IDStrings.GOLD,
                new ComponentMaterial
                        (
                                IDStrings.GOLD,
                                "#ffe138",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Material.GOLD_NUGGET.toString(),
                                    Material.GOLD_INGOT.toString(),
                                    Material.GOLD_BLOCK.toString(),
                                    Material.GOLD_ORE.toString(),
                                    null,
                                    SlimefunItems.GOLD_DUST.getItemId(),
                                    Material.GOLDEN_BOOTS.toString(),
                                    Material.GOLDEN_LEGGINGS.toString(),
                                    Material.GOLDEN_CHESTPLATE.toString(),
                                    Material.GOLDEN_HELMET.toString()
                                ),
                                new CMLiquid(
                                        IDStrings.GOLD,
                                        SkullTextures.ALLOY_RED,
                                        new ItemStack(Material.GOLD_INGOT)
                                ),
                                null
                        ));
        map.put(IDStrings.COPPER,
                new ComponentMaterial
                        (
                                IDStrings.COPPER,
                                "#c99732",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_COPPER.getItemId(),
                                    SlimefunItems.COPPER_INGOT.getItemId(),
                                    Materials.BLOCK_CAST_COPPER.getItemId(),
                                    null,
                                    null,
                                    SlimefunItems.COPPER_DUST.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.COPPER,
                                        SkullTextures.ALLOY_BROWN,
                                        SlimefunItems.COPPER_DUST.getItem().getItem()
                                ),
                                null
                        ));
        map.put(IDStrings.LEAD,
                new ComponentMaterial
                        (
                                IDStrings.LEAD,
                                "#9043ba",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_LEAD.getItemId(),
                                    SlimefunItems.LEAD_INGOT.getItemId(),
                                    Materials.BLOCK_CAST_LEAD.getItemId(),
                                    null,
                                    null,
                                    SlimefunItems.COPPER_DUST.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.LEAD,
                                        SkullTextures.ALLOY_PURPLE,
                                        SlimefunItems.LEAD_DUST.getItem().getItem()
                                ),
                                null
                        ));
        map.put(IDStrings.SILVER,
                new ComponentMaterial
                        (
                                IDStrings.SILVER,
                                "#d4d4d4",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_SILVER.getItemId(),
                                    SlimefunItems.SILVER_INGOT.getItemId(),
                                    Materials.BLOCK_CAST_SILVER.getItemId(),
                                    null,
                                    null,
                                    SlimefunItems.SILVER_DUST.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SILVER,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItems.SILVER_DUST.getItem().getItem()
                                ),
                                null
                        ));
        map.put(IDStrings.ALUMINUM,
                new ComponentMaterial
                        (
                                IDStrings.ALUMINUM,
                                "#b0b0b0",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_ALUMINUM.getItemId(),
                                    SlimefunItems.ALUMINUM_INGOT.getItemId(),
                                    Materials.BLOCK_CAST_ALUMINUM.getItemId(),
                                    null,
                                    null,
                                    SlimefunItems.ALUMINUM_DUST.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.ALUMINUM,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItems.ALUMINUM_DUST.getItem().getItem()
                                ),
                                null
                        ));
        map.put(IDStrings.TIN,
                new ComponentMaterial
                        (
                                IDStrings.TIN,
                                "#a89b9b",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_TIN.getItemId(),
                                    SlimefunItems.TIN_INGOT.getItemId(),
                                    Materials.BLOCK_CAST_TIN.getItemId(),
                                    null,
                                    null,
                                    SlimefunItems.TIN_DUST.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.TIN,
                                        SkullTextures.ALLOY_BLUE_PALE,
                                        SlimefunItems.TIN_DUST.getItem().getItem()
                                ),
                                null
                        ));
        map.put(IDStrings.ZINC,
                new ComponentMaterial
                        (
                                IDStrings.ZINC,
                                "#9ba8a6",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_ZINC.getItemId(),
                                    SlimefunItems.ZINC_INGOT.getItemId(),
                                    Materials.BLOCK_CAST_ZINC.getItemId(),
                                    null,
                                    null,
                                    SlimefunItems.ZINC_DUST.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.ZINC,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItems.ZINC_DUST.getItem().getItem()
                                ),
                                null
                        ));
        map.put(IDStrings.MAGNESIUM,
                new ComponentMaterial
                        (
                                IDStrings.MAGNESIUM,
                                "#e8cef5",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_MAGNESIUM.getItemId(),
                                    SlimefunItems.MAGNESIUM_INGOT.getItemId(),
                                    Materials.BLOCK_CAST_MAGNESIUM.getItemId(),
                                    null,
                                    null,
                                    SlimefunItems.MAGNESIUM_DUST.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.MAGNESIUM,
                                        SkullTextures.ALLOY_PINK,
                                        SlimefunItems.MAGNESIUM_DUST.getItem().getItem()
                                ),
                                null
                        ));
        map.put(IDStrings.COAL,
                new ComponentMaterial
                        (
                                IDStrings.COAL,
                                "#2d2e2d",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_COAL.getItemId(),
                                    Material.COAL.toString(),
                                    Material.COAL_BLOCK.toString(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.COAL,
                                        SkullTextures.ALLOY_BROWN,
                                        new ItemStack(Material.COAL)
                                ),
                                null
                        ));
        map.put(IDStrings.STEEL,
                new ComponentMaterial
                        (
                                IDStrings.STEEL,
                                "#d1d1d1",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_STEEL.getItemId(),
                                    SlimefunItems.STEEL_INGOT.getItemId(),
                                    Materials.BLOCK_CAST_STEEL.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.STEEL,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItems.STEEL_INGOT.getItem().getItem()
                                ),
                                new CMAlloy(
                                        IDStrings.STEEL,
                                        SkullTextures.ALLOY_SILVER,
                                        Arrays.asList(
                                                map.get(IDStrings.IRON).getLiquidItemStack(2),
                                                map.get(IDStrings.COAL).getLiquidItemStack(4)
                                        )
                                )
                        ));
        map.put(IDStrings.DAMSTEEL,
                new ComponentMaterial
                        (
                                IDStrings.DAMSTEEL,
                                "#a38c8c",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_DAMASCUS_STEEL.getItemId(),
                                    SlimefunItems.DAMASCUS_STEEL_INGOT.getItemId(),
                                    Materials.BLOCK_CAST_DAMASCUS_STEEL.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.DAMSTEEL,
                                        SkullTextures.ALLOY_RED,
                                        SlimefunItems.DAMASCUS_STEEL_INGOT.getItem().getItem()
                                ),
                                new CMAlloy(
                                        IDStrings.DAMSTEEL,
                                        SkullTextures.ALLOY_RED,
                                        Arrays.asList(
                                                map.get(IDStrings.STEEL).getLiquidItemStack(1),
                                                map.get(IDStrings.IRON).getLiquidItemStack(2),
                                                map.get(IDStrings.COAL).getLiquidItemStack(8)
                                        )
                                )
                        ));
        map.put(IDStrings.DURALIUM,
                new ComponentMaterial
                        (
                                IDStrings.DURALIUM,
                                "#a3a089",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_DURALIUM.getItemId(),
                                    SlimefunItems.DURALUMIN_INGOT.getItemId(),
                                    Materials.BLOCK_CAST_DURALIUM.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.DURALIUM,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItems.DURALUMIN_INGOT.getItem().getItem()
                                ),
                                new CMAlloy(
                                        IDStrings.DURALIUM,
                                        SkullTextures.ALLOY_SILVER,
                                        Arrays.asList(
                                                map.get(IDStrings.ALUMINUM).getLiquidItemStack(2),
                                                map.get(IDStrings.COPPER).getLiquidItemStack(1)
                                        )
                                )
                        ));
        map.put(IDStrings.BRONZE,
                new ComponentMaterial
                        (
                                IDStrings.BRONZE,
                                "#877435",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_BRONZE.getItemId(),
                                    SlimefunItems.BRONZE_INGOT.getItemId(),
                                    Materials.BLOCK_CAST_BRONZE.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.BRONZE,
                                        SkullTextures.ALLOY_BROWN,
                                        SlimefunItems.BRONZE_INGOT.getItem().getItem()
                                ),
                                new CMAlloy(
                                        IDStrings.BRONZE,
                                        SkullTextures.ALLOY_BROWN,
                                        Arrays.asList(
                                                map.get(IDStrings.COPPER).getLiquidItemStack(2),
                                                map.get(IDStrings.TIN).getLiquidItemStack(1)
                                        )
                                )
                        ));
        map.put(IDStrings.ALUBRONZE,
                new ComponentMaterial
                        (
                                IDStrings.ALUBRONZE,
                                "#bdaa6d",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_ALU_BRONZE.getItemId(),
                                    SlimefunItems.ALUMINUM_BRONZE_INGOT.getItemId(),
                                    Materials.BLOCK_CAST_ALU_BRONZE.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.ALUBRONZE,
                                        SkullTextures.ALLOY_TAN,
                                        SlimefunItems.ALUMINUM_BRONZE_INGOT.getItem().getItem()
                                ),
                                new CMAlloy(
                                        IDStrings.ALUBRONZE,
                                        SkullTextures.ALLOY_TAN,
                                        Arrays.asList(
                                                map.get(IDStrings.ALUMINUM).getLiquidItemStack(2),
                                                map.get(IDStrings.BRONZE).getLiquidItemStack(1)
                                        )
                                )
                        ));
        map.put(IDStrings.HARD,
                new ComponentMaterial
                        (
                                IDStrings.HARD,
                                "#29251a",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_HARD_METAL.getItemId(),
                                    SlimefunItems.HARDENED_METAL_INGOT.getItemId(),
                                    Materials.BLOCK_CAST_HARD_METAL.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.HARD,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItems.HARDENED_METAL_INGOT.getItem().getItem()
                                ),
                                new CMAlloy(
                                        IDStrings.HARD,
                                        SkullTextures.ALLOY_SILVER,
                                        Arrays.asList(
                                                map.get(IDStrings.ALUBRONZE).getLiquidItemStack(1),
                                                map.get(IDStrings.DURALIUM).getLiquidItemStack(1),
                                                map.get(IDStrings.DAMSTEEL).getLiquidItemStack(1),
                                                map.get(IDStrings.COAL).getLiquidItemStack(32)
                                        )
                                )
                        ));
        map.put(IDStrings.CORBRONZE,
                new ComponentMaterial
                        (
                                IDStrings.CORBRONZE,
                                "#8a6500",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_COR_BRONZE.getItemId(),
                                    SlimefunItems.CORINTHIAN_BRONZE_INGOT.getItemId(),
                                    Materials.BLOCK_CAST_COR_BRONZE.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.CORBRONZE,
                                        SkullTextures.ALLOY_BROWN,
                                        SlimefunItems.CORINTHIAN_BRONZE_INGOT.getItem().getItem()
                                ),
                                new CMAlloy(
                                        IDStrings.CORBRONZE,
                                        SkullTextures.ALLOY_BROWN,
                                        Arrays.asList(
                                                map.get(IDStrings.BRONZE).getLiquidItemStack(1),
                                                map.get(IDStrings.GOLD).getLiquidItemStack(1),
                                                map.get(IDStrings.SILVER).getLiquidItemStack(1),
                                                map.get(IDStrings.COPPER).getLiquidItemStack(1)
                                        )
                                )
                        ));
        map.put(IDStrings.SOLDER,
                new ComponentMaterial
                        (
                                IDStrings.SOLDER,
                                "#b7afbd",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_SOLDER.getItemId(),
                                    SlimefunItems.SOLDER_INGOT.getItemId(),
                                    Materials.BLOCK_CAST_SOLDER.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SOLDER,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItems.SOLDER_INGOT.getItem().getItem()
                                ),
                                new CMAlloy(
                                        IDStrings.SOLDER,
                                        SkullTextures.ALLOY_SILVER,
                                        Arrays.asList(
                                                map.get(IDStrings.LEAD).getLiquidItemStack(2),
                                                map.get(IDStrings.TIN).getLiquidItemStack(1)
                                        )
                                )
                        ));
        map.put(IDStrings.BILLON,
                new ComponentMaterial
                        (
                                IDStrings.BILLON,
                                "#b0c2be",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_BILLON.getItemId(),
                                    SlimefunItems.BILLON_INGOT.getItemId(),
                                    Materials.BLOCK_CAST_BILLON.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.BILLON,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItems.BILLON_INGOT.getItem().getItem()
                                ),
                                new CMAlloy(
                                        IDStrings.BILLON,
                                        SkullTextures.ALLOY_SILVER,
                                        Arrays.asList(
                                                map.get(IDStrings.SILVER).getLiquidItemStack(2),
                                                map.get(IDStrings.COPPER).getLiquidItemStack(1)
                                        )
                                )
                        ));
        map.put(IDStrings.BRASS,
                new ComponentMaterial
                        (
                                IDStrings.BRASS,
                                "#dbcd4b",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_BRASS.getItemId(),
                                    SlimefunItems.BRASS_INGOT.getItemId(),
                                    Materials.BLOCK_CAST_BRASS.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.BRASS,
                                        SkullTextures.ALLOY_TAN,
                                        SlimefunItems.BRASS_INGOT.getItem().getItem()
                                ),
                                new CMAlloy(
                                        IDStrings.BRASS,
                                        SkullTextures.ALLOY_TAN,
                                        Arrays.asList(
                                                map.get(IDStrings.COPPER).getLiquidItemStack(2),
                                                map.get(IDStrings.ZINC).getLiquidItemStack(1)
                                        )
                                )
                        ));
        map.put(IDStrings.ALUBRASS,
                new ComponentMaterial
                        (
                                IDStrings.ALUBRASS,
                                "#dbd279",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_ALU_BRASS.getItemId(),
                                    SlimefunItems.ALUMINUM_BRASS_INGOT.getItemId(),
                                    Materials.BLOCK_CAST_ALU_BRASS.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.ALUBRASS,
                                        SkullTextures.ALLOY_BROWN,
                                        SlimefunItems.ALUMINUM_BRASS_INGOT.getItem().getItem()
                                ),
                                new CMAlloy(
                                        IDStrings.ALUBRASS,
                                        SkullTextures.ALLOY_BROWN,
                                        Arrays.asList(
                                                map.get(IDStrings.BRASS).getLiquidItemStack(1),
                                                map.get(IDStrings.ALUMINUM).getLiquidItemStack(2)
                                        )
                                )
                        ));
        map.put(IDStrings.NICKEL,
                new ComponentMaterial
                        (
                                IDStrings.NICKEL,
                                "#ebebeb",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_NICKEL.getItemId(),
                                    SlimefunItems.NICKEL_INGOT.getItemId(),
                                    Materials.BLOCK_CAST_NICKEL.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.NICKEL,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItems.NICKEL_INGOT.getItem().getItem()
                                ),
                                new CMAlloy(
                                        IDStrings.NICKEL,
                                        SkullTextures.ALLOY_SILVER,
                                        Arrays.asList(
                                                map.get(IDStrings.IRON).getLiquidItemStack(2),
                                                map.get(IDStrings.COPPER).getLiquidItemStack(1)
                                        )
                                )
                        ));
        map.put(IDStrings.COBALT,
                new ComponentMaterial
                        (
                                IDStrings.COBALT,
                                "#9e9e9e",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_COBALT.getItemId(),
                                    SlimefunItems.COBALT_INGOT.getItemId(),
                                    Materials.BLOCK_CAST_COBALT.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.COBALT,
                                        SkullTextures.ALLOY_BLUE,
                                        SlimefunItems.COBALT_INGOT.getItem().getItem()
                                ),
                                new CMAlloy(
                                        IDStrings.COBALT,
                                        SkullTextures.ALLOY_BLUE,
                                        Arrays.asList(
                                                map.get(IDStrings.IRON).getLiquidItemStack(1),
                                                map.get(IDStrings.NICKEL).getLiquidItemStack(1),
                                                map.get(IDStrings.COPPER).getLiquidItemStack(1)
                                        )
                                )
                        ));
        map.put(IDStrings.REINFORCED,
                new ComponentMaterial
                        (
                                IDStrings.REINFORCED,
                                "#465899",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_REINFORCED.getItemId(),
                                    SlimefunItems.REINFORCED_ALLOY_INGOT.getItemId(),
                                    Materials.BLOCK_CAST_REINFORCED.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.REINFORCED,
                                        SkullTextures.ALLOY_PURPLE,
                                        SlimefunItems.REINFORCED_ALLOY_INGOT.getItem().getItem()
                                ),
                                new CMAlloy(
                                        IDStrings.REINFORCED,
                                        SkullTextures.ALLOY_PURPLE,
                                        Arrays.asList(
                                                map.get(IDStrings.DAMSTEEL).getLiquidItemStack(1),
                                                map.get(IDStrings.HARD).getLiquidItemStack(1),
                                                map.get(IDStrings.CORBRONZE).getLiquidItemStack(1),
                                                map.get(IDStrings.SOLDER).getLiquidItemStack(1),
                                                map.get(IDStrings.BILLON).getLiquidItemStack(1),
                                                map.get(IDStrings.GOLD).getLiquidItemStack(1)
                                        )
                                )
                        ));
        map.put(IDStrings.STRING,
                new ComponentMaterial
                        (
                                IDStrings.STRING,
                                "#f5f5f5",
                                new CMToolMakeup(false, true, false),
                                new CMForms(
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                null,
                                null
                        ));
        map.put(IDStrings.VINE,
                new ComponentMaterial
                        (
                                IDStrings.VINE,
                                "#4ca86b",
                                new CMToolMakeup(false, true, false),
                                new CMForms(
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                null,
                                null
                        ));
        map.put(IDStrings.CRIMSONROOTS,
                new ComponentMaterial
                        (
                                IDStrings.CRIMSONROOTS,
                                "#b5365e",
                                new CMToolMakeup(false, true, false),
                                new CMForms(
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                null,
                                null
                        ));
        map.put(IDStrings.WARPEDROOTS,
                new ComponentMaterial
                        (
                                IDStrings.WARPEDROOTS,
                                "#36b549",
                                new CMToolMakeup(false, true, false),
                                new CMForms(
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                null,
                                null
                        ));
        map.put(IDStrings.WEEPINGVINES,
                new ComponentMaterial
                        (
                                IDStrings.WEEPINGVINES,
                                "#9c091d",
                                new CMToolMakeup(false, true, false),
                                new CMForms(
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                null,
                                null
                        ));
        map.put(IDStrings.TWISTEDVINES,
                new ComponentMaterial
                        (
                                IDStrings.TWISTEDVINES,
                                "#1b8045",
                                new CMToolMakeup(false, true, false),
                                new CMForms(
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                null,
                                null
                        ));

        map.get(IDStrings.ALUBRASS).addHeadDamageEvent(EntityDamageEvents::headAluBrass);       // Abra
        map.get(IDStrings.GOLD).addRodTickEvent(TickEvents::rodGold);                           // All that glitters
        map.get(IDStrings.TWISTEDVINES).addBindTickEvent(TickEvents::binderTwistingvine);       // Attraction
        map.get(IDStrings.COPPER).addHeadDamageEvent(EntityDamageEvents::headCopper);           // Brains not brawn - Damage
        map.get(IDStrings.COPPER).addHeadBlockBreakEvent(BlockBreakEvents::headCopper);         // Brains not brawn - Block Break
        map.get(IDStrings.ALUBRONZE).addRodDuraEvent(DurabilityEvents::rodAluBronze);           // Brittle
        map.get(IDStrings.REINFORCED).addHeadDuraEvent(DurabilityEvents::explosive);            // Bulky (explosive)
        map.get(IDStrings.TIN).addRodTickEvent(TickEvents::rodTin);                             // Can
        map.get(IDStrings.NICKEL).addHeadDamageEvent(EntityDamageEvents::charged);              // Charged A - Head
        map.get(IDStrings.NICKEL).addRodDamageEvent(EntityDamageEvents::charged);               // Charged A - Rod
        map.get(IDStrings.COBALT).addHeadDamageEvent(EntityDamageEvents::charged);              // Charged A - Head
        map.get(IDStrings.COBALT).addRodDamageEvent(EntityDamageEvents::charged);               // Charged A - Rod
                                                                                                // Conductive (Special case - in Experience.java, should be moved out)
        map.get(IDStrings.CRIMSONROOTS).addBindTickEvent(TickEvents::binderCrimsonroot);        // Decay
        map.get(IDStrings.WEEPINGVINES).addBindTickEvent(TickEvents::binderWeepingvine);        // Doom
                                                                                                // Durable - Damage (Special Case - in EntityDamageListener.java - cant move)
                                                                                                // Durable - Block Break (Special Case - in BlockBreakListener.java - cant move)
        map.get(IDStrings.DURALIUM).addHeadTickEvent(TickEvents::headDuralium);                 // Durable - Tick
                                                                                                // Easy Fix (Special case - in RepairBench.java. Will have to stay there)
                                                                                                // Enchanting (Special case - in Experience.java - could be moved if I raise an event)
        map.get(IDStrings.BILLON).addHeadTickEvent(TickEvents::headBillon);                     // Fast
        map.get(IDStrings.MAGNESIUM).addHeadDamageEvent(EntityDamageEvents::headMagnesium);     // Flammable
        map.get(IDStrings.CORBRONZE).addHeadBlockBreakEvent(BlockBreakEvents::headCorbronze);   // Flaming Hot
                                                                                                // Fused (Special Case - in EntityKilledListener.java and DropItemListener.java - likely wont move
        map.get(IDStrings.GOLD).addHeadDamageEvent(EntityDamageEvents::headGold);               // Golden Veil - Damage
        map.get(IDStrings.GOLD).addHeadTickEvent(TickEvents::headGold);                         // Golden Veil - Tick
        map.get(IDStrings.ZINC).addHeadTickEvent(TickEvents::headZinc);                         // Graceful
        map.get(IDStrings.VINE).addBindTickEvent(TickEvents::binderVine);                       // Growth
        map.get(IDStrings.HARD).addRodDuraEvent(DurabilityEvents::explosive);                   // Heavy (explosive)
        map.get(IDStrings.SOLDER).addHeadDuraEvent(DurabilityEvents::headSolder);               // Hidden - Durability
        map.get(IDStrings.SOLDER).addHeadTickEvent(TickEvents::headSolder);                     // Hidden - Tick
        map.get(IDStrings.BRONZE).addRodTickEvent(TickEvents::rodBronze);                       // Ingheights
        map.get(IDStrings.LEAD).addRodTickEvent(TickEvents::rodLead);                           // Leech
        map.get(IDStrings.MAGNESIUM).addRodTickEvent(TickEvents::rodMagnesium);                 // Magnetisium
        map.get(IDStrings.TIN).addHeadDamageEvent(EntityDamageEvents::headTin);                 // Malleable - Damage
        map.get(IDStrings.TIN).addHeadTickEvent(TickEvents::headTin);                           // Malleable - Tick
        map.get(IDStrings.DAMSTEEL).addRodTickEvent(TickEvents::rodDamsteel);                   // Night Stalker
        map.get(IDStrings.BRASS).addRodTickEvent(TickEvents::rodBrass);                         // Oxygenated
        map.get(IDStrings.LEAD).addHeadDamageEvent(EntityDamageEvents::headLead);               // Poisonous
        map.get(IDStrings.ALUMINUM).addHeadDuraEvent(DurabilityEvents::headAluminum);           // Recycleable
        map.get(IDStrings.WARPEDROOTS).addBindTickEvent(TickEvents::bindWarpedroot);            // Refreshing
                                                                                                // Reinforced (Special Case - nested within plate mod. Will be moved when mods are changed so consumers)
        map.get(IDStrings.BRONZE).addHeadTickEvent(TickEvents::headBronze);                     // Resistant
        map.get(IDStrings.IRON).addRodTickEvent(TickEvents::rodIron);                           // Sharp I
        map.get(IDStrings.ALUBRONZE).addHeadTickEvent(TickEvents::headAlubronze);               // Sharp II
        map.get(IDStrings.ALUMINUM).addRodDuraEvent(DurabilityEvents::rodAluminum);             // Soft - Durability
        map.get(IDStrings.ALUMINUM).addRodDamageEvent(EntityDamageEvents::rodAluminum);         // Soft - Damage
        map.get(IDStrings.ALUMINUM).addRodBlockBreakEvent(BlockBreakEvents::rodAluminum);       // Soft - Block Break
        map.get(IDStrings.SILVER).addRodTickEvent(TickEvents::rodSilver);                       // Soft Touch
        map.get(IDStrings.BILLON).addRodTickEvent(TickEvents::rodBillon);                       // Springs
                                                                                                // Stability (Special Case, doesn't do anything, just here for consistency)
        map.get(IDStrings.STEEL).addHeadDamageEvent(EntityDamageEvents::headSteel);             // Stainless
        map.get(IDStrings.BRASS).addHeadDamageEvent(EntityDamageEvents::headBrass);             // Stiff - Damage
        map.get(IDStrings.BRASS).addHeadTickEvent(TickEvents::headBrass);                       // Stiff - Tick
        map.get(IDStrings.ALUBRASS).addRodDamageEvent(EntityDamageEvents::rodAlubrass);         // Studious - Damage
        map.get(IDStrings.ALUBRASS).addRodBlockBreakEvent(BlockBreakEvents::rodAluBrass);       // Studious - Block Break
        map.get(IDStrings.ZINC).addRodTickEvent(TickEvents::rodZinc);                           // Super Light Weight
        map.get(IDStrings.CORBRONZE).addRodTickEvent(TickEvents::rodCorbronze);                 // Too Hot to Handle
        map.get(IDStrings.HARD).addHeadDamageEvent(EntityDamageEvents::headHard);               // Tuff Stuff
        map.get(IDStrings.DAMSTEEL).addHeadDamageEvent(EntityDamageEvents::headDamsteel);       // Vampirism
                                                                                                // Works (Special Case, doesn't do anything, just here for consistency)
    }


}
