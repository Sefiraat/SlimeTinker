package io.github.sefiraat.slimetinker.utils;

import io.github.sefiraat.slimetinker.SlimeTinker;
import lombok.Data;
import org.bukkit.NamespacedKey;

@Data
public class Keys {

    // Categories
    private final NamespacedKey categoryMain = new NamespacedKey(SlimeTinker.inst(), "slime-tinker");
    private final NamespacedKey categoryWorkstations = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-workstations");
    private final NamespacedKey categoryMaterials = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-materials");
    private final NamespacedKey categoryMolten = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-molten");
    private final NamespacedKey categoryAlloys = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-alloys");
    private final NamespacedKey categoryProperties = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-properties");
    private final NamespacedKey categoryCasts = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-casts");
    private final NamespacedKey categoryParts = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-parts");
    private final NamespacedKey categoryPartDict = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-part-dict");
    private final NamespacedKey categoryTools = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-tools");
    private final NamespacedKey categoryArmour = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-armour");
    private final NamespacedKey categoryModifications = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-modifications");
    private final NamespacedKey categoryDummy = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-dummy");

    // Parts information
    private final NamespacedKey partInfoMaterialType = new NamespacedKey(SlimeTinker.inst(), "ST_Material");
    private final NamespacedKey partInfoClassType = new NamespacedKey(SlimeTinker.inst(), "ST_Class");
    private final NamespacedKey partInfoType = new NamespacedKey(SlimeTinker.inst(), "ST_Type");

    // General Information
    private final NamespacedKey stExpCurrent = new NamespacedKey(SlimeTinker.inst(), "ST_CurrentExp");
    private final NamespacedKey stExpRequired = new NamespacedKey(SlimeTinker.inst(), "ST_NextLevelExp");
    private final NamespacedKey stLevel = new NamespacedKey(SlimeTinker.inst(), "ST_Level");
    private final NamespacedKey stModSlots = new NamespacedKey(SlimeTinker.inst(), "ST_Modifier_Slots");
    private final NamespacedKey stMods = new NamespacedKey(SlimeTinker.inst(), "ST_Modifier_Map");
    private final NamespacedKey stModLevelRedstone = new NamespacedKey(SlimeTinker.inst(), "ST_mod_level_redstone");
    private final NamespacedKey stModLevelLapis = new NamespacedKey(SlimeTinker.inst(), "ST_mod_level_lapis");
    private final NamespacedKey stModLevelQuartz = new NamespacedKey(SlimeTinker.inst(), "ST_mod_level_quartz");
    private final NamespacedKey stModLevelDiamond = new NamespacedKey(SlimeTinker.inst(), "ST_mod_level_diamond");
    private final NamespacedKey stModLevelEmerald = new NamespacedKey(SlimeTinker.inst(), "ST_mod_level_emerald");
    private final NamespacedKey stModLevelObsidian = new NamespacedKey(SlimeTinker.inst(), "ST_mod_level_obsidian");

    // Tool information
    private final NamespacedKey toolInfoIsTool = new NamespacedKey(SlimeTinker.inst(), "ST_Tool");
    private final NamespacedKey toolInfoHeadType = new NamespacedKey(SlimeTinker.inst(), "ST_Type_Head");
    private final NamespacedKey toolInfoToolType = new NamespacedKey(SlimeTinker.inst(), "ST_Tool_Type");
    private final NamespacedKey toolInfoHeadMaterial = new NamespacedKey(SlimeTinker.inst(), "ST_Material_Head");
    private final NamespacedKey toolInfoBinderMaterial = new NamespacedKey(SlimeTinker.inst(), "ST_Material_Binder");
    private final NamespacedKey toolInfoRodMaterial = new NamespacedKey(SlimeTinker.inst(), "ST_Material_Rod");

    // Armour information
    private final NamespacedKey armourInfoIsArmour = new NamespacedKey(SlimeTinker.inst(), "ST_Armour");
    private final NamespacedKey armourInfoPlateType = new NamespacedKey(SlimeTinker.inst(), "ST_Type_Plate");
    private final NamespacedKey armourInfoArmourType = new NamespacedKey(SlimeTinker.inst(), "ST_Armour_Type");
    private final NamespacedKey armourInfoPlateMaterial = new NamespacedKey(SlimeTinker.inst(), "ST_Material_Plate");
    private final NamespacedKey armourInfoLinksMaterial = new NamespacedKey(SlimeTinker.inst(), "ST_Material_Links");
    private final NamespacedKey armourInfoGambesonMaterial = new NamespacedKey(SlimeTinker.inst(), "ST_Material_Gambeson");

    // Trait Keys
    private final NamespacedKey traitsCooldownNoClip = new NamespacedKey(SlimeTinker.inst(), "ST_cd_noclip");
    private final NamespacedKey traitsCooldownHypercube = new NamespacedKey(SlimeTinker.inst(), "ST_cd_hypercube");
    private final NamespacedKey traitsHypercubeLocation = new NamespacedKey(SlimeTinker.inst(), "ST_loc_hypercube");
    private final NamespacedKey traitsCooldownProtective = new NamespacedKey(SlimeTinker.inst(), "ST_cd_protective");
    private final NamespacedKey traitsCooldownWarp = new NamespacedKey(SlimeTinker.inst(), "ST_cd_warp");
    private final NamespacedKey toolFlagTeleport = new NamespacedKey(SlimeTinker.inst(), "ST_stop_teleport");
    private final NamespacedKey armourInfiniteCapacityStored = new NamespacedKey(SlimeTinker.inst(), "ST_infinite_cap_stored");
    private final NamespacedKey armourInfinitlyPowerfulStored = new NamespacedKey(SlimeTinker.inst(), "ST_infinite_pow_stored");
    private final NamespacedKey stopEvents = new NamespacedKey(SlimeTinker.inst(), "STOP_EVENTS");

    // Workstations
    private final NamespacedKey wsDummySmeltery = new NamespacedKey(SlimeTinker.inst(), "dummy-smeltery");
    private final NamespacedKey wsDummySmelteryM = new NamespacedKey(SlimeTinker.inst(), "dummy-smeltery-molten");
    private final NamespacedKey wsDummySmelteryA = new NamespacedKey(SlimeTinker.inst(), "dummy-smeltery-alloy");
    private final NamespacedKey wsDummyToolTable = new NamespacedKey(SlimeTinker.inst(), "dummy-table");
    private final NamespacedKey wsDummyArmourTable = new NamespacedKey(SlimeTinker.inst(), "dummy-table");
    private final NamespacedKey wsDummyWorkbench = new NamespacedKey(SlimeTinker.inst(), "dummy-workbench");

}
