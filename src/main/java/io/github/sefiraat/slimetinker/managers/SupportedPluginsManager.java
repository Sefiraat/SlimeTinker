package io.github.sefiraat.slimetinker.managers;

import io.github.sefiraat.slimetinker.SlimeTinker;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class SupportedPluginsManager {

    public static final boolean INFINITY_EXPANSION = SlimeTinker.inst().getServer().getPluginManager().getPlugin("InfinityExpansion") != null;
    public static final boolean SLIMEFUN_WARFARE = SlimeTinker.inst().getServer().getPluginManager().getPlugin("SlimefunWarfare") != null;
    public static final boolean DYNATECH = SlimeTinker.inst().getServer().getPluginManager().getPlugin("DynaTech") != null;
    public static final boolean LITEPANSION = SlimeTinker.inst().getServer().getPluginManager().getPlugin("LiteXpansion") != null;

}
