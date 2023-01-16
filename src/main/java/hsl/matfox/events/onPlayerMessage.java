package hsl.matfox.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class onPlayerMessage implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {

        Player player = event.getPlayer();

        String message = event.getMessage();
        String newMessage =  ChatColor.translateAlternateColorCodes('&', "&a&l[" + player.getWorld().getName().toUpperCase() + "]" + " &6&l" + player.getDisplayName()+": &f")+ message;
        if(player.isOp()){
            StringBuilder stringBuilder = new StringBuilder(newMessage);
            newMessage = stringBuilder.insert(0, ChatColor.translateAlternateColorCodes('&', "&4&l[ADMIN] ")).toString();
        }
        event.setCancelled(true);
        player.sendMessage(newMessage);
    }
}
