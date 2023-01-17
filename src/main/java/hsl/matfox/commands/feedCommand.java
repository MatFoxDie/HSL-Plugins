package hsl.matfox.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class feedCommand implements CommandExecutor {
    private long lastExecution = 0;
    private final long delay = 30;


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        long currentTime = System.currentTimeMillis();
        if (currentTime > lastExecution + delay * 1000) {
            lastExecution = currentTime;
            return true;
        } else {
            long remainingTime = (lastExecution + delay * 1000 - currentTime) / 1000;
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l[HSC]&6&lVocê deve aguardar " + remainingTime + " segundos antes de usar o comando novamente."));
            return false;
        }
    }
}
