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
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings("SpellCheckingInspection")
public final class CMDynaTech {

    private CMDynaTech() {
        throw new UnsupportedOperationException("Utility Class");
    }

    private static final Map<String, ComponentMaterial> CM_MAP = new HashMap<>();

    static {
        CM_MAP.put(IDStrings.STAINLESS_STEEL,
            new ComponentMaterial(
                new CMIdentity(IDStrings.STAINLESS_STEEL, Objects.requireNonNull(SlimefunItem.getById("STAINLESS_STEEL")).getItem(), SkullTextures.ALLOY_SILVER, "#d1d1d1"),
                Arrays.asList(
                    CMCore.getCmMap().get(IDStrings.IRON).getLiquidItemStack(2),
                    CMCore.getCmMap().get(IDStrings.ZINC).getLiquidItemStack(1)
                ),
                new CMToolMakeup(true, false, true, true, false, true),
                new CMForms(
                    Materials.NUGGET_CAST_STAINLESSSTEEL.getItemId(),
                    SlimefunItem.getById("STAINLESS_STEEL").getId(),
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

        CM_MAP.put(IDStrings.VEX_GEM,
            new ComponentMaterial(
                new CMIdentity(IDStrings.VEX_GEM, Objects.requireNonNull(SlimefunItem.getById("VEX_GEM")).getItem(), SkullTextures.ALLOY_BLUE, "#38c0c2"),
                null,
                new CMToolMakeup(false, true, false, false, true, false),
                new CMForms(
                    null,
                    null,
                    null,
                    null,
                    SlimefunItem.getById("VEX_GEM").getId(),
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

        CM_MAP.put(IDStrings.STARDUST,
            new ComponentMaterial(
                new CMIdentity(IDStrings.STARDUST, Objects.requireNonNull(SlimefunItem.getById("STAR_DUST")).getItem(), SkullTextures.ALLOY_SILVER, "#fdff96"),
                null,
                new CMToolMakeup(true, false, true, true, false, true),
                new CMForms(
                    null,
                    null,
                    null,
                    Objects.requireNonNull(SlimefunItem.getById("STARDUST_METEOR")).getId(),
                    Objects.requireNonNull(SlimefunItem.getById("STAR_DUST")).getId(),
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

        CM_MAP.put(IDStrings.GHOSTLY_ESSENCE,
            new ComponentMaterial(
                new CMIdentity(IDStrings.GHOSTLY_ESSENCE, Objects.requireNonNull(SlimefunItem.getById("GHOSTLY_ESSENCE")).getItem(), SkullTextures.ALLOY_BROWN, "#d4ffef"),
                null,
                new CMToolMakeup(false, true, true, false, true, true),
                new CMForms(
                    null,
                    null,
                    null,
                    null,
                    null,
                    Objects.requireNonNull(SlimefunItem.getById("GHOSTLY_ESSENCE")).getId(),
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
                        "Slowly damages all nearby mobs at the cost of durability.",
                        "Mobs cannot die due to this effect."
                    ),
                    new CMTrait(
                        CMTraits.PROP_LINKS,
                        SupportedPluginsManager.DYNATECH_NOTE,
                        "Ghostly",
                        "Hover like a ghost"
                    ))
            ));

        CM_MAP.put(IDStrings.TESSERACT,
            new ComponentMaterial(
                new CMIdentity(IDStrings.TESSERACT, Objects.requireNonNull(SlimefunItem.getById("TESSERACTING_OBJ")).getItem(), SkullTextures.ALLOY_TAN, "#c7ba9f"),
                null,
                new CMToolMakeup(true, false, true, true, false, true),
                new CMForms(
                    null,
                    null,
                    Objects.requireNonNull(SlimefunItem.getById("TESSERACTING_OBJ")).getId(),
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
                        "Required 8x pieces to function and caps at 50",
                        "per peice."
                    ))
            ));

        setupToolConsumers();
        setupArmourConsumers();

    }

    public static void setupToolConsumers() {

        CM_MAP.get(IDStrings.STARDUST).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headStarDust);                    // Bright Fury
        CM_MAP.get(IDStrings.STAINLESS_STEEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodStainlessSteel);         // Cutlery
        CM_MAP.get(IDStrings.TESSERACT).addEvent(TraitEventType.RIGHT_CLICK, TraitPartType.HEAD, RightClickEvents::headTessMat);                         // HyperCube [A]
        CM_MAP.get(IDStrings.GHOSTLY_ESSENCE).addEvent(TraitEventType.RIGHT_CLICK, TraitPartType.ROD, RightClickEvents::rodGhostly);                     // HyperCube [B]
        CM_MAP.get(IDStrings.GHOSTLY_ESSENCE).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.BINDER, PlayerDamagedEvents::bindGhostly);           // Incorporeal
        CM_MAP.get(IDStrings.VEX_GEM).addEvent(TraitEventType.RIGHT_CLICK, TraitPartType.BINDER, RightClickEvents::bindVex);                             // NoClip
        CM_MAP.get(IDStrings.STAINLESS_STEEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headStainlessSteel);       // Super Dooper Stainless
        CM_MAP.get(IDStrings.STARDUST).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodStarDust);                                        // Yvaine

    }

    public static void setupArmourConsumers() {

        CM_MAP.get(IDStrings.VEX_GEM).addEvent(TraitEventType.TICK, TraitPartType.GAMBESON, TickEvents::gambesonVex);                                     // Annoying
        CM_MAP.get(IDStrings.STARDUST).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::brightBurn);                                        // Brightburn (CO)
        CM_MAP.get(IDStrings.GHOSTLY_ESSENCE).addEvent(TraitEventType.TICK, TraitPartType.GAMBESON, TickEvents::gambesonGhostly);                         // Ghost in the Shell
        CM_MAP.get(IDStrings.GHOSTLY_ESSENCE).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksGhostly);                               // Ghostly
        CM_MAP.get(IDStrings.TESSERACT).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::hyperbolic);                                       // Hyperbolic Tesseration - Links - Store
        CM_MAP.get(IDStrings.TESSERACT).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::hyperbolic);                    // Hyperbolic Tesseration - Links - Absorb
        CM_MAP.get(IDStrings.TESSERACT).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::hyperbolic);                                       // Hyperbolic Tesseration - Plate - Store
        CM_MAP.get(IDStrings.TESSERACT).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::hyperbolic);                    // Hyperbolic Tesseration - Plate - Absorb
        CM_MAP.get(IDStrings.STARDUST).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateStardust);                                     // Starshine
        CM_MAP.get(IDStrings.STAINLESS_STEEL).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateStainlessSteel);     // The Standard
        CM_MAP.get(IDStrings.STAINLESS_STEEL).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksStainlessSteel);                        // Water Safe
    }

    public static Map<String, ComponentMaterial> getCmMap() {
        return CM_MAP;
    }
}
