package io.github.sefiraat.slimetinker.items.componentmaterials.factories;

import io.github.sefiraat.slimetinker.events.BlockBreakEvents;
import io.github.sefiraat.slimetinker.events.DurabilityEvents;
import io.github.sefiraat.slimetinker.events.EntityDamageEvents;
import io.github.sefiraat.slimetinker.events.PlayerDamagedEvents;
import io.github.sefiraat.slimetinker.events.TickEvents;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMForms;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMIdentity;
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
                                new CMIdentity(IDStrings.VOID, SlimefunItem.getByID("VOID_INGOT").getItem(), SkullTextures.ALLOY_PURPLE_DEEP, "#5c5756"),
                                null,
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
                                new CMTraits(
                                        IDStrings.VOID,
                                        new CMTrait(
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Void Miner",
                                                "Randomly generates ores while mining/digging."
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Fear the Void",
                                                "Damage +150%. 250% in the End."
                                        )
                                )
                        ));

        map.put(IDStrings.MAGSTEEL,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.MAGSTEEL, SlimefunItem.getByID("MAGSTEEL").getItem(), SkullTextures.ALLOY_BROWN, "#730000"),
                                Arrays.asList(
                                        CMCore.getMap().get(IDStrings.MAGNESIUM).getLiquidItemStack(2),
                                        CMCore.getMap().get(IDStrings.STEEL).getLiquidItemStack(1)
                                ),
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
                                new CMTraits(
                                        IDStrings.MAGSTEEL,
                                        new CMTrait(
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Really Stainless",
                                                "Like Stainless, but.. REALLY."
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Flammable",
                                                "Has a (Tool level x 5)% chance to",
                                                "set your enemies ablaze."
                                        )
                                )
                        ));

        map.put(IDStrings.TITANIUM,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.TITANIUM, SlimefunItem.getByID("TITANIUM").getItem(), SkullTextures.ALLOY_SILVER, "#adadad"),
                                Arrays.asList(
                                        CMCore.getMap().get(IDStrings.REINFORCED).getLiquidItemStack(1),
                                        CMCore.getMap().get(IDStrings.DAMSTEEL).getLiquidItemStack(1),
                                        CMCore.getMap().get(IDStrings.HARD).getLiquidItemStack(1)
                                ),
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
                                new CMTraits(
                                        IDStrings.TITANIUM,
                                        new CMTrait(
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Reinforced",
                                                "Any Plate mod on the tool is counted twice."
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Durable",
                                                "Ignores being broken but damage 50%,",
                                                "mining will be slower and 0 exp."
                                        )
                                )
                        ));

        map.put(IDStrings.SINGIRON,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.SINGIRON, SlimefunItem.getByID("IRON_SINGULARITY").getItem(), SkullTextures.ALLOY_SILVER, "#8c8c8c"),
                                null,
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
                                new CMTraits(
                                        IDStrings.SINGIRON,
                                        new CMTrait(
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Stability II",
                                                "Still does Nothing"
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Sharp 1 II",
                                                "What a bad naming convention. +Damage"
                                        )
                                )
                        ));

        map.put(IDStrings.SINGGOLD,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.SINGGOLD, SlimefunItem.getByID("GOLD_SINGULARITY").getItem(), SkullTextures.ALLOY_TAN, "#ffe138"),
                                null,
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
                                new CMTraits(
                                        IDStrings.SINGGOLD,
                                        new CMTrait(
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Golden Veil II",
                                                "Makes the player invisible. If used on",
                                                "a weapon, +150% damage."
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "All That Glitters II",
                                                "Makes you shiny AND rainbow...y"
                                        )
                                )
                        ));

        map.put(IDStrings.SINGCOPPER,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.SINGCOPPER, SlimefunItem.getByID("COPPER_SINGULARITY").getItem(), SkullTextures.ALLOY_BROWN, "#c99732"),
                                null,
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
                                new CMTraits(
                                        IDStrings.SINGGOLD,
                                        new CMTrait(
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Brains, Not Brawn II",
                                                "Tool exp +200%, Damage 50%"
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Conductive II",
                                                "All tool exp is converted to player exp",
                                                "with a 50% bonus."
                                        )
                                )
                        ));

        map.put(IDStrings.SINGLEAD,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.SINGLEAD, SlimefunItem.getByID("LEAD_SINGULARITY").getItem(), SkullTextures.ALLOY_PURPLE, "#9043ba"),
                                null,
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
                                new CMTraits(
                                        IDStrings.SINGLEAD,
                                        new CMTrait(
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Poisonous II",
                                                "Poisons more frequently and for longer."
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Leech II",
                                                "Bonus health, but drains your energy."
                                        )
                                )
                        ));

        map.put(IDStrings.SINGSILVER,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.SINGSILVER, SlimefunItem.getByID("SILVER_SINGULARITY").getItem(), SkullTextures.ALLOY_SILVER, "#d4d4d4"),
                                null,
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
                                new CMTraits(
                                        IDStrings.SINGSILVER,
                                        new CMTrait(
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Enchanting II",
                                                "Poisons more frequently and for longer."
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Soft Touch II",
                                                "Tool exp gain is halved. Tools add 1-3",
                                                "randomly selected enchants when leveling",
                                                "up. These enchants may not be useful!"
                                        )
                                )
                        ));

        map.put(IDStrings.SINGALUMINUM,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.SINGALUMINUM, SlimefunItem.getByID("ALUMINUM_SINGULARITY").getItem(), SkullTextures.ALLOY_SILVER, "#b0b0b0"),
                                null,
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
                                new CMTraits(
                                        IDStrings.SINGALUMINUM,
                                        new CMTrait(
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Recyclable II",
                                                "Chance to restore durability on hit/block break"
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Soft II",
                                                "Durability loss +100%, tool EXP +100%."
                                        )
                                )
                        ));

        map.put(IDStrings.SINGTIN,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.SINGTIN, SlimefunItem.getByID("TIN_SINGULARITY").getItem(), SkullTextures.ALLOY_SILVER, "#a89b9b"),
                                null,
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
                                new CMTraits(
                                        IDStrings.SINGTIN,
                                        new CMTrait(
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Malleable II",
                                                "Deal 50% less damage but gain lots of",
                                                "Luck and Speed."
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Can II",
                                                "No Hunger Loss"
                                        )
                                )
                        ));

        map.put(IDStrings.SINGZINC,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.SINGZINC, SlimefunItem.getByID("ZINC_SINGULARITY").getItem(), SkullTextures.ALLOY_SILVER, "#9ba8a6"),
                                null,
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
                                new CMTraits(
                                        IDStrings.SINGZINC,
                                        new CMTrait(
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Graceful II",
                                                "DOLPHIN POWERS, ACTIVATE... MORE!"
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Super Lightweight II",
                                                "Makes you lighter than air when not sneaking."
                                        )
                                )
                        ));

        map.put(IDStrings.SINGMAGNESIUM,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.SINGMAGNESIUM, SlimefunItem.getByID("MAGNESIUM_SINGULARITY").getItem(), SkullTextures.ALLOY_PINK, "#e8cef5"),
                                null,
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
                                new CMTraits(
                                        IDStrings.SINGMAGNESIUM,
                                        new CMTrait(
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Flammable II",
                                                "Has a (Tool level x 10)% chance to",
                                                "set your enemies ablaze for a longer time."
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Magnetesium II",
                                                "Random items are drawn to you from",
                                                "within a 10 block range"
                                        )
                                )
                        ));
        map.put(IDStrings.SINGDIAMOND,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.SINGDIAMOND, SlimefunItem.getByID("DIAMOND_SINGULARITY").getItem(), SkullTextures.ALLOY_BLUE, "#e8cef5"),
                                null,
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
                                new CMIdentity(IDStrings.MYTHRIL, SlimefunItem.getByID("MYTHRIL").getItem(), SkullTextures.ALLOY_BLUE_PALE, "#4ebdc7"),
                                Arrays.asList(
                                        CMCore.getMap().get(IDStrings.REINFORCED).getLiquidItemStack(1),
                                        map.get(IDStrings.SINGIRON).getLiquidItemStack(9),
                                        CMCore.getMap().get(IDStrings.HARD).getLiquidItemStack(1)
                                ),
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
                                new CMTraits(
                                        IDStrings.MYTHRIL,
                                        new CMTrait(
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Elven Speed",
                                                "Haste 2, Speed 1. Durability loss +50%"
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Sting of Gondolin",
                                                "All nearby, hostile, mobs are repelled."
                                        )
                                )
                        ));

        map.put(IDStrings.ADAMANTITE,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.ADAMANTITE, SlimefunItem.getByID("ADAMANTITE").getItem(), SkullTextures.ALLOY_TAN, "#c93ec2"),
                                Arrays.asList(
                                        CMCore.getMap().get(IDStrings.REDSTONEALLOY).getLiquidItemStack(1),
                                        map.get(IDStrings.SINGDIAMOND).getLiquidItemStack(9),
                                        map.get(IDStrings.MAGSTEEL).getLiquidItemStack(1)
                                ),
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
                                new CMTraits(
                                        IDStrings.ADAMANTITE,
                                        new CMTrait(
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Mystic",
                                                "Player Exp + 100% (Mining) +50% (Mobs)"
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Adamant",
                                                "Become immune to all explosions"
                                        )
                                )
                        ));

        map.put(IDStrings.MAGNONIUM,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.MAGNONIUM, SlimefunItem.getByID("MAGNONIUM").getItem(), SkullTextures.ALLOY_PURPLE, "#4a0446"),
                                null,
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
                                new CMTraits(
                                        IDStrings.MAGNONIUM,
                                        new CMTrait(
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Magnanimous",
                                                "You're just far too kind"
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Flaming Hot",
                                                "Smelts things when possible."
                                        )
                                )
                        ));


        map.put(IDStrings.FORTUNE,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.FORTUNE, SlimefunItem.getByID("FORTUNE_SINGULARITY").getItem(), SkullTextures.ALLOY_PURPLE, "#f0d541"),
                                null,
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
                                new CMTraits(
                                        IDStrings.FORTUNE,
                                        new CMTrait(
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Fortunate",
                                                "200% drops from fortune. Stacks",
                                                "with Lapis modifiers."
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Merchant's Veil",
                                                "Invisibility with none of the drawbacks!"
                                        )
                                )
                        ));

        map.put(IDStrings.MAGIC,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.MAGIC, SlimefunItem.getByID("MAGIC_SINGULARITY").getItem(), SkullTextures.ALLOY_BLUE, "#c941e8"),
                                null,
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
                                new CMTraits(
                                        IDStrings.MAGIC,
                                        new CMTrait(
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Tricks",
                                                "Plays nasty tricks on nearby things."
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Secrets Revealed",
                                                "Reveals all nearby living (or not!) things."
                                        )
                                )
                        ));

        map.put(IDStrings.EARTH,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.EARTH, SlimefunItem.getByID("EARTH_SINGULARITY").getItem(), SkullTextures.ALLOY_GREEN, "#44e34f"),
                                null,
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
                                new CMTraits(
                                        IDStrings.EARTH,
                                        new CMTrait(
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Earth Shaker",
                                                "Knocks back hit mobs and stuns them",
                                                "when they land."
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Grinder",
                                                "Breaking blocks act as if they have",
                                                "gone through the grinder."
                                        )
                                )
                        ));

        map.put(IDStrings.METAL,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.METAL, SlimefunItem.getByID("METAL_SINGULARITY").getItem(), SkullTextures.ALLOY_SILVER, "#5b615b"),
                                null,
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
                                new CMTraits(
                                        IDStrings.METAL,
                                        new CMTrait(
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Clean Cut",
                                                "Damage +100%. Haste 2"
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Conductor",
                                                "All player exp is converted to tool",
                                                "exp at a 10 : 1 ratio."
                                        )
                                )
                        ));


        map.put(IDStrings.INFINITY,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.INFINITY, SlimefunItem.getByID("INFINITE_INGOT").getItem(), SkullTextures.ALLOY_BLUE_PALE, "#d1ebf0"),
                                null,
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
                                new CMTraits(
                                        IDStrings.INFINITY,
                                        new CMTrait(
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Infinite",
                                                "This tool will live on forever."
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Conceptual Defence",
                                                "All damage is halved (rounded up)."
                                        )
                                )
                        ));

        map.put(IDStrings.SINGINFINITY,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.SINGINFINITY, SlimefunItem.getByID("INFINITY_SINGULARITY").getItem(), SkullTextures.ALLOY_BLUE_PALE, "#e8cef5"),
                                null,
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
                                new CMTraits(
                                        IDStrings.SINGINFINITY,
                                        new CMTrait(
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
                                                "Breakpoint",
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
