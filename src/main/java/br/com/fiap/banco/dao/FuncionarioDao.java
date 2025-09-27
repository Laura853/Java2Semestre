package br.com.fiap.banco.dao;

import br.com.fiap.banco.exception.EntidadeNaoEncontradaException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Funcionario;

import java.sql.*;
import java.util.ArrayList;
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

    public void atualizar(Funcionario funcionario) throws SQLException, EntidadeNaoEncontradaException{
        //Criar o PreparedStatement
        PreparedStatement stmt = conexao.prepareStatement("update t_tdspw_funcionario set nm_funcionario = ?," + "vl_salario = ?, st_ativo = ?, ds_email = ? where cd_funcionario = ?");
        //Setar os valores dos parametros na query
        stmt.setInt(1, funcionario.getCodigo());
        stmt.setString(2, funcionario.getNome());
        stmt.setDouble(3, funcionario.getSalario());
        stmt.setBoolean(4, funcionario.isAtivo());
        stmt.setString(5, funcionario.getEmail());
        //Executar a query
        stmt.executeUpdate();
        if (stmt.executeUpdate() == 0)
            throw new  EntidadeNaoEncontradaException("Não foi possível atualizar, pois o funcionário não existe!");
    }

    public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException{
        //Criar o PreparedStatement
        PreparedStatement stmt = conexao.prepareStatement("delet from t_tdspw where cd_funcionario = ?");
        //Setar o codigo no PreparedStatement
        stmt.setInt(1, codigo);
        //Executar a query
        int linha = stmt.executeUpdate();
        if (linha == 0)
            throw new  EntidadeNaoEncontradaException("Não foi possível remover, pois o funcionário não existe!");

    }

    public Funcionario buscar(int codigo) throws SQLException, EntidadeNaoEncontradaException{
        //Criar o PreparedStatement
        PreparedStatement stmt = conexao.prepareStatement("select * from t_tdspw_funcionario where cd_funcionario = ?");
        //Setar o codigo no PreparedStatement
        stmt.setInt(1, codigo);
        //Executar o comando SQL
        ResultSet rs = stmt.executeQuery();
        //Valida se retornou algum resultado
        if (!rs.next())
            throw new EntidadeNaoEncontradaException("Funcionario não encontrado");
        //Recuperar os dados, criar um funcionario e retornar
        return parseFuncionario(rs);
    }

    public List<Funcionario> listar() throws SQLException{


        Statement stmt = conexao.createStatement();

        ResultSet result = stmt.executeQuery("select * from t_tdspw_funcionario");

        List<Funcionario> funcionarios = new ArrayList<>();

        while (result.next()) {

            Funcionario funcionario = getFuncionario(result);

            funcionarios.add(funcionario);
        }

        return funcionarios;

    }

    private static Funcionario getFuncionario(ResultSet result) throws SQLException {
        Funcionario funcionario = parseFuncionario(result);
        return funcionario;
    }

    private static Funcionario parseFuncionario(ResultSet result) throws SQLException {
        int codigo = result.getInt("cd_funcionario");
        String nome = result.getString("nm_funcionario");
        double salario = result.getDouble("vl_salario");
        boolean estaAtivo = result.getBoolean("st_ativo");
        String email = result.getString("ds_email");

        Funcionario funcionario = new Funcionario(codigo, nome, salario, estaAtivo, email);
        return funcionario;
    }

}
