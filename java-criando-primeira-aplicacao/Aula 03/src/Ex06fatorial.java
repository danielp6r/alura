//Crie um programa que solicite ao usuário um número e calcule o fatorial desse número.

import java.util.Scanner;

public class Ex06fatorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número inteiro:");
        int n = scanner.nextInt();
        int resultado = 1;

        if (n < 0 ){
            System.out.println("Impossível calcular para valores negativos.");
        } else {
            while (n > 1) {
                resultado *= n;
                n--;
            }
            System.out.println(resultado);
        }
    }
}
