package br.com.alura.contador.desafios;

public class Produto implements Avaliavel {
    private String nome;

    public Produto(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Produto: " + nome;
    }
}
