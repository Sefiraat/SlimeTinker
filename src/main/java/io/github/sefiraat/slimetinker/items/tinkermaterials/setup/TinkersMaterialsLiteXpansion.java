package io.github.sefiraat.slimetinker.items.tinkermaterials.setup;

import io.github.sefiraat.slimetinker.events.BlockBreakEvents;
import io.github.sefiraat.slimetinker.events.DurabilityEvents;
import io.github.sefiraat.slimetinker.events.EntityDamageEvents;
import io.github.sefiraat.slimetinker.events.PlayerDamagedEvents;
import io.github.sefiraat.slimetinker.events.RightClickEvents;
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
public final class TinkersMaterialsLiteXpansion {

    private TinkersMaterialsLiteXpansion() {
        throw new UnsupportedOperationException("Utility Class");
    }

    private static final Map<String, TinkerMaterial> CM_MAP = new HashMap<>();

    private static final TinkerMaterial RUBBER = new TinkerMaterial(Ids.RUBBER, SlimefunItem.getById("RUBBER").getItem(), "#38414d")
        .setTraitToolBinder(Traits.LITE_RUBBER_BINDING)
        .setTraitArmorGambeson(Traits.LITE_RUBBER_GAMBESON)
        .setFormGem("RUBBER")
        .build();

    private static final TinkerMaterial REFINED_IRON = new TinkerMaterial(Ids.RUBBER, SlimefunItem.getById("REFINED_IRON").getItem(), "#ababab")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.LITE_REFINED_IRON_HEAD)
        .setTraitToolRod(Traits.LITE_REFINED_IRON_ROD)
        .setTraitArmorPlates(Traits.LITE_REFINED_IRON_PLATES)
        .setTraitArmorLinks(Traits.LITE_REFINED_IRON_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_REFINED_IRON.getItemId())
        .setFormIngot("REFINED_IRON")
        .setFormBlock(Materials.BLOCK_CAST_REFINED_IRON.getItemId())
        .build();

    private static final TinkerMaterial MIXED_METAL = new TinkerMaterial(Ids.MIXED_METAL, SlimefunItem.getById("MIXED_METAL_INGOT").getItem(), "#6e7a66")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.LITE_MIXED_METAL_HEAD)
        .setTraitToolRod(Traits.LITE_MIXED_METAL_ROD)
        .setTraitArmorPlates(Traits.LITE_MIXED_METAL_PLATES)
        .setTraitArmorLinks(Traits.LITE_MIXED_METAL_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_MIXED_METAL.getItemId())
        .setFormIngot("MIXED_METAL_INGOT")
        .setFormBlock(Materials.BLOCK_CAST_MIXED_METAL.getItemId())
        .addAlloyRecipe(
            REFINED_IRON.getLiquidItemStack(3),
            TinkersMaterialsCore.getCmMap().get(Ids.BRONZE).getLiquidItemStack(3),
            TinkersMaterialsCore.getCmMap().get(Ids.TIN).getLiquidItemStack(3)
        )
        .build();

    private static final TinkerMaterial ADVANCED_ALLOY = new TinkerMaterial(Ids.ADVANCED_ALLOY, SlimefunItem.getById("ADVANCED_ALLOY").getItem(), "#78aba2")
        .setLiquidTexture(SkullTextures.ALLOY_BLUE_PALE)
        .setTraitToolHead(Traits.LITE_ADVANCED_ALLOY_HEAD)
        .setTraitToolRod(Traits.LITE_ADVANCED_ALLOY_ROD)
        .setTraitArmorPlates(Traits.LITE_ADVANCED_ALLOY_PLATES)
        .setTraitArmorLinks(Traits.LITE_ADVANCED_ALLOY_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_ADVANCED_ALLOY.getItemId())
        .setFormIngot("ADVANCED_ALLOY")
        .setFormBlock(Materials.BLOCK_CAST_ADVANCED_ALLOY.getItemId())
        .build();

    private static final TinkerMaterial THORIUM = new TinkerMaterial(Ids.THORIUM, SlimefunItem.getById("THORIUM").getItem(), "#33de4d")
        .setLiquidTexture(SkullTextures.ALLOY_GREEN)
        .setFormGem("THORIUM")
        .build();

    private static final TinkerMaterial MAG_THOR = new TinkerMaterial(Ids.MAG_THOR, SlimefunItem.getById("MAG_THOR").getItem(), "#33de4d")
        .setLiquidTexture(SkullTextures.ALLOY_BLUE_PALE)
        .setTraitToolHead(Traits.LITE_MAG_THOR_HEAD)
        .setTraitToolRod(Traits.LITE_MAG_THOR_ROD)
        .setTraitArmorPlates(Traits.LITE_MAG_THOR_PLATES)
        .setTraitArmorLinks(Traits.LITE_MAG_THOR_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_MAG_THOR.getItemId())
        .setFormIngot("MAG_THOR")
        .setFormBlock(Materials.BLOCK_CAST_MAG_THOR.getItemId())
        .addAlloyRecipe(
            TinkersMaterialsCore.getCmMap().get(Ids.REINFORCED_ALLOY).getLiquidItemStack(1),
            THORIUM.getLiquidItemStack(1),
            TinkersMaterialsCore.getCmMap().get(Ids.MAGNESIUM).getLiquidItemStack(1),
            TinkersMaterialsCore.getCmMap().get(Ids.ZINC).getLiquidItemStack(1)
        )
        .build();

    private static final TinkerMaterial CARBON_MESH = new TinkerMaterial(Ids.THORIUM, SlimefunItem.getById("RAW_CARBON_MESH").getItem(), "#192927")
        .setTraitToolBinder(Traits.LITE_CARBON_MESH_BINDING)
        .setTraitArmorGambeson(Traits.LITE_CARBON_MESH_GAMBESON)
        .build();

    private static final TinkerMaterial SCRAP = new TinkerMaterial(Ids.SCRAP, SlimefunItem.getById("SCRAP").getItem(), "#5c451d")
        .setLiquidTexture(SkullTextures.ALLOY_BROWN)
        .setTraitToolHead(Traits.LITE_SCRAP_HEAD)
        .setTraitToolRod(Traits.LITE_SCRAP_ROD)
        .setTraitArmorPlates(Traits.LITE_SCRAP_PLATES)
        .setTraitArmorLinks(Traits.LITE_SCRAP_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_SCRAP.getItemId())
        .setFormIngot("SCRAP")
        .setFormBlock(Materials.BLOCK_CAST_SCRAP.getItemId())
        .build();

    private static final TinkerMaterial IRIDIUM = new TinkerMaterial(Ids.IRIDIUM, SlimefunItem.getById("IRIDIUM").getItem(), "#c999c9")
        .setLiquidTexture(SkullTextures.ALLOY_PINK)
        .setTraitToolHead(Traits.LITE_IRIDIUM_HEAD)
        .setTraitToolRod(Traits.LITE_IRIDIUM_ROD)
        .setTraitArmorPlates(Traits.LITE_IRIDIUM_PLATES)
        .setTraitArmorLinks(Traits.LITE_IRIDIUM_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_IRIDIUM.getItemId())
        .setFormIngot("IRIDIUM")
        .setFormBlock(Materials.BLOCK_CAST_IRIDIUM.getItemId())
        .build();

    static {
        CM_MAP.put(Ids.RUBBER, RUBBER);
        CM_MAP.put(Ids.REFINED_IRON, REFINED_IRON);
        CM_MAP.put(Ids.MIXED_METAL, MIXED_METAL);
        CM_MAP.put(Ids.ADVANCED_ALLOY, ADVANCED_ALLOY);
        CM_MAP.put(Ids.THORIUM, THORIUM);
        CM_MAP.put(Ids.MAG_THOR, MAG_THOR);
        CM_MAP.put(Ids.CARBON_MESH, CARBON_MESH);
        CM_MAP.put(Ids.SCRAP, SCRAP);
        CM_MAP.put(Ids.IRIDIUM, IRIDIUM);

        setupToolConsumers();
        setupArmourConsumers();
    }

    public static void setupToolConsumers() {

        CM_MAP.get(Ids.SCRAP).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::headCopper);                            // Brains not brawn - Damage             |
        CM_MAP.get(Ids.SCRAP).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.ROD, BlockBreakEvents::headCopper);                                 // Brains not brawn - Block Break        | - CO Copper Head
        CM_MAP.get(Ids.ADVANCED_ALLOY).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headAdvancedAlloy);           // Cleave
        CM_MAP.get(Ids.MAG_THOR).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.HEAD, PlayerDamagedEvents::headMagThor);                      // Heat Resistance
        CM_MAP.get(Ids.ADVANCED_ALLOY).addEvent(TraitEventType.DURABILITY, TraitPartType.ROD, DurabilityEvents::rodAdvancedAlloy);                   // Heavy Duty
        CM_MAP.get(Ids.RUBBER).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.BINDER, PlayerDamagedEvents::bindRubber);                       // Insulated
        CM_MAP.get(Ids.REFINED_IRON).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodRefinedIron);                 // Manners Maketh Man - Damage
        CM_MAP.get(Ids.REFINED_IRON).addEvent(TraitEventType.RIGHT_CLICK, TraitPartType.ROD, RightClickEvents::rodRefinedIron);                      // Manners Maketh Man - Right Click (Register Manners)
        CM_MAP.get(Ids.REFINED_IRON).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodRefinedIron);                                   // Manners Maketh Man - Tick
        CM_MAP.get(Ids.MIXED_METAL).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headMixedMetal);                                   // Mixed Metals
        CM_MAP.get(Ids.CARBON_MESH).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.BINDER, PlayerDamagedEvents::bindCarbonMesh);              // Nimble - Player Damage
        CM_MAP.get(Ids.CARBON_MESH).addEvent(TraitEventType.TICK, TraitPartType.BINDER, TickEvents::bindCarbonMesh);                                 // Nimble - Tick
        CM_MAP.get(Ids.IRIDIUM).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.HEAD, PlayerDamagedEvents::headIridium);                       // Protective
        CM_MAP.get(Ids.REFINED_IRON).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headRefinedIron);               // Really Stable
        CM_MAP.get(Ids.MIXED_METAL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::headBrass);                       // Stiff - Damage                        |
        CM_MAP.get(Ids.MIXED_METAL).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::headBrass);                                         // Stiff - Tick                          | - CO Brass Head
        CM_MAP.get(Ids.SCRAP).addEvent(TraitEventType.DURABILITY, TraitPartType.HEAD, DurabilityEvents::headScrap);                                  // Terrible - Durability
        CM_MAP.get(Ids.SCRAP).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headScrap);                            // Terrible - Damage
        CM_MAP.get(Ids.SCRAP).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headScrap);                                 // Terrible - Block Break
        CM_MAP.get(Ids.MAG_THOR).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::headDamsteel);                       // Vampirism                             | - CO DamSteel Head
        CM_MAP.get(Ids.IRIDIUM).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodIridium);                          // Warp

    }

    public static void setupArmourConsumers() {

        CM_MAP.get(Ids.MAG_THOR).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksMagThor);                    // Building Rage
        CM_MAP.get(Ids.CARBON_MESH).addEvent(TraitEventType.TICK, TraitPartType.GAMBESON, TickEvents::gambesonCarbonMesh);                           // Carbon Fibre
        // Event More Advanced (mod affector)
        CM_MAP.get(Ids.MIXED_METAL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.PLATE, EntityDamageEvents::linksAdamantite);               // Experienced (CO) - Kill
        CM_MAP.get(Ids.MIXED_METAL).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.PLATE, BlockBreakEvents::linksAdamantite);                    // Experienced (CO) - Block Break
        CM_MAP.get(Ids.SCRAP).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.LINKS, EntityDamageEvents::linksScrap);                          // Falling Apart - Exp
        CM_MAP.get(Ids.SCRAP).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksScrap);                         // Falling Apart - Drop
        CM_MAP.get(Ids.IRIDIUM).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateIridium);                     // Indomitable
        CM_MAP.get(Ids.REFINED_IRON).addEvent(TraitEventType.RIGHT_CLICK, TraitPartType.PLATE, RightClickEvents::plateRefinedIron);                  // Kingsman
        CM_MAP.get(Ids.MIXED_METAL).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksMixedMetal);              // Mix it Up
        CM_MAP.get(Ids.REFINED_IRON).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksRefinedIron);            // Narrowing
        CM_MAP.get(Ids.SCRAP).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateScrap);                         // Pathetic - Death
        CM_MAP.get(Ids.SCRAP).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.PLATE, EntityDamageEvents::plateScrap);                          // Pathetic - Exp
        CM_MAP.get(Ids.MAG_THOR).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateMagThor);                    // Radioactive Plates
        CM_MAP.get(Ids.ADVANCED_ALLOY).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::plateCorBronze);                               // SuperHot (CO)
        CM_MAP.get(Ids.RUBBER).addEvent(TraitEventType.TICK, TraitPartType.GAMBESON, TickEvents::gambesonRubber);                                    // Sweaty
        CM_MAP.get(Ids.IRIDIUM).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksIridium);                     // Unconventional Power - Store
        CM_MAP.get(Ids.IRIDIUM).addEvent(TraitEventType.RIGHT_CLICK, TraitPartType.LINKS, RightClickEvents::linksIridium);                           // Unconventional Power - Charge

    }

    public static Map<String, TinkerMaterial> getCmMap() {
        return CM_MAP;
    }
}
