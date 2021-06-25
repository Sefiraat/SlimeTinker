package io.github.sefiraat.slimetinker.managers;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class SupportedPluginsManager {

    public static final boolean INFINITY_EXPANSION = SlimeTinker.inst().getServer().getPluginManager().getPlugin("InfinityExpansion") != null;
    public static final boolean SLIMEFUN_WARFARE = SlimeTinker.inst().getServer().getPluginManager().getPlugin("SlimefunWarfare") != null;
    public static final boolean DYNATECH = SlimeTinker.inst().getServer().getPluginManager().getPlugin("DynaTech") != null;
    public static final boolean LITEPANSION = SlimeTinker.inst().getServer().getPluginManager().getPlugin("LiteXpansion") != null;

    public static final String CORE_NOTE = ThemeUtils.MAIN + "Core SlimeTinker";
    public static final String INFINITY_EXPANSION_NOTE = ThemeUtils.ADD_INFINITY + "Infinity Expansion";
    public static final String SLIMEFUN_WARFARE_NOTE = ThemeUtils.ADD_SLIMEFUN_WARFARE + "Slimefun Warfare";
    public static final String DYNATECH_NOTE = ThemeUtils.ADD_DYNATECH + "DynaTech";
    public static final String LITEXPANSION_NOTE = ThemeUtils.ADD_LITEXPANSION + "LiteXpansion";

}
