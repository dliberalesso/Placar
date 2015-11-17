package me.dliberalesso.dao;

import me.dliberalesso.model.Aluno;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Douglas Liberalesso
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AlunoDAOTest {
    private static AlunoDAO alunoDAO;
    private static int expectedSize;

    @BeforeClass
    public static void setUp() throws Exception {
        alunoDAO = new AlunoDAO();
        expectedSize = 0;
    }

    @Test
    public void testSalvarBuscar() {
        Aluno aluno = new Aluno("Douglas", "Liberalesso");
        alunoDAO.salvar(aluno);
        expectedSize++;
        assertEquals(aluno, alunoDAO.buscar(1));
        aluno = new Aluno("Susane", "Engel");
        alunoDAO.salvar(aluno);
        expectedSize++;
    }

    @Test
    public void test2Todos() {
        List<Aluno> alunoList = (List<Aluno>) alunoDAO.todos();
        assertEquals(expectedSize, alunoList.size());
    }
}