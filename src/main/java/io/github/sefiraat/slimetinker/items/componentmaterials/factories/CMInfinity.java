package io.github.sefiraat.slimetinker.items.componentmaterials.factories;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.events.BlockBreakEvents;
import io.github.sefiraat.slimetinker.events.DurabilityEvents;
import io.github.sefiraat.slimetinker.events.EntityDamageEvents;
import io.github.sefiraat.slimetinker.events.PlayerDamagedEvents;
import io.github.sefiraat.slimetinker.events.TickEvents;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMForms;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMLiquid;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMToolMakeup;
import io.github.sefiraat.slimetinker.items.componentmaterials.ComponentMaterial;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.sefiraat.slimetinker.utils.enums.TraitEventType;
import io.github.sefiraat.slimetinker.utils.enums.TraitPartType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public final class CMInfinity {


    @Getter
    private static final Map<String, ComponentMaterial> map = new HashMap<>();

    static {
        map.put(IDStrings.VOID,
                new ComponentMaterial
                        (
                                IDStrings.VOID,
                                "#5c5756",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    "VOID_BIT",
                                    "VOID_INGOT",
                                    Materials.BLOCK_CAST_VOID.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.VOID,
                                        SkullTextures.ALLOY_PURPLE_DEEP,
                                        SlimefunItem.getByID("VOID_INGOT").getItem()
                                ),
                                null
                        ));

        map.put(IDStrings.INFINITY,
                new ComponentMaterial
                        (
                                IDStrings.INFINITY,
                                "#d1ebf0",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_INFINITY.getItemId(),
                                    "INFINITE_INGOT",
                                    Materials.BLOCK_CAST_INFINITY.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.INFINITY,
                                        SkullTextures.ALLOY_BLUE_PALE,
                                        SlimefunItem.getByID("INFINITE_INGOT").getItem()
                                ),
                                null
                        ));

        map.put(IDStrings.FORTUNE,
                new ComponentMaterial
                        (
                                IDStrings.FORTUNE,
                                "#f0d541",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    null,
                                    null,
                                    "FORTUNE_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.FORTUNE,
                                        SkullTextures.ALLOY_PURPLE,
                                        SlimefunItem.getByID("FORTUNE_SINGULARITY").getItem()
                                ),
                                null
                        ));

        map.put(IDStrings.MAGIC,
                new ComponentMaterial
                        (
                                IDStrings.MAGIC,
                                "#c941e8",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    null,
                                    null,
                                    "MAGIC_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.MAGIC,
                                        SkullTextures.ALLOY_BLUE,
                                        SlimefunItem.getByID("MAGIC_SINGULARITY").getItem()
                                ),
                                null
                        ));

        map.put(IDStrings.EARTH,
                new ComponentMaterial
                        (
                                IDStrings.EARTH,
                                "#44e34f",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    null,
                                    null,
                                    "EARTH_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.EARTH,
                                        SkullTextures.ALLOY_GREEN,
                                        SlimefunItem.getByID("EARTH_SINGULARITY").getItem()
                                ),
                                null
                        ));

        map.put(IDStrings.METAL,
                new ComponentMaterial
                        (
                                IDStrings.METAL,
                                "#5b615b",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    null,
                                    null,
                                    "METAL_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.METAL,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItem.getByID("METAL_SINGULARITY").getItem()
                                ),
                                null
                        ));

        map.put(IDStrings.MAGSTEEL,
                new ComponentMaterial
                        (
                                IDStrings.MAGSTEEL,
                                "#730000",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_MAGSTEEL.getItemId(),
                                    "MAGSTEEL",
                                    Materials.BLOCK_CAST_MAGSTEEL.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.MAGSTEEL,
                                        SkullTextures.ALLOY_BROWN,
                                        SlimefunItem.getByID("MAGSTEEL").getItem()
                                ),
                                null
                        ));

        map.put(IDStrings.TITANIUM,
                new ComponentMaterial
                        (
                                IDStrings.TITANIUM,
                                "#adadad",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_TITANIUM.getItemId(),
                                    "TITANIUM",
                                    Materials.BLOCK_CAST_TITANIUM.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.TITANIUM,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItem.getByID("TITANIUM").getItem()
                                ),
                                null
                        ));

        map.put(IDStrings.MYTHRIL,
                new ComponentMaterial
                        (
                                IDStrings.MYTHRIL,
                                "#4ebdc7",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_MYTHRIL.getItemId(),
                                    "MYTHRIL",
                                    Materials.BLOCK_CAST_MYTHRIL.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.MYTHRIL,
                                        SkullTextures.ALLOY_BLUE_PALE,
                                        SlimefunItem.getByID("MYTHRIL").getItem()
                                ),
                                null
                        ));

        map.put(IDStrings.ADAMANTITE,
                new ComponentMaterial
                        (
                                IDStrings.ADAMANTITE,
                                "#c93ec2",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_ADAMANTITE.getItemId(),
                                    "ADAMANTITE",
                                    Materials.BLOCK_CAST_ADAMANTITE.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.ADAMANTITE,
                                        SkullTextures.ALLOY_TAN,
                                        SlimefunItem.getByID("ADAMANTITE").getItem()
                                ),
                                null
                        ));

        map.put(IDStrings.MAGNONIUM,
                new ComponentMaterial
                        (
                                IDStrings.MAGNONIUM,
                                "#4a0446",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    Materials.NUGGET_CAST_MAGNONIUM.getItemId(),
                                    "MAGNONIUM",
                                    Materials.BLOCK_CAST_MAGNONIUM.getItemId(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.MAGNONIUM,
                                        SkullTextures.ALLOY_PURPLE,
                                        SlimefunItem.getByID("MAGNONIUM").getItem()
                                ),
                                null
                        ));

        map.put(IDStrings.SINGIRON,
                new ComponentMaterial
                        (
                                IDStrings.SINGIRON,
                                "#8c8c8c",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    "IRON_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SINGIRON,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItem.getByID("IRON_SINGULARITY").getItem()
                                ),
                                null
                        ));

        map.put(IDStrings.SINGGOLD,
                new ComponentMaterial
                        (
                                IDStrings.SINGGOLD,
                                "#ffe138",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    "GOLD_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SINGGOLD,
                                        SkullTextures.ALLOY_TAN,
                                        SlimefunItem.getByID("GOLD_SINGULARITY").getItem()
                                ),
                                null
                        ));

        map.put(IDStrings.SINGCOPPER,
                new ComponentMaterial
                        (
                                IDStrings.SINGCOPPER,
                                "#c99732",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    "COPPER_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SINGCOPPER,
                                        SkullTextures.ALLOY_BROWN,
                                        SlimefunItem.getByID("COPPER_SINGULARITY").getItem()
                                ),
                                null
                        ));

        map.put(IDStrings.SINGLEAD,
                new ComponentMaterial
                        (
                                IDStrings.SINGLEAD,
                                "#9043ba",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    "LEAD_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SINGLEAD,
                                        SkullTextures.ALLOY_PURPLE,
                                        SlimefunItem.getByID("LEAD_SINGULARITY").getItem()
                                ),
                                null
                        ));

        map.put(IDStrings.SINGSILVER,
                new ComponentMaterial
                        (
                                IDStrings.SINGSILVER,
                                "#d4d4d4",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    "SILVER_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SINGSILVER,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItem.getByID("SILVER_SINGULARITY").getItem()
                                ),
                                null
                        ));

        map.put(IDStrings.SINGALUMINUM,
                new ComponentMaterial
                        (
                                IDStrings.SINGALUMINUM,
                                "#b0b0b0",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    "ALUMINUM_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SINGALUMINUM,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItem.getByID("ALUMINUM_SINGULARITY").getItem()
                                ),
                                null
                        ));

        map.put(IDStrings.SINGTIN,
                new ComponentMaterial
                        (
                                IDStrings.SINGTIN,
                                "#a89b9b",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    "TIN_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SINGTIN,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItem.getByID("TIN_SINGULARITY").getItem()
                                ),
                                null
                        ));

        map.put(IDStrings.SINGZINC,
                new ComponentMaterial
                        (
                                IDStrings.SINGZINC,
                                "#9ba8a6",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    "ZINC_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SINGZINC,
                                        SkullTextures.ALLOY_SILVER,
                                        SlimefunItem.getByID("ZINC_SINGULARITY").getItem()
                                ),
                                null
                        ));

        map.put(IDStrings.SINGMAGNESIUM,
                new ComponentMaterial
                        (
                                IDStrings.SINGMAGNESIUM,
                                "#e8cef5",
                                new CMToolMakeup(true, false, true),
                                new CMForms(
                                    null,
                                    null,
                                    "MAGNESIUM_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SINGMAGNESIUM,
                                        SkullTextures.ALLOY_PINK,
                                        SlimefunItem.getByID("MAGNESIUM_SINGULARITY").getItem()
                                ),
                                null
                        ));

        map.put(IDStrings.SINGINFINITY,
                new ComponentMaterial
                        (
                                IDStrings.SINGINFINITY,
                                "#e8cef5",
                                new CMToolMakeup(true, false, false),
                                new CMForms(
                                    null,
                                    null,
                                    "INFINITY_SINGULARITY",
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                                ),
                                new CMLiquid(
                                        IDStrings.SINGINFINITY,
                                        SkullTextures.ALLOY_BLUE_PALE,
                                        SlimefunItem.getByID("INFINITY_SINGULARITY").getItem()
                                ),
                                null
                        ));

        map.get(IDStrings.ADAMANTITE).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.ROD, PlayerDamagedEvents::rodAdamantite);           // Adamant
        map.get(IDStrings.SINGGOLD).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodSingGold);                                  // All that Glitters II
        map.get(IDStrings.SINGCOPPER).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headSingCopper);          // Brains Not Brawn II - Damage
        map.get(IDStrings.SINGCOPPER).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headSingCopper);               // Brains Not Brawn II - Block Break
        map.get(IDStrings.SINGINFINITY).addEvent(TraitEventType.DURABILITY, TraitPartType.HEAD, DurabilityEvents::headSingInfinity);            // Breakpoint - Durability
        map.get(IDStrings.SINGINFINITY).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headSingInfinity);      // Breakpoint - Damage
        map.get(IDStrings.SINGINFINITY).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headSingInfinity);           // Breakpoint - Block Break
        map.get(IDStrings.SINGTIN).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodSingTin);                                    // Can II
        map.get(IDStrings.METAL).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headMetal);                                      // Clean Cut - Tick
        map.get(IDStrings.METAL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headMetal);                    // Clean Cut - Damage
        map.get(IDStrings.INFINITY).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.ROD, PlayerDamagedEvents::rodInfinity);               // Conceptual Defence
                                                                                                                                                // Conductive II (Special case, handled in Experience.java)
        map.get(IDStrings.METAL).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.ROD, BlockBreakEvents::rodMetal);                           // Conductor - Block Break
        map.get(IDStrings.METAL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodMetal);                      // Conductor - Damage
                                                                                                                                                // Durable - Damage (Special Case - in EntityDamageListener.java - cant move)       |
                                                                                                                                                // Durable - Block Break (Special Case - in BlockBreakListener.java - cant move)    |-- CO - Duralium Head
        map.get(IDStrings.TITANIUM).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headDuralium);                                // Durable - Tick
        map.get(IDStrings.EARTH).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headEarth);                    // Earth Shaker
        map.get(IDStrings.MYTHRIL).addEvent(TraitEventType.DURABILITY, TraitPartType.HEAD, DurabilityEvents::headMythril);                      // Elven Speed - Durability
        map.get(IDStrings.MYTHRIL).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headMythril);                                  // Elven Speed - Tick
                                                                                                                                                // Enchanting II (Special Case, handled in Experience.java)
        map.get(IDStrings.VOID).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodVoid);                        // Fear the Void
        map.get(IDStrings.MAGSTEEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::headMagnesium);              // Flammable                                                                        |-- CO - Magnesium Head
        map.get(IDStrings.SINGMAGNESIUM).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headSingMagnesium);    // Flammable II
        map.get(IDStrings.MAGNONIUM).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.ROD, BlockBreakEvents::headCorbronze);                  // Flaming Hot                                                                      |-- CO - Corin Bronze Head
        map.get(IDStrings.FORTUNE).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headFortune);                     // Fortunate
        map.get(IDStrings.SINGGOLD).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headSingGold);                                // Golden Veil II - Tick
        map.get(IDStrings.SINGGOLD).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headSingGold);              // Golden Veil II - Damage
        map.get(IDStrings.SINGZINC).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headSingZinc);                                // Graceful II
        map.get(IDStrings.EARTH).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.ROD, BlockBreakEvents::rodEarth);                           // Grinder
        map.get(IDStrings.INFINITY).addEvent(TraitEventType.DURABILITY, TraitPartType.HEAD, DurabilityEvents::headInfinity);                    // Infinite
        map.get(IDStrings.SINGLEAD).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodSingLead);                                  // Leech II
        map.get(IDStrings.MAGNONIUM).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headMagnonium);                 // Magnanimous
        map.get(IDStrings.SINGMAGNESIUM).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodSingMagnesium);                        // Magnetesium II
        map.get(IDStrings.SINGTIN).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headSingTin);                // Malleable II - Damage
        map.get(IDStrings.SINGTIN).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headSingTin);                                  // Malleable II - Tick
        map.get(IDStrings.FORTUNE).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodFortune);                                    // Merchant's Veil
        map.get(IDStrings.ADAMANTITE).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headAdamantite);               // Mystic - Block Break
        map.get(IDStrings.ADAMANTITE).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headAdamantite);          // Mystic - Damage
        map.get(IDStrings.SINGLEAD).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headSingLead);              // Poisonous II
        map.get(IDStrings.MAGSTEEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headMagSteel);              // Really Stainless
        map.get(IDStrings.SINGALUMINUM).addEvent(TraitEventType.DURABILITY, TraitPartType.HEAD, DurabilityEvents::headSingAluminum);            // Recyclable II
                                                                                                                                                // Reinforced                                                                       |-- CO - Reinforced Rod
        map.get(IDStrings.MAGIC).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodMagic);                                        // Secrets Revealed
        map.get(IDStrings.SINGIRON).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodSingIron);                                  // Sharp 1 II
        map.get(IDStrings.SINGALUMINUM).addEvent(TraitEventType.DURABILITY, TraitPartType.ROD, DurabilityEvents::rodSingAluminum);              // Soft II - Durability
        map.get(IDStrings.SINGALUMINUM).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.ROD, BlockBreakEvents::rodSingAluminum);             // Soft II - Block Break
        map.get(IDStrings.SINGALUMINUM).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodSingAluminum);        // Soft II - Damage
        map.get(IDStrings.SINGSILVER).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.ROD, PlayerDamagedEvents::rodSingSilver);           // Soft Touch II
                                                                                                                                                // Stability II (Does nothing, here for consistency)
        map.get(IDStrings.MYTHRIL).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodMythril);                                    // Sting of Gondolin
        map.get(IDStrings.SINGZINC).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodSingZinc);                                  // Super Lightweight II
        map.get(IDStrings.MAGIC).addEvent(TraitEventType.TICK, TraitPartType.HEAD, TickEvents::headMagic);                                      // Trick
        map.get(IDStrings.VOID).addEvent(TraitEventType.BLOCK_BREAK, TraitPartType.HEAD, BlockBreakEvents::headVoid);                           // Void Miner

    }

}
