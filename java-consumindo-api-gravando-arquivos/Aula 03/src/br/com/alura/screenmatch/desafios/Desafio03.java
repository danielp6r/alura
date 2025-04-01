package br.com.alura.screenmatch.desafios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Desafio03 {
    //03 - Desenvolva um programa em Java que permite aos usuários consultar informações sobre um usuário do GitHub
    //(utilize a API pública do GitHub para obter os dados). Crie uma classe de exceção personalizada,
    //ErroConsultaGitHubException, que estende RuntimeException. Lance essa exceção quando o nome de usuário não for
    //encontrado. No bloco catch, trate de forma específica essa exceção, exibindo uma mensagem amigável.

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o usuário do github: ");
        String usuario = scanner.nextLine();

        String endereco = "https://api.github.com/users/" + usuario;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verifica o status da resposta para saber se o usuário foi encontrado
            if (response.statusCode() == 404) {
                throw new ErroConsultaGitHubException("Usuário do GitHub não encontrado." );
            }

            // Caso o usuário seja encontrado, exibe as informações
            String json = response.body();
            System.out.println("Informações do GitHub: ");
            System.out.println(json);

        } catch (ErroConsultaGitHubException e) {
            // Tratar a exceção de forma específica, exibindo uma mensagem amigável
            System.out.println("Erro: " + e.getMessage());
        } catch (IOException | InterruptedException e) {
            // Captura outros tipos de exceções, como problemas de rede ou interrupções na execução
            System.out.println("Erro na consulta ao GitHub: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

}
