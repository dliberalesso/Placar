package me.dliberalesso.controller;

import me.dliberalesso.model.Prova;
import me.dliberalesso.view.VerProvas;

import javax.swing.*;
import java.util.List;

public class ControladorVerProvas {
    private static List<Prova> provas;
    private static VerProvas verProvas;

    public static void mostraVerProvas() {
        DefaultListModel<Prova> provaDefaultListModel = new DefaultListModel<Prova>();
        provas = Controlador.getProvas();

        for (Prova prova : provas) {
            provaDefaultListModel.addElement(prova);
        }

        verProvas = new VerProvas(provaDefaultListModel);
    }

    public static void updateForm(int index) {
        Prova prova = provas.get(index);
        verProvas.setTextOfFieldDescricao(prova.getDescricao());
        verProvas.setTextOfFieldPenalidade("" + prova.getPenalidade());
        verProvas.setTextOfFieldPontuacaoMaxima("" + prova.getPontuacaoMaxima());
        verProvas.setTextOfFieldTempoMaximo("" + prova.getTempoMaximo());
    }

    public static VerProvas getVerProvas() {
        return verProvas;
    }
}
