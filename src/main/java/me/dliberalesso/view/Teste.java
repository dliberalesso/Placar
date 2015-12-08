package me.dliberalesso.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author Douglas Liberalesso
 */

public class Teste extends JFrame {
    private Cronometro cronometro;

    public Teste() throws HeadlessException {
        Container container = getContentPane();
        cronometro = new Cronometro();
        container.add(cronometro);
        setSize(310, 170);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
