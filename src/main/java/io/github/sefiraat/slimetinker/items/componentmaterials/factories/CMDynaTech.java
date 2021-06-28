package io.github.sefiraat.slimetinker.items.componentmaterials.factories;

import io.github.sefiraat.slimetinker.events.EntityDamageEvents;
import io.github.sefiraat.slimetinker.events.PlayerDamagedEvents;
import io.github.sefiraat.slimetinker.events.RightClickEvents;
import io.github.sefiraat.slimetinker.events.TickEvents;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMForms;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMIdentity;
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
                                new CMIdentity(IDStrings.STAINLESSSTEEL, SlimefunItem.getByID("STAINLESS_STEEL").getItem(), SkullTextures.ALLOY_SILVER, "#d1d1d1"),
                                Arrays.asList(
                                        CMCore.getMap().get(IDStrings.IRON).getLiquidItemStack(2),
                                        CMCore.getMap().get(IDStrings.ZINC).getLiquidItemStack(1)
                                ),
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
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                "Super Dooper Stainless",
                                                "Like Steel or MagSteel but yet more absurd."
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                "Cutlery",
                                                "Hitting animals will directly feed you. Grim"
                                        )
                                )
                        ));

        map.put(IDStrings.VEXGEM,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.VEXGEM, SlimefunItem.getByID("VEX_GEM").getItem(), SkullTextures.ALLOY_BLUE, "#38c0c2"),
                                null,
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
                                                CMTraits.PROP_BINDING,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                "NoClip",
                                                "Right click while holding to randomly teleport.",
                                                "5 min cooldown."
                                        ),
                                        null
                                )
                        ));

        map.put(IDStrings.STARDUST,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.STARDUST, SlimefunItem.getByID("STAR_DUST").getItem(), SkullTextures.ALLOY_SILVER, "#fdff96"),
                                null,
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
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                "Bright Fury",
                                                "Attacks dazzle and blind while being.",
                                                "50% more powerful."
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                "Yvaine",
                                                "Gives an ethereal glow and makes villagers",
                                                "friendlier to you."
                                        )
                                )
                        ));

        map.put(IDStrings.GHOSTLYESSENCE,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.GHOSTLYESSENCE, SlimefunItem.getByID("GHOSTLY_ESSENCE").getItem(), SkullTextures.ALLOY_BROWN, "#d4ffef"),
                                null,
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
                                                CMTraits.PROP_BINDING,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                "Incorporeal",
                                                "Projectiles just pass right through you."
                                        ),
                                        new CMTrait(
                                                CMTraits.PROP_ROD,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                "HyperCube [B]",
                                                "Only works with both [A] and [B]. Shift + Right",
                                                "click to store a location. Right click to recall",
                                                "to that location. 10min CD."
                                        )
                                )
                        ));

        map.put(IDStrings.TESSERACT,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.TESSERACT, SlimefunItem.getByID("TESSERACTING_OBJ").getItem(), SkullTextures.ALLOY_TAN, "#c7ba9f"),
                                null,
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
                                                CMTraits.PROP_HEAD,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                "HyperCube [A]",
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
