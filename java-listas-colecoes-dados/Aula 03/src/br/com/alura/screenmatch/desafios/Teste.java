package br.com.alura.screenmatch.desafios;

import br.com.alura.screenmatch.modelos.*;

import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) {

        //01 Crie um ArrayList de strings e utilize um loop foreach para
        //percorrer e imprimir cada elemento da lista.

        ArrayList<String> meuArray = new ArrayList<>();
        meuArray.add("Primeiro");
        meuArray.add("Segundo");
        meuArray.add("Terceiro");

        for (String item: meuArray) {
            System.out.println(item);
        }

        //02 - Crie uma classe Animal e uma classe Cachorro que herda de Animal.
        //Em seguida, crie um objeto da classe Cachorro e faça o casting para a classe Animal.

        Cachorro preta = new Cachorro();
        Animal animal = (Animal) preta;

        //03 - Modifique o Exercício 2 para incluir uma verificação usando instanceof
        //para garantir que o objeto seja do tipo correto antes de fazer o casting.

        if (preta instanceof Cachorro) {
            Animal animal2 = (Animal) preta;
        }

        //04 - Crie uma classe Produto com propriedades como nome e preço. Em seguida, crie uma lista
        //de produtos e utilize um loop para calcular e imprimir o preço médio dos produtos.

        Produto produto1 = new Produto("produto1", 15);
        Produto produto2 = new Produto("produto2", 5);

        ArrayList<Produto> listaDeProdutos = new ArrayList<>();
        listaDeProdutos.add(produto1);
        listaDeProdutos.add(produto2);

        double precoTotal = 0;

        for (Produto item: listaDeProdutos) {
            precoTotal += item.getPreco();
        }
        System.out.println("Preço médio: " + precoTotal/listaDeProdutos.size());

        //05 - Crie uma interface Forma com um metodo calcularArea(). Implemente a interface em duas
        //classes, por exemplo, Circulo e Quadrado. Em seguida, crie uma lista de formas
        //(objetos da interface Forma) e utilize um loop para calcular e imprimir a área de cada forma.

        Quadrado quadrado = new Quadrado();
        quadrado.setLado(10);
        System.out.println(quadrado.calcularArea());

        Circulo circulo = new Circulo();
        circulo.setRaio(2);
        System.out.println(circulo.calcularArea());

        //06 - Crie uma classe ContaBancaria com propriedades como número da conta e saldo. Em seguida,
        //crie uma lista de contas bancárias com diferentes saldos.
        //Utilize um loop para encontrar e imprimir a conta com o maior saldo.

        ContaBancaria conta1 = new ContaBancaria(12345, 1000);
        ContaBancaria conta2 = new ContaBancaria(23456, 500);
        ContaBancaria conta3 = new ContaBancaria(34567, 2000);

        ArrayList<ContaBancaria> listaDeContas = new ArrayList<>();
        listaDeContas.add(conta1);
        listaDeContas.add(conta2);
        listaDeContas.add(conta3);

        ContaBancaria contaMaiorSaldo = listaDeContas.get(0);
        for (ContaBancaria conta : listaDeContas) {
            if (conta.getSaldo() > contaMaiorSaldo.getSaldo()) {
                contaMaiorSaldo = conta;
            }
        }

        System.out.println("Conta com o maior saldo:" + contaMaiorSaldo.getNumeroDaConta() +
                ", Com R$" + contaMaiorSaldo.getSaldo());

    }
}
