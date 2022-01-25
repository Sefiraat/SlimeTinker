package io.github.sefiraat.slimetinker.items.componentmaterials.cmfactories;

import io.github.sefiraat.slimetinker.events.BlockBreakEvents;
import io.github.sefiraat.slimetinker.events.DurabilityEvents;
import io.github.sefiraat.slimetinker.events.EntityDamageEvents;
import io.github.sefiraat.slimetinker.events.PlayerDamagedEvents;
import io.github.sefiraat.slimetinker.events.TickEvents;
import io.github.sefiraat.slimetinker.events.friend.TraitEventType;
import io.github.sefiraat.slimetinker.events.friend.TraitPartType;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.componentmaterials.ComponentMaterial;
import io.github.sefiraat.slimetinker.items.componentmaterials.cmelements.CMForms;
import io.github.sefiraat.slimetinker.items.componentmaterials.cmelements.CMIdentity;
import io.github.sefiraat.slimetinker.items.componentmaterials.cmelements.CMToolMakeup;
import io.github.sefiraat.slimetinker.items.componentmaterials.cmelements.CMTrait;
import io.github.sefiraat.slimetinker.items.componentmaterials.cmelements.CMTraits;
import io.github.sefiraat.slimetinker.managers.SupportedPluginsManager;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings("SpellCheckingInspection")
public final class CMSlimefunWarfare {

    private CMSlimefunWarfare() {
        throw new UnsupportedOperationException("Utility Class");
    }

    private static final Map<String, ComponentMaterial> CM_MAP = new HashMap<>();

    static {
        CM_MAP.put(IDStrings.SEGGANESSON,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.SEGGANESSON, Objects.requireNonNull(SlimefunItem.getById("SEGGANESSON")).getItem(), SkullTextures.ALLOY_BLUE_PALE, "#4bacbf"),
                    null,
                    new CMToolMakeup(true, false, true, true, false, true),
                    new CMForms(
                        null,
                        null,
                        null,
                        null,
                        "SEGGANESSON",
                        null,
                        null,
                        null,
                        null,
                        null
                    ),
                    new CMTraits(
                        IDStrings.SEGGANESSON,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                            "Overcharge",
                            "Stores energy each time you hit a mob.",
                            "Every 10th attack releases this back."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                            "Blinding Speed",
                            "Gain insane speed but with a side effect."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                            "Gravity",
                            "All nearby entities are slowly pulled",
                            "towards you"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                            "Soul Siphon",
                            "Stores the souls of killed, hostile, mobs.",
                            "Damage + 1% per 100 souls. Caps at 100%."
                        ))
                ));

        CM_MAP.put(IDStrings.SLIMESTEEL,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.SLIMESTEEL, Objects.requireNonNull(SlimefunItem.getById("SLIMESTEEL_INGOT")).getItem(), SkullTextures.ALLOY_GREEN, "#aed197"),
                    Arrays.asList(
                        CMCore.getCmMap().get(IDStrings.STEEL).getLiquidItemStack(1),
                        CMCore.getCmMap().get(IDStrings.SLIME).getLiquidItemStack(1)
                    ),
                    new CMToolMakeup(false, true, false, false, true, false),
                    new CMForms(
                        Materials.NUGGET_CAST_SLIMESTEEL.getItemId(),
                        "SLIMESTEEL_INGOT",
                        Materials.BLOCK_CAST_SLIMESTEEL.getItemId(),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                    ),
                    new CMTraits(
                        IDStrings.SLIMESTEEL,
                        null,
                        new CMTrait(
                            CMTraits.PROP_BINDING,
                            SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                            "Bouncy II",
                            "Fall damage halved with a jump boost."
                        ),
                        null,
                        null,
                        new CMTrait(
                            CMTraits.PROP_GAMBESON,
                            SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                            "Moon Bounce",
                            "When on boots, fall damamge is ignored.",
                            "You also get more bouncy."
                        ),
                        null)
                ));

        CM_MAP.put(IDStrings.REINFORCED_SLIMESTEEL,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.REINFORCED_SLIMESTEEL, Objects.requireNonNull(SlimefunItem.getById("REINFORCED_SLIMESTEEL_INGOT")).getItem(), SkullTextures.ALLOY_GREEN, "#aed197"),
                    Arrays.asList(
                        CM_MAP.get(IDStrings.SLIMESTEEL).getLiquidItemStack(1),
                        CMCore.getCmMap().get(IDStrings.SLIME).getLiquidItemStack(9),
                        CMCore.getCmMap().get(IDStrings.DAMSTEEL).getLiquidItemStack(1),
                        CMCore.getCmMap().get(IDStrings.HARD).getLiquidItemStack(1),
                        CMCore.getCmMap().get(IDStrings.CORBRONZE).getLiquidItemStack(1),
                        CMCore.getCmMap().get(IDStrings.ALUBRONZE).getLiquidItemStack(1)
                    ),
                    new CMToolMakeup(true, false, true, true, false, true),
                    new CMForms(
                        Materials.NUGGET_CAST_REINFORCED_SLIMESTEEL.getItemId(),
                        "REINFORCED_SLIMESTEEL_INGOT",
                        Materials.BLOCK_CAST_REINFORCED_SLIMESTEEL.getItemId(),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                    ),
                    new CMTraits(
                        IDStrings.REINFORCED_SLIMESTEEL,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                            "Strong and Sticky",
                            "Dropped blocks go into your inventory",
                            "when possible to do so"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                            "Flexibility",
                            "Incoming damage reduced and durability is lost",
                            "instead. Doesn't work while tool is broken."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                            "Regid Flexibility",
                            "Speed and Jump + 1. Damage Taken + 10%"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                            "Deflection",
                            "10% chance to ignore projectile damage."
                        ))
                ));

        CM_MAP.put(IDStrings.OSMIUM,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.OSMIUM, Objects.requireNonNull(SlimefunItem.getById("OSMIUM_INGOT")).getItem(), SkullTextures.ALLOY_BLUE_PALE, "#8dd6c0"),
                    null,
                    new CMToolMakeup(true, false, true, true, false, true),
                    new CMForms(
                        Materials.NUGGET_CAST_OSMIUM.getItemId(),
                        "OSMIUM_INGOT",
                        Materials.BLOCK_CAST_OSMIUM.getItemId(),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                    ),
                    new CMTraits(
                        IDStrings.OSMIUM,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                            "Heavy",
                            "Mines in a 3x3 Area"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                            "Heavy Pommel",
                            "Struck mobs are slowed and cannot teleport."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                            "Increased Mass",
                            "Attackers will be knocked back.",
                            "Gives you slow when procced"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                            "Draw",
                            "5% chance to heal by damage dealt."
                        ))
                ));

        CM_MAP.put(IDStrings.OSMIUM_SUPERALLOY,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.OSMIUM_SUPERALLOY, Objects.requireNonNull(SlimefunItem.getById("OSMIUM_SUPERALLOY")).getItem(), SkullTextures.ALLOY_BLUE_PALE, "#8dd6c0"),
                    Arrays.asList(
                        CM_MAP.get(IDStrings.OSMIUM).getLiquidItemStack(2),
                        CM_MAP.get(IDStrings.SEGGANESSON).getLiquidItemStack(1),
                        CM_MAP.get(IDStrings.REINFORCED_SLIMESTEEL).getLiquidItemStack(1),
                        CMCore.getCmMap().get(IDStrings.REINFORCED).getLiquidItemStack(1)
                    ),
                    new CMToolMakeup(true, false, true, true, false, true),
                    new CMForms(
                        Materials.NUGGET_CAST_OSMIUM_SUPER_ALLOY.getItemId(),
                        "OSMIUM_SUPERALLOY",
                        Materials.BLOCK_CAST_OSMIUM_SUPER_ALLOY.getItemId(),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                    ),
                    new CMTraits(
                        IDStrings.OSMIUM_SUPERALLOY,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                            "Brute",
                            "Slow swinging speed. Hit enemies are stunned",
                            "briefly. Damage +100% with an additional 33%",
                            "chance to crit for a further +100%"
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                            "Tuff Stuff",
                            "Knocks back anything hit and stuns."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                            "Tempest",
                            "When wearing 4 peices, chance when hit",
                            "to summon a tempest."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                            "Partial Decay",
                            "Chance to damage random nearby living",
                            "things. Will never kill."
                        ))
                ));

        CM_MAP.put(IDStrings.UNPATENTABLIUM,
            new ComponentMaterial
                (
                    new CMIdentity(IDStrings.UNPATENTABLIUM, Objects.requireNonNull(SlimefunItem.getById("UNPATENTABLIUM")).getItem(), SkullTextures.ALLOY_BLUE_PALE, "#8dd6c0"),
                    null,
                    new CMToolMakeup(true, false, true, true, false, true),
                    new CMForms(
                        Materials.NUGGET_CAST_UNPATENTABILUM.getItemId(),
                        "UNPATENTABLIUM",
                        Materials.BLOCK_CAST_UNPATENTABILUM.getItemId(),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                    ),
                    new CMTraits(
                        IDStrings.UNPATENTABLIUM,
                        new CMTrait(
                            CMTraits.PROP_HEAD,
                            SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                            "Innovation",
                            "+100% Tool and Player EXP during the day."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_ROD,
                            SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                            "Incoporeal Right",
                            "Tool cannot be dropped or lost on death."
                        ),
                        new CMTrait(
                            CMTraits.PROP_PLATES,
                            SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                            "Intense Gaze",
                            "Entities you look at will teleport to you.",
                            "Does not work on players or bosses."
                        ),
                        null,
                        new CMTrait(
                            CMTraits.PROP_LINKS,
                            SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                            "KOTR",
                            "Chance, when hit, to summon a Knight",
                            "of the Round. (It's a Golem ;))"
                        )
                    )
                ));

        setupToolConsumers();
        setupArmourConsumers();

    }

    public static void setupToolConsumers() {

        CM_MAP.get(IDStrings.SEGGANESSON).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodSegganesson);                                           // Blinding Speed
        CM_MAP.get(IDStrings.SLIMESTEEL).addEvent(TraitEventType.TICK, TraitPartType.BINDER, TickEvents::bindSlimesteel);                                         // Bouncy II - Tick
        CM_MAP.get(IDStrings.SLIMESTEEL).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.BINDER, PlayerDamagedEvents::bindSlimesteel);                      // Bouncy II - Damage
        CM_MAP.get(IDStrings.OSMIUM_SUPERALLOY).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headOsmiumSuperalloy);            // Brute - Damage
        CM_MAP.get(IDStrings.OSMIUM_SUPERALLOY).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headOsmiumSuperalloy);                              // Brute - Tick
        CM_MAP.get(IDStrings.REINFORCED_SLIMESTEEL).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.ROD, PlayerDamagedEvents::headReinforcedSlimesteel);    // Flexibility
        CM_MAP.get(IDStrings.OSMIUM).addEvent(TraitEventType.DURABILITY, TraitPartType.HEAD, DurabilityEvents::explosive);                                        // Heavy (CO)
        CM_MAP.get(IDStrings.OSMIUM).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodOsmium);                                   // Heavy Pommel
        // Incorporeal Right (Special case in ItemDrop and PlayerDesth)
        CM_MAP.get(IDStrings.UNPATENTABLIUM).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headUnpatentabilum);                 // Innovation - Damage
        CM_MAP.get(IDStrings.UNPATENTABLIUM).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headUnpatentabilum);                      // Innovation - Block Break
        CM_MAP.get(IDStrings.SEGGANESSON).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headSegganesson);                       // Overcharge
        CM_MAP.get(IDStrings.REINFORCED_SLIMESTEEL).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headReinforcedSlimesteel);         // Strong and Sticky
        CM_MAP.get(IDStrings.OSMIUM_SUPERALLOY).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::headHard);                         // Tuff Stuff (CO)

    }

    public static void setupArmourConsumers() {

        CM_MAP.get(IDStrings.REINFORCED_SLIMESTEEL).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksReinforcedSlimesteel);  // Deflection
        CM_MAP.get(IDStrings.OSMIUM).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::linksOsmium);                               // Draw
        CM_MAP.get(IDStrings.SEGGANESSON).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateSegganesson);                                        // Gravity
        CM_MAP.get(IDStrings.OSMIUM).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateOsmium);                                                  // Increased Mass - Slow
        CM_MAP.get(IDStrings.OSMIUM).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateOsmium);                               // Increased Mass - Knockback
        CM_MAP.get(IDStrings.UNPATENTABLIUM).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateUnpatentabilum);                                  // Intense Gase
        CM_MAP.get(IDStrings.UNPATENTABLIUM).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::plateMetal);                        // KOTR (CO)
        CM_MAP.get(IDStrings.SLIMESTEEL).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.GAMBESON, PlayerDamagedEvents::gambesonSlimeSteel);                 // Moon Bounce
        CM_MAP.get(IDStrings.OSMIUM_SUPERALLOY).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksOsmiumSuperalloy);                             // Partial Decay
        CM_MAP.get(IDStrings.REINFORCED_SLIMESTEEL).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateReinforcedSlimesteel);                     // Rigid Flexibility - Effects
        CM_MAP.get(IDStrings.REINFORCED_SLIMESTEEL).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateReinforcedSlimesteel);  // Rigid Flexibility - Damage
        CM_MAP.get(IDStrings.SEGGANESSON).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.LINKS, EntityDamageEvents::linksSegganesson);                      // Soul Siphon
        CM_MAP.get(IDStrings.OSMIUM_SUPERALLOY).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateOsmiumSuperalloy);                             // Tempest

    }

    public static Map<String, ComponentMaterial> getCmMap() {
        return CM_MAP;
    }
}
