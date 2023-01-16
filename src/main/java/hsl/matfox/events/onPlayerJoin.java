package hsl.matfox.events;

import com.google.inject.Inject;
import hsl.matfox.utils.ConfigurationManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import hsl.matfox.Main;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class onPlayerJoin implements Listener {

    Plugin plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        String configValue = this.plugin.getConfig().getString("SomeCoolValue");

        Configuration config = plugin.getConfig();

        String worldName = config.getString("spawn-location.world");
        double x = config.getDouble("spawn-location.x");
        double y = config.getDouble("spawn-location.y");
        double z = config.getDouble("spawn-location.z");
        World world = Bukkit.getWorld(worldName);
        Location spawnLocation = new Location(world, x, y, z);

        Player player = event.getPlayer();

        player.teleport(spawnLocation);


        System.out.println("Teleportado");
        setInventory(player);
    }
    public void setInventory(Player player) {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Espada de Diamante Mágica");
        List<String> lore = new ArrayList<String>();
        lore.add("Espada mágica com poder de fogo!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        player.getInventory().clear();
        player.getInventory().setItem(10, item);
    }
}
