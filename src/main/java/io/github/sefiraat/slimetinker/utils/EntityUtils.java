package io.github.sefiraat.slimetinker.utils;

import lombok.experimental.UtilityClass;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;

@UtilityClass
public final class EntityUtils {


    public static void push(LivingEntity pushed, Location loc) {
        pushed.setVelocity(loc.toVector().subtract(pushed.getLocation().toVector()).normalize().multiply(-1));
    }


}
