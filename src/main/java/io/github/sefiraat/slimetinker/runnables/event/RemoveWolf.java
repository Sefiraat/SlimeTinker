package io.github.sefiraat.slimetinker.runnables.event;

import org.bukkit.entity.Wolf;
import org.bukkit.scheduler.BukkitRunnable;

public class RemoveWolf extends BukkitRunnable {

    private final Wolf wolf;

    public RemoveWolf(Wolf wolf) {
        this.wolf = wolf;
    }

    @Override
    public void run() {
        wolf.remove();
        this.cancel();
    }

}
