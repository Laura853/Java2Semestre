package br.com.fiap.view;

import br.com.fiap.exception.SaldoInsuficienteException;
import br.com.fiap.exception.ValorInvalidoException;
import br.com.fiap.model.ContaCorrente;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exemplo02 {

    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente();
        Scanner leitor = new Scanner(System.in);
        //Menu: 1-Depositar 2-Sacar 3-Exibir Saldo 0-Sair
        int opcao = 1;
        do {

            System.out.println("Escolha: \n1-Depositar \n2-Sacar \n3-Saldo \n0-Sair");
            try {
                opcao = leitor.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Informe o valor para depósito");
                        double valor = leitor.nextDouble();
                        cc.depositar(valor);
                        break;
                    case 2:
                        System.out.println("Informe o valor para saque");
                        valor = leitor.nextDouble();
                        cc.sacar(valor);
                        break;
                    case 3:
                        System.out.println("Saldo atual: " + cc.consultarSaldo());
                        break;
                    case 0:
                        System.out.println("Finalizando o programa...");
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            }  catch (InputMismatchException e) {
                leitor.next();
                System.err.println("Valor inválido");
            } catch (ValorInvalidoException | SaldoInsuficienteException e) {
                System.err.println("Tratamento específico...");
                System.err.println(e.getMessage());
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        } while(opcao != 0);
    }//main
}//class
