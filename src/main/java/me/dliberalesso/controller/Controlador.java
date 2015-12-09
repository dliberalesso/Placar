package me.dliberalesso.controller;

import me.dliberalesso.model.Equipe;
import me.dliberalesso.model.Prova;
import me.dliberalesso.view.Inicio;

import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private static List<Equipe> equipes = new ArrayList<>();
    private static List<Prova> provas = new ArrayList<>();

    public static List<Equipe> getEquipes() {
        return equipes;
    }

    public static List<Prova> getProvas() {
        return provas;
    }

    public static void mostraInicio() {
        System.out.println(provas);
        new Inicio(!equipes.isEmpty() && !provas.isEmpty());
    }
}
