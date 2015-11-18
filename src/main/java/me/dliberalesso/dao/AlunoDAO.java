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

        session.flush();
        commitAndClose();
        return objeto;
    }

    @Override
    public Aluno alterar(Aluno objeto) {
        openAndBeginTx();

        session.update(objeto);

        session.flush();
        commitAndClose();
        return objeto;
    }

    @Override
    public Aluno buscar(int id) {
        openAndBeginTx();

        Aluno busca = session.get(Aluno.class, id);

        session.flush();
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

    @Override
    public Aluno deletar(Aluno objeto) {
        openAndBeginTx();

        session.delete(objeto);

        session.flush();
        commitAndClose();
        return objeto;
    }
}
