package io.github.sefiraat.slimetinker.events;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.events.friend.EventFriend;
import io.github.sefiraat.slimetinker.utils.BlockUtils;
import io.github.sefiraat.slimetinker.utils.EntityUtils;
import io.github.sefiraat.slimetinker.utils.GeneralUtils;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.cscorelib2.protection.ProtectableAction;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Wither;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static io.github.sefiraat.slimetinker.utils.EntityUtils.increaseEffect;

@UtilityClass
public final class TickEvents {

    public static void rodGold(EventFriend friend) {
        increaseEffect(PotionEffectType.GLOWING, friend.getPotionEffects());
    }

    public static void binderTwistingVine(EventFriend friend) {
        for (Entity entity : friend.getPlayer().getNearbyEntities(5,5,5)) {
            if (entity instanceof Item) {
                Location eLoc = entity.getLocation();
                Location pLoc = friend.getPlayer().getLocation();
                entity.teleport(BlockUtils.getMid(eLoc.getWorld(), eLoc.getX(), eLoc.getY(), eLoc.getZ(), pLoc.getX(), pLoc.getY(), pLoc.getZ()));
            }
        }
    }

    public static void rodTin(EventFriend friend) {
        increaseEffect(PotionEffectType.SATURATION, friend.getPotionEffects());
    }

    public static void binderCrimsonRoot(EventFriend friend) {
        if (!GeneralUtils.day(friend.getPlayer().getWorld())) {
            int rnd = ThreadLocalRandom.current().nextInt(1,5);
            if (rnd == 1) {
                ItemUtils.incrementRepair(friend.getHeldItem());
            }
        }
    }

    public static void binderWeepingVine(EventFriend friend) {
        increaseEffect(PotionEffectType.BAD_OMEN, friend.getPotionEffects());
    }

    public static void headBillon(EventFriend friend) {
        increaseEffect(PotionEffectType.FAST_DIGGING, friend.getPotionEffects());
    }

    public static void headGold(EventFriend friend) {
        increaseEffect(PotionEffectType.INVISIBILITY, friend.getPotionEffects());
    }

    public static void headZinc(EventFriend friend) {
        increaseEffect(PotionEffectType.DOLPHINS_GRACE, friend.getPotionEffects());
    }

    public static void binderVine(EventFriend friend) {
        if (GeneralUtils.day(friend.getPlayer().getWorld())) {
            int rnd = ThreadLocalRandom.current().nextInt(1,5);
            if (rnd == 1) {
                ItemUtils.incrementRepair(friend.getHeldItem());
            }
        }
    }

    public static void headSolder(EventFriend friend) {
        increaseEffect(PotionEffectType.INVISIBILITY, friend.getPotionEffects());
    }

    public static void rodBronze(EventFriend friend) {
        increaseEffect(PotionEffectType.WITHER, friend.getPotionEffects());
    }

    public static void rodLead(EventFriend friend) {
        increaseEffect(PotionEffectType.HEALTH_BOOST, friend.getPotionEffects(), 2);
        increaseEffect(PotionEffectType.HUNGER, friend.getPotionEffects());
    }

    public static void rodMagnesium(EventFriend friend) {
        for (Entity entity : friend.getPlayer().getNearbyEntities(10,10,10)) {
            if (entity instanceof Item && ThreadLocalRandom.current().nextInt(1,3) == 1) {
                entity.teleport(friend.getPlayer().getLocation());
            }
        }
    }

    public static void headTin(EventFriend friend) {
        increaseEffect(PotionEffectType.LUCK, friend.getPotionEffects());
    }

    public static void rodDamsteel(EventFriend friend) {
        increaseEffect(PotionEffectType.NIGHT_VISION, friend.getPotionEffects());
    }

    public static void rodBrass(EventFriend friend) {
        increaseEffect(PotionEffectType.WATER_BREATHING, friend.getPotionEffects());
    }

    public static void bindWarpedRoot(EventFriend friend) {
        int rnd = ThreadLocalRandom.current().nextInt(1,5);
        if (rnd == 1) {
            friend.getPlayer().setHealth(Math.min(friend.getPlayer().getHealth() + 1, friend.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()));
        }
    }

    public static void headBronze(EventFriend friend) {
        increaseEffect(PotionEffectType.FIRE_RESISTANCE, friend.getPotionEffects());
    }

    public static void rodIron(EventFriend friend) {
        increaseEffect(PotionEffectType.INCREASE_DAMAGE, friend.getPotionEffects());
    }

    public static void headAlubronze(EventFriend friend) {
        increaseEffect(PotionEffectType.INCREASE_DAMAGE, friend.getPotionEffects());
    }

    public static void rodSilver(EventFriend friend) {
        increaseEffect(PotionEffectType.SLOW_FALLING, friend.getPotionEffects(), 2);
    }

    public static void rodBillon(EventFriend friend) {
        increaseEffect(PotionEffectType.JUMP, friend.getPotionEffects(), 3);
    }

    public static void headBrass(EventFriend friend) {
        increaseEffect(PotionEffectType.UNLUCK, friend.getPotionEffects(), 2);
    }

    public static void rodZinc(EventFriend friend) {
        if (!friend.getPlayer().isSneaking()) {
            increaseEffect(PotionEffectType.LEVITATION, friend.getPotionEffects(), 1);
        }
    }

    public static void rodCorbronze(EventFriend friend) {
        increaseEffect(PotionEffectType.CONFUSION, friend.getPotionEffects());
    }

    public static void headDuralium(EventFriend friend) {
        if (ItemUtils.isTinkersBroken(friend.getHeldItem())) {
            increaseEffect(PotionEffectType.SLOW_DIGGING, friend.getPotionEffects());
        }
    }

    public static void rodSingGold(EventFriend friend) {
        increaseEffect(PotionEffectType.GLOWING, friend.getPotionEffects());
    }

    public static void rodSingTin(EventFriend friend) {
        increaseEffect(PotionEffectType.SATURATION, friend.getPotionEffects(), 2);
    }

    public static void headMetal(EventFriend friend) {
        increaseEffect(PotionEffectType.FAST_DIGGING, friend.getPotionEffects(), 1);
    }

    public static void headMythril(EventFriend friend) {
        increaseEffect(PotionEffectType.FAST_DIGGING, friend.getPotionEffects(), 1);
        increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects());
    }

    public static void headSingGold(EventFriend friend) {
        increaseEffect(PotionEffectType.INVISIBILITY, friend.getPotionEffects(), 1);
    }

    public static void headSingZinc(EventFriend friend) {
        increaseEffect(PotionEffectType.DOLPHINS_GRACE, friend.getPotionEffects(), 1);
    }

    public static void rodSingLead(EventFriend friend) {
        increaseEffect(PotionEffectType.HEALTH_BOOST, friend.getPotionEffects(), 1);
    }

    public static void rodSingMagnesium(EventFriend friend) {
        for (Entity entity : friend.getPlayer().getNearbyEntities(10,10,10)) {
            if (entity instanceof Item) {
                Location eLoc = entity.getLocation();
                Location pLoc = friend.getPlayer().getLocation();
                entity.teleport(BlockUtils.getMid(eLoc.getWorld(), eLoc.getX(), eLoc.getY(), eLoc.getZ(), pLoc.getX(), pLoc.getY(), pLoc.getZ()));
            }
        }
    }

    public static void headSingTin(EventFriend friend) {
        increaseEffect(PotionEffectType.LUCK, friend.getPotionEffects(), 1);
        increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects(), 1);
    }

    public static void rodFortune(EventFriend friend) {
        increaseEffect(PotionEffectType.INVISIBILITY, friend.getPotionEffects(), 2);
    }

    public static void rodMagic(EventFriend friend) {
        for (Entity entity : friend.getPlayer().getNearbyEntities(10,10,10)) {
            if (entity instanceof LivingEntity) {
                LivingEntity l = (LivingEntity) entity;
                l.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, SlimeTinker.RUNNABLE_TICK_RATE + 5, 0));
            }
        }
    }

    public static void rodSingIron(EventFriend friend) {
        increaseEffect(PotionEffectType.INCREASE_DAMAGE, friend.getPotionEffects(), 1);
    }

    public static void rodMythril(EventFriend friend) {
        for (Entity entity : friend.getPlayer().getNearbyEntities(5,5,5)) {
            if (entity instanceof Monster && (entity.getType() != EntityType.WITHER && entity.getType() != EntityType.ENDER_DRAGON)) {
                Monster l = (Monster) entity;
                EntityUtils.push(l, friend.getPlayer().getLocation(), 0.2);
            }
        }
    }

    public static void rodSingZinc(EventFriend friend) {
        if (friend.getPlayer().isSneaking()) {
            increaseEffect(PotionEffectType.LEVITATION, friend.getPotionEffects(), 1);
        }
    }

    public static void headMagic(EventFriend friend) {
        for (Entity entity : friend.getPlayer().getNearbyEntities(5,5,5)) {
            int rnd = ThreadLocalRandom.current().nextInt(1, 10);
            if (entity instanceof LivingEntity) {
                LivingEntity l = (LivingEntity) entity;
                switch (rnd) {
                    case 1:
                        EntityUtils.push(l, friend.getPlayer().getLocation(), 3);
                        break;
                    case 2:
                        l.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 0, true, true, false));
                        break;
                    case 3:
                        int rndX = ThreadLocalRandom.current().nextInt(-25,26);
                        int rndY = ThreadLocalRandom.current().nextInt(0,5);
                        int rndZ = ThreadLocalRandom.current().nextInt(-25,26);
                        Location location = l.getLocation().clone().add(rndX, rndY, rndZ);
                        if (entity.getWorld().getBlockAt(location).getType() == Material.AIR) {
                            entity.teleport(location);
                            entity.getWorld().playEffect(friend.getPlayer().getLocation(), Effect.ENDEREYE_LAUNCH, 10);
                        }
                        break;
                    case 4:
                        l.setFireTicks(40);
                        break;
                    case 5:
                        l.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 4, true, true, false));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public static void rodSegganesson(EventFriend friend) {
        increaseEffect(PotionEffectType.BLINDNESS, friend.getPotionEffects(), 1);
        increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects(), 5);
    }

    public static void bindSlimesteel(EventFriend friend) {
        increaseEffect(PotionEffectType.JUMP, friend.getPotionEffects(), 1);
    }

    public static void headOsmiumSuperalloy(EventFriend friend) {
        increaseEffect(PotionEffectType.SLOW_DIGGING, friend.getPotionEffects());
    }

    // todo Find a way for 'real' following without NMS??
    public static void rodStarDust(EventFriend friend) {
        increaseEffect(PotionEffectType.GLOWING, friend.getPotionEffects());
        for (Entity e : friend.getPlayer().getNearbyEntities(10,10,10)) {
            if (e instanceof Villager) {
                Location eLoc = e.getLocation();
                Location pLoc = friend.getPlayer().getLocation();
                e.teleport(BlockUtils.getMid(eLoc.getWorld(), eLoc.getX(), eLoc.getY(), eLoc.getZ(), pLoc.getX(), pLoc.getY(), pLoc.getZ()));
            }
        }
    }

    public static void rodRefinedIron(EventFriend friend) {
        increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects());
    }

    public static void headMixedMetal(EventFriend friend) {
        int rnd = ThreadLocalRandom.current().nextInt(1, 4);
        if (rnd == 1) {
            increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects());
        } else if (rnd == 2) {
            increaseEffect(PotionEffectType.FIRE_RESISTANCE, friend.getPotionEffects());
        } else if (rnd == 3) {
            increaseEffect(PotionEffectType.LUCK, friend.getPotionEffects());
        }
    }

    public static void bindCarbonMesh(EventFriend friend) {
        increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects());
    }

    public static void linksIron(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() - 0.1);
        friend.setPlayerExpMod(friend.getPlayerExpMod() + 0.1);
    }

    public static void plateIron(EventFriend friend) {
        increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects());
    }

    public static void gambesonTwistingWines(EventFriend friend) {
        for (Entity entity : friend.getPlayer().getNearbyEntities(5,5,5)) {
            if (entity instanceof Item) {
                Location eLoc = entity.getLocation();
                Location pLoc = friend.getPlayer().getLocation();
                entity.teleport(BlockUtils.getMid(eLoc.getWorld(), eLoc.getX(), eLoc.getY(), eLoc.getZ(), pLoc.getX(), pLoc.getY(), pLoc.getZ()));
            }
        }
    }

    public static void linksGold(EventFriend friend) {
        for (Entity entity : friend.getPlayer().getNearbyEntities(5,5,5)) {
            if (entity instanceof Piglin) {
                Piglin p = (Piglin) entity;
                p.setTarget(null);
            }
        }
    }

    public static void plateAluBronze(EventFriend friend) {
        int rnd = ThreadLocalRandom.current().nextInt(0,5);
        if (rnd == 0) {
            Player player = friend.getPlayer();
            Set<Block> blocks = new HashSet<>();
            for (int x = -3; x <= 3; x++) {
                for (int z = -3; z <= 3; z++) {
                    for (int y = -1; z <= 1; z++) {
                        blocks.add(player.getLocation().getBlock().getRelative(x, y, z));
                    }
                }
            }
            Optional<Block> oBlock = blocks.stream().filter(b -> b.getType() == Material.GRASS_BLOCK).findFirst();
            if (oBlock.isPresent()) {
                Block grass = oBlock.get();
                Block above = grass.getRelative(BlockFace.UP);
                if (above.getType() == Material.AIR && SlimefunPlugin.getProtectionManager().hasPermission(player, above, ProtectableAction.PLACE_BLOCK)) {
                    if (ThreadLocalRandom.current().nextInt(0, 101) == 0) {
                        above.setType(Material.WITHER_ROSE);
                        return;
                    }
                    List<Material> flowers = Arrays.asList(
                            Material.DANDELION,
                            Material.POPPY,
                            Material.BLUE_ORCHID,
                            Material.ALLIUM,
                            Material.AZURE_BLUET,
                            Material.WHITE_TULIP,
                            Material.ORANGE_TULIP,
                            Material.PINK_TULIP,
                            Material.RED_TULIP,
                            Material.OXEYE_DAISY,
                            Material.CORNFLOWER,
                            Material.LILY_OF_THE_VALLEY,
                            Material.SUNFLOWER
                    );
                    above.setType(flowers.get(ThreadLocalRandom.current().nextInt(0,flowers.size())));
                }
            }
        }
    }

    public static void linksFerrosilicon(EventFriend friend) {
        friend.setBrightBurn(friend.getBrightBurn() + 1);
        if (friend.getBrightBurn() >= 4) {
            for (Entity entity : friend.getPlayer().getNearbyEntities(5,5,5)) {
                if (entity instanceof Mob && (!(entity instanceof Wither) && !(entity instanceof EnderDragon))) {
                    EntityUtils.push((LivingEntity) entity, friend.getPlayer().getLocation(), 1);
                }
            }
        }
    }

    public static void plateDamSteel(EventFriend friend) {
         friend.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20 + (friend.getCompounding()^2));
    }

    public static void gambesonCrimsonRoots(EventFriend friend) {
        if (!GeneralUtils.day(friend.getPlayer().getWorld())) {
            int rnd = ThreadLocalRandom.current().nextInt(1,5);
            if (rnd == 1) {
                ItemUtils.incrementRepair(friend.getActiveStack());
            }
        }
    }

    public static void gambesonWeepingVines(EventFriend friend) {
        increaseEffect(PotionEffectType.BAD_OMEN, friend.getPotionEffects());
    }

    public static void platesAluminum(EventFriend friend) {
        increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects(), 1);
    }

    public static void gambesonVine(EventFriend friend) {
        if (GeneralUtils.day(friend.getPlayer().getWorld())) {
            int rnd = ThreadLocalRandom.current().nextInt(1,5);
            if (rnd == 1) {
                ItemUtils.incrementRepair(friend.getActiveStack());
            }
        }
    }
}
