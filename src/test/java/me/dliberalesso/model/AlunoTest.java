package me.dliberalesso.model;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AlunoTest {
    private Aluno aluno = new Aluno("Douglas", "Liberalesso");

    @Test
    public void testToString() {
        assertEquals("[ID: 0] Douglas Liberalesso", aluno.toString());
    }

    @Test
    public void testHashCode() {
        int hashCode = (31 * aluno.getNome().hashCode() + aluno.getSobrenome().hashCode()) * 31 * 31;
        assertEquals(hashCode, aluno.hashCode());
    }

    @Test
    public void testIsEqual() {
        Aluno aluno1 = new Aluno("Douglas", "Liberalesso");
        assertEquals(aluno1, aluno);
    }

    @Test
    public void testNotEqual() {
        Aluno aluno1 = new Aluno("Douuglas", "Liberalesso");
        assertNotEquals(aluno1, aluno);
    }

    @Test
    public void testCalculaIdade() {
        aluno.setNascimento(LocalDate.of(1989, 12, 22));
        aluno.calculaIdade();
        assertEquals(25, aluno.getIdade());
    }
}