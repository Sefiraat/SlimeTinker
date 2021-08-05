package io.github.sefiraat.slimetinker.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang.Validate;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Breedable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

@UtilityClass
public final class EntityUtils {


    public static void push(LivingEntity pushed, Location loc, double force) {
        Vector v = pushed.getLocation().toVector().subtract(loc.toVector()).normalize().multiply(force);
        v.add(new Vector(0, force + 1, 0));
        pushed.setVelocity(v);
    }

    public static void increaseEffect(PotionEffectType potionEffectType, Map<PotionEffectType, Integer> potionEffects) {
        increaseEffect(potionEffectType, potionEffects, 0);
    }

    public static void increaseEffect(PotionEffectType potionEffectType, Map<PotionEffectType, Integer> potionEffects, int amount) {
        if (potionEffects.containsKey(potionEffectType)) {
            potionEffects.put(potionEffectType, potionEffects.get(potionEffectType) + amount);
        } else {
            potionEffects.put(potionEffectType, amount);
        }
    }

    /**
     * SFW's Training dummy allows damage and exp gain for free, no thanks!
     * @return True is target is a Training Dummy
     */
    public static boolean isTrainingDummy(Entity e) {
        return e.getCustomName() != null && e.getCustomName().equals("Dummy");
    }

    public static double getFacing(Player p, Entity e) {
        Vector pd = p.getLocation().getDirection();
        Vector ed = p.getLocation().getDirection();
        double x = (pd.getX() * ed.getZ()) - (pd.getZ() * ed.getX());
        double z = (pd.getX() * ed.getX()) + (pd.getZ() * ed.getZ());
        double a = Math.atan2(x, z);
        return (a * 180) / Math.PI;
    }

    public static boolean isFacingAway(Player p, Entity e) {
        return isFacingAway(p, e, null);
    }

    public static boolean isFacingAway(Player p, Entity e, @Nullable Integer tolerance) {
        double d = getFacing(p, e);
        Integer val = tolerance == null ? Integer.valueOf(30) : tolerance;
        return d <= val && d >= -val;
    }

    public static void makeBreed(Animals a) {
        if (a.isAdult() &&!a.isLoveMode()) {
            a.setBreed(true);
            a.setLoveModeTicks(400);
            a.getWorld().spawnParticle(Particle.HEART, a.getLocation(), 4, 0.5, 0.5, 0.5);
        }
    }

    @Nonnull
    public static <T> List<T> getNearbyEntitiesByType(@Nonnull Class<?> clazz, @Nonnull Entity e, double x, double y, double z) {
        return getNearbyEntitiesByType(clazz, e.getLocation(), x, y, z);
    }

    @Nonnull
    public static <T> List<T> getNearbyEntitiesByType(@Nonnull Class<?> clazz, @Nonnull Block b, double x, double y, double z) {
        return getNearbyEntitiesByType(clazz, b.getLocation(), x, y, z);
    }

    @Nonnull
    public static <T> List<T> getNearbyEntitiesByType(@Nonnull Class<?> clazz, @Nonnull Location l, double x, double y, double z) {
        World world = l.getWorld();
        Validate.notNull(world);
        return ((List<T>) world.getNearbyEntities(l, x, y, z, e -> e.getClass().isInstance(clazz)));
    }

}
