package br.com.fiap;

import br.com.fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExemploLer {

    public static void main(String[] args) {
        try {
            //Obter a conexão
            Connection conexao = ConnectionFactory.getConnection();
            //Statement
            Statement stm = conexao.createStatement();
            //Executar o SQL
            ResultSet rs = stm.executeQuery("select * from t_tdspw_produto");
            //Exibir os dados retornados do banco de dados
            while (rs.next()){
                int codigo = rs.getInt("cd_produto");
                String nome = rs.getString("nm_produto");
                int qtd = rs.getInt("qt_produto");
                String descricao = rs.getString("ds_produto");
                System.out.println(codigo + " " + nome + " " + qtd + " " + descricao);
            }
            //Fechar
            conexao.close();
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }//main
}//class
