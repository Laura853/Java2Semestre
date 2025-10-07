package br.com.fiap.banco.dao;

import br.com.fiap.banco.exception.EntidadeNaoEncontradaException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {

    private Connection conexao;

    public FuncionarioDao() throws SQLException, ClassNotFoundException {
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(Funcionario funcionario) throws SQLException {
        //Criar o PreparedStatement
        PreparedStatement stmt = conexao.prepareStatement("insert into t_tdspw_funcionario (cd_funcionario," +
                "nm_funcionario, vl_salario, st_ativo, ds_email) values (seq_tdspw_funcionario.nextval,?,?,?,?)");
        //Setar os valores dos paramentros na query
        //stmt.setInt(1, funcionario.getCodigo());
        stmt.setString(1, funcionario.getNome());
        stmt.setDouble(2, funcionario.getSalario());
        stmt.setBoolean(3, funcionario.isAtivo());
        stmt.setString(4, funcionario.getEmail());
        //Executar a query
        stmt.executeUpdate();
    }

    public void atualizar(Funcionario funcionario) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stmt = conexao.prepareStatement("update t_tdspw_funcionario set nm_funcionario = ?," +
                "vl_salario = ?, st_ativo = ?, ds_email = ? where cd_funcionario = ?");
        //Setar os valores no SQL
        stmt.setString(1, funcionario.getNome());
        stmt.setDouble(2, funcionario.getSalario());
        stmt.setBoolean(3, funcionario.isAtivo());
        stmt.setString(4, funcionario.getEmail());
        stmt.setInt(5, funcionario.getCodigo());
        //Executar o comando
        if (stmt.executeUpdate() == 0)
            throw new EntidadeNaoEncontradaException("Nenhum funcionário encontrado para atualização");
    }

    public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
        //Criar o PreparedStatement
        PreparedStatement stmt = conexao.prepareStatement("delete from t_tdspw_funcionario where cd_funcionario = ?");
        //Setar o codigo no PreparedStatement
        stmt.setInt(1, codigo);
        //Executar o comando e recupera a qtd de linhas removidas
        int linha = stmt.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEncontradaException("Não foi possível remover, pois o funcionário não existe");
    }

    public Funcionario buscar(int codigo) throws SQLException, EntidadeNaoEncontradaException {
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

    public List<Funcionario> listar() throws SQLException {
        PreparedStatement stmt = conexao.prepareStatement("select * from t_tdspw_funcionario");
        ResultSet rs = stmt.executeQuery();
        List<Funcionario> funcionarios = new ArrayList<>();
        while (rs.next()){
            Funcionario funcionario = parseFuncionario(rs);
            funcionarios.add(funcionario);
        }
        return funcionarios;
    }

    private static Funcionario parseFuncionario(ResultSet rs) throws SQLException {
        int codigo = rs.getInt("cd_funcionario");
        String nome = rs.getString("nm_funcionario");
        double salario = rs.getDouble("vl_salario");
        boolean ativo = rs.getBoolean("st_ativo");
        String email = rs.getString("ds_email");
        Funcionario funcionario = new Funcionario(codigo, nome, salario, ativo, email);
        return funcionario;
    }

}
