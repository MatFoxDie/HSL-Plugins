package hsl.matfox;

import hsl.matfox.commands.hslReloadCommand;
import hsl.matfox.events.*;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.List;

public final class Main extends JavaPlugin {


    @Override
    public void onEnable() {
        //loadConfig
        this.saveDefaultConfig();
        //events
        getServer().getPluginManager().registerEvents(new onPlayerJoin(),this);
        getServer().getPluginManager().registerEvents(new onPlayerDamage(),this);
        getServer().getPluginManager().registerEvents(new onPlayerDropItem(), this);
        getServer().getPluginManager().registerEvents(new onInventoryClick(), this);
        getServer().getPluginManager().registerEvents(new onPlayerMessage(), this);

        //commands
        this.getCommand("hslReload").setExecutor(new hslReloadCommand());



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
