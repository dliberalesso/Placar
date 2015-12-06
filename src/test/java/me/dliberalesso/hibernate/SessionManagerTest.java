package me.dliberalesso.hibernate;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Testes de unidade de SessionManager
 */
public class SessionManagerTest extends SessionManager {

    /**
     * Verifica que o metodo abre uma sessao e conecta
     */
    @Test
    public void testOpenAndBeginTx() {
        openAndBeginTx();
        assertTrue(session.isOpen() && session.isConnected());
        commitAndClose();
    }

    /**
     * Verifica que o metodo compromissa as alteracao e fecha a sessao.
     */
    @Test
    public void testCommitAndClose() {
        openAndBeginTx();
        commitAndClose();
        assertFalse(session.isOpen());
        assertFalse(session.isConnected());
    }
}