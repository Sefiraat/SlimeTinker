package io.github.sefiraat.slimetinker;

import io.github.mooy1.infinitylib.AbstractAddon;
import io.github.mooy1.infinitylib.bstats.bukkit.Metrics;
import io.github.mooy1.infinitylib.commands.AbstractCommand;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.commands.AddExp;
import io.github.sefiraat.slimetinker.commands.GiveDummyTool;
import io.github.sefiraat.slimetinker.items.Alloys;
import io.github.sefiraat.slimetinker.items.Casts;
import io.github.sefiraat.slimetinker.items.Dies;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.Mods;
import io.github.sefiraat.slimetinker.items.Parts;
import io.github.sefiraat.slimetinker.items.Props;
import io.github.sefiraat.slimetinker.items.Tools;
import io.github.sefiraat.slimetinker.items.Workstations;
import io.github.sefiraat.slimetinker.listeners.ListenerManager;
import io.github.sefiraat.slimetinker.managers.RecipeManager;
import io.github.sefiraat.slimetinker.managers.RunnableManager;
import io.github.sefiraat.slimetinker.utils.Keys;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

public class SlimeTinker extends AbstractAddon {


    public static final int RUNNABLE_TICK_RATE = 60;

    private static SlimeTinker instance;
    public static SlimeTinker inst() {
        return instance;
    }

    @Getter
    private RecipeManager recipeManager;

    @Getter
    private RunnableManager runnableManager;

    @Getter
    private Keys keys;

    @Override
    public void onAddonEnable() {

        instance = this;
        keys = new Keys();

        getLogger().info("########################################");
        getLogger().info("              Slime Tinker              ");
        getLogger().info("           Created by Sefiraat          ");
        getLogger().info("########################################");

        Categories.set(this);
        Materials.set(this);
        Alloys.set(this);
        Props.set(this);
        Dies.set(this);
        Casts.set(this);
        Parts.set(this);
        Tools.set(this);
        Mods.set(this);
        Workstations.set(this);

        recipeManager = new RecipeManager();
        runnableManager = new RunnableManager();

        new ListenerManager(this, this.getServer().getPluginManager());

    }

    @Override
    protected void onAddonDisable() {
        saveConfig();
        instance = null;
    }

    @Override
    protected Metrics setupMetrics() {
        return new Metrics(this,11748);
    }



    @Nonnull
    @Override
    protected List<AbstractCommand> setupSubCommands() {
        return Arrays.asList(new GiveDummyTool(), new AddExp());
    }



    @Override
    protected @NotNull String getGithubPath() {
        return "Sefiraat/SlimeTinker/master";
    }

}
