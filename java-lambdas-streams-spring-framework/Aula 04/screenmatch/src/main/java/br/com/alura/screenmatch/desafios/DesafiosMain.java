package br.com.alura.screenmatch.desafios;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class DesafiosMain {
    public static void main(String[] args) {
        // 01 - Dada a lista de números inteiros a seguir, encontre o maior número dela.

        List<Integer> numeros = asList(10, 20, 30, 40, 50);
        // código do agrupamento
        Optional<Integer> maximo = numeros.stream()
                .max(Integer::compareTo);
        maximo.ifPresent(m -> System.out.println("Ex01 - Maior Número: " + m));

        // 02 -Dada a lista de palavras (strings) abaixo, agrupe-as pelo seu tamanho.
        // Resultado Esperado: {4=[java, code], 6=[stream, lambda]}

        List<String> palavras = asList("java", "stream", "lambda", "code");
        // código do agrupamento
        Map<Integer, List<String>> agrupamento = palavras.stream()
                .collect(Collectors.groupingBy(p -> p.length()));
        System.out.println("Ex02 - Agrupamento por tamanho: " + agrupamento);

        // 03 - Dada a lista de nomes abaixo, concatene-os separados por vírgula.
        // Resultado Esperado: "Alice, Bob, Charlie"

        List<String> nomes = asList("Alice", "Bob", "Charlie");
        // código do agrupamento de dados
        String resultado = nomes.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Ex03 - Concatenado: " + resultado);

        // 04 - Dada a lista de números inteiros abaixo, calcule a soma dos quadrados dos números pares.

        List<Integer> numeros2 = asList(1, 2, 3, 4, 5, 6);
        // código da filtragem e agrupamento dos dados
        int somaDosQuadrados = numeros2.stream()    // Inicia um Stream para processar os elementos da lista
                .filter(n -> n % 2 == 0)    // Filtra somente números pares
                .map(n -> n * n)    // Eleva cada número ao quadrado
                .reduce(0, Integer::sum);   // Soma todos os quadrados, acumulando os valors
        System.out.println("Ex04 - Soma dos quadrados dos pares: " + somaDosQuadrados);

        // 05 - Dada uma lista de números inteiros, separe os números pares dos ímpares.

        List<Integer> numeros3 = asList(1, 2, 3, 4, 5, 6);
        // código do particionamento da lista
        Map<Boolean, List<Integer>> parOuImpar = numeros3.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0)); // Usa partitioningBy para separar os números em dois grupos: pares (true) e ímpares (false)
        System.out.println("Ex05 - Pares: " + parOuImpar.get(true));
        System.out.println("Ex05 - Ímpares: " + parOuImpar.get(false));

        // Código para os próximos exercícios:

        List<Produto> produtos = asList(
                new Produto("Smartphone", 800.0, "Eletrônicos"),
                new Produto("Notebook", 1500.0, "Eletrônicos"),
                new Produto("Teclado", 200.0, "Eletrônicos"),
                new Produto("Cadeira", 300.0, "Móveis"),
                new Produto("Monitor", 900.0, "Eletrônicos"),
                new Produto("Mesa", 700.0, "Móveis")
        );

        // 06 - Dada a lista de produtos acima, agrupe-os por categoria em um Map<String, List<Produto>>

        Map<String, List<Produto>> produtosPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(p -> p.getCategoria()));
        System.out.println("Ex06 - Produtos por categoria: ");
        produtosPorCategoria.forEach((categoria, lista) -> {
            System.out.println("Categoria: " + categoria);
            lista.forEach(produto -> System.out.println("  - " + produto));
        });

        // 07 - Dada a lista de produtos acima, conte quantos produtos há em cada categoria e armazene em um Map<String, Long>.

        Map<String, Long> contagemPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria, Collectors.counting()));
        System.out.println("Ex07 - Contagem por categoria: " + contagemPorCategoria);

        // 08 - Dada a lista de produtos acima, encontre o produto mais caro de cada categoria
        // e armazene o resultado em um Map<String, Optional<Produto>>.

        Map<String, Optional<Produto>> maisCaro = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria,
                        Collectors.maxBy(Comparator.comparingDouble(Produto::getPreco))));
        System.out.println("Ex08 - Mais caro por categoria");
        System.out.println(maisCaro);

        // 09 - Dada a lista de produtos acima, calcule o total dos preços dos produtos
        // em cada categoria e armazene o resultado em um Map<String, Double>.

        Map<String, Double> totalPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria,
                        Collectors.summingDouble(Produto::getPreco)));
        System.out.println("Ex09 - Soma dos preços por categoria: ");
        System.out.println(totalPorCategoria);

    }

}
