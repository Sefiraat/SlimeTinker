package io.github.sefiraat.slimetinker.runnables;

import io.github.sefiraat.slimetinker.SlimeTinker;
import lombok.Getter;

public class RunnableManager {

    @Getter
    private final EffectRunnable effectRunnable;
    @Getter
    private final FirstTick firstTick;

    public RunnableManager() {

        this.effectRunnable = new EffectRunnable();
        effectRunnable.runTaskTimer(SlimeTinker.inst(), 0, SlimeTinker.RUNNABLE_TICK_RATE);

        this.firstTick = new FirstTick();
        firstTick.runTaskLater(SlimeTinker.inst(), 1);

    }

}
