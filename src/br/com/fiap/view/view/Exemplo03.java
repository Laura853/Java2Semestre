package br.com.fiap.view.view;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class Exemplo03 {
    public static void main(String[] args) {

        Set<String> registrosMatriculas = new HashSet<>();

        // Adicionar RM
        registrosMatriculas.add("RM566376");
        registrosMatriculas.add("RM784532");
        registrosMatriculas.add("RM873465");

        // Adicionar um RM repetido

        registrosMatriculas.add("RM873465");

        // Exibir a quantidade de RM
        System.out.println(registrosMatriculas.size());

        // Exibir todos os rms

        for (String churros : registrosMatriculas){
            System.out.println(churros);
        }

    }
}

