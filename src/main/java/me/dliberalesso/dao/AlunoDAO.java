package me.dliberalesso.dao;

import me.dliberalesso.hibernate.SessionManager;
import me.dliberalesso.model.Aluno;

import java.util.Collection;

/**
 * Responsavel pelo acesso da tabela Alunos junto ao banco de dados
 */
public class AlunoDAO extends SessionManager implements DAO<Aluno> {
    /**
     * Salva ou Altera um aluno junto ao banco de dados.
     *
     * @param objeto Aluno a ser salvo
     * @return aluno
     */
    @Override
    public Aluno salvarOuAlterar(Aluno objeto) {
        openAndBeginTx();

        session.saveOrUpdate(objeto);

        session.flush();
        commitAndClose();
        return objeto;
    }

    /**
     * Busca um aluno no banco de dados com base no atributo identificador.
     * @param id Atributo identificador
     * @return aluno
     */
    @Override
    public Aluno buscar(int id) {
        openAndBeginTx();

        Aluno busca = session.get(Aluno.class, id);

        session.flush();
        commitAndClose();
        return busca;
    }

    /**
     * Retorna todos os alunos existentes no banco de dados.
     * @return todos
     */
    @Override
    public Collection<Aluno> todos() {
        openAndBeginTx();

        @SuppressWarnings("unchecked")
        Collection<Aluno> todos = session.createQuery("from Aluno").list();

        commitAndClose();
        return todos;
    }

    /**
     * Deleta o aluno do banco de dados
     * @param objeto Aluno que sera deletado
     * @return aluno
     */
    @Override
    public Aluno deletar(Aluno objeto) {
        openAndBeginTx();

        session.delete(objeto);

        session.flush();
        commitAndClose();
        return objeto;
    }
}
