package br.com.fiap.banco.exception;

public class EntidadeNaoEncontradaException extends Exception {

    public EntidadeNaoEncontradaException() {
    }

    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }
}
