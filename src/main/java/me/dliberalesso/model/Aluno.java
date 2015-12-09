package me.dliberalesso.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Modela Aluno e confere comportamento.
 * <p>
 * Aluno eh composto por nome, sobrenome, email e nascimento.
 * <p>
 * Alem disso, Aluno ainda tem idade, a qual eh calculada em tempo de execucao.
 */
public class Aluno {
    private String nome, sobrenome, email;
    private LocalDate nascimento;

    /**
     * Construtor generico utilizado pela GUI.
     */
    public Aluno() {
        // Generico
    }

    /**
     * Retorna uma String com o nome do Aluno.
     *
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Seta o nome do Aluno.
     *
     * @param nome String que representa o nome do Aluno
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna uma String com o sobrenome do Aluno.
     *
     * @return sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * Seta o sobrenome do Aluno.
     *
     * @param sobrenome String que representa o sobrenome do Aluno
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * Retorna o email do Aluno.
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Seta o email do Aluno.
     *
     * @param email String que representa o email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna a data de nascimento do Aluno.
     *
     * @return nascimento
     */
    public LocalDate getNascimento() {
        return nascimento;
    }

    /**
     * Seta a data de nascimento do Aluno, desde que a data seja inferior a data atual.
     * Se a data for igual ou superior a data atual, joga uma excecao.
     *
     * @param nascimento Data de nascimento
     * @throws IllegalArgumentException Data de nascimento nao pode ser menor que a atual
     */
    public void setNascimento(LocalDate nascimento) throws IllegalArgumentException {
        if (nascimento.isBefore(LocalDate.now())) {
            this.nascimento = nascimento;
        } else {
            throw new IllegalArgumentException("Data de nascimento não pode ser menor que Hoje");
        }
    }

    /**
     * Retorna a idade do Aluno, calculada em tempo de execucao.
     *
     * @return idade
     */
    public long getIdade() {
        if (nascimento != null) {
            LocalDate agora = LocalDate.now();
            return (ChronoUnit.YEARS.between(nascimento, agora));
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return nome + " " + sobrenome + ", " + getIdade() + " anos;";
    }
}
