package hsl.matfox.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class hslReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Bukkit.getPluginManager().disablePlugin(Bukkit.getPluginManager().getPlugin("Project_M"));
        Bukkit.getPluginManager().enablePlugin(Bukkit.getPluginManager().getPlugin("Project_M"));
        return false;
    }
}
