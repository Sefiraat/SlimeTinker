package io.github.sefiraat.slimetinker.utils;

import lombok.experimental.UtilityClass;
import org.bukkit.World;

@UtilityClass
public final class GeneralUtils {

    public static boolean day(World world) {
        return world.getTime() > 0 && world.getTime() < 12300;
    }

}
