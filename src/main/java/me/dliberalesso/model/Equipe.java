package me.dliberalesso.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Modela Equipe e confere comportamento.
 * <p>
 * Equipe eh composta por nome, escola e uma lista de alunos.
 */

public class Equipe {
    private int pontuacao;
    private String nome, escola;
    private List<Aluno> alunoList;

    /**
     * Construtor generico utilizado pela GUI.
     */
    public Equipe() {
        pontuacao = 0;
        alunoList = new ArrayList<>();
    }

    /**
     * Retorna a pontuacao acumulada da Equipe.
     *
     * @return pontuacao;
     */
    public int getPontuacao() {
        return pontuacao;
    }

    /**
     * Adiciona pontos na pontuacao da Equipe.
     *
     * @param pontos Pontos para adicionar
     */
    public void addPontos(int pontos) {
        pontuacao += pontos;
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
     * Seta uma lista contendo os alunso integrantes da Equipe.
     *
     * @param alunoList Lista de alunos
     */
    public void setAlunoList(List<Aluno> alunoList) {
        this.alunoList = alunoList;
    }

    @Override
    public String toString() {
        return nome + "  -  " + escola;
    }
}
