package me.dliberalesso.model;

import org.hibernate.CallbackException;
import org.hibernate.Session;
import org.hibernate.classic.Lifecycle;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Modela a entidade Aluno e confere comportamento.
 * Aluno eh composto por nome, sobrenome, email e nascimento, os quais sao salvos no banco de dados.
 * Alem disso, Aluo ainda sera composto por idade, a qual eh calculada em tempo de execucao e nao eh salva
 * no banco de dados.
 */
@Entity
@Table(name = "aluno", uniqueConstraints = @UniqueConstraint(columnNames = {"nome", "sobrenome"}))
public class Aluno extends BaseEntity implements Lifecycle {
    private String nome, sobrenome, email;
    private LocalDate nascimento;
    private long idade;

    /**
     * Construtor que deve ser utilizado apenas pela JPA.
     */
    public Aluno() {
        // JPA only
    }

    /**
     * Constroi um objeto Aluno basico.
     *
     * @param nome      Nome do aluno
     * @param sobrenome Sobrenome do aluno
     */
    public Aluno(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    /**
     * Retorna o nome do Aluno.
     * @return nome
     */
    @Column(name = "nome", nullable = false)
    public String getNome() {
        return nome;
    }

    /**
     * Seta o nome do Aluno.
     * @param nome String que representa o nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o sobrenome do Aluno.
     * @return sobrenome
     */
    @Column(name = "sobrenome", nullable = false)
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * Seta o sobrenome do Aluno.
     * @param sobrenome String que representa o sobrenome
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * Retorna o email do Aluno.
     * @return email
     */
    @Column(name = "email", nullable = true, unique = true)
    public String getEmail() {
        return email;
    }

    /**
     * Seta o email do Aluno.
     * @param email String que representa o email
     */
    public void setEmail(String email) {
        // TODO Garantir que email seja válido
        this.email = email;
    }

    /**
     * Retorna a data de nascimento do Aluno.
     * @return nascimento
     */
    @Column(name = "nascimento", nullable = true)
    public LocalDate getNascimento() {
        return nascimento;
    }

    /**
     * Seta a data de nascimento do Aluno, desde que a data seja inferior a data atual.
     * Se a data for igual ou superior a data atual, joga uma excecao.
     *
     * @param nascimento Data de nascimento
     * @throws IllegalArgumentException Data de nascimento nao pode ser menor que data atual
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
     * Atributo nao eh salvo no banco de dados.
     * @return idade
     */
    @Transient
    public long getIdade() {
        return idade;
    }

    /**
     * Seta a idade do Aluno.
     * Atributo nao eh salvo no banco de dados.
     * @param idade Inteiro que representa a idade
     */
    public void setIdade(long idade) {
        this.idade = idade;
    }

    /**
     * Calcula a idade do Aluno no momento em que o objeto eh inserido no banco de dados.
     * Idade nunca eh salva no banco de dados.
     * @param session Sessao do Hibernate
     * @return false
     * @throws CallbackException Excecao da interface
     */
    @Override
    public boolean onSave(Session session) throws CallbackException {
        calculaIdade();
        return false;
    }

    /**
     * Calcula a idade do Aluno no momento em que o objeto eh salvo no banco de dados.
     * Idade nunca eh salva no banco de dados.
     * @param session Sessao do Hibernate
     * @return false
     * @throws CallbackException Excecao da interface
     */
    @Override
    public boolean onUpdate(Session session) throws CallbackException {
        calculaIdade();
        return false;
    }

    /**
     * Nao tem funcao. Serve apenas para cumprir o contrato da interface.
     * @param session Sessao do Hibernate
     * @return false
     * @throws CallbackException Excecao da interface
     */
    @Override
    public boolean onDelete(Session session) throws CallbackException {
        return false;
    }

    /**
     * Clacula a idade de Aluno no momento em que o objeto eh carregado do banco de dados.
     * @param session Sessao do Hibernate
     * @param serializable Serializable
     */
    @Override
    public void onLoad(Session session, Serializable serializable) {
        calculaIdade();
    }

    /**
     * Responsavel por calcular a idade de Aluno com base na data de nascimento e a data atual.
     * Se nao existir data de nascimento, nao faz nada.
     */
    protected void calculaIdade() {
        if (nascimento != null) {
            LocalDate agora = LocalDate.now();
            setIdade(ChronoUnit.YEARS.between(nascimento, agora));
        }
    }

    /**
     * Determina a igualdade entre objetos.
     * Para ser igual eh necessario que nome, sobrenome, email e nascimento sejam iguais.
     * @param o Objeto com o qual se deseja comparar
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aluno aluno = (Aluno) o;

        if (!getNome().equals(aluno.getNome())) return false;
        if (!getSobrenome().equals(aluno.getSobrenome())) return false;
        if (getEmail() != null ? !getEmail().equals(aluno.getEmail()) : aluno.getEmail() != null) return false;
        return !(getNascimento() != null ? !getNascimento().equals(aluno.getNascimento()) : aluno.getNascimento() != null);
    }

    /**
     * Calcula o hashcode correspondente ao Aluno.
     * @return hash
     */
    @Override
    public int hashCode() {
        int result = getNome().hashCode();
        result = 31 * result + getSobrenome().hashCode();
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getNascimento() != null ? getNascimento().hashCode() : 0);
        return result;
    }

    /**
     * Retorna uma string representativa do Aluno.
     * @return string
     */
    @Override
    public String toString() {
        return String.format("[ID: %d] %s %s", getId(), nome, sobrenome);
    }
}
