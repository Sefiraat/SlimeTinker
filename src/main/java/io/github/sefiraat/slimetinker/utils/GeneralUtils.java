package io.github.sefiraat.slimetinker.utils;

import org.bukkit.World;

public final class GeneralUtils {

    private GeneralUtils() {
        throw new IllegalStateException("Utility class");
    }

    // https://bukkit.org/threads/solved-how-to-check-if-it-is-day-or-night.12262/
    public static boolean day(World world) {
        if(world.getTime() > 0 && world.getTime() < 12300) {
            return true;
        } else {
            return false;
        }
    }

}
