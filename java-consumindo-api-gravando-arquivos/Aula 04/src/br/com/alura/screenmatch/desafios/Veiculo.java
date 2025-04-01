package br.com.alura.screenmatch.desafios;

public class Veiculo {
    private String marca;
    private String modelo;
    private int ano;
    private String cor;

    public Veiculo(String marca, String modelo, int ano, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Ano: " + ano + ", Cor: " + cor;
    }
}
