package me.dliberalesso.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author Douglas Liberalesso
 */

@Entity
public class Equipe {
    private int id;
    private String nome;
    private List<Aluno> integrantes;

    public Equipe() {
        // JPA & Hibernate only
    }

    public Equipe(String nome) {
        this.nome = nome;
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

    @OneToMany
    public List<Aluno> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Aluno> integrantes) {
        this.integrantes = integrantes;
    }

    @Override
    public String toString() {
        return nome;
    }
}
