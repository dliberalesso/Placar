package me.dliberalesso.controller;

import me.dliberalesso.model.Aluno;
import me.dliberalesso.model.Equipe;
import me.dliberalesso.view.VerEquipes;

import javax.swing.*;
import java.util.List;

public class ControladorVerEquipes {
    private static List<Equipe> equipeList;
    private static DefaultListModel<Equipe> equipeListModel;
    private static VerEquipes verEquipes;

    public static void mostraVerEquipes() {
        inicializaEquipeListModel();
        verEquipes = new VerEquipes(equipeListModel, new DefaultListModel<Aluno>());
    }

    private static void inicializaEquipeListModel() {
        equipeList = Controlador.getEquipes();
        equipeListModel = new DefaultListModel<Equipe>();

        for (Equipe equipe : equipeList) {
            equipeListModel.addElement(equipe);
        }
    }

    public static VerEquipes getVerEquipes() {
        return verEquipes;
    }

    public static DefaultListModel<Aluno> updateAlunoListModel(int index) {
        Equipe equipe = equipeList.get(index);
        List<Aluno> alunoList = equipe.getAlunoList();
        DefaultListModel<Aluno> alunoListModel = new DefaultListModel<Aluno>();

        for (Aluno aluno : alunoList) {
            alunoListModel.addElement(aluno);
        }

        return alunoListModel;
    }
}
