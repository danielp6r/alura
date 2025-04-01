package br.com.alura.screenmatch.desafios;

import br.com.alura.screenmatch.modelos.Titulo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.util.Scanner;

public class Desafio02 {
    public static void main(String[] args) {
        //02 - Defina uma classe chamada Titulo com os atributos necessários. Em seguida, crie um programa que
        //instancia um objeto Titulo, serializa esse objeto para JSON usando a biblioteca Gson e imprime o resultado.

        Titulo meuTitulo = new Titulo("Open Season",2006);
        meuTitulo.setDuracaoEmMinutos(86);
        meuTitulo.avalia(10);

        Gson gson = new Gson();
        String json = gson.toJson(meuTitulo);
        System.out.println(json);
    }
}
