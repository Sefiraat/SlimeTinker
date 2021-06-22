package io.github.sefiraat.slimetinker.events;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.utils.BlockUtils;
import io.github.sefiraat.slimetinker.utils.EntityUtils;
import io.github.sefiraat.slimetinker.utils.GeneralUtils;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import lombok.experimental.UtilityClass;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.concurrent.ThreadLocalRandom;

import static io.github.sefiraat.slimetinker.utils.EntityUtils.increaseEffect;

@UtilityClass
public final class TickEvents {

    public static void rodGold(TickEventFriend friend) {
        increaseEffect(PotionEffectType.GLOWING, friend.getPotionEffects());
    }

    public static void binderTwistingvine(TickEventFriend friend) {
        for (Entity entity : friend.getPlayer().getNearbyEntities(5,5,5)) {
            if (entity instanceof Item) {
                Location eLoc = entity.getLocation();
                Location pLoc = friend.getPlayer().getLocation();
                entity.teleport(BlockUtils.getMid(eLoc.getWorld(), eLoc.getX(), eLoc.getY(), eLoc.getZ(), pLoc.getX(), pLoc.getY(), pLoc.getZ()));
            }
        }
    }

    public static void rodTin(TickEventFriend friend) {
        increaseEffect(PotionEffectType.SATURATION, friend.getPotionEffects());
    }

    public static void binderCrimsonroot(TickEventFriend friend) {
        if (!GeneralUtils.day(friend.getPlayer().getWorld())) {
            int rnd = ThreadLocalRandom.current().nextInt(1,5);
            if (rnd == 1) {
                ItemUtils.incrementRepair(friend.getHeldItem());
            }
        }
    }

    public static void binderWeepingvine(TickEventFriend friend) {
        increaseEffect(PotionEffectType.BAD_OMEN, friend.getPotionEffects());
    }

    public static void headBillon(TickEventFriend friend) {
        increaseEffect(PotionEffectType.FAST_DIGGING, friend.getPotionEffects());
    }

    public static void headGold(TickEventFriend friend) {
        increaseEffect(PotionEffectType.INVISIBILITY, friend.getPotionEffects());
    }

    public static void headZinc(TickEventFriend friend) {
        increaseEffect(PotionEffectType.DOLPHINS_GRACE, friend.getPotionEffects());
    }

    public static void binderVine(TickEventFriend friend) {
        if (GeneralUtils.day(friend.getPlayer().getWorld())) {
            int rnd = ThreadLocalRandom.current().nextInt(1,5);
            if (rnd == 1) {
                ItemUtils.incrementRepair(friend.getHeldItem());
            }
        }
    }

    public static void headSolder(TickEventFriend friend) {
        increaseEffect(PotionEffectType.INVISIBILITY, friend.getPotionEffects());
    }

    public static void rodBronze(TickEventFriend friend) {
        increaseEffect(PotionEffectType.WITHER, friend.getPotionEffects());
    }

    public static void rodLead(TickEventFriend friend) {
        increaseEffect(PotionEffectType.HEALTH_BOOST, friend.getPotionEffects(), 2);
        increaseEffect(PotionEffectType.HUNGER, friend.getPotionEffects());
    }

    public static void rodMagnesium(TickEventFriend friend) {
        for (Entity entity : friend.getPlayer().getNearbyEntities(10,10,10)) {
            if (entity instanceof Item && ThreadLocalRandom.current().nextInt(1,3) == 1) {
                entity.teleport(friend.getPlayer().getLocation());
            }
        }
    }

    public static void headTin(TickEventFriend friend) {
        increaseEffect(PotionEffectType.LUCK, friend.getPotionEffects());
    }

    public static void rodDamsteel(TickEventFriend friend) {
        increaseEffect(PotionEffectType.NIGHT_VISION, friend.getPotionEffects());
    }

    public static void rodBrass(TickEventFriend friend) {
        increaseEffect(PotionEffectType.WATER_BREATHING, friend.getPotionEffects());
    }

    public static void bindWarpedroot(TickEventFriend friend) {
        int rnd = ThreadLocalRandom.current().nextInt(1,5);
        if (rnd == 1) {
            friend.getPlayer().setHealth(Math.min(friend.getPlayer().getHealth() + 1, friend.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()));
        }
    }

    public static void headBronze(TickEventFriend friend) {
        increaseEffect(PotionEffectType.FIRE_RESISTANCE, friend.getPotionEffects());
    }

    public static void rodIron(TickEventFriend friend) {
        increaseEffect(PotionEffectType.INCREASE_DAMAGE, friend.getPotionEffects());
    }

    public static void headAlubronze(TickEventFriend friend) {
        increaseEffect(PotionEffectType.INCREASE_DAMAGE, friend.getPotionEffects());
    }

    public static void rodSilver(TickEventFriend friend) {
        increaseEffect(PotionEffectType.SLOW_FALLING, friend.getPotionEffects(), 2);
    }

    public static void rodBillon(TickEventFriend friend) {
        increaseEffect(PotionEffectType.JUMP, friend.getPotionEffects(), 3);
    }

    public static void headBrass(TickEventFriend friend) {
        increaseEffect(PotionEffectType.UNLUCK, friend.getPotionEffects(), 2);
    }

    public static void rodZinc(TickEventFriend friend) {
        if (!friend.getPlayer().isSneaking()) {
            increaseEffect(PotionEffectType.LEVITATION, friend.getPotionEffects(), 1);
        }
    }

    public static void rodCorbronze(TickEventFriend friend) {
        increaseEffect(PotionEffectType.CONFUSION, friend.getPotionEffects());
    }

    public static void headDuralium(TickEventFriend friend) {
        if (ItemUtils.isToolBroken(friend.getHeldItem())) {
            increaseEffect(PotionEffectType.SLOW_DIGGING, friend.getPotionEffects());
        }
    }

    public static void bindString(TickEventFriend friend) {
        increaseEffect(PotionEffectType.WEAKNESS, friend.getPotionEffects());
    }

    public static void rodSingGold(TickEventFriend friend) {
        increaseEffect(PotionEffectType.GLOWING, friend.getPotionEffects());
    }

    public static void rodSingTin(TickEventFriend friend) {
        increaseEffect(PotionEffectType.SATURATION, friend.getPotionEffects(), 2);
    }

    public static void headMetal(TickEventFriend friend) {
        increaseEffect(PotionEffectType.FAST_DIGGING, friend.getPotionEffects(), 1);
    }

    public static void headMythril(TickEventFriend friend) {
        increaseEffect(PotionEffectType.FAST_DIGGING, friend.getPotionEffects(), 1);
        increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects());
    }

    public static void headSingGold(TickEventFriend friend) {
        increaseEffect(PotionEffectType.INVISIBILITY, friend.getPotionEffects(), 1);
    }

    public static void headSingZinc(TickEventFriend friend) {
        increaseEffect(PotionEffectType.DOLPHINS_GRACE, friend.getPotionEffects(), 1);
    }

    public static void rodSingLead(TickEventFriend friend) {
        increaseEffect(PotionEffectType.HEALTH_BOOST, friend.getPotionEffects(), 1);
    }

    public static void rodSingMagnesium(TickEventFriend friend) {
        for (Entity entity : friend.getPlayer().getNearbyEntities(10,10,10)) {
            if (entity instanceof Item) {
                Location eLoc = entity.getLocation();
                Location pLoc = friend.getPlayer().getLocation();
                entity.teleport(BlockUtils.getMid(eLoc.getWorld(), eLoc.getX(), eLoc.getY(), eLoc.getZ(), pLoc.getX(), pLoc.getY(), pLoc.getZ()));
            }
        }
    }

    public static void headSingTin(TickEventFriend friend) {
        increaseEffect(PotionEffectType.LUCK, friend.getPotionEffects(), 1);
        increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects(), 1);
    }

    public static void rodFortune(TickEventFriend friend) {
        increaseEffect(PotionEffectType.INVISIBILITY, friend.getPotionEffects(), 2);
    }

    public static void rodMagic(TickEventFriend friend) {
        for (Entity entity : friend.getPlayer().getNearbyEntities(10,10,10)) {
            if (entity instanceof LivingEntity) {
                LivingEntity l = (LivingEntity) entity;
                l.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, SlimeTinker.RUNNABLE_TICK_RATE + 5, 0));
            }
        }
    }

    public static void rodSingIron(TickEventFriend friend) {
        increaseEffect(PotionEffectType.INCREASE_DAMAGE, friend.getPotionEffects(), 1);
    }

    public static void rodMythril(TickEventFriend friend) {
        for (Entity entity : friend.getPlayer().getNearbyEntities(5,5,5)) {
            if (entity instanceof Monster && (entity.getType() != EntityType.WITHER && entity.getType() != EntityType.ENDER_DRAGON)) {
                Monster l = (Monster) entity;
                EntityUtils.push(l, friend.getPlayer().getLocation(), 0.2);
            }
        }
    }

    public static void rodSingZinc(TickEventFriend friend) {
        if (friend.getPlayer().isSneaking()) {
            increaseEffect(PotionEffectType.LEVITATION, friend.getPotionEffects(), 1);
        }
    }

    public static void headMagic(TickEventFriend friend) {
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
}
