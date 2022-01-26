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
        .setTraitToolHead(Traits.SFW_SEGGANESSON_HEAD)
        .setTraitToolRod(Traits.SFW_SEGGANESSON_ROD)
        .setTraitArmorPlates(Traits.SFW_SEGGANESSON_PLATES)
        .setTraitArmorLinks(Traits.SFW_SEGGANESSON_LINKS)
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
        setupToolConsumers();
        setupArmourConsumers();
    }

    public static void setupToolConsumers() {

        CM_MAP.get(Ids.SEGGANESSON).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodSegganesson);                                           // Blinding Speed
        CM_MAP.get(Ids.SLIMESTEEL).addEvent(TraitEventType.TICK, TraitPartType.BINDER, TickEvents::bindSlimesteel);                                         // Bouncy II - Tick
        CM_MAP.get(Ids.SLIMESTEEL).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.BINDER, PlayerDamagedEvents::bindSlimesteel);                      // Bouncy II - Damage
        CM_MAP.get(Ids.OSMIUM_SUPERALLOY).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headOsmiumSuperalloy);            // Brute - Damage
        CM_MAP.get(Ids.OSMIUM_SUPERALLOY).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headOsmiumSuperalloy);                              // Brute - Tick
        CM_MAP.get(Ids.REINFORCED_SLIMESTEEL).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.ROD, PlayerDamagedEvents::headReinforcedSlimesteel);    // Flexibility
        CM_MAP.get(Ids.OSMIUM).addEvent(TraitEventType.DURABILITY, TraitPartType.HEAD, DurabilityEvents::explosive);                                        // Heavy (CO)
        CM_MAP.get(Ids.OSMIUM).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodOsmium);                                   // Heavy Pommel
        // Incorporeal Right (Special case in ItemDrop and PlayerDesth)
        CM_MAP.get(Ids.UNPATENTABLIUM).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headUnpatentabilum);                 // Innovation - Damage
        CM_MAP.get(Ids.UNPATENTABLIUM).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headUnpatentabilum);                      // Innovation - Block Break
        CM_MAP.get(Ids.SEGGANESSON).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headSegganesson);                       // Overcharge
        CM_MAP.get(Ids.REINFORCED_SLIMESTEEL).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headReinforcedSlimesteel);         // Strong and Sticky
        CM_MAP.get(Ids.OSMIUM_SUPERALLOY).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::headHard);                         // Tuff Stuff (CO)

    }

    public static void setupArmourConsumers() {

        CM_MAP.get(Ids.REINFORCED_SLIMESTEEL).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksReinforcedSlimesteel);  // Deflection
        CM_MAP.get(Ids.OSMIUM).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksOsmium);                               // Draw
        CM_MAP.get(Ids.SEGGANESSON).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateSegganesson);                                        // Gravity
        CM_MAP.get(Ids.OSMIUM).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateOsmium);                                                  // Increased Mass - Slow
        CM_MAP.get(Ids.OSMIUM).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateOsmium);                               // Increased Mass - Knockback
        CM_MAP.get(Ids.UNPATENTABLIUM).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateUnpatentabilum);                                  // Intense Gase
        CM_MAP.get(Ids.UNPATENTABLIUM).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::plateMetal);                        // KOTR (CO)
        CM_MAP.get(Ids.SLIMESTEEL).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.GAMBESON, PlayerDamagedEvents::gambesonSlimeSteel);                 // Moon Bounce
        CM_MAP.get(Ids.OSMIUM_SUPERALLOY).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksOsmiumSuperalloy);                             // Partial Decay
        CM_MAP.get(Ids.REINFORCED_SLIMESTEEL).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateReinforcedSlimesteel);                     // Rigid Flexibility - Effects
        CM_MAP.get(Ids.REINFORCED_SLIMESTEEL).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateReinforcedSlimesteel);  // Rigid Flexibility - Damage
        CM_MAP.get(Ids.SEGGANESSON).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.LINKS, EntityDamageEvents::linksSegganesson);                      // Soul Siphon
        CM_MAP.get(Ids.OSMIUM_SUPERALLOY).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateOsmiumSuperalloy);                             // Tempest

    }

    public static Map<String, TinkerMaterial> getCmMap() {
        return CM_MAP;
    }
}
