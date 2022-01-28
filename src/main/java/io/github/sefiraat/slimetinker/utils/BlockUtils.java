package io.github.sefiraat.slimetinker.utils;

import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.TileState;
import org.bukkit.block.data.AnaloguePowerable;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Lightable;
import org.bukkit.block.data.Powerable;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class BlockUtils {

    private BlockUtils() {
        throw new IllegalStateException("Utility class");
    }

    private static final Map<Location, Boolean> STATE_MAP = new HashMap<>();

    public static boolean isValidBreakEvent(Block block, Player player) {
        return !isPlaced(block)
            && !BlockStorage.hasBlockInfo(block)
            && !(block.getState() instanceof TileState)
            && Slimefun.getProtectionManager().hasPermission(player, block, Interaction.BREAK_BLOCK);
    }

    public static boolean isPlaced(Block block) {
        return STATE_MAP.getOrDefault(block.getLocation(), false);
    }

    /**
     * Credits : https://www.spigotmc.org/threads/getting-the-blockface-of-a-targeted-block.319181/
     * Gets the BlockFace of the block the player is currently targeting.
     *
     * @param player the player's whos targeted blocks BlockFace is to be checked.
     * @return the BlockFace of the targeted block, or null if the targeted block is non-occluding.
     */
    public static BlockFace getTargetedBlockFace(Player player) {
        List<Block> lastTwoTargetBlocks = player.getLastTwoTargetBlocks(null, 100);
        if (lastTwoTargetBlocks.size() != 2 || !lastTwoTargetBlocks.get(1).getType().isOccluding()) return null;
        Block targetBlock = lastTwoTargetBlocks.get(1);
        Block adjacentBlock = lastTwoTargetBlocks.get(0);
        return targetBlock.getFace(adjacentBlock);
    }

    public static void fakePower(Block block) {
        BlockData blockData = block.getBlockData();
        if (blockData instanceof Powerable) {
            ((Powerable) blockData).setPowered(true);
        } else if (blockData instanceof AnaloguePowerable) {
            ((AnaloguePowerable) blockData).setPower(15);
        } else if (blockData instanceof Lightable) {
            ((Lightable) blockData).setLit(true);
        }
        block.setBlockData(blockData);
    }

    public static void fakeUnPower(Block block) {
        BlockData blockData = block.getBlockData();
        if (blockData instanceof Powerable) {
            ((Powerable) blockData).setPowered(false);
        } else if (blockData instanceof AnaloguePowerable) {
            ((AnaloguePowerable) blockData).setPower(0);
        } else if (blockData instanceof Lightable) {
            ((Lightable) blockData).setLit(false);
        }
        block.setBlockData(blockData);
    }

    public static Map<Location, Boolean> getStateMap() {
        return STATE_MAP;
    }
}
