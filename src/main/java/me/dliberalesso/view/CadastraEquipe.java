package me.dliberalesso.view;

import me.dliberalesso.controller.JanelaListener;
import me.dliberalesso.model.Aluno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastraEquipe extends JFrame {
    private JLabel labelNome, labelEscola, labelAlunos;
    private JTextField fieldNome, fieldEscola;
    private JList<Aluno> alunoJList;
    private DefaultListModel listModel;
    private JButton buttonCadastraAluno, buttonConfirma;

    public CadastraEquipe() throws HeadlessException {
        super("Cadastrar Equipe");

        Container container = getContentPane();
        container.setLayout(new BorderLayout(5, 5));

        // Panel para labels
        JPanel panel1 = new JPanel(new GridLayout(3, 2, 5, 5));

        // Linha para cadastrar nome
        labelNome = new JLabel("Nome da equipe:");
        fieldNome = new JTextField();
        panel1.add(labelNome);
        panel1.add(fieldNome);

        // Linha para cadastrar escola
        labelEscola = new JLabel("Nome da escola:");
        fieldEscola = new JTextField();
        panel1.add(labelEscola);
        panel1.add(fieldEscola);

        // Cabecalho da lista de alunos
        labelAlunos = new JLabel("Alunos da equipe:");
        buttonCadastraAluno = new JButton("Cadastrar Aluno");
        buttonCadastraAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CadastraAluno().setLocationRelativeTo(container);
                setVisible(false);
            }
        });
        panel1.add(labelAlunos);
        panel1.add(buttonCadastraAluno);

        container.add(panel1, BorderLayout.PAGE_START);

        // Lista de alunos
        listModel = new DefaultListModel();
        alunoJList = new JList(listModel);
        alunoJList.setVisibleRowCount(5);
        container.add(new JScrollPane(alunoJList), BorderLayout.CENTER);

        // Botao confirma
        buttonConfirma = new JButton("Confirma");
        JPanel panel2 = new JPanel(new BorderLayout(5, 5));
        panel2.add(buttonConfirma, BorderLayout.LINE_END);
        container.add(panel2, BorderLayout.PAGE_END);

        setSize(310, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new JanelaListener());
        setVisible(true);
    }

    public DefaultListModel getListModel() {
        return listModel;
    }
}
