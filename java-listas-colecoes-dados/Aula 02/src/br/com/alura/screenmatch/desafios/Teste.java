package br.com.alura.screenmatch.desafios;

import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) {

        //01 - Crie uma classe Produto com atributos como nome, preco, e quantidade.
        //Em seguida, crie uma lista de objetos Produto utilizando a classe ArrayList.
        //Adicione alguns produtos, imprima o tamanho da lista e recupere um produto pelo índice.

        Produto chaVerde = new Produto("Chá Verde Leão", 3.99, 10);
        Produto cocaZero = new Produto("Coca Cola Zero", 10.99, 1);
        Produto cafe = new Produto("Café ruim", 1000.99, 1);

        ArrayList<Produto> listaDeProdutos = new ArrayList<>();
        listaDeProdutos.add(chaVerde);
        listaDeProdutos.add(cocaZero);
        listaDeProdutos.add(cafe);

        System.out.println("Tamanho da lista: " + listaDeProdutos.size());
        System.out.println("Último item: " + listaDeProdutos.get(2).getNome());

        //02 - Implemente o metodo toString() na classe Produto para retornar uma representação em texto do objeto
        //Em seguida, imprima a lista de produtos utilizando o metodo System.out.println().

        System.out.println(listaDeProdutos);

        //03 - Modifique a classe Produto para incluir um construtor que aceite parâmetros para inicializar os atributos.
        //Em seguida, crie objetos Produto utilizando esse novo construtor.

        Produto novoProduto = new Produto("Produto Genérico ", 9.99, 10);
        System.out.println(novoProduto);

        //04 - Crie uma classe ProdutoPerecivel que herde de Produto. Adicione um atributo dataValidade e um construtor
        //que utilize o construtor da classe mãe (super) para inicializar os atributos herdados.
        //Crie um objeto ProdutoPerecivel e imprima seus valores.

        ProdutoPerecivel passatempo = new ProdutoPerecivel("Passatempo", 4.99, 1, "20 - 04 - 2025");
        System.out.println(passatempo);

    }
}
