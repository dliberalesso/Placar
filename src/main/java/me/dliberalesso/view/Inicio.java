package me.dliberalesso.view;

import me.dliberalesso.controller.ControladorCadastraEquipe;
import me.dliberalesso.controller.ControladorCadastraProva;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame {
    private JButton buttonCadastraEquipe, buttonCadastraProva, buttonIniciarProvas;
    private Container container;
    private FlowLayout flowLayout;

    public Inicio(boolean permiteIniciarProvas) throws HeadlessException {
        super("Placar da URI");
        container = getContentPane();
        flowLayout = new FlowLayout(FlowLayout.CENTER, 5, 5);
        container.setLayout(flowLayout);

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
        buttonIniciarProvas.setEnabled(permiteIniciarProvas);
        container.add(buttonIniciarProvas);

        setSize(410, 75);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
