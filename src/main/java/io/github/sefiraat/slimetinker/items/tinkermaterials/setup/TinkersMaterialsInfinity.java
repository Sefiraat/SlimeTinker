package io.github.sefiraat.slimetinker.items.tinkermaterials.setup;

import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.tinkermaterials.TinkerMaterial;
import io.github.sefiraat.slimetinker.utils.Ids;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("SpellCheckingInspection")
public final class TinkersMaterialsInfinity {

    private TinkersMaterialsInfinity() {
        throw new UnsupportedOperationException("Utility Class");
    }

    private static final Map<String, TinkerMaterial> CM_MAP = new HashMap<>();

    private static final TinkerMaterial VOID = new TinkerMaterial(Ids.VOID, SlimefunItem.getById("VOID_INGOT").getItem(), "#5c5756")
        .setLiquidTexture(SkullTextures.ALLOY_PURPLE_DEEP)
        .setTraitToolHead(Traits.INFINITY_VOID_HEAD)
        .setTraitToolRod(Traits.INFINITY_VOID_ROD)
        .setTraitArmorPlates(Traits.INFINITY_VOID_PLATES)
        .setTraitArmorLinks(Traits.INFINITY_VOID_LINKS)
        .setFormNugget("VOID_DUST")
        .setFormIngot("VOID_INGOT")
        .setFormBlock(Materials.BLOCK_CAST_VOID.getItemId())
        .build();

    private static final TinkerMaterial MAGSTEEL = new TinkerMaterial(Ids.MAGSTEEL, SlimefunItem.getById("MAGSTEEL").getItem(), "#730000")
        .setLiquidTexture(SkullTextures.ALLOY_BROWN)
        .setTraitToolHead(Traits.INFINITY_MAGSTEEL_HEAD)
        .setTraitToolRod(Traits.INFINITY_MAGSTEEL_ROD)
        .setTraitArmorPlates(Traits.INFINITY_MAGSTEEL_PLATES)
        .setTraitArmorLinks(Traits.INFINITY_MAGSTEEL_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_MAGSTEEL.getItemId())
        .setFormIngot("MAGSTEEL")
        .setFormBlock(Materials.BLOCK_CAST_MAGSTEEL.getItemId())
        .addAlloyRecipe(
            TinkersMaterialsCore.getCmMap().get(Ids.MAGNESIUM).getLiquidItemStack(2),
            TinkersMaterialsCore.getCmMap().get(Ids.STEEL).getLiquidItemStack(1)
        )
        .build();

    private static final TinkerMaterial TITANIUM = new TinkerMaterial(Ids.TITANIUM, SlimefunItem.getById("TITANIUM").getItem(), "#adadad")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.INFINITY_TITANIUM_HEAD)
        .setTraitToolRod(Traits.INFINITY_TITANIUM_ROD)
        .setTraitArmorPlates(Traits.INFINITY_TITANIUM_PLATES)
        .setTraitArmorLinks(Traits.INFINITY_TITANIUM_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_TITANIUM.getItemId())
        .setFormIngot("TITANIUM")
        .setFormBlock(Materials.BLOCK_CAST_TITANIUM.getItemId())
        .addAlloyRecipe(
            TinkersMaterialsCore.getCmMap().get(Ids.REINFORCED_ALLOY).getLiquidItemStack(1),
            TinkersMaterialsCore.getCmMap().get(Ids.DAMASCUS_STEEL).getLiquidItemStack(1),
            TinkersMaterialsCore.getCmMap().get(Ids.HARDENED_METAL).getLiquidItemStack(1)
        )
        .build();

    private static final TinkerMaterial IRON_SINGULARITY = new TinkerMaterial(Ids.IRON_SINGULARITY, SlimefunItem.getById("IRON_SINGULARITY").getItem(), "#8c8c8c")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.INFINITY_IRON_SINGULARITY_HEAD)
        .setTraitToolRod(Traits.INFINITY_IRON_SINGULARITY_ROD)
        .setTraitArmorPlates(Traits.INFINITY_IRON_SINGULARITY_PLATES)
        .setTraitArmorLinks(Traits.INFINITY_IRON_SINGULARITY_LINKS)
        .setFormBlock("IRON_SINGULARITY")
        .build();

    private static final TinkerMaterial GOLD_SINGULARITY = new TinkerMaterial(Ids.GOLD_SINGULARITY, SlimefunItem.getById("GOLD_SINGULARITY").getItem(), "#ffe138")
        .setLiquidTexture(SkullTextures.ALLOY_TAN)
        .setTraitToolHead(Traits.INFINITY_GOLD_SINGULARITY_HEAD)
        .setTraitToolRod(Traits.INFINITY_GOLD_SINGULARITY_ROD)
        .setTraitArmorPlates(Traits.INFINITY_GOLD_SINGULARITY_PLATES)
        .setTraitArmorLinks(Traits.INFINITY_GOLD_SINGULARITY_LINKS)
        .setFormBlock("GOLD_SINGULARITY")
        .build();

    private static final TinkerMaterial COPPER_SINGULARITY = new TinkerMaterial(Ids.COPPER_SINGULARITY, SlimefunItem.getById("COPPER_SINGULARITY").getItem(), "#c99732")
        .setLiquidTexture(SkullTextures.ALLOY_BROWN)
        .setTraitToolHead(Traits.INFINITY_COPPER_SINGULARITY_HEAD)
        .setTraitToolRod(Traits.INFINITY_COPPER_SINGULARITY_ROD)
        .setTraitArmorPlates(Traits.INFINITY_COPPER_SINGULARITY_PLATES)
        .setTraitArmorLinks(Traits.INFINITY_COPPER_SINGULARITY_LINKS)
        .setFormBlock("COPPER_SINGULARITY")
        .build();

    private static final TinkerMaterial LEAD_SINGULARITY = new TinkerMaterial(Ids.LEAD_SINGULARITY, SlimefunItem.getById("LEAD_SINGULARITY").getItem(), "#9043ba")
        .setLiquidTexture(SkullTextures.ALLOY_PURPLE)
        .setTraitToolHead(Traits.INFINITY_LEAD_SINGULARITY_HEAD)
        .setTraitToolRod(Traits.INFINITY_LEAD_SINGULARITY_ROD)
        .setTraitArmorPlates(Traits.INFINITY_LEAD_SINGULARITY_PLATES)
        .setTraitArmorLinks(Traits.INFINITY_LEAD_SINGULARITY_LINKS)
        .setFormBlock("LEAD_SINGULARITY")
        .build();

    private static final TinkerMaterial SILVER_SINGULARITY = new TinkerMaterial(Ids.SILVER_SINGULARITY, SlimefunItem.getById("SILVER_SINGULARITY").getItem(), "#d4d4d4")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.INFINITY_SILVER_SINGULARITY_HEAD)
        .setTraitToolRod(Traits.INFINITY_SILVER_SINGULARITY_ROD)
        .setTraitArmorPlates(Traits.INFINITY_SILVER_SINGULARITY_PLATES)
        .setTraitArmorLinks(Traits.INFINITY_SILVER_SINGULARITY_LINKS)
        .setFormBlock("SILVER_SINGULARITY")
        .build();

    private static final TinkerMaterial ALUMINUM_SINGULARITY = new TinkerMaterial(Ids.ALUMINUM_SINGULARITY, SlimefunItem.getById("ALUMINUM_SINGULARITY").getItem(), "#b0b0b0")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.INFINITY_ALUMINUM_SINGULARITY_HEAD)
        .setTraitToolRod(Traits.INFINITY_ALUMINUM_SINGULARITY_ROD)
        .setTraitArmorPlates(Traits.INFINITY_ALUMINUM_SINGULARITY_PLATES)
        .setTraitArmorLinks(Traits.INFINITY_ALUMINUM_SINGULARITY_LINKS)
        .setFormBlock("ALUMINUM_SINGULARITY")
        .build();

    private static final TinkerMaterial TIN_SINGULARITY = new TinkerMaterial(Ids.TIN_SINGULARITY, SlimefunItem.getById("TIN_SINGULARITY").getItem(), "#a89b9b")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.INFINITY_TIN_SINGULARITY_HEAD)
        .setTraitToolRod(Traits.INFINITY_TIN_SINGULARITY_ROD)
        .setTraitArmorPlates(Traits.INFINITY_TIN_SINGULARITY_PLATES)
        .setTraitArmorLinks(Traits.INFINITY_TIN_SINGULARITY_LINKS)
        .setFormBlock("TIN_SINGULARITY")
        .build();

    private static final TinkerMaterial ZINC_SINGULARITY = new TinkerMaterial(Ids.ZINC_SINGULARITY, SlimefunItem.getById("ZINC_SINGULARITY").getItem(), "#9ba8a6")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.INFINITY_ZINC_SINGULARITY_HEAD)
        .setTraitToolRod(Traits.INFINITY_ZINC_SINGULARITY_ROD)
        .setTraitArmorPlates(Traits.INFINITY_ZINC_SINGULARITY_PLATES)
        .setTraitArmorLinks(Traits.INFINITY_ZINC_SINGULARITY_LINKS)
        .setFormBlock("ZINC_SINGULARITY")
        .build();

    private static final TinkerMaterial MAGNESIUM_SINGULARITY = new TinkerMaterial(Ids.MAGNESIUM_SINGULARITY, SlimefunItem.getById("MAGNESIUM_SINGULARITY").getItem(), "#e8cef5")
        .setLiquidTexture(SkullTextures.ALLOY_PINK)
        .setTraitToolHead(Traits.INFINITY_MAGNESIUM_SINGULARITY_HEAD)
        .setTraitToolRod(Traits.INFINITY_MAGNESIUM_SINGULARITY_ROD)
        .setTraitArmorPlates(Traits.INFINITY_MAGNESIUM_SINGULARITY_PLATES)
        .setTraitArmorLinks(Traits.INFINITY_MAGNESIUM_SINGULARITY_LINKS)
        .setFormBlock("MAGNESIUM_SINGULARITY")
        .build();

    private static final TinkerMaterial DIAMOND_SINGULARITY = new TinkerMaterial(Ids.DIAMOND_SINGULARITY, SlimefunItem.getById("DIAMOND_SINGULARITY").getItem(), "#e8cef5")
        .setLiquidTexture(SkullTextures.ALLOY_BLUE)
        .setFormBlock("DIAMOND_SINGULARITY")
        .build();

    private static final TinkerMaterial MYTHRIL = new TinkerMaterial(Ids.MYTHRIL, SlimefunItem.getById("MYTHRIL").getItem(), "#4ebdc7")
        .setLiquidTexture(SkullTextures.ALLOY_BLUE_PALE)
        .setTraitToolHead(Traits.INFINITY_MYTHRIL_HEAD)
        .setTraitToolRod(Traits.INFINITY_MYTHRIL_ROD)
        .setTraitArmorPlates(Traits.INFINITY_MYTHRIL_PLATES)
        .setTraitArmorLinks(Traits.INFINITY_MYTHRIL_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_MYTHRIL.getItemId())
        .setFormIngot("MYTHRIL")
        .setFormBlock(Materials.BLOCK_CAST_MYTHRIL.getItemId())
        .build();

    private static final TinkerMaterial ADAMANTITE = new TinkerMaterial(Ids.ADAMANTITE, SlimefunItem.getById("ADAMANTITE").getItem(), "#c93ec2")
        .setLiquidTexture(SkullTextures.ALLOY_TAN)
        .setTraitToolHead(Traits.INFINITY_ADAMANTITE_HEAD)
        .setTraitToolRod(Traits.INFINITY_ADAMANTITE_ROD)
        .setTraitArmorPlates(Traits.INFINITY_ADAMANTITE_PLATES)
        .setTraitArmorLinks(Traits.INFINITY_ADAMANTITE_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_ADAMANTITE.getItemId())
        .setFormIngot("ADAMANTITE")
        .setFormBlock(Materials.BLOCK_CAST_ADAMANTITE.getItemId())
        .build();

    private static final TinkerMaterial MAGNONIUM = new TinkerMaterial(Ids.MAGNONIUM, SlimefunItem.getById("MAGNONIUM").getItem(), "#4a0446")
        .setLiquidTexture(SkullTextures.ALLOY_PURPLE)
        .setTraitToolHead(Traits.INFINITY_MAGNONIUM_HEAD)
        .setTraitToolRod(Traits.INFINITY_MAGNONIUM_ROD)
        .setTraitArmorPlates(Traits.INFINITY_MAGNONIUM_PLATES)
        .setTraitArmorLinks(Traits.INFINITY_MAGNONIUM_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_MAGNONIUM.getItemId())
        .setFormIngot("MAGNONIUM")
        .setFormBlock(Materials.BLOCK_CAST_MAGNONIUM.getItemId())
        .build();

    private static final TinkerMaterial FORTUNE_SINGULARITY = new TinkerMaterial(Ids.FORTUNE_SINGULARITY, SlimefunItem.getById("FORTUNE_SINGULARITY").getItem(), "#f0d541")
        .setLiquidTexture(SkullTextures.ALLOY_PURPLE)
        .setTraitToolHead(Traits.INFINITY_FORTUNE_SINGULARITY_HEAD)
        .setTraitToolRod(Traits.INFINITY_FORTUNE_SINGULARITY_ROD)
        .setTraitArmorPlates(Traits.INFINITY_FORTUNE_SINGULARITY_PLATES)
        .setTraitArmorLinks(Traits.INFINITY_FORTUNE_SINGULARITY_LINKS)
        .setFormGem("FORTUNE_SINGULARITY")
        .build();

    private static final TinkerMaterial MAGIC_SINGULARITY = new TinkerMaterial(Ids.MAGIC_SINGULARITY, SlimefunItem.getById("MAGIC_SINGULARITY").getItem(), "#c941e8")
        .setLiquidTexture(SkullTextures.ALLOY_BLUE)
        .setTraitToolHead(Traits.INFINITY_MAGIC_SINGULARITY_HEAD)
        .setTraitToolRod(Traits.INFINITY_MAGIC_SINGULARITY_ROD)
        .setTraitArmorPlates(Traits.INFINITY_MAGIC_SINGULARITY_PLATES)
        .setTraitArmorLinks(Traits.INFINITY_MAGIC_SINGULARITY_LINKS)
        .setFormGem("MAGIC_SINGULARITY")
        .build();

    private static final TinkerMaterial EARTH_SINGULARITY = new TinkerMaterial(Ids.EARTH_SINGULARITY, SlimefunItem.getById("EARTH_SINGULARITY").getItem(), "#44e34f")
        .setLiquidTexture(SkullTextures.ALLOY_GREEN)
        .setTraitToolHead(Traits.INFINITY_EARTH_SINGULARITY_HEAD)
        .setTraitToolRod(Traits.INFINITY_EARTH_SINGULARITY_ROD)
        .setTraitArmorPlates(Traits.INFINITY_EARTH_SINGULARITY_PLATES)
        .setTraitArmorLinks(Traits.INFINITY_EARTH_SINGULARITY_LINKS)
        .setFormGem("EARTH_SINGULARITY")
        .build();

    private static final TinkerMaterial METAL_SINGULARITY = new TinkerMaterial(Ids.METAL_SINGULARITY, SlimefunItem.getById("METAL_SINGULARITY").getItem(), "#5b615b")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.INFINITY_METAL_SINGULARITY_HEAD)
        .setTraitToolRod(Traits.INFINITY_METAL_SINGULARITY_ROD)
        .setTraitArmorPlates(Traits.INFINITY_METAL_SINGULARITY_PLATES)
        .setTraitArmorLinks(Traits.INFINITY_METAL_SINGULARITY_LINKS)
        .setFormGem("METAL_SINGULARITY")
        .build();

    private static final TinkerMaterial INFINITY = new TinkerMaterial(Ids.INFINITY, SlimefunItem.getById("INFINITE_INGOT").getItem(), "#d1ebf0")
        .setLiquidTexture(SkullTextures.ALLOY_BLUE_PALE)
        .setTraitToolHead(Traits.INFINITY_INFINITY_HEAD)
        .setTraitToolRod(Traits.INFINITY_INFINITY_ROD)
        .setTraitArmorPlates(Traits.INFINITY_INFINITY_PLATES)
        .setTraitArmorLinks(Traits.INFINITY_INFINITY_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_INFINITY.getItemId())
        .setFormIngot("INFINITE_INGOT")
        .setFormBlock(Materials.BLOCK_CAST_INFINITY.getItemId())
        .build();

    private static final TinkerMaterial INFINITY_SINGULARITY = new TinkerMaterial(Ids.INFINITY_SINGULARITY, SlimefunItem.getById("INFINITY_SINGULARITY").getItem(), "#e8cef5")
        .setLiquidTexture(SkullTextures.ALLOY_BLUE_PALE)
        .setTraitToolHead(Traits.INFINITY_INFINITY_SINGULARITY_HEAD)
        .setTraitArmorPlates(Traits.INFINITY_INFINITY_SINGULARITY_PLATES)
        .setTraitArmorLinks(Traits.INFINITY_INFINITY_SINGULARITY_LINKS)
        .setFormBlock("INFINITY_SINGULARITY")
        .build();

    private static final TinkerMaterial REINFORCED_DRACONIUM = new TinkerMaterial(Ids.REINFORCED_DRACONIUM, Materials.INGOT_CAST_REINFORCED_DRACONIUM, "#9532a8")
        .setLiquidTexture(SkullTextures.ALLOY_PURPLE_DEEP)
        .setTraitToolHead(Traits.INFINITY_REINFORCED_DRACONIUM_HEAD)
        .setFormNugget(Materials.NUGGET_CAST_REINFORCED_DRACONIUM.getItemId())
        .setFormIngot(Materials.INGOT_CAST_REINFORCED_DRACONIUM.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_REINFORCED_DRACONIUM.getItemId())
        .addAlloyRecipe(
            TinkersMaterialsCore.getCmMap().get(Ids.COBALT).getLiquidItemStack(1),
            TinkersMaterialsCore.getCmMap().get(Ids.DRACONIC).getLiquidItemStack(2),
            MYTHRIL.getLiquidItemStack(2)
        )
        .build();

    static {
        CM_MAP.put(Ids.VOID, VOID);
        CM_MAP.put(Ids.MAGSTEEL, MAGSTEEL);
        CM_MAP.put(Ids.TITANIUM, TITANIUM);
        CM_MAP.put(Ids.IRON_SINGULARITY, IRON_SINGULARITY);
        CM_MAP.put(Ids.GOLD_SINGULARITY, GOLD_SINGULARITY);
        CM_MAP.put(Ids.COPPER_SINGULARITY, COPPER_SINGULARITY);
        CM_MAP.put(Ids.LEAD_SINGULARITY, LEAD_SINGULARITY);
        CM_MAP.put(Ids.SILVER_SINGULARITY, SILVER_SINGULARITY);
        CM_MAP.put(Ids.ALUMINUM_SINGULARITY, ALUMINUM_SINGULARITY);
        CM_MAP.put(Ids.TIN_SINGULARITY, TIN_SINGULARITY);
        CM_MAP.put(Ids.ZINC_SINGULARITY, ZINC_SINGULARITY);
        CM_MAP.put(Ids.MAGNESIUM_SINGULARITY, MAGNESIUM_SINGULARITY);
        CM_MAP.put(Ids.DIAMOND_SINGULARITY, DIAMOND_SINGULARITY);
        CM_MAP.put(Ids.MYTHRIL, MYTHRIL);
        CM_MAP.put(Ids.ADAMANTITE, ADAMANTITE);
        CM_MAP.put(Ids.MAGNONIUM, MAGNONIUM);
        CM_MAP.put(Ids.FORTUNE_SINGULARITY, FORTUNE_SINGULARITY);
        CM_MAP.put(Ids.MAGIC_SINGULARITY, MAGIC_SINGULARITY);
        CM_MAP.put(Ids.EARTH_SINGULARITY, EARTH_SINGULARITY);
        CM_MAP.put(Ids.METAL_SINGULARITY, METAL_SINGULARITY);
        CM_MAP.put(Ids.INFINITY, INFINITY);
        CM_MAP.put(Ids.INFINITY_SINGULARITY, INFINITY_SINGULARITY);
        CM_MAP.put(Ids.REINFORCED_DRACONIUM, REINFORCED_DRACONIUM);
    }

    public static Map<String, TinkerMaterial> getCmMap() {
        return CM_MAP;
    }
}
