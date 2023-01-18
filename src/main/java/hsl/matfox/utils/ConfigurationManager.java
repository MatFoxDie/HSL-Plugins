package hsl.matfox.utils;

import hsl.matfox.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class ConfigurationManager {
    Plugin plugin = Main.getPlugin(Main.class);
    File permFile;
    File statusFile;
    private static ConfigurationManager instance;

    private ConfigurationManager() {
        loadConfigFiles();
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public void loadConfigFiles() {
        permFile = new File(plugin.getDataFolder(), "permissions.yml");
        if (!permFile.exists()) {
            try {
                permFile.createNewFile();
            }
            catch (IOException e) {
                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create permissions.yml!");
            }
        }
        statusFile = new File(plugin.getDataFolder(), "status.yml");
        if (!statusFile.exists()) {
            try {
                statusFile.createNewFile();
            }
            catch (IOException e) {
                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create status.yml!");
            }
        }
    }
    public Configuration loadConfig() {
        Configuration config = plugin.getConfig();
        return config;
    }
}