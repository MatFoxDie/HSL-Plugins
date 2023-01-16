package hsl.matfox.events;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public final class onInventoryClick implements Listener {
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
}