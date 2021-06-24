package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.DummySmelteryProp;
import io.github.sefiraat.slimetinker.managers.SupportedPluginsManager;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@UtilityClass
public final class Props {

    // region Dummy parts
    // Used to display the 'head' item in Property explanation recipes only
    public static final SlimefunItemStack PROP_HEAD =
            ThemeUtils.themedItemStack(
                    "PROP_HEAD",
                    SkullTextures.PART_SWORD_BLADE,
                    ThemeUtils.ThemeItemType.PART,
                    "Part: Head",
                    ThemeUtils.PASSIVE + "Any 'Head' item (Sword Blade, Axe Head etc.)"
            );
    // Used to display the 'binding' item in Property explanation recipes only
    public static final SlimefunItemStack PROP_BINDING =
            ThemeUtils.themedItemStack(
                    "PROP_BINDING",
                    SkullTextures.PART_SWORD_BLADE,
                    ThemeUtils.ThemeItemType.PART,
                    "Part: Head",
                    ThemeUtils.PASSIVE + "Any 'Binder' item."
            );
    // Used to display the 'rod' item in Property explanation recipes only
    public static final SlimefunItemStack PROP_ROD =
            ThemeUtils.themedItemStack(
                    "PROP_ROD",
                    SkullTextures.PART_TOOL_ROD,
                    ThemeUtils.ThemeItemType.PART,
                    "Part: Tool Rod",
                    ThemeUtils.PASSIVE + "Any 'Tool Rod' item."
            );
    // Used to display the 'rod' item in Property explanation recipes only
    public static final SlimefunItemStack PROP_HEADROD =
            ThemeUtils.themedItemStack(
                    "PROP_HEADROD",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PART,
                    "Part: Head and Rod",
                    ThemeUtils.PASSIVE + "Any 'Head' or 'Tool Rod'."
            );

    protected static ItemStack[] propRecipe(SlimefunItemStack part, ItemStack stack) {
        return new ItemStack[]{
                null, null, null,
                part, null, stack,
                null, null, null
        };
    }

    // endregion

    //region itemstacks
    public static final SlimefunItemStack PROP_ABRA =
            ThemeUtils.themedItemStack(
                    "PROP_ABRA",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: 'Abra'",
                    ThemeUtils.PASSIVE + "Any hit mob has a % chance to be",
                    ThemeUtils.PASSIVE + "randomly teleported."
            );

    public static final SlimefunItemStack PROP_ADAMANT =
            ThemeUtils.themedItemStack(
                    "PROP_ADAMANT",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Adamant",
                    ThemeUtils.PASSIVE + "Become immune to all explosions",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_ALLTHATGLITTERS =
            ThemeUtils.themedItemStack(
                    "PROP_ALLTHATGLITTERS",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: All that glitters",
                    ThemeUtils.PASSIVE + "Makes you all shiny..."
            );

    public static final SlimefunItemStack PROP_ALLTHATGLITTERS2 =
            ThemeUtils.themedItemStack(
                    "PROP_ALLTHATGLITTERS2",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: All that Glitters II",
                    ThemeUtils.PASSIVE + "Makes you shiny AND rainbow...y",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_ATTRACTION =
            ThemeUtils.themedItemStack(
                    "PROP_ATTRACTION",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Attraction",
                    ThemeUtils.PASSIVE + "All drops are drawn to you within a",
                    ThemeUtils.PASSIVE + "5 block range."
            );

    public static final SlimefunItemStack PROP_BRAINSNOTBRAWN =
            ThemeUtils.themedItemStack(
                    "PROP_BRAINSNOTBRAWN",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Brains not brawn",
                    ThemeUtils.PASSIVE + "Tool exp gain is doubled. Damage",
                    ThemeUtils.PASSIVE + "dealt is halved."
            );

    public static final SlimefunItemStack PROP_BRAINSNOTBRAWN2 =
            ThemeUtils.themedItemStack(
                    "PROP_BRAINSNOTBRAWN2",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Brains Not Brawn II",
                    ThemeUtils.PASSIVE + "Tool exp +200%, Damage 50%",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_BREAKPOINT =
            ThemeUtils.themedItemStack(
                    "PROP_BREAKPOINT",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Breakpoint",
                    ThemeUtils.PASSIVE + "Unbreakable. +200% Damage.",
                    ThemeUtils.PASSIVE + "+200% Tool Exp and 3x3 Mining.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_BRITTLE =
            ThemeUtils.themedItemStack(
                    "PROP_BRITTLE",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Brittle",
                    ThemeUtils.PASSIVE + "Durability loss is doubled."
            );

    public static final SlimefunItemStack PROP_BULKY =
            ThemeUtils.themedItemStack(
                    "PROP_BULKY",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Bulky",
                    ThemeUtils.PASSIVE + "Mines in a 3x3 area"
            );

    public static final SlimefunItemStack PROP_CAN =
            ThemeUtils.themedItemStack(
                    "PROP_CAN",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: ...can",
                    ThemeUtils.PASSIVE + "Your hunger just fades away"
            );

    public static final SlimefunItemStack PROP_CAN2 =
            ThemeUtils.themedItemStack(
                    "PROP_CAN2",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Can II",
                    ThemeUtils.PASSIVE + "No Hunger Loss",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_CHARGEDA =
            ThemeUtils.themedItemStack(
                    "PROP_CHARGEDA",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Charged (A)",
                    ThemeUtils.PASSIVE + "Doesn't do anything... on it's own..."
            );

    public static final SlimefunItemStack PROP_CHARGEDB =
            ThemeUtils.themedItemStack(
                    "PROP_CHARGEDB",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Charged (B)",
                    ThemeUtils.PASSIVE + "Doesn't do anything... on it's own..."
            );

    public static final SlimefunItemStack PROP_CLEANCUT =
            ThemeUtils.themedItemStack(
                    "PROP_CLEANCUT",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Clean Cut",
                    ThemeUtils.PASSIVE + "Damage +100%. Haste 2",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_CONCEPTUALDEFENCE =
            ThemeUtils.themedItemStack(
                    "PROP_CONCEPTUALDEFENCE",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Conceptual Defence",
                    ThemeUtils.PASSIVE + "All damage is halved (rounded up).",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_CONDUCTIVE =
            ThemeUtils.themedItemStack(
                    "PROP_CONDUCTIVE",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Conductive",
                    ThemeUtils.PASSIVE + "All tool exp is converted to player exp.",
                    ThemeUtils.PASSIVE + "dealt is halved."
            );

    public static final SlimefunItemStack PROP_CONDUCTIVE2 =
            ThemeUtils.themedItemStack(
                    "PROP_CONDUCTIVE2",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Conductive II",
                    ThemeUtils.PASSIVE + "All tool exp is converted to player exp",
                    ThemeUtils.PASSIVE + "with a 50% bonus.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_CONDUCTOR =
            ThemeUtils.themedItemStack(
                    "PROP_CONDUCTOR",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Conductor",
                    ThemeUtils.PASSIVE + "All player exp is converted to tool",
                    ThemeUtils.PASSIVE + "exp at a 10 : 1 ratio.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_DECAY =
            ThemeUtils.themedItemStack(
                    "PROP_DECAY",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Decay",
                    ThemeUtils.PASSIVE + "Slowly repairs the tool at night.",
                    ThemeUtils.PASSIVE + "Stacks with mods. Must be in hand"
            );

    public static final SlimefunItemStack PROP_DOOM =
            ThemeUtils.themedItemStack(
                    "PROP_DOOM",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Doom",
                    ThemeUtils.PASSIVE + "I get a bad feeling from this..."
            );

    public static final SlimefunItemStack PROP_DURABLE =
            ThemeUtils.themedItemStack(
                    "PROP_DURABLE",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Durable",
                    ThemeUtils.PASSIVE + "Ignores being broken but damage 50%,",
                    ThemeUtils.PASSIVE + "mining will be slower and 0 exp."
            );

    public static final SlimefunItemStack PROP_DURABLE_CO =
            ThemeUtils.themedItemStack(
                    "PROP_DURABLE_CO",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Durable",
                    ThemeUtils.PASSIVE + "Ignores being broken but damage 50%,",
                    ThemeUtils.PASSIVE + "mining will be slower and 0 exp.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_EARTHSHAKER =
            ThemeUtils.themedItemStack(
                    "PROP_EARTHSHAKER",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Earthshaker",
                    ThemeUtils.PASSIVE + "Knocks back hit mobs and stuns them",
                    ThemeUtils.PASSIVE + "when they land.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_EASYFIX =
            ThemeUtils.themedItemStack(
                    "PROP_EASYFIX",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Easy Fix",
                    ThemeUtils.PASSIVE + "Only 1 kit is needed to fully repair."
            );

    public static final SlimefunItemStack PROP_ELVENSPEED =
            ThemeUtils.themedItemStack(
                    "PROP_ELVENSPEED",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Elven Speed",
                    ThemeUtils.PASSIVE + "Haste 2, Speed 1. Durability loss +50%",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_ENCHANTING =
            ThemeUtils.themedItemStack(
                    "PROP_ENCHANTING",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Enchanting",
                    ThemeUtils.PASSIVE + "Tool exp gain is halved. Tools add a",
                    ThemeUtils.PASSIVE + "random vanilla enchant when leveling. May or",
                    ThemeUtils.PASSIVE + "may not match the tool type."
            );

    public static final SlimefunItemStack PROP_ENCHANTING2 =
            ThemeUtils.themedItemStack(
                    "PROP_ENCHANTING2",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Enchanting II",
                    ThemeUtils.PASSIVE + "Tool exp gain is halved. Tools add 1-3",
                    ThemeUtils.PASSIVE + "randomly selected enchants when leveling",
                    ThemeUtils.PASSIVE + "up. These enchants may not be useful!",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_FAST =
            ThemeUtils.themedItemStack(
                    "PROP_FAST",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Fast",
                    ThemeUtils.PASSIVE + "Move speed increased and haste applied.",
                    ThemeUtils.PASSIVE + "Stacks with modifiers."
            );

    public static final SlimefunItemStack PROP_FEARTHEVOID =
            ThemeUtils.themedItemStack(
                    "PROP_FEARTHEVOID",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Fear The Void",
                    ThemeUtils.PASSIVE + "Damage +150%. 250% in the End.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_FLAMABLE =
            ThemeUtils.themedItemStack(
                    "PROP_FLAMABLE",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Flammable",
                    ThemeUtils.PASSIVE + "Has a (Tool level x 5)% chance to",
                    ThemeUtils.PASSIVE + "set your enemies ablaze."
            );

    public static final SlimefunItemStack PROP_FLAMABLE_CO =
            ThemeUtils.themedItemStack(
                    "PROP_FLAMABLE_CO",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Flammable",
                    ThemeUtils.PASSIVE + "Has a (Tool level x 5)% chance to",
                    ThemeUtils.PASSIVE + "set your enemies ablaze.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_FLAMABLE2 =
            ThemeUtils.themedItemStack(
                    "PROP_FLAMABLE2",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Flammable II",
                    ThemeUtils.PASSIVE + "Has a (Tool level x 10)% chance to",
                    ThemeUtils.PASSIVE + "set your enemies ablaze for a longer time.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_FLAMINGHOT =
            ThemeUtils.themedItemStack(
                    "PROP_FLAMINGHOT",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Brains not brawn",
                    ThemeUtils.PASSIVE + "Smelts things when possible."
            );

    public static final SlimefunItemStack PROP_FLAMINGHOT_CO =
            ThemeUtils.themedItemStack(
                    "PROP_FLAMINGHOT_CO",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Brains not brawn",
                    ThemeUtils.PASSIVE + "Smelts things when possible.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_FORTUNATE =
            ThemeUtils.themedItemStack(
                    "PROP_FORTUNATE",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Fortunate",
                    ThemeUtils.PASSIVE + "200% drops from fortune. Stacks",
                    ThemeUtils.PASSIVE + "with Lapis modifiers.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_FUSED =
            ThemeUtils.themedItemStack(
                    "PROP_FUSED",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Fused",
                    ThemeUtils.PASSIVE + "Tool cannot be dropped either by the",
                    ThemeUtils.PASSIVE + "player or on death."
            );

    public static final SlimefunItemStack PROP_GOLDENVEIL =
            ThemeUtils.themedItemStack(
                    "PROP_GOLDENVEIL",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Golden Veil",
                    ThemeUtils.PASSIVE + "Makes the player invisible. If used on",
                    ThemeUtils.PASSIVE + "a weapon, -100% damage."
            );

    public static final SlimefunItemStack PROP_GOLDENVEIL2 =
            ThemeUtils.themedItemStack(
                    "PROP_GOLDENVEIL2",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Golden Veil II",
                    ThemeUtils.PASSIVE + "Makes the player invisible. If used on",
                    ThemeUtils.PASSIVE + "a weapon, +150% damage.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_GRACEFUL =
            ThemeUtils.themedItemStack(
                    "PROP_GRACEFUL",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Graceful",
                    ThemeUtils.PASSIVE + "DOLPHIN POWERS, ACTIVATE!"
            );

    public static final SlimefunItemStack PROP_GRACEFUL2 =
            ThemeUtils.themedItemStack(
                    "PROP_GRACEFUL2",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Graceful II",
                    ThemeUtils.PASSIVE + "DOLPHIN POWERS, ACTIVATE... MORE!",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_GRINDER =
            ThemeUtils.themedItemStack(
                    "PROP_GRINDER",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Grinder",
                    ThemeUtils.PASSIVE + "Breaking blocks act as if they have",
                    ThemeUtils.PASSIVE + "gone through the grinder.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_GROWTH =
            ThemeUtils.themedItemStack(
                    "PROP_GROWTH",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Growth",
                    ThemeUtils.PASSIVE + "Slowly repairs the tool during the day.",
                    ThemeUtils.PASSIVE + "Stacks with mods. Must be in hand"
            );

    public static final SlimefunItemStack PROP_HEAVY =
            ThemeUtils.themedItemStack(
                    "PROP_HEAVY",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Heavy",
                    ThemeUtils.PASSIVE + "Mines in a 3x3 area."
            );

    public static final SlimefunItemStack PROP_HIDDEN =
            ThemeUtils.themedItemStack(
                    "PROP_HIDDEN",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Hidden",
                    ThemeUtils.PASSIVE + "Grants invisibility, breaks instantly."
            );

    public static final SlimefunItemStack PROP_INFINITE =
            ThemeUtils.themedItemStack(
                    "PROP_INFINITE",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Infinite",
                    ThemeUtils.PASSIVE + "This tool will live on forever.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_INGHEIGHTS =
            ThemeUtils.themedItemStack(
                    "PROP_INGHEIGHTS",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Ingheights",
                    ThemeUtils.PASSIVE + "Something is wrong with this tool."
            );

    public static final SlimefunItemStack PROP_LEECH =
            ThemeUtils.themedItemStack(
                    "PROP_LEECH",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Leech",
                    ThemeUtils.PASSIVE + "Bonus health, but drains your energy."
            );

    public static final SlimefunItemStack PROP_LEECH2 =
            ThemeUtils.themedItemStack(
                    "PROP_LEECH2",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Leech II",
                    ThemeUtils.PASSIVE + "Adds 6 bonus hearts.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_MAGNANIMOUS =
            ThemeUtils.themedItemStack(
                    "PROP_MAGNANIMOUS",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Magnanimous II",
                    ThemeUtils.PASSIVE + "You're just far too kind",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_MAGNETESIUM =
            ThemeUtils.themedItemStack(
                    "PROP_MAGNETESIUM",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Magnetesium",
                    ThemeUtils.PASSIVE + "Random items are drawn to you from",
                    ThemeUtils.PASSIVE + "within a 5 block range"
            );

    public static final SlimefunItemStack PROP_MAGNETESIUM2 =
            ThemeUtils.themedItemStack(
                    "PROP_MAGNETESIUM2",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Magnetesium II",
                    ThemeUtils.PASSIVE + "Random items are drawn to you from",
                    ThemeUtils.PASSIVE + "within a 10 block range",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_MALLEABLE =
            ThemeUtils.themedItemStack(
                    "PROP_MALLEABLE",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Malleable",
                    ThemeUtils.PASSIVE + "Deal 50% less damage but gain luck."
            );

    public static final SlimefunItemStack PROP_MALLEABLE2 =
            ThemeUtils.themedItemStack(
                    "PROP_MALLEABLE2",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Malleable II",
                    ThemeUtils.PASSIVE + "Deal 50% less damage but gain lots of",
                    ThemeUtils.PASSIVE + "Luck and Speed.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_MERCHANTSVEIL =
            ThemeUtils.themedItemStack(
                    "PROP_MERCHANTSVEIL",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Merchant's Veil",
                    ThemeUtils.PASSIVE + "Invisibility with none of the drawbacks!",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_MYSTIC =
            ThemeUtils.themedItemStack(
                    "PROP_MYSTIC",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Mystic",
                    ThemeUtils.PASSIVE + "Player Exp + 100% (Mining) +50% (Mobs)",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_NIGHTSTALKER =
            ThemeUtils.themedItemStack(
                    "PROP_NIGHTSTALKER",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Night Stalker",
                    ThemeUtils.PASSIVE + "Gives night vision."
            );

    public static final SlimefunItemStack PROP_OXYGENATED =
            ThemeUtils.themedItemStack(
                    "PROP_OXYGENATED",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Oxygenated",
                    ThemeUtils.PASSIVE + "Gives water breathing while held."
            );

    public static final SlimefunItemStack PROP_POISONOUS =
            ThemeUtils.themedItemStack(
                    "PROP_POISONOUS",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Poisonous",
                    ThemeUtils.PASSIVE + "25% chance to afflict poison on hit."
            );

    public static final SlimefunItemStack PROP_POISONOUS2 =
            ThemeUtils.themedItemStack(
                    "PROP_POISONOUS2",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Poisonous II",
                    ThemeUtils.PASSIVE + "Poisons more frequently and for longer.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_REALLYSTAINLESS =
            ThemeUtils.themedItemStack(
                    "PROP_REALLYSTAINLESS",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Really Stainless",
                    ThemeUtils.PASSIVE + "Like Stainless, but.. REALLY.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_RECYCLABLE =
            ThemeUtils.themedItemStack(
                    "PROP_RECYCLABLE",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Recyclable",
                    ThemeUtils.PASSIVE + "Chance to restore durability on hit/block break"
            );

    public static final SlimefunItemStack PROP_RECYCLABLE2 =
            ThemeUtils.themedItemStack(
                    "PROP_RECYCLABLE2",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Recyclable II",
                    ThemeUtils.PASSIVE + "Chance to restore durability on hit/block break",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_REFRESHING =
            ThemeUtils.themedItemStack(
                    "PROP_REFRESHING",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Refreshing",
                    ThemeUtils.PASSIVE + "Slowly heals the holder."
            );

    public static final SlimefunItemStack PROP_REINFORCED =
            ThemeUtils.themedItemStack(
                    "PROP_REINFORCED",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Reinforced",
                    ThemeUtils.PASSIVE + "Any Plate mod on the tool is counted twice."
            );

    public static final SlimefunItemStack PROP_REINFORCED_CO =
            ThemeUtils.themedItemStack(
                    "PROP_REINFORCED_CO",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Reinforced",
                    ThemeUtils.PASSIVE + "Any Plate mod on the tool is counted twice.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_RESISTANT =
            ThemeUtils.themedItemStack(
                    "PROP_RESISTANT",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Resistant",
                    ThemeUtils.PASSIVE + "Gives fire resistance while held."
            );

    public static final SlimefunItemStack PROP_SECRETSREVEALED =
            ThemeUtils.themedItemStack(
                    "PROP_SECRETSREVEALED",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Secrets Revealed",
                    ThemeUtils.PASSIVE + "Reveals all nearby living (or not!) things.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_SHARP1 =
            ThemeUtils.themedItemStack(
                    "PROP_SHARP1",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Sharp 1",
                    ThemeUtils.PASSIVE + "Gives increased damage, stacks with",
                    ThemeUtils.PASSIVE + "mods and other properties."
            );

    public static final SlimefunItemStack PROP_SHARP12 =
            ThemeUtils.themedItemStack(
                    "PROP_SHARP12",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Sharp 1 II",
                    ThemeUtils.PASSIVE + "What a bad naming convention. +Damage",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_SHARP2 =
            ThemeUtils.themedItemStack(
                    "PROP_SHARP2",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Sharp 2",
                    ThemeUtils.PASSIVE + "Gives increased damage, stacks with",
                    ThemeUtils.PASSIVE + "mods and other properties."
            );

    public static final SlimefunItemStack PROP_SOFT =
            ThemeUtils.themedItemStack(
                    "PROP_SOFT",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Soft",
                    ThemeUtils.PASSIVE + "Durability loss +100%, tool EXP +50%."
            );

    public static final SlimefunItemStack PROP_SOFT2 =
            ThemeUtils.themedItemStack(
                    "PROP_SOFT2",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Soft II",
                    ThemeUtils.PASSIVE + "Durability loss +100%, tool EXP +100%.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_SOFTTOUCH =
            ThemeUtils.themedItemStack(
                    "PROP_SOFTTOUCH",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Soft Touch",
                    ThemeUtils.PASSIVE + "You feel lighter."
            );

    public static final SlimefunItemStack PROP_SOFTTOUCH2 =
            ThemeUtils.themedItemStack(
                    "PROP_SOFTTOUCH2",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Soft Touch II",
                    ThemeUtils.PASSIVE + "The ground is no obstacle. No fall damage.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_SPRINGS =
            ThemeUtils.themedItemStack(
                    "PROP_SPRINGS",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Springs",
                    ThemeUtils.PASSIVE + "Makes you jump higher."
            );

    public static final SlimefunItemStack PROP_STABILITY =
            ThemeUtils.themedItemStack(
                    "PROP_STABILITY",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Stability",
                    ThemeUtils.PASSIVE + "Does... nothing!"
            );

    public static final SlimefunItemStack PROP_STABILITY2 =
            ThemeUtils.themedItemStack(
                    "PROP_STABILITY2",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Stability",
                    ThemeUtils.PASSIVE + "Yup, still does nothing.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_STAINLESS =
            ThemeUtils.themedItemStack(
                    "PROP_STAINLESS",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Stainless",
                    ThemeUtils.PASSIVE + "The tool/weapon repels blood."
            );

    public static final SlimefunItemStack PROP_STIFF =
            ThemeUtils.themedItemStack(
                    "PROP_STIFF",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Stiff",
                    ThemeUtils.PASSIVE + "Damage +50% but makes you unlucky"
            );

    public static final SlimefunItemStack PROP_STINGOFGONDOLIN =
            ThemeUtils.themedItemStack(
                    "PROP_STINGOFGONDOLIN",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Sting of Gondolin",
                    ThemeUtils.PASSIVE + "All nearby, hostile, mobs are repelled.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_STUDIOUS =
            ThemeUtils.themedItemStack(
                    "PROP_STUDIOUS",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Studious",
                    ThemeUtils.PASSIVE + "Tool and Player exp +50% but damage halved",
                    ThemeUtils.PASSIVE + "and you are slower to act."
            );

    public static final SlimefunItemStack PROP_SUPERLIGHTWEIGHT =
            ThemeUtils.themedItemStack(
                    "PROP_SUPERLIGHTWEIGHT",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Super Lightweight",
                    ThemeUtils.PASSIVE + "Makes you lighter than air when not sneaking."
            );

    public static final SlimefunItemStack PROP_SUPERLIGHTWEIGHT2 =
            ThemeUtils.themedItemStack(
                    "PROP_SUPERLIGHTWEIGHT2",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Super Lightweight II",
                    ThemeUtils.PASSIVE + "Makes you lighter than air when you ARE sneaking.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_TRICKS =
            ThemeUtils.themedItemStack(
                    "PROP_TRICKS",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Tricks",
                    ThemeUtils.PASSIVE + "Plays nasty tricks on nearby things.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_TUFFSTUFF =
            ThemeUtils.themedItemStack(
                    "PROP_TUFFSTUFF",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Tuff Stuff",
                    ThemeUtils.PASSIVE + "Knocks back anything hit with a chance",
                    ThemeUtils.PASSIVE + "to stun."
            );

    public static final SlimefunItemStack PROP_VAMPIRISM =
            ThemeUtils.themedItemStack(
                    "PROP_VAMPIRISM",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Vampirism",
                    ThemeUtils.PASSIVE + "Chance to heal by damage given.",
                    ThemeUtils.PASSIVE + "Damage dealt varies by time of day."
            );

    public static final SlimefunItemStack PROP_VOIDMINER =
            ThemeUtils.themedItemStack(
                    "PROP_VOIDMINER",
                    SkullTextures.PROPERTIES_INFINITY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Void Miner",
                    ThemeUtils.PASSIVE + "Randomly generates ores while mining/digging.",
                    ThemeUtils.ITEM_TYPEDESC + "Added by: " + ThemeUtils.ADD_INFINITY + "Infinity Expansion"
            );

    public static final SlimefunItemStack PROP_WEAK =
            ThemeUtils.themedItemStack(
                    "PROP_WEAK",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Growth",
                    ThemeUtils.PASSIVE + "You feel weak."
            );

    public static final SlimefunItemStack PROP_WORKS =
            ThemeUtils.themedItemStack(
                    "PROP_WORKS",
                    SkullTextures.PROPERTIES_CORE,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Works",
                    ThemeUtils.PASSIVE + "No special effects."
            );

    // endregion

    public static void set(SlimeTinker p) {
        // Core SF + Vanilla
        new UnplaceableBlock(Categories.PROPERTIES, PROP_ABRA, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItems.ALUMINUM_BRASS_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_ALLTHATGLITTERS, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, new ItemStack(Material.GOLD_INGOT))).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_ATTRACTION, DummySmelteryProp.TYPE, propRecipe(PROP_BINDING, new ItemStack(Material.TWISTING_VINES))).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_BRAINSNOTBRAWN, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItems.COPPER_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_BRITTLE, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItems.ALUMINUM_BRONZE_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_BULKY, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItems.REINFORCED_ALLOY_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_CAN, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItems.TIN_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_CHARGEDA, DummySmelteryProp.TYPE, propRecipe(PROP_HEADROD, SlimefunItems.NICKEL_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_CHARGEDB, DummySmelteryProp.TYPE, propRecipe(PROP_HEADROD, SlimefunItems.COBALT_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_CONDUCTIVE, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItems.COPPER_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_DECAY, DummySmelteryProp.TYPE, propRecipe(PROP_BINDING, new ItemStack(Material.CRIMSON_ROOTS))).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_DOOM, DummySmelteryProp.TYPE, propRecipe(PROP_BINDING, new ItemStack(Material.WEEPING_VINES))).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_DURABLE, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItems.DURALUMIN_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_EASYFIX, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItems.DURALUMIN_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_ENCHANTING, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItems.SILVER_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_FAST, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItems.BILLON_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_FLAMABLE, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItems.MAGNESIUM_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_FLAMINGHOT, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItems.CORINTHIAN_BRONZE_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_FUSED, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItems.SOLDER_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_GOLDENVEIL, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, new ItemStack(Material.GOLD_INGOT))).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_GRACEFUL, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItems.ZINC_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_GROWTH, DummySmelteryProp.TYPE, propRecipe(PROP_BINDING, new ItemStack(Material.VINE))).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_HEAVY, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItems.HARDENED_METAL_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_HIDDEN, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItems.SOLDER_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_INGHEIGHTS, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItems.BRONZE_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_LEECH, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItems.LEAD_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_MAGNETESIUM, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItems.MAGNESIUM_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_MALLEABLE, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItems.TIN_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_NIGHTSTALKER, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItems.DAMASCUS_STEEL_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_OXYGENATED, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItems.BRASS_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_POISONOUS, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItems.LEAD_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_RECYCLABLE, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItems.ALUMINUM_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_REFRESHING, DummySmelteryProp.TYPE, propRecipe(PROP_BINDING, new ItemStack(Material.WARPED_ROOTS))).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_REINFORCED, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItems.REINFORCED_ALLOY_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_RESISTANT, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItems.BRONZE_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_SHARP1, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, new ItemStack(Material.IRON_INGOT))).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_SHARP2, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItems.ALUMINUM_BRONZE_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_SOFT, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItems.ALUMINUM_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_SOFTTOUCH, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItems.SILVER_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_SPRINGS, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItems.BILLON_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_STABILITY, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, new ItemStack(Material.IRON_INGOT))).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_STAINLESS, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItems.STEEL_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_STIFF, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItems.BRASS_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_STUDIOUS, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItems.ALUMINUM_BRASS_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_SUPERLIGHTWEIGHT, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItems.ZINC_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_TUFFSTUFF, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItems.HARDENED_METAL_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_VAMPIRISM, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItems.DAMASCUS_STEEL_INGOT)).register(p);
        new UnplaceableBlock(Categories.PROPERTIES, PROP_WORKS, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, new ItemStack(Material.STRING))).register(p);

        // Infinity
        if (SupportedPluginsManager.INFINITY_EXPANSION) {
            new UnplaceableBlock(Categories.PROPERTIES, PROP_ALLTHATGLITTERS2, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItem.getByID("GOLD_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_ADAMANT, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItem.getByID("ADAMANTITE").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_BRAINSNOTBRAWN2, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItem.getByID("COPPER_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_BREAKPOINT, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItem.getByID("INFINITY_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_CAN2, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItem.getByID("TIN_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_CLEANCUT, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItem.getByID("METAL_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_CONCEPTUALDEFENCE, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItem.getByID("INFINITE_INGOT").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_CONDUCTIVE2, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItem.getByID("COPPER_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_CONDUCTOR, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItem.getByID("METAL_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_DURABLE_CO, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItem.getByID("TITANIUM").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_EARTHSHAKER, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItem.getByID("EARTH_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_ELVENSPEED, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItem.getByID("MYTHRIL").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_ENCHANTING2, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItem.getByID("SILVER_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_FEARTHEVOID, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItem.getByID("VOID_INGOT").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_FLAMABLE2, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItem.getByID("MAGNESIUM_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_FLAMABLE_CO, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItem.getByID("MAGSTEEL").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_FLAMINGHOT_CO, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItem.getByID("MAGNONIUM").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_FORTUNATE, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItem.getByID("FORTUNE_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_GOLDENVEIL2, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItem.getByID("GOLD_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_GRACEFUL2, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItem.getByID("ZINC_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_GRINDER, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItem.getByID("EARTH_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_INFINITE, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItem.getByID("INFINITE_INGOT").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_LEECH2, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItem.getByID("LEAD_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_MAGNANIMOUS, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItem.getByID("MAGNONIUM").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_MAGNETESIUM2, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItem.getByID("MAGNESIUM_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_MALLEABLE2, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItem.getByID("TIN_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_MERCHANTSVEIL, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItem.getByID("FORTUNE_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_MYSTIC, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItem.getByID("ADAMANTITE").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_POISONOUS2, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItem.getByID("LEAD_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_REALLYSTAINLESS, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItem.getByID("MAGSTEEL").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_RECYCLABLE2, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItem.getByID("ALUMINUM_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_REINFORCED_CO, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItem.getByID("TITANIUM").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_SECRETSREVEALED, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItem.getByID("MAGIC_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_SHARP12, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItem.getByID("IRON_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_SOFT2, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItem.getByID("ALUMINUM_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_SOFTTOUCH2, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItem.getByID("SILVER_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_STABILITY2, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItem.getByID("IRON_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_STINGOFGONDOLIN, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItem.getByID("MYTHRIL").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_SUPERLIGHTWEIGHT2, DummySmelteryProp.TYPE, propRecipe(PROP_ROD, SlimefunItem.getByID("ZINC_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_TRICKS, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItem.getByID("MAGIC_SINGULARITY").getItem())).register(p);
            new UnplaceableBlock(Categories.PROPERTIES, PROP_VOIDMINER, DummySmelteryProp.TYPE, propRecipe(PROP_HEAD, SlimefunItem.getByID("VOID_INGOT").getItem())).register(p);
        }

    }

}

