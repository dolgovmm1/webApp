package ru.dolgov.web.dbService;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.service.ServiceRegistry;
import ru.dolgov.web.dbService.DAO.UserDao;
import ru.dolgov.web.dbService.dataSet.UserDataSet;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * BigComp
 * 04.01.2017.
 */
public class DbServiceImpl implements DbService{
    private static final String HIBERNATE_SHOW_SQL = "true";
    private static final String HIBERNATE_HBM2DDL_AUTO = "create";

    private final SessionFactory sessionFactory;

    public DbServiceImpl() {
        Configuration configuration = getMySqlConfiguration();
        sessionFactory = createSessionFactory(configuration);
    }

    private Configuration getMySqlConfiguration(){
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(UserDataSet.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/db_example");
        configuration.setProperty("hibernate.connection.username", "user");
        configuration.setProperty("hibernate.connection.password", "user");
        configuration.setProperty("hibernate.show_sql", HIBERNATE_SHOW_SQL);
        configuration.setProperty("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
        return configuration;
    }

    private static SessionFactory createSessionFactory(Configuration configuration){
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public void printConnectInfo() {
        try {
            SessionFactoryImpl sessionFactoryImpl = (SessionFactoryImpl) sessionFactory;
            Connection connection = sessionFactoryImpl.getConnectionProvider().getConnection();
            System.out.println("DB name: " + connection.getMetaData().getDatabaseProductName());
            System.out.println("DB version: " + connection.getMetaData().getDatabaseProductVersion());
            System.out.println("Driver: " + connection.getMetaData().getDriverName());
            System.out.println("Autocommit: " + connection.getAutoCommit());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public long addUser(String name, String password) throws DbException{
        try{
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            UserDao dao = new UserDao(session);
            long id = dao.insertUser(name, password);
            transaction.commit();
            session.close();
            return id;
        }catch (HibernateException ex){
            throw new DbException(ex);
        }
    }

    public UserDataSet getUserByLogin(String name) throws DbException{
        try{
            Session session = sessionFactory.openSession();
            UserDao dao = new UserDao(session);
            UserDataSet dataSet = dao.getUser(name);
            session.close();
            return dataSet;
        }catch (HibernateException ex){
            throw new DbException(ex);
        }
    }

    public UserDataSet getUser(long id) throws DbException{
        try{
            Session session = sessionFactory.openSession();
            UserDao dao = new UserDao(session);
            UserDataSet dataSet = dao.get(id);
            session.close();
            return dataSet;
        }catch (HibernateException ex){
            throw new DbException(ex);
        }
    }
}
