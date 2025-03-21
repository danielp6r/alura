//Crie um programa que simula um jogo de adivinhação, que deve gerar um número aleatório entre 0 e 100 e pedir para que
//o usuário tente adivinhar o número, em até 5 tentativas.
//A cada tentativa, o programa deve informar se o número digitado pelo usuário é maior ou menor do que o número gerado.
//Dicas:
//    Para gerar um número aleatório em Java: new Random().nextInt(100);
//    Utilize o Scanner para obter os dados do usuário;
//    Utilize uma variável para contar as tentativas;
//    Utilize um loop para controlar as tentativas;
//    Utilize a instrução break; para interromper o loop.

import java.util.Random;
import java.util.Scanner;

public class Adivinhacao {
    public static void main(String[] args) {
        int na = new Random().nextInt(100);
        int tentativas = 0;
        int chute;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha um número de 1 a 100: ");

        while (tentativas < 5) {
            System.out.println((tentativas + 1) + "ª tentativa: ");
            chute = scanner.nextInt();
            if (chute == na) {
                System.out.println("Acertou!");
                break;
            } else {
                if (chute < na) {
                    System.out.println("O número é maior.");
                    tentativas++;
                } else {
                    System.out.println("O número é menor. ");
                    tentativas++;
                }
            }
        }
    }
}
