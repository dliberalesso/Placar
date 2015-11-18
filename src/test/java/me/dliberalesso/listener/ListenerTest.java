package me.dliberalesso.listener;

import me.dliberalesso.dao.AlunoDAO;
import me.dliberalesso.model.Aluno;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author Douglas Liberalesso
 */

public class ListenerTest {
    private static Aluno aluno;
    private static AlunoDAO alunoDAO;

    @BeforeClass
    public static void setUp() {
        alunoDAO = new AlunoDAO();
        aluno = new Aluno("Adair", "Limana");
        alunoDAO.salvar(aluno);
    }

    @Test
    public void testPrePersist() {
        assertEquals(aluno.getCreatedAt(), aluno.getUpdatedAt());
    }

    @Test
    public void testPreUpdate() {
        aluno.setEmail("adalimana@yahoo.com");
        alunoDAO.alterar(aluno);
        assertNotEquals(aluno.getCreatedAt(), aluno.getUpdatedAt());
    }
}