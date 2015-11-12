package me.dliberalesso.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Douglas Liberalesso
 */

@Entity
public class Aluno {
    private int id;
    private String nome;
    private int idade;

    public Aluno() {
        // JPA & Hibernate only
    }

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return nome;
    }
}
