package io.github.sefiraat.slimetinker.utils;

import org.bukkit.World;

public final class GeneralUtils {

    private GeneralUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean day(World world) {
        return world.getTime() > 0 && world.getTime() < 12300;
    }

}
