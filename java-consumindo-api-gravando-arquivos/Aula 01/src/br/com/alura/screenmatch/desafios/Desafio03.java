package br.com.alura.screenmatch.desafios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Desafio03 {

    public static void main(String[] args) throws IOException, InterruptedException {

        //03 - Crie um programa Java que faça uma consulta à API do TheMealDB utilizando as classes HttpClient,
        //HttpRequest e HttpResponse. Solicite ao usuário que insira o nome de uma receita e exiba as informações
        //disponíveis sobre essa receita.

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o nome de uma receita: ");
        var busca = leitura.nextLine();

        String endereco = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + busca;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

    }
}
