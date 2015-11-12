package me.dliberalesso;

import me.dliberalesso.model.Aluno;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Douglas Liberalesso
 */

public class AppTest {
    @Test
    public void testSaveAluno() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(new Aluno("Douglas Liberalesso", 25));
        session.getTransaction().commit();
        session.close();

        session = HibernateUtil.getSession();
        session.beginTransaction();
        List alunos = session.createQuery("from Aluno").list();
        assertNotNull(alunos);
        assertEquals(1, alunos.size());
        session.getTransaction().commit();
        session.close();

        HibernateUtil.closeFactory();
    }
}