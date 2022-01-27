package io.github.sefiraat.slimetinker.runnables;

import io.github.sefiraat.slimetinker.SlimeTinker;

public class RunnableManager {

    private final EffectTick effectTick;
    private final ArmourRemove armourRemove;
    private final FirstTick firstTick;

    public RunnableManager() {
        final SlimeTinker plugin = SlimeTinker.getInstance();

        this.effectTick = new EffectTick();
        effectTick.runTaskTimer(plugin, 0, SlimeTinker.RUNNABLE_TICK_RATE);

        this.armourRemove = new ArmourRemove();
        armourRemove.runTaskTimer(plugin, 0, SlimeTinker.RUNNABLE_TICK_RATE);

        this.firstTick = new FirstTick();
        firstTick.runTaskLater(plugin, 1);
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
