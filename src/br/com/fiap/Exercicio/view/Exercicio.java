package br.com.fiap.Exercicio.view;

import br.com.fiap.Exercicio.model.Aluno;
import br.com.fiap.model.Disciplina;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio {
    public static void main(String[] args) {

        //Permitir o usuário adicionar quantos alunos desejar á lista de alunos.

        List<Aluno> alunos = new ArrayList<>();

        Scanner leitor = new Scanner(System.in);

        do {
            //Ler os dados do aluno
            System.out.println("Digite o nome:");
            String nome = leitor.nextLine();
            System.out.println("Digite o rm:");
            int rm = leitor.nextInt();
            System.out.println("Digite a idade:");
            int idade = leitor.nextInt();
            System.out.println("Digite a nota 1");
            double nota1 = leitor.nextDouble();
            System.out.println("Digite a nota 2");
            double nota2 = leitor.nextDouble();

            //Instanciar o aluno na lista

            Aluno aluno = new Aluno(nome, rm, idade, nota1, nota2);

            //Cadastrar o aluno na lista

            alunos.add(aluno);

            //Perguntar se o usuário deseja cadastrar mais 1 aluno S-sim N-não..

            System.out.println("Deseja cadastrar mais 1 aluno? S se sim, N se não");
        } while (!leitor.next().equalsIgnoreCase("N"));

        //Exibir os alunos registrados

        System.out.println("Alunos: " + alunos.size());

        //Exibir os alunos registrados
        for (Aluno a : alunos) {
            System.out.println(a);
        }

        //Exibir a média de idade
        int somaIdade = 0;
        double somaNotas = 0;
        int maiorIdade = alunos.getFirst().getIdade();
        int menorIdade = alunos.getFirst().getIdade();
        for (Aluno a : alunos) {
            somaIdade += a.getIdade();
            somaNotas += (a.getNota1() + a.getNota2()) / 2;
            if (a.getIdade() > maiorIdade)
                maiorIdade = a.getIdade();
            if (a.getIdade() < menorIdade)
                menorIdade = a.getIdade();
        }

        System.out.println("A maior idade é " + maiorIdade);
        System.out.println("A menor idade é " + menorIdade);
        System.out.println("Média de idade " + somaIdade / alunos.size());
        System.out.println("Média de notas " + somaNotas / alunos.size());

        //Exibir menu

        int opcao;

        do {
            System.out.println("""
                    Escolha:
                    1-Exibir os nomes e médias
                    2-Exibir alunos media >6
                    3-Exibir alunos com mais de 30
                    4-Excluir alunos media < 3
                    5-Sair""");
            opcao = leitor.nextInt();
            switch (opcao){
                case 1: //Exibir nome e medias
                    for (int i = 0; i < alunos.size(); i++) {
                        System.out.println("Alunos: " + alunos.get().getNome() + "Idades: " + alunos.get().getIdade());
                    }
                    break;
                case 2: //Exibir alunos média > 6
                    if (somaNotas>6)
                    break;
                case 3: //Exibir alunos idade > 30
                    break;
                case 4: //Remover alunos media < 3
                    break;

            }

        } while (opcao != 5);

    }

}



