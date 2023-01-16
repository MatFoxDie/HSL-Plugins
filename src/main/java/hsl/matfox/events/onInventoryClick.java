package hsl.matfox.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.concurrent.TimeUnit;

public final class onInventoryClick implements Listener {
    private int delay;
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        System.out.println("onClick");
        if (event.getCurrentItem() == null || event.getCurrentItem().getItemMeta() == null || event.getCurrentItem().getType() == Material.AIR){
            System.out.println("Sem item");
        }
        else{
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) throws InterruptedException {
        Action a = e.getAction();
        Player p = e.getPlayer();
        if ((a == Action.PHYSICAL) || (e.getItem() == null) || (e.getItem().getType() == Material.STICK)) return;
        if(delay > 0){
            p.sendMessage("Aguarde "+delay+" segundos para utilizar novamente.");
        } else {
            if (e.getItem().getType() == Material.GRAY_DYE) {
                ItemStack showPlayers = new ItemStack(Material.LIME_DYE);
                ItemMeta showPlayersmeta = showPlayers.getItemMeta();
                showPlayersmeta.setDisplayName("Mostrar jogadores");
                showPlayers.setItemMeta(showPlayersmeta);
                p.getInventory().setItem(7, showPlayers);
                p.sendMessage("Mostrando jogadores.");
                for (Player online : Bukkit.getOnlinePlayers()) {
                    p.hidePlayer(online);
                }
            }
            if (e.getItem().getType() == Material.LIME_DYE) {
                ItemStack showPlayers = new ItemStack(Material.GRAY_DYE);
                ItemMeta showPlayersmeta = showPlayers.getItemMeta();
                showPlayersmeta.setDisplayName("Esconder jogadores");
                showPlayers.setItemMeta(showPlayersmeta);
                p.getInventory().setItem(7, showPlayers);
                p.sendMessage("Jogadores escondidos.");
                for (Player online : Bukkit.getOnlinePlayers()) {
                    p.showPlayer(online);
                }
            }
        }
    }
}