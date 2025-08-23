package br.com.fiap.view;

import br.com.fiap.model.ContaCorrente;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exemplo02 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        ContaCorrente contaCorrente = new ContaCorrente();        //Menu 1-Depositar 2-Sacar 3-Exibir saldo 0-Sair

        int opcao = 0;

        do {
            System.out.println("""
                1-Depositar
                2-Sacar
                3-Exibir saldo
                0-Sair
                """);

            try {
                int opcao1 = leitor.nextInt();


                switch (opcao1){
                    case 1:
                        System.out.println("Digite o valor que deseja depositar");
                        double valorDeposito = leitor.nextDouble();

                        if (valorDeposito >= 1){
                            contaCorrente.depositar(valorDeposito);
                            System.out.println("Saque realizado com sucesso! Saldo atual: R$: " + contaCorrente.consultarSaldo());
                        }else{
                            System.out.println("O valor minímo para depósito é 1 real");
                        }
                        break;
                    case 2:
                        System.out.println("Digite o valor que deseja sacar");
                        double valorSaque = leitor.nextDouble();

                        if (valorSaque > contaCorrente.getSaldo()){
                            System.out.println("O valor de saque é maior do que o valor do saldo! Seu saldo atual é: " + contaCorrente.getSaldo());
                        }else {
                          contaCorrente.sacar(valorSaque);
                            System.out.println("Saque realizado com sucesso! Saldo atual: R$: " + contaCorrente.consultarSaldo());
                        }
                        break;
                    case 3:
                        System.out.println("O seu saldo é: " + contaCorrente.getSaldo());

                    case 4:
                        System.out.println("Encerrando sistema!");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (InputMismatchException e){
                System.err.println("Você deve digitar um número válido!");
            }

        }while (opcao !=0);


    }
}
