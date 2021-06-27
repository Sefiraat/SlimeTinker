package io.github.sefiraat.slimetinker.runnables;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.scheduler.BukkitRunnable;

public class FirstTick extends BukkitRunnable {

    @Override
    public void run() {
        for (SlimefunItem i : SlimefunPlugin.getRegistry().getAllSlimefunItems()) {
            if (i.getRecipeType() == RecipeType.ENHANCED_CRAFTING_TABLE) {
                SlimeTinker.inst().getWorkbench().getCraftingRecipes().put(i.getRecipe(), i.getItem());
            }
        }
    }

}
