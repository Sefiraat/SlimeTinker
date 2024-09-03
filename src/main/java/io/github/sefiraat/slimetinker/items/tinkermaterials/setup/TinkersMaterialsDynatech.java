package io.github.sefiraat.slimetinker.items.tinkermaterials.setup;

import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.tinkermaterials.TinkerMaterial;
import io.github.sefiraat.slimetinker.utils.Ids;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("SpellCheckingInspection")
public final class TinkersMaterialsDynatech {

    private TinkersMaterialsDynatech() {
        throw new UnsupportedOperationException("Utility Class");
    }

    private static final Map<String, TinkerMaterial> CM_MAP = new HashMap<>();

    private static final TinkerMaterial STAINLESS_STEEL = new TinkerMaterial(Ids.STAINLESS_STEEL, SlimefunItem.getById("DYNATECH_STAINLESS_STEEL_INGOT").getItem(), "#d1d1d1")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.DYN_STAINLESS_STEEL_HEAD)
        .setTraitToolRod(Traits.DYN_STAINLESS_STEEL_ROD)
        .setTraitArmorPlates(Traits.DYN_STAINLESS_STEEL_PLATES)
        .setTraitArmorLinks(Traits.DYN_STAINLESS_STEEL_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_STAINLESSSTEEL.getItemId())
        .setFormIngot("DYNATECH_STAINLESS_STEEL_INGOT")
        .setFormBlock(Materials.BLOCK_CAST_STAINLESSSTEEL.getItemId())
        .addAlloyRecipe(
            TinkersMaterialsCore.getCmMap().get(Ids.IRON).getLiquidItemStack(2),
            TinkersMaterialsCore.getCmMap().get(Ids.ZINC).getLiquidItemStack(1)
        )
        .build();

    private static final TinkerMaterial VEX_GEM = new TinkerMaterial(Ids.VEX_GEM, SlimefunItem.getById("DYNATECH_VEX_GEM").getItem(), "#38c0c2")
        .setLiquidTexture(SkullTextures.ALLOY_BLUE_PALE)
        .setTraitToolBinder(Traits.DYN_VEX_GEM_BINDING)
        .setTraitArmorGambeson(Traits.DYN_VEX_GEM_GAMBESON)
        .setFormGem("DYNATECH_VEX_GEM")
        .build();

    private static final TinkerMaterial STARDUST = new TinkerMaterial(Ids.STARDUST, SlimefunItem.getById("DYNATECH_STAR_DUST").getItem(), "#fdff96")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.DYN_STAR_DUST_HEAD)
        .setTraitToolRod(Traits.DYN_STAR_DUST_ROD)
        .setTraitArmorPlates(Traits.DYN_STAR_DUST_PLATES)
        .setTraitArmorLinks(Traits.DYN_STAR_DUST_LINKS)
        .setFormGem("DYNATECH_STAR_DUST")
        .build();

    private static final TinkerMaterial GHOSTLY_ESSENCE = new TinkerMaterial(Ids.GHOSTLY_ESSENCE, SlimefunItem.getById("DYNATECH_GHOSTLY_ESSENCE").getItem(), "#d4ffef")
        .setLiquidTexture(SkullTextures.ALLOY_BROWN)
        .setTraitToolBinder(Traits.DYN_GHOSTLY_ESSENCE_BINDING)
        .setTraitToolRod(Traits.DYN_GHOSTLY_ESSENCE_ROD)
        .setTraitArmorGambeson(Traits.DYN_GHOSTLY_ESSENCE_GAMBESON)
        .setTraitArmorLinks(Traits.DYN_GHOSTLY_ESSENCE_LINKS)
        .setFormDust("DYNATECH_GHOSTLY_ESSENCE")
        .build();

    private static final TinkerMaterial TESSERACT = new TinkerMaterial(Ids.TESSERACT, SlimefunItem.getById("DYNATECH_TESSERACTING_OBJECT").getItem(), "#c7ba9f")
        .setLiquidTexture(SkullTextures.ALLOY_TAN)
        .setTraitToolHead(Traits.DYN_TESSERACT_HEAD)
        .setTraitArmorPlates(Traits.DYN_TESSERACT_PLATES)
        .setTraitArmorLinks(Traits.DYN_TESSERACT_LINKS)
        .setFormBlock("DYNATECH_TESSERACTING_OBJECT")
        .build();

    static {
        CM_MAP.put(Ids.STAINLESS_STEEL, STAINLESS_STEEL);
        CM_MAP.put(Ids.VEX_GEM, VEX_GEM);
        CM_MAP.put(Ids.STARDUST, STARDUST);
        CM_MAP.put(Ids.GHOSTLY_ESSENCE, GHOSTLY_ESSENCE);
        CM_MAP.put(Ids.TESSERACT, TESSERACT);
    }

    public static Map<String, TinkerMaterial> getCmMap() {
        return CM_MAP;
    }
}
