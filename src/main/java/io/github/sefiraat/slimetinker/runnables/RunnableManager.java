package io.github.sefiraat.slimetinker.runnables;

import io.github.sefiraat.slimetinker.SlimeTinker;
import lombok.Getter;

public class RunnableManager {

    @Getter
    private final EffectRunnable effectRunnable;


    public RunnableManager() {
        this.effectRunnable = new EffectRunnable();
        effectRunnable.runTaskTimer(SlimeTinker.inst(), 0, SlimeTinker.RUNNABLE_TICK_RATE);
    }
}
