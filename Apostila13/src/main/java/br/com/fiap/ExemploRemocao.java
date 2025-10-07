package br.com.fiap;

import br.com.fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ExemploRemocao {

    public static void main(String[] args) {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            Statement stm = conexao.createStatement();
            stm.executeUpdate("delete from t_tdspw_produto where cd_produto = 1");
            System.out.println("Produto removido!");
            conexao.close();
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
}
