package me.dliberalesso.hibernate;

import org.hibernate.Session;

/**
 * @author Douglas Liberalesso
 */

public class SessionManager {
    protected Session session;

    protected void openAndBeginTx() {
        session = HibernateUtil.getSession();
        session.beginTransaction();
    }

    protected void rollBack() {
        session.getTransaction().rollback();
        session.close();
    }

    protected void commitAndClose() {
        session.getTransaction().commit();
        session.close();
    }
}
