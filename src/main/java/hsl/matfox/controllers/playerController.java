package hsl.matfox.controllers;

import hsl.matfox.models.Adventurer;
import hsl.matfox.models.Attributes;
import org.bukkit.entity.Player;

public class playerController {
    public static void newPlayer(Player p){
        new Adventurer(p, Attributes.basicPlayer);
        System.out.println("Novo player criado nos registros");
    }
    public static void playerSetLife(Player p){
        p.setHealthScale(Adventurer.getAdventurerByPlayer(p).getAttributes().getLife());
    }

}
