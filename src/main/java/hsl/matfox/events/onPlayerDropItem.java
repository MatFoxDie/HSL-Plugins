package hsl.matfox.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class onPlayerDropItem implements Listener {
    @EventHandler
    public void onItemDrop (PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        if(player.getWorld().getName().equals("hub")) {
            player.sendMessage(e.getItemDrop().getLocation().toString());
            e.setCancelled(true);
        }
    }
}

