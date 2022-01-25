package io.github.sefiraat.slimetinker.utils;

import io.github.sefiraat.slimetinker.SlimeTinker;
import org.bukkit.NamespacedKey;

public class Keys {

    private Keys() {
        throw new UnsupportedOperationException("Utility Class");
    }

    // ItemGroups
    public static final NamespacedKey ITEM_GROUP_MAIN = new NamespacedKey(SlimeTinker.inst(), "slime-tinker");
    public static final NamespacedKey ITEM_GROUP_WORKSTATIONS = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-workstations");
    public static final NamespacedKey ITEM_GROUP_MATERIALS = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-materials");
    public static final NamespacedKey ITEM_GROUP_MOLTEN = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-molten");
    public static final NamespacedKey ITEM_GROUP_ALLOYS = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-alloys");
    public static final NamespacedKey ITEM_GROUP_PROPERTIES = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-properties");
    public static final NamespacedKey ITEM_GROUP_CASTS = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-casts");
    public static final NamespacedKey ITEM_GROUP_PARTS = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-parts");
    public static final NamespacedKey ITEM_GROUP_PART_DICT = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-part-dict");
    public static final NamespacedKey ITEM_GROUP_TOOLS = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-tools");
    public static final NamespacedKey ITEM_GROUP_ARMOUR = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-armour");
    public static final NamespacedKey ITEM_GROUP_MODIFICATIONS = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-modifications");
    public static final NamespacedKey ITEM_GROUP_DUMMY = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-dummy");

    // Parts information
    public static final NamespacedKey PART_MATERIAL = new NamespacedKey(SlimeTinker.inst(), "ST_Material");
    public static final NamespacedKey PART_CLASS = new NamespacedKey(SlimeTinker.inst(), "ST_Class");
    public static final NamespacedKey PART_TYPE = new NamespacedKey(SlimeTinker.inst(), "ST_Type");

    // General Information
    public static final NamespacedKey ST_EXP_CURRENT = new NamespacedKey(SlimeTinker.inst(), "ST_CurrentExp");
    public static final NamespacedKey ST_EXP_REQUIRED = new NamespacedKey(SlimeTinker.inst(), "ST_NextLevelExp");
    public static final NamespacedKey ST_LEVEL = new NamespacedKey(SlimeTinker.inst(), "ST_Level");
    public static final NamespacedKey ST_MOD_SLOTS = new NamespacedKey(SlimeTinker.inst(), "ST_Modifier_Slots");
    public static final NamespacedKey ST_MODS = new NamespacedKey(SlimeTinker.inst(), "ST_Modifier_Map");
    public static final NamespacedKey ST_MOD_LEVEL_REDSTONE = new NamespacedKey(SlimeTinker.inst(), "ST_mod_level_redstone");
    public static final NamespacedKey ST_MOD_LEVEL_LAPIS = new NamespacedKey(SlimeTinker.inst(), "ST_mod_level_lapis");
    public static final NamespacedKey ST_MOD_LEVEL_QUARTZ = new NamespacedKey(SlimeTinker.inst(), "ST_mod_level_quartz");
    public static final NamespacedKey ST_MOD_LEVEL_DIAMOND = new NamespacedKey(SlimeTinker.inst(), "ST_mod_level_diamond");
    public static final NamespacedKey ST_MOD_LEVEL_EMERALD = new NamespacedKey(SlimeTinker.inst(), "ST_mod_level_emerald");
    public static final NamespacedKey ST_MOD_LEVEL_OBSIDIAN = new NamespacedKey(SlimeTinker.inst(), "ST_mod_level_obsidian");

    // Tool information
    public static final NamespacedKey TOOL_INFO_IS_TOOL = new NamespacedKey(SlimeTinker.inst(), "ST_Tool");
    public static final NamespacedKey TOOL_INFO_HEAD_TYPE = new NamespacedKey(SlimeTinker.inst(), "ST_Type_Head");
    public static final NamespacedKey TOOL_INFO_TOOL_TYPE = new NamespacedKey(SlimeTinker.inst(), "ST_Tool_Type");
    public static final NamespacedKey TOOL_INFO_HEAD_MATERIAL = new NamespacedKey(SlimeTinker.inst(), "ST_Material_Head");
    public static final NamespacedKey TOOL_INFO_BINDER_MATERIAL = new NamespacedKey(SlimeTinker.inst(), "ST_Material_Binder");
    public static final NamespacedKey TOOL_INFO_ROD_MATERIAL = new NamespacedKey(SlimeTinker.inst(), "ST_Material_Rod");

    // Armour information
    public static final NamespacedKey ARMOUR_INFO_IS_ARMOUR = new NamespacedKey(SlimeTinker.inst(), "ST_Armour");
    public static final NamespacedKey ARMOUR_INFO_PLATE_TYPE = new NamespacedKey(SlimeTinker.inst(), "ST_Type_Plate");
    public static final NamespacedKey ARMOUR_INFO_ARMOUR_TYPE = new NamespacedKey(SlimeTinker.inst(), "ST_Armour_Type");
    public static final NamespacedKey ARMOUR_INFO_PLATE_MATERIAL = new NamespacedKey(SlimeTinker.inst(), "ST_Material_Plate");
    public static final NamespacedKey ARMOUR_INFO_LINKS_MATERIAL = new NamespacedKey(SlimeTinker.inst(), "ST_Material_Links");
    public static final NamespacedKey ARMOUR_INFO_GAMBESON_MATERIAL = new NamespacedKey(SlimeTinker.inst(), "ST_Material_Gambeson");

    // Trait Keys
    public static final NamespacedKey TRAITS_COOLDOWN_NO_CLIP = new NamespacedKey(SlimeTinker.inst(), "ST_cd_noclip");
    public static final NamespacedKey TRAITS_COOLDOWN_HYPERCUBE = new NamespacedKey(SlimeTinker.inst(), "ST_cd_hypercube");
    public static final NamespacedKey TRAITS_HYPERCUBE_LOCATION = new NamespacedKey(SlimeTinker.inst(), "ST_loc_hypercube");
    public static final NamespacedKey TRAITS_COOLDOWN_PROTECTIVE = new NamespacedKey(SlimeTinker.inst(), "ST_cd_protective");
    public static final NamespacedKey TRAITS_COOLDOWN_WARP = new NamespacedKey(SlimeTinker.inst(), "ST_cd_warp");
    public static final NamespacedKey TOOL_FLAG_TELEPORT = new NamespacedKey(SlimeTinker.inst(), "ST_stop_teleport");
    public static final NamespacedKey ARMOUR_INFINITE_CAPACITY_STORED = new NamespacedKey(SlimeTinker.inst(), "ST_infinite_cap_stored");
    public static final NamespacedKey ARMOUR_INFINITLY_POWERFUL_STORED = new NamespacedKey(SlimeTinker.inst(), "ST_infinite_pow_stored");
    public static final NamespacedKey ARMOUR_HYPERBOLIC_STORED = new NamespacedKey(SlimeTinker.inst(), "ST_hyperbolic_stored");
    public static final NamespacedKey ARMOUR_UNCONVENTIONAL_STORED = new NamespacedKey(SlimeTinker.inst(), "ST_unconventional_stored");
    public static final NamespacedKey ARMOUR_SOULS_STORED = new NamespacedKey(SlimeTinker.inst(), "ST_souls_stored");
    public static final NamespacedKey ARMOUR_HAPPY_PIGLIN = new NamespacedKey(SlimeTinker.inst(), "ST_happy_piglin");
    public static final NamespacedKey STOP_EVENTS = new NamespacedKey(SlimeTinker.inst(), "STOP_EVENTS");

    // Workstations
    public static final NamespacedKey WS_DUMMY_SMELTERY = new NamespacedKey(SlimeTinker.inst(), "dummy-smeltery");
    public static final NamespacedKey WS_DUMMY_SMELTERY_M = new NamespacedKey(SlimeTinker.inst(), "dummy-smeltery-molten");
    public static final NamespacedKey WS_DUMMY_SMELTERY_A = new NamespacedKey(SlimeTinker.inst(), "dummy-smeltery-alloy");
    public static final NamespacedKey WS_DUMMY_TOOL_TABLE = new NamespacedKey(SlimeTinker.inst(), "dummy-table");
    public static final NamespacedKey WS_DUMMY_ARMOUR_TABLE = new NamespacedKey(SlimeTinker.inst(), "dummy-table");
    public static final NamespacedKey WS_DUMMY_WORKBENCH = new NamespacedKey(SlimeTinker.inst(), "dummy-workbench");
}
