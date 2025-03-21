//Crie um programa que solicite ao usuário a entrada de um número inteiro.
//Verifique se o número é par ou ímpar e exiba uma mensagem correspondente.

import java.util.Scanner;

public class Ex05ParImpar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número inteiro:");
        int n = scanner.nextInt();

        if (n % 2 == 0) {
            System.out.println(n + " é par.");
        } else {
            System.out.println(n + " é ímpar.");
        }
    }
}
