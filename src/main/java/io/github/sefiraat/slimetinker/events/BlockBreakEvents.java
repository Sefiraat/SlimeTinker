package io.github.sefiraat.slimetinker.events;

import org.bukkit.Bukkit;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class BlockBreakEvents {

    public static void headCorbronze(BlockBreakEventFriend friend) {
        Collection<ItemStack> newAddDrops = new ArrayList<>();

        Iterator<Recipe> recipeIterator = Bukkit.recipeIterator();
        while (recipeIterator.hasNext()) {
            Recipe recipe = recipeIterator.next();
            if (!(recipe instanceof FurnaceRecipe)) continue;
            for (ItemStack i : friend.getDrops()) {
                if (i.isSimilar(((FurnaceRecipe) recipe).getInput())) {
                    ItemStack ni = recipe.getResult().clone();
                    ni.setAmount(i.getAmount());
                    newAddDrops.add(ni);
                    friend.getRemoveDrops().add(i);
                    break;
                }
            }
            if (friend.getAddDrops().isEmpty()) continue;
            for (ItemStack i : friend.getAddDrops()) {
                if (i.isSimilar(((FurnaceRecipe) recipe).getInput())) {
                    ItemStack ni = recipe.getResult().clone();
                    ni.setAmount(i.getAmount());
                    newAddDrops.add(ni);
                    friend.getRemoveDrops().add(i);
                    break;
                }
            }

        }
        friend.getAddDrops().clear();
        friend.getAddDrops().addAll(newAddDrops);
    }

    public static void headCopper(BlockBreakEventFriend friend) {
        friend.setToolExpMod(friend.getToolExpMod() + 1);
    }

    public static void rodAluBrass(BlockBreakEventFriend friend) {
        friend.setToolExpMod(friend.getToolExpMod() + 0.5);
        friend.setPlayerExpMod(friend.getPlayerExpMod() + 0.5);
    }

    public static void rodAluminum(BlockBreakEventFriend friend) {
        friend.setToolExpMod(friend.getToolExpMod() + 0.5);
    }

    public static void headDuralium(BlockBreakEventFriend friend) {
        friend.setToolExpMod(0);
        friend.setDuraliumCheck(true);
    }

}
