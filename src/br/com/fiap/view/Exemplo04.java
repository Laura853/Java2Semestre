package br.com.fiap.view;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Exemplo04 {
    public static void main(String[] args) {
        //Criar um mapa de Estados (Chave : Sigla, Valor : Nome)

        Map<String, String> brasil = new HashMap<>();

        //Adicionar 4 estados

        brasil.put("SP", "São Paulo");
        brasil.put("RJ", "Rio de Janeiro");
        brasil.put("SC", "Santa Catarina");
        brasil.put("MG", "Minas Gerais");

        //Exibir a quantidade de estados

        System.out.println(brasil.size());

        //Exibir o valor da chave "RJ"

        System.out.println(brasil.get("RJ"));

        //Exibir a sigla e o nome de todos os estados mapeados

        //Recuperar as chaves do mapeamento

        Set<String> chaves =  brasil.keySet();

        //Laço para percorrer todas as chaves do mapa

        for (String chave : chaves){
            //Exibir a chave e o valor
            System.out.println("Sigla " + chave + "Estado: " + brasil.get(chave));

        }


    }
}
