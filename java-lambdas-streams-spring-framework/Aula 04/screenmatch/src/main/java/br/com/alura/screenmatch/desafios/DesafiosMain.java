package br.com.alura.screenmatch.desafios;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DesafiosMain {
    public static void main(String[] args) {
        // 01 - Dada a lista de números inteiros abaixo, filtre apenas os números pares e imprima-os.

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        // código para filtragem.
        List<Integer> numerosPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Ex01: Lista filtrada por números pares: " + numerosPares);

        // 02 - Dada a lista de strings abaixo, converta todas para letras maiúsculas e imprima-as.

        List<String> palavras = Arrays.asList("java", "stream", "lambda");
        System.out.println("\nEx02: Convertido para letras maiúsculas:");
        // código para conversão
        palavras.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // 03 - Dada a lista de números inteiros abaixo, filtre os números ímpares,
        // multiplique cada um por 2 e colete os resultados em uma nova lista.

        List<Integer> numeros2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("\nEx03: Ímpares x2:");
        // código para filtragem e coleta
        List<Integer> numerosImpares = numeros2.stream()
                .filter(n -> n % 2 != 0)
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println(numerosImpares);

        // 04 - Dada a lista de strings abaixo, remova as duplicatas (palavras que aparecem mais de uma vez) e imprima o resultado.

        List<String> palavras2 = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        // código da filtragem
        List<String> distintas = palavras2.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("\nEx04: Palavras distintas: " + distintas);

        // 05 - Dada a lista de sublistas de números inteiros abaixo, extraia todos
        // os números primos em uma única lista e os ordene em ordem crescente.

        List<List<Integer>> listaDeNumeros = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12)
        );

        List<Integer> listaTodosPrimos = listaDeNumeros.stream()
                .flatMap(l -> l.stream())
                .filter(n -> ehPrimo(n))
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Ex05: Números primos extraídos de todas as listas e ordenados: " + listaTodosPrimos);

        // 06 - Dado um objeto Pessoa com os campos nome e idade, filtre as pessoas com mais de 18 anos,
        // extraia os nomes e imprima-os em ordem alfabética. A classe Pessoa está definida abaixo.

        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Alice", 22),
                new Pessoa("Bob", 17),
                new Pessoa("Charlie", 19)
        );

        System.out.println("\nEx06 Pessoas maiores de 18 anos e em ordem alfabética:");

        // código para filtrar pessoas
        pessoas.stream()
                .filter(p -> p.getIdade() > 18)
                .map(p ->p.getNome())   // pega só os nomes
                .sorted()
                .forEach(System.out::println);

        // 07 - Você tem uma lista de objetos do tipo Produto, onde cada produto possui os atributos nome (String),
        // preco (double) e categoria (String). Filtre todos os produtos da categoria "Eletrônicos" com preço menor
        // que R$ 1000, ordene-os pelo preço em ordem crescente e colete o resultado em uma nova lista.

        List<Produto> produtos = Arrays.asList(
                new Produto("Smartphone", 800.0, "Eletrônicos"),
                new Produto("Notebook", 1500.0, "Eletrônicos"),
                new Produto("Teclado", 200.0, "Eletrônicos"),
                new Produto("Cadeira", 300.0, "Móveis"),
                new Produto("Monitor", 900.0, "Eletrônicos"),
                new Produto("Mesa", 700.0, "Móveis")
        );

        System.out.println("\nEx07 - Eletrônicos abaixo de R$1000 (ordenados):");
        // código para filtrar os produtos
        List<Produto> novaLista = produtos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase("Eletrônicos"))
                .filter(p -> p.getPreco() < 1000)
                .sorted(Comparator.comparing(Produto::getPreco))
                .collect(Collectors.toList());
        novaLista.forEach(System.out::println);

        // 08 - Tomando o mesmo código do exercício anterior como base, modifique o código para que a saída mostre
        // apenas os três produtos mais baratos da categoria "Eletrônicos".

        System.out.println("\nEx08 - Top 3 eletrônicos mais baratos:");
        List<Produto> listaBaratos = produtos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase("Eletrônicos"))
                .sorted(Comparator.comparing(Produto::getPreco))
                .limit(3)
                .collect(Collectors.toList());
        listaBaratos.forEach(System.out::println);

    }

    // Função para verificar se um número é primo
    private static boolean ehPrimo(int numero) {
        if (numero < 2) return false; // Números menores que 2 não são primos
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false; // Divisível por outro número que não 1 e ele mesmo
            }
        }
        return true;
    }
}
