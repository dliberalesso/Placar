package me.dliberalesso;

import me.dliberalesso.model.Aluno;
import org.hibernate.PropertyValueException;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Douglas Liberalesso
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AlunoTest {
    static Aluno aluno = new Aluno();
    Session session;

    @BeforeClass
    public static void setUp() {
        aluno = new Aluno();
    }

    @Before
    public void setUpBeforeEachTest() {
        session = HibernateUtil.getSession();
        session.beginTransaction();
    }

    @Test(expected = PropertyValueException.class)
    public void test1DoesNotSaveAlunoWithNullNome() throws Exception {
        session.save(aluno);
    }

    @Test(expected = PropertyValueException.class)
    public void test2DoesNotSaveAlunoWithNullSobrenome() throws Exception {
        aluno.setNome("Douglas");
        session.save(aluno);
    }

    @Test
    public void test3SaveAluno() {
        aluno = new Aluno("Douglas", "Liberalesso");
        session.save(aluno);
        session.getTransaction().commit();
        session.close();

        session = HibernateUtil.getSession();
        session.beginTransaction();
        List alunos = session.createQuery("from Aluno").list();
        assertNotNull(alunos);
        assertEquals(1, alunos.size());
        session.getTransaction().commit();
    }

    @Test(expected = ConstraintViolationException.class)
    public void test4AlunoIsUnique() {
        if (aluno.getNome() == null || aluno.getSobrenome() == null) {
            aluno.setNome("Douglas");
            aluno.setSobrenome("Liberalesso");
            session.save(aluno);
            session.getTransaction().commit();
            session.close();
            setUpBeforeEachTest();
        }

        session.save(aluno);
        session.getTransaction().commit();
        session.close();
    }

    @After
    public void setUpAfterEachTest() {
        session.close();
    }
}