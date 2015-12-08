package me.dliberalesso.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author Douglas Liberalesso
 */

public class Cronometro extends JPanel {
    private JLabel labelContador;
    private JButton buttonIniciar, buttonPenalizar, buttonPausar;

    public Cronometro() throws HeadlessException {
        this.setLayout(new BorderLayout(5, 5));

        // Contador
        labelContador = new JLabel("00:00:000", SwingConstants.CENTER);
        labelContador.setPreferredSize(new Dimension(300, 100));
        labelContador.setFont(labelContador.getFont().deriveFont(48.0f));
        this.add(labelContador, BorderLayout.PAGE_START);

        // Botao Iniciar
        buttonIniciar = new JButton("Iniciar");
        this.add(buttonIniciar, BorderLayout.LINE_START);

        // Botao Penalizar
        buttonPenalizar = new JButton("Penalizar");
        this.add(buttonPenalizar, BorderLayout.CENTER);

        // Botao Pausar
        buttonPausar = new JButton("Pausar");
        this.add(buttonPausar, BorderLayout.LINE_END);
    }
}
