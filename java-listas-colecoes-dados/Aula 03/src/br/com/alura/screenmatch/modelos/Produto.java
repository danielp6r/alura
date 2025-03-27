package br.com.alura.screenmatch.modelos;

public class Produto {
    private String nome;
    private double preco;

    public double getPreco() {
        return preco;
    }

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}
