package me.dliberalesso.controller;

import me.dliberalesso.model.Prova;
import me.dliberalesso.view.CadastraProva;

import java.util.List;

public class ControladorCadastraProva {
    private static List<Prova> provas;
    private static CadastraProva cadastraProva;

    public static void mostraCadastraProva() {
        provas = Controlador.getProvas();
        cadastraProva = new CadastraProva();
    }

    public static void adicionaProva(Prova prova) {
        provas.add(prova);
    }

    public static CadastraProva getCadastraProva() {
        return cadastraProva;
    }
}
