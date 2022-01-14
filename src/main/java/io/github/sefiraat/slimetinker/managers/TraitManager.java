package io.github.sefiraat.slimetinker.managers;

import io.github.sefiraat.slimetinker.config.ConfigManager;

/**
 * This class manages the traits.
 */
public class TraitManager {

    private ConfigManager config;

    public TraitManager() {
        this.config = new ConfigManager("traits.yml");
    }

    /**
     * If the trait is enabled in the config.
     * If the config does not exist, set to true by default.
     *
     * @param material the material of trait
     * @param part the part of trait
     * @return if the trait is enabled in the config
     */
    public boolean getEnabled(String material, String part) {
        return this.config.getConfig().getOrSetDefault(material + "." + part, true);
    }

    /**
     * If the trait is enabled in the config.
     * This will not set the default value.
     *
     * @param material the material of trait
     * @param part the part of trait
     * @return if the trait is enabled in the config
     */
    public boolean isEnabled(String material, String part) {
        return this.config.getConfig().getBoolean(material + "." + part);
    }

    /**
     * Save the file
     */
    public void save() {
        this.config.getConfig().save();
    }
}
