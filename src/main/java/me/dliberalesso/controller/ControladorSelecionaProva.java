package me.dliberalesso.controller;

import me.dliberalesso.model.Prova;
import me.dliberalesso.view.SelecionaProva;

import javax.swing.*;
import java.util.List;

public class ControladorSelecionaProva {
    private static List<Prova> provaList;
    private static SelecionaProva selecionaProva;

    public static void mostraSelecionaProva() {
        provaList = Controlador.getProvas();
        DefaultListModel<Prova> provaDefaultListModel = new DefaultListModel<Prova>();

        for (Prova prova : provaList) {
            provaDefaultListModel.addElement(prova);
        }

        selecionaProva = new SelecionaProva(provaDefaultListModel);
    }

    public static Prova getProva(int index) {
        return provaList.get(index);
    }

    public static SelecionaProva getSelecionaProva() {
        return selecionaProva;
    }

    public static void ativaSelecionaProva() {
        selecionaProva.setVisible(true);
    }
}
