package me.dliberalesso.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Modela Equipe e confere comportamento.
 * <p>
 * Equipe eh composta por nome, escola e uma lista de alunos.
 */

public class Equipe {
    private String nome, escola;
    private List<Aluno> alunoList;

    /**
     * Construtor generico utilizado pela GUI.
     */
    public Equipe() {
        alunoList = new ArrayList<>();
    }

    /**
     * Retorna o nome da Equipe.
     *
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Seta o nome da Equipe.
     *
     * @param nome String que representa o nome da Equipe
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o nome da ESCOLA da Equipe.
     *
     * @return escola
     */
    public String getEscola() {
        return escola;
    }

    /**
     * Seta o nome da ESCOLA da Equipe.
     *
     * @param escola String com o nome da escola
     */
    public void setEscola(String escola) {
        this.escola = escola;
    }

    /**
     * Retorna uma lista contendo os alunos integrantes da Equipe.
     *
     * @return alunoList
     */
    public List<Aluno> getAlunoList() {
        return alunoList;
    }

    /**
     * Adiciona um Aluno na Equipe.
     *
     * @param aluno Aluno que integra a Equipe
     */
    public void addAluno(Aluno aluno) {
        alunoList.add(aluno);
    }
}
