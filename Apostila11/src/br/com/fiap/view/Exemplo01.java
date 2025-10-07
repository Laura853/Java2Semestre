package br.com.fiap.view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Exemplo01 {

    public static void main(String[] args) {
        List<String> alunos = new ArrayList<>();
        alunos.add("Lucas");
        alunos.add("Carlos");

        //Adicionar 1 aluno na segunda posição da lista
        alunos.add(1, "Nicolle");

        //Exibir a quantidade de alunos na lista
        System.out.println("Qtd de alunos: " + alunos.size());

        //Exibir o aluno da primeira posição
        System.out.println(alunos.get(0));

        //Exibir todos os alunos
        for (int i = 0; i < alunos.size(); i++){
            System.out.println( i + " - " + alunos.get(i));
        }

    }
}
