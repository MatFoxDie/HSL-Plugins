package hsl.matfox;

import hsl.matfox.commands.hslReloadCommand;
import hsl.matfox.events.*;
import hsl.matfox.utils.ConfigurationManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {


    @Override
    public void onEnable() {
        //loadConfig
        ConfigurationManager.getInstance();
        this.saveDefaultConfig();
        //events
        getServer().getPluginManager().registerEvents(new onPlayerJoin(),this);
        getServer().getPluginManager().registerEvents(new onPlayerDamage(),this);
        getServer().getPluginManager().registerEvents(new onPlayerDropItem(), this);
        getServer().getPluginManager().registerEvents(new onInventoryClick(), this);
        getServer().getPluginManager().registerEvents(new onPlayerMessage(), this);
        getServer().getPluginManager().registerEvents(new onPlayerFoodLevelChangeEvent(), this);

        //commands
        this.getCommand("hslReload").setExecutor(new hslReloadCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
