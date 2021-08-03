package io.github.sefiraat.slimetinker.utils;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.utils.enums.Temperature;
import lombok.experimental.UtilityClass;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@UtilityClass
public final class GeneralUtils {

    public static boolean day(World world) {
        return world.getTime() > 0 && world.getTime() < 12300;
    }

    public static String serializeLocation(Location l) {
        String world = Objects.requireNonNull(l.getWorld()).getName();
        double x = l.getX();
        double y = l.getY();
        double z = l.getZ();
        float w = l.getYaw();
        float p = l.getPitch();
        return world + ";" + x + ";" + y + ";" + z + ";" + w + ";" + p;
    }

    public static Location deserializeLocation(String s) {
        String[] split = s.split(";");
        return new Location(
                SlimeTinker.inst().getServer().getWorld(split[0]),
                Double.parseDouble(split[1]),
                Double.parseDouble(split[2]),
                Double.parseDouble(split[3]),
                Float.parseFloat(split[4]),
                Float.parseFloat(split[5])
        );
    }

    /**
     * Tests a chance roll starting from 1 to upper
     * @param chance The number the roll must be lower than
     * @param upper The highest possible number that could roll (inclusive)
     * @return true if roll passes
     */
    public static boolean testChance(int chance, int upper) {
        return ThreadLocalRandom.current().nextInt(1, upper + 1) <= chance;
    }

    public static boolean isBiomeHot(Biome biome) {
        return getBiomeTemperature(biome) == Temperature.HOT;
    }

    public static boolean isBiomeCold(Biome biome) {
        return getBiomeTemperature(biome) == Temperature.COLD;
    }

    public static boolean isBiomeNormal(Biome biome) {
        return getBiomeTemperature(biome) == Temperature.NORMAL;
    }

    public static Temperature getBiomeTemperature(Biome biome) {
        switch (biome) {
            case DESERT:
            case SWAMP:
            case NETHER_WASTES:
            case BEACH:
            case DESERT_HILLS:
            case JUNGLE:
            case JUNGLE_HILLS:
            case JUNGLE_EDGE:
            case SAVANNA:
            case SAVANNA_PLATEAU:
            case WOODED_BADLANDS_PLATEAU:
            case BADLANDS:
            case BADLANDS_PLATEAU:
            case WARM_OCEAN:
            case LUKEWARM_OCEAN:
            case DEEP_WARM_OCEAN:
            case DEEP_LUKEWARM_OCEAN:
            case DESERT_LAKES:
            case SWAMP_HILLS:
            case MODIFIED_JUNGLE:
            case MODIFIED_JUNGLE_EDGE:
            case SHATTERED_SAVANNA:
            case SHATTERED_SAVANNA_PLATEAU:
            case ERODED_BADLANDS:
            case MODIFIED_WOODED_BADLANDS_PLATEAU:
            case MODIFIED_BADLANDS_PLATEAU:
            case BAMBOO_JUNGLE:
            case BAMBOO_JUNGLE_HILLS:
            case SOUL_SAND_VALLEY:
            case CRIMSON_FOREST:
            case WARPED_FOREST:
            case BASALT_DELTAS:
                return Temperature.HOT;
            case OCEAN:
            case MOUNTAINS:
            case THE_END:
            case FROZEN_OCEAN:
            case FROZEN_RIVER:
            case SNOWY_TUNDRA:
            case SNOWY_MOUNTAINS:
            case DEEP_OCEAN:
            case SNOWY_BEACH:
            case SNOWY_TAIGA:
            case SNOWY_TAIGA_HILLS:
            case SMALL_END_ISLANDS:
            case END_MIDLANDS:
            case END_HIGHLANDS:
            case END_BARRENS:
            case COLD_OCEAN:
            case DEEP_COLD_OCEAN:
            case DEEP_FROZEN_OCEAN:
            case THE_VOID:
            case ICE_SPIKES:
            case SNOWY_TAIGA_MOUNTAINS:
                return Temperature.COLD;
            case PLAINS:
            case FOREST:
            case TAIGA:
            case RIVER:
            case MUSHROOM_FIELDS:
            case MUSHROOM_FIELD_SHORE:
            case WOODED_HILLS:
            case TAIGA_HILLS:
            case MOUNTAIN_EDGE:
            case STONE_SHORE:
            case BIRCH_FOREST:
            case BIRCH_FOREST_HILLS:
            case DARK_FOREST:
            case GIANT_TREE_TAIGA:
            case GIANT_TREE_TAIGA_HILLS:
            case WOODED_MOUNTAINS:
            case SUNFLOWER_PLAINS:
            case GRAVELLY_MOUNTAINS:
            case FLOWER_FOREST:
            case TAIGA_MOUNTAINS:
            case TALL_BIRCH_FOREST:
            case TALL_BIRCH_HILLS:
            case DARK_FOREST_HILLS:
            case GIANT_SPRUCE_TAIGA:
            case GIANT_SPRUCE_TAIGA_HILLS:
            case MODIFIED_GRAVELLY_MOUNTAINS:
            case DRIPSTONE_CAVES:
            case LUSH_CAVES:
            case CUSTOM:
            default:
                return Temperature.NORMAL;
        }
    }

}
