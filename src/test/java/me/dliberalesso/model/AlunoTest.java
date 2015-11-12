package me.dliberalesso.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Douglas Liberalesso
 */

public class AlunoTest {
    private Aluno aluno = new Aluno("Douglas", "Liberalesso");

    @Test
    public void testToString() {
        String str = "[ID: " + aluno.getId();
        str += "] " + aluno.getNome() + " " + aluno.getSobrenome() + "]";
        assertEquals(str, aluno.toString());
    }
}