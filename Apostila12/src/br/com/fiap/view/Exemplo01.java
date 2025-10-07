package br.com.fiap.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exemplo01 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        try {
            //Ler dois números inteiros
            System.out.println("Digite um número");
            int n1 = leitor.nextInt();

            System.out.println("Digite outro número");
            int n2 = leitor.nextInt();

            //Dividir os números
            int divisao = n1 / n2;

            //Exibir o resultado
            System.out.println("Resultado: " + divisao);
        } catch (InputMismatchException e){
            System.err.println("Insira um número válido");
        } catch (ArithmeticException e){
            System.err.println("Não é possível realizar a divisão por zero");
        }

    }//main
}//class
