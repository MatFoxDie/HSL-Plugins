package hsl.matfox;

import hsl.matfox.events.onPlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new onPlayerJoin(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
