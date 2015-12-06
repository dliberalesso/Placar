package me.dliberalesso.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.jboss.logging.Logger;

/**
 * Contem metodos estaticos e utilitarios para uso do Hibernate.
 * De forma a facilitar o diagnostico de erros, todos os metodos da classe imprimem para o log.
 */

public final class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static Logger logger = Logger.getLogger(HibernateUtil.class);

    /**
     * Constroi uma SessionFactory
     *
     * @return sessionFactory
     */
    protected static SessionFactory getSessionFactory() {
        if (sessionFactory == null || sessionFactory.isClosed()) {
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

    /**
     * Abre uma nova sessao junto ao banco de dados
     * @return session
     */
    public static Session getSession() {
        return getSessionFactory().openSession();
    }

    /**
     * Fecha a SessionFactory
     */
    public static void closeFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
            logger.info("SessionFactory closed.");
        }
    }
}