package io.github.sefiraat.slimetinker;

import io.github.mooy1.infinitylib.AbstractAddon;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.Casts;
import io.github.sefiraat.slimetinker.items.Machines;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.recipes.RecipeManager;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public class SlimeTinker extends AbstractAddon {

    private static SlimeTinker instance;
    public static SlimeTinker inst() {
        return instance;
    }

    @Getter
    private RecipeManager recipeManager;

    @Override
    public void onAddonEnable() {
        instance = this;

        getLogger().info("########################################");
        getLogger().info("              Slime Tinker              ");
        getLogger().info("           Created by Sefiraat          ");
        getLogger().info("########################################");

        recipeManager = new RecipeManager();

        Categories.set(this);
        Materials.set(this);
        Machines.set(this);
        Casts.set(this);

    }

    @Override
    protected void onAddonDisable() {
        saveConfig();
        instance = null;
    }

    @Override
    protected @NotNull String getGithubPath() {
        return "Sefiraat/SlimeTinker/master";
    }

}
