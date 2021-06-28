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
    private final NamespacedKey categoryModifications = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-modifications");
    private final NamespacedKey categoryDummy = new NamespacedKey(SlimeTinker.inst(), "slime-tinker-dummy");

    // Parts information
    private final NamespacedKey partInfoMaterialType = new NamespacedKey(SlimeTinker.inst(), "ST_Material");
    private final NamespacedKey partInfoClassType = new NamespacedKey(SlimeTinker.inst(), "ST_Class");
    private final NamespacedKey partInfoType = new NamespacedKey(SlimeTinker.inst(), "ST_Type");

    // Tool information
    private final NamespacedKey toolInfoIsTool = new NamespacedKey(SlimeTinker.inst(), "ST_Tool");
    private final NamespacedKey toolInfoHeadType = new NamespacedKey(SlimeTinker.inst(), "ST_Type_Head");
    private final NamespacedKey toolInfoToolType = new NamespacedKey(SlimeTinker.inst(), "ST_Tool_Type");
    private final NamespacedKey toolInfoHeadMaterial = new NamespacedKey(SlimeTinker.inst(), "ST_Material_Head");
    private final NamespacedKey toolInfoBinderMaterial = new NamespacedKey(SlimeTinker.inst(), "ST_Material_Binder");
    private final NamespacedKey toolInfoRodMaterial = new NamespacedKey(SlimeTinker.inst(), "ST_Material_Rod");
    private final NamespacedKey toolExpCurrent = new NamespacedKey(SlimeTinker.inst(), "ST_CurrentExp");
    private final NamespacedKey toolExpRequired = new NamespacedKey(SlimeTinker.inst(), "ST_NextLevelExp");
    private final NamespacedKey toolLevel = new NamespacedKey(SlimeTinker.inst(), "ST_Level");
    private final NamespacedKey toolModSlots = new NamespacedKey(SlimeTinker.inst(), "ST_Modifier_Slots");
    private final NamespacedKey toolMods = new NamespacedKey(SlimeTinker.inst(), "ST_Modifier_Map");
    private final NamespacedKey toolModLevelRedstone = new NamespacedKey(SlimeTinker.inst(), "ST_mod_level_redstone");
    private final NamespacedKey toolModLevelLapis = new NamespacedKey(SlimeTinker.inst(), "ST_mod_level_lapis");
    private final NamespacedKey toolModLevelQuartz = new NamespacedKey(SlimeTinker.inst(), "ST_mod_level_quartz");
    private final NamespacedKey toolModLevelDiamond = new NamespacedKey(SlimeTinker.inst(), "ST_mod_level_diamond");
    private final NamespacedKey toolModLevelEmerald = new NamespacedKey(SlimeTinker.inst(), "ST_mod_level_emerald");
    private final NamespacedKey toolModLevelObsidian = new NamespacedKey(SlimeTinker.inst(), "ST_mod_level_obsidian");
    private final NamespacedKey toolCooldownNoClip = new NamespacedKey(SlimeTinker.inst(), "ST_cd_noclip");
    private final NamespacedKey toolCooldownHypercube = new NamespacedKey(SlimeTinker.inst(), "ST_cd_hypercube");
    private final NamespacedKey toolHypercubeLocation = new NamespacedKey(SlimeTinker.inst(), "ST_loc_hypercube");
    private final NamespacedKey toolCooldownProtective = new NamespacedKey(SlimeTinker.inst(), "ST_cd_protective");
    private final NamespacedKey toolCooldownWarp = new NamespacedKey(SlimeTinker.inst(), "ST_cd_warp");

    // Workstations
    private final NamespacedKey wsDummySmeltery = new NamespacedKey(SlimeTinker.inst(), "dummy-smeltery");
    private final NamespacedKey wsDummySmelteryM = new NamespacedKey(SlimeTinker.inst(), "dummy-smeltery-molten");
    private final NamespacedKey wsDummySmelteryA = new NamespacedKey(SlimeTinker.inst(), "dummy-smeltery-alloy");
    private final NamespacedKey wsDummyTable = new NamespacedKey(SlimeTinker.inst(), "dummy-table");
    private final NamespacedKey wsDummyWorkbench = new NamespacedKey(SlimeTinker.inst(), "dummy-workbench");

}
