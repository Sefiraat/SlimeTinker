package io.github.sefiraat.slimetinker.runnables.event;

import io.github.sefiraat.slimetinker.utils.BlockUtils;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class RemovePoweredState extends BukkitRunnable {

    private final Block block;
    private final Player player;

    public RemovePoweredState(Block block, Player player) {
        this.block = block;
        this.player = player;
    }

    @Override
    public void run() {
        for (Entity e : block.getWorld().getNearbyEntities(block.getLocation(), 1, 1, 1)) {
            if (e instanceof Player) {
                Player p = (Player) e;
                if (p.getUniqueId() == player.getUniqueId()) {
                    return;
                }
            }
        }
        unPower();
    }

    private void unPower() {
        BlockUtils.fakeUnPower(block);
        BlockUtils.fakeUnPower(block.getRelative(BlockFace.NORTH));
        BlockUtils.fakeUnPower(block.getRelative(BlockFace.SOUTH));
        BlockUtils.fakeUnPower(block.getRelative(BlockFace.EAST));
        BlockUtils.fakeUnPower(block.getRelative(BlockFace.WEST));
        BlockUtils.fakeUnPower(block.getRelative(BlockFace.DOWN));
        BlockUtils.fakeUnPower(block.getRelative(BlockFace.UP));
        this.cancel();
    }
}
