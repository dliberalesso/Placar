package me.dliberalesso.model;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Responsavel pelos testes de unidade da classe Aluno.
 * Testes sao feitos utilizando o objeto criado com o construtor <b>Aluno("Douglas", "Liberalesso")</b>.
 */
public class AlunoTest {
    private Aluno aluno = new Aluno("Douglas", "Liberalesso");

    /**
     * Verifica se o Aluno se transforma na string <b>"[ID: 0] Douglas Liberalesso"</b>.
     */
    @Test
    public void testToString() {
        assertEquals("[ID: 0] Douglas Liberalesso", aluno.toString());
    }

    /**
     * Verifica se o hash do Aluno eh igual <b>1806255398</b>.
     */
    @Test
    public void testHashCode() {
        int hashCode = (31 * aluno.getNome().hashCode() + aluno.getSobrenome().hashCode()) * 31 * 31;
        System.out.println(hashCode);
        assertEquals(hashCode, aluno.hashCode());
    }

    /**
     * Verifica a igualdade de dois objetos criados com o mesmo construtor e os mesmos parametros.
     */
    @Test
    public void testIsEqual() {
        Aluno aluno1 = new Aluno("Douglas", "Liberalesso");
        assertEquals(aluno1, aluno);
    }

    /**
     * Verifica se Alunos criados com parametros diferentes sao efetivamente diferentes.
     */
    @Test
    public void testNotEqual() {
        Aluno aluno1 = new Aluno("Douuglas", "Liberalesso");
        assertNotEquals(aluno1, aluno);
    }

    /**
     * Verifica se o calculo da idade funciona.
     * Idade ainda esta harcoded.
     */
    @Test
    public void testCalculaIdade() {
        aluno.setNascimento(LocalDate.of(1989, 12, 22));
        aluno.calculaIdade();
        assertEquals(25, aluno.getIdade());
    }
}