package me.dliberalesso.view;

import me.dliberalesso.controller.ControladorCadastraEquipe;
import me.dliberalesso.controller.JanelaListener;
import me.dliberalesso.model.Aluno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastraAluno extends JFrame {
    private JLabel labelNome, labelSobrenome, labelEmail, labelNascimento;
    private JTextField fieldNome, fieldSobrenome, fieldEmail, fieldNascimento;
    private JButton buttonConfirma;

    public CadastraAluno() throws HeadlessException {
        super("Cadastra Aluno");

        Container container = getContentPane();
        container.setLayout(new GridLayout(5, 2, 5, 5));

        labelNome = new JLabel("Nome:");
        fieldNome = new JTextField();
        container.add(labelNome);
        container.add(fieldNome);

        labelSobrenome = new JLabel("Sobrenome:");
        fieldSobrenome = new JTextField();
        container.add(labelSobrenome);
        container.add(fieldSobrenome);

        labelEmail = new JLabel("Email:");
        fieldEmail = new JTextField();
        container.add(labelEmail);
        container.add(fieldEmail);

        labelNascimento = new JLabel("Data de nascimento:");
        fieldNascimento = new JTextField();
        fieldNascimento.setToolTipText("dd/MM/yyyy");
        container.add(labelNascimento);
        container.add(fieldNascimento);

        container.add(new JPanel());
        buttonConfirma = new JButton("Confirma");
        buttonConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aluno aluno = new Aluno();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                try {
                    aluno.setNome(fieldNome.getText());
                    aluno.setSobrenome(fieldSobrenome.getText());
                    aluno.setEmail(fieldEmail.getText());
                    aluno.setNascimento(LocalDate.parse(fieldNascimento.getText(), dateTimeFormatter));
                    ControladorCadastraEquipe.getAlunos().add(aluno);
                    ControladorCadastraEquipe.getCadastraEquipe().getListModel().addElement(aluno);
                    dispose();
                } catch (Exception e1) {
                    String mensagem;
                    if (e1.getClass().equals(IllegalArgumentException.class)) {
                        mensagem = e1.getMessage();
                    } else {
                        mensagem = "Formato de data inválido.";
                    }
                    JOptionPane.showMessageDialog(container, mensagem, "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        container.add(buttonConfirma);

        setSize(310, 180);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new JanelaAlunoListener());
        setVisible(true);
    }

    private class JanelaAlunoListener extends JanelaListener {
        @Override
        public void windowClosed(WindowEvent e) {
            ControladorCadastraEquipe.ativaCadastraEquipe();
        }
    }
}
