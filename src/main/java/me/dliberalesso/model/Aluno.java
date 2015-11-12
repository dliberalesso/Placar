package me.dliberalesso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;

/**
 * @author Douglas Liberalesso
 */

@Entity
@Table(name = "aluno", uniqueConstraints = @UniqueConstraint(columnNames = {"nome", "sobrenome"}))
public class Aluno extends BaseEntity {
    private String nome, sobrenome, email;
    private Date nascimento;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }


    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "[ID: " + this.getId() + "] " + nome + " " + sobrenome + "]";
    }
}
