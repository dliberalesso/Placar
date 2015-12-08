package me.dliberalesso.controller;

import me.dliberalesso.model.Equipe;

import java.util.List;

public class ControladorCadastraEquipe {
    private static List<Equipe> equipes;

    public static void mostraCadastraEquipe() {
        equipes = Controlador.getEquipes();
    }

    public static void adicionaEquipe(Equipe equipe) {
        equipes.add(equipe);
    }
}
