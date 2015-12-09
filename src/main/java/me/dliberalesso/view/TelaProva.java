package me.dliberalesso.view;

import me.dliberalesso.controller.ControladorSelecionaProva;
import me.dliberalesso.controller.ControladorTelaProva;
import me.dliberalesso.controller.JanelaListener;
import me.dliberalesso.model.Equipe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaProva extends JFrame {
    private Cronometro cronometro;

    private JLabel labelTitulo;
    private JList<Equipe> faltanteJList;
    private JTable realizouJTable;
    private JButton buttonSalvar, buttonZerar, buttonTerminar;

    public TelaProva(
            DefaultListModel<Equipe> equipeListModelFaltante,
            DefaultTableModel equipeTableModelRealizou
    ) throws HeadlessException {
        super("Prova");

        Container container = getContentPane();
        container.setLayout(new BorderLayout(5, 5));

        labelTitulo = new JLabel(ControladorTelaProva.getProvaDescricao());
        labelTitulo.setFont(labelTitulo.getFont().deriveFont(48.0f));
        labelTitulo.setVerticalAlignment(JLabel.CENTER);
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);
        container.add(labelTitulo, BorderLayout.PAGE_START);

        JPanel panel1 = new JPanel(new GridLayout(1, 3, 10, 10));
        faltanteJList = new JList<Equipe>(equipeListModelFaltante);
        faltanteJList.setVisibleRowCount(20);
        panel1.add(new JScrollPane(faltanteJList));

        JPanel panel2 = new JPanel(new BorderLayout(50, 50));
        buttonZerar = new JButton("Zerar Cronômetro");
        buttonZerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cronometro.zerar();
            }
        });
        panel2.add(buttonZerar, BorderLayout.PAGE_START);

        cronometro = new Cronometro(ControladorTelaProva.getProva());
        panel2.add(cronometro, BorderLayout.CENTER);

        JPanel panel3 = new JPanel(new BorderLayout(100, 100));
        buttonSalvar = new JButton("Salvar");
        buttonSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (faltanteJList.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(container, "Seleciona uma equipe da lista.", "ERRO", JOptionPane.ERROR_MESSAGE);
                } else {
                    ControladorTelaProva.pontua(faltanteJList.getSelectedIndex(), cronometro.getMiliSegundos());
                    cronometro.zerar();
                }
            }
        });
        panel3.add(buttonSalvar, BorderLayout.PAGE_START);

        buttonTerminar = new JButton("Terminar");
        buttonTerminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if(faltanteJList.getSize().equals(0)) {
                    FileWriter pontuacao;
                    try {
                        pontuacao = new FileWriter("D:\\Documentos\\NetBeansProjects\\Placar\\src\\pontuacao.txt");
                        PrintWriter gravarPontuacao = new PrintWriter(pontuacao);
                        gravarPontuacao.printf("+---------------Pontuação---------------+%n");
                        gravarPontuacao.printf("Equipe\t\tEscola\t\tPontuacao%n");
                        gravarPontuacao.printf("+----------------------------------------+%n");
//                        for() {
//                         
//                        }
                        pontuacao.close();
                    } catch (IOException ex) {
                        Logger.getLogger(TelaProva.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                    

//                else {
//                    JOptionPane.showMessageDialog(container, "Nem todas as equipes terminaram a prova!", "ERRO", JOptionPane.ERROR_MESSAGE);
//                }
                dispose();
            }
        });
        panel3.add(buttonTerminar, BorderLayout.PAGE_END);

        panel2.add(panel3, BorderLayout.PAGE_END);

        panel1.add(panel2);

        realizouJTable = new JTable(equipeTableModelRealizou);
        panel1.add(new JScrollPane(realizouJTable));
        container.add(panel1, BorderLayout.CENTER);

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new TelaProvaListener());
        setVisible(true);
    }

    private class TelaProvaListener extends JanelaListener {
        @Override
        public void windowClosed(WindowEvent e) {
            ControladorSelecionaProva.ativaSelecionaProva();
        }
    }
}
