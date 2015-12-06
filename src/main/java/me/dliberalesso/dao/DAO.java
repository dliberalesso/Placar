package me.dliberalesso.dao;

import java.util.Collection;

/**
 * Interface que impoe os principais metodos de uma classe DAO.
 */
public interface DAO<T> {
    /**
     * Salvar ou Altera o objeto, de acordo com o modelo, no banco de dados.
     *
     * @param objeto Objeto a ser salvo
     * @return objeto
     */
    T salvarOuAlterar(T objeto);

    /**
     * Buscar no banco de dados, de acordo com o respectivo modelo, com base no id.
     * @param id Atributo identificador
     * @return objeto encontrado
     */
    T buscar(int id);

    /**
     * Retorna todas as entradas de uma determinada tabela, de acordo com o respectivo modelo.
     * @return todos
     */
    Collection<T> todos();

    /**
     * Deleta  a entrada correspondente ao objeto passado.
     * @param objeto O que sera deletado
     * @return objeto
     */
    T deletar(T objeto);
}
