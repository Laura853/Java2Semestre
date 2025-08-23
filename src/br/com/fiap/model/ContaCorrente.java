package br.com.fiap.model;

public class ContaCorrente {

    private double saldo = 100;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //Criar os métodos sacar, depositar e consultar

    public void sacar(double valor){saldo -= valor;
    }

    public void depositar(double valor){saldo += valor;
    }

    public double consultarSaldo(){
        return saldo;
    }




}
