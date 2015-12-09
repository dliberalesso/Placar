package me.dliberalesso.view;

import me.dliberalesso.controller.ControladorCadastraProva;
import me.dliberalesso.controller.JanelaListener;
import me.dliberalesso.model.Prova;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastraProva extends JFrame {
    private JLabel labelDescricao, labelTempoMaximo, labelPontuacaoMaxima, labelPenalidade;
    private JTextField fieldDescricao, fieldTempoMaximo, fieldPontuacaoMaxima, fieldPenalidade;
    private JButton buttonConfirma;

    public CadastraProva() throws HeadlessException {
        super("Cadastrar Prova");

        Container container = getContentPane();
        container.setLayout(new GridLayout(5, 2, 5, 5));

        // Linha descricao
        labelDescricao = new JLabel("Descricao:");
        fieldDescricao = new JTextField();
        container.add(labelDescricao);
        container.add(fieldDescricao);

        // Linha TempoMaximo
        labelTempoMaximo = new JLabel("Tempo maximo (segundos):");
        fieldTempoMaximo = new JTextField();
        container.add(labelTempoMaximo);
        container.add(fieldTempoMaximo);

        // Linha pontuacao
        labelPontuacaoMaxima = new JLabel("Pontuacao maxima (inteiros):");
        fieldPontuacaoMaxima = new JTextField();
        container.add(labelPontuacaoMaxima);
        container.add(fieldPontuacaoMaxima);

        // Linha penalidade
        labelPenalidade = new JLabel("Penalidade (segundos)");
        fieldPenalidade = new JTextField();
        container.add(labelPenalidade);
        container.add(fieldPenalidade);

        // Linha botao
        container.add(new JPanel());
        buttonConfirma = new JButton("Confirma");
        buttonConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Prova prova = new Prova();

                try {
                    prova.setDescricao(fieldDescricao.getText());
                    prova.setTempoMaximo(Integer.parseInt(fieldTempoMaximo.getText()));
                    prova.setPontuacaoMaxima(Integer.parseInt(fieldPontuacaoMaxima.getText()));
                    prova.setPenalidade(Integer.parseInt(fieldPenalidade.getText()));
                    ControladorCadastraProva.adicionaProva(prova);
                    dispose();
                } catch (IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(container, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        container.add(buttonConfirma);

        setSize(390, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new JanelaListener());
        setVisible(true);
    }
}
