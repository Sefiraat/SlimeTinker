package io.github.sefiraat.slimetinker.utils;

import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.block.Block;
import org.bukkit.block.Container;

@UtilityClass
public final class BlockUtils {

    public static boolean isValidBreakEvent(Block block) {
        return !isPlaced(block) && !BlockStorage.hasBlockInfo(block) && !(block instanceof Container);
    }

    public static boolean isPlaced(Block block) {
        return block.hasMetadata(IDStrings.PLACED);
    }

}
