package br.com.alura.contador.desafios;

import java.util.List;

// Declaração da classe genérica Avaliacao<T>
// O <T> significa que essa classe pode ser usada com qualquer tipo de objeto.
public class Avaliacao <T> {
    private T item; // O item avaliado pode ser de qualquer tipo (Produto, Serviço, Assinatura, etc.).
    private double nota;
    private String comentario;

    // Construtor que recebe um item genérico, uma nota e um comentário.
    public Avaliacao(T item, double nota, String comentario) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve ser entre 0 e 10.");
        }
        this.item = item;
        this.nota = nota;
        this.comentario = comentario;
    }

    // Metodo para obter o item avaliado (de qualquer tipo)
    public T getItem() {
        return item;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve ser entre 0 e 10.");
        }
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    // Metodo estático que recebe uma lista de avaliações genéricas e calcula a média das notas.
    public static <T> double calcularMediaNotas(List<Avaliacao<T>> avaliacoes) {
        if (avaliacoes.isEmpty()) {
            throw new IllegalArgumentException("A lista de avaliações está vazia.");
        }
        double soma = 0;
        for (Avaliacao<T> avaliacao : avaliacoes) {
            soma += avaliacao.getNota();
        }
        return soma / avaliacoes.size(); // Retorna a média das notas
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "item=" + item + // Aqui o item pode ser qualquer tipo de objeto.
                ", nota=" + nota +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
