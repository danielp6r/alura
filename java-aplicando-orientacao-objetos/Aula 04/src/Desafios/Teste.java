package Desafios;

public class Teste {
    public static void main(String[] args) {
        ConversorMoeda conversorMoeda = new ConversorMoeda();
        System.out.println(conversorMoeda.converterDolarParaReal(10));

        CalculadoraSalaRetangular calculadora = new CalculadoraSalaRetangular();
        System.out.println(calculadora.calcularArea(2,10));
        System.out.println(calculadora.calcularPerimetro(2,10));

        TabuadaMultiplicacao tabuada = new TabuadaMultiplicacao();
        tabuada.mostrarTabuada(7);

        ConversorTemperaturaPadrao conversor = new ConversorTemperaturaPadrao();
        System.out.println(conversor.celsiusParaFahrenheit(40));
        System.out.println(conversor.fahrenheitParaCelsius(104));

        Livro livro = new Livro();
        System.out.println(livro.calcularPrecoFinal(40));
        ProdutoFisico produtoFisico = new ProdutoFisico();
        System.out.println(produtoFisico.calcularPrecoFinal(50));
    }
}
