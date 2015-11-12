package me.dliberalesso;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.jboss.logging.Logger;

/**
 * @author Douglas Liberalesso
 */

public final class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static Logger logger = Logger.getLogger(HibernateUtil.class);

    protected static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

            try {
                sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
                logger.info("SessionFactory built.");
            } catch (Exception e) {
                e.printStackTrace();
                StandardServiceRegistryBuilder.destroy(registry);
            }
        }

        return sessionFactory;
    }

    public static Session getSession() {
        return getSessionFactory().openSession();
    }

    public static void closeFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
            logger.info("SessionFactory closed.");
        }
    }
}