package br.com.alura.screenmatch.desafios;

import java.io.IOException;
import java.util.Scanner;

public class Desafio01 {
    public static void main(String[] args) throws IOException, InterruptedException {

        //01 - Crie um programa simples que solicita dois números ao usuário e realiza a divisão do primeiro pelo segundo.
        //Utilize o bloco try/catch para tratar a exceção que pode ocorrer caso o usuário informe 0 como divisor.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro numero:");
        double x = scanner.nextDouble();
        System.out.println("Digite o segundo numero:");
        double y = scanner.nextDouble();

        try {
            // Verifica se o divisor é zero antes de realizar a divisão
            if (y == 0) {
                throw new ArithmeticException("Erro: Não é possível dividir por zero.");
            }

            double divisao = x / y;
            System.out.println("A divisão de " + x + " por " + y + " é: " + divisao);

        } catch (ArithmeticException e) {
            // Captura e trata a exceção se ocorrer divisão por zero
            System.out.println(e.getMessage());
        }

        //Exemplo da correção
        System.out.println("Informe o numerador: ");
        int numerador = scanner.nextInt();

        System.out.println("Informe o denominador: ");
        int denominador = scanner.nextInt();

        try {
            int resultado = numerador / denominador;
            System.out.println("Resultado da divisão: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Erro: Divisão por zero não permitida.");
        }
    }
}