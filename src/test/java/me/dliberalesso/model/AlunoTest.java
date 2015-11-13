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
        assertEquals("[ID: 0] Douglas Liberalesso", aluno.toString());
    }
}