package io.github.sefiraat.slimetinker.managers;

import io.github.sefiraat.slimetinker.SlimeTinker;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class SupportedPluginsManager {

    public static final boolean INFINITY_EXPANSION = SlimeTinker.inst().getServer().getPluginManager().getPlugin("InfinityExpansion") != null;

}
