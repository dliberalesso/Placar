package me.dliberalesso.dao;

import me.dliberalesso.model.Aluno;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Douglas Liberalesso
 */

public class AlunoDAOTest {
    private static AlunoDAO alunoDAO;
    private static int expectedSize;

    @BeforeClass
    public static void setUp() {
        alunoDAO = new AlunoDAO();
        expectedSize = 0;
    }

    @Test
    public void testSalvarBuscar() {
        Aluno aluno = new Aluno("Douglas", "Liberalesso");
        alunoDAO.salvar(aluno);
        expectedSize++;
        assertEquals(aluno, alunoDAO.buscar(aluno.getId()));
        aluno = new Aluno("Susane", "Engel");
        alunoDAO.salvar(aluno);
        expectedSize++;
    }

    @Test
    public void testAlterar() {
        Aluno aluno = new Aluno("Adriana", "Liberalesso");
        String nome = "Mauricio";
        alunoDAO.salvar(aluno);
        expectedSize++;
        aluno.setNome(nome);
        alunoDAO.alterar(aluno);
        assertEquals(nome, alunoDAO.buscar(aluno.getId()).getNome());
    }

    @Test
    public void testTodos() {
        List<Aluno> alunoList = (List<Aluno>) alunoDAO.todos();
        assertEquals(expectedSize, alunoList.size());
    }

    @Test
    public void testDeletar() {
        Aluno aluno = new Aluno("Marlon", "Arguilar");
        alunoDAO.salvar(aluno);
        expectedSize++;
        alunoDAO.deletar(aluno);
        expectedSize--;
        assertNull(alunoDAO.buscar(aluno.getId()));
    }
}