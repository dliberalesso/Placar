package me.dliberalesso.controller;

import me.dliberalesso.model.Equipe;
import me.dliberalesso.model.Prova;
import me.dliberalesso.view.TelaProva;

import javax.swing.*;
import java.util.List;

public class ControladorTelaProva {
    private static Prova prova;
    private static TelaProva telaProva;

    private static List<Equipe> equipeList;
    private static DefaultListModel<Equipe> equipeListModelFaltante; // Equipes que ainda nao realizaram a prova
    private static DefaultListModel<Equipe> equipetListModelRealizou; // Equipes que ja realizaram a prova

    public static void mostraTelaProva(Prova prova) {
        ControladorTelaProva.prova = prova;
        equipeList = Controlador.getEquipes();

        // Inicializa equipes faltantes
        equipeListModelFaltante = new DefaultListModel<Equipe>();
        for (Equipe equipe : equipeList) {
            equipeListModelFaltante.addElement(equipe);
        }

        // Inicializa equipes que ja realizaram a prova
        equipetListModelRealizou = new DefaultListModel<Equipe>();

        telaProva = new TelaProva(equipeListModelFaltante, equipetListModelRealizou);
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
}
