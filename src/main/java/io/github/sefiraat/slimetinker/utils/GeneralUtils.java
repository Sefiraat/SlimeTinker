package io.github.sefiraat.slimetinker.utils;

import io.github.sefiraat.slimetinker.SlimeTinker;
import lombok.experimental.UtilityClass;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.Objects;

@UtilityClass
public final class GeneralUtils {

    public static boolean day(World world) {
        return world.getTime() > 0 && world.getTime() < 12300;
    }

    public static String serializeLocation(Location l) {
        String world = Objects.requireNonNull(l.getWorld()).getName();
        double x = l.getX();
        double y = l.getY();
        double z = l.getZ();
        float w = l.getYaw();
        float p = l.getPitch();
        return world + ";" + x + ";" + y + ";" + z + ";" + w + ";" + p;
    }

    public static Location deserializeLocation(String s) {
        String[] split = s.split(";");
        return new Location(
                SlimeTinker.inst().getServer().getWorld(split[0]),
                Double.parseDouble(split[1]),
                Double.parseDouble(split[2]),
                Double.parseDouble(split[3]),
                Float.parseFloat(split[4]),
                Float.parseFloat(split[5])
        );
    }

}
