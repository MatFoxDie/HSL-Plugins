package hsl.matfox.models;

import jakarta.persistence.Entity;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;
@Entity
public class Adventurer {
    private static final HashMap<UUID, Adventurer> adventurers = new HashMap<UUID, Adventurer>();

    private UUID uuid;
    private String name;
    private String displayName;
    private String permissions;
    private Attributes attributes;

    public Adventurer() {
    }

    public Adventurer(Player player, Attributes attributes) {
        this.name = player.getName();
        this.displayName = player.getDisplayName();
        this.uuid = player.getUniqueId();
        this.permissions = "Jogador";
        this.attributes =  attributes;
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

    public static Adventurer getAdventurerByPlayer(Player p) {
        Adventurer a = adventurers.get(p.getUniqueId());
        return a != null ? a : new Adventurer(p, a.attributes);
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
}
