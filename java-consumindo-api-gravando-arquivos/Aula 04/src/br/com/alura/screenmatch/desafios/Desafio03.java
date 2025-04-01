package br.com.alura.screenmatch.desafios;

import br.com.alura.screenmatch.modelos.Titulo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Desafio03 {
    public static void main(String[] args) throws IOException, InterruptedException {

        //03 - Modifique o programa anterior para que o JSON gerado seja formatado de maneira mais elegante.
        // Utilize o metodo setPrettyPrinting para alcançar esse resultado.

        Titulo meuTitulo = new Titulo("Open Season",2006);
        meuTitulo.setDuracaoEmMinutos(86);
        meuTitulo.avalia(10);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(meuTitulo);
        System.out.println(json);

    }

}
