package io.github.sefiraat.slimetinker.events;

import io.github.sefiraat.slimetinker.events.friend.EventFriend;
import io.github.sefiraat.slimetinker.listeners.BlockMap;
import io.github.sefiraat.slimetinker.utils.GeneralUtils;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.utils.tags.SlimefunTag;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public final class BlockBreakEvents {

    private BlockBreakEvents() {
        throw new UnsupportedOperationException("Utility Class");
    }

    public static void headNice(EventFriend friend) {
        friend.getPlayer().sendMessage(ThemeUtils.WARNING + "Nice");
    }

    public static void headCorbronze(EventFriend friend) {
        Collection<ItemStack> newDrops = new ArrayList<>(friend.getAddDrops());

        Iterator<Recipe> recipeIterator = Bukkit.recipeIterator();
        while (recipeIterator.hasNext()) {
            Recipe recipe = recipeIterator.next();
            if (!(recipe instanceof FurnaceRecipe)) continue;
            FurnaceRecipe furnaceRecipe = (FurnaceRecipe) recipe;
            for (ItemStack i : friend.getDrops()) {
                if (furnaceRecipe.getInputChoice().test(i)) {
                    ItemStack ni = recipe.getResult().clone();
                    ni.setAmount(i.getAmount());
                    newDrops.add(ni);
                    friend.getRemoveDrops().add(i);
                    Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(130, 100, 30), 2);
                    friend.getBlock().getWorld().spawnParticle(Particle.REDSTONE, friend.getBlock().getLocation(), 10, 0.2, 0.2, 0.2, 0.5, dustOptions);
                    break;
                }
            }
            if (friend.getAddDrops().isEmpty()) continue;
            for (ItemStack i : friend.getAddDrops()) {
                if (i.isSimilar(((FurnaceRecipe) recipe).getInput())) {
                    ItemStack ni = recipe.getResult().clone();
                    ni.setAmount(i.getAmount());
                    newDrops.add(ni);
                    friend.getRemoveDrops().add(i);
                    break;
                }
            }
        }
        friend.setAddDrops(newDrops);
    }

    public static void headCopper(EventFriend friend) {
        friend.setToolExpMod(friend.getToolExpMod() + 1);
    }

    public static void rodAluBrass(EventFriend friend) {
        friend.setToolExpMod(friend.getToolExpMod() + 0.5);
        friend.setPlayerExpMod(friend.getPlayerExpMod() + 0.5);
    }

    public static void rodAluminum(EventFriend friend) {
        friend.setToolExpMod(friend.getToolExpMod() + 0.5);
    }

    public static void headDuralium(EventFriend friend) {
        friend.setToolExpMod(0);
    }

    public static void headSingCopper(EventFriend friend) {
        friend.setToolExpMod(friend.getToolExpMod() + 2);
    }

    public static void headSingInfinity(EventFriend friend) {
        friend.setToolExpMod(friend.getToolExpMod() + 2);
    }

    public static void rodMetal(EventFriend friend) {
        friend.setMetalCheck(true);
    }

    public static void headFortune(EventFriend friend) {
        Collection<ItemStack> c = new ArrayList<>(friend.getAddDrops());

        for (ItemStack i : friend.getDrops()) {
            if (i.getAmount() > 1) {
                ItemStack i2 = i.clone();
                i2.setAmount(i.getAmount() * 2);
                c.add(i2);
                friend.getRemoveDrops().add(i);
            }
        }
        friend.setAddDrops(c);
        Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(130, 30, 120), 2);
        friend.getBlock().getWorld().spawnParticle(Particle.REDSTONE, friend.getBlock().getLocation(), 10, 0.2, 0.2, 0.2, 0.5, dustOptions);
    }

    public static void rodEarth(EventFriend friend) {
        Collection<ItemStack> c = new ArrayList<>(friend.getAddDrops());
        for (ItemStack i : friend.getDrops()) {
            Material m = null;
            int amount = 1;
            switch (i.getType()) {
                case COBBLESTONE:
                case ANDESITE:
                case GRANITE:
                case DIORITE:
                    m = Material.GRAVEL;
                    break;
                case BONE_BLOCK:
                    m = Material.BONE_MEAL;
                    amount = 9;
                    break;
                case SANDSTONE:
                    m = Material.SAND;
                    amount = 4;
                    break;
                case RED_SANDSTONE:
                    m = Material.RED_SAND;
                    amount = 4;
                    break;
                case PRISMARINE_BRICKS:
                    m = Material.PRISMARINE;
                    amount = 2;
                    break;
                case PRISMARINE:
                    m = Material.PRISMARINE_SHARD;
                    amount = 4;
                    break;
                case NETHER_WART_BLOCK:
                    m = Material.NETHER_WART;
                    amount = 9;
                    break;
                case QUARTZ_BLOCK:
                    m = Material.QUARTZ;
                    amount = 4;
                    break;
                default:
                    break;
            }
            if (m != null) {
                c.add(new ItemStack(m, amount));
                friend.getRemoveDrops().add(i);
            }
            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(30, 130, 40), 2);
            friend.getBlock().getWorld().spawnParticle(Particle.REDSTONE, friend.getBlock().getLocation(), 10, 0.2, 0.2, 0.2, 0.5, dustOptions);
        }
        friend.setAddDrops(c);
    }

    public static void headMagnonium(EventFriend friend) {
        if (ThreadLocalRandom.current().nextInt(1, 6) == 1) {
            friend.getPlayer().dropItem(true);
        }
    }

    public static void headAdamantite(EventFriend friend) {
        friend.setPlayerExpMod(friend.getPlayerExpMod() + 1);
    }

    public static void rodSingAluminum(EventFriend friend) {
        friend.setToolExpMod(friend.getToolExpMod() + 1);
    }

    public static void headVoid(EventFriend friend) {
        String toolType = ItemUtils.getToolTypeName(friend.getTool());
        Map<Material, String> m = BlockMap.getMaterialMap();
        Block b = friend.getBlock();
        if (m.containsKey(b.getType()) && m.get(b.getType()).equals(toolType) && GeneralUtils.testChance(1, 10)) {
            ItemStack i;
            int rnd2 = GeneralUtils.roll(1000);
            if (rnd2 > 975) {
                i = new ItemStack(Material.ANCIENT_DEBRIS);
            } else if (rnd2 > 900) {
                i = new ItemStack(Material.DIAMOND);
            } else if (rnd2 > 800) {
                i = new ItemStack(Material.LAPIS_LAZULI);
            } else if (rnd2 > 700) {
                i = new ItemStack(Material.REDSTONE);
            } else if (rnd2 > 550) {
                i = new ItemStack(Material.GOLD_ORE);
            } else if (rnd2 > 400) {
                i = new ItemStack(Material.IRON_ORE);
            } else {
                i = new ItemStack(Material.COAL);
            }
            friend.getAddDrops().add(i);
            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(60, 60, 60), 2);
            friend.getBlock().getWorld().spawnParticle(Particle.REDSTONE, friend.getBlock().getLocation(), 10, 0.2, 0.2, 0.2, 0.5, dustOptions);
        }
    }

    public static void headUnpatentabilum(EventFriend friend) {
        if (GeneralUtils.day(friend.getPlayer().getWorld())) {
            friend.setPlayerExpMod(friend.getPlayerExpMod() + 1);
            friend.setToolExpMod(friend.getToolExpMod() + 1);
        }
    }

    public static void headReinforcedSlimesteel(EventFriend friend) {
        friend.setBlocksIntoInv(true);
    }

    public static void bindSilicon(EventFriend friend) {
        friend.setToolExpMod(friend.getToolExpMod() + (friend.getToolExpMod() * (friend.getActiveLevel() * 0.05)));
    }

    public static void headScrap(EventFriend friend) {
        friend.setToolExpMod(0);
    }

    public static void linksHardened(EventFriend friend) {
        List<SlimefunItemStack> list = Arrays.asList(
            SlimefunItems.MAGIC_LUMP_1,
            SlimefunItems.MAGIC_LUMP_2,
            SlimefunItems.ENDER_LUMP_1,
            SlimefunItems.ENDER_LUMP_2,
            SlimefunItems.PURE_ORE_CLUSTER,
            SlimefunItems.SIFTED_ORE,
            SlimefunItems.GILDED_IRON,
            SlimefunItems.CARBON,
            SlimefunItems.COMPRESSED_CARBON,
            SlimefunItems.CARBON_CHUNK
        );
        if (GeneralUtils.testChance(1, 200)) {
            friend.getAddDrops().add(list.get(GeneralUtils.roll(list.size(), false)));
        }
    }

    public static void plateBronze(EventFriend friend) {
        Block b = friend.getBlock();
        if (SlimefunTag.CROPS.isTagged(b.getType())) {
            Optional<ItemStack> opStack = b.getDrops().stream().findFirst();
            if (opStack.isPresent()) {
                ItemStack i = opStack.get();
                i.setAmount(1);
                b.getWorld().dropItem(b.getLocation().clone().add(0.5, 0.5, 0.5), i);
            }
        }
    }

    public static void linksAdamantite(EventFriend friend) {
        friend.incrementItemExpMod(0.1);
        friend.setPlayerExpMod(friend.getPlayerExpMod() + 0.1);
    }

    public static void binderLeather(EventFriend friend) {
        friend.incrementItemExpMod(0.5);
    }
}
