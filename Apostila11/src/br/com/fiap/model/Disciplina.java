package br.com.fiap.model;

public class Disciplina {

    private String nome;
    private int cargaHoraria;
    private String categoria;

    public Disciplina(String nome, int cargaHoraria, String categoria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return nome + " - " + categoria + " - " + cargaHoraria + " horas";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
