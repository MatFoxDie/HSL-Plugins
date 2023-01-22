package hsl.matfox.configuration;

import com.mysql.cj.jdbc.MysqlDataSource;
import hsl.matfox.mappers.AdventurerDAO;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class MySQL {
    private SqlSession sqlSession;
    private static MySQL INSTANCE;

    private MySQL() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://89.116.225.201:3306/happysuggarcraft");
        dataSource.setUser("gabs");
        dataSource.setPassword("P@kemon04");
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(AdventurerDAO.class);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        sqlSession = sessionFactory.openSession();
    }
    public static MySQL getInstance(){
        if(INSTANCE == null) {
            INSTANCE = new MySQL();
        }
        return INSTANCE;
    }
    public SqlSession getSession() {
        return sqlSession;
    }
}
