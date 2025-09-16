package br.com.fiap.banco.view;

import br.com.fiap.banco.dao.FuncionarioDao;
import br.com.fiap.banco.model.Funcionario;

import java.sql.SQLException;
import java.util.List;

public class ListarFuncionario {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Acessar o DAO

        FuncionarioDao dao = new FuncionarioDao();

        //Buscar dados do DAO

        List<Funcionario> funcionarios = dao.listar();

        //Imprime os resultados

        for(Funcionario funcionario : funcionarios) {
            System.out.println("Código do funcionário " + funcionario.getCodigo());
            System.out.println("Nome do funcionário " + funcionario.getNome());
            System.out.println("Salário do funcionário " + funcionario.getSalario());
            System.out.println("O funcionário está ativo " + funcionario.isAtivo());
            System.out.println("Email do funcionário " + funcionario.getEmail());
        }
    }
}
