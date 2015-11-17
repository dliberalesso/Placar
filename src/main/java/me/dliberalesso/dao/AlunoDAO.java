package me.dliberalesso.dao;

import me.dliberalesso.hibernate.SessionManager;
import me.dliberalesso.model.Aluno;

import java.util.Collection;

/**
 * @author Douglas Liberalesso
 */

public class AlunoDAO extends SessionManager implements DAO<Aluno> {
    @Override
    public Aluno salvar(Aluno objeto) {
        openAndBeginTx();

        session.save(objeto);

        commitAndClose();
        return objeto;
    }

    @Override
    public Aluno buscar(int id) {
        openAndBeginTx();

        Aluno busca = session.get(Aluno.class, id);

        commitAndClose();
        return busca;
    }

    @Override
    public Collection<Aluno> todos() {
        openAndBeginTx();

        @SuppressWarnings("unchecked")
        Collection<Aluno> todos = session.createQuery("from Aluno").list();

        commitAndClose();
        return todos;
    }
}
