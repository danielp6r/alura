package Desafios;

public class ProdutoFisico implements Calculavel{
    @Override
    public double calcularPrecoFinal(double precoInicial) {
        return precoInicial * 1.1;
    }
}
