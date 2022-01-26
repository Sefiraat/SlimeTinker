package io.github.sefiraat.slimetinker.items.tinkermaterials.setup;

import io.github.sefiraat.slimetinker.items.tinkermaterials.elements.MaterialTrait;
import io.github.sefiraat.slimetinker.managers.SupportedPluginsManager;

public final class Traits {

    private Traits() {
        throw new UnsupportedOperationException("Utility Class");
    }

    // region Core

    public static final MaterialTrait CORE_IRON_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Stability",
        "Does... nothing!"
    );

    public static final MaterialTrait CORE_IRON_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Sharp 1",
        "Gives increased damage, stacks with",
        "mods and other properties."
    );

    public static final MaterialTrait CORE_IRON_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Steadfast",
        "33% chance to ignore an explosion"
    );

    public static final MaterialTrait CORE_IRON_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Rusty",
        "Armour durability loss +10%. Player Exp gain +10%"
    );

    public static final MaterialTrait CORE_GOLD_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Golden Veil",
        "Makes the player invisible. If used on",
        "a weapon, -100% damage."
    );

    public static final MaterialTrait CORE_GOLD_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "All that Glitters",
        "Makes you all shiny..."
    );

    public static final MaterialTrait CORE_GOLD_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Prosperous",
        "1% chance to drop a gold nugget when hit"
    );

    public static final MaterialTrait CORE_GOLD_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Barter",
        "Piglins like your armour"
    );

    public static final MaterialTrait CORE_COPPER_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Brains, Not Brawn",
        "Tool exp gain is doubled. Damage",
        "dealt is halved."
    );

    public static final MaterialTrait CORE_COPPER_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Conductive",
        "All tool exp is converted to player exp."
    );

    public static final MaterialTrait CORE_COPPER_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Beginner",
        "Damage taken +25%. Armour Exp +20%"
    );

    public static final MaterialTrait CORE_COPPER_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Tarnished",
        "Outgoing damage reduced by 25%. Armour Exp +20%"
    );

    public static final MaterialTrait CORE_LEAD_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Poisonous",
        "25% chance to afflict poison on hit."
    );

    public static final MaterialTrait CORE_LEAD_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Leech",
        "Bonus health, but drains your energy."
    );

    public static final MaterialTrait CORE_LEAD_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Sickly",
        "Lead Armour is not a good idea"
    );

    public static final MaterialTrait CORE_LEAD_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Sickly",
        "Lead Armour is not a good idea"
    );

    public static final MaterialTrait CORE_SILVER_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Enchanting",
        "Tool exp gain is halved. Tools add a",
        "random vanilla enchant when leveling. May or",
        "may not match the tool type."
    );

    public static final MaterialTrait CORE_SILVER_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Soft Touch",
        "You feel lighter."
    );

    public static final MaterialTrait CORE_SILVER_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Conductivity",
        "Immune to lightning and even reflect it back!"
    );

    public static final MaterialTrait CORE_SILVER_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Enchanting",
        "Gains a random enchantment every time this",
        "piece of armour levels up. May not be useful."
    );

    public static final MaterialTrait CORE_ALUMINUM_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Recyclable",
        "Chance to restore durability on hit/block break"
    );

    public static final MaterialTrait CORE_ALUMINUM_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Soft",
        "Durability loss +100%, tool EXP +50%."
    );

    public static final MaterialTrait CORE_ALUMINUM_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Foil",
        "Damage Taken +50%. Speed + 1"
    );

    public static final MaterialTrait CORE_ALUMINUM_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Easily Shaped",
        "Repairs only need a single kit."
    );

    public static final MaterialTrait CORE_TIN_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Malleable",
        "Deal 50% less damage but gain luck."
    );

    public static final MaterialTrait CORE_TIN_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Can",
        "Your hunger just fades away"
    );

    public static final MaterialTrait CORE_TIN_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Non-Corrosive",
        "Immune to poison"
    );

    public static final MaterialTrait CORE_TIN_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Boost",
        "When taking heavy damage, gain absorption"
    );

    public static final MaterialTrait CORE_ZINC_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Graceful",
        "DOLPHIN POWERS, ACTIVATE!"
    );

    public static final MaterialTrait CORE_ZINC_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Super Lightweight",
        "Makes you lighter than air when not sneaking."
    );

    public static final MaterialTrait CORE_ZINC_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Sneaky",
        "Damage doubled if target is facing away.",
        "Small tolerance"
    );

    public static final MaterialTrait CORE_ZINC_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Acupuncture",
        "Take no damage from cactus pricks"
    );

    public static final MaterialTrait CORE_MAGNESIUM_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Flammable",
        "Has a (Tool level x 5)% chance to",
        "set your enemies ablaze."
    );

    public static final MaterialTrait CORE_MAGNESIUM_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Magnetesium",
        "Random items are drawn to you from",
        "within a 5 block range"
    );

    public static final MaterialTrait CORE_MAGNESIUM_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Light",
        "Damage dealt -25%. Speed + 1"
    );

    public static final MaterialTrait CORE_MAGNESIUM_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "MagneSight™",
        "Gain Nightvision."
    );

    public static final MaterialTrait CORE_STEEL_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Stainless",
        "The tool/weapon repels blood."
    );

    public static final MaterialTrait CORE_STEEL_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Lightweight",
        "Tool Exp +50%. Speed + 1"
    );

    public static final MaterialTrait CORE_STEEL_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Hardy",
        "Explosions do 25% less damage"
    );

    public static final MaterialTrait CORE_STEEL_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Strong",
        "Health boost + 1"
    );

    public static final MaterialTrait CORE_DAMASCUS_STEEL_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Vampirism",
        "Chance to heal by damage given.",
        "Damage dealt varies by time of day."
    );

    public static final MaterialTrait CORE_DAMASCUS_STEEL_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Nightstalker",
        "Gives night vision."
    );

    public static final MaterialTrait CORE_DAMASCUS_STEEL_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Compounding",
        "Gain extra health equal for each compounding",
        "piece. Amount stacks on it's own gain"
    );

    public static final MaterialTrait CORE_DAMASCUS_STEEL_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Snroht",
        "Thorns damage is ignored and relfected back"
    );

    public static final MaterialTrait CORE_DURALUMIN_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Durable",
        "Ignores being broken but damage 50%,",
        "mining will be slower and 0 exp."
    );

    public static final MaterialTrait CORE_DURALUMIN_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Easy Fix",
        "Only 1 kit is needed to fully repair."
    );

    public static final MaterialTrait CORE_DURALUMIN_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Durable",
        "Works when broken but damage taken +20%"
    );

    public static final MaterialTrait CORE_DURALUMIN_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Shock Absorbant",
        "10% chance to ignore damage. Not additive"
    );

    public static final MaterialTrait CORE_BRONZE_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Resistance",
        "Gives fire resistance while held."
    );

    public static final MaterialTrait CORE_BRONZE_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Ingheights",
        "Something is wrong with this tool."
    );

    public static final MaterialTrait CORE_BRONZE_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Farmer",
        "All crop drops 1 extra item. Not effected by fortune.",
        "Does not stack with itself but does with other effects."
    );

    public static final MaterialTrait CORE_BRONZE_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Brittle",
        "Durability loss doubled."
    );

    public static final MaterialTrait CORE_ALUMINUM_BRONZE_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Sharp 2",
        "Gives increased damage, stacks with",
        "mods and other properties."
    );

    public static final MaterialTrait CORE_ALUMINUM_BRONZE_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Brittle",
        "Durability loss is doubled."
    );

    public static final MaterialTrait CORE_ALUMINUM_BRONZE_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Beautiful",
        "Chance to grow flowers as you walk."
    );

    public static final MaterialTrait CORE_ALUMINUM_BRONZE_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Eject!",
        "If damaged when below 1/2 health - Eject!"
    );

    public static final MaterialTrait CORE_HARDENED_METAL_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Tuff Stuff",
        "Knocks back anything hit with a chance",
        "to stun."
    );

    public static final MaterialTrait CORE_HARDENED_METAL_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Heavy",
        "Mines in a 3x3 area."
    );

    public static final MaterialTrait CORE_HARDENED_METAL_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Toughened",
        "Will not lose durability."
    );

    public static final MaterialTrait CORE_HARDENED_METAL_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Dwarven Skills",
        "Chance to find rare artifacts while mining."
    );

    public static final MaterialTrait CORE_CORINTHIAN_BRONZE_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Flaming Hot",
        "Smelts broken blocks when possible."
    );

    public static final MaterialTrait CORE_CORINTHIAN_BRONZE_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Too Hot to Handle",
        "?"
    );
    public static final MaterialTrait CORE_CORINTHIAN_BRONZE_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Superhot",
        "Chance to set nearby entities on fire"
    );

    public static final MaterialTrait CORE_CORINTHIAN_BRONZE_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Warm Blodded",
        "Speed + 2 when hot in the nether.",
        "Slow + 1 when cold in the end"
    );

    public static final MaterialTrait CORE_SOLDER_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Hidden",
        "Grants invisibility, breaks instantly."
    );

    public static final MaterialTrait CORE_SOLDER_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Fused",
        "Tool cannot be dropped either by the",
        "player or on death."
    );
    public static final MaterialTrait CORE_SOLDER_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Soft Landing",
        "Hitting walls no longer hurts"
    );

    public static final MaterialTrait CORE_SOLDER_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Fused",
        "Cannot be dropped on death or on purpose."
    );

    public static final MaterialTrait CORE_BILLON_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Fast",
        "Move speed increased and haste applied.",
        "Stacks with modifiers."
    );

    public static final MaterialTrait CORE_BILLON_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Springs",
        "Makes you jump higher."
    );
    public static final MaterialTrait CORE_BILLON_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "WHM",
        "Your attacks heal instead of harm."
    );

    public static final MaterialTrait CORE_BILLON_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Heat Conductor",
        "Magma blocks no longer cause damage"
    );

    public static final MaterialTrait CORE_BRASS_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Stiff",
        "Damage +50% but makes you unlucky"
    );

    public static final MaterialTrait CORE_BRASS_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Oxygenated",
        "Gives water breathing while held."
    );

    public static final MaterialTrait CORE_BRASS_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Band",
        "Durability loss + 200%. Damage reduced between 1-25%",
        "getting lower as durability drops."
    );

    public static final MaterialTrait CORE_BRASS_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Scarpaaarr!",
        "Durability loss doubled. When damaged below 1/2 health, gain Speed 3."
    );

    public static final MaterialTrait CORE_ALUMINUM_BRASS_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Abra",
        "Any hit mob has a % chance to be",
        "randomly teleported."
    );

    public static final MaterialTrait CORE_ALUMINUM_BRASS_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Studious",
        "Tool and Player exp +50% but damage halved",
        "and you are slower to act."
    );

    public static final MaterialTrait CORE_ALUMINUM_BRASS_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Magus",
        "Magic Damage -50%"
    );

    public static final MaterialTrait CORE_ALUMINUM_BRASS_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Escape",
        "Randomly teleport then hit (10s CD)"
    );

    public static final MaterialTrait CORE_NICKEL_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Charged Head -",
        "Doesn't do anything... on it's own..."
    );

    public static final MaterialTrait CORE_NICKEL_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Charged Rod -",
        "Doesn't do anything... on it's own..."
    );
    public static final MaterialTrait CORE_NICKEL_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Magnetic -",
        "Gain 1 Stack of Magnetism and 1 Stack of Negativity.",
        "Magnetism draws in all nearby items.",
        "Range = Magnetism Level - (∆ Positivity/Negativity)"
    );

    public static final MaterialTrait CORE_NICKEL_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Magnetic -",
        "Gain 1 Stack of Magnetism and 1 Stack of Negativity.",
        "Magnetism draws in all nearby items.",
        "Range = Magnetism Level - (∆ Positivity/Negativity)"
    );

    public static final MaterialTrait CORE_COBALT_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Charged Head +",
        "Doesn't do anything... on it's own..."
    );

    public static final MaterialTrait CORE_COBALT_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Charged Rod +",
        "Doesn't do anything... on it's own..."
    );

    public static final MaterialTrait CORE_COBALT_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Magnetic +",
        "Gain 1 Stack of Magnetism and 1 Stack of Negativity.",
        "Magnetism draws in all nearby items.",
        "Range = Magnetism Level - (∆ Positivity/Negativity)"
    );

    public static final MaterialTrait CORE_COBALT_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Magnetic +",
        "Gain 1 Stack of Magnetism and 1 Stack of Positivity.",
        "Magnetism draws in all nearby items.",
        "Range = Magnetism Level - (∆ Positivity/Negativity)"
    );

    public static final MaterialTrait CORE_REINFORCED_ALLOY_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Bulky",
        "Mines in a 3x3 area"
    );

    public static final MaterialTrait CORE_REINFORCED_ALLOY_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Reinforced",
        "Any Plate mod on the tool is counted twice."
    );

    public static final MaterialTrait CORE_REINFORCED_ALLOY_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Reinforcable",
        "Plate mods count twice."
    );

    public static final MaterialTrait CORE_REINFORCED_ALLOY_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Witherproof",
        "Immune to the wither effect."
    );

    public static final MaterialTrait CORE_STRING_BINDER = new MaterialTrait(
        MaterialTrait.PROP_BINDING,
        SupportedPluginsManager.CORE_NOTE,
        "Works",
        "No special effects."
    );

    public static final MaterialTrait CORE_STRING_GAMBESON = new MaterialTrait(
        MaterialTrait.PROP_GAMBESON,
        SupportedPluginsManager.CORE_NOTE,
        "Works",
        "No special effects but makes armour quickly."
    );

    public static final MaterialTrait CORE_VINE_BINDER = new MaterialTrait(
        MaterialTrait.PROP_BINDING,
        SupportedPluginsManager.CORE_NOTE,
        "Growth",
        "Slowly repairs the tool during the day.",
        "Stacks with mods. Must be in hand"
    );

    public static final MaterialTrait CORE_VINE_GAMBESON = new MaterialTrait(
        MaterialTrait.PROP_GAMBESON,
        SupportedPluginsManager.CORE_NOTE,
        "Growth",
        "Slowly repairs during the day."
    );


    public static final MaterialTrait CORE_CRIMSON_ROOT_BINDER = new MaterialTrait(
        MaterialTrait.PROP_BINDING,
        SupportedPluginsManager.CORE_NOTE,
        "Decay",
        "Slowly repairs the tool at night.",
        "Stacks with mods. Must be in hand"
    );

    public static final MaterialTrait CORE_CRIMSON_ROOT_GAMBESON = new MaterialTrait(
        MaterialTrait.PROP_GAMBESON,
        SupportedPluginsManager.CORE_NOTE,
        "Decay",
        "Slowly repairs during night."
    );

    public static final MaterialTrait CORE_WARPED_ROOT_BINDER = new MaterialTrait(
        MaterialTrait.PROP_BINDING,
        SupportedPluginsManager.CORE_NOTE,
        "Refreshing",
        "Slowly heals the holder."
    );

    public static final MaterialTrait CORE_WARPED_ROOT_GAMBESON = new MaterialTrait(
        MaterialTrait.PROP_GAMBESON,
        SupportedPluginsManager.CORE_NOTE,
        "Refreshing",
        "Slowly heals the equipping player."
    );

    public static final MaterialTrait CORE_WEEPING_VINE_BINDER = new MaterialTrait(
        MaterialTrait.PROP_BINDING,
        SupportedPluginsManager.CORE_NOTE,
        "Dooom",
        "I get a bad feeling from this..."
    );

    public static final MaterialTrait CORE_WEEPING_VINE_GAMBESON = new MaterialTrait(
        MaterialTrait.PROP_GAMBESON,
        SupportedPluginsManager.CORE_NOTE,
        "Doom",
        "Gives you bad omen. Hide your villagers!"
    );

    public static final MaterialTrait CORE_TWISTING_VINE_BINDER = new MaterialTrait(
        MaterialTrait.PROP_BINDING,
        SupportedPluginsManager.CORE_NOTE,
        "Attraction",
        "All drops are drawn to you within a",
        "5 block range."
    );

    public static final MaterialTrait CORE_TWISTING_VINE_GAMBESON = new MaterialTrait(
        MaterialTrait.PROP_GAMBESON,
        SupportedPluginsManager.CORE_NOTE,
        "Attraction",
        "Nearby drops (5x5 area) are drawn to you."
    );

    public static final MaterialTrait CORE_SLIME_BINDER = new MaterialTrait(
        MaterialTrait.PROP_BINDING,
        SupportedPluginsManager.CORE_NOTE,
        "Bouncy",
        "Fall damage is halved."
    );

    public static final MaterialTrait CORE_SLIME_GAMBESON = new MaterialTrait(
        MaterialTrait.PROP_GAMBESON,
        SupportedPluginsManager.CORE_NOTE,
        "Bouncy",
        "Fall damage -25%"
    );

    public static final MaterialTrait CORE_SILICON_BINDER = new MaterialTrait(
        MaterialTrait.PROP_BINDING,
        SupportedPluginsManager.CORE_NOTE,
        "Slow Learner",
        "Tool exp gain when breaking blocks is",
        "increased by (Tool Level x 5%)"
    );

    public static final MaterialTrait CORE_SILICON_GAMBESON = new MaterialTrait(
        MaterialTrait.PROP_GAMBESON,
        SupportedPluginsManager.CORE_NOTE,
        "Slow Learner",
        "Armour exp gain = (Level * 5%)"
    );

    public static final MaterialTrait CORE_LEATHER_BINDER = new MaterialTrait(
        MaterialTrait.PROP_BINDING,
        SupportedPluginsManager.CORE_NOTE,
        "Thick",
        "Tool exp gain + 50%"
    );

    public static final MaterialTrait CORE_LEATHER_GAMBESON = new MaterialTrait(
        MaterialTrait.PROP_GAMBESON,
        SupportedPluginsManager.CORE_NOTE,
        "Thick",
        "Armour exp gain + 10%"
    );

    public static final MaterialTrait CORE_FERROSILICON_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Hydrogen",
        "Float away from danger."
    );

    public static final MaterialTrait CORE_FERROSILICON_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Solar Powered",
        "Restores durability during the day time."
    );

    public static final MaterialTrait CORE_FERROSILICON_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Brightburn",
        "Gives on stack of Burning Bright! With 4 ",
        "stacks, hostile mobs are repelled (not bosses)."
    );

    public static final MaterialTrait CORE_REDSTONE_ALLOY_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.CORE_NOTE,
        "Lightning Rod",
        "A chance to strike hit mobs with lightning."
    );
    public static final MaterialTrait CORE_REDSTONE_ALLOY_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Powered On",
        "Randomly powers a block within a 5x2x5 range."
    );

    public static final MaterialTrait CORE_REDSTONE_ALLOY_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Who needs pressure plates?",
        "The block you stand on is powered."
    );

    public static final MaterialTrait CORE_BOOMERITE_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Ladder Simulator™",
        "Spawns ladders on right click."
    );

    public static final MaterialTrait CORE_BOOMERITE_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.CORE_NOTE,
        "Go Boomer",
        "Warning... things will go boom..."
    );

    public static final MaterialTrait CORE_SEFIRITE_PLATES = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.CORE_NOTE,
        "Celebrate",
        "Time to celebrate"
    );

    public static final MaterialTrait CORE_CRINGLEIUM_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.CORE_NOTE,
        "Feeling Festive",
        "Get that festive feeling!"
    );

    // endregion

    // region Infinity Expansion

    public static final MaterialTrait INFINITY_VOID_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Void Miner",
        "Randomly generates ores while mining/digging."
    );

    public static final MaterialTrait INFINITY_VOID_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Fear the Void",
        "Damage +150%. 250% in the End."
    );

    public static final MaterialTrait INFINITY_VOID_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Planewalker",
        "The void is no longer your enemy"
    );

    public static final MaterialTrait INFINITY_VOID_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "The End",
        "Reduce damage from the Dragon, Endermen and",
        "Shulkers by 10%"
    );

    public static final MaterialTrait INFINITY_MAGSTEEL_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Really Stainless",
        "Like Stainless, but.. REALLY."
    );

    public static final MaterialTrait INFINITY_MAGSTEEL_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Flammable",
        "Has a (Tool level x 5)% chance to",
        "set your enemies ablaze."
    );

    public static final MaterialTrait INFINITY_MAGSTEEL_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Tarnished",
        "Outgoing damage reduced by 25%. Armour Exp +20%"
    );

    public static final MaterialTrait INFINITY_MAGSTEEL_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Defender",
        "5% chance, when hit, to ignore damage",
        "and gain absorbtion."
    );

    public static final MaterialTrait INFINITY_TITANIUM_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Reinforced",
        "Any Plate mod on the tool is counted twice."
    );

    public static final MaterialTrait INFINITY_TITANIUM_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Durable",
        "Ignores being broken but damage 50%,",
        "mining will be slower and 0 exp."
    );

    public static final MaterialTrait INFINITY_TITANIUM_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Dwarven Skills",
        "Chance to find rare artifacts while mining."
    );

    public static final MaterialTrait INFINITY_TITANIUM_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Heat Resistant",
        "Immune to fire and lava."
    );

    public static final MaterialTrait INFINITY_IRON_SINGULARITY_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Stability II",
        "Still does Nothing"
    );

    public static final MaterialTrait INFINITY_IRON_SINGULARITY_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Sharp 1 II",
        "What a bad naming convention. +Damage"
    );

    public static final MaterialTrait INFINITY_IRON_SINGULARITY_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Steadfast II",
        "Ignore all explosions"
    );

    public static final MaterialTrait INFINITY_IRON_SINGULARITY_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Rusty II",
        "Armour durability loss +10%. Player Exp gain +20%"
    );

    public static final MaterialTrait INFINITY_GOLD_SINGULARITY_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Golden Veil II",
        "Makes the player invisible. If used on",
        "a weapon, +50% damage."
    );

    public static final MaterialTrait INFINITY_GOLD_SINGULARITY_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "All That Glitters II",
        "Makes you shiny AND rainbow...y"
    );

    public static final MaterialTrait INFINITY_GOLD_SINGULARITY_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Prosperous II",
        "1% chance to drop 1-4 gold nuggets when hit"
    );

    public static final MaterialTrait INFINITY_GOLD_SINGULARITY_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Barter II",
        "Piglins REALLY like your armour"
    );

    public static final MaterialTrait INFINITY_COPPER_SINGULARITY_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Brains, Not Brawn II",
        "Tool exp +200%, Damage 50%"
    );

    public static final MaterialTrait INFINITY_COPPER_SINGULARITY_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Conductive II",
        "All tool exp is converted to player exp",
        "with a 50% bonus."
    );

    public static final MaterialTrait INFINITY_COPPER_SINGULARITY_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Beginner II",
        "Damage Taken +50%. Armour Exp +40%"
    );

    public static final MaterialTrait INFINITY_COPPER_SINGULARITY_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Tarnished II",
        "Outgoing damage reduced by 25%. Armour Exp +40%"
    );

    public static final MaterialTrait INFINITY_LEAD_SINGULARITY_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Poisonous II",
        "Poisons more frequently and for longer."
    );

    public static final MaterialTrait INFINITY_LEAD_SINGULARITY_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Leech II",
        "Bonus health, but drains your energy."
    );

    public static final MaterialTrait INFINITY_LEAD_SINGULARITY_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Sickly II",
        "Lead armour is a VERY BAD idea"
    );

    public static final MaterialTrait INFINITY_LEAD_SINGULARITY_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Sickly II",
        "Lead armour is a VERY BAD idea"
    );

    public static final MaterialTrait INFINITY_SILVER_SINGULARITY_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Enchanting II",
        "Tool exp gain is halved. Tools add 1-3",
        "randomly selected enchants when leveling",
        "up. These enchants may not be useful!"
    );

    public static final MaterialTrait INFINITY_SILVER_SINGULARITY_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Soft Touch II",
        "You feel much lighter."
    );

    public static final MaterialTrait INFINITY_SILVER_SINGULARITY_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Conductivity II",
        "Chance to summon a tempest when hit.",
        "Lightning damage heals you."
    );

    public static final MaterialTrait INFINITY_SILVER_SINGULARITY_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Enchanting II",
        "Gains 1-3 random enchantments everytime this",
        "piece of armour levels up. May not be useful."
    );

    public static final MaterialTrait INFINITY_ALUMINUM_SINGULARITY_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Recyclable II",
        "Chance to restore durability on hit/block break"
    );

    public static final MaterialTrait INFINITY_ALUMINUM_SINGULARITY_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Soft II",
        "Durability loss +100%, tool EXP +100%."
    );

    public static final MaterialTrait INFINITY_ALUMINUM_SINGULARITY_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Foil II",
        "Damage Taken +50%. Speed + 2"
    );

    public static final MaterialTrait INFINITY_ALUMINUM_SINGULARITY_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Easily Shaped II",
        "Repairs only need a single kit of ANY metal"
    );

    public static final MaterialTrait INFINITY_TIN_SINGULARITY_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Malleable II",
        "Deal 50% less damage but gain lots of",
        "Luck and Speed."
    );

    public static final MaterialTrait INFINITY_TIN_SINGULARITY_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Can II",
        "No Hunger Loss"
    );

    public static final MaterialTrait INFINITY_TIN_SINGULARITY_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Non-Corrosive II",
        "Poison heals and immune to hunger and weakness."
    );

    public static final MaterialTrait INFINITY_TIN_SINGULARITY_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Boost II",
        "When taking heavy damage, gain lots of absorption"
    );

    public static final MaterialTrait INFINITY_ZINC_SINGULARITY_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Graceful II",
        "DOLPHIN POWERS, ACTIVATE... MORE!"
    );

    public static final MaterialTrait INFINITY_ZINC_SINGULARITY_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Super Lightweight II",
        "Makes you lighter than air when sneaking."
    );

    public static final MaterialTrait INFINITY_ZINC_SINGULARITY_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Sneaky II",
        "Damage doubled if target is facing away.",
        "Large tolerence"
    );

    public static final MaterialTrait INFINITY_ZINC_SINGULARITY_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Acupuncture II",
        "Cactus pricks heal you."
    );

    public static final MaterialTrait INFINITY_MAGNESIUM_SINGULARITY_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Flammable II",
        "Has a (Tool level x 10)% chance to",
        "set your enemies ablaze for a longer time."
    );

    public static final MaterialTrait INFINITY_MAGNESIUM_SINGULARITY_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Magnetesium II",
        "Random items are drawn to you from",
        "within a 10 block range"
    );

    public static final MaterialTrait INFINITY_MAGNESIUM_SINGULARITY_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Light II",
        "Damage Dealt -50%. Speed + 2"
    );

    public static final MaterialTrait INFINITY_MAGNESIUM_SINGULARITY_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "MagneSight™ II",
        "Gain night vision and highlight all mobs"
    );

    public static final MaterialTrait INFINITY_MYTHRIL_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Elven Speed",
        "Haste 2, Speed 1. Durability loss +50%"
    );

    public static final MaterialTrait INFINITY_MYTHRIL_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Sting of Gondolin",
        "All nearby, hostile, mobs are repelled."
    );

    public static final MaterialTrait INFINITY_MYTHRIL_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Brightburn",
        "Gives on stack of Burning Bright! With 4 ",
        "stacks, hostile mobs are repelled (not bosses)."
    );

    public static final MaterialTrait INFINITY_MYTHRIL_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Call of the Wild",
        "When hit, you sometimes summon a wolf to your aid"
    );

    public static final MaterialTrait INFINITY_ADAMANTITE_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Mystic",
        "Player Exp + 100% (Mining) +50% (Mobs)"
    );

    public static final MaterialTrait INFINITY_ADAMANTITE_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Adamant",
        "Become immune to all explosions"
    );

    public static final MaterialTrait INFINITY_ADAMANTITE_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Deflective",
        "Projectile Damage -25%"
    );

    public static final MaterialTrait INFINITY_ADAMANTITE_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Experienced",
        "All tool and armour exp +10%"
    );

    public static final MaterialTrait INFINITY_MAGNONIUM_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Magnanimous",
        "You're just far too kind"
    );

    public static final MaterialTrait INFINITY_MAGNONIUM_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Flaming Hot",
        "Smelts things when possible."
    );

    public static final MaterialTrait INFINITY_MAGNONIUM_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Escape",
        "When hit, teleport away randomly (10s CD)."
    );

    public static final MaterialTrait INFINITY_MAGNONIUM_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Oxygenated",
        "Who needs it!?"
    );

    public static final MaterialTrait INFINITY_FORTUNE_SINGULARITY_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Fortunate",
        "200% drops from fortune. Stacks",
        "with Lapis modifiers."
    );

    public static final MaterialTrait INFINITY_FORTUNE_SINGULARITY_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Merchant's Veil",
        "Invisibility with none of the drawbacks!"
    );

    public static final MaterialTrait INFINITY_FORTUNE_SINGULARITY_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "How Fortunate",
        "0.5% chance to get a gift when hit."
    );

    public static final MaterialTrait INFINITY_FORTUNE_SINGULARITY_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Beautiful",
        "Plants flowers as you walk."
    );

    public static final MaterialTrait INFINITY_MAGIC_SINGULARITY_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Tricks",
        "Plays nasty tricks on nearby things."
    );

    public static final MaterialTrait INFINITY_MAGIC_SINGULARITY_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Secrets Revealed",
        "Reveals all nearby living (or not!) things."
    );

    public static final MaterialTrait INFINITY_MAGIC_SINGULARITY_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Wizard Robes",
        "Chance, when hit, to create MAGIC"
    );

    public static final MaterialTrait INFINITY_MAGIC_SINGULARITY_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Magical Mint",
        "It may still be foul, but the Dragon's",
        "breath will not hurt you."
    );

    public static final MaterialTrait INFINITY_EARTH_SINGULARITY_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Earth Shaker",
        "Knocks back hit mobs and stuns them",
        "when they land."
    );

    public static final MaterialTrait INFINITY_EARTH_SINGULARITY_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Grinder",
        "Breaking blocks act as if they have",
        "gone through the grinder."
    );

    public static final MaterialTrait INFINITY_EARTH_SINGULARITY_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Lava Walker",
        "Lava turns into magma blocks beneath your feet."
    );

    public static final MaterialTrait INFINITY_EARTH_SINGULARITY_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "It's only natural",
        "Feeds two nearby animals on right click. 2m CD",
        "Cooldown fires regardless of success."
    );

    public static final MaterialTrait INFINITY_METAL_SINGULARITY_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Clean Cut",
        "Damage +100%. Haste 2"
    );

    public static final MaterialTrait INFINITY_METAL_SINGULARITY_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Conductor",
        "All player exp is converted to tool",
        "exp at a 10 : 1 ratio."
    );

    public static final MaterialTrait INFINITY_METAL_SINGULARITY_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "KOTR",
        "Chance, when hit, to summon a Knight",
        "of the Round. (It's a Golem ;))"
    );

    public static final MaterialTrait INFINITY_METAL_SINGULARITY_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Gleam",
        "Chance when hit to reflect damage and",
        "dazzle attackers."
    );

    public static final MaterialTrait INFINITY_INFINITY_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Infinite",
        "This tool will live on forever."
    );

    public static final MaterialTrait INFINITY_INFINITY_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Conceptual Defence",
        "All damage is halved (rounded up)."
    );

    public static final MaterialTrait INFINITY_INFINITY_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Infinite Capacity",
        "Everytime you take damage, 10% is stored",
        "up to 5 hearts. Right click to release",
        "the damage on nearby entities"
    );

    public static final MaterialTrait INFINITY_INFINITY_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Oroborus",
        "20% chance to reflect damage taken."
    );

    public static final MaterialTrait INFINITY_INFINITY_SINGULARITY_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Breakpoint",
        "Unbreakable. +200% Damage.",
        "+200% Tool Exp and 3x3 Mining."
    );

    public static final MaterialTrait INFINITY_INFINITY_SINGULARITY_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Infinitly Powerful",
        "Every 2000 points of damage taken (before",
        "reductions) will unlock a new, random,",
        "enchantment. No upper limits."
    );

    public static final MaterialTrait INFINITY_INFINITY_SINGULARITY_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.INFINITY_EXPANSION_NOTE,
        "Infinite Defence",
        "All damage taken set to 1 when 4 pieces",
        "are equipped."
    );

    // endregion

    // region LiteXpansion

    public static final MaterialTrait LITE_RUBBER_BINDING = new MaterialTrait(
        MaterialTrait.PROP_BINDING,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Insulated",
        "Become immune to lightning."
    );

    public static final MaterialTrait LITE_RUBBER_GAMBESON = new MaterialTrait(
        MaterialTrait.PROP_GAMBESON,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Sweaty",
        "A rubber lining is WAY too hot."
    );

    public static final MaterialTrait LITE_REFINED_IRON_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Really Stable",
        "Does nothing. Perhaps if you level it up?."
    );

    public static final MaterialTrait LITE_REFINED_IRON_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Manners Maketh Man",
        "Speed 1, Damage + 50%. Your fights look",
        "super cool."
    );

    public static final MaterialTrait LITE_REFINED_IRON_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Kingsman",
        "On right click, summons a colorful cavelcade",
        "of pure desctruction.",
        "Does nothing if you don't have manners.",
        "Requires 4 peices with Kingsman."
    );

    public static final MaterialTrait LITE_REFINED_IRON_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Narrowing",
        "Attackers are blinded."
    );

    public static final MaterialTrait LITE_MIXED_METAL_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Mixed Metals",
        "Has the effects of all it's ingredients but",
        "their power is halved."
    );

    public static final MaterialTrait LITE_MIXED_METAL_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Stiff",
        "Double damage. Unlucky!"
    );

    public static final MaterialTrait LITE_MIXED_METAL_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Experienced",
        "All tool/armour exp + 10%"
    );

    public static final MaterialTrait LITE_MIXED_METAL_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Mix it up!",
        "Mixes things up a bit when hit"
    );

    public static final MaterialTrait LITE_ADVANCED_ALLOY_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Cleave",
        "Damage all nearby mobs when you attack.",
        "Cleave damage does not trigger Tinker's effects."
    );

    public static final MaterialTrait LITE_ADVANCED_ALLOY_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Heavy Duty",
        "When durability gets low, it eats 1 iron",
        "ingot from your inventory to restore some."
    );

    public static final MaterialTrait LITE_ADVANCED_ALLOY_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Even More Advanced",
        "Advanced modifiers +1 for each piece."
    );

    public static final MaterialTrait LITE_ADVANCED_ALLOY_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Superhot",
        "Chance to set nearby linving things on fire."
    );

    public static final MaterialTrait LITE_MAG_THOR_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Heat Resistant",
        "Lava is no longer your enemy."
    );

    public static final MaterialTrait LITE_MAG_THOR_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Vampirism",
        "Chance to heal by damage given.",
        "Damage dealt varies by time of day."
    );

    public static final MaterialTrait LITE_MAG_THOR_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Radioactive Plates",
        "Poisons enemies that attack you."
    );

    public static final MaterialTrait LITE_MAG_THOR_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Building Rage",
        "Chance, when hit, to gain Speed 1 and Haste 1"
    );

    public static final MaterialTrait LITE_CARBON_MESH_BINDING = new MaterialTrait(
        MaterialTrait.PROP_BINDING,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Nimble",
        "Speed 1. Take 33% less damage"
    );

    public static final MaterialTrait LITE_CARBON_MESH_GAMBESON = new MaterialTrait(
        MaterialTrait.PROP_GAMBESON,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Carbon Fibre",
        "Speed + 1"
    );

    public static final MaterialTrait LITE_SCRAP_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Terrible",
        "+300% durability loss. 0% Exp Gain."
    );

    public static final MaterialTrait LITE_SCRAP_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Brains, Not Brawn.",
        "Tool exp gain is doubled. Damage",
        "dealt is halved."
    );

    public static final MaterialTrait LITE_SCRAP_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Pathetic",
        "Do not wear this armour.",
        "VERY BAD THINGS MAY HAPPEN",
        "YOU HAVE BEEN WARNED",
        "Exp + 400%."
    );

    public static final MaterialTrait LITE_SCRAP_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Falling Apart",
        "Exp + 200%. Chance for the amrour to",
        "just fall off!"
    );

    public static final MaterialTrait LITE_IRIDIUM_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Protective",
        "Saves you from deaths. 20min CD."
    );

    public static final MaterialTrait LITE_IRIDIUM_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Warp",
        "Turns your opponent around. 20s CD."
    );

    public static final MaterialTrait LITE_IRIDIUM_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Indomitable",
        "10% of all damage is ignored and reflected."
    );

    public static final MaterialTrait LITE_IRIDIUM_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.LITEXPANSION_NOTE,
        "Unconventional Power",
        "Any damage taken is remembered. Right",
        "Click to charge inventory items."
    );

    // endregion

    // region Slimefun Warfare

    public static final MaterialTrait SFW_SEGGANESSON_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
        "Overcharge",
        "Stores energy each time you hit a mob.",
        "Every 10th attack releases this back."
    );

    public static final MaterialTrait SFW_SEGGANESSON_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
        "Blinding Speed",
        "Gain insane speed but with a side effect."
    );

    public static final MaterialTrait SFW_SEGGANESSON_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
        "Gravity",
        "All nearby entities are slowly pulled",
        "towards you"
    );

    public static final MaterialTrait SFW_SEGGANESSON_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
        "Soul Siphon",
        "Stores the souls of killed, hostile, mobs.",
        "Damage + 1% per 100 souls. Caps at 100%."
    );

    public static final MaterialTrait SFW_SLIMESTEEL_BINDING = new MaterialTrait(
        MaterialTrait.PROP_BINDING,
        SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
        "Bouncy II",
        "Fall damage halved with a jump boost."
    );

    public static final MaterialTrait SFW_SLIMESTEEL_GAMBESON = new MaterialTrait(
        MaterialTrait.PROP_GAMBESON,
        SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
        "Moon Bounce",
        "When on boots, fall damamge is ignored.",
        "You also get more bouncy."
    );

    public static final MaterialTrait SFW_REINFORCED_SLIMESTEEL_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
        "Strong and Sticky",
        "Dropped blocks go into your inventory",
        "when possible to do so"
    );

    public static final MaterialTrait SFW_REINFORCED_SLIMESTEEL_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
        "Flexibility",
        "Incoming damage reduced and durability is lost",
        "instead. Doesn't work while tool is broken."
    );

    public static final MaterialTrait SFW_REINFORCED_SLIMESTEEL_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
        "Regid Flexibility",
        "Speed and Jump + 1. Damage Taken + 10%"
    );

    public static final MaterialTrait SFW_REINFORCED_SLIMESTEEL_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
        "Deflection",
        "10% chance to ignore projectile damage."
    );

    public static final MaterialTrait SFW_OSMIUM_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
        "Heavy",
        "Mines in a 3x3 Area"
    );

    public static final MaterialTrait SFW_OSMIUM_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
        "Heavy Pommel",
        "Struck mobs are slowed and cannot teleport."
    );

    public static final MaterialTrait SFW_OSMIUM_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
        "Increased Mass",
        "Attackers will be knocked back.",
        "Gives you slow when procced"
    );

    public static final MaterialTrait SFW_OSMIUM_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
        "Draw",
        "5% chance to heal by damage dealt."
    );

    public static final MaterialTrait SFW_OSMIUM_SUPERALLOY_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
        "Brute",
        "Slow swinging speed. Hit enemies are stunned",
        "briefly. Damage +100% with an additional 33%",
        "chance to crit for a further +100%"
    );

    public static final MaterialTrait SFW_OSMIUM_SUPERALLOY_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
        "Tuff Stuff",
        "Knocks back anything hit and stuns."
    );

    public static final MaterialTrait SFW_OSMIUM_SUPERALLOY_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
        "Tempest",
        "When wearing 4 peices, chance when hit",
        "to summon a tempest."
    );

    public static final MaterialTrait SFW_OSMIUM_SUPERALLOY_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
        "Partial Decay",
        "Chance to damage random nearby living",
        "things. Will never kill."
    );

    public static final MaterialTrait SFW_UNPATENTABLIUM_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
        "Innovation",
        "+100% Tool and Player EXP during the day."
    );

    public static final MaterialTrait SFW_UNPATENTABLIUM_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
        "Incoporeal Right",
        "Tool cannot be dropped or lost on death."
    );

    public static final MaterialTrait SFW_UNPATENTABLIUM_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
        "Intense Gaze",
        "Entities you look at will teleport to you.",
        "Does not work on players or bosses."
    );

    public static final MaterialTrait SFW_UNPATENTABLIUM_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
        "KOTR",
        "Chance, when hit, to summon a Knight",
        "of the Round. (It's a Golem ;))"
    );

    // endregion

    // region DynaTech

    public static final MaterialTrait DYN_STAINLESS_STEEL_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.DYNATECH_NOTE,
        "Super Dooper Stainless",
        "Like Steel or MagSteel but yet more absurd."
    );

    public static final MaterialTrait DYN_STAINLESS_STEEL_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.DYNATECH_NOTE,
        "Cutlery",
        "Hitting animals will directly feed you. Grim"
    );

    public static final MaterialTrait DYN_STAINLESS_STEEL_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.DYNATECH_NOTE,
        "The Standard",
        "Damage taken reduced by 5%"
    );

    public static final MaterialTrait DYN_STAINLESS_STEEL_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.DYNATECH_NOTE,
        "Water Safe",
        "Gives you water breathing"
    );

    public static final MaterialTrait DYN_VEX_GEM_BINDING = new MaterialTrait(
        MaterialTrait.PROP_BINDING,
        SupportedPluginsManager.DYNATECH_NOTE,
        "NoClip",
        "Right click while holding to randomly teleport.",
        "5 min cooldown."
    );

    public static final MaterialTrait DYN_VEX_GEM_GAMBESON = new MaterialTrait(
        MaterialTrait.PROP_GAMBESON,
        SupportedPluginsManager.DYNATECH_NOTE,
        "Annoying",
        "Vex gems shouldn't be used like this!"
    );

    public static final MaterialTrait DYN_STAR_DUST_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.DYNATECH_NOTE,
        "Bright Fury",
        "Attacks dazzle and blind while being.",
        "50% more powerful."
    );

    public static final MaterialTrait DYN_STAR_DUST_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.DYNATECH_NOTE,
        "Yvaine",
        "Gives an ethereal glow and makes villagers",
        "friendlier to you."
    );

    public static final MaterialTrait DYN_STAR_DUST_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.DYNATECH_NOTE,
        "Starshine",
        "5% chance to heal 1/2 heart during the night"
    );

    public static final MaterialTrait DYN_STAR_DUST_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.DYNATECH_NOTE,
        "Brightburn",
        "Gives on stack of Burning Bright! With 4 ",
        "stacks, hostile mobs are repelled (not bosses)."
    );

    public static final MaterialTrait DYN_GHOSTLY_ESSENCE_HEAD = new MaterialTrait(
        MaterialTrait.PROP_BINDING,
        SupportedPluginsManager.DYNATECH_NOTE,
        "Incorporeal",
        "Projectiles just pass right through you."
    );

    public static final MaterialTrait DYN_GHOSTLY_ESSENCE_ROD = new MaterialTrait(
        MaterialTrait.PROP_ROD,
        SupportedPluginsManager.DYNATECH_NOTE,
        "HyperCube [B]",
        "Only works with both [A] and [B]. Shift + Right",
        "click to store a location. Right click to recall",
        "to that location. 10min CD."
    );

    public static final MaterialTrait DYN_GHOSTLY_ESSENCE_PLATES = new MaterialTrait(
        MaterialTrait.PROP_GAMBESON,
        SupportedPluginsManager.DYNATECH_NOTE,
        "Ghost in the shell",
        "Slowly damages all nearby mobs at the cost of durability.",
        "Mobs cannot die due to this effect."
    );

    public static final MaterialTrait DYN_GHOSTLY_ESSENCE_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.DYNATECH_NOTE,
        "Ghostly",
        "Hover like a ghost"
    );

    public static final MaterialTrait DYN_TESSERACT_HEAD = new MaterialTrait(
        MaterialTrait.PROP_HEAD,
        SupportedPluginsManager.DYNATECH_NOTE,
        "HyperCube [A]",
        "Only works with both [A] and [B]. Shift + Right",
        "click to store a location. Right click to recall",
        "to that location. 10min CD."
    );

    public static final MaterialTrait DYN_TESSERACT_PLATES = new MaterialTrait(
        MaterialTrait.PROP_PLATES,
        SupportedPluginsManager.DYNATECH_NOTE,
        "Hyberbolic Tesseration",
        "When in your personal home, you store energy.",
        "Damage taken is removed from this energy pool.",
        "Required 8x pieces to function and caps at 50."
    );

    public static final MaterialTrait DYN_TESSERACT_LINKS = new MaterialTrait(
        MaterialTrait.PROP_LINKS,
        SupportedPluginsManager.DYNATECH_NOTE,
        "Hyberbolic Tesseration",
        "When in your personal home, you store energy.",
        "Damage taken is removed from this energy pool.",
        "Required 8x pieces to function and caps at 50",
        "per peice."
    );

    // endregion

}
