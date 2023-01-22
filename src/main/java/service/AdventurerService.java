package service;

import hsl.matfox.config.Database;
import hsl.matfox.models.Adventurer;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class AdventurerService {


    public Integer register(Adventurer adventurer) throws IOException {
        Database database = Database.getInstance();
        SqlSession session = database.getSession();
        Integer id = session.insert("AdventurerMapper.insert",adventurer);
        session.commit();
        return id;
    }

}