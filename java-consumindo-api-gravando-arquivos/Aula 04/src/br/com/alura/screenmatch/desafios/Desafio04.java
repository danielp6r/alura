package br.com.alura.screenmatch.desafios;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Desafio04 {
    public static void main(String[] args) {

        //04 - Defina uma classe chamada Veiculo com os atributos necessários. Em seguida, crie um programa que
        //instancia um objeto Veiculo, serializa esse objeto para JSON usando a biblioteca Gson e imprime o resultado.

        Veiculo meuVeiculo = new Veiculo("Kia", "Sportage", 2006, "Prata");

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(meuVeiculo);
        System.out.println(json);
    }
}
