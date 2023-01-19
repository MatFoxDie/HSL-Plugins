package hsl.matfox.events;
import hsl.matfox.DAO.AdventurerDAO;
import hsl.matfox.DAO.MySQL;
import hsl.matfox.controllers.playerController;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import hsl.matfox.Main;
import org.bukkit.plugin.Plugin;


public final class onPlayerJoin implements Listener {
    Plugin plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        Location spawnLocation = loadSpawn();
        Player player = event.getPlayer();

        player.teleport(spawnLocation);

        setInventory(player);
        HSL(player);

        AdventurerDAO adventurerDAO = new AdventurerDAO();
        int result = adventurerDAO.NewPlayer(player);

        if(result == 400){
            playerController.newPlayer(event.getPlayer());
            playerController.playerSetLife(event.getPlayer());
        }

        if(!player.hasPlayedBefore()){
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes(
                    '&', "&6&lBem vindo!" + "&f&l "+player.getDisplayName())));

            // Criando e Settando vida de um NOVO jogador


        } else {
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes(
                    '&', "&6&lVocê voltou!" + "&f&l " + player.getDisplayName())
            ));
        }
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
    public Location loadSpawn() {
        Configuration config = plugin.getConfig();
        String worldName = config.getString("spawn-location.world");
        double x = config.getDouble("spawn-location.x");
        double y = config.getDouble("spawn-location.y");
        double z = config.getDouble("spawn-location.z");
        World world = Bukkit.getWorld(worldName);
        Location spawnLocation = new Location(world, x, y, z);
        return spawnLocation;
    }
}
