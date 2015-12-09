package me.dliberalesso.view;

import me.dliberalesso.controller.ControladorVerProvas;
import me.dliberalesso.controller.JanelaListener;
import me.dliberalesso.model.Prova;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class VerProvas extends JFrame {
    private JList<Prova> provaJList;
    private JLabel labelDescricao, labelTempoMaximo, labelPontuacaoMaxima, labelPenalidade;
    private JTextField fieldDescricao, fieldTempoMaximo, fieldPontuacaoMaxima, fieldPenalidade;

    public VerProvas(DefaultListModel<Prova> provaListModel) throws HeadlessException {
        super("Provas Cadastradas");

        Container container = getContentPane();
        container.setLayout(new GridLayout(1, 2, 5, 5));

        // Provas
        JPanel panel1 = new JPanel(new BorderLayout(5, 5));
        JLabel labelProvas = new JLabel("Selecione uma Prova:");
        panel1.add(labelProvas, BorderLayout.PAGE_START);

        // Lista
        provaJList = new JList<Prova>(provaListModel);
        provaJList.setVisibleRowCount(10);
        provaJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        provaJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                ControladorVerProvas.updateForm(provaJList.getSelectedIndex());
            }
        });

        panel1.add(new JScrollPane(provaJList), BorderLayout.CENTER);
        container.add(panel1);

        // Dados da prova selecionada
        JPanel panel2 = new JPanel(new BorderLayout(5, 5));
        JLabel labelProva = new JLabel("Prova selecionada:");
        panel2.add(labelProva, BorderLayout.PAGE_START);

        JPanel panelProva = new JPanel(new GridLayout(4, 2, 5, 5));

        // Linha descricao
        labelDescricao = new JLabel("Descricao:");
        fieldDescricao = new JTextField();
        fieldDescricao.setEnabled(false);
        panelProva.add(labelDescricao);
        panelProva.add(fieldDescricao);

        // Linha TempoMaximo
        labelTempoMaximo = new JLabel("Tempo maximo (segundos):");
        fieldTempoMaximo = new JTextField();
        fieldTempoMaximo.setEnabled(false);
        panelProva.add(labelTempoMaximo);
        panelProva.add(fieldTempoMaximo);

        // Linha pontuacao
        labelPontuacaoMaxima = new JLabel("Pontuacao maxima (inteiros):");
        fieldPontuacaoMaxima = new JTextField();
        fieldPontuacaoMaxima.setEnabled(false);
        panelProva.add(labelPontuacaoMaxima);
        panelProva.add(fieldPontuacaoMaxima);

        // Linha penalidade
        labelPenalidade = new JLabel("Penalidade (segundos)");
        fieldPenalidade = new JTextField();
        fieldPenalidade.setEnabled(false);
        panelProva.add(labelPenalidade);
        panelProva.add(fieldPenalidade);

        panel2.add(panelProva, BorderLayout.CENTER);
        container.add(panel2);

        setSize(750, 220);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new JanelaListener());
        setVisible(true);
    }

    public void setTextOfFieldDescricao(String text) {
        this.fieldDescricao.setText(text);
    }

    public void setTextOfFieldTempoMaximo(String text) {
        this.fieldTempoMaximo.setText(text);
    }

    public void setTextOfFieldPontuacaoMaxima(String text) {
        this.fieldPontuacaoMaxima.setText(text);
    }

    public void setTextOfFieldPenalidade(String text) {
        this.fieldPenalidade.setText(text);
    }
}
