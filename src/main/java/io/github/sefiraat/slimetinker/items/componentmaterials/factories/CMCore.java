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
import io.github.sefiraat.slimetinker.items.componentmaterials.CMTrait;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMTraits;
import io.github.sefiraat.slimetinker.items.componentmaterials.ComponentMaterial;
import io.github.sefiraat.slimetinker.managers.SupportedPluginsManager;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.sefiraat.slimetinker.utils.enums.TraitEventType;
import io.github.sefiraat.slimetinker.utils.enums.TraitPartType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

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
                                null,
                                new CMTraits(
                                        IDStrings.IRON,
                                        new CMTrait(
                                                "Stability",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                new ItemStack(Material.IRON_INGOT),
                                                "Does... nothing!"
                                        ),
                                        null,
                                        new CMTrait(
                                                "Sharp 1",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                new ItemStack(Material.IRON_INGOT),
                                                "Gives increased damage, stacks with",
                                                "mods and other properties."
                                        )
                                )
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
                                null,
                                new CMTraits(
                                        IDStrings.GOLD,
                                        new CMTrait(
                                                "Golden Veil",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                new ItemStack(Material.GOLD_INGOT),
                                                "Makes the player invisible. If used on",
                                                "a weapon, -100% damage."
                                        ),
                                        null,
                                        new CMTrait(
                                                "All that Glitters",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                new ItemStack(Material.GOLD_INGOT),
                                                "Makes you all shiny..."
                                        )
                                )
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
                                null,
                                new CMTraits(
                                        IDStrings.COPPER,
                                        new CMTrait(
                                                "Brains, Not Brawn",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItems.COPPER_INGOT,
                                                "Tool exp gain is doubled. Damage",
                                                "dealt is halved."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Conductive",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItems.COPPER_INGOT,
                                                "All tool exp is converted to player exp."
                                        )
                                )
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
                                null,
                                new CMTraits(
                                        IDStrings.LEAD,
                                        new CMTrait(
                                                "Poisonous",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItems.LEAD_INGOT,
                                                "25% chance to afflict poison on hit."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Leech",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItems.LEAD_INGOT,
                                                "Bonus health, but drains your energy."
                                        )
                                )
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
                                null,
                                new CMTraits(
                                        IDStrings.SILVER,
                                        new CMTrait(
                                                "Enchanting",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItems.SILVER_INGOT,
                                                "Tool exp gain is halved. Tools add a",
                                                "random vanilla enchant when leveling. May or",
                                                "may not match the tool type."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Soft Touch",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItems.SILVER_INGOT,
                                                "You feel lighter."
                                        )
                                )
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
                                null,
                                new CMTraits(
                                        IDStrings.ALUMINUM,
                                        new CMTrait(
                                                "Recyclable",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItems.ALUMINUM_INGOT,
                                                "Chance to restore durability on hit/block break"
                                        ),
                                        null,
                                        new CMTrait(
                                                "Soft",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItems.ALUMINUM_INGOT,
                                                "Durability loss +100%, tool EXP +50%."
                                        )
                                )
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
                                null,
                                new CMTraits(
                                        IDStrings.TIN,
                                        new CMTrait(
                                                "Malleable",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItems.TIN_INGOT,
                                                "Deal 50% less damage but gain luck."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Can",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItems.TIN_INGOT,
                                                "Your hunger just fades away"
                                        )
                                )
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
                                null,
                                new CMTraits(
                                        IDStrings.ZINC,
                                        new CMTrait(
                                                "Graceful",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItems.ZINC_INGOT,
                                                "DOLPHIN POWERS, ACTIVATE!"
                                        ),
                                        null,
                                        new CMTrait(
                                                "Super Lightweight",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItems.ZINC_INGOT,
                                                "Makes you lighter than air when not sneaking."
                                        )
                                )
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
                                null,
                                new CMTraits(
                                        IDStrings.MAGNESIUM,
                                        new CMTrait(
                                                "Flammable",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItems.MAGNESIUM_INGOT,
                                                "Has a (Tool level x 5)% chance to",
                                                "set your enemies ablaze."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Magnetesium",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItems.MAGNESIUM_INGOT,
                                                "Random items are drawn to you from",
                                                "within a 5 block range"
                                        )
                                )
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
                                null,
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
                                ),
                                new CMTraits(
                                        IDStrings.STEEL,
                                        new CMTrait(
                                                "Stainless",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItems.STEEL_INGOT,
                                                "The tool/weapon repels blood."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Lightweight",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItems.STEEL_INGOT,
                                                "Random items are drawn to you from",
                                                "within a 5 block range"
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
                                ),
                                new CMTraits(
                                        IDStrings.DAMSTEEL,
                                        new CMTrait(
                                                "Vampirism",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItems.DAMASCUS_STEEL_INGOT,
                                                "Chance to heal by damage given.",
                                                "Damage dealt varies by time of day."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Nightstalker",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItems.DAMASCUS_STEEL_INGOT,
                                                "Gives night vision."
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
                                ),
                                new CMTraits(
                                        IDStrings.DURALIUM,
                                        new CMTrait(
                                                "Durable",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItems.DURALUMIN_INGOT,
                                                "Ignores being broken but damage 50%,",
                                                "mining will be slower and 0 exp."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Easy Fix",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItems.DURALUMIN_INGOT,
                                                "Only 1 kit is needed to fully repair."
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
                                ),
                                new CMTraits(
                                        IDStrings.BRONZE,
                                        new CMTrait(
                                                "Resistance",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItems.BRONZE_INGOT,
                                                "Gives fire resistance while held."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Ingheights",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItems.BRONZE_INGOT,
                                                "Something is wrong with this tool."
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
                                ),
                                new CMTraits(
                                        IDStrings.ALUBRONZE,
                                        new CMTrait(
                                                "Sharp 2",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItems.ALUMINUM_BRONZE_INGOT,
                                                "Gives increased damage, stacks with",
                                                "mods and other properties."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Brittle",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItems.ALUMINUM_BRONZE_INGOT,
                                                "Durability loss is doubled."
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
                                ),
                                new CMTraits(
                                        IDStrings.HARD,
                                        new CMTrait(
                                                "Sharp 2",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItems.HARDENED_METAL_INGOT,
                                                "Knocks back anything hit with a chance",
                                                "to stun."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Heavy",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItems.HARDENED_METAL_INGOT,
                                                "Mines in a 3x3 area."
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
                                ),
                                new CMTraits(
                                        IDStrings.CORBRONZE,
                                        new CMTrait(
                                                "Flaming Hot",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItems.CORINTHIAN_BRONZE_INGOT,
                                                "Smelts broken blocks when possible."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Too Hot to Handle",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItems.CORINTHIAN_BRONZE_INGOT,
                                                "?"
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
                                ),
                                new CMTraits(
                                        IDStrings.SOLDER,
                                        new CMTrait(
                                                "Hidden",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItems.SOLDER_INGOT,
                                                "Grants invisibility, breaks instantly."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Fused",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItems.SOLDER_INGOT,
                                                "Tool cannot be dropped either by the",
                                                "player or on death."
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
                                ),
                                new CMTraits(
                                        IDStrings.BILLON,
                                        new CMTrait(
                                                "Fast",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItems.BILLON_INGOT,
                                                "Move speed increased and haste applied.",
                                                "Stacks with modifiers."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Springs",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItems.BILLON_INGOT,
                                                "Makes you jump higher."
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
                                ),
                                new CMTraits(
                                        IDStrings.BRASS,
                                        new CMTrait(
                                                "Stiff",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItems.BRASS_INGOT,
                                                "Damage +50% but makes you unlucky"
                                        ),
                                        null,
                                        new CMTrait(
                                                "Oxygenated",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItems.BRASS_INGOT,
                                                "Gives water breathing while held."
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
                                ),
                                new CMTraits(
                                        IDStrings.ALUBRASS,
                                        new CMTrait(
                                                "Abra",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItems.ALUMINUM_BRASS_INGOT,
                                                "Any hit mob has a % chance to be",
                                                "randomly teleported."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Studious",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItems.ALUMINUM_BRASS_INGOT,
                                                "Tool and Player exp +50% but damage halved",
                                                "and you are slower to act."
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
                                ),
                                new CMTraits(
                                        IDStrings.NICKEL,
                                        new CMTrait(
                                                "Charged Head -",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItems.NICKEL_INGOT,
                                                "Doesn't do anything... on it's own..."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Charged Rod -",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItems.NICKEL_INGOT,
                                                "Doesn't do anything... on it's own..."
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
                                ),
                                new CMTraits(
                                        IDStrings.COBALT,
                                        new CMTrait(
                                                "Charged Head +",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItems.COBALT_INGOT,
                                                "Doesn't do anything... on it's own..."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Charged Rod +",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItems.COBALT_INGOT,
                                                "Doesn't do anything... on it's own..."
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
                                ),
                                new CMTraits(
                                        IDStrings.REINFORCED,
                                        new CMTrait(
                                                "Bulky",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItems.REINFORCED_ALLOY_INGOT,
                                                "Mines in a 3x3 area"
                                        ),
                                        null,
                                        new CMTrait(
                                                "Reinforced",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItems.REINFORCED_ALLOY_INGOT,
                                                "Any Plate mod on the tool is counted twice."
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
                                null,
                                new CMTraits(
                                        IDStrings.STRING,
                                        null,
                                        new CMTrait(
                                                "Works",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_BINDING,
                                                new ItemStack(Material.STRING),
                                                "No special effects."
                                        ),
                                        null
                                )
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
                                null,
                                new CMTraits(
                                        IDStrings.VINE,
                                        null,
                                        new CMTrait(
                                                "Growth",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_BINDING,
                                                new ItemStack(Material.VINE),
                                                "Slowly repairs the tool during the day.",
                                                "Stacks with mods. Must be in hand"
                                        ),
                                        null
                                )
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
                                null,
                                new CMTraits(
                                        IDStrings.CRIMSONROOTS,
                                        null,
                                        new CMTrait(
                                                "Decay",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_BINDING,
                                                new ItemStack(Material.CRIMSON_ROOTS),
                                                "Slowly repairs the tool at night.",
                                                "Stacks with mods. Must be in hand"
                                        ),
                                        null
                                )
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
                                null,
                                new CMTraits(
                                        IDStrings.WARPEDROOTS,
                                        null,
                                        new CMTrait(
                                                "Refreshing",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_BINDING,
                                                new ItemStack(Material.WARPED_ROOTS),
                                                "Slowly heals the holder."
                                        ),
                                        null
                                )
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
                                null,
                                new CMTraits(
                                        IDStrings.WEEPINGVINES,
                                        null,
                                        new CMTrait(
                                                "Dooom",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_BINDING,
                                                new ItemStack(Material.WEEPING_VINES),
                                                "I get a bad feeling from this..."
                                        ),
                                        null
                                )
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
                                null,
                                new CMTraits(
                                        IDStrings.TWISTEDVINES,
                                        null,
                                        new CMTrait(
                                                "Attraction",
                                                SkullTextures.PROPERTIES_CORE,
                                                SupportedPluginsManager.CORE_NOTE,
                                                CMTraits.PROP_BINDING,
                                                new ItemStack(Material.TWISTING_VINES),
                                                "All drops are drawn to you within a",
                                                "5 block range."
                                        ),
                                        null
                                )
                        ));

        map.get(IDStrings.ALUBRASS).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headAluBrass);          // Abra
        map.get(IDStrings.GOLD).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodGold);                                      // All that glitters
        map.get(IDStrings.TWISTEDVINES).addEvent(TraitEventType.TICK, TraitPartType.BINDER, TickEvents::binderTwistingvine);                // Attraction
        map.get(IDStrings.COPPER).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headCopper);              // Brains not brawn - Damage
        map.get(IDStrings.COPPER).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headCopper);                   // Brains not brawn - Block Break
        map.get(IDStrings.ALUBRONZE).addEvent(TraitEventType.DURABILITY, TraitPartType.ROD, DurabilityEvents::rodAluBronze);                // Brittle
        map.get(IDStrings.REINFORCED).addEvent(TraitEventType.DURABILITY, TraitPartType.HEAD, DurabilityEvents::explosive);                 // Bulky (explosive)
        map.get(IDStrings.TIN).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodTin);                                        // Can
        map.get(IDStrings.NICKEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::charged);                 // Charged A (Head)
        map.get(IDStrings.NICKEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::charged);                  // Charged A (Rod)
        map.get(IDStrings.COBALT).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::charged);                 // Charged B (Head)
        map.get(IDStrings.COBALT).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::charged);                  // Charged B (Rod)
                                                                                                                                            // Conductive (Special case - in Experience.java, should be moved out)
        map.get(IDStrings.CRIMSONROOTS).addEvent(TraitEventType.TICK, TraitPartType.BINDER, TickEvents::binderCrimsonroot);                 // Decay
        map.get(IDStrings.WEEPINGVINES).addEvent(TraitEventType.TICK, TraitPartType.BINDER, TickEvents::binderWeepingvine);                 // Doom
                                                                                                                                            // Durable - Damage (Special Case - in EntityDamageListener.java - cant move)
                                                                                                                                            // Durable - Block Break (Special Case - in BlockBreakListener.java - cant move)
        map.get(IDStrings.DURALIUM).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headDuralium);                            // Durable - Tick
                                                                                                                                            // Easy Fix (Special case - in RepairBench.java. Will have to stay there)
                                                                                                                                            // Enchanting (Special case - in Experience.java - could be moved if I raise an event)
        map.get(IDStrings.BILLON).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headBillon);                                // Fast
        map.get(IDStrings.MAGNESIUM).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headMagnesium);        // Flammable
        map.get(IDStrings.CORBRONZE).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headCorbronze);             // Flaming Hot
                                                                                                                                            // Fused (Special Case - in EntityKilledListener.java and DropItemListener.java - likely wont move
        map.get(IDStrings.GOLD).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headGold);                  // Golden Veil - Damage
        map.get(IDStrings.GOLD).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headGold);                                    // Golden Veil - Tick
        map.get(IDStrings.ZINC).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headZinc);                                    // Graceful
        map.get(IDStrings.VINE).addEvent(TraitEventType.TICK, TraitPartType.BINDER, TickEvents::binderVine);                                // Growth
        map.get(IDStrings.HARD).addEvent(TraitEventType.DURABILITY, TraitPartType.ROD, DurabilityEvents::explosive);                        // Heavy (explosive)
        map.get(IDStrings.SOLDER).addEvent(TraitEventType.DURABILITY, TraitPartType.HEAD, DurabilityEvents::headSolder);                    // Hidden - Durability
        map.get(IDStrings.SOLDER).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headSolder);                                // Hidden - Tick
        map.get(IDStrings.BRONZE).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodBronze);                                  // Ingheights
        map.get(IDStrings.LEAD).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodLead);                                      // Leech
        map.get(IDStrings.MAGNESIUM).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodMagnesium);                            // Magnetisium
        map.get(IDStrings.TIN).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headTin);                    // Malleable - Damage
        map.get(IDStrings.TIN).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headTin);                                      // Malleable - Tick
        map.get(IDStrings.DAMSTEEL).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodDamsteel);                              // Night Stalker
        map.get(IDStrings.BRASS).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodBrass);                                    // Oxygenated
        map.get(IDStrings.LEAD).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headLead);                  // Poisonous
        map.get(IDStrings.ALUMINUM).addEvent(TraitEventType.DURABILITY, TraitPartType.HEAD, DurabilityEvents::headAluminum);                // Recycleable
        map.get(IDStrings.WARPEDROOTS).addEvent(TraitEventType.TICK, TraitPartType.BINDER, TickEvents::bindWarpedroot);                     // Refreshing
                                                                                                                                            // Reinforced (Special Case - nested within plate mod. Will be moved when mods are changed so consumers)
        map.get(IDStrings.BRONZE).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headBronze);                                // Resistant
        map.get(IDStrings.IRON).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodIron);                                      // Sharp I
        map.get(IDStrings.ALUBRONZE).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headAlubronze);                          // Sharp II
        map.get(IDStrings.ALUMINUM).addEvent(TraitEventType.DURABILITY, TraitPartType.ROD, DurabilityEvents::rodAluminum);                  // Soft - Durability
        map.get(IDStrings.ALUMINUM).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodAluminum);            // Soft - Damage
        map.get(IDStrings.ALUMINUM).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.ROD, BlockBreakEvents::rodAluminum);                 // Soft - Block Break
        map.get(IDStrings.SILVER).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodSilver);                                  // Soft Touch
        map.get(IDStrings.BILLON).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodBillon);                                  // Springs
                                                                                                                                            // Stability (Special Case, doesn't do anything, just here for consistency)
        map.get(IDStrings.STEEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headSteel);                // Stainless
        map.get(IDStrings.BRASS).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headBrass);                // Stiff - Damage
        map.get(IDStrings.BRASS).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headBrass);                                  // Stiff - Tick
        map.get(IDStrings.ALUBRASS).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodAlubrass);            // Studious - Damage
        map.get(IDStrings.ALUBRASS).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.ROD, BlockBreakEvents::rodAluBrass);                 // Studious - Block Break
        map.get(IDStrings.ZINC).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodZinc);                                      // Super Light Weight
        map.get(IDStrings.CORBRONZE).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodCorbronze);                            // Too Hot to Handle
        map.get(IDStrings.HARD).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::headHard);                   // Tuff Stuff
        map.get(IDStrings.DAMSTEEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headDamsteel);          // Vampirism
                                                                                                                                            // Works (Special Case, doesn't do anything, just here for consistency)
    }


}
