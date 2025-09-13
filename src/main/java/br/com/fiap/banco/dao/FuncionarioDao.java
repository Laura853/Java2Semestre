package br.com.fiap.banco.dao;

import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioDao{

    private Connection conexao;

    public FuncionarioDao() throws SQLException, ClassNotFoundException{
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(Funcionario funcionario) throws SQLException{
        //Criar o PreparedStatement

        PreparedStatement stmt = conexao.prepareStatement("insert into t_tdspw_funcionario (cd_funcionario," + "nm_funcionario, vl_salario, st_ativo, ds_email) values (?,?,?,?,?)");

        //Setar os valores dos parametros na query

        stmt.setInt(1, funcionario.getCodigo());
        stmt.setString(2, funcionario.getNome());
        stmt.setDouble(3, funcionario.getSalario());
        stmt.setBoolean(4, funcionario.isAtivo());
        stmt.setString(5, funcionario.getEmail());

        //Executar a query
        stmt.executeUpdate();

    }

    public void atualizar(Funcionario funcionario){}

    public void remover(int codigo){}

    public Funcionario buscar(int codigo){return null;}

    public List<Funcionario> listar(){return null;}

}
