package me.dliberalesso;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Douglas Liberalesso
 */

public class HibernateUtilTest {
    static SessionFactory sessionFactory;
    static Session session;

    @BeforeClass
    public static void setUp() {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = HibernateUtil.getSession();
    }

    @AfterClass
    public static void tearDown() {
        HibernateUtil.closeFactory();
    }

    @Test
    public void testSessionFactoryNotNull() {
        assertNotNull(sessionFactory);
    }

    @Test
    public void testSessionNotNull() {
        assertNotNull(session);
    }

    @Test
    public void testSessionOpenAndClose() {
        assertTrue(session.isOpen() && session.isConnected());
        session.close();
        assertFalse(session.isOpen());
        assertFalse(session.isConnected());
    }
}