package me.dliberalesso.view;

import javax.swing.*;
import java.awt.*;

public class Inicio extends JFrame {
    private JButton buttonCadastraEquipe, buttonCadastraProva, buttonIniciarProvas;
    private Container container;
    private FlowLayout flowLayout;

    public Inicio() throws HeadlessException {
        super("Placar da URI");
        container = getContentPane();
        flowLayout = new FlowLayout(FlowLayout.CENTER, 5, 5);
        container.setLayout(flowLayout);

        // Botao para cadastrar equipe
        buttonCadastraEquipe = new JButton("Cadastrar Equipe");
        container.add(buttonCadastraEquipe);
        setSize(300, 100);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
