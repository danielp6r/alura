//01 - Crie uma classe ConversorMoeda que implementa uma interface ConversaoFinanceira com o
//metodo converterDolarParaReal() para converter um valor em dólar para reais.
//A classe deve receber o valor em dólar como parâmetro.

package Desafios;

public class ConversorMoeda implements ConversaoFinanceira {

    @Override
    public double converterDolarParaReal(double dolares) {
        double reais = dolares * 6;
        return reais;
    }
}