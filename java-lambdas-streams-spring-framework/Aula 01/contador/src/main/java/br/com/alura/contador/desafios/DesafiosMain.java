package br.com.alura.contador.desafios;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DesafiosMain {

    /*01 - Crie um novo projeto com Spring Boot, usando o site start.spring.io. Esse projeto será
        o contador, e funcionará na linha de comando. Você deve pedir para um usuário digitar um
        número e depois imprimir na tela uma contagem de 1 até o número digitado pelo usuário

        Resolução na pasta da Aula 01 - projeto contador.

        02 - Suponha que decidimos mudar de ideia e utilizar novamente a biblioteca Gson no nosso projeto
        ScreenMatch. Agora que estamos trabalhando com o Maven, os passos para adicionar a biblioteca são
        diferentes do que já foi feito antes. Explique quais passos você iria realizar nesse caso.

        Adicionar o código a seguir no arquivo pom.xml do projeto

        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.11.0</version>
        </dependency>

        03 - Agora iremos trabalhar com serialização e desserialização. Para isso, você pode reaproveitar seu
        projeto do exercício 1. Adicione a dependência do Jackson ao seu pom.xml, pois iremos utilizá-la
        bastante nos próximos exercícios. Também crie uma classe Tarefa, com os seguintes atributos:

        public class Tarefa {
            private String descricao;
            private boolean concluida;
            private String pessoaResponsavel;

            // Construtores, getters e toString

        Para que o Jackson funcione corretamente, é importante que sua classe tenha todos os getters e um
        construtor padrão. Também é legal criar um metodo toString().

        Dependencias Jackson adicionadas ao pom do projeto.
        classe Tarefa na pasta desafios
         */

    public static void main(String[] args) {
        /*
        04 - Lembre-se: serializar um objeto é conseguir representá-lo de alguma forma em um arquivo. Aqui,
        você deve instanciar um objeto do tipo Tarefa e fazer com que o conteúdo do objeto vá para o arquivo
        tarefa.json. Para isso, utilize o Jackson para te auxiliar na tarefa. Observação: para criar novos
        arquivos, podemos utilizar new File("tarefa.json").
         */

        // Cria um objeto do tipo Tarefa com os valores especificados
        Tarefa minhaTarefa = new Tarefa("exercício 04", true, "Daniel");

        ObjectMapper mapper = new ObjectMapper(); // Cria um ObjectMapper do Jackson para manipular JSON
        try {
            // Serializa o objeto minhaTarefa e o salva no arquivo "tarefa.json"
            mapper.writeValue(new File("tarefa.json"),minhaTarefa);
            System.out.println("Arquivo \"tarefa.json\" criado.");
        } catch (IOException e) {
            // Se ocorrer um erro de entrada/saída, lança uma RuntimeException
            throw new RuntimeException(e);
        }

        /*
        05 - Agora, você fará o oposto da atividade anterior: a desserialização de um arquivo, que é ler os valores de
        um arquivo específico e transformar em um objeto. Leia o conteúdo do arquivo tarefa.json, produzido no exercício
         anterior, e o transforme em um objeto do tipo Tarefa. Exiba o conteúdo do objeto na tela.
         */

        ObjectMapper mapper1 = new ObjectMapper(); // Cria um ObjectMapper do Jackson para manipular JSON
        Tarefa tarefaLida = null; // Declara um objeto do tipo Tarefa, que será preenchido com os dados do JSON
        try {
            // Lê o arquivo "tarefa.json" e converte seu conteúdo para um objeto do tipo Tarefa
            tarefaLida = mapper1.readValue(new File("tarefa.json"), Tarefa.class);
        } catch (IOException e) {
            // Se ocorrer um erro de leitura/escrita, lança uma RuntimeException
            throw new RuntimeException(e);
        }
        System.out.println(tarefaLida);
    }
}
