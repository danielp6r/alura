package br.com.alura.screenmatch.desafios;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Desafio01 {
    public static void main(String[] args) {

        //01 - Crie um programa em Java que escreva a seguinte mensagem em um arquivo chamado "arquivo.txt":
        //"Conteúdo a ser gravado no arquivo." Utilize as classes do pacote java.io.

        try (FileWriter fileWriter = new FileWriter("arquivo.txt")) {
            fileWriter.write("Conteúdo a ser gravado no arquivo.");
            System.out.println("Conteúdo gravado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}