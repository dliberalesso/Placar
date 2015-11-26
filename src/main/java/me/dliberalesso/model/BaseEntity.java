package me.dliberalesso.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Define atributos basicos e necessarios para todas as Entidades que compoem o Modelo.
 * <p>
 * Esta classe contem um conjunto de <i>setters</i> e <i>getters</i> e estabelece nomes
 * apropriados para as colunas no Banco de Dados.
 */

@MappedSuperclass
public abstract class BaseEntity {
    private int id;
    private Date createdAt;
    private Date updatedAt;

    /**
     * Retorna o identificador da entidade junto ao Banco de Dados.
     *
     * @return id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    /**
     * Seta o ID da entidade junto ao Banco de Dados.
     * @param id Atributo identificador
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna a data em que a entidade foi salva pela primeira vez no Banco de Dados.
     * @return createdAt
     */
    @Column(name = "created_at")
    @CreationTimestamp
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Seta a data em que a entidade foi salva pela primeira vez no Banco de Dados.
     * @param createdAt Data em que a entidade foi criada
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Retorna a data em que a entidade foi modificada pela ultima vez no Banco de Dados.
     * @return updatedAt
     */
    @Column(name = "updated_at")
    @UpdateTimestamp
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Seta a data em que a entidade foi modificada pela ultima vez no Banco de Dados.
     * @param updatedAt Data em que a entidade foi modificada
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Retorna um booleano que representa a igualdade entre os objetos.
     * @param o Objeto com o qual se deseja comparar
     * @return true or false
     */
    @Override
    public abstract boolean equals(Object o);

    /**
     * Retorna o hashcode representativo do objeto.
     * @return hashCode
     */
    @Override
    public abstract int hashCode();

    /**
     * Retorna a representação do objeto em uma String.
     * @return String
     */
    @Override
    public abstract String toString();
}
