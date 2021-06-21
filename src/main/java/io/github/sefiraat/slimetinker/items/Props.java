package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.DummySmelteryProp;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import lombok.experimental.UtilityClass;
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
                    SkullTextures.PROPERTY,
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
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: 'Abra'",
                    ThemeUtils.PASSIVE + "Any hit mob has a % chance to be",
                    ThemeUtils.PASSIVE + "randomly teleported."
            );

    public static final SlimefunItemStack PROP_ALLTHATGLITTERS =
            ThemeUtils.themedItemStack(
                    "PROP_ALLTHATGLITTERS",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: All that glitters",
                    ThemeUtils.PASSIVE + "Makes you all shiny..."
            );

    public static final SlimefunItemStack PROP_ATTRACTION =
            ThemeUtils.themedItemStack(
                    "PROP_ATTRACTION",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Attraction",
                    ThemeUtils.PASSIVE + "All drops are drawn to you within a",
                    ThemeUtils.PASSIVE + "5 block range."
            );

    public static final SlimefunItemStack PROP_BRAINSNOTBRAWN =
            ThemeUtils.themedItemStack(
                    "PROP_BRAINSNOTBRAWN",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Brains not brawn",
                    ThemeUtils.PASSIVE + "Tool exp gain is doubled. Damage",
                    ThemeUtils.PASSIVE + "dealt is halved."
            );

    public static final SlimefunItemStack PROP_BRITTLE =
            ThemeUtils.themedItemStack(
                    "PROP_BRITTLE",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Brittle",
                    ThemeUtils.PASSIVE + "Durability loss is doubled."
            );

    public static final SlimefunItemStack PROP_BULKY =
            ThemeUtils.themedItemStack(
                    "PROP_BULKY",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Bulky",
                    ThemeUtils.PASSIVE + "Mines in a 3x3 area"
            );

    public static final SlimefunItemStack PROP_CAN =
            ThemeUtils.themedItemStack(
                    "PROP_CAN",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: ...can",
                    ThemeUtils.PASSIVE + "Your hunger just fades away"
            );

    public static final SlimefunItemStack PROP_CHARGEDA =
            ThemeUtils.themedItemStack(
                    "PROP_CHARGEDA",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Charged (A)",
                    ThemeUtils.PASSIVE + "Doesn't do anything... on it's own..."
            );

    public static final SlimefunItemStack PROP_CHARGEDB =
            ThemeUtils.themedItemStack(
                    "PROP_CHARGEDB",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Charged (B)",
                    ThemeUtils.PASSIVE + "Doesn't do anything... on it's own..."
            );

    public static final SlimefunItemStack PROP_CONDUCTIVE =
            ThemeUtils.themedItemStack(
                    "PROP_CONDUCTIVE",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Conductive",
                    ThemeUtils.PASSIVE + "All tool exp is converted to player exp.",
                    ThemeUtils.PASSIVE + "dealt is halved."
            );

    public static final SlimefunItemStack PROP_DECAY =
            ThemeUtils.themedItemStack(
                    "PROP_DECAY",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Decay",
                    ThemeUtils.PASSIVE + "Slowly repairs the tool at night.",
                    ThemeUtils.PASSIVE + "Stacks with mods. Must be in hand"
            );

    public static final SlimefunItemStack PROP_DOOM =
            ThemeUtils.themedItemStack(
                    "PROP_DOOM",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Doom",
                    ThemeUtils.PASSIVE + "I get a bad feeling from this..."
            );

    public static final SlimefunItemStack PROP_DURABLE =
            ThemeUtils.themedItemStack(
                    "PROP_DURABLE",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Durable",
                    ThemeUtils.PASSIVE + "Ignores being broken but damage 50%,",
                    ThemeUtils.PASSIVE + "mining will be slower and 0 exp."
            );

    public static final SlimefunItemStack PROP_EASYFIX =
            ThemeUtils.themedItemStack(
                    "PROP_EASYFIX",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Easy Fix",
                    ThemeUtils.PASSIVE + "Only 1 kit is needed to fully repair."
            );

    public static final SlimefunItemStack PROP_ENCHANTING =
            ThemeUtils.themedItemStack(
                    "PROP_ENCHANTING",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Enchanting",
                    ThemeUtils.PASSIVE + "Tool exp gain is halved. Tools add a",
                    ThemeUtils.PASSIVE + "random vanilla enchant when leveling. May or",
                    ThemeUtils.PASSIVE + "may not match the tool type."
            );

    public static final SlimefunItemStack PROP_FAST =
            ThemeUtils.themedItemStack(
                    "PROP_FAST",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Fast",
                    ThemeUtils.PASSIVE + "Move speed increased and haste applied.",
                    ThemeUtils.PASSIVE + "Stacks with modifiers."
            );

    public static final SlimefunItemStack PROP_FLAMABLE =
            ThemeUtils.themedItemStack(
                    "PROP_FLAMABLE",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Flammable",
                    ThemeUtils.PASSIVE + "Has a (Tool level x 5)% chance to",
                    ThemeUtils.PASSIVE + "set your enemies ablaze."
            );

    public static final SlimefunItemStack PROP_FLAMINGHOT =
            ThemeUtils.themedItemStack(
                    "PROP_FLAMINGHOT",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Brains not brawn",
                    ThemeUtils.PASSIVE + "Smelts things when possible."
            );

    public static final SlimefunItemStack PROP_FUSED =
            ThemeUtils.themedItemStack(
                    "PROP_FUSED",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Fused",
                    ThemeUtils.PASSIVE + "Tool cannot be dropped either by the",
                    ThemeUtils.PASSIVE + "player or on death."
            );

    public static final SlimefunItemStack PROP_GOLDENVEIL =
            ThemeUtils.themedItemStack(
                    "PROP_GOLDENVEIL",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Golden Veil",
                    ThemeUtils.PASSIVE + "Makes the player invisible. If used on",
                    ThemeUtils.PASSIVE + "a weapon, -100% damage."
            );

    public static final SlimefunItemStack PROP_GRACEFUL =
            ThemeUtils.themedItemStack(
                    "PROP_GRACEFUL",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Graceful",
                    ThemeUtils.PASSIVE + "DOLPHIN POWERS, ACTIVATE!"
            );

    public static final SlimefunItemStack PROP_GROWTH =
            ThemeUtils.themedItemStack(
                    "PROP_GROWTH",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Growth",
                    ThemeUtils.PASSIVE + "Slowly repairs the tool during the day.",
                    ThemeUtils.PASSIVE + "Stacks with mods. Must be in hand"
            );

    public static final SlimefunItemStack PROP_HEAVY =
            ThemeUtils.themedItemStack(
                    "PROP_HEAVY",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Heavy",
                    ThemeUtils.PASSIVE + "Mines in a 3x3 area."
            );

    public static final SlimefunItemStack PROP_HIDDEN =
            ThemeUtils.themedItemStack(
                    "PROP_HIDDEN",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Hidden",
                    ThemeUtils.PASSIVE + "Grants invisibility, breaks instantly."
            );

    public static final SlimefunItemStack PROP_INGHEIGHTS =
            ThemeUtils.themedItemStack(
                    "PROP_INGHEIGHTS",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Ingheights",
                    ThemeUtils.PASSIVE + "Something is wrong with this tool."
            );

    public static final SlimefunItemStack PROP_LEECH =
            ThemeUtils.themedItemStack(
                    "PROP_LEECH",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Leech",
                    ThemeUtils.PASSIVE + "Bonus health, but drains your energy."
            );

    public static final SlimefunItemStack PROP_MAGNETESIUM =
            ThemeUtils.themedItemStack(
                    "PROP_MAGNETESIUM",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Magnetesium",
                    ThemeUtils.PASSIVE + "Random items are drawn to you from",
                    ThemeUtils.PASSIVE + "within a 10 block range"
            );

    public static final SlimefunItemStack PROP_MALLEABLE =
            ThemeUtils.themedItemStack(
                    "PROP_MALLEABLE",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Malleable",
                    ThemeUtils.PASSIVE + "Deal 50% less damage but gain luck."
            );

    public static final SlimefunItemStack PROP_NIGHTSTALKER =
            ThemeUtils.themedItemStack(
                    "PROP_NIGHTSTALKER",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Night Stalker",
                    ThemeUtils.PASSIVE + "Gives night vision."
            );

    public static final SlimefunItemStack PROP_OXYGENATED =
            ThemeUtils.themedItemStack(
                    "PROP_OXYGENATED",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Oxygenated",
                    ThemeUtils.PASSIVE + "Gives water breathing while held."
            );

    public static final SlimefunItemStack PROP_POISONOUS =
            ThemeUtils.themedItemStack(
                    "PROP_POISONOUS",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Poisonous",
                    ThemeUtils.PASSIVE + "25% chance to afflict poison on hit."
            );

    public static final SlimefunItemStack PROP_RECYCLABLE =
            ThemeUtils.themedItemStack(
                    "PROP_RECYCLABLE",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Recyclable",
                    ThemeUtils.PASSIVE + "Chance to restore durability on hit/block break"
            );

    public static final SlimefunItemStack PROP_REFRESHING =
            ThemeUtils.themedItemStack(
                    "PROP_REFRESHING",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Refreshing",
                    ThemeUtils.PASSIVE + "Slowly heals the holder."
            );

    public static final SlimefunItemStack PROP_REINFORCED =
            ThemeUtils.themedItemStack(
                    "PROP_REINFORCED",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Reinforced",
                    ThemeUtils.PASSIVE + "Any Plate mod on the tool is counted twice."
            );

    public static final SlimefunItemStack PROP_RESISTANT =
            ThemeUtils.themedItemStack(
                    "PROP_RESISTANT",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Resistant",
                    ThemeUtils.PASSIVE + "Gives fire resistance while held."
            );

    public static final SlimefunItemStack PROP_SHARP1 =
            ThemeUtils.themedItemStack(
                    "PROP_SHARP1",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Sharp 1",
                    ThemeUtils.PASSIVE + "Gives increased damage, stacks with",
                    ThemeUtils.PASSIVE + "mods and other properties."
            );

    public static final SlimefunItemStack PROP_SHARP2 =
            ThemeUtils.themedItemStack(
                    "PROP_SHARP2",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Sharp 2",
                    ThemeUtils.PASSIVE + "Gives increased damage, stacks with",
                    ThemeUtils.PASSIVE + "mods and other properties."
            );

    public static final SlimefunItemStack PROP_SOFT =
            ThemeUtils.themedItemStack(
                    "PROP_SOFT",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Soft",
                    ThemeUtils.PASSIVE + "Durability loss +100%, tool EXP +50%."
            );

    public static final SlimefunItemStack PROP_SOFTTOUCH =
            ThemeUtils.themedItemStack(
                    "PROP_SOFTTOUCH",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Soft Touch",
                    ThemeUtils.PASSIVE + "You feel lighter."
            );

    public static final SlimefunItemStack PROP_SPRINGS =
            ThemeUtils.themedItemStack(
                    "PROP_SPRINGS",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Springs",
                    ThemeUtils.PASSIVE + "Makes you jump higher."
            );

    public static final SlimefunItemStack PROP_STABILITY =
            ThemeUtils.themedItemStack(
                    "PROP_STABILITY",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Stability",
                    ThemeUtils.PASSIVE + "Does... nothing!"
            );

    public static final SlimefunItemStack PROP_STAINLESS =
            ThemeUtils.themedItemStack(
                    "PROP_STAINLESS",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Stainless",
                    ThemeUtils.PASSIVE + "The tool/weapon repels blood."
            );

    public static final SlimefunItemStack PROP_STIFF =
            ThemeUtils.themedItemStack(
                    "PROP_STIFF",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Stiff",
                    ThemeUtils.PASSIVE + "Damage +50% but makes you unlucky"
            );

    public static final SlimefunItemStack PROP_STUDIOUS =
            ThemeUtils.themedItemStack(
                    "PROP_STUDIOUS",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Studious",
                    ThemeUtils.PASSIVE + "Tool and Player exp +50% but damage halved",
                    ThemeUtils.PASSIVE + "and you are slower to act."
            );

    public static final SlimefunItemStack PROP_SUPERLIGHTWEIGHT =
            ThemeUtils.themedItemStack(
                    "PROP_SUPERLIGHTWEIGHT",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Super Lightweight",
                    ThemeUtils.PASSIVE + "Makes you lighter than air."
            );

    public static final SlimefunItemStack PROP_TUFFSTUFF =
            ThemeUtils.themedItemStack(
                    "PROP_TUFFSTUFF",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Tuff Stuff",
                    ThemeUtils.PASSIVE + "Knocks back anything hit with a chance",
                    ThemeUtils.PASSIVE + "to stun."
            );

    public static final SlimefunItemStack PROP_VAMPIRISM =
            ThemeUtils.themedItemStack(
                    "PROP_VAMPIRISM",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Vampirism",
                    ThemeUtils.PASSIVE + "Chance to heal by damage given.",
                    ThemeUtils.PASSIVE + "Damage dealt varies by time of day."
            );

    public static final SlimefunItemStack PROP_WEAK =
            ThemeUtils.themedItemStack(
                    "PROP_WEAK",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Growth",
                    ThemeUtils.PASSIVE + "You feel weak."
            );

    public static final SlimefunItemStack PROP_WORKS =
            ThemeUtils.themedItemStack(
                    "PROP_WORKS",
                    SkullTextures.PROPERTY,
                    ThemeUtils.ThemeItemType.PROP,
                    "Property: Works",
                    ThemeUtils.PASSIVE + "No special effects."
            );

    // endregion

    public static void set(SlimeTinker p) {
        // Dummies for the recipe book
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
    }
    

}
