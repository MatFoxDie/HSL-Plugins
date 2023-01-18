package hsl.matfox.models;

import hsl.matfox.enums.Rarity;
import org.bukkit.Material;

import java.util.HashSet;

public class Item {
    private Long id;
    private String name;
    private Material material;
    private Rarity rarity;
    private String[] lore;
    private Attributes attributes;
    private HashSet<Spells> spells = new HashSet<>();

    public Item() {
    }

    public Item(String name, Material material, Rarity rarity, String[] lore, Attributes attributes, HashSet<Spells> spells) {
        this.name = name;
        this.material = material;
        this.rarity = rarity;
        this.lore = lore;
        this.attributes = attributes;
        this.spells = spells;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public String[] getLore() {
        return lore;
    }

    public void setLore(String[] lore) {
        this.lore = lore;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public HashSet<Spells> getSpells() {
        return spells;
    }
}
