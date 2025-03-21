//Crie um menu que oferece duas opções ao usuário: "1. Calcular área do quadrado" e "2. Calcular área do círculo".
//Solicite a escolha do usuário e realize o cálculo da área com base na opção selecionada.

import java.util.Scanner;

public class Ex03CalcularArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Escolha uma opção ---: ");
        System.out.println("1 - calcular área do quadrado.");
        System.out.println("2 - calcular área do círculo.");

        int escolhido = scanner.nextInt();

        if (escolhido == 1) {
            System.out.println("Digite o valor de um lado do quadrado:");
            double lado = scanner.nextDouble();
            double areaQuadrado = lado * lado;
            System.out.println("A área do quadrado é: " + areaQuadrado + "m².");
        } else {
            if (escolhido == 2) {
                System.out.println("Digite o valor do raio:");
                double raio = scanner.nextDouble();
                double areaCirculo = 3.14159 * raio * raio;
                System.out.println("A área do círculo é: " + areaCirculo + "m².");
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
}
