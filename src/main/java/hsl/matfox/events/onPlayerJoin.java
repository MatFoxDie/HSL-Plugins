package hsl.matfox.events;

import hsl.matfox.models.Adventurer;
import hsl.matfox.models.Attributes;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import hsl.matfox.Main;
import org.bukkit.plugin.Plugin;



public final class onPlayerJoin implements Listener {
    FileConfiguration data;
    File permFile;
    File statusFile;
    private boolean isFirstJoin;
    Adventurer a;
    Plugin plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Attributes at = new Attributes();

        at.setDmg(1);
        at.setDef(1);
        at.setLife(1);

        Adventurer a= new Adventurer(event.getPlayer(), at);

        Adventurer b =  Adventurer.getAdventurer(event.getPlayer().getName());

        event.getPlayer().setHealthScale(b.getAttributes().getLife());

        System.out.println(b.getName());
        System.out.println(b.getAttributes().getLife());

        String configValue = this.plugin.getConfig().getString("SomeCoolValue");

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

        Configuration config = plugin.getConfig();
        String worldName = config.getString("spawn-location.world");
        double x = config.getDouble("spawn-location.x");
        double y = config.getDouble("spawn-location.y");
        double z = config.getDouble("spawn-location.z");
        World world = Bukkit.getWorld(worldName);
        Location spawnLocation = new Location(world, x, y, z);
        System.out.println("teste3");
        Player player = event.getPlayer();

        player.teleport(spawnLocation);

        System.out.println("Teleportado");

        setInventory(player);
        System.out.println("teste2");
        HSL(player);
        System.out.println("teste1");
        if(!player.hasPlayedBefore()){
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes(
                    '&', "&6&lBem vindo!" + "&f&l "+player.getDisplayName())
            ));
        } else {
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes(
                    '&', "&6&lVocê voltou!" + "&f&l "+player.getDisplayName())
            ));
        }
        System.out.println("teste1");
    }
    public void setInventory(Player player) {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Espada de Diamante Mágica");
        List<String> lore = new ArrayList<String>();
        lore.add("Espada mágica com poder de fogo!");
        meta.setLore(lore);
        item.setItemMeta(meta);

        ItemStack showPlayers = new ItemStack(Material.GRAY_DYE);
        ItemMeta showPlayersmeta = showPlayers.getItemMeta();
        showPlayersmeta.setDisplayName("Mostrar jogadores");
        showPlayers.setItemMeta(showPlayersmeta);

        player.getInventory().clear();
        player.getInventory().setItem(0, item);
        player.getInventory().setItem(7, showPlayers);

    }

    public void HSL(Player player) {

        Inventory inventory = player.getInventory();

        ItemStack pinkglass = new ItemStack(Material.PINK_STAINED_GLASS_PANE, 1);
        ItemMeta meta = pinkglass.getItemMeta();
        meta.setDisplayName("♥");
        List<String> lore = new ArrayList<String>();
        lore.add("Happy Suggar Craft!");
        meta.setLore(lore);
        pinkglass.setItemMeta(meta);

        inventory.setItem(4, pinkglass);
        inventory.setItem(12, pinkglass);
        inventory.setItem(14, pinkglass);
        inventory.setItem(20, pinkglass);
        inventory.setItem(21, pinkglass);
        inventory.setItem(22, pinkglass);
        inventory.setItem(23, pinkglass);
        inventory.setItem(24, pinkglass);
        inventory.setItem(30, pinkglass);
        inventory.setItem(31, pinkglass);
        inventory.setItem(32, pinkglass);
    }
}
