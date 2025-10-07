package br.com.fiap.exercicio.view;

import br.com.fiap.exercicio.model.Aluno;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio {

    public static void main(String[] args) {
        //Lista para armazenar os alunos
        List<Aluno> alunos = new ArrayList<>();

        Scanner leitor = new Scanner(System.in);

        do {
            //Ler os dados do aluno
            System.out.println("Digite o RM");
            int rm = leitor.nextInt();

            System.out.println("Digite o nome");
            String nome = leitor.next() + leitor.nextLine();

            System.out.println("Digite a idade");
            int idade = leitor.nextInt();

            System.out.println("Digite a nota 1");
            double nota1 = leitor.nextDouble();

            System.out.println("Digite a nota 2");
            double nota2 = leitor.nextDouble();

            //Instanciar o aluno com dados
            Aluno aluno = new Aluno(rm, nome, idade, nota1, nota2);

            //Cadastrar o aluno na lista
            alunos.add(aluno);

            //Perguntar se o usuario deseja cadastrar mais 1 aluno S-Sim N-Não...
            System.out.println("Deseja cadastrar mais um aluno? S-Sim N-Não");
        } while (!leitor.next().equalsIgnoreCase("N"));

        //Exibir a quantidade de alunos
        System.out.println("Quantidade de alunos: " + alunos.size());

        //Exibir os alunos registrados
        for (Aluno a : alunos){
            System.out.println(a);
        }

        //Exibir a média de idade
        int somaIdades = 0;
        double somaNotas = 0;
        int maiorIdade = alunos.getFirst().getIdade();
        int menorIdade = alunos.getFirst().getIdade();
        for (Aluno a : alunos){
            somaIdades += a.getIdade();
            somaNotas += (a.getNota1() + a.getNota2())/2;
            if (a.getIdade() > maiorIdade)
                maiorIdade = a.getIdade();
            if (a.getIdade() < menorIdade)
                menorIdade = a.getIdade();
        }

        System.out.println("A maior idade é: " + maiorIdade);
        System.out.println("A menor idade é: " + menorIdade);
        System.out.println("Média de idade: " + somaIdades/alunos.size());
        System.out.println("Média de notas: " + somaNotas/alunos.size());

        //Exibir o menu
        int opcao;
        do {
            System.out.println("""
                    Escolha:
                    1-Exibir nomes e medias
                    2-Exibir alunos media > 6
                    3-Exibir alunos com mais de 30
                    4-Excluir alunos media < 3
                    5-Sair""");
            opcao = leitor.nextInt();
            switch (opcao){
                case 1: //Exibir nome e medias
                    System.out.println("***************NOME E MÉDIAS**************");
                    for (Aluno aluno : alunos){
                        System.out.println(aluno.getNome() + " média: " + (aluno.getNota1() + aluno.getNota2())/2);
                    }
                    break;
                case 2: //Exibir alunos media > 6
                    System.out.println("*************ALUNOS COM MÉDIA > 6************");
                    for (Aluno aluno : alunos){
                        if ((aluno.getNota1() + aluno.getNota2())/2 > 6){
                            System.out.println(aluno);
                        }
                    }
                    break;
                case 3: //Exibir alunos idade > 30
                    System.out.println("**********ALUNOS COM IDADE > 30***************");
                    for (Aluno aluno : alunos){
                        if (aluno.getIdade() > 30)
                            System.out.println(aluno);
                    }
                    break;
                case 4: //Remover alunos media < 3
                    System.out.println("*****REMOVENDO ALUNOS COM MÉDIA < 3************");
                    for (int i = 0; i < alunos.size(); i++){
                        if ((alunos.get(i).getNota1() + alunos.get(i).getNota2())/2 < 3)
                            alunos.remove(alunos.get(i));
                    }
                    break;
                case 5:
                    System.out.println("Finalizando o programa");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while(opcao != 5);
    }//main
}//class
