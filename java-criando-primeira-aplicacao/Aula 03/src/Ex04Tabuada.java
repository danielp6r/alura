//Crie um programa que solicite ao usuário um número e exiba a tabuada desse número de 1 a 10.

import java.util.Scanner;

public class Ex04Tabuada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha um número de 1 a 10");
        int n = scanner.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + n * i);
        }
    }
}
