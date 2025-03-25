//04 - Crie uma classe NumerosPrimos com métodos como verificarPrimalidade() e listarPrimos().
//Em seguida, crie duas subclasses, VerificadorPrimo e GeradorPrimo, que herdam da classe NumerosPrimos.
//Adicione um metodo específico para cada uma das subclasses, como verificarSeEhPrimo() para o VerificadorPrimo
//e gerarProximoPrimo() para o GeradorPrimo.

package br.com.alura.screenmatch.desafios;

public class NumerosPrimos {
    public boolean verificarPrimalidade(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i * i <= numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void listarPrimos(int limiteSuperior) {
        System.out.println("Números primos até " + limiteSuperior + ": ");
        for (int i = 2; i <= limiteSuperior; i++) {
            if (verificarPrimalidade(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
