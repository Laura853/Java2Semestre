package br.com.fiap.view;

import java.util.HashSet;
import java.util.Set;

public class Exemplo03 {

    public static void main(String[] args) {
        Set<String> registrosMatriculas = new HashSet<>();

        //Adicionar RM
        registrosMatriculas.add("Rm564113");
        registrosMatriculas.add("Rm565708");
        registrosMatriculas.add("Rm563065");
        //Adicionar um RM repetido
        registrosMatriculas.add("Rm563065");

        //Exibir a quantidade de RM
        System.out.println(registrosMatriculas.size());

        //Exibir todos os rms
        for (String churros : registrosMatriculas){
            System.out.println(churros);
        }
    }
}
