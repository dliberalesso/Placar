package me.dliberalesso.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Define atributos basicos e necessarios para todas as Entidades que compoem o Modelo.
 *
 * <p>Esta classe contem um conjunto de <i>setters</i> e <i>getters</i> e estabelece nomes
 * apropriados para as colunas no Banco de Dados.</p>
 *
 * @author Adair Limana
 * @author Douglas Liberalesso
 */

@MappedSuperclass
public abstract class BaseEntity {
    private int id;
    private Date createdAt;
    private Date updatedAt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "created_at")
    @CreationTimestamp
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "updated_at")
    @UpdateTimestamp
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();

    @Override
    public abstract String toString();
}
