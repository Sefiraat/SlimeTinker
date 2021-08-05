package io.github.sefiraat.slimetinker.runnables.event;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Powerable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class RemoveMagmaBlock extends BukkitRunnable {

    private final Block block;
    private final Player player;

    public RemoveMagmaBlock(Block block, Player player) {
        this.block = block;
        this.player = player;
    }

    @Override
    public void run() {
        block.setType(Material.LAVA);
    }

}
