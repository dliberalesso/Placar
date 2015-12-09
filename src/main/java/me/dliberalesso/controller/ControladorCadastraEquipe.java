package me.dliberalesso.controller;

import me.dliberalesso.model.Aluno;
import me.dliberalesso.model.Equipe;
import me.dliberalesso.view.CadastraEquipe;

import java.util.ArrayList;
import java.util.List;

public class ControladorCadastraEquipe {
    private static List<Equipe> equipes;
    private static List<Aluno> alunos;
    private static CadastraEquipe cadastraEquipe;

    public static void mostraCadastraEquipe() {
        equipes = Controlador.getEquipes();
        alunos = new ArrayList<>();
        cadastraEquipe = new CadastraEquipe();
    }

    public static void ativaCadastraEquipe() {
        cadastraEquipe.setVisible(true);
    }

    public static void adicionaEquipe(Equipe equipe) {
        equipes.add(equipe);
    }

    public static CadastraEquipe getCadastraEquipe() {
        return cadastraEquipe;
    }

    public static List<Aluno> getAlunos() {
        return alunos;
    }
}
