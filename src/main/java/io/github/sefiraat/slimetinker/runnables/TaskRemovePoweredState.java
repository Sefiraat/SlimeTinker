package io.github.sefiraat.slimetinker.runnables;

import org.bukkit.block.data.Powerable;
import org.bukkit.scheduler.BukkitRunnable;
import sun.jvm.hotspot.opto.Block;

public class TaskRemovePoweredState extends BukkitRunnable {

    private final Powerable block;

    public TaskRemovePoweredState(Powerable block) {
        this.block = block;
    }

    @Override
    public void run() {
        block.setPowered(false);
    }

}
