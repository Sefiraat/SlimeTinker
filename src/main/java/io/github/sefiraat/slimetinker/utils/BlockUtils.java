package io.github.sefiraat.slimetinker.utils;

import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Container;

import javax.annotation.Nullable;
import java.util.concurrent.ThreadLocalRandom;

@UtilityClass
public final class BlockUtils {

    public static boolean isValidBreakEvent(Block block) {
        return !isPlaced(block) && !BlockStorage.hasBlockInfo(block) && !(block instanceof Container);
    }

    public static boolean isPlaced(Block block) {
        return block.hasMetadata(IDStrings.PLACED);
    }

    public static Location getMid(World world, double x1, double y1, double z1, double x2, double y2, double z2) {
        return new Location(world,x1 + (x2 - x1) * 0.5, y1 + (y2 - y1) * 0.5, z1 + (z2 - z1) * 0.5);
    }

    /**
     * Scans the given bounds range around the given location for a random block
     * If allowAir is false then will try max 50 times then return null
     * @param l
     * @param boundX
     * @param boundY
     * @param boundZ
     * @return
     */
    @Nullable
    public static Block getRandomBlockInRange(Location l, int boundX, int boundY, int boundZ, boolean allowAir) {
        return getRandomBlockInRange(l, boundX, boundY, boundZ, allowAir, 1);
    }

    @Nullable
    private static Block getRandomBlockInRange(Location l, int boundX, int boundY, int boundZ, boolean allowAir, int ittr) {
        if (ittr > 50) {
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

}
