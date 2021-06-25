package io.github.sefiraat.slimetinker.items.componentmaterials.factories;

import io.github.sefiraat.slimetinker.events.BlockBreakEvents;
import io.github.sefiraat.slimetinker.events.DurabilityEvents;
import io.github.sefiraat.slimetinker.events.EntityDamageEvents;
import io.github.sefiraat.slimetinker.events.PlayerDamagedEvents;
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
import lombok.Getter;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
public final class CMInfinity {


    @Getter
    private static final Map<String, ComponentMaterial> map = new HashMap<>();

    static {
        map.put(IDStrings.VOID,
                new ComponentMaterial
                        (
                                IDStrings.VOID,
                                "#5c5756",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    "VOID_BIT",
                                    "VOID_INGOT",
                                    Materials.BLOCK_CAST_VOID.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.VOID,
                                        SkullTextures.ALLOY_PURPLE_DEEP,
                                        SlimefunItem.getByID("VOID_INGOT").getItem()
                                ),
                                null,
                                new CMTraits(
                                        IDStrings.VOID,
                                        new CMTrait(
                                                "Void Miner",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("VOID_INGOT").getItem(),
                                                "Randomly generates ores while mining/digging."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Fear the Void",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("VOID_INGOT").getItem(),
                                                "Damage +150%. 250% in the End."
                                        )
                                )
                        ));

        map.put(IDStrings.MAGSTEEL,
                new ComponentMaterial
                        (
                                IDStrings.MAGSTEEL,
                                "#730000",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_MAGSTEEL.getItemId(),
                                    "MAGSTEEL",
                                    Materials.BLOCK_CAST_MAGSTEEL.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.MAGSTEEL,
                                        SkullTextures.ALLOY_BROWN,
                                        SlimefunItem.getByID("MAGSTEEL").getItem()
                                ),
                                new CMAlloy(
                                        IDStrings.MAGSTEEL,
                                        SkullTextures.ALLOY_BROWN,
                                        Arrays.asList(
                                                CMCore.getMap().get(IDStrings.MAGNESIUM).getLiquidItemStack(2),
                                                CMCore.getMap().get(IDStrings.STEEL).getLiquidItemStack(1)
                                        )
                                ),
                                new CMTraits(
                                        IDStrings.MAGSTEEL,
                                        new CMTrait(
                                                "Really Stainless",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("MAGSTEEL").getItem(),
                                                "Like Stainless, but.. REALLY."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Flammable",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("MAGSTEEL").getItem(),
                                                "Has a (Tool level x 5)% chance to",
                                                "set your enemies ablaze."
                                        )
                                )
                        ));

        map.put(IDStrings.TITANIUM,
                new ComponentMaterial
                        (
                                IDStrings.TITANIUM,
                                "#adadad",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_TITANIUM.getItemId(),
                                    "TITANIUM",
                                    Materials.BLOCK_CAST_TITANIUM.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.TITANIUM,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItem.getByID("TITANIUM").getItem()
                                ),
                                new CMAlloy(
                                        IDStrings.TITANIUM,
                                        SkullTextures.ALLOY_BROWN,
                                        Arrays.asList(
                                                CMCore.getMap().get(IDStrings.REINFORCED).getLiquidItemStack(1),
                                                CMCore.getMap().get(IDStrings.DAMSTEEL).getLiquidItemStack(1),
                                                CMCore.getMap().get(IDStrings.HARD).getLiquidItemStack(1)
                                        )
                                ),
                                new CMTraits(
                                        IDStrings.TITANIUM,
                                        new CMTrait(
                                                "Reinforced",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("TITANIUM").getItem(),
                                                "Any Plate mod on the tool is counted twice."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Durable",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("TITANIUM").getItem(),
                                                "Ignores being broken but damage 50%,",
                                                "mining will be slower and 0 exp."
                                        )
                                )
                        ));

        map.put(IDStrings.SINGIRON,
                new ComponentMaterial
                        (
                                IDStrings.SINGIRON,
                                "#8c8c8c",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    "IRON_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SINGIRON,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItem.getByID("IRON_SINGULARITY").getItem()
                                ),
                                null,
                                new CMTraits(
                                        IDStrings.SINGIRON,
                                        new CMTrait(
                                                "Stability II",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("IRON_SINGULARITY").getItem(),
                                                "Still does Nothing"
                                        ),
                                        null,
                                        new CMTrait(
                                                "Sharp 1 II",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("IRON_SINGULARITY").getItem(),
                                                "What a bad naming convention. +Damage"
                                        )
                                )
                        ));

        map.put(IDStrings.SINGGOLD,
                new ComponentMaterial
                        (
                                IDStrings.SINGGOLD,
                                "#ffe138",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    "GOLD_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SINGGOLD,
                                        SkullTextures.ALLOY_TAN,
                                        SlimefunItem.getByID("GOLD_SINGULARITY").getItem()
                                ),
                                null,
                                new CMTraits(
                                        IDStrings.SINGGOLD,
                                        new CMTrait(
                                                "Golden Veil II",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("GOLD_SINGULARITY").getItem(),
                                                "Makes the player invisible. If used on",
                                                "a weapon, +150% damage."
                                        ),
                                        null,
                                        new CMTrait(
                                                "All That Glitters II",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("GOLD_SINGULARITY").getItem(),
                                                "Makes you shiny AND rainbow...y"
                                        )
                                )
                        ));

        map.put(IDStrings.SINGCOPPER,
                new ComponentMaterial
                        (
                                IDStrings.SINGCOPPER,
                                "#c99732",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    "COPPER_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SINGCOPPER,
                                        SkullTextures.ALLOY_BROWN,
                                        SlimefunItem.getByID("COPPER_SINGULARITY").getItem()
                                ),
                                null,
                                new CMTraits(
                                        IDStrings.SINGGOLD,
                                        new CMTrait(
                                                "Brains, Not Brawn II",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("COPPER_SINGULARITY").getItem(),
                                                "Tool exp +200%, Damage 50%"
                                        ),
                                        null,
                                        new CMTrait(
                                                "Conductive II",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("COPPER_SINGULARITY").getItem(),
                                                "All tool exp is converted to player exp",
                                                "with a 50% bonus."
                                        )
                                )
                        ));

        map.put(IDStrings.SINGLEAD,
                new ComponentMaterial
                        (
                                IDStrings.SINGLEAD,
                                "#9043ba",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    "LEAD_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SINGLEAD,
                                        SkullTextures.ALLOY_PURPLE,
                                        SlimefunItem.getByID("LEAD_SINGULARITY").getItem()
                                ),
                                null,
                                new CMTraits(
                                        IDStrings.SINGLEAD,
                                        new CMTrait(
                                                "Poisonous II",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("LEAD_SINGULARITY").getItem(),
                                                "Poisons more frequently and for longer."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Leech II",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("LEAD_SINGULARITY").getItem(),
                                                "Bonus health, but drains your energy."
                                        )
                                )
                        ));

        map.put(IDStrings.SINGSILVER,
                new ComponentMaterial
                        (
                                IDStrings.SINGSILVER,
                                "#d4d4d4",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    "SILVER_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SINGSILVER,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItem.getByID("SILVER_SINGULARITY").getItem()
                                ),
                                null,
                                new CMTraits(
                                        IDStrings.SINGSILVER,
                                        new CMTrait(
                                                "Enchanting II",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("SILVER_SINGULARITY").getItem(),
                                                "Poisons more frequently and for longer."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Soft Touch II",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("SILVER_SINGULARITY").getItem(),
                                                "Tool exp gain is halved. Tools add 1-3",
                                                "randomly selected enchants when leveling",
                                                "up. These enchants may not be useful!"
                                        )
                                )
                        ));

        map.put(IDStrings.SINGALUMINUM,
                new ComponentMaterial
                        (
                                IDStrings.SINGALUMINUM,
                                "#b0b0b0",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    "ALUMINUM_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SINGALUMINUM,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItem.getByID("ALUMINUM_SINGULARITY").getItem()
                                ),
                                null,
                                new CMTraits(
                                        IDStrings.SINGALUMINUM,
                                        new CMTrait(
                                                "Recyclable II",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("ALUMINUM_SINGULARITY").getItem(),
                                                "Chance to restore durability on hit/block break"
                                        ),
                                        null,
                                        new CMTrait(
                                                "Soft II",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("ALUMINUM_SINGULARITY").getItem(),
                                                "Durability loss +100%, tool EXP +100%."
                                        )
                                )
                        ));

        map.put(IDStrings.SINGTIN,
                new ComponentMaterial
                        (
                                IDStrings.SINGTIN,
                                "#a89b9b",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    "TIN_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SINGTIN,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItem.getByID("TIN_SINGULARITY").getItem()
                                ),
                                null,
                                new CMTraits(
                                        IDStrings.SINGTIN,
                                        new CMTrait(
                                                "Malleable II",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("TIN_SINGULARITY").getItem(),
                                                "Deal 50% less damage but gain lots of",
                                                "Luck and Speed."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Can II",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("TIN_SINGULARITY").getItem(),
                                                "No Hunger Loss"
                                        )
                                )
                        ));

        map.put(IDStrings.SINGZINC,
                new ComponentMaterial
                        (
                                IDStrings.SINGZINC,
                                "#9ba8a6",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    "ZINC_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SINGZINC,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItem.getByID("ZINC_SINGULARITY").getItem()
                                ),
                                null,
                                new CMTraits(
                                        IDStrings.SINGZINC,
                                        new CMTrait(
                                                "Graceful II",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("ZINC_SINGULARITY").getItem(),
                                                "DOLPHIN POWERS, ACTIVATE... MORE!"
                                        ),
                                        null,
                                        new CMTrait(
                                                "Super Lightweight II",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("ZINC_SINGULARITY").getItem(),
                                                "Makes you lighter than air when not sneaking."
                                        )
                                )
                        ));

        map.put(IDStrings.SINGMAGNESIUM,
                new ComponentMaterial
                        (
                                IDStrings.SINGMAGNESIUM,
                                "#e8cef5",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    "MAGNESIUM_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SINGMAGNESIUM,
                                        SkullTextures.ALLOY_PINK,
                                        SlimefunItem.getByID("MAGNESIUM_SINGULARITY").getItem()
                                ),
                                null,
                                new CMTraits(
                                        IDStrings.SINGMAGNESIUM,
                                        new CMTrait(
                                                "Flammable II",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("MAGNESIUM_SINGULARITY").getItem(),
                                                "Has a (Tool level x 10)% chance to",
                                                "set your enemies ablaze for a longer time."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Magnetesium II",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("MAGNESIUM_SINGULARITY").getItem(),
                                                "Random items are drawn to you from",
                                                "within a 10 block range"
                                        )
                                )
                        ));
        map.put(IDStrings.SINGDIAMOND,
                new ComponentMaterial
                        (
                                IDStrings.SINGDIAMOND,
                                "#e8cef5",
                                new CMToolMakeup(false, false, false),
                                new CMForms(
                                    null,
                                    null,
                                    "DIAMOND_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SINGDIAMOND,
                                        SkullTextures.ALLOY_BLUE,
                                        SlimefunItem.getByID("DIAMOND_SINGULARITY").getItem()
                                ),
                                null,
                                new CMTraits(
                                        IDStrings.SINGDIAMOND,
                                        null,
                                        null,
                                        null
                                )
                        ));


        map.put(IDStrings.MYTHRIL,
                new ComponentMaterial
                        (
                                IDStrings.MYTHRIL,
                                "#4ebdc7",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                        Materials.NUGGET_CAST_MYTHRIL.getItemId(),
                                        "MYTHRIL",
                                        Materials.BLOCK_CAST_MYTHRIL.getItemId(),
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null
                                ),
                                new CMLiquid(
                                        IDStrings.MYTHRIL,
                                        SkullTextures.ALLOY_BLUE_PALE,
                                        SlimefunItem.getByID("MYTHRIL").getItem()
                                ),
                                new CMAlloy(
                                        IDStrings.MYTHRIL,
                                        SkullTextures.ALLOY_BLUE_PALE,
                                        Arrays.asList(
                                                CMCore.getMap().get(IDStrings.REINFORCED).getLiquidItemStack(1),
                                                map.get(IDStrings.SINGIRON).getLiquidItemStack(9),
                                                CMCore.getMap().get(IDStrings.HARD).getLiquidItemStack(1)
                                        )
                                ),
                                new CMTraits(
                                        IDStrings.MYTHRIL,
                                        new CMTrait(
                                                "Elven Speed",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("MYTHRIL").getItem(),
                                                "Haste 2, Speed 1. Durability loss +50%"
                                        ),
                                        null,
                                        new CMTrait(
                                                "Sting of Gondolin",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("MYTHRIL").getItem(),
                                                "All nearby, hostile, mobs are repelled."
                                        )
                                )
                        ));

        map.put(IDStrings.ADAMANTITE,
                new ComponentMaterial
                        (
                                IDStrings.ADAMANTITE,
                                "#c93ec2",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                        Materials.NUGGET_CAST_ADAMANTITE.getItemId(),
                                        "ADAMANTITE",
                                        Materials.BLOCK_CAST_ADAMANTITE.getItemId(),
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null
                                ),
                                new CMLiquid(
                                        IDStrings.ADAMANTITE,
                                        SkullTextures.ALLOY_TAN,
                                        SlimefunItem.getByID("ADAMANTITE").getItem()
                                ),
                                new CMAlloy(
                                        IDStrings.ADAMANTITE,
                                        SkullTextures.ALLOY_TAN,
                                        Arrays.asList(
                                                CMCore.getMap().get(IDStrings.REDSTONEALLOY).getLiquidItemStack(1),
                                                map.get(IDStrings.SINGDIAMOND).getLiquidItemStack(9),
                                                map.get(IDStrings.MAGSTEEL).getLiquidItemStack(1)
                                        )
                                ),
                                new CMTraits(
                                        IDStrings.ADAMANTITE,
                                        new CMTrait(
                                                "Mystic",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("ADAMANTITE").getItem(),
                                                "Player Exp + 100% (Mining) +50% (Mobs)"
                                        ),
                                        null,
                                        new CMTrait(
                                                "Adamant",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("ADAMANTITE").getItem(),
                                                "Become immune to all explosions"
                                        )
                                )
                        ));

        map.put(IDStrings.MAGNONIUM,
                new ComponentMaterial
                        (
                                IDStrings.MAGNONIUM,
                                "#4a0446",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                        Materials.NUGGET_CAST_MAGNONIUM.getItemId(),
                                        "MAGNONIUM",
                                        Materials.BLOCK_CAST_MAGNONIUM.getItemId(),
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null
                                ),
                                new CMLiquid(
                                        IDStrings.MAGNONIUM,
                                        SkullTextures.ALLOY_PURPLE,
                                        SlimefunItem.getByID("MAGNONIUM").getItem()
                                ),
                                null,
                                new CMTraits(
                                        IDStrings.MAGNONIUM,
                                        new CMTrait(
                                                "Magnanimous",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("MAGNONIUM").getItem(),
                                                "You're just far too kind"
                                        ),
                                        null,
                                        new CMTrait(
                                                "Flaming Hot",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("MAGNONIUM").getItem(),
                                                "Smelts things when possible."
                                        )
                                )
                        ));


        map.put(IDStrings.FORTUNE,
                new ComponentMaterial
                        (
                                IDStrings.FORTUNE,
                                "#f0d541",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                        null,
                                        null,
                                        null,
                                        null,
                                        "FORTUNE_SINGULARITY",
                                        null,
                                        null,
                                        null,
                                        null,
                                        null
                                ),
                                new CMLiquid(
                                        IDStrings.FORTUNE,
                                        SkullTextures.ALLOY_PURPLE,
                                        SlimefunItem.getByID("FORTUNE_SINGULARITY").getItem()
                                ),
                                null,
                                new CMTraits(
                                        IDStrings.FORTUNE,
                                        new CMTrait(
                                                "Fortunate",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("FORTUNE_SINGULARITY").getItem(),
                                                "200% drops from fortune. Stacks",
                                                "with Lapis modifiers."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Merchant's Veil",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("FORTUNE_SINGULARITY").getItem(),
                                                "Invisibility with none of the drawbacks!"
                                        )
                                )
                        ));

        map.put(IDStrings.MAGIC,
                new ComponentMaterial
                        (
                                IDStrings.MAGIC,
                                "#c941e8",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                        null,
                                        null,
                                        null,
                                        null,
                                        "MAGIC_SINGULARITY",
                                        null,
                                        null,
                                        null,
                                        null,
                                        null
                                ),
                                new CMLiquid(
                                        IDStrings.MAGIC,
                                        SkullTextures.ALLOY_BLUE,
                                        SlimefunItem.getByID("MAGIC_SINGULARITY").getItem()
                                ),
                                null,
                                new CMTraits(
                                        IDStrings.MAGIC,
                                        new CMTrait(
                                                "Tricks",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("MAGIC_SINGULARITY").getItem(),
                                                "Plays nasty tricks on nearby things."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Secrets Revealed",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("MAGIC_SINGULARITY").getItem(),
                                                "Reveals all nearby living (or not!) things."
                                        )
                                )
                        ));

        map.put(IDStrings.EARTH,
                new ComponentMaterial
                        (
                                IDStrings.EARTH,
                                "#44e34f",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                        null,
                                        null,
                                        null,
                                        null,
                                        "EARTH_SINGULARITY",
                                        null,
                                        null,
                                        null,
                                        null,
                                        null
                                ),
                                new CMLiquid(
                                        IDStrings.EARTH,
                                        SkullTextures.ALLOY_GREEN,
                                        SlimefunItem.getByID("EARTH_SINGULARITY").getItem()
                                ),
                                null,
                                new CMTraits(
                                        IDStrings.EARTH,
                                        new CMTrait(
                                                "Earth Shaker",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("EARTH_SINGULARITY").getItem(),
                                                "Knocks back hit mobs and stuns them",
                                                "when they land."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Grinder",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("EARTH_SINGULARITY").getItem(),
                                                "Breaking blocks act as if they have",
                                                "gone through the grinder."
                                        )
                                )
                        ));

        map.put(IDStrings.METAL,
                new ComponentMaterial
                        (
                                IDStrings.METAL,
                                "#5b615b",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                        null,
                                        null,
                                        null,
                                        null,
                                        "METAL_SINGULARITY",
                                        null,
                                        null,
                                        null,
                                        null,
                                        null
                                ),
                                new CMLiquid(
                                        IDStrings.METAL,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItem.getByID("METAL_SINGULARITY").getItem()
                                ),
                                null,
                                new CMTraits(
                                        IDStrings.METAL,
                                        new CMTrait(
                                                "Clean Cut",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("METAL_SINGULARITY").getItem(),
                                                "Damage +100%. Haste 2"
                                        ),
                                        null,
                                        new CMTrait(
                                                "Conductor",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("METAL_SINGULARITY").getItem(),
                                                "All player exp is converted to tool",
                                                "exp at a 10 : 1 ratio."
                                        )
                                )
                        ));


        map.put(IDStrings.INFINITY,
                new ComponentMaterial
                        (
                                IDStrings.INFINITY,
                                "#d1ebf0",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                        Materials.NUGGET_CAST_INFINITY.getItemId(),
                                        "INFINITE_INGOT",
                                        Materials.BLOCK_CAST_INFINITY.getItemId(),
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null
                                ),
                                new CMLiquid(
                                        IDStrings.INFINITY,
                                        SkullTextures.ALLOY_BLUE_PALE,
                                        SlimefunItem.getByID("INFINITE_INGOT").getItem()
                                ),
                                null,
                                new CMTraits(
                                        IDStrings.INFINITY,
                                        new CMTrait(
                                                "Infinite",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("INFINITE_INGOT").getItem(),
                                                "This tool will live on forever."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Conceptual Defence",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("INFINITE_INGOT").getItem(),
                                                "All damage is halved (rounded up)."
                                        )
                                )
                        ));

        map.put(IDStrings.SINGINFINITY,
                new ComponentMaterial
                        (
                                IDStrings.SINGINFINITY,
                                "#e8cef5",
                                new CMToolMakeup(true, false, false),
                                new CMForms(
                                    null,
                                    null,
                                    "INFINITY_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SINGINFINITY,
                                        SkullTextures.ALLOY_BLUE_PALE,
                                        SlimefunItem.getByID("INFINITY_SINGULARITY").getItem()
                                ),
                                null,
                                new CMTraits(
                                        IDStrings.SINGINFINITY,
                                        new CMTrait(
                                                "Breakpoint",
                                                SkullTextures.PROPERTIES_INFINITY,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("INFINITY_SINGULARITY").getItem(),
                                                "Unbreakable. +200% Damage.",
                                                "+200% Tool Exp and 3x3 Mining."
                                        ),
                                        null,
                                        null
                                )
                        ));

        map.get(IDStrings.ADAMANTITE).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.ROD, PlayerDamagedEvents::rodAdamantite);           // Adamant
        map.get(IDStrings.SINGGOLD).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodSingGold);                                  // All that Glitters II
        map.get(IDStrings.SINGCOPPER).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headSingCopper);          // Brains Not Brawn II - Damage
        map.get(IDStrings.SINGCOPPER).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headSingCopper);               // Brains Not Brawn II - Block Break
        map.get(IDStrings.SINGINFINITY).addEvent(TraitEventType.DURABILITY, TraitPartType.HEAD, DurabilityEvents::headSingInfinity);            // Breakpoint - Durability
        map.get(IDStrings.SINGINFINITY).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headSingInfinity);      // Breakpoint - Damage
        map.get(IDStrings.SINGINFINITY).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headSingInfinity);           // Breakpoint - Block Break
        map.get(IDStrings.SINGTIN).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodSingTin);                                    // Can II
        map.get(IDStrings.METAL).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headMetal);                                      // Clean Cut - Tick
        map.get(IDStrings.METAL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headMetal);                    // Clean Cut - Damage
        map.get(IDStrings.INFINITY).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.ROD, PlayerDamagedEvents::rodInfinity);               // Conceptual Defence
                                                                                                                                                // Conductive II (Special case, handled in Experience.java)
        map.get(IDStrings.METAL).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.ROD, BlockBreakEvents::rodMetal);                           // Conductor - Block Break
        map.get(IDStrings.METAL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodMetal);                      // Conductor - Damage
                                                                                                                                                // Durable - Damage (Special Case - in EntityDamageListener.java - cant move)       |
                                                                                                                                                // Durable - Block Break (Special Case - in BlockBreakListener.java - cant move)    |-- CO - Duralium Head
        map.get(IDStrings.TITANIUM).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headDuralium);                                // Durable - Tick
        map.get(IDStrings.EARTH).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headEarth);                    // Earth Shaker
        map.get(IDStrings.MYTHRIL).addEvent(TraitEventType.DURABILITY, TraitPartType.HEAD, DurabilityEvents::headMythril);                      // Elven Speed - Durability
        map.get(IDStrings.MYTHRIL).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headMythril);                                  // Elven Speed - Tick
                                                                                                                                                // Enchanting II (Special Case, handled in Experience.java)
        map.get(IDStrings.VOID).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodVoid);                        // Fear the Void
        map.get(IDStrings.MAGSTEEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::headMagnesium);              // Flammable                                                                        |-- CO - Magnesium Head
        map.get(IDStrings.SINGMAGNESIUM).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headSingMagnesium);    // Flammable II
        map.get(IDStrings.MAGNONIUM).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.ROD, BlockBreakEvents::headCorbronze);                  // Flaming Hot                                                                      |-- CO - Corin Bronze Head
        map.get(IDStrings.FORTUNE).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headFortune);                     // Fortunate
        map.get(IDStrings.SINGGOLD).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headSingGold);                                // Golden Veil II - Tick
        map.get(IDStrings.SINGGOLD).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headSingGold);              // Golden Veil II - Damage
        map.get(IDStrings.SINGZINC).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headSingZinc);                                // Graceful II
        map.get(IDStrings.EARTH).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.ROD, BlockBreakEvents::rodEarth);                           // Grinder
        map.get(IDStrings.INFINITY).addEvent(TraitEventType.DURABILITY, TraitPartType.HEAD, DurabilityEvents::headInfinity);                    // Infinite
        map.get(IDStrings.SINGLEAD).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodSingLead);                                  // Leech II
        map.get(IDStrings.MAGNONIUM).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headMagnonium);                 // Magnanimous
        map.get(IDStrings.SINGMAGNESIUM).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodSingMagnesium);                        // Magnetesium II
        map.get(IDStrings.SINGTIN).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headSingTin);                // Malleable II - Damage
        map.get(IDStrings.SINGTIN).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headSingTin);                                  // Malleable II - Tick
        map.get(IDStrings.FORTUNE).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodFortune);                                    // Merchant's Veil
        map.get(IDStrings.ADAMANTITE).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headAdamantite);               // Mystic - Block Break
        map.get(IDStrings.ADAMANTITE).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headAdamantite);          // Mystic - Damage
        map.get(IDStrings.SINGLEAD).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headSingLead);              // Poisonous II
        map.get(IDStrings.MAGSTEEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headMagSteel);              // Really Stainless
        map.get(IDStrings.SINGALUMINUM).addEvent(TraitEventType.DURABILITY, TraitPartType.HEAD, DurabilityEvents::headSingAluminum);            // Recyclable II
                                                                                                                                                // Reinforced                                                                       |-- CO - Reinforced Rod
        map.get(IDStrings.MAGIC).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodMagic);                                        // Secrets Revealed
        map.get(IDStrings.SINGIRON).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodSingIron);                                  // Sharp 1 II
        map.get(IDStrings.SINGALUMINUM).addEvent(TraitEventType.DURABILITY, TraitPartType.ROD, DurabilityEvents::rodSingAluminum);              // Soft II - Durability
        map.get(IDStrings.SINGALUMINUM).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.ROD, BlockBreakEvents::rodSingAluminum);             // Soft II - Block Break
        map.get(IDStrings.SINGALUMINUM).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodSingAluminum);        // Soft II - Damage
        map.get(IDStrings.SINGSILVER).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.ROD, PlayerDamagedEvents::rodSingSilver);           // Soft Touch II
                                                                                                                                                // Stability II (Does nothing, here for consistency)
        map.get(IDStrings.MYTHRIL).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodMythril);                                    // Sting of Gondolin
        map.get(IDStrings.SINGZINC).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodSingZinc);                                  // Super Lightweight II
        map.get(IDStrings.MAGIC).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headMagic);                                      // Trick
        map.get(IDStrings.VOID).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headVoid);                           // Void Miner

    }

}
