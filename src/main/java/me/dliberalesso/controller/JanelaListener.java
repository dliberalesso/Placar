package me.dliberalesso.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class JanelaListener implements WindowListener {
    @Override
    public void windowOpened(WindowEvent e) {
        // nada
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // nada
    }

    @Override
    public void windowClosed(WindowEvent e) {
        Controlador.mostraInicio();
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // nada
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // nada
    }

    @Override
    public void windowActivated(WindowEvent e) {
        // nada
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // nada
    }
}
