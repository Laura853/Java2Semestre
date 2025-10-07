package br.com.fiap.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Exemplo04 {

    public static void main(String[] args) {

        //Criar um mapa de Estados (Chave: Sigla, Valor: Nome)
        Map<String, String> estados = new HashMap<>();

        //Adicionar 4 estados
        estados.put("SP", "São Paulo");
        estados.put("PI", "Piaui");
        estados.put("RO", "Roma");
        estados.put("RS", "Risos");

        //Exibir a quantidade de estados
        System.out.println("Estados: " + estados.size());

        //Exibir o valor da chave "RS"
        System.out.println(estados.get("RO"));

        //Exibir a sigla e o nome de todos os estados mapeados
        //Recuperar as chaves do mapeamento
        Set<String> chaves = estados.keySet();

        //Laço para percorrer todas as chaves do mapa
        for (String chave : chaves) {
            //Exibir a chave e o valor
            System.out.println("Sigla: " + chave + " Estado: " + estados.get(chave));
        }//for

    }//main
}//class
