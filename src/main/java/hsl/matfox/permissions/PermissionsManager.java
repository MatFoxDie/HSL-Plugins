package hsl.matfox.permissions;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PermissionsManager {
    private File permissionsFile;
    private YamlConfiguration permissionsConfig;
    private List<String> validPermissions = Arrays.asList("example.permission1", "example.permission2", "example.permission3");

    public PermissionsManager(JavaPlugin plugin) {
        this.permissionsFile = new File(plugin.getDataFolder(), "permissions.yml");
        this.permissionsConfig = YamlConfiguration.loadConfiguration(permissionsFile);
    }

    public void addPermission(String player, String permission) {
        if(validPermissions.contains(permission)){
            permissionsConfig.set("players." + player + ".permission", permission);
            save();
        }else{
            //permissão não existe na lista de permissões válidas
        }
    }

    public void removePermission(String player, String permission) {
        permissionsConfig.set("players." + player + ".permission", null);
        save();
    }

    public List<String> getPermissions(String player) {
        return permissionsConfig.getStringList("players." + player + ".permission");
    }

    private void save() {
        try {
            permissionsConfig.save(permissionsFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}