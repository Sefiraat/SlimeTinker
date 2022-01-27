package io.github.sefiraat.slimetinker.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.concurrent.ThreadLocalRandom;

public final class WorldUtils {

    private WorldUtils() {
        throw new UnsupportedOperationException("Utility Class");
    }

    public static void dropItem(ItemStack i, @Nonnull Player p) {
        dropItem(p.getWorld(), p.getLocation(), i);
    }

    public static void dropItem(ItemStack i, @Nonnull Location l) {
        dropItem(l.getWorld(), l, i);
    }

    public static void dropItem(ItemStack i, @Nonnull Block b) {
        dropItem(b.getWorld(), b.getLocation(), i);
    }

    public static void dropItem(@Nonnull World w, Location l, ItemStack i) {
        w.dropItemNaturally(l, i);
    }

    @Nonnull
    public static Location getMid(@Nonnull World world, double x1, double y1, double z1, double x2, double y2, double z2) {
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
    public static Block getRandomBlockInRange(@Nonnull Location l, int boundX, int boundY, int boundZ, boolean allowAir) {
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
    public static Block getRandomBlockInRange(@Nonnull Player p, int boundX, int boundY, int boundZ, boolean allowAir) {
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
    public static Block getRandomBlockInRange(@Nonnull Block b, int boundX, int boundY, int boundZ, boolean allowAir) {
        return getRandomBlockInRange(b.getLocation(), boundX, boundY, boundZ, allowAir, 1);
    }

    @Nullable
    private static Block getRandomBlockInRange(@Nonnull Location l, int boundX, int boundY, int boundZ, boolean allowAir, int ittr) {
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
