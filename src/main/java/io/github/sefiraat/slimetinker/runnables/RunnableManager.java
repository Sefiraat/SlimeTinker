package io.github.sefiraat.slimetinker.runnables;

import io.github.sefiraat.slimetinker.SlimeTinker;

public class RunnableManager {

    private final EffectTick effectTick;
    private final ArmourRemove armourRemove;
    private final FirstTick firstTick;

    public RunnableManager() {
        this.effectTick = new EffectTick();
        effectTick.runTaskTimer(SlimeTinker.inst(), 0, SlimeTinker.RUNNABLE_TICK_RATE);

        this.armourRemove = new ArmourRemove();
        armourRemove.runTaskTimer(SlimeTinker.inst(), 0, SlimeTinker.RUNNABLE_TICK_RATE);

        this.firstTick = new FirstTick();
        firstTick.runTaskLater(SlimeTinker.inst(), 1);
    }

    public EffectTick getEffectTick() {
        return effectTick;
    }

    public ArmourRemove getArmourRemove() {
        return armourRemove;
    }

    public FirstTick getFirstTick() {
        return firstTick;
    }
}
