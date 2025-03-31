package br.com.alura.screenmatch.desafios;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

public class DesafiosMain {
    public static void main(String[] args) throws IOException, InterruptedException {


        //01 - Crie uma classe Pessoa usando o conceito de Record em Java, com atributos como nome, idade e cidade.
        //Em seguida, implemente um programa que utiliza a biblioteca Gson para converter um JSON representando
        //uma pessoa em um objeto do tipo Pessoa.

        String json = "{\"nome\": \"Daniel\", \"idade\": 30, \"cidade\": \"Indaial\"}";

        // Criando um objeto Gson
        Gson gson = new Gson();

        // Convertendo o JSON para um objeto Pessoa
        Pessoa pessoa = gson.fromJson(json, Pessoa.class);

        // Exibindo o objeto Pessoa
        System.out.println("Ex 01 - Objeto Pessoa: " + pessoa);

        //02 - Modifique o programa do Exercício anterior para permitir a conversão de um JSON mesmo se alguns
        //campos estiverem ausentes ou se houver campos adicionais não representados no objeto Pessoa.
        //Consulte a documentação da biblioteca Gson para flexibilizar a conversão.

        //JSON com campo 'idade' ausente e outros campos adicionais a serem ignorados
        String jsonFlexivel = "{\"nome\": \"Daniel\", \"cidade\": \"Indaial\", \"endereco\": \"Rua XYZ\", \"profissao\": \"Desenvolvedor\"}";

        // Criando um objeto Gson com a configuração para permitir campos ausentes ou adicionais
        Gson gsonFlexivel = new GsonBuilder().setLenient().create();

        // Convertendo o JSON flexível para um objeto Pessoa
        Pessoa pessoaFlexivel = gsonFlexivel.fromJson(jsonFlexivel, Pessoa.class);

        // Exibindo o objeto Pessoa com o JSON flexível
        System.out.println("Ex 02 - Objeto Pessoa: " + pessoaFlexivel);

        //03 - Crie uma classe (record) Livro que contenha atributos como título, autor e um objeto representando a editora.
        //Em seguida, implemente um programa que utiliza a biblioteca Gson para converter um JSON aninhado
        //representando um livro em um objeto do tipo Livro.

        // JSON representando um livro com título, autor e editora (com nome e cidade).
        String jsonLivro = "{\"titulo\":\"O Senhor dos Anéis: A Sociedade do Anel\",\"autor\":\"J.R.R. Tolkien\",\"editora\":{\"nome\":\"HarperCollins\",\"cidade\":\"Londres\"}}";

        // Convertendo o JSON em um objeto Livro usando Gson
        Livro livro = gson.fromJson(jsonLivro, Livro.class);

        // Exibindo o objeto Livro convertido
        System.out.println("EX 03 - Objeto Livro: " + livro);

    }
}
