package me.dliberalesso.controller;

import me.dliberalesso.model.Equipe;
import me.dliberalesso.model.Prova;
import me.dliberalesso.view.TelaProva;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ControladorTelaProva {
    private static Prova prova;
    private static TelaProva telaProva;

    private static List<Equipe> equipeList;
    private static DefaultListModel<Equipe> equipeListModelFaltante; // Equipes que ainda nao realizaram a prova
    private static DefaultTableModel equipeTableModelRealizou; // Equipes que ja realizaram a prova

    public static void mostraTelaProva(Prova prova) {
        ControladorTelaProva.prova = prova;
        equipeList = Controlador.getEquipes();

        // Inicializa equipes faltantes
        equipeListModelFaltante = new DefaultListModel<Equipe>();
        for (Equipe equipe : equipeList) {
            equipeListModelFaltante.addElement(equipe);
        }

        // Inicializa equipes que ja realizaram a prova
        equipeTableModelRealizou = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        equipeTableModelRealizou.addColumn("Nome");
        equipeTableModelRealizou.addColumn("Escola");
        equipeTableModelRealizou.addColumn("Pontuacao");

        telaProva = new TelaProva(equipeListModelFaltante, equipeTableModelRealizou);
    }

    public static Prova getProva() {
        return prova;
    }

    public static String getProvaDescricao() {
        return prova.getDescricao();
    }

    public static TelaProva getTelaProva() {
        return telaProva;
    }

    public static void pontua(int index, int milisegundos) {
        Equipe equipe = equipeListModelFaltante.remove(index);
        equipe.addPontos(prova.getPontuacaoMaxima() - ((milisegundos / 1000) * (prova.getPontuacaoMaxima() / prova.getTempoMaximo())));
        equipeTableModelRealizou.addRow(new Object[]{equipe.getNome(), equipe.getEscola(), equipe.getPontuacao()});
    }
}
