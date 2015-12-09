package me.dliberalesso.view;

import me.dliberalesso.controller.ControladorCadastraEquipe;
import me.dliberalesso.controller.ControladorCadastraProva;
import me.dliberalesso.controller.ControladorVerEquipes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame {
    private JButton buttonCadastraEquipe, buttonCadastraProva, buttonCadastraPatro, buttonIniciarProvas;
    private JButton buttonVerEquipes, buttonVerProvas, buttonVerPatro, buttonVerClassificacao;
    private Container container;
    private GridLayout layout;

    public Inicio(boolean temEquipe, boolean temProva, boolean temPatrocinador) throws HeadlessException {
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

        // Botao para cadastrar patrocinador
        buttonCadastraPatro = new JButton("Cadastrar Patrocinador");
        container.add(buttonCadastraPatro);

        // Botao para iniciar provas
        buttonIniciarProvas = new JButton("Iniciar Provas");
        buttonIniciarProvas.setEnabled(temEquipe && temProva && temPatrocinador);
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

        // Botao para ver patrocinador
        buttonVerPatro = new JButton("Ver Patrocinador");
        buttonVerPatro.setEnabled(temPatrocinador);
        container.add(buttonVerPatro);

        // Botao para ver classificacao
        buttonVerClassificacao = new JButton("Ver Classificaçao");
        buttonVerClassificacao.setEnabled(temEquipe && temProva && temPatrocinador);
        container.add(buttonVerClassificacao);

        setSize(710, 110);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
