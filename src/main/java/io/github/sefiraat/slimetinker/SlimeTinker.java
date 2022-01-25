package io.github.sefiraat.slimetinker;

import io.github.mooy1.infinitylib.core.AbstractAddon;
import io.github.sefiraat.slimetinker.itemgroups.ItemGroups;
import io.github.sefiraat.slimetinker.items.Casts;
import io.github.sefiraat.slimetinker.items.Dies;
import io.github.sefiraat.slimetinker.items.Guide;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.Mods;
import io.github.sefiraat.slimetinker.items.Parts;
import io.github.sefiraat.slimetinker.items.Workstations;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMManager;
import io.github.sefiraat.slimetinker.items.workstations.workbench.Workbench;
import io.github.sefiraat.slimetinker.listeners.ListenerManager;
import io.github.sefiraat.slimetinker.managers.DispatchManager;
import io.github.sefiraat.slimetinker.managers.TraitManager;
import io.github.sefiraat.slimetinker.runnables.RunnableManager;
import org.bstats.bukkit.Metrics;

public class SlimeTinker extends AbstractAddon {

    public static final int RUNNABLE_TICK_RATE = 40;

    private static SlimeTinker instance;


    private RunnableManager runnableManager;
    private ListenerManager listenerManager;
    private CMManager cmManager;
    private DispatchManager dispatchManager;

    public Workbench getWorkbench() {
        return workbench;
    }

    public void setWorkbench(Workbench workbench) {
        this.workbench = workbench;
    }

    private Workbench workbench;
    private TraitManager traitManager;

    public SlimeTinker() {
        super("Sefiraat", "SlimeTinker", "master", "auto-update");
    }

    public static SlimeTinker inst() {
        return instance;
    }

    @Override
    public void enable() {

        new Metrics(this, 11748);

        instance = this;

        getLogger().info("########################################");
        getLogger().info("   Slime Tinker - Created by Sefiraat   ");
        getLogger().info("########################################");

        ItemGroups.set(this);
        Materials.set(this);
        Dies.set(this);
        Casts.set(this);
        Parts.set(this);
        Guide.set(this);
        Mods.set(this);
        Workstations.set(this);

        traitManager = new TraitManager();
        cmManager = new CMManager();
        runnableManager = new RunnableManager();
        dispatchManager = new DispatchManager();

        this.listenerManager = new ListenerManager(this, this.getServer().getPluginManager());

    }

    @Override
    protected void disable() {
        saveConfig();
        instance = null;
    }

    public static SlimeTinker getInstance() {
        return instance;
    }

    public RunnableManager getRunnableManager() {
        return runnableManager;
    }

    public ListenerManager getListenerManager() {
        return listenerManager;
    }

    public CMManager getCmManager() {
        return cmManager;
    }

    public DispatchManager getDispatchManager() {
        return dispatchManager;
    }

    public TraitManager getTraitManager() {
        return traitManager;
    }

}
