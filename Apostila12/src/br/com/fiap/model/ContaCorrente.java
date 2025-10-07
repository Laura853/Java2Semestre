package br.com.fiap.model;

import br.com.fiap.exception.SaldoInsuficienteException;
import br.com.fiap.exception.ValorInvalidoException;

public class ContaCorrente {

    private double saldo;

    //Criar os métodos Sacar, Depositar e Consultar
    public void sacar(double valor) throws SaldoInsuficienteException, ValorInvalidoException {
        validarValor(valor);
        if (valor > saldo)
            throw new SaldoInsuficienteException("Saldo insuficiente, saldo atual " + saldo);
        saldo -= valor;
    }

    public void depositar(double valor) throws Exception {
        validarValor(valor);
        saldo += valor;
    }

    private void validarValor(double valor) throws ValorInvalidoException {
        if (valor < 0)
            throw new ValorInvalidoException("Valor não pode ser negativo");
    }

    public double consultarSaldo(){
        return saldo;
    }

}
