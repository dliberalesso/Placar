package me.dliberalesso.view;

import me.dliberalesso.controller.ControladorSelecionaProva;
import me.dliberalesso.controller.ControladorTelaProva;
import me.dliberalesso.controller.JanelaListener;
import me.dliberalesso.model.Prova;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelecionaProva extends JFrame {
    private JLabel labelSeleciona;
    private JList<Prova> provaJList;
    private JButton buttonIniciar;

    public SelecionaProva(DefaultListModel<Prova> provaDefaultListModel) throws HeadlessException {
        super("Iniciar provas");
        Container container = getContentPane();
        container.setLayout(new BorderLayout(5, 5));

        labelSeleciona = new JLabel("Selecione uma prova e clique em iniciar.");
        container.add(labelSeleciona, BorderLayout.PAGE_START);

        provaJList = new JList<Prova>(provaDefaultListModel);
        provaJList.setVisibleRowCount(10);
        provaJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        container.add(new JScrollPane(provaJList), BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(1, 3, 5, 5));
        buttonIniciar = new JButton("Iniciar");
        buttonIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (provaJList.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(container, "Selecione uma prova.", "ERRO", JOptionPane.ERROR_MESSAGE);
                } else {
                    Prova prova = ControladorSelecionaProva.getProva(provaJList.getSelectedIndex());
                    ControladorTelaProva.mostraTelaProva(prova);
                    ControladorTelaProva.getTelaProva().setLocationRelativeTo(container);
                    setVisible(false);
                }
            }
        });
        panel.add(new JPanel());
        panel.add(buttonIniciar);
        panel.add(new JPanel());

        container.add(panel, BorderLayout.PAGE_END);

        setSize(390, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new JanelaListener());
        setVisible(true);
    }
}
