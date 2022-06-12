package io.github.sefiraat.slimetinker.config;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;

import java.io.File;
import java.io.IOException;

/**
 * Basic config file manager
 */
public class ConfigManager {
    private final Config config;

    public ConfigManager(String fileName) {
        final SlimeTinker plugin = SlimeTinker.getInstance();
        final File file = new File(plugin.getDataFolder(), fileName);

        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.config = new Config(file);
    }

    public Config getConfig() {
        return this.config;
    }
}
