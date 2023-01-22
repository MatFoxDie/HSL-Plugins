package hsl.matfox.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Database {
    private static Database INSTANCE;
    private final String resource;
    private final SqlSession session;


    private Database() throws IOException {
        resource = "hsl/matfox/config/Database.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession();
    }

    public static Database getInstance() throws IOException {
        if (INSTANCE == null) INSTANCE = new Database();
        return INSTANCE;
    }

    public SqlSession getSession() {
        return session;
    }
}
