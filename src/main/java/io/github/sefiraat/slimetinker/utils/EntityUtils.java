package io.github.sefiraat.slimetinker.utils;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;

public class EntityUtils {


    public static void push(LivingEntity pushed, Location loc) {
        pushed.setVelocity(loc.toVector().subtract(pushed.getLocation().toVector()).normalize().multiply(-1));
    }


}
