package Desafios;

public class Livro implements Calculavel{
    @Override
    public double calcularPrecoFinal(double precoInicial) {
        return precoInicial - (precoInicial / 10);
    }
}
