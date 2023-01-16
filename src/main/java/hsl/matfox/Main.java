package hsl.matfox;

import hsl.matfox.commands.hslReloadCommand;
import hsl.matfox.events.onPlayerDamage;
import hsl.matfox.events.onPlayerDropItem;
import hsl.matfox.events.onPlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

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

        //commands
        this.getCommand("hslReload").setExecutor(new hslReloadCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
