package br.com.fiap;

import br.com.fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExemploCadastro {

    public static void main(String[] args) {

        try {
           //Obter uma conexão com o banco de dados
           Connection conexao = ConnectionFactory.getConnection();

            System.out.println("Conectado com sucesso!");

            //Criar o Statement
            Statement stm = conexao.createStatement();

            //Executar o comando SQL de insert, para cadastrar um produto
            stm.executeUpdate("insert into t_tdspw_produto (cd_produto, nm_produto, qt_produto, ds_produto) " +
                    "values (2, 'Mouse Gamer', 50, 'Mouse com fio para jogar')");

            //Fechar a conexão
            conexao.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }//main
}//class
