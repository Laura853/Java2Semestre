package br.com.fiap;

import br.com.fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ExemploAtualizar {

    public static void main(String[] args) {
        try {
            //Obter a conexão com o banco
            Connection conexao = ConnectionFactory.getConnection();
            //Obter um Statement
            Statement stm = conexao.createStatement();
            //Executar o comando de update
            stm.executeUpdate("update t_tdspw_produto set nm_produto = 'Teclado', " +
                    "ds_produto = 'Teclado Mecanico' where cd_produto = 1");
            //Fechar a conexão com o banco
            conexao.close();
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }//main
}//class
