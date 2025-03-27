//02 - Crie uma classe CalculadoraSalaRetangular que implementa uma interface CalculoGeometrico com os métodos
//calcularArea() e calcularPerimetro() para calcular a área e o perímetro de uma sala retangular.
//A classe deve receber altura e largura como parâmetros.

package Desafios;

public class CalculadoraSalaRetangular implements CalculoGeometrico{
    @Override
    public double calcularArea(double altura, double largura) {
        double area = altura * largura;
        return area;
    }

    @Override
    public double calcularPerimetro(double altura, double largura) {
        double perimetro = 2 * (altura + largura);
        return perimetro;
    }
}
