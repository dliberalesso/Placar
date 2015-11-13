package me.dliberalesso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDate;

/**
 * @author Douglas Liberalesso
 */

@Entity
@Table(name = "aluno", uniqueConstraints = @UniqueConstraint(columnNames = {"nome", "sobrenome"}))
public class Aluno extends BaseEntity {
    private String nome, sobrenome, email;
    private LocalDate nascimento;

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
