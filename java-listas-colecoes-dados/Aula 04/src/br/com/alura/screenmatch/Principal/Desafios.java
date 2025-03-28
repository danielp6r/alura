package br.com.alura.screenmatch.Principal;

import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Desafios {
    public static void main(String[] args) {
        //01 - Crie uma lista de números inteiros e utilize o metodo Collections.sort
        // para ordená-la em ordem crescente. Em seguida, imprima a lista ordenada.

        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(0);
        numeros.add(12);
        numeros.add(147);
        numeros.add(-1);
        numeros.add(-17);

        Collections.sort(numeros);
        System.out.println("Lista de números em ordem crescente: ");
        System.out.println(numeros);

        //02 - Crie uma classe Titulo com um atributo nome do tipo String. Implemente a interface
        //Comparable na classe para que seja possível ordenar uma lista de objetos Titulo.

        ArrayList<Titulo> listaDeTitulos = new ArrayList<>();

        // 03 - No Exercício 2, crie alguns objetos da classe Titulo e adicione-os a uma lista.
        //Utilize o metodo Collections.sort para ordenar a lista e, em seguida, imprima os títulos ordenados.

        Titulo titulo1 = new Titulo("Alguma coisa", 2025);
        Titulo titulo2 = new Titulo("Qualquer coisa", 2020);
        Titulo titulo3 = new Titulo("Outra coisa", 1999);

        listaDeTitulos.add(titulo1);
        listaDeTitulos.add(titulo2);
        listaDeTitulos.add(titulo3);

        Collections.sort(listaDeTitulos);
        System.out.println("Lista de títulos ordenada: ");
        System.out.println(listaDeTitulos);
        for (Titulo titulo : listaDeTitulos) {
            System.out.println(titulo.getNome());
        }

        //04 - Crie uma lista utilizando a interface List e instancie-a tanto como ArrayList quanto como LinkedList.
        //Adicione elementos e imprima a lista, mostrando que é possível trocar facilmente a implementação.

        List<String> lista = new LinkedList<>();  // comentar para mudar a implementação
        //List<String> lista = new ArrayList<>(); // descomentar para mudar a implementação

        lista.add("aaa");
        lista.add("bbb");
        lista.add("ccc");
        System.out.println("Implementação: " + lista.getClass().getSimpleName());
        System.out.println(lista);

        //05 - Modifique o Exercício 4 para declarar a variável de lista como a interface List,
        //demonstrando o uso de polimorfismo.

        List<String> listaPolimorfica;

        System.out.println("Demonstrando a polimorfia com os métodos de Arraylist e Linkedlist");
        System.out.println("*******************************************************************");

        listaPolimorfica = new ArrayList<>();
        listaPolimorfica.add("A");
        listaPolimorfica.add("B");
        listaPolimorfica.add("C");
        System.out.println();
        System.out.println("Arraylist:");
        System.out.println(listaPolimorfica);

        listaPolimorfica = new LinkedList<>();
        listaPolimorfica.add("1");
        listaPolimorfica.add("2");
        listaPolimorfica.add("3");
        System.out.println("Linkedlist:");
        System.out.println(listaPolimorfica);
    }
}
