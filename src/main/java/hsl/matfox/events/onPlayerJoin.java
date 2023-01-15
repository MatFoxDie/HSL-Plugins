package hsl.matfox.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.Console;
import java.io.File;
import java.io.IOException;

public final class onPlayerJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        FileConfiguration config = new YamlConfiguration();
        try {
            System.out.println("Teleportado");
            config.load(new File("src/main/resources/plugin.yml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
        String worldName = config.getString("spawn-location.world");
        double x = config.getDouble("spawn-location.x");
        double y = config.getDouble("spawn-location.y");
        double z = config.getDouble("spawn-location.z");
        World world = Bukkit.getWorld(worldName);
        Location spawnLocation = new Location(world, x, y, z);

        Player player = event.getPlayer();

        player.teleport(spawnLocation);

        System.out.println("Teleportado");
    }
}
