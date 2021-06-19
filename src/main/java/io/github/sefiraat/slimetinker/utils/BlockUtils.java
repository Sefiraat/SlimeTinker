package io.github.sefiraat.slimetinker.utils;

import org.bukkit.block.Block;

public final class BlockUtils {

    private BlockUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isPlaced(Block block) {
        return block.hasMetadata(IDStrings.PLACED);
    }
}
