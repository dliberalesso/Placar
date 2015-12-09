package me.dliberalesso.controller;

import me.dliberalesso.model.Aluno;
import me.dliberalesso.model.Equipe;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

public class ControladorSalvaClassificacao {
    public static void salvaClassificacao() {
        List<Equipe> equipeList = Controlador.getEquipes();
        FileWriter pontuacao;
        try {
            pontuacao = new FileWriter("./" + "pontuacao.txt");
            PrintWriter gravarPontuacao = new PrintWriter(pontuacao);
            gravarPontuacao.printf("+---------------Pontuação---------------+%n");
            gravarPontuacao.printf("Equipe\t\tEscola\t\tPontuacao%n");
            gravarPontuacao.printf("+----------------------------------------+%n");

            for (Equipe equipe : equipeList) {
                String str = equipe.getNome() + "\t\t" + equipe.getEscola() + "\t\t" + equipe.getPontuacao() + "%n";
                gravarPontuacao.printf(str);
                str = "Alunos: ";
                List<Aluno> alunoList = equipe.getAlunoList();
                for (Aluno aluno : alunoList) {
                    str += aluno.getNome();
                    str += ", ";
                }
                str += "%n";
                gravarPontuacao.printf(str);
            }

            pontuacao.close();
        } catch (IOException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }
}
