package io.github.sefiraat.slimetinker.items.componentmaterials.factories;

import io.github.sefiraat.slimetinker.events.BlockBreakEvents;
import io.github.sefiraat.slimetinker.events.DurabilityEvents;
import io.github.sefiraat.slimetinker.events.EntityDamageEvents;
import io.github.sefiraat.slimetinker.events.PlayerDamagedEvents;
import io.github.sefiraat.slimetinker.events.RightClickEvents;
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
public final class CMDynaTech {


    @Getter
    private static final Map<String, ComponentMaterial> map = new HashMap<>();

    static {
        map.put(IDStrings.STAINLESSSTEEL,
                new ComponentMaterial
                        (
                                IDStrings.STAINLESSSTEEL,
                                SlimefunItem.getByID("STAINLESS_STEEL").getItem(),
                                SkullTextures.ALLOY_SILVER,
                                Arrays.asList(
                                        CMCore.getMap().get(IDStrings.IRON).getLiquidItemStack(2),
                                        CMCore.getMap().get(IDStrings.ZINC).getLiquidItemStack(1)
                                ),
                                "#d1d1d1",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_STAINLESSSTEEL.getItemId(),
                                    SlimefunItem.getByID("STAINLESS_STEEL").getId(),
                                    Materials.BLOCK_CAST_STAINLESSSTEEL.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMTraits(
                                        IDStrings.STAINLESSSTEEL,
                                        new CMTrait(
                                                "Super Dooper Stainless",
                                                SkullTextures.PROPERTIES_DYNATECH,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("STAINLESS_STEEL").getItem(),
                                                "Like Steel or MagSteel but yet more absurd."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Cutlery",
                                                SkullTextures.PROPERTIES_DYNATECH,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("STAINLESS_STEEL").getItem(),
                                                "Hitting animals will directly feed you. Grim"
                                        )
                                )
                        ));

        map.put(IDStrings.VEXGEM,
                new ComponentMaterial
                        (
                                IDStrings.VEXGEM,
                                SlimefunItem.getByID("VEX_GEM").getItem(),
                                SkullTextures.ALLOY_BLUE,
                                null,
                                "#38c0c2",
                                new CMToolMakeup(false, true, false),
                                new CMForms(
                                    null,
                                    null,
                                    null,
                                    null,
                                    SlimefunItem.getByID("VEX_GEM").getId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMTraits(
                                        IDStrings.VEXGEM,
                                        null,
                                        new CMTrait(
                                                "NoClip",
                                                SkullTextures.PROPERTIES_DYNATECH,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                CMTraits.PROP_BINDING,
                                                SlimefunItem.getByID("VEX_GEM").getItem(),
                                                "Right click while holding to randomly teleport.",
                                                "5 min cooldown."
                                        ),
                                        null
                                )
                        ));

        map.put(IDStrings.STARDUST,
                new ComponentMaterial
                        (
                                IDStrings.STARDUST,
                                SlimefunItem.getByID("STAR_DUST").getItem(),
                                SkullTextures.ALLOY_SILVER,
                                null,
                                "#fdff96",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    null,
                                    SlimefunItem.getByID("STARDUST_METEOR").getId(),
                                    SlimefunItem.getByID("STAR_DUST").getId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMTraits(
                                        IDStrings.STARDUST,
                                        new CMTrait(
                                                "Bright Fury",
                                                SkullTextures.PROPERTIES_DYNATECH,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("STAR_DUST").getItem(),
                                                "Attacks dazzle and blind while being.",
                                                "50% more powerful."
                                        ),
                                        null,
                                        new CMTrait(
                                                "Yvaine",
                                                SkullTextures.PROPERTIES_DYNATECH,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("STAR_DUST").getItem(),
                                                "Gives an ethereal glow and makes villagers",
                                                "friendlier to you."
                                        )
                                )
                        ));

        map.put(IDStrings.GHOSTLYESSENCE,
                new ComponentMaterial
                        (
                                IDStrings.GHOSTLYESSENCE,
                                SlimefunItem.getByID("GHOSTLY_ESSENCE").getItem(),
                                SkullTextures.ALLOY_BROWN,
                                null,
                                "#d4ffef",
                                new CMToolMakeup(false, true, true),
                                new CMForms(
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    SlimefunItem.getByID("GHOSTLY_ESSENCE").getId(),
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMTraits(
                                        IDStrings.GHOSTLYESSENCE,
                                        null,
                                        new CMTrait(
                                                "Incorporeal",
                                                SkullTextures.PROPERTIES_DYNATECH,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                CMTraits.PROP_BINDING,
                                                SlimefunItem.getByID("GHOSTLY_ESSENCE").getItem(),
                                                "Projectiles just pass right through you."
                                        ),
                                        new CMTrait(
                                                "HyperCube [B]",
                                                SkullTextures.PROPERTIES_DYNATECH,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                CMTraits.PROP_ROD,
                                                SlimefunItem.getByID("GHOSTLY_ESSENCE").getItem(),
                                                "Only works with both [A] and [B]. Shift + Right",
                                                "click to store a location. Right click to recall",
                                                "to that location. 10min CD."
                                        )
                                )
                        ));

        map.put(IDStrings.TESSERACT,
                new ComponentMaterial
                        (
                                IDStrings.TESSERACT,
                                SlimefunItem.getByID("TESSERACTING_OBJ").getItem(),
                                SkullTextures.ALLOY_TAN,
                                null,
                                "#c7ba9f",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    SlimefunItem.getByID("TESSERACTING_OBJ").getId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMTraits(
                                        IDStrings.TESSERACT,
                                        new CMTrait(
                                                "HyperCube [A]",
                                                SkullTextures.PROPERTIES_DYNATECH,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                CMTraits.PROP_HEAD,
                                                SlimefunItem.getByID("TESSERACTING_OBJ").getItem(),
                                                "Only works with both [A] and [B]. Shift + Right",
                                                "click to store a location. Right click to recall",
                                                "to that location. 10min CD."
                                        ),
                                        null,
                                        null
                                )
                        ));

        map.get(IDStrings.STARDUST).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headStarDust);                    // Bright Fury
        map.get(IDStrings.STAINLESSSTEEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodStainlessSteel);          // Cutlery
        map.get(IDStrings.TESSERACT).addEvent(TraitEventType.RIGHT_CLICK, TraitPartType.HEAD, RightClickEvents::headTessMat);                         // HyperCube [A]
        map.get(IDStrings.GHOSTLYESSENCE).addEvent(TraitEventType.RIGHT_CLICK, TraitPartType.ROD, RightClickEvents::rodGhostly);                      // HyperCube [B]
        map.get(IDStrings.GHOSTLYESSENCE).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.BINDER, PlayerDamagedEvents::bindGhostly);            // Incorporeal
        map.get(IDStrings.VEXGEM).addEvent(TraitEventType.RIGHT_CLICK, TraitPartType.BINDER, RightClickEvents::bindVex);                              // NoClip
        map.get(IDStrings.STAINLESSSTEEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headStainlessSteel);        // Super Dooper Stainless
        map.get(IDStrings.STARDUST).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodStarDust);                                        // Yvaine

    }

}
