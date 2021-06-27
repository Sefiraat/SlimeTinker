package io.github.sefiraat.slimetinker.items.componentmaterials.factories;

import io.github.sefiraat.slimetinker.events.BlockBreakEvents;
import io.github.sefiraat.slimetinker.events.DurabilityEvents;
import io.github.sefiraat.slimetinker.events.EntityDamageEvents;
import io.github.sefiraat.slimetinker.events.PlayerDamagedEvents;
import io.github.sefiraat.slimetinker.events.TickEvents;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMForms;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMToolMakeup;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMTrait;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMTraits;
import io.github.sefiraat.slimetinker.items.componentmaterials.ComponentMaterial;
import io.github.sefiraat.slimetinker.managers.SupportedPluginsManager;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.sefiraat.slimetinker.utils.enums.TraitEventType;
import io.github.sefiraat.slimetinker.utils.enums.TraitPartType;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
public final class CMSlimefunWarfare {


    @Getter
    private static final Map<String, ComponentMaterial> map = new HashMap<>();

    static {
        map.put(IDStrings.SEGGANESSON,
                new ComponentMaterial
                        (
                                IDStrings.SEGGANESSON,
                                SlimefunItem.getByID("SEGGANESSON").getItem(), SkullTextures.ALLOY_BLUE_PALE,
                                null,
                                "#4bacbf",
                                new CMToolMakeup(true, false, true),
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
                                                "Overcharge",
                                                SkullTextures.PROPERTIES_WARFARE,
                                                SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("SEGGANESSON").getItem(),
                                                "Stores energy each time you hit a mob.",
                                                "Every 10th attack releases this back."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Blinding Speed",
                                                SkullTextures.PROPERTIES_WARFARE,
                                                SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("SEGGANESSON").getItem(),
                                                "Gain insane speed but with a side effect."
                                        )
                                )
                        ));

        map.put(IDStrings.SLIMESTEEL,
                new ComponentMaterial
                        (
                                IDStrings.SLIMESTEEL,
                                SlimefunItem.getByID("SLIMESTEEL_INGOT").getItem(),
                                SkullTextures.ALLOY_GREEN,
                                Arrays.asList(
                                        CMCore.getMap().get(IDStrings.STEEL).getLiquidItemStack(1),
                                        CMCore.getMap().get(IDStrings.SLIME).getLiquidItemStack(1)
                                ),
                                "#aed197",
                                new CMToolMakeup(true, false, true),
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
                                                "Bouncy II",
                                                SkullTextures.PROPERTIES_WARFARE,
                                                SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                                                CMTraits.PROP_BINDING,
                                                SlimefunItem.getByID("SLIMESTEEL_INGOT").getItem(),
                                                "Fall damage halved with a jump boost."
                                        ),
                                        null
                                )
                        ));

        map.put(IDStrings.REINFORCEDSLIMESTEEL,
                new ComponentMaterial
                        (
                                IDStrings.REINFORCEDSLIMESTEEL,
                                SlimefunItem.getByID("REINFORCED_SLIMESTEEL_INGOT").getItem(), SkullTextures.ALLOY_GREEN,
                                Arrays.asList(
                                        map.get(IDStrings.SLIMESTEEL).getLiquidItemStack(1),
                                        CMCore.getMap().get(IDStrings.SLIME).getLiquidItemStack(9),
                                        CMCore.getMap().get(IDStrings.DAMSTEEL).getLiquidItemStack(1),
                                        CMCore.getMap().get(IDStrings.HARD).getLiquidItemStack(1),
                                        CMCore.getMap().get(IDStrings.CORBRONZE).getLiquidItemStack(1),
                                        CMCore.getMap().get(IDStrings.ALUBRONZE).getLiquidItemStack(1)
                                ),
                                "#aed197",
                                new CMToolMakeup(true, false, true),
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
                                        IDStrings.REINFORCEDSLIMESTEEL,
                                        new CMTrait(
                                                "Strong and Sticky",
                                                SkullTextures.PROPERTIES_WARFARE,
                                                SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("REINFORCED_SLIMESTEEL_INGOT").getItem(),
                                                "Dropped blocks go into your inventory",
                                                "when possible to do so"
                                        ),
                                        null,
                                        new CMTrait(
                                                "Flexibility",
                                                SkullTextures.PROPERTIES_WARFARE,
                                                SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("REINFORCED_SLIMESTEEL_INGOT").getItem(),
                                                "Incoming damage reduced and durability is lost",
                                                "instead. Doesn't work while tool is broken."
                                        )
                                )
                        ));

        map.put(IDStrings.OSMIUM,
                new ComponentMaterial
                        (
                                IDStrings.OSMIUM,
                                SlimefunItem.getByID("OSMIUM_INGOT").getItem(),
                                SkullTextures.ALLOY_BLUE_PALE,
                                null,
                                "#8dd6c0",
                                new CMToolMakeup(true, false, true),
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
                                                "Heavy",
                                                SkullTextures.PROPERTIES_WARFARE,
                                                SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("OSMIUM_INGOT").getItem(),
                                                "Mines in a 3x3 Area"
                                        ),
                                        null,
                                        new CMTrait(
                                                "Heavy Pommel",
                                                SkullTextures.PROPERTIES_WARFARE,
                                                SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("OSMIUM_INGOT").getItem(),
                                                "Struck mobs are slowed and cannot teleport."
                                        )
                                )
                        ));

        map.put(IDStrings.OSMIUMSUPERALLOY,
                new ComponentMaterial
                        (
                                IDStrings.OSMIUMSUPERALLOY,
                                SlimefunItem.getByID("OSMIUM_SUPERALLOY").getItem(),
                                SkullTextures.ALLOY_BLUE_PALE,
                                Arrays.asList(
                                        map.get(IDStrings.OSMIUM).getLiquidItemStack(2),
                                        map.get(IDStrings.SEGGANESSON).getLiquidItemStack(1),
                                        map.get(IDStrings.REINFORCEDSLIMESTEEL).getLiquidItemStack(1),
                                        CMCore.getMap().get(IDStrings.REINFORCED).getLiquidItemStack(1)
                                ),
                                "#8dd6c0",
                                new CMToolMakeup(true, false, true),
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
                                        IDStrings.OSMIUMSUPERALLOY,
                                        new CMTrait(
                                                "Brute",
                                                SkullTextures.PROPERTIES_WARFARE,
                                                SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("OSMIUM_SUPERALLOY").getItem(),
                                                "Slow swinging speed. Hit enemies are stunned",
                                                "briefly. Damage +100% with an additional 33%",
                                                "chance to crit for a further +100%"
                                        ),
                                        null,
                                        new CMTrait(
                                                "Tuff Stuff",
                                                SkullTextures.PROPERTIES_WARFARE,
                                                SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("OSMIUM_SUPERALLOY").getItem(),
                                                "Knocks back anything hit and stuns."
                                        )
                                )
                        ));

        map.put(IDStrings.UNPATENTABLIUM,
                new ComponentMaterial
                        (
                                IDStrings.UNPATENTABLIUM,
                                SlimefunItem.getByID("UNPATENTABLIUM").getItem(),
                                SkullTextures.ALLOY_BLUE_PALE,
                                null,
                                "#8dd6c0",
                                new CMToolMakeup(true, false, true),
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
                                        IDStrings.OSMIUMSUPERALLOY,
                                        new CMTrait(
                                                "Brute",
                                                SkullTextures.PROPERTIES_WARFARE,
                                                SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("UNPATENTABLIUM").getItem(),
                                                "Slow swinging speed. Hit enemies are stunned",
                                                "briefly. Damage +100% with an additional 33%",
                                                "chance to crit for a further +100%"
                                        ),
                                        null,
                                        new CMTrait(
                                                "Tuff Stuff",
                                                SkullTextures.PROPERTIES_WARFARE,
                                                SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("UNPATENTABLIUM").getItem(),
                                                "Knocks back anything hit and stuns."
                                        )
                                )
                        ));



        map.get(IDStrings.SEGGANESSON).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodSegganesson);                                        // Blinding Speed
        map.get(IDStrings.SLIMESTEEL).addEvent(TraitEventType.TICK, TraitPartType.BINDER, TickEvents::bindSlimesteel);                                      // Bouncy II - Tick
        map.get(IDStrings.SLIMESTEEL).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.BINDER, PlayerDamagedEvents::bindSlimesteel);                   // Bouncy II - Damage
        map.get(IDStrings.OSMIUMSUPERALLOY).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headOsmiumsuperalloy);          // Brute - Damage
        map.get(IDStrings.OSMIUMSUPERALLOY).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headOsmiumsuperalloy);                            // Brute - Tick
        map.get(IDStrings.REINFORCEDSLIMESTEEL).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.ROD, PlayerDamagedEvents::headReinforcedslimesteel);  // Flexibility
        map.get(IDStrings.OSMIUM).addEvent(TraitEventType.DURABILITY, TraitPartType.HEAD, DurabilityEvents::explosive);                                     // Heavy (CO)
        map.get(IDStrings.OSMIUM).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodOsmium);                                // Heavy Pommel
                                                                                                                                                            // Incorporeal Right (Special case in ItemDrop and PlayerDesth)
        map.get(IDStrings.UNPATENTABLIUM).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headUnpatentabilum);              // Innovation - Damage
        map.get(IDStrings.UNPATENTABLIUM).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headUnpatentabilum);                   // Innovation - Block Break
        map.get(IDStrings.SEGGANESSON).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headSegganesson);                    // Overcharge
        map.get(IDStrings.REINFORCEDSLIMESTEEL).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headReinforcedSlimesteel);       // Strong and Sticky
        map.get(IDStrings.OSMIUMSUPERALLOY).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::headHard);                       // Tuff Stuff (CO)


    }

}
