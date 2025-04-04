package br.com.alura.screenmatch.desafios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DesafiosMain {
    public static void main(String[] args) {
        // 01 - Crie uma expressão lambda que multiplique dois números inteiros.
        // A expressão deve ser implementada dentro de uma interface funcional com o método multiplicacao(int a, int b).

        Multiplicacao minhaMultiplicacao = (a, b) -> a * b;
        System.out.println("Resultado da multiplicação: "+ minhaMultiplicacao.multiplica(8,7));

        // 02 - Implemente uma expressão lambda que verifique se um número é primo.
        VerificacaoPrimo verificacaoPrimo = a -> {
            if (a <= 1) return false;
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) return false;
            }
            return true;
        };
        System.out.println("\nVerirficando Primos");
        System.out.println(verificacaoPrimo.verificaPrimo(10));
        System.out.println(verificacaoPrimo.verificaPrimo(7));

        // 03 - Crie uma função lambda que receba uma string e a converta para letras maiúsculas.

        ConversaoParaMaiusculas conversaoParaMaiusculas = original -> original.toUpperCase();
        System.out.println("\nConvertendo para maiúsculas: ");
        System.out.println(conversaoParaMaiusculas.converteParaMaiusculas("qualquer coisa"));

        // 04 - Crie uma expressão lambda que verifique se uma string é um palíndromo. A expressão deve ser
        // implementada dentro de uma interface funcional com o metodo boolean verificarPalindromo(String str).
        // Dica: utilize o metodo reverse da classe StringBuilder.

        VerificacaoPalindromo verificacaoPalindromo = str -> str.equals(new StringBuilder(str).reverse().toString());
        System.out.println("\nTestando palindromos: ");
        System.out.println(verificacaoPalindromo.verificarPalindromo("radar"));
        System.out.println(verificacaoPalindromo.verificarPalindromo("java"));

        // 05 - Implemente uma expressão lambda que recebe uma lista de inteiros e retorna uma nova lista onde cada
        // número foi multiplicado por 3. Dica: a função replaceAll, das Collections, recebe uma interface funcional
        // como parâmetro, assim como vimos na função forEach.

        List<Integer> minhaLista = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Triplicador triplicador = a -> a * 3;   // Criando uma instância de Triplicador com lambda

        minhaLista.replaceAll(triplicador::triplicar);  // Usando replaceAll com a interface funcional

        System.out.println("\nLista com os elementos triplicados:");
        System.out.println(minhaLista);

        // 06 - Crie uma expressão lambda que ordene uma lista de strings em ordem alfabética. Dica: a função sort,
        // das Collections, recebe uma interface funcional como parâmetro, assim como vimos na função forEach

        List<String> listaDeNomes = Arrays.asList("Fulano", "Ciclano", "Beltrano", "Daniel", "Karine");
        listaDeNomes.sort((a, b) -> a.compareTo(b));
        System.out.println("Lista em ordem alfabetica: ");
        System.out.println(listaDeNomes);

        // 07 - Crie uma função lambda que recebe dois números e divide o primeiro pelo segundo.
        // A função deve lançar uma exceção de tipo ArithmeticException se o divisor for zero.

        Divisor divisor = (a, b) -> {
            if (b == 0) {
                throw new ArithmeticException("Não é possível dividir por zero.");
            }
            return a / b;
        };
        System.out.println("\nTestando divisões:");
        try {
            System.out.println(divisor.dividir(50, 10));
            System.out.println(divisor.dividir(50, 0));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());;
        }

    }
}
