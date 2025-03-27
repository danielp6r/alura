// 03 - Crie uma classe TabuadaMultiplicacao que implementa uma interface Tabuada com o
//metodo mostrarTabuada() para exibir a tabuada de um número. A classe deve receber o número como parâmetro.

package Desafios;

public class TabuadaMultiplicacao implements Tabuada{
    @Override
    public void mostrarTabuada(int x) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(x + " x " + i + " = " + x * i);
        }
    }
}
