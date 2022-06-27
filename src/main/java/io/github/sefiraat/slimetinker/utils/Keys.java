package io.github.sefiraat.slimetinker.utils;

import io.github.sefiraat.slimetinker.SlimeTinker;
import org.bukkit.NamespacedKey;

import javax.annotation.Nonnull;

public final class Keys {

    private Keys() {
        throw new UnsupportedOperationException("Utility Class");
    }

    // ItemGroups
    public static final NamespacedKey ITEM_GROUP_MAIN = create("slime-tinker");
    public static final NamespacedKey ITEM_GROUP_WORKSTATIONS = create("slime-tinker-workstations");
    public static final NamespacedKey ITEM_GROUP_MATERIALS = create("slime-tinker-materials");
    public static final NamespacedKey ITEM_GROUP_MOLTEN = create("slime-tinker-molten");
    public static final NamespacedKey ITEM_GROUP_ALLOYS = create("slime-tinker-alloys");
    public static final NamespacedKey ITEM_GROUP_PROPERTIES = create("slime-tinker-properties");
    public static final NamespacedKey ITEM_GROUP_CASTS = create("slime-tinker-casts");
    public static final NamespacedKey ITEM_GROUP_PARTS = create("slime-tinker-parts");
    public static final NamespacedKey ITEM_GROUP_PART_DICT = create("slime-tinker-part-dict");
    public static final NamespacedKey ITEM_GROUP_TOOLS = create("slime-tinker-tools");
    public static final NamespacedKey ITEM_GROUP_ARMOUR = create("slime-tinker-armour");
    public static final NamespacedKey ITEM_GROUP_MODIFICATIONS = create("slime-tinker-modifications");
    public static final NamespacedKey ITEM_GROUP_DUMMY = create("slime-tinker-dummy");

    // Parts information
    public static final NamespacedKey PART_MATERIAL = create("ST_Material");
    public static final NamespacedKey PART_CLASS = create("ST_Class");
    public static final NamespacedKey PART_TYPE = create("ST_Type");

    // General Information
    public static final NamespacedKey ST_EXP_CURRENT = create("ST_CurrentExp");
    public static final NamespacedKey ST_EXP_REQUIRED = create("ST_NextLevelExp");
    public static final NamespacedKey ST_LEVEL = create("ST_Level");
    public static final NamespacedKey ST_MOD_SLOTS = create("ST_Modifier_Slots");
    public static final NamespacedKey ST_MODS = create("ST_Modifier_Map");
    public static final NamespacedKey ST_MOD_LEVEL_REDSTONE = create("ST_mod_level_redstone");
    public static final NamespacedKey ST_MOD_LEVEL_LAPIS = create("ST_mod_level_lapis");
    public static final NamespacedKey ST_MOD_LEVEL_QUARTZ = create("ST_mod_level_quartz");
    public static final NamespacedKey ST_MOD_LEVEL_DIAMOND = create("ST_mod_level_diamond");
    public static final NamespacedKey ST_MOD_LEVEL_EMERALD = create("ST_mod_level_emerald");
    public static final NamespacedKey ST_MOD_LEVEL_OBSIDIAN = create("ST_mod_level_obsidian");

    // Tool information
    public static final NamespacedKey TOOL_INFO_IS_TOOL = create("ST_Tool");
    public static final NamespacedKey TOOL_INFO_HEAD_TYPE = create("ST_Type_Head");
    public static final NamespacedKey TOOL_INFO_TOOL_TYPE = create("ST_Tool_Type");
    public static final NamespacedKey TOOL_INFO_HEAD_MATERIAL = create("ST_Material_Head");
    public static final NamespacedKey TOOL_INFO_BINDER_MATERIAL = create("ST_Material_Binder");
    public static final NamespacedKey TOOL_INFO_ROD_MATERIAL = create("ST_Material_Rod");

    // Armour information
    public static final NamespacedKey ARMOUR_INFO_IS_ARMOUR = create("ST_Armour");
    public static final NamespacedKey ARMOUR_INFO_PLATE_TYPE = create("ST_Type_Plate");
    public static final NamespacedKey ARMOUR_INFO_ARMOUR_TYPE = create("ST_Armour_Type");
    public static final NamespacedKey ARMOUR_INFO_PLATE_MATERIAL = create("ST_Material_Plate");
    public static final NamespacedKey ARMOUR_INFO_LINKS_MATERIAL = create("ST_Material_Links");
    public static final NamespacedKey ARMOUR_INFO_GAMBESON_MATERIAL = create("ST_Material_Gambeson");

    // Trait Keys
    public static final NamespacedKey TRAITS_COOLDOWN_NO_CLIP = create("ST_cd_noclip");
    public static final NamespacedKey TRAITS_COOLDOWN_HYPERCUBE = create("ST_cd_hypercube");
    public static final NamespacedKey TRAITS_HYPERCUBE_LOCATION = create("ST_loc_hypercube");
    public static final NamespacedKey TRAITS_COOLDOWN_PROTECTIVE = create("ST_cd_protective");
    public static final NamespacedKey TRAITS_COOLDOWN_WARP = create("ST_cd_warp");
    public static final NamespacedKey TOOL_FLAG_TELEPORT = create("ST_stop_teleport");
    public static final NamespacedKey ARMOUR_INFINITE_CAPACITY_STORED = create("ST_infinite_cap_stored");
    public static final NamespacedKey ARMOUR_INFINITLY_POWERFUL_STORED = create("ST_infinite_pow_stored");
    public static final NamespacedKey ARMOUR_HYPERBOLIC_STORED = create("ST_hyperbolic_stored");
    public static final NamespacedKey ARMOUR_UNCONVENTIONAL_STORED = create("ST_unconventional_stored");
    public static final NamespacedKey ARMOUR_SOULS_STORED = create("ST_souls_stored");
    public static final NamespacedKey ARMOUR_HAPPY_PIGLIN = create("ST_happy_piglin");
    public static final NamespacedKey STOP_EVENTS = create("STOP_EVENTS");
    public static final NamespacedKey DRACONIC_STACKS = create("draconic_stacks");
    public static final NamespacedKey DRACONIC_DURATION = create("draconic_duration");

    // Workstations
    public static final NamespacedKey WS_DUMMY_SMELTERY = create("dummy-smeltery");
    public static final NamespacedKey WS_DUMMY_SMELTERY_M = create("dummy-smeltery-molten");
    public static final NamespacedKey WS_DUMMY_SMELTERY_A = create("dummy-smeltery-alloy");
    public static final NamespacedKey WS_DUMMY_TOOL_TABLE = create("dummy-table");
    public static final NamespacedKey WS_DUMMY_ARMOUR_TABLE = create("dummy-table");
    public static final NamespacedKey WS_DUMMY_WORKBENCH = create("dummy-workbench");

    @Nonnull
    public static NamespacedKey create(@Nonnull String key) {
        return new NamespacedKey(SlimeTinker.getInstance(), key);
    }

}
