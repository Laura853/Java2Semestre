package br.com.fiap.banco.view;

import br.com.fiap.banco.dao.FuncionarioDao;
import br.com.fiap.banco.exception.EntidadeNaoEncontradaException;
import br.com.fiap.banco.model.Funcionario;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Terminal {
    public static void main(String[] args)  throws SQLException, ClassNotFoundException {
        //Ler os dados do funcionario

        Scanner scanner = new Scanner(System.in);

        try{
            FuncionarioDao dao = new FuncionarioDao();
            int opcao;
            do{
                //Menu
                System.out.println("Escolha \n1-Cadastrar\n2-Atualizar\n3-Pesquisar\n4-Listar\n5-Remover\n0-Sair");
                opcao= scanner.nextInt();
                switch (opcao){
                    case 1:
                        //Cadastro
                        Funcionario funcionario = lerFuncionario(scanner);
                        dao.cadastrar(funcionario);
                        System.out.println("Funcionário cadastrado com sucesso!");
                        break;
                    case 2:
                        try {
                            //Atualizar
                            funcionario = lerFuncionario(scanner);
                            dao.atualizar(funcionario);
                            System.out.println("Funcionário atualizado com sucesso!");
                        } catch (EntidadeNaoEncontradaException e){
                            System.err.println(e.getMessage());
                        }
                        break;
                    case 3:
                        try {
                            //Pesquisar por ID
                            System.out.println("Digite o código do funcionário");
                            int codigo = scanner.nextInt();
                            Funcionario func = dao.buscar(codigo);
                            System.out.println(func);
                        } catch (EntidadeNaoEncontradaException e){
                            System.err.println(e.getMessage());
                        }
                        break;
                    case 4:
                        List<Funcionario> lista = dao.listar();
                        for (Funcionario f : lista){
                            System.out.println(f);
                        }
                        break;
                    case 5:
                        try {
                            System.out.println("Digite o código do funcionário");
                            int codigo = scanner.nextInt();
                            dao.remover(codigo);
                            System.out.println(" Funcionário removido com sucesso!");
                        } catch (EntidadeNaoEncontradaException e){
                            System.err.println(e.getMessage());
                        }
                        break;
                    case 0:
                        System.out.println("Finalizando o sistema");
                        break;
                    default:
                        System.err.println("Opção inválida");
                }
            }while (opcao!=0);
        } catch (Exception e) {

        }

        //System.out.println("Informe o código do funcionário");
//        int codigo = scanner.nextInt();
//
//        System.out.println("Informe o nome do funcionário");
//        String nome = scanner.next();
//
//        System.out.println("Informe o salário do funcionário");
//        double salario = scanner.nextDouble();
//
//        System.out.println("Informe se o funcionário está ativo");
//        boolean estaAtivo = scanner.nextBoolean();
//
//        System.out.println("Informe o email do funcionário");
//        String email = scanner.nextLine() + scanner.next();
//
//        //Criar um funcionario
//
//        Funcionario funcionario = new Funcionario(codigo, nome, salario, estaAtivo, email);
//
//        //Criar um FuncionarioDao
//
//        FuncionarioDao dao = new FuncionarioDao();
//
//        //Cadastrar o funcionario
//
//        dao.cadastrar(funcionario);

    }

    private static Funcionario lerFuncionario(Scanner scanner) {
        System.out.println("Digite o código do funcionário");
        int codigo = scanner.nextInt();
        System.out.println("Digite o nome do funcionário: ");
        String nome = scanner.next() + scanner.nextLine();
        System.out.println("Digitge o salário do funcionário");
        double salario = scanner.nextDouble();
        System.out.println("Digite o email do funcionário");
        String email = scanner.next() + scanner.nextLine();
        System.out.println("Digite se o funcionário está ativo");
        boolean ativo = scanner.nextBoolean();
        Funcionario funcionario = new Funcionario(codigo, nome, salario, ativo, email);
        return funcionario;
    }
}
