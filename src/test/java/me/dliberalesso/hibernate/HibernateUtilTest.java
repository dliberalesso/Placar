package me.dliberalesso.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testes de unidade de HibernateUtil.
 */
public class HibernateUtilTest {
    private static SessionFactory sessionFactory;
    private static Session session;

    /**
     * Roda apenas uma vez, antes do primeiro teste desta classe.
     */
    @BeforeClass
    public static void setUp() {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = HibernateUtil.getSession();
    }

    /**
     * Roda apenas uma vez, apos o ultimo teste desta classe.
     */
    @AfterClass
    public static void tearDown() {
        HibernateUtil.closeFactory();
    }

    /**
     * Assegura que a sessionFactory existe e nao eh nula.
     */
    @Test
    public void testSessionFactoryNotNull() {
        assertNotNull(sessionFactory);
    }

    /**
     * Assegura que uma sessao existe e nao eh nula.
     */
    @Test
    public void testSessionNotNull() {
        assertNotNull(session);
    }

    /**
     * Assegura que eh possivel abrir uma sessao e conectar, fechar e desconectar.
     */
    @Test
    public void testSessionOpenAndClose() {
        assertTrue(session.isOpen() && session.isConnected());
        session.close();
        assertFalse(session.isOpen());
        assertFalse(session.isConnected());
    }
}