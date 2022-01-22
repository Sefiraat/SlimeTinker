package io.github.sefiraat.slimetinker.config;

import java.io.File;

import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;

import io.github.sefiraat.slimetinker.SlimeTinker;

/**
 * Basic config file manager
 */
public class ConfigManager {
    private final String filename;
    private final Config config;

    public ConfigManager(String filename) {
        this.filename = filename;

        File file = new File(SlimeTinker.inst().getDataFolder(), filename);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            SlimeTinker.inst().saveResource(filename, true);
        }

        this.config = new Config(SlimeTinker.inst(), filename);
    }

    public Config getConfig() {
        return this.config;
    }
}
