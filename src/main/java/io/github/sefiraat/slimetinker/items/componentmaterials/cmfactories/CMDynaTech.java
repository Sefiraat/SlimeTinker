package io.github.sefiraat.slimetinker.items.componentmaterials.cmfactories;

import io.github.sefiraat.slimetinker.events.EntityDamageEvents;
import io.github.sefiraat.slimetinker.events.PlayerDamagedEvents;
import io.github.sefiraat.slimetinker.events.RightClickEvents;
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
import lombok.Getter;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings("SpellCheckingInspection")
@UtilityClass
public final class CMDynaTech {


    @Getter
    private static final Map<String, ComponentMaterial> map = new HashMap<>();

    static {
        map.put(IDStrings.STAINLESS_STEEL,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.STAINLESS_STEEL, Objects.requireNonNull(SlimefunItem.getByID("STAINLESS_STEEL")).getItem(), SkullTextures.ALLOY_SILVER, "#d1d1d1"),
                                Arrays.asList(
                                        CMCore.getMap().get(IDStrings.IRON).getLiquidItemStack(2),
                                        CMCore.getMap().get(IDStrings.ZINC).getLiquidItemStack(1)
                                ),
                                new CMToolMakeup(true, false, true, true, false, true),
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
                                        IDStrings.STAINLESS_STEEL,
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
                                        ),
                                        new CMTrait(
                                                CMTraits.PROP_PLATES,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                "The Standard",
                                                "Damage taken reduced by 5%"
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_LINKS,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                "Water Safe",
                                                "Gives you water breathing"
                                        ))
                        ));

        map.put(IDStrings.VEX_GEM,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.VEX_GEM, Objects.requireNonNull(SlimefunItem.getByID("VEX_GEM")).getItem(), SkullTextures.ALLOY_BLUE, "#38c0c2"),
                                null,
                                new CMToolMakeup(false, true, false, false, true, false),
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
                                        IDStrings.VEX_GEM,
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_BINDING,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                "NoClip",
                                                "Right click while holding to randomly teleport.",
                                                "5 min cooldown."
                                        ),
                                        null,
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_GAMBESON,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                "Annoying",
                                                "Vex gems shouldn't be used like this!"
                                        ),
                                        null)
                        ));

        map.put(IDStrings.STARDUST,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.STARDUST, Objects.requireNonNull(SlimefunItem.getByID("STAR_DUST")).getItem(), SkullTextures.ALLOY_SILVER, "#fdff96"),
                                null,
                                new CMToolMakeup(true, false, true, true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    null,
                                    Objects.requireNonNull(SlimefunItem.getByID("STARDUST_METEOR")).getId(),
                                    Objects.requireNonNull(SlimefunItem.getByID("STAR_DUST")).getId(),
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
                                        ),
                                        new CMTrait(
                                                CMTraits.PROP_PLATES,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                "Starshine",
                                                "5% chance to heal 1/2 heart during the night"
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_LINKS,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                "Brightburn",
                                                "Gives on stack of Burning Bright! With 4 ",
                                                "stacks, hostile mobs are repelled (not bosses)."
                                        ))
                        ));

        map.put(IDStrings.GHOSTLY_ESSENCE,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.GHOSTLY_ESSENCE, Objects.requireNonNull(SlimefunItem.getByID("GHOSTLY_ESSENCE")).getItem(), SkullTextures.ALLOY_BROWN, "#d4ffef"),
                                null,
                                new CMToolMakeup(false, true, true, false, true, true),
                                new CMForms(
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    Objects.requireNonNull(SlimefunItem.getByID("GHOSTLY_ESSENCE")).getId(),
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMTraits(
                                        IDStrings.GHOSTLY_ESSENCE,
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
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_GAMBESON,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                "Ghost in the shell",
                                                "Slowly damaged all nearby mobs at the cost of durability"
                                        ),
                                        new CMTrait(
                                                CMTraits.PROP_LINKS,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                "Ghostly",
                                                "Hover like a ghost"
                                        ))
                        ));

        map.put(IDStrings.TESSERACT,
                new ComponentMaterial
                        (
                                new CMIdentity(IDStrings.TESSERACT, Objects.requireNonNull(SlimefunItem.getByID("TESSERACTING_OBJ")).getItem(), SkullTextures.ALLOY_TAN, "#c7ba9f"),
                                null,
                                new CMToolMakeup(true, false, true, true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    Objects.requireNonNull(SlimefunItem.getByID("TESSERACTING_OBJ")).getId(),
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
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_PLATES,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                "Hyberbolic Tesseration",
                                                "When in your personal home, you store energy.",
                                                "Damage taken is removed from this energy pool.",
                                                "Required 8x pieces to function and caps at 50."
                                        ),
                                        null,
                                        new CMTrait(
                                                CMTraits.PROP_LINKS,
                                                SupportedPluginsManager.DYNATECH_NOTE,
                                                "Hyberbolic Tesseration",
                                                "When in your personal home, you store energy.",
                                                "Damage taken is removed from this energy pool.",
                                                "Required 8x pieces to function and caps at 50."
                                        ))
                        ));

        map.get(IDStrings.STARDUST).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headStarDust);                    // Bright Fury
        map.get(IDStrings.STAINLESS_STEEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodStainlessSteel);         // Cutlery
        map.get(IDStrings.TESSERACT).addEvent(TraitEventType.RIGHT_CLICK, TraitPartType.HEAD, RightClickEvents::headTessMat);                         // HyperCube [A]
        map.get(IDStrings.GHOSTLY_ESSENCE).addEvent(TraitEventType.RIGHT_CLICK, TraitPartType.ROD, RightClickEvents::rodGhostly);                     // HyperCube [B]
        map.get(IDStrings.GHOSTLY_ESSENCE).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.BINDER, PlayerDamagedEvents::bindGhostly);           // Incorporeal
        map.get(IDStrings.VEX_GEM).addEvent(TraitEventType.RIGHT_CLICK, TraitPartType.BINDER, RightClickEvents::bindVex);                             // NoClip
        map.get(IDStrings.STAINLESS_STEEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headStainlessSteel);       // Super Dooper Stainless
        map.get(IDStrings.STARDUST).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodStarDust);                                        // Yvaine

    }

}
