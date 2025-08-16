package br.com.fiap.Exercicio.view;

import br.com.fiap.Exercicio.model.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio {
    public static void main(String[] args) {

        //Permitir o usuário adicionar quantos alunos desejar á lista de alunos.

        List<Aluno> alunos = new ArrayList<>();

        Scanner leitor = new Scanner(System.in);

        do{
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

            Aluno aluno = new Aluno(nome,rm,idade,nota1,nota2);

            //Cadastrar o aluno na lista

            alunos.add(aluno);

            //Perguntar se o usuário deseja cadastrar mais 1 aluno S-sim N-não..

            System.out.println("Deseja cadastrar mais 1 aluno? S se sim, N se não");
        } while (leitor.next().equalsIgnoreCase("N"));

        //Exibir os alunos registrados

        System.out.println("Alunos: " + alunos.size());

        //Exibir os alunos registrados
        for (Aluno a : alunos){
            System.out.println(a);
        }



    }
}
