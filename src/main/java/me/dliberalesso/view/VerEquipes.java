package me.dliberalesso.view;

import me.dliberalesso.controller.ControladorVerEquipes;
import me.dliberalesso.controller.JanelaListener;
import me.dliberalesso.model.Aluno;
import me.dliberalesso.model.Equipe;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class VerEquipes extends JFrame {
    JLabel labelEquipes, labelAlunos;
    JList<Equipe> equipeJList;
    JList<Aluno> alunoJlist;

    public VerEquipes(DefaultListModel<Equipe> listModel, DefaultListModel<Aluno> alunoListModel) throws HeadlessException {
        super("Equipes cadastradas");

        Container container = getContentPane();
        container.setLayout(new BorderLayout(5, 5));

        JPanel panel1 = new JPanel(new GridLayout(1, 2, 5, 5));
        labelEquipes = new JLabel("Equipes:");
        labelAlunos = new JLabel("Alunos:");
        panel1.add(labelEquipes);
        panel1.add(labelAlunos);
        container.add(panel1, BorderLayout.CENTER);

        JPanel panel2 = new JPanel(new GridLayout(1, 2, 5, 5));
        equipeJList = new JList<Equipe>(listModel);
        equipeJList.setVisibleRowCount(10);
        equipeJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        equipeJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                alunoJlist.setModel(ControladorVerEquipes.updateAlunoListModel(equipeJList.getSelectedIndex()));
            }
        });
        panel2.add(new JScrollPane(equipeJList));

        alunoJlist = new JList<Aluno>(alunoListModel);
        alunoJlist.setVisibleRowCount(10);
        panel2.add(new JScrollPane(alunoJlist));

        container.add(panel2, BorderLayout.CENTER);

        setSize(610, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new JanelaListener());
        setVisible(true);
    }
}
