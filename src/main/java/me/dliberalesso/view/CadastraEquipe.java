package me.dliberalesso.view;

import me.dliberalesso.controller.JanelaListener;

import javax.swing.*;
import java.awt.*;

public class CadastraEquipe extends JFrame {
    private Container container;
    private GridLayout gridLayout;

    private JLabel labelNome, labelEscola, labelAlunos;
    private JTextField fieldNome, fieldEscola;
    private JButton buttonCadastraAluno, buttonConfirma;

    public CadastraEquipe() throws HeadlessException {
        super("Cadastrar Equipe");

        container = getContentPane();
        gridLayout = new GridLayout(2, 1, 5, 5);
        container.setLayout(gridLayout);


        // Linha para cadastrar nome
        labelNome = new JLabel("Nome da equipe");
        fieldNome = new JTextField();
        container.add(labelNome);
        container.add(fieldNome);

        setSize(410, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new JanelaListener());
        setVisible(true);
    }
}
