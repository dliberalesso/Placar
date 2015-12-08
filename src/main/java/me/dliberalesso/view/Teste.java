package me.dliberalesso.view;

import me.dliberalesso.model.Prova;

import javax.swing.*;
import java.awt.*;

public class Teste extends JFrame {
    private Cronometro cronometro;
    private Prova prova;

    public Teste() throws HeadlessException {
        Container container = getContentPane();
        prova = new Prova();
        prova.setPenalidade(10);
        prova.setTempoMaximo(180);
        cronometro = new Cronometro(prova);
        container.add(cronometro);
        setSize(310, 170);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
