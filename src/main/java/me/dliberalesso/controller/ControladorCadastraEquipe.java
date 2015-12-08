package me.dliberalesso.controller;

import me.dliberalesso.model.Equipe;
import me.dliberalesso.view.CadastraEquipe;

import java.util.List;

public class ControladorCadastraEquipe {
    private static List<Equipe> equipes;
    private static CadastraEquipe cadastraEquipe;

    public static void mostraCadastraEquipe() {
        equipes = Controlador.getEquipes();
        cadastraEquipe = new CadastraEquipe();
    }

    public static void adicionaEquipe(Equipe equipe) {
        equipes.add(equipe);
    }

    public static CadastraEquipe getCadastraEquipe() {
        return cadastraEquipe;
    }
}
