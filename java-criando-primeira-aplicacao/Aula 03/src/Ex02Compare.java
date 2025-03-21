//Peça ao usuário para inserir dois números inteiros. Compare os números e imprima uma mensagem
//indicando se são iguais, diferentes, o primeiro é maior ou o segundo é maior.

import java.util.Scanner;

public class Ex02Compare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro número:");
        int n1 = scanner.nextInt();
        System.out.println("Digite o segundo número: ");
        int n2 = scanner.nextInt();

        if (n1 == n2) {
            System.out.println("Números iguais");
        } else {
            if (n1 > n2) {
                System.out.println("O primeiro número é maior");
            } else {
                System.out.println("O segundo número é maior");
            }
        }
    }
}
