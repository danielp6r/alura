package br.com.alura.screenmatch.desafios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Desafio02 {
    public static void main(String[] args) throws IOException, InterruptedException {

        //02 - Crie um programa Java que utiliza as classes HttpClient, HttpRequest e HttpResponse para fazer
        //uma consulta à API CoinGecko e exiba a cotação atual de uma criptomoeda escolhida pelo usuário.

        // Solicita que o usuário insira o nome de uma criptomoeda
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o nome da criptomoeda para buscar a cotação (ex: bitcoin, ethereum): ");
        var moeda = leitura.nextLine().toLowerCase();

        // Define o endereço da API CoinGecko
        String endereco = "https://api.coingecko.com/api/v3/simple/price?ids=" + moeda + "&vs_currencies=usd";

        // Cria o cliente HTTP
        HttpClient client = HttpClient.newHttpClient();
        // Cria a requisição HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        // Envia a requisição e obtém a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Verifica se a resposta foi bem-sucedida
        if (response.statusCode() == 200) {
            // Exibe o corpo da resposta, que contém a cotação da criptomoeda
            System.out.println("Resposta da API: " + response.body());
        } else {
            // Caso a API retorne um erro, exibe uma mensagem
            System.out.println("Erro ao buscar a cotação. Verifique o nome da criptomoeda.");
        }
    }
}
