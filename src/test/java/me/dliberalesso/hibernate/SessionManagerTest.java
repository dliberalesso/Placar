package me.dliberalesso.hibernate;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SessionManagerTest extends SessionManager {

    @Test
    public void testOpenAndBeginTx() {
        openAndBeginTx();
        assertTrue(session.isOpen() && session.isConnected());
        commitAndClose();
    }

    @Test
    public void testCommitAndClose() {
        openAndBeginTx();
        commitAndClose();
        assertFalse(session.isOpen());
        assertFalse(session.isConnected());
    }
}