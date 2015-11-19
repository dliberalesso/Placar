package me.dliberalesso.model;

import org.hibernate.CallbackException;
import org.hibernate.Session;
import org.hibernate.classic.Lifecycle;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "aluno", uniqueConstraints = @UniqueConstraint(columnNames = {"nome", "sobrenome"}))
public class Aluno extends BaseEntity implements Lifecycle {
    private String nome, sobrenome, email;
    private LocalDate nascimento;
    private long idade;

    public Aluno() {
        // JPA only
    }

    public Aluno(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    @Column(name = "nome", nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "sobrenome", nullable = false)
    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Column(name = "email", nullable = true, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        // TODO Garantir que email seja válido
        this.email = email;
    }

    @Column(name = "nascimento", nullable = true)
    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        // TODO Garantir que data de nascimento seja inferior à data atual
        this.nascimento = nascimento;
    }

    @Transient
    public long getIdade() {
        return idade;
    }

    public void setIdade(long idade) {
        this.idade = idade;
    }

    @Override
    public boolean onSave(Session session) throws CallbackException {
        calculaIdade();
        return false;
    }

    @Override
    public boolean onUpdate(Session session) throws CallbackException {
        calculaIdade();
        return false;
    }

    @Override
    public boolean onDelete(Session session) throws CallbackException {
        return false;
    }

    @Override
    public void onLoad(Session session, Serializable serializable) {
        calculaIdade();
    }

    protected void calculaIdade() {
        if (nascimento != null) {
            LocalDate agora = LocalDate.now();
            setIdade(ChronoUnit.YEARS.between(nascimento, agora));
        }
    }

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

    @Override
    public int hashCode() {
        int result = getNome().hashCode();
        result = 31 * result + getSobrenome().hashCode();
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getNascimento() != null ? getNascimento().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("[ID: %d] %s %s", getId(), nome, sobrenome);
    }
}
