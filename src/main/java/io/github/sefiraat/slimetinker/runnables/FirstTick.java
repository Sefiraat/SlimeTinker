package io.github.sefiraat.slimetinker.runnables;

import io.github.sefiraat.slimetinker.SlimeTinker;
import org.bukkit.scheduler.BukkitRunnable;

public class FirstTick extends BukkitRunnable {

    @Override
    public void run() {
        SlimeTinker.inst().getWorkbench().setupSFRecipes();
    }

}
