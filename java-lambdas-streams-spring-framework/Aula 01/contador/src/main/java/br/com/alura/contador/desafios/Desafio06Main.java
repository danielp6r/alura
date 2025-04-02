package br.com.alura.contador.desafios;

import java.util.List;

public class Desafio06Main {

    /*
    06 - Vamos criar objetos genéricos. Imagine que você trabalha em um site que oferece várias coisas: venda de
    produtos, serviços de instalação desses produtos e assinatura de alguns itens. Todas essas coisas têm algo em comum:
    podem ser avaliadas pelos consumidores. Crie uma classe genérica de Avaliação, de modo que possamos ter, por exemplo:
    Avaliacao<Servico>, Avaliacao<Produto> e Avaliacao<Assinatura>. Essa classe deve ter o item genérico de avaliação,
    a nota e um comentário sobre a nota.
    Tendo criado a classe genérica, você também pode criar um metodo para calcular as médias das notas recebidas,
    independente do tipo de item avaliado.
     */

    public static void main(String[] args) {
        // Criando um objeto do tipo Produto
        Produto meuProduto = new Produto("Notebook");

        // Criando um objeto do tipo Serviço
        Servico servico = new Servico("Instalação de Internet");

        // Avaliando
        Avaliacao<Avaliavel> avaliacaoProduto = new Avaliacao<>(meuProduto, 9.0, "Ótimo desempenho!");
        Avaliacao<Avaliavel> avaliacaoServico = new Avaliacao<>(servico, 8.0, "Instalação rápida e eficiente.");

        // Calculando a média das notas usando apenas os dois objetos
        double media = Avaliacao.calcularMediaNotas(List.of(avaliacaoProduto, avaliacaoServico));

        // Exibindo os resultados
        System.out.println(avaliacaoProduto);
        System.out.println(avaliacaoServico);
        System.out.println("Média das avaliações: " + media);
    }
}
