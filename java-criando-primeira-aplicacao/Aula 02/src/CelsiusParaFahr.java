import java.util.Scanner;

public class CelsiusParaFahr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a temperatura em Celsius:");
        double celsius = scanner.nextDouble();
        double fah = (int) ((celsius * 1.8) + 32);

        System.out.println(celsius + " graus C equivalem a " + fah + " graus Fahrenheit.");
    }
}
