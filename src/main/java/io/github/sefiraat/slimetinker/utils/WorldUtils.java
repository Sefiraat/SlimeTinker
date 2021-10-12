package io.github.sefiraat.slimetinker.utils;

import io.github.sefiraat.slimetinker.utils.enums.Temperature;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang.Validate;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.concurrent.ThreadLocalRandom;

@UtilityClass
public class WorldUtils {

    public static void dropItem(ItemStack i, Player p) {
        dropItem(p.getWorld(), p.getLocation(), i);
    }

    public static void dropItem(ItemStack i, Location l) {
        Validate.notNull(l.getWorld(), "Location doesn't have a world");
        dropItem(l.getWorld(), l, i);
    }

    public static void dropItem(ItemStack i, Block b) {
        dropItem(b.getWorld(), b.getLocation(), i);
    }

    public static void dropItem(World w, Location l, ItemStack i) {
        w.dropItemNaturally(l, i);
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

    public static Location getMid(World world, double x1, double y1, double z1, double x2, double y2, double z2) {
        return new Location(world, x1 + (x2 - x1) * 0.5, y1 + (y2 - y1) * 0.5, z1 + (z2 - z1) * 0.5);
    }

    /**
     * Scans the given bounds range around the given location for a random block
     * If allowAir is false then will try max 50 times then return null
     *
     * @param l      {@link Location} to start looking from
     * @param boundX The maximum distance on the X axis
     * @param boundY The maximum distance on the Y axis
     * @param boundZ The maximum distance on the Z axis
     * @return The found, random, {@link Block}
     */
    @Nullable
    public static Block getRandomBlockInRange(Location l, int boundX, int boundY, int boundZ, boolean allowAir) {
        return getRandomBlockInRange(l, boundX, boundY, boundZ, allowAir, 1);
    }

    /**
     * Scans the given bounds range around the given location for a random block
     * If allowAir is false then will try max 50 times then return null
     *
     * @param p      {@link Player} to start looking from
     * @param boundX The maximum distance on the X axis
     * @param boundY The maximum distance on the Y axis
     * @param boundZ The maximum distance on the Z axis
     * @return The found, random, {@link Block}
     */
    @Nullable
    public static Block getRandomBlockInRange(Player p, int boundX, int boundY, int boundZ, boolean allowAir) {
        return getRandomBlockInRange(p.getLocation(), boundX, boundY, boundZ, allowAir, 1);
    }

    /**
     * Scans the given bounds range around the given location for a random block
     * If allowAir is false then will try max 50 times then return null
     *
     * @param b      {@link Block} to start looking from
     * @param boundX The maximum distance on the X axis
     * @param boundY The maximum distance on the Y axis
     * @param boundZ The maximum distance on the Z axis
     * @return The found, random, {@link Block}
     */
    @Nullable
    public static Block getRandomBlockInRange(Block b, int boundX, int boundY, int boundZ, boolean allowAir) {
        return getRandomBlockInRange(b.getLocation(), boundX, boundY, boundZ, allowAir, 1);
    }

    @Nullable
    private static Block getRandomBlockInRange(Location l, int boundX, int boundY, int boundZ, boolean allowAir, int ittr) {
        if (ittr < 50) {
            int rndX = ThreadLocalRandom.current().nextInt(-boundX, boundX + 1);
            int rndY = ThreadLocalRandom.current().nextInt(-boundY, boundY + 1);
            int rndZ = ThreadLocalRandom.current().nextInt(-boundZ, boundZ + 1);
            Block b = l.getBlock().getRelative(rndX, rndY, rndZ);
            if (allowAir || b.getType() != Material.AIR) {
                return b;
            }
            return getRandomBlockInRange(l, boundX, boundY, boundZ, false, ittr + 1);
        } else {
            return null;
        }
    }

    /**
     * Scans the given bounds range around the given location for a random location
     *
     * @param b      {@link Block} to start looking from
     * @param boundX The maximum distance on the X axis
     * @param boundY The maximum distance on the Y axis
     * @param boundZ The maximum distance on the Z axis
     * @return The found, random, {@link Location}
     */
    @Nonnull
    public static Location getRandomLocationInRange(@Nonnull Block b, int boundX, int boundY, int boundZ) {
        return getRandomLocationInRange(b.getLocation(), boundX, boundY, boundZ);
    }

    /**
     * Scans the given bounds range around the given location for a random location
     *
     * @param e      {@link Entity} to start looking from
     * @param boundX The maximum distance on the X axis
     * @param boundY The maximum distance on the Y axis
     * @param boundZ The maximum distance on the Z axis
     * @return The found, random, {@link Location}
     */
    @Nonnull
    public static Location getRandomLocationInRange(@Nonnull Entity e, int boundX, int boundY, int boundZ) {
        return getRandomLocationInRange(e.getLocation(), boundX, boundY, boundZ);
    }

    /**
     * Scans the given bounds range around the given location for a random location
     *
     * @param l      {@link Location} to start looking from
     * @param boundX The maximum distance on the X axis
     * @param boundY The maximum distance on the Y axis
     * @param boundZ The maximum distance on the Z axis
     * @return The found, random, {@link Location}
     */
    @Nonnull
    public static Location getRandomLocationInRange(@Nonnull Location l, int boundX, int boundY, int boundZ) {
        int rndX = ThreadLocalRandom.current().nextInt(-boundX, boundX + 1);
        int rndY = ThreadLocalRandom.current().nextInt(-boundY, boundY + 1);
        int rndZ = ThreadLocalRandom.current().nextInt(-boundZ, boundZ + 1);
        return l.clone().add(rndX, rndY, rndZ);
    }
}
