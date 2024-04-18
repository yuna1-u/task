package peaksoft;

import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.model.User;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

        User user = new User("Rabi", "Buzurmanalieva", (byte) 17);
        User user2 = new User("Sami", "Uraimjanova", (byte) 16);

        //Creat table
//        userDaoHibernate.createUsersTable();

        //Save user
//        userDaoHibernate.saveUser(user.getName(), user.getLastName(), user.getAge());
//        userDaoHibernate.saveUser(user2.getName(), user2.getLastName(), user2.getAge());

        //Get all
//        System.out.println(userDaoHibernate.getAllUsers());

        //Remove user
//        userDaoHibernate.removeUserById(2);

        //Clean table
//        userDaoHibernate.cleanUsersTable();

        //Drop table
//        userDaoHibernate.dropUsersTable();

    }
}
