package io.github.sefiraat.slimetinker.events;

import io.github.sefiraat.slimetinker.utils.BlockUtils;
import io.github.sefiraat.slimetinker.utils.GeneralUtils;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.potion.PotionEffectType;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class TickEvents {

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
        increaseEffect(PotionEffectType.LUCK, friend.getPotionEffects(), 2);
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

    public static void bindString(TickEventFriend friend) {
        increaseEffect(PotionEffectType.WEAKNESS, friend.getPotionEffects());
    }




















    private static void increaseEffect(PotionEffectType potionEffectType, Map<PotionEffectType, Integer> potionEffects) {
        if (potionEffects.containsKey(potionEffectType)) {
            potionEffects.put(potionEffectType, potionEffects.get(potionEffectType) + 1);
        } else {
            potionEffects.put(potionEffectType, 0);
        }
    }

    private static void increaseEffect(PotionEffectType potionEffectType, Map<PotionEffectType, Integer> potionEffects, int amount) {
        if (potionEffects.containsKey(potionEffectType)) {
            potionEffects.put(potionEffectType, potionEffects.get(potionEffectType) + amount);
        } else {
            potionEffects.put(potionEffectType, amount);
        }
    }

}
