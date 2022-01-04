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
     * Get the trait status in the config file
     *
     * @param material the material of trait
     * @param part the part of trait
     * @return if the trait is enabled in the config
     */
    public boolean getTraitStatus(String material, String part) {
        return this.config.getConfig().getOrSetDefault(material + "." + part, true);
    }

    /**
     * Save the file
     */
    public void save() {
        this.config.getConfig().save();
    }
}
