package io.github.sefiraat.slimetinker.runnables;

import io.github.sefiraat.slimetinker.SlimeTinker;
import lombok.Getter;

public class RunnableManager {

    @Getter
    private final EffectTick effectTick;
    @Getter
    private final ArmourRemove armourRemove;
    @Getter
    private final FirstTick firstTick;

    public RunnableManager() {

        this.effectTick = new EffectTick();
        effectTick.runTaskTimer(SlimeTinker.inst(), 0, SlimeTinker.RUNNABLE_TICK_RATE);

        this.armourRemove = new ArmourRemove();
        armourRemove.runTaskTimer(SlimeTinker.inst(), 0, SlimeTinker.RUNNABLE_TICK_RATE);

        this.firstTick = new FirstTick();
        firstTick.runTaskLater(SlimeTinker.inst(), 1);

    }

}
