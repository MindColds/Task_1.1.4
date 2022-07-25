package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class Util {

/*    private static final String URL = "jdbc:mysql://localhost:3306/test1"; // база для DAOJDBC
    private static final String USERNAME = "root";
    private static final String PASSWORD = "DragonSerg";

    public static Connection getConnection(){

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException  e) {
            e.printStackTrace();
        }
        return connection;
    }*/

    private static final String URL = "jdbc:mysql://localhost:3306/test1";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "DragonSerg";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static SessionFactory sessionFactory;

    public static SessionFactory getConnection() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration()
                        .setProperty(Environment.URL, URL)
                        .setProperty(Environment.USER, USERNAME)
                        .setProperty(Environment.PASS, PASSWORD)
                        //.setProperty(Environment.DRIVER, DRIVER)
                        .addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

}// реализуйте настройку соеденения с БД








