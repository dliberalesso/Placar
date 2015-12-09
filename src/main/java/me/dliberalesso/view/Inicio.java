package me.dliberalesso.view;

import me.dliberalesso.controller.ControladorCadastraEquipe;
import me.dliberalesso.controller.ControladorCadastraProva;
import me.dliberalesso.controller.ControladorVerEquipes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame {
    private JButton buttonCadastraEquipe, buttonCadastraProva, buttonIniciarProvas;
    private JButton buttonVerEquipes, buttonVerProvas, buttonVerClassificacao;
    private Container container;
    private GridLayout layout;

    public Inicio(boolean temEquipe, boolean temProva) throws HeadlessException {
        super("Placar da URI");
        container = getContentPane();
        layout = new GridLayout(2, 4, 5, 5);
        container.setLayout(layout);

        // Botao para cadastrar equipe
        buttonCadastraEquipe = new JButton("Cadastrar Equipe");
        buttonCadastraEquipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorCadastraEquipe.mostraCadastraEquipe();
                ControladorCadastraEquipe.getCadastraEquipe().setLocationRelativeTo(container);
                dispose();
            }
        });
        container.add(buttonCadastraEquipe);

        // Botao para cadastrar prova
        buttonCadastraProva = new JButton("Cadastrar Prova");
        buttonCadastraProva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorCadastraProva.mostraCadastraProva();
                ControladorCadastraProva.getCadastraProva().setLocationRelativeTo(container);
                dispose();
            }
        });
        container.add(buttonCadastraProva);

        // Botao para iniciar provas
        buttonIniciarProvas = new JButton("Iniciar Provas");
        buttonIniciarProvas.setEnabled(temEquipe && temProva);
        container.add(buttonIniciarProvas);

        // Botao para ver equipes
        buttonVerEquipes = new JButton("Ver Equipes");
        buttonVerEquipes.setEnabled(temEquipe);
        buttonVerEquipes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorVerEquipes.mostraVerEquipes();
                ControladorVerEquipes.getVerEquipes().setLocationRelativeTo(container);
                dispose();
            }
        });
        container.add(buttonVerEquipes);

        // Botao para ver provas
        buttonVerProvas = new JButton("Ver Provas");
        buttonVerProvas.setEnabled(temProva);
        container.add(buttonVerProvas);

        // Botao para ver classificacao
        buttonVerClassificacao = new JButton("Ver Classificaçao");
        buttonVerClassificacao.setEnabled(temEquipe && temProva);
        container.add(buttonVerClassificacao);

        setSize(450, 110);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
