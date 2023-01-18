package hsl.matfox.repositories;

import jakarta.persistence.EntityManager;

public class PlayerRepository {
    private EntityManager em;

    public int player(String UUID, String nick, String displayName, String permissions, String atributes){
        em.createNativeQuery("INSERT INTO player VALUES(?,?,?,?)");
        return 1;
    }
}
