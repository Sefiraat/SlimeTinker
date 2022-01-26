package io.github.sefiraat.slimetinker.items.tinkermaterials.setup;

import io.github.sefiraat.slimetinker.events.BlockBreakEvents;
import io.github.sefiraat.slimetinker.events.DurabilityEvents;
import io.github.sefiraat.slimetinker.events.EntityDamageEvents;
import io.github.sefiraat.slimetinker.events.PlayerDamagedEvents;
import io.github.sefiraat.slimetinker.events.TickEvents;
import io.github.sefiraat.slimetinker.events.friend.TraitEventType;
import io.github.sefiraat.slimetinker.events.friend.TraitPartType;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.tinkermaterials.TinkerMaterial;
import io.github.sefiraat.slimetinker.utils.Ids;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("SpellCheckingInspection")
public final class TinkersMaterialsSlimefunWarfare {

    private TinkersMaterialsSlimefunWarfare() {
        throw new UnsupportedOperationException("Utility Class");
    }

    private static final Map<String, TinkerMaterial> CM_MAP = new HashMap<>();

    private static final TinkerMaterial SEGGANESSON = new TinkerMaterial(Ids.SEGGANESSON, SlimefunItem.getById("SEGGANESSON").getItem(), "#4bacbf")
        .setLiquidTexture(SkullTextures.ALLOY_BLUE_PALE)
        .setTraitToolHead(Traits.SFW_SEGGANESSON_HEAD)
        .setTraitToolRod(Traits.SFW_SEGGANESSON_ROD)
        .setTraitArmorPlates(Traits.SFW_SEGGANESSON_PLATES)
        .setTraitArmorLinks(Traits.SFW_SEGGANESSON_LINKS)
        .setFormIngot("SEGGANESSON")
        .build();

    private static final TinkerMaterial SLIMESTEEL = new TinkerMaterial(Ids.SLIMESTEEL, SlimefunItem.getById("SLIMESTEEL_INGOT").getItem(), "#aed197")
        .setLiquidTexture(SkullTextures.ALLOY_GREEN)
        .setTraitToolBinder(Traits.SFW_SLIMESTEEL_BINDING)
        .setTraitArmorGambeson(Traits.SFW_SLIMESTEEL_GAMBESON)
        .setFormNugget(Materials.NUGGET_CAST_SLIMESTEEL.getItemId())
        .setFormIngot("SLIMESTEEL_INGOT")
        .setFormBlock(Materials.BLOCK_CAST_SLIMESTEEL.getItemId())
        .addAlloyRecipe(
            TinkersMaterialsCore.getCmMap().get(Ids.STEEL).getLiquidItemStack(1),
            TinkersMaterialsCore.getCmMap().get(Ids.SLIME).getLiquidItemStack(1)
        )
        .build();

    private static final TinkerMaterial REINFORCED_SLIMESTEEL = new TinkerMaterial(Ids.REINFORCED_SLIMESTEEL, SlimefunItem.getById("REINFORCED_SLIMESTEEL_INGOT").getItem(), "#aed197")
        .setLiquidTexture(SkullTextures.ALLOY_GREEN)
        .setTraitToolHead(Traits.SFW_REINFORCED_SLIMESTEEL_HEAD)
        .setTraitToolRod(Traits.SFW_REINFORCED_SLIMESTEEL_ROD)
        .setTraitArmorPlates(Traits.SFW_REINFORCED_SLIMESTEEL_PLATES)
        .setTraitArmorLinks(Traits.SFW_REINFORCED_SLIMESTEEL_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_REINFORCED_SLIMESTEEL.getItemId())
        .setFormIngot("REINFORCED_SLIMESTEEL_INGOT")
        .setFormBlock(Materials.BLOCK_CAST_REINFORCED_SLIMESTEEL.getItemId())
        .addAlloyRecipe(
            SLIMESTEEL.getLiquidItemStack(1),
            TinkersMaterialsCore.getCmMap().get(Ids.SLIME).getLiquidItemStack(9),
            TinkersMaterialsCore.getCmMap().get(Ids.DAMASCUS_STEEL).getLiquidItemStack(1),
            TinkersMaterialsCore.getCmMap().get(Ids.HARDENED_METAL).getLiquidItemStack(1),
            TinkersMaterialsCore.getCmMap().get(Ids.CORINTHIAN_BRONZE).getLiquidItemStack(1),
            TinkersMaterialsCore.getCmMap().get(Ids.ALUMINUM_BRONZE).getLiquidItemStack(1)
        )
        .build();

    private static final TinkerMaterial OSMIUM = new TinkerMaterial(Ids.OSMIUM, SlimefunItem.getById("OSMIUM_INGOT").getItem(), "#8dd6c0")
        .setLiquidTexture(SkullTextures.ALLOY_BLUE_PALE)
        .setTraitToolHead(Traits.SFW_OSMIUM_HEAD)
        .setTraitToolRod(Traits.SFW_OSMIUM_ROD)
        .setTraitArmorPlates(Traits.SFW_OSMIUM_PLATES)
        .setTraitArmorLinks(Traits.SFW_OSMIUM_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_OSMIUM.getItemId())
        .setFormIngot("OSMIUM_INGOT")
        .setFormBlock(Materials.BLOCK_CAST_OSMIUM.getItemId())
        .build();

    private static final TinkerMaterial OSMIUM_SUPERALLOY = new TinkerMaterial(Ids.OSMIUM_SUPERALLOY, SlimefunItem.getById("OSMIUM_SUPERALLOY").getItem(), "#8dd6c0")
        .setLiquidTexture(SkullTextures.ALLOY_BLUE_PALE)
        .setTraitToolHead(Traits.SFW_OSMIUM_SUPERALLOY_HEAD)
        .setTraitToolRod(Traits.SFW_OSMIUM_SUPERALLOY_ROD)
        .setTraitArmorPlates(Traits.SFW_OSMIUM_SUPERALLOY_PLATES)
        .setTraitArmorLinks(Traits.SFW_OSMIUM_SUPERALLOY_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_OSMIUM_SUPER_ALLOY.getItemId())
        .setFormIngot("OSMIUM_SUPERALLOY")
        .setFormBlock(Materials.BLOCK_CAST_OSMIUM_SUPER_ALLOY.getItemId())
        .build();

    private static final TinkerMaterial UNPATENTABLIUM = new TinkerMaterial(Ids.UNPATENTABLIUM, SlimefunItem.getById("UNPATENTABLIUM").getItem(), "#8dd6c0")
        .setLiquidTexture(SkullTextures.ALLOY_BLUE_PALE)
        .setTraitToolHead(Traits.SFW_UNPATENTABLIUM_HEAD)
        .setTraitToolRod(Traits.SFW_UNPATENTABLIUM_ROD)
        .setTraitArmorPlates(Traits.SFW_UNPATENTABLIUM_PLATES)
        .setTraitArmorLinks(Traits.SFW_UNPATENTABLIUM_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_UNPATENTABILUM.getItemId())
        .setFormIngot("UNPATENTABLIUM")
        .setFormBlock(Materials.BLOCK_CAST_UNPATENTABILUM.getItemId())
        .build();

    static {
        CM_MAP.put(Ids.SEGGANESSON, SEGGANESSON);
        CM_MAP.put(Ids.SLIMESTEEL, SLIMESTEEL);
        CM_MAP.put(Ids.REINFORCED_SLIMESTEEL, REINFORCED_SLIMESTEEL);
        CM_MAP.put(Ids.OSMIUM, OSMIUM);
        CM_MAP.put(Ids.OSMIUM_SUPERALLOY, OSMIUM_SUPERALLOY);
        CM_MAP.put(Ids.UNPATENTABLIUM, UNPATENTABLIUM);
    }

    public static Map<String, TinkerMaterial> getCmMap() {
        return CM_MAP;
    }
}
