package peaksoft.dao;

import org.hibernate.*;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    @Override
    public void createUsersTable() {
        String query = """
                CREATE TABLE IF NOT EXISTS users (
                      id        SERIAL PRIMARY KEY,
                      name      VARCHAR NOT NULL,
                      last_name VARCHAR,
                      age       INT
                  );
                  """;
        Connection connection = Util.getConnection();
        try {
            assert connection != null;
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropUsersTable() {
        String query = "DROP TABLE IF EXISTS users;";
        Connection connection = Util.getConnection();
        try {
            assert connection != null;
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeUserById(long id) {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User WHERE id = :userId");
            query.setParameter("userId", id);
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();
        try {
            SessionFactory sessionFactory = Util.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("FROM User");
            users = query.list();
            session.getTransaction().commit();
            session.close();
        } catch (SessionException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
}

