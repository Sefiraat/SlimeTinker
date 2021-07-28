package io.github.sefiraat.slimetinker.utils;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.managers.SupportedPluginsManager;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.cscorelib2.data.PersistentDataAPI;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import javax.annotation.Nullable;
import java.util.Map;

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
        return d <= 30 && d >= -30;
    }


}
