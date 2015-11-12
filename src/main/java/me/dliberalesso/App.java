package me.dliberalesso;

import me.dliberalesso.model.Aluno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author Douglas Liberalesso
 */

public class App {
    private static SessionFactory sessionFactory;

    private static void createSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    private static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public static void main(String[] args) {
        createSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new Aluno("Douglas Liberalesso", 25));
        session.getTransaction().commit();
        session.close();

        closeSessionFactory();
    }
}
