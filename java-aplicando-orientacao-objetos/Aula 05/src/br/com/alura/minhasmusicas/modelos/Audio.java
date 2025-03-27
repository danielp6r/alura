package br.com.alura.minhasmusicas.modelos;

public class Audio {
    private String titulo;
    private int totalReproducoes;
    private int totalCurtidas;
    private int classificacao;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTotalReproducoes() {
        return totalReproducoes;
    }

    public int getTotalCurtidas() {
        return totalCurtidas;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void curte() {
        System.out.println("Você curtiu " + this.titulo);
        System.out.println("Total de curtidas: " + this.totalCurtidas);
        this.totalCurtidas ++;
    }

    public void reproduz() {
        System.out.println("Reproduzindo " + this.titulo);
        System.out.println("Total de reproduções " + this.totalReproducoes);
        this.totalReproducoes++;
    }
}
