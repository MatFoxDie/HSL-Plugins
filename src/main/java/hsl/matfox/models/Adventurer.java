package hsl.matfox.models;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Adventurer {
    private static final HashMap<UUID, Adventurer> adventurers = new HashMap<UUID, Adventurer>();

    private Integer id;
    private UUID uuid;
    private String name;
    private String displayName;
    private  String password;
    private String permissions;
    private Attributes attributes;

    public Adventurer() {
    }

    public Adventurer(Player player) {
        this.name = player.getName();
        this.displayName = player.getDisplayName();
        this.uuid = player.getUniqueId();
        this.permissions = "Jogador";
        adventurers.put(uuid, this);
    }

    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public static Adventurer getAdventurerByUUID(UUID id) {
        for (Adventurer obj : adventurers.values()) {
            if (obj.getUuid() == id) {
                return obj;
            }
        }
        return null;
    }

    public String getDisplayName() { return displayName; }

    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getPermissions() { return permissions; }

    public void setPermissions(String permissions) { this.permissions = permissions; }



    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
