package peaksoft.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import peaksoft.model.User;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
    // реализуйте настройку соеденения с БД

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return sessionFactory;
    }

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "0802");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
