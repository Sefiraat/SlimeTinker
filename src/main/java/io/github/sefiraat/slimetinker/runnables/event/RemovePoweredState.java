package io.github.sefiraat.slimetinker.runnables.event;

import org.bukkit.block.Block;
import org.bukkit.block.data.Powerable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class RemovePoweredState extends BukkitRunnable {

    private final Powerable block;
    private final Player player;

    public RemovePoweredState(Powerable block, Player player) {
        this.block = block;
        this.player = player;
    }

    @Override
    public void run() {
        Block b = (Block) block;
        for (Entity e : b.getWorld().getNearbyEntities(b.getLocation(), 1,1,1)) {
            if (e instanceof Player) {
                Player p = (Player) e;
                if (p.getUniqueId() != player.getUniqueId()) {
                    block.setPowered(false);
                    this.cancel();
                }
            }
        }
    }

}
