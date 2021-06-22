package io.github.sefiraat.slimetinker.items.componentmaterials;

import io.github.sefiraat.slimetinker.events.BlockBreakEvents;
import io.github.sefiraat.slimetinker.events.DurabilityEvents;
import io.github.sefiraat.slimetinker.events.EntityDamageEvents;
import io.github.sefiraat.slimetinker.events.PlayerDamagedEvents;
import io.github.sefiraat.slimetinker.events.TickEvents;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.materials.ComponentMaterial;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import lombok.Getter;
import lombok.experimental.UtilityClass;

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
                                true,
                                false,
                                true,
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
                        ));

        map.put(IDStrings.INFINITY,
                new ComponentMaterial
                        (
                                IDStrings.INFINITY,
                                "#d1ebf0",
                                true,
                                false,
                                true,
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
                        ));

        map.put(IDStrings.FORTUNE,
                new ComponentMaterial
                        (
                                IDStrings.FORTUNE,
                                "#f0d541",
                                true,
                                false,
                                true,
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
                        ));

        map.put(IDStrings.MAGIC,
                new ComponentMaterial
                        (
                                IDStrings.MAGIC,
                                "#c941e8",
                                true,
                                false,
                                true,
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
                        ));

        map.put(IDStrings.EARTH,
                new ComponentMaterial
                        (
                                IDStrings.EARTH,
                                "#44e34f",
                                true,
                                false,
                                true,
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
                        ));

        map.put(IDStrings.METAL,
                new ComponentMaterial
                        (
                                IDStrings.METAL,
                                "#5b615b",
                                true,
                                false,
                                true,
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
                        ));

        map.put(IDStrings.MAGSTEEL,
                new ComponentMaterial
                        (
                                IDStrings.MAGSTEEL,
                                "#730000",
                                true,
                                false,
                                true,
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
                        ));

        map.put(IDStrings.TITANIUM,
                new ComponentMaterial
                        (
                                IDStrings.TITANIUM,
                                "#adadad",
                                true,
                                false,
                                true,
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
                        ));

        map.put(IDStrings.MYTHRIL,
                new ComponentMaterial
                        (
                                IDStrings.MYTHRIL,
                                "#4ebdc7",
                                true,
                                false,
                                true,
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
                        ));

        map.put(IDStrings.ADAMANTITE,
                new ComponentMaterial
                        (
                                IDStrings.ADAMANTITE,
                                "#c93ec2",
                                true,
                                false,
                                true,
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
                        ));

        map.put(IDStrings.MAGNONIUM,
                new ComponentMaterial
                        (
                                IDStrings.MAGNONIUM,
                                "#4a0446",
                                true,
                                false,
                                true,
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
                        ));

        map.put(IDStrings.SINGIRON,
                new ComponentMaterial
                        (
                                IDStrings.SINGIRON,
                                "#8c8c8c",
                                true,
                                false,
                                true,
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
                        ));

        map.put(IDStrings.SINGGOLD,
                new ComponentMaterial
                        (
                                IDStrings.SINGGOLD,
                                "#ffe138",
                                true,
                                false,
                                true,
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
                        ));

        map.put(IDStrings.SINGCOPPER,
                new ComponentMaterial
                        (
                                IDStrings.SINGCOPPER,
                                "#c99732",
                                true,
                                false,
                                true,
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
                        ));

        map.put(IDStrings.SINGLEAD,
                new ComponentMaterial
                        (
                                IDStrings.SINGLEAD,
                                "#9043ba",
                                true,
                                false,
                                true,
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
                        ));

        map.put(IDStrings.SINGSILVER,
                new ComponentMaterial
                        (
                                IDStrings.SINGSILVER,
                                "#d4d4d4",
                                true,
                                false,
                                true,
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
                        ));

        map.put(IDStrings.SINGALUMINUM,
                new ComponentMaterial
                        (
                                IDStrings.SINGALUMINUM,
                                "#b0b0b0",
                                true,
                                false,
                                true,
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
                        ));

        map.put(IDStrings.SINGTIN,
                new ComponentMaterial
                        (
                                IDStrings.SINGTIN,
                                "#a89b9b",
                                true,
                                false,
                                true,
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
                        ));

        map.put(IDStrings.SINGZINC,
                new ComponentMaterial
                        (
                                IDStrings.SINGZINC,
                                "#9ba8a6",
                                true,
                                false,
                                true,
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
                        ));

        map.put(IDStrings.SINGMAGNESIUM,
                new ComponentMaterial
                        (
                                IDStrings.SINGMAGNESIUM,
                                "#e8cef5",
                                true,
                                false,
                                true,
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
                        ));

        map.put(IDStrings.SINGINFINITY,
                new ComponentMaterial
                        (
                                IDStrings.SINGINFINITY,
                                "#e8cef5",
                                true,
                                false,
                                false,
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
                        ));

        map.get(IDStrings.ADAMANTITE).addRodPlayerDamagedEvent(PlayerDamagedEvents::rodAdamantite);             // Adamant
        map.get(IDStrings.SINGGOLD).addRodTickEvent(TickEvents::rodSingGold);                                   // All that Glitters II
        map.get(IDStrings.SINGCOPPER).addHeadDamageEvent(EntityDamageEvents::headSingCopper);                   // Brains Not Brawn II - Damage
        map.get(IDStrings.SINGCOPPER).addHeadBlockBreakEvent(BlockBreakEvents::headSingCopper);                 // Brains Not Brawn II - Block Break
        map.get(IDStrings.SINGINFINITY).addHeadDuraEvent(DurabilityEvents::headSingInfinity);                   // Breakpoint - Durability
        map.get(IDStrings.SINGINFINITY).addHeadDamageEvent(EntityDamageEvents::headSingInfinity);               // Breakpoint - Durability
        map.get(IDStrings.SINGINFINITY).addHeadBlockBreakEvent(BlockBreakEvents::headSingInfinity);             // Breakpoint - Durability
        map.get(IDStrings.SINGTIN).addRodTickEvent(TickEvents::rodSingTin);                                     // Can II
        map.get(IDStrings.METAL).addHeadTickEvent(TickEvents::headMetal);                                       // Clean Cut - Tick
        map.get(IDStrings.METAL).addHeadDamageEvent(EntityDamageEvents::headMetal);                             // Clean Cut - Damage
        map.get(IDStrings.INFINITY).addRodPlayerDamagedEvent(PlayerDamagedEvents::rodInfinity);                 // Conceptual Defence
                                                                                                                // Conductive II (Special case, handled in Experience.java)
        map.get(IDStrings.METAL).addRodBlockBreakEvent(BlockBreakEvents::rodMetal);                             // Conductor - Block Break
        map.get(IDStrings.METAL).addRodDamageEvent(EntityDamageEvents::rodMetal);                               // Conductor - Damage
                                                                                                                // Durable - Damage (Special Case - in EntityDamageListener.java - cant move)       |
                                                                                                                // Durable - Block Break (Special Case - in BlockBreakListener.java - cant move)    |-- CO - Duralium Head
        map.get(IDStrings.TITANIUM).addHeadTickEvent(TickEvents::headDuralium);                                 // Durable - Tick                                                                   |
        map.get(IDStrings.EARTH).addHeadDamageEvent(EntityDamageEvents::headEarth);                             // Earth Shaker
        map.get(IDStrings.MYTHRIL).addHeadDuraEvent(DurabilityEvents::headMythril);                             // Elven Speed - Durability
        map.get(IDStrings.MYTHRIL).addHeadTickEvent(TickEvents::headMythril);                                   // Elven Speed - Tick
                                                                                                                // Enchanting II (Special Case, handled in Experience.java)
        map.get(IDStrings.VOID).addRodDamageEvent(EntityDamageEvents::rodVoid);                                 // Fear the Void
        map.get(IDStrings.MAGSTEEL).addRodDamageEvent(EntityDamageEvents::headMagnesium);                       // Flammable                                                                        |-- CO - Magnesium Head
        map.get(IDStrings.SINGMAGNESIUM).addHeadDamageEvent(EntityDamageEvents::headSingMagnesium);             // Flammable II
        map.get(IDStrings.MAGNONIUM).addRodBlockBreakEvent(BlockBreakEvents::headCorbronze);                    // Flaming Hot                                                                      |-- CO - Corin Bronze Head
        map.get(IDStrings.FORTUNE).addHeadBlockBreakEvent(BlockBreakEvents::headFortune);                       // Fortunate
        map.get(IDStrings.SINGGOLD).addHeadTickEvent(TickEvents::headSingGold);                                 // Golden Veil II - Tick
        map.get(IDStrings.SINGGOLD).addHeadDamageEvent(EntityDamageEvents::headSingGold);                       // Golden Veil II - Damage
        map.get(IDStrings.SINGZINC).addHeadTickEvent(TickEvents::headSingZinc);                                 // Graceful II
        map.get(IDStrings.EARTH).addRodBlockBreakEvent(BlockBreakEvents::rodEarth);                             // Grinder
        map.get(IDStrings.INFINITY).addHeadDuraEvent(DurabilityEvents::headInfinity);                           // Infinite
        map.get(IDStrings.SINGLEAD).addRodTickEvent(TickEvents::rodSingLead);                                   // Leech II
        map.get(IDStrings.MAGNONIUM).addHeadBlockBreakEvent(BlockBreakEvents::headMagnonium);                   // Magnanimous
        map.get(IDStrings.SINGMAGNESIUM).addRodTickEvent(TickEvents::rodSingMagnesium);                         // Magnetesium II
        map.get(IDStrings.SINGTIN).addHeadDamageEvent(EntityDamageEvents::headSingTin);                         // Malleable II - Damage
        map.get(IDStrings.SINGTIN).addHeadTickEvent(TickEvents::headSingTin);                                   // Malleable II - Tick
        map.get(IDStrings.FORTUNE).addRodTickEvent(TickEvents::rodFortune);                                     // Merchant's Veil
        map.get(IDStrings.ADAMANTITE).addHeadBlockBreakEvent(BlockBreakEvents::headAdamantite);                 // Mystic - Block Break
        map.get(IDStrings.ADAMANTITE).addHeadDamageEvent(EntityDamageEvents::headAdamantite);                   // Mystic - Damage
        map.get(IDStrings.SINGLEAD).addHeadDamageEvent(EntityDamageEvents::headSingLead);                       // Poisonous II
        map.get(IDStrings.MAGSTEEL).addHeadDamageEvent(EntityDamageEvents::headMagSteel);                       // Really Stainless
        map.get(IDStrings.SINGALUMINUM).addHeadDuraEvent(DurabilityEvents::headSingAluminum);                   // Recyclable II
                                                                                                                // Reinforced                                                                       |-- CO - Reinforced Rod
        map.get(IDStrings.MAGIC).addRodTickEvent(TickEvents::rodMagic);                                         // Secrets Revealed
        map.get(IDStrings.SINGIRON).addRodTickEvent(TickEvents::rodSingIron);                                   // Sharp 1 II
        map.get(IDStrings.SINGALUMINUM).addRodDuraEvent(DurabilityEvents::rodSingAluminum);                     // Soft II - Durability
        map.get(IDStrings.SINGALUMINUM).addRodBlockBreakEvent(BlockBreakEvents::rodSingAluminum);               // Soft II - Block Break
        map.get(IDStrings.SINGALUMINUM).addRodDamageEvent(EntityDamageEvents::rodSingAluminum);                 // Soft II - Damage
        map.get(IDStrings.SINGSILVER).addRodPlayerDamagedEvent(PlayerDamagedEvents::rodSingSilver);             // Soft Touch II
                                                                                                                // Stability II (Does nothing, here for consistency)
        map.get(IDStrings.MYTHRIL).addRodTickEvent(TickEvents::rodMythril);                                     // Sting of Gondolin
        map.get(IDStrings.SINGZINC).addRodTickEvent(TickEvents::rodSingZinc);                                   // Super Lightweight II
        map.get(IDStrings.MAGIC).addHeadTickEvent(TickEvents::headMagic);                                       // Trick
        map.get(IDStrings.VOID).addHeadBlockBreakEvent(BlockBreakEvents::headVoid);                             // Void Miner

    }

}
