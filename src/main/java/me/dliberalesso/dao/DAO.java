package me.dliberalesso.dao;

import java.util.Collection;

/**
 * @author Douglas Liberalesso
 */

public interface DAO<T> {
    T salvarOuAlterar(T objeto);

    T buscar(int id);

    Collection<T> todos();

    T deletar(T objeto);
}
