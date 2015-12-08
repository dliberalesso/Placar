package me.dliberalesso.view;

import me.dliberalesso.model.Prova;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cronometro extends JPanel {
    private int miliSegundos = 0;
    private int velocidade = 1; // 1 milisegundo por vez
    private boolean iniciou = false;

    private Timer timer;
    private Prova prova;

    private JLabel labelContador;
    private JButton buttonIniciar, buttonPenalizar, buttonParar;

    public Cronometro(Prova prova) throws HeadlessException {
        this.prova = prova;
        this.setLayout(new BorderLayout(5, 5));

        // Contador
        labelContador = new JLabel("00:00:000", SwingConstants.CENTER);
        labelContador.setPreferredSize(new Dimension(300, 100));
        labelContador.setFont(labelContador.getFont().deriveFont(48.0f));
        labelContador.setBorder(BorderFactory.createEtchedBorder());
        this.add(labelContador, BorderLayout.PAGE_START);

        // Botao Iniciar
        buttonIniciar = new JButton("Iniciar");
        buttonIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!iniciou) {
                    iniciar();
                    iniciou = true;
                }
            }
        });
        this.add(buttonIniciar, BorderLayout.LINE_START);

        // Botao Penalizar
        buttonPenalizar = new JButton("Penalizar");
        buttonPenalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miliSegundos += (prova.getPenalidade() * 1000);
            }
        });
        this.add(buttonPenalizar, BorderLayout.CENTER);

        // Botao Parar
        buttonParar = new JButton("Parar");
        buttonParar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                iniciou = false;
            }
        });
        this.add(buttonParar, BorderLayout.LINE_END);
    }

    private void iniciar() {
        ActionListener timerListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ms = miliSegundos++;

                if (miliSegundos >= (prova.getTempoMaximo() * 1000)) {
                    timer.stop();
                }

                int minutos = ms / 60000;
                ms = ms % 60000;
                int segundos = ms / 1000;
                ms = ms % 1000;


                String min = minutos <= 9 ? ("0" + minutos) : (minutos + "");
                String seg = segundos <= 9 ? ("0" + segundos) : (segundos + "");
                String mili;
                if (ms <= 9) {
                    mili = "00" + ms;
                } else if (ms <= 99) {
                    mili = "0" + ms;
                } else {
                    mili = ms + "";
                }

                labelContador.setText(String.format("%s:%s:%s", min, seg, mili));
            }
        };

        timer = new Timer(velocidade, timerListener);
        timer.start();
    }

    /**
     * Retorna o tempo registrado em milisegundos.
     *
     * @return miliSegundos.
     */
    public int getMiliSegundos() {
        return miliSegundos;
    }
}
