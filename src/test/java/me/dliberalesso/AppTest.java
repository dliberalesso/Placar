package me.dliberalesso;

import me.dliberalesso.model.Aluno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Douglas Liberalesso
 */

public class AppTest {
    private SessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @Test
    public void testSaveAluno() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new Aluno("Douglas Liberalesso", 25));
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        List alunos = session.createQuery("from Aluno").list();
        assertNotNull(alunos);
        assertEquals(1, alunos.size());
        session.getTransaction().commit();
        session.close();
    }

    @After
    public void tearDown() throws Exception {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}