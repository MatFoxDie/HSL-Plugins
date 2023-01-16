package hsl.matfox.utils;

import hsl.matfox.Main;
import org.bukkit.configuration.Configuration;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private final Main plugin;
    private Configuration config;

    private ConfigurationManager(Main plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    public static ConfigurationManager getInstance(Main plugin) {
        if (instance == null) {
            instance = new ConfigurationManager(plugin);
        }
        return instance;
    }

    public Configuration getConfig() {
        return config;
    }

    public void saveConfig() {
        plugin.saveConfig();
    }
}