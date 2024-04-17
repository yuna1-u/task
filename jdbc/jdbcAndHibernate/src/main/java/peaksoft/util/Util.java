package peaksoft.util;

import peaksoft.model.User;

public class Util {
    // реализуйте настройку соеденения с БД

    public static SessionFactory getSessionFactory() {
         Session sessionFactory = null;
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
}
