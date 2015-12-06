package me.dliberalesso.hibernate;

import org.hibernate.Session;

/**
 * Um objeto desta classe eh, essecialmente, uma sessao do Hibernate junto ao banco de dados.
 */
public class SessionManager {
    protected Session session;

    /**
     * Abre a sessao e inicia uma transacao.
     */
    protected void openAndBeginTx() {
        session = HibernateUtil.getSession();
        session.beginTransaction();
    }

    /**
     * Desfaz alteracoes que ainda nao foram comprossidados.
     */
    protected void rollBack() {
        session.getTransaction().rollback();
        session.close();
    }

    /**
     * Compromissa as alteracoes e fecha a sessao.
     */
    protected void commitAndClose() {
        session.getTransaction().commit();
        session.close();
    }
}
