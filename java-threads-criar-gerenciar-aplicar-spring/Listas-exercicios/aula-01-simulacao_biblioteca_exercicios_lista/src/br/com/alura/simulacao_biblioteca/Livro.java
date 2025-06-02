package br.com.alura.simulacao_biblioteca;

public class Livro {
    private String nome;

    private boolean reservado;

    public Livro(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void reservar() {
        this.reservado = true;
    }
}
