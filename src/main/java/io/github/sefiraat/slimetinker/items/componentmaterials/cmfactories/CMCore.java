package io.github.sefiraat.slimetinker.items.componentmaterials.cmfactories;

import io.github.sefiraat.slimetinker.events.BlockBreakEvents;
import io.github.sefiraat.slimetinker.events.DurabilityEvents;
import io.github.sefiraat.slimetinker.events.EntityDamageEvents;
import io.github.sefiraat.slimetinker.events.PlayerDamagedEvents;
import io.github.sefiraat.slimetinker.events.RightClickEvents;
import io.github.sefiraat.slimetinker.events.TickEvents;
import io.github.sefiraat.slimetinker.events.friend.TraitEventType;
import io.github.sefiraat.slimetinker.events.friend.TraitPartType;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.componentmaterials.ComponentMaterial;
import io.github.sefiraat.slimetinker.items.componentmaterials.cmelements.CMForms;
import io.github.sefiraat.slimetinker.items.componentmaterials.cmelements.CMIdentity;
import io.github.sefiraat.slimetinker.items.componentmaterials.cmelements.CMToolMakeup;
import io.github.sefiraat.slimetinker.items.componentmaterials.cmelements.CMTrait;
import io.github.sefiraat.slimetinker.items.componentmaterials.cmelements.CMTraits;
import io.github.sefiraat.slimetinker.managers.SupportedPluginsManager;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("SpellCheckingInspection")
public final class CMCore {

    private CMCore() {
        throw new UnsupportedOperationException("Utility Class");
    }

    private static final Map<String, ComponentMaterial> CM_MAP = new HashMap<>();

    static {
        CM_MAP.put(IDStrings.IRON,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.IRON, SlimefunItems.IRON_DUST, SkullTextures.ALLOY_SILVER, "#8c8c8c"),
                    null,
                    new CMToolMakeup(true, false, true, true, false, true),
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
                    new CMTraits(
                        IDStrings.IRON,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Stability",
                            "Does... nothing!"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Sharp 1",
                            "Gives increased damage, stacks with",
                            "mods and other properties."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Steadfast",
                            "33% chance to ignore an explosion"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Rusty",
                            "Armour durability loss +10%. Player Exp gain +10%"
                        ))
                ));
        CM_MAP.put(IDStrings.GOLD,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.GOLD, SlimefunItems.GOLD_DUST, SkullTextures.ALLOY_RED, "#ffe138"),
                    null,
                    new CMToolMakeup(true, false, true, true, false, true),
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
                    new CMTraits(
                        IDStrings.GOLD,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Golden Veil",
                            "Makes the player invisible. If used on",
                            "a weapon, -100% damage."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "All that Glitters",
                            "Makes you all shiny..."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Prosperous",
                            "1% chance to drop a gold nugget when hit"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Barter",
                            "Piglins like your armour"
                        ))
                ));
        CM_MAP.put(IDStrings.COPPER,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.COPPER, SlimefunItems.COPPER_DUST, SkullTextures.ALLOY_BROWN, "#c99732"),
                    null,
                    new CMToolMakeup(true, false, true, true, false, true),
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
                    new CMTraits(
                        IDStrings.COPPER,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Brains, Not Brawn",
                            "Tool exp gain is doubled. Damage",
                            "dealt is halved."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Conductive",
                            "All tool exp is converted to player exp."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Beginner",
                            "Damage taken +25%. Armour Exp +20%"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Tarnished",
                            "Outgoing damage reduced by 25%. Armour Exp +20%"
                        ))
                ));
        CM_MAP.put(IDStrings.LEAD,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.LEAD, SlimefunItems.LEAD_DUST, SkullTextures.ALLOY_PURPLE, "#9043ba"),
                    null,
                    new CMToolMakeup(true, false, true, true, false, true),
                    new CMForms(
                        Materials.NUGGET_CAST_LEAD.getItemId(),
                        SlimefunItems.LEAD_INGOT.getItemId(),
                        Materials.BLOCK_CAST_LEAD.getItemId(),
                        null,
                        null,
                        SlimefunItems.LEAD_DUST.getItemId(),
                        null,
                        null,
                        null,
                        null
                    ),
                    new CMTraits(
                        IDStrings.LEAD,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Poisonous",
                            "25% chance to afflict poison on hit."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Leech",
                            "Bonus health, but drains your energy."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Sickly",
                            "Lead Armour is not a good idea"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Sickly",
                            "Lead Armour is not a good idea"
                        ))
                ));
        CM_MAP.put(IDStrings.SILVER,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.SILVER, SlimefunItems.SILVER_DUST, SkullTextures.ALLOY_SILVER, "#d4d4d4"),
                    null,
                    new CMToolMakeup(true, false, true, true, false, true),
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
                    new CMTraits(
                        IDStrings.SILVER,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Enchanting",
                            "Tool exp gain is halved. Tools add a",
                            "random vanilla enchant when leveling. May or",
                            "may not match the tool type."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Soft Touch",
                            "You feel lighter."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Conductivity",
                            "Immune to lightning and even reflect it back!"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Enchanting",
                            "Gains a random enchantment every time this",
                            "peice of armour levels up. May not be useful."
                        ))
                ));
        CM_MAP.put(IDStrings.ALUMINUM,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.ALUMINUM, SlimefunItems.ALUMINUM_DUST, SkullTextures.ALLOY_SILVER, "#b0b0b0"),
                    null,
                    new CMToolMakeup(true, false, true, true, false, true),
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
                    new CMTraits(
                        IDStrings.ALUMINUM,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Recyclable",
                            "Chance to restore durability on hit/block break"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Soft",
                            "Durability loss +100%, tool EXP +50%."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Foil",
                            "Damage Taken +50%. Speed + 1"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Easily Shaped",
                            "Repairs only need a single kit."
                        ))
                ));
        CM_MAP.put(IDStrings.TIN,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.TIN, SlimefunItems.TIN_DUST, SkullTextures.ALLOY_BLUE_PALE, "#a89b9b"),
                    null,
                    new CMToolMakeup(true, false, true, true, false, true),
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
                    new CMTraits(
                        IDStrings.TIN,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Malleable",
                            "Deal 50% less damage but gain luck."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Can",
                            "Your hunger just fades away"
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Non-Corrosive",
                            "Immune to poison"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Boost",
                            "When taking heavy damage, gain absorption"
                        ))
                ));
        CM_MAP.put(IDStrings.ZINC,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.ZINC, SlimefunItems.ZINC_DUST, SkullTextures.ALLOY_SILVER, "#9ba8a6"),
                    null,
                    new CMToolMakeup(true, false, true, true, false, true),
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
                    new CMTraits(
                        IDStrings.ZINC,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Graceful",
                            "DOLPHIN POWERS, ACTIVATE!"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Super Lightweight",
                            "Makes you lighter than air when not sneaking."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Sneaky",
                            "Damage doubled if target is facing away.",
                            "Small tolerance"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Acupuncture",
                            "Take no damage from cactus pricks"
                        ))
                ));
        CM_MAP.put(IDStrings.MAGNESIUM,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.MAGNESIUM, SlimefunItems.MAGNESIUM_DUST, SkullTextures.ALLOY_PINK, "#e8cef5"),
                    null,
                    new CMToolMakeup(true, false, true, true, false, true),
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
                    new CMTraits(
                        IDStrings.MAGNESIUM,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Flammable",
                            "Has a (Tool level x 5)% chance to",
                            "set your enemies ablaze."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Magnetesium",
                            "Random items are drawn to you from",
                            "within a 5 block range"
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Light",
                            "Damage dealt -25%. Speed + 1"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "MagneSight™",
                            "Gain Nightvision."
                        ))
                ));
        CM_MAP.put(IDStrings.COAL,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.COAL, new ItemStack(Material.COAL), SkullTextures.ALLOY_BROWN, "#2d2e2d"),
                    null,
                    new CMToolMakeup(false, false, false, false, false, false),
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
                    null
                ));
        CM_MAP.put(IDStrings.STEEL,
            new ComponentMaterial
                (
                    new CMIdentity(
                        IDStrings.STEEL,
                        SlimefunItems.STEEL_INGOT,
                        SkullTextures.ALLOY_SILVER,
                        "#d1d1d1"
                    ),
                    Arrays.asList(
                        CM_MAP.get(IDStrings.IRON).getLiquidItemStack(2),
                        CM_MAP.get(IDStrings.COAL).getLiquidItemStack(4)
                    ),
                    new CMToolMakeup(true, false, true, true, false, true),
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
                    new CMTraits(
                        IDStrings.STEEL,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Stainless",
                            "The tool/weapon repels blood."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Lightweight",
                            "Tool Exp +50%. Speed + 1"
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Hardy",
                            "Explosions do 25% less damage"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Strong",
                            "Health boost + 1"
                        ))
                ));
        CM_MAP.put(IDStrings.DAMSTEEL,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.DAMSTEEL, SlimefunItems.DAMASCUS_STEEL_INGOT, SkullTextures.ALLOY_RED, "#a38c8c"),
                    Arrays.asList(
                        CM_MAP.get(IDStrings.STEEL).getLiquidItemStack(1),
                        CM_MAP.get(IDStrings.IRON).getLiquidItemStack(2),
                        CM_MAP.get(IDStrings.COAL).getLiquidItemStack(8)
                    ),
                    new CMToolMakeup(true, false, true, true, false, true),
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
                    new CMTraits(
                        IDStrings.DAMSTEEL,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Vampirism",
                            "Chance to heal by damage given.",
                            "Damage dealt varies by time of day."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Nightstalker",
                            "Gives night vision."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Compounding",
                            "Gain extra health equal for each compounding",
                            "piece. Amount stacks on it's own gain"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Snroht",
                            "Thorns damage is ignored and relfected back"
                        ))
                ));
        CM_MAP.put(IDStrings.DURALIUM,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.DURALIUM, SlimefunItems.DURALUMIN_INGOT, SkullTextures.ALLOY_SILVER, "#a3a089"),
                    Arrays.asList(
                        CM_MAP.get(IDStrings.ALUMINUM).getLiquidItemStack(2),
                        CM_MAP.get(IDStrings.COPPER).getLiquidItemStack(1)
                    ),
                    new CMToolMakeup(true, false, true, true, false, true),
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
                    new CMTraits(
                        IDStrings.DURALIUM,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Durable",
                            "Ignores being broken but damage 50%,",
                            "mining will be slower and 0 exp."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Easy Fix",
                            "Only 1 kit is needed to fully repair."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Durable",
                            "Works when broken but damage taken +20%"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Shock Absorbant",
                            "10% chance to ignore damage. Not additive"
                        ))
                ));
        CM_MAP.put(IDStrings.BRONZE,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.BRONZE, SlimefunItems.BRONZE_INGOT, SkullTextures.ALLOY_BROWN, "#877435"),
                    Arrays.asList(
                        CM_MAP.get(IDStrings.COPPER).getLiquidItemStack(2),
                        CM_MAP.get(IDStrings.TIN).getLiquidItemStack(1)
                    ),
                    new CMToolMakeup(true, false, true, true, false, true),
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
                    new CMTraits(
                        IDStrings.BRONZE,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Resistance",
                            "Gives fire resistance while held."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Ingheights",
                            "Something is wrong with this tool."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Farmer",
                            "All crop drops 1 extra item. Not effected by fortune.",
                            "Does not stack with itself but does with other effects."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Brittle",
                            "Durability loss doubled."
                        ))
                ));
        CM_MAP.put(IDStrings.ALUBRONZE,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.ALUBRONZE, SlimefunItems.ALUMINUM_BRONZE_INGOT, SkullTextures.ALLOY_TAN, "#bdaa6d"),
                    Arrays.asList(
                        CM_MAP.get(IDStrings.ALUMINUM).getLiquidItemStack(2),
                        CM_MAP.get(IDStrings.BRONZE).getLiquidItemStack(1)
                    ),
                    new CMToolMakeup(true, false, true, true, false, true),
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
                    new CMTraits(
                        IDStrings.ALUBRONZE,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Sharp 2",
                            "Gives increased damage, stacks with",
                            "mods and other properties."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Brittle",
                            "Durability loss is doubled."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Beautiful",
                            "Chance to grow flowers as you walk."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Eject!",
                            "If damaged when below 1/2 health - Eject!"
                        ))
                ));
        CM_MAP.put(IDStrings.HARD,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.HARD, SlimefunItems.HARDENED_METAL_INGOT, SkullTextures.ALLOY_SILVER, "#29251a"),
                    Arrays.asList(
                        CM_MAP.get(IDStrings.ALUBRONZE).getLiquidItemStack(1),
                        CM_MAP.get(IDStrings.DURALIUM).getLiquidItemStack(1),
                        CM_MAP.get(IDStrings.DAMSTEEL).getLiquidItemStack(1),
                        CM_MAP.get(IDStrings.COAL).getLiquidItemStack(32)
                    ),
                    new CMToolMakeup(true, false, true, true, false, true),
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
                    new CMTraits(
                        IDStrings.HARD,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Tuff Stuff",
                            "Knocks back anything hit with a chance",
                            "to stun."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Heavy",
                            "Mines in a 3x3 area."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Toughened",
                            "Will not lose durability."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Dwarven Skills",
                            "Chance to find rare artifacts while mining."
                        ))
                ));
        CM_MAP.put(IDStrings.CORBRONZE,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.CORBRONZE, SlimefunItems.CORINTHIAN_BRONZE_INGOT, SkullTextures.ALLOY_BROWN, "#8a6500"),
                    Arrays.asList(
                        CM_MAP.get(IDStrings.BRONZE).getLiquidItemStack(1),
                        CM_MAP.get(IDStrings.GOLD).getLiquidItemStack(1),
                        CM_MAP.get(IDStrings.SILVER).getLiquidItemStack(1),
                        CM_MAP.get(IDStrings.COPPER).getLiquidItemStack(1)
                    ),
                    new CMToolMakeup(true, false, true, true, false, true),
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
                    new CMTraits(
                        IDStrings.CORBRONZE,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Flaming Hot",
                            "Smelts broken blocks when possible."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Too Hot to Handle",
                            "?"
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Superhot",
                            "Chance to set nearby entities on fire"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Warm Blodded",
                            "Speed + 2 when hot in the nether.",
                            "Slow + 1 when cold in the end"
                        ))
                ));
        CM_MAP.put(IDStrings.SOLDER,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.SOLDER, SlimefunItems.SOLDER_INGOT, SkullTextures.ALLOY_SILVER, "#b7afbd"),
                    Arrays.asList(
                        CM_MAP.get(IDStrings.LEAD).getLiquidItemStack(2),
                        CM_MAP.get(IDStrings.TIN).getLiquidItemStack(1)
                    ),
                    new CMToolMakeup(true, false, true, true, false, true),
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
                    new CMTraits(
                        IDStrings.SOLDER,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Hidden",
                            "Grants invisibility, breaks instantly."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Fused",
                            "Tool cannot be dropped either by the",
                            "player or on death."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Soft Landing",
                            "Hitting walls no longer hurts"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Fused",
                            "Cannot be dropped on death or on purpose."
                        ))
                ));
        CM_MAP.put(IDStrings.BILLON,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.BILLON, SlimefunItems.BILLON_INGOT, SkullTextures.ALLOY_SILVER, "#b0c2be"),
                    Arrays.asList(
                        CM_MAP.get(IDStrings.SILVER).getLiquidItemStack(2),
                        CM_MAP.get(IDStrings.COPPER).getLiquidItemStack(1)
                    ),
                    new CMToolMakeup(true, false, true, true, false, true),
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
                    new CMTraits(
                        IDStrings.BILLON,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Fast",
                            "Move speed increased and haste applied.",
                            "Stacks with modifiers."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Springs",
                            "Makes you jump higher."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "WHM",
                            "Your attacks heal instead of harm."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Heat Conductor",
                            "Magma blocks no longer cause damage"
                        ))
                ));
        CM_MAP.put(IDStrings.BRASS,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.BRASS, SlimefunItems.BRASS_INGOT, SkullTextures.ALLOY_TAN, "#dbcd4b"),
                    Arrays.asList(
                        CM_MAP.get(IDStrings.COPPER).getLiquidItemStack(2),
                        CM_MAP.get(IDStrings.ZINC).getLiquidItemStack(1)
                    ),
                    new CMToolMakeup(true, false, true, true, false, true),
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
                    new CMTraits(
                        IDStrings.BRASS,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Stiff",
                            "Damage +50% but makes you unlucky"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Oxygenated",
                            "Gives water breathing while held."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Band",
                            "Durability loss + 200%. Damage reduced between 1-25%",
                            "getting lower as durability drops."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Scarpaaarr!",
                            "Durability loss doubled. When damaged below 1/2 health, gain Speed 3."
                        ))
                ));
        CM_MAP.put(IDStrings.ALUBRASS,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.ALUBRASS, SlimefunItems.ALUMINUM_BRASS_INGOT, SkullTextures.ALLOY_BROWN, "#dbd279"),
                    Arrays.asList(
                        CM_MAP.get(IDStrings.BRASS).getLiquidItemStack(1),
                        CM_MAP.get(IDStrings.ALUMINUM).getLiquidItemStack(2)
                    ),
                    new CMToolMakeup(true, false, true, true, false, true),
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
                    new CMTraits(
                        IDStrings.ALUBRASS,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Abra",
                            "Any hit mob has a % chance to be",
                            "randomly teleported."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Studious",
                            "Tool and Player exp +50% but damage halved",
                            "and you are slower to act."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Magus",
                            "Magic Damage -50%"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Escape",
                            "Randomly teleport then hit (10s CD)"
                        ))
                ));
        CM_MAP.put(IDStrings.NICKEL,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.NICKEL, SlimefunItems.NICKEL_INGOT, SkullTextures.ALLOY_SILVER, "#ebebeb"),
                    Arrays.asList(
                        CM_MAP.get(IDStrings.IRON).getLiquidItemStack(2),
                        CM_MAP.get(IDStrings.COPPER).getLiquidItemStack(1)
                    ),
                    new CMToolMakeup(true, false, true, true, false, true),
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
                    new CMTraits(
                        IDStrings.NICKEL,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Charged Head -",
                            "Doesn't do anything... on it's own..."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Charged Rod -",
                            "Doesn't do anything... on it's own..."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Magnetic -",
                            "Gain 1 Stack of Magnetism and 1 Stack of Negativity.",
                            "Magnetism draws in all nearby items.",
                            "Range = Magnetism Level - (∆ Positivity/Negativity)"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Magnetic -",
                            "Gain 1 Stack of Magnetism and 1 Stack of Negativity.",
                            "Magnetism draws in all nearby items.",
                            "Range = Magnetism Level - (∆ Positivity/Negativity)"
                        ))
                ));
        CM_MAP.put(IDStrings.COBALT,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.COBALT, SlimefunItems.COBALT_INGOT, SkullTextures.ALLOY_BLUE, "#9e9e9e"),
                    Arrays.asList(
                        CM_MAP.get(IDStrings.IRON).getLiquidItemStack(1),
                        CM_MAP.get(IDStrings.NICKEL).getLiquidItemStack(1),
                        CM_MAP.get(IDStrings.COPPER).getLiquidItemStack(1)
                    ),
                    new CMToolMakeup(true, false, true, true, false, true),
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
                    new CMTraits(
                        IDStrings.COBALT,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Charged Head +",
                            "Doesn't do anything... on it's own..."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Charged Rod +",
                            "Doesn't do anything... on it's own..."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Magnetic +",
                            "Gain 1 Stack of Magnetism and 1 Stack of Negativity.",
                            "Magnetism draws in all nearby items.",
                            "Range = Magnetism Level - (∆ Positivity/Negativity)"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Magnetic +",
                            "Gain 1 Stack of Magnetism and 1 Stack of Positivity.",
                            "Magnetism draws in all nearby items.",
                            "Range = Magnetism Level - (∆ Positivity/Negativity)"
                        ))
                ));
        CM_MAP.put(IDStrings.REINFORCED,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.REINFORCED, SlimefunItems.REINFORCED_ALLOY_INGOT, SkullTextures.ALLOY_PURPLE, "#465899"),
                    Arrays.asList(
                        CM_MAP.get(IDStrings.DAMSTEEL).getLiquidItemStack(1),
                        CM_MAP.get(IDStrings.HARD).getLiquidItemStack(1),
                        CM_MAP.get(IDStrings.CORBRONZE).getLiquidItemStack(1),
                        CM_MAP.get(IDStrings.SOLDER).getLiquidItemStack(1),
                        CM_MAP.get(IDStrings.BILLON).getLiquidItemStack(1),
                        CM_MAP.get(IDStrings.GOLD).getLiquidItemStack(1)
                    ),
                    new CMToolMakeup(true, false, true, true, false, true),
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
                    new CMTraits(
                        IDStrings.REINFORCED,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Bulky",
                            "Mines in a 3x3 area"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Reinforced",
                            "Any Plate mod on the tool is counted twice."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Reinforcable",
                            "Plate mods count twice."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Witherproof",
                            "Immune to the wither effect."
                        ))
                ));
        CM_MAP.put(IDStrings.STRING,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.STRING, new ItemStack(Material.STRING), null, "#f5f5f5"),
                    null,
                    new CMToolMakeup(false, true, false, false, true, false),
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
                    new CMTraits(
                        IDStrings.STRING,
                        null,
                        new CMTrait(
                            CMTraits.PROP_BINDING,
                            SupportedPluginsManager.CORE_NOTE,
                            "Works",
                            "No special effects."
                        ),
                        null,
                        null,
                        new CMTrait(
                            CMTraits.PROP_GAMBESON,
                            SupportedPluginsManager.CORE_NOTE,
                            "Works",
                            "No special effects but makes armour quickly."
                        ),
                        null)
                ));
        CM_MAP.put(IDStrings.VINE,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.VINE, new ItemStack(Material.VINE), null, "#4ca86b"),
                    null,
                    new CMToolMakeup(false, true, false, false, true, false),
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
                    new CMTraits(
                        IDStrings.VINE,
                        null,
                        new CMTrait(
                            CMTraits.PROP_BINDING,
                            SupportedPluginsManager.CORE_NOTE,
                            "Growth",
                            "Slowly repairs the tool during the day.",
                            "Stacks with mods. Must be in hand"
                        ),
                        null,
                        null,
                        new CMTrait(
                            CMTraits.PROP_GAMBESON,
                            SupportedPluginsManager.CORE_NOTE,
                            "Growth",
                            "Slowly repairs during the day."
                        ),
                        null)
                ));
        CM_MAP.put(IDStrings.CRIMSON_ROOTS,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.CRIMSON_ROOTS, new ItemStack(Material.CRIMSON_ROOTS), null, "#b5365e"),
                    null,
                    new CMToolMakeup(false, true, false, false, true, false),
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
                    new CMTraits(
                        IDStrings.CRIMSON_ROOTS,
                        null,
                        new CMTrait(
                            CMTraits.PROP_BINDING,
                            SupportedPluginsManager.CORE_NOTE,
                            "Decay",
                            "Slowly repairs the tool at night.",
                            "Stacks with mods. Must be in hand"
                        ),
                        null,
                        null,
                        new CMTrait(
                            CMTraits.PROP_GAMBESON,
                            SupportedPluginsManager.CORE_NOTE,
                            "Decay",
                            "Slowly repairs during night."
                        ),
                        null)
                ));
        CM_MAP.put(IDStrings.WARPED_ROOTS,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.WARPED_ROOTS, new ItemStack(Material.WARPED_ROOTS), null, "#36b549"),
                    null,
                    new CMToolMakeup(false, true, false, false, true, false),
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
                    new CMTraits(
                        IDStrings.WARPED_ROOTS,
                        null,
                        new CMTrait(
                            CMTraits.PROP_BINDING,
                            SupportedPluginsManager.CORE_NOTE,
                            "Refreshing",
                            "Slowly heals the holder."
                        ),
                        null,
                        null,
                        new CMTrait(
                            CMTraits.PROP_GAMBESON,
                            SupportedPluginsManager.CORE_NOTE,
                            "Refreshing",
                            "Slowly heals the equipping player."
                        ),
                        null)
                ));
        CM_MAP.put(IDStrings.WEEPING_VINES,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.WEEPING_VINES, new ItemStack(Material.WEEPING_VINES), null, "#9c091d"),
                    null,
                    new CMToolMakeup(false, true, false, false, true, false),
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
                    new CMTraits(
                        IDStrings.WEEPING_VINES,
                        null,
                        new CMTrait(
                            CMTraits.PROP_BINDING,
                            SupportedPluginsManager.CORE_NOTE,
                            "Dooom",
                            "I get a bad feeling from this..."
                        ),
                        null,
                        null,
                        new CMTrait(
                            CMTraits.PROP_GAMBESON,
                            SupportedPluginsManager.CORE_NOTE,
                            "Doom",
                            "Gives you bad omen. Hide your villagers!"
                        ),
                        null)
                ));
        CM_MAP.put(IDStrings.TWISTED_VINES,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.TWISTED_VINES, new ItemStack(Material.TWISTING_VINES), null, "#1b8045"),
                    null,
                    new CMToolMakeup(false, true, false, false, true, false),
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
                    new CMTraits(
                        IDStrings.TWISTED_VINES,
                        null,
                        new CMTrait(
                            CMTraits.PROP_BINDING,
                            SupportedPluginsManager.CORE_NOTE,
                            "Attraction",
                            "All drops are drawn to you within a",
                            "5 block range."
                        ),
                        null,
                        null,
                        new CMTrait(
                            CMTraits.PROP_GAMBESON,
                            SupportedPluginsManager.CORE_NOTE,
                            "Attraction",
                            "Nearby drops (5x5 area) are drawn to you."
                        ),
                        null)
                ));
        CM_MAP.put(IDStrings.SLIME,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.SLIME, new ItemStack(Material.SLIME_BALL), SkullTextures.ALLOY_GREEN, "#29e01f"),
                    null,
                    new CMToolMakeup(false, true, false, false, true, false),
                    new CMForms(
                        null,
                        null,
                        Material.SLIME_BLOCK.toString(),
                        null,
                        Material.SLIME_BALL.toString(),
                        null,
                        null,
                        null,
                        null,
                        null
                    ),
                    new CMTraits(
                        IDStrings.SLIME,
                        null,
                        new CMTrait(
                            CMTraits.PROP_BINDING,
                            SupportedPluginsManager.CORE_NOTE,
                            "Bouncy",
                            "Fall damage is halved."
                        ),
                        null,
                        null,
                        new CMTrait(
                            CMTraits.PROP_GAMBESON,
                            SupportedPluginsManager.CORE_NOTE,
                            "Bouncy",
                            "Fall damage -25%"
                        ),
                        null)
                ));
        CM_MAP.put(IDStrings.REDSTONE,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.REDSTONE, new ItemStack(Material.REDSTONE), SkullTextures.ALLOY_RED, "#c4082e"),
                    null,
                    new CMToolMakeup(false, false, false, false, false, false),
                    new CMForms(
                        null,
                        null,
                        Material.REDSTONE_BLOCK.toString(),
                        Material.REDSTONE_ORE.toString(),
                        Material.REDSTONE.toString(),
                        null,
                        null,
                        null,
                        null,
                        null
                    ),
                    new CMTraits(
                        IDStrings.REDSTONE,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null)
                ));

        CM_MAP.put(IDStrings.SILICON,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.SILICON, SlimefunItems.SILICON, SkullTextures.ALLOY_SILVER, "#f2f2f2"),
                    null,
                    new CMToolMakeup(false, true, false, true, true, false),
                    new CMForms(
                        null,
                        Material.QUARTZ.toString(),
                        Material.QUARTZ_BLOCK.toString(),
                        Material.NETHER_QUARTZ_ORE.toString(),
                        SlimefunItems.SILICON.getItemId(),
                        null,
                        null,
                        null,
                        null,
                        null
                    ),
                    new CMTraits(
                        IDStrings.SILICON,
                        null,
                        new CMTrait(
                            CMTraits.PROP_BINDING,
                            SupportedPluginsManager.CORE_NOTE,
                            "Slow Learner",
                            "Tool exp gain when breaking blocks is",
                            "increased by (Tool Level x 5%)"
                        ),
                        null,
                        null,
                        new CMTrait(
                            CMTraits.PROP_GAMBESON,
                            SupportedPluginsManager.CORE_NOTE,
                            "Slow Learner",
                            "Armour exp gain = (Level * 5%)"
                        ),
                        null)
                ));

        CM_MAP.put(IDStrings.LEATHER,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.LEATHER, new ItemStack(Material.LEATHER), null, "#918056"),
                    null,
                    new CMToolMakeup(false, true, false, false, true, false),
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
                    new CMTraits(
                        IDStrings.LEATHER,
                        null,
                        new CMTrait(
                            CMTraits.PROP_BINDING,
                            SupportedPluginsManager.CORE_NOTE,
                            "Thick",
                            "Tool exp gain + 50%"
                        ),
                        null,
                        null,
                        new CMTrait(
                            CMTraits.PROP_GAMBESON,
                            SupportedPluginsManager.CORE_NOTE,
                            "Thick",
                            "Armour exp gain + 10%"
                        ),
                        null)
                ));

        CM_MAP.put(IDStrings.FERROSILICON,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.FERROSILICON, SlimefunItems.FERROSILICON, SkullTextures.ALLOY_SILVER, "#f2f2f2"),
                    Arrays.asList(
                        CM_MAP.get(IDStrings.IRON).getLiquidItemStack(2),
                        CM_MAP.get(IDStrings.SILICON).getLiquidItemStack(1)
                    ),
                    new CMToolMakeup(true, false, false, true, false, true),
                    new CMForms(
                        Materials.NUGGET_CAST_FERROSILICON.getItemId(),
                        SlimefunItems.FERROSILICON.getItemId(),
                        Materials.BLOCK_CAST_FERROSILICON.getItemId(),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                    ),
                    new CMTraits(
                        IDStrings.FERROSILICON,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Hydrogen",
                            "Float away from danger."
                        ),
                        null,
                        null,
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Solar Powered",
                            "Restores durability during the day time."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Brightburn",
                            "Gives on stack of Burning Bright! With 4 ",
                            "stacks, hostile mobs are repelled (not bosses)."
                        ))
                ));
        CM_MAP.put(IDStrings.REDSTONE_ALLOY,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.REDSTONE_ALLOY, SlimefunItems.REDSTONE_ALLOY, SkullTextures.ALLOY_RED, "#700d21"),
                    Arrays.asList(
                        CM_MAP.get(IDStrings.REDSTONE).getLiquidItemStack(10),
                        CM_MAP.get(IDStrings.FERROSILICON).getLiquidItemStack(1),
                        CM_MAP.get(IDStrings.HARD).getLiquidItemStack(1)
                    ),
                    new CMToolMakeup(false, false, true, true, false, true),
                    new CMForms(
                        Materials.NUGGET_CAST_REDSTONE_ALLOY.getItemId(),
                        SlimefunItems.REDSTONE_ALLOY.getItemId(),
                        Materials.BLOCK_CAST_REDSTONE_ALLOY.getItemId(),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                    ),
                    new CMTraits(
                        IDStrings.REDSTONE_ALLOY,
                        null,
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Lightning Rod",
                            "A chance to strike hit mobs with lightning."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Powered On",
                            "Randomly powers a block within a 5x2x5 range."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Who needs pressure plates?",
                            "The block you stand on is powered."
                        ))
                ));
        CM_MAP.put(IDStrings.DIAMOND,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.DIAMOND, new ItemStack(Material.DIAMOND), SkullTextures.ALLOY_BLUE, "#5fdde8"),
                    null,
                    new CMToolMakeup(false, false, false, false, false, false),
                    new CMForms(
                        null,
                        null,
                        Material.DIAMOND_BLOCK.toString(),
                        Material.DIAMOND_ORE.toString(),
                        Material.DIAMOND.toString(),
                        null,
                        null,
                        null,
                        null,
                        null
                    ),
                    new CMTraits(
                        IDStrings.DIAMOND,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null)
                ));
        CM_MAP.put(IDStrings.BOOMERITE,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.BOOMERITE, Materials.INGOT_CAST_BOOMERITE, SkullTextures.ALLOY_PURPLE, "#d94c00"),
                    Arrays.asList(
                        CM_MAP.get(IDStrings.REINFORCED).getLiquidItemStack(1),
                        CM_MAP.get(IDStrings.CORBRONZE).getLiquidItemStack(1),
                        CM_MAP.get(IDStrings.HARD).getLiquidItemStack(1),
                        CM_MAP.get(IDStrings.COPPER).getLiquidItemStack(5)
                    ),
                    new CMToolMakeup(true, false, false, true, false, false),
                    new CMForms(
                        Materials.NUGGET_CAST_BOOMERITE.getItemId(),
                        Materials.INGOT_CAST_BOOMERITE.getItemId(),
                        Materials.BLOCK_CAST_BOOMERITE.getItemId(),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                    ),
                    new CMTraits(
                        IDStrings.BOOMERITE,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Ladder Simulator™",
                            "Spawns ladders on right click."
                        ),
                        null,
                        null,
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.CORE_NOTE,
                            "Go Boomer",
                            "Warning... things will go boom..."
                        ),
                        null,
                        null)
                ));
        CM_MAP.put(IDStrings.SEFIRITE,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.SEFIRITE, Materials.INGOT_CAST_SEFIRITE, SkullTextures.ALLOY_GREEN, "#9beb34"),
                    null,
                    new CMToolMakeup(true, false, false, false, false, false),
                    new CMForms(
                        Materials.NUGGET_CAST_SEFIRITE.getItemId(),
                        Materials.INGOT_CAST_SEFIRITE.getItemId(),
                        Materials.BLOCK_CAST_SEFIRITE.getItemId(),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                    ),
                    new CMTraits(
                        IDStrings.SEFIRITE,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.CORE_NOTE,
                            "Celebrate",
                            "Time to celebrate"
                        ),
                        null,
                        null,
                        null,
                        null,
                        null)
                ));
        CM_MAP.put(IDStrings.LIQUID_CHRISTMAS,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.LIQUID_CHRISTMAS, SlimefunItems.CHRISTMAS_PRESENT, SkullTextures.ALLOY_GREEN, "#00cc36"),
                    null,
                    new CMToolMakeup(false, false, false, false, false, false),
                    new CMForms(
                        null,
                        SlimefunItems.CHRISTMAS_PRESENT.getItemId(),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                    ),
                    new CMTraits(
                        IDStrings.LIQUID_CHRISTMAS,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null)
                ));
        CM_MAP.put(IDStrings.CRINGLEIUM,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.CRINGLEIUM, Materials.INGOT_CAST_SEFIRITE, SkullTextures.ALLOY_GREEN, "#00cc36"),
                    Arrays.asList(
                        CM_MAP.get(IDStrings.REINFORCED).getLiquidItemStack(2),
                        CM_MAP.get(IDStrings.LIQUID_CHRISTMAS).getLiquidItemStack(3),
                        CM_MAP.get(IDStrings.MAGNESIUM).getLiquidItemStack(2)
                    ),
                    new CMToolMakeup(false, false, false, false, false, true),
                    new CMForms(
                        Materials.NUGGET_CAST_CRINGLEIUM.getItemId(),
                        Materials.INGOT_CAST_CRINGLEIUM.getItemId(),
                        Materials.BLOCK_CAST_CRINGLEIUM.getItemId(),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                    ),
                    new CMTraits(
                        IDStrings.CRINGLEIUM,
                        null,
                        null,
                        null,
                        null,
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.CORE_NOTE,
                            "Feeling Festive",
                            "Get that festive feeling!"
                        ))
                ));

        setupToolConsumers();
        setupArmourConsumers();

    }

    public static void setupToolConsumers() {

        CM_MAP.get(IDStrings.ALUBRASS).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headAluBrass);          // Abra
        CM_MAP.get(IDStrings.GOLD).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodGold);                                      // All that glitters
        CM_MAP.get(IDStrings.TWISTED_VINES).addEvent(TraitEventType.TICK, TraitPartType.BINDER, TickEvents::binderTwistingVine);               // Attraction
        CM_MAP.get(IDStrings.COPPER).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headCopper);              // Brains not brawn - Damage
        CM_MAP.get(IDStrings.COPPER).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headCopper);                   // Brains not brawn - Block Break
        CM_MAP.get(IDStrings.ALUBRONZE).addEvent(TraitEventType.DURABILITY, TraitPartType.ROD, DurabilityEvents::rodAluBronze);                // Brittle
        CM_MAP.get(IDStrings.REINFORCED).addEvent(TraitEventType.DURABILITY, TraitPartType.HEAD, DurabilityEvents::explosive);                 // Bulky (explosive)
        CM_MAP.get(IDStrings.TIN).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodTin);                                        // Can
        CM_MAP.get(IDStrings.SEFIRITE).addEvent(TraitEventType.RIGHT_CLICK, TraitPartType.HEAD, RightClickEvents::headSefirite);               // Celebrate
        CM_MAP.get(IDStrings.NICKEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::charged);                 // Charged A (Head)
        CM_MAP.get(IDStrings.NICKEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::charged);                  // Charged A (Rod)
        CM_MAP.get(IDStrings.COBALT).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::charged);                 // Charged B (Head)
        CM_MAP.get(IDStrings.COBALT).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::charged);                  // Charged B (Rod)
        // Conductive (Special case - in Experience.java, should be moved out)
        CM_MAP.get(IDStrings.CRIMSON_ROOTS).addEvent(TraitEventType.TICK, TraitPartType.BINDER, TickEvents::binderCrimsonRoot);                // Decay
        CM_MAP.get(IDStrings.WEEPING_VINES).addEvent(TraitEventType.TICK, TraitPartType.BINDER, TickEvents::binderWeepingVine);                // Doom
        CM_MAP.get(IDStrings.DURALIUM).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headDuralium);          // Durable - Entity Damage - Damage Reduction + No Exp
        CM_MAP.get(IDStrings.DURALIUM).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headDuralium);               // Durable - Block Break -  No Exp
        CM_MAP.get(IDStrings.DURALIUM).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headDuralium);                            // Durable - Tick
        // Easy Fix (Special case - in RepairBench.java. Will have to stay there)
        // Enchanting (Special case - in Experience.java - could be moved if I raise an event)
        CM_MAP.get(IDStrings.BILLON).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headBillon);                                // Fast
        CM_MAP.get(IDStrings.MAGNESIUM).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headMagnesium);        // Flammable
        CM_MAP.get(IDStrings.CORBRONZE).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headCorbronze);             // Flaming Hot
        // Fused (Special Case - in EntityKilledListener.java and DropItemListener.java - likely wont move
        CM_MAP.get(IDStrings.GOLD).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headGold);                  // Golden Veil - Damage
        CM_MAP.get(IDStrings.GOLD).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headGold);                                    // Golden Veil - Tick
        CM_MAP.get(IDStrings.ZINC).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headZinc);                                    // Graceful
        CM_MAP.get(IDStrings.VINE).addEvent(TraitEventType.TICK, TraitPartType.BINDER, TickEvents::binderVine);                                // Growth
        CM_MAP.get(IDStrings.HARD).addEvent(TraitEventType.DURABILITY, TraitPartType.ROD, DurabilityEvents::explosive);                        // Heavy (explosive)
        CM_MAP.get(IDStrings.SOLDER).addEvent(TraitEventType.DURABILITY, TraitPartType.HEAD, DurabilityEvents::headSolder);                    // Hidden - Durability
        CM_MAP.get(IDStrings.SOLDER).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headSolder);                                // Hidden - Tick
        CM_MAP.get(IDStrings.FERROSILICON).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.HEAD, PlayerDamagedEvents::headFerrosilicon); // Hydrogen
        CM_MAP.get(IDStrings.BRONZE).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodBronze);                                  // Ingheights
        CM_MAP.get(IDStrings.BOOMERITE).addEvent(TraitEventType.RIGHT_CLICK, TraitPartType.HEAD, RightClickEvents::headBoomerite);             // Ladder Simulator™
        CM_MAP.get(IDStrings.LEAD).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodLead);                                      // Leech
        CM_MAP.get(IDStrings.REDSTONE_ALLOY).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodRedstoneAlloy); // Lightning Rod
        CM_MAP.get(IDStrings.STEEL).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodSteel);                                    // Lightweight
        CM_MAP.get(IDStrings.MAGNESIUM).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodMagnesium);                            // Magnetisium
        CM_MAP.get(IDStrings.TIN).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headTin);                    // Malleable - Damage
        CM_MAP.get(IDStrings.TIN).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headTin);                                      // Malleable - Tick
        CM_MAP.get(IDStrings.DAMSTEEL).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodDamsteel);                              // Night Stalker
        CM_MAP.get(IDStrings.BRASS).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodBrass);                                    // Oxygenated
        CM_MAP.get(IDStrings.LEAD).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headLead);                  // Poisonous
        CM_MAP.get(IDStrings.ALUMINUM).addEvent(TraitEventType.DURABILITY, TraitPartType.HEAD, DurabilityEvents::headAluminum);                // Recycleable
        CM_MAP.get(IDStrings.WARPED_ROOTS).addEvent(TraitEventType.TICK, TraitPartType.BINDER, TickEvents::bindWarpedRoot);                    // Refreshing
        // Reinforced (Special Case - nested within plate mod. Will be moved when mods are changed to consumers)
        CM_MAP.get(IDStrings.BRONZE).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headBronze);                                // Resistant
        CM_MAP.get(IDStrings.IRON).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodIron);                                      // Sharp I
        CM_MAP.get(IDStrings.ALUBRONZE).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headAlubronze);                          // Sharp II
        CM_MAP.get(IDStrings.SILICON).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.BINDER, BlockBreakEvents::bindSilicon);               // Slow Learner
        CM_MAP.get(IDStrings.SLIME).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.BINDER, PlayerDamagedEvents::bindSlime);             // Slimey
        CM_MAP.get(IDStrings.ALUMINUM).addEvent(TraitEventType.DURABILITY, TraitPartType.ROD, DurabilityEvents::rodAluminum);                  // Soft - Durability
        CM_MAP.get(IDStrings.ALUMINUM).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodAluminum);            // Soft - Damage
        CM_MAP.get(IDStrings.ALUMINUM).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.ROD, BlockBreakEvents::rodAluminum);                 // Soft - Block Break
        CM_MAP.get(IDStrings.SILVER).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodSilver);                                  // Soft Touch
        CM_MAP.get(IDStrings.BILLON).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodBillon);                                  // Springs
        // Stability (Special Case, doesn't do anything, just here for consistency)
        CM_MAP.get(IDStrings.STEEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headSteel);                // Stainless
        CM_MAP.get(IDStrings.BRASS).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headBrass);                // Stiff - Damage
        CM_MAP.get(IDStrings.BRASS).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headBrass);                                  // Stiff - Tick
        CM_MAP.get(IDStrings.ALUBRASS).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodAlubrass);            // Studious - Damage
        CM_MAP.get(IDStrings.ALUBRASS).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.ROD, BlockBreakEvents::rodAluBrass);                 // Studious - Block Break
        CM_MAP.get(IDStrings.ZINC).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodZinc);                                      // Super Light Weight
        CM_MAP.get(IDStrings.LEATHER).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.BINDER, EntityDamageEvents::binderLeather);        // Thick - Exp Entity Damage
        CM_MAP.get(IDStrings.LEATHER).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.BINDER, BlockBreakEvents::binderLeather);             // Thick - Exp Block Break
        CM_MAP.get(IDStrings.CORBRONZE).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodCorbronze);                            // Too Hot to Handle
        CM_MAP.get(IDStrings.HARD).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::headHard);                   // Tuff Stuff
        CM_MAP.get(IDStrings.DAMSTEEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headDamsteel);          // Vampirism
        // Works (Special Case, doesn't do anything, just here for consistency)
    }

    public static void setupArmourConsumers() {

        CM_MAP.get(IDStrings.ZINC).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksZinc);               // Acupuncture
        CM_MAP.get(IDStrings.TWISTED_VINES).addEvent(TraitEventType.TICK, TraitPartType.GAMBESON, TickEvents::gambesonTwistingWines);          // Attraction
        CM_MAP.get(IDStrings.BRASS).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateBrass);             // Band
        CM_MAP.get(IDStrings.BRASS).addEvent(TraitEventType.DURABILITY, TraitPartType.PLATE, DurabilityEvents::plateBrass);                    // Band
        CM_MAP.get(IDStrings.GOLD).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksGold);                                  // Barter
        CM_MAP.get(IDStrings.ALUBRONZE).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateAluBronze);                        // Beautiful
        CM_MAP.get(IDStrings.COPPER).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateCopper);           // Beginner - Damage mod
        CM_MAP.get(IDStrings.COPPER).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.PLATE, EntityDamageEvents::plateCopper);            // Beginner - EXP Gain
        CM_MAP.get(IDStrings.TIN).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksTin);                 // Boost
        CM_MAP.get(IDStrings.SLIME).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.GAMBESON, PlayerDamagedEvents::gambesonSlime);       // Bouncy
        CM_MAP.get(IDStrings.FERROSILICON).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::brightBurn);                         // Brightburn
        CM_MAP.get(IDStrings.BRASS).addEvent(TraitEventType.DURABILITY, TraitPartType.LINKS, DurabilityEvents::linksBrass);                    // Brittle
        CM_MAP.get(IDStrings.DAMSTEEL).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateDamSteel);                          // Compounding
        CM_MAP.get(IDStrings.SILVER).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateSilver);           // Conductive
        CM_MAP.get(IDStrings.CRIMSON_ROOTS).addEvent(TraitEventType.TICK, TraitPartType.GAMBESON, TickEvents::gambesonCrimsonRoots);           // Decay
        CM_MAP.get(IDStrings.WEEPING_VINES).addEvent(TraitEventType.TICK, TraitPartType.GAMBESON, TickEvents::gambesonWeepingVines);           // Doom
        CM_MAP.get(IDStrings.DURALIUM).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateDuralium);       // Durable (Working trait is done via ItemUtils#doesNotUnequip(ItemStack)
        CM_MAP.get(IDStrings.HARD).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.LINKS, BlockBreakEvents::linksHardened);                 // Dwarven Skills
        // Easily Shaped (In RepairBench)
        CM_MAP.get(IDStrings.ALUBRONZE).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksAluBronze);     // Eject!
        // Enchanting (Experience)
        CM_MAP.get(IDStrings.ALUBRASS).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksAluBrass);       // Escape
        CM_MAP.get(IDStrings.BRONZE).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.PLATE, BlockBreakEvents::plateBronze);                 // Farmer
        CM_MAP.get(IDStrings.CRINGLEIUM).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksCringleium);                      // Feeling Festive
        CM_MAP.get(IDStrings.ALUMINUM).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateAluminum);       // Foil 50% damage
        CM_MAP.get(IDStrings.ALUMINUM).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateAluminum);                          // Foil +1 speed
        // Fused
        CM_MAP.get(IDStrings.BOOMERITE).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateBoomerite);                        // Go Boomer
        CM_MAP.get(IDStrings.VINE).addEvent(TraitEventType.TICK, TraitPartType.GAMBESON, TickEvents::gambesonVine);                            // Growth
        CM_MAP.get(IDStrings.STEEL).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateSteel);             // Hardy
        CM_MAP.get(IDStrings.BILLON).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksBillon);           // Heat Conductor
        CM_MAP.get(IDStrings.BRASS).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksBrass);             // Help
        CM_MAP.get(IDStrings.MAGNESIUM).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.PLATE, EntityDamageEvents::plateMagnesium);      // Light - Player Damage
        CM_MAP.get(IDStrings.MAGNESIUM).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateMagnesium);                        // Light - Speed
        CM_MAP.get(IDStrings.MAGNESIUM).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksMagnesium);                        // Magnesight
        CM_MAP.get(IDStrings.COBALT).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateCobalt);                              // Magnetic -
        CM_MAP.get(IDStrings.COBALT).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksCobalt);                              // Magnetic -
        CM_MAP.get(IDStrings.NICKEL).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateNickel);                              // Magnetic +
        CM_MAP.get(IDStrings.NICKEL).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksNickel);                              // Magnetic +
        CM_MAP.get(IDStrings.ALUBRASS).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateAluBrass);       // Magus
        CM_MAP.get(IDStrings.TIN).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateTin);                 // Non-corrosive
        CM_MAP.get(IDStrings.REDSTONE_ALLOY).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateRedstoneAlloy);               // Powered On
        CM_MAP.get(IDStrings.GOLD).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateGold);               // Prosperous
        CM_MAP.get(IDStrings.WARPED_ROOTS).addEvent(TraitEventType.TICK, TraitPartType.GAMBESON, TickEvents::gambesonWarpedRoots);             // Refreshing
        // Reinforcable (Special Case - nested within plate mod. Will be moved when mods are changed to consumers)
        CM_MAP.get(IDStrings.IRON).addEvent(TraitEventType.TICK, TraitPartType.LINKS, EntityDamageEvents::linksIron);                          // Rusty
        CM_MAP.get(IDStrings.DURALIUM).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksDuralium);       // Shock Absorbant
        CM_MAP.get(IDStrings.LEAD).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateLead);                                  // Sickly (plate)
        CM_MAP.get(IDStrings.LEAD).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksLead);                                  // Sickly (links)
        CM_MAP.get(IDStrings.SILICON).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.GAMBESON, EntityDamageEvents::gambesonSilicon);    // Slow Learner
        CM_MAP.get(IDStrings.ZINC).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.PLATE, EntityDamageEvents::plateZinc);                // Sneaky
        CM_MAP.get(IDStrings.DAMSTEEL).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksDamSteel);       // Snroht
        CM_MAP.get(IDStrings.SOLDER).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateSolder);           // Soft Landing
        CM_MAP.get(IDStrings.FERROSILICON).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateFerrosilicon);                  // Solar Powered
        CM_MAP.get(IDStrings.IRON).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateIron);               // Steadfast
        CM_MAP.get(IDStrings.STEEL).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksSteel);                                // Strong
        CM_MAP.get(IDStrings.CORBRONZE).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateCorBronze);                        // SuperHot
        CM_MAP.get(IDStrings.COPPER).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.LINKS, EntityDamageEvents::linksCopper);            // Tarnished
        CM_MAP.get(IDStrings.LEATHER).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.GAMBESON, EntityDamageEvents::gambesonLeather);    // Thick Hide
        CM_MAP.get(IDStrings.HARD).addEvent(TraitEventType.DURABILITY, TraitPartType.PLATE, DurabilityEvents::plateHardened);                  // Toughened
        CM_MAP.get(IDStrings.CORBRONZE).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksCorBronze);                        // Warm Blooded
        CM_MAP.get(IDStrings.BILLON).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.PLATE, EntityDamageEvents::plateBillon);            // WHM
        CM_MAP.get(IDStrings.REDSTONE_ALLOY).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksRedstoneAlloy);               // Who needs pressure plates
        CM_MAP.get(IDStrings.REINFORCED).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksReinforced);   // Witherproof
        // Works
    }

    public static Map<String, ComponentMaterial> getCmMap() {
        return CM_MAP;
    }
}
