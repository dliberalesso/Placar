package me.dliberalesso.dao;

import java.util.Collection;

/**
 * @author Douglas Liberalesso
 */

public interface DAO<T> {
    T salvar(T objeto);

    T alterar(T objeto);

    T buscar(int id);

    Collection<T> todos();

    T deletar(T objeto);
}
