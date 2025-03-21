import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        String nome = "Daniel";
        String tipoConta = "Corrente";
        double saldo = 500000.99;

        int opcao = 0;

        System.out.println("**************************\n");
        System.out.println("Nome do Cliente: " + nome);
        System.out.println("Tipo da Conta: " + tipoConta);
        System.out.println("Saldo Atual: R$" + saldo);
        System.out.println("**************************\n");

        String menu = """
                ** Digite a opção **
                1 - Saldo
                2 - Transferir
                3 - Saque
                4 - Sair
                
                """;

        Scanner scanner = new Scanner(System.in);

        while (opcao != 4) {
            System.out.println(menu);
            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("O saldo é: " + saldo);
            } else if (opcao == 2) {
                System.out.println("Valor a transferir:");
                double valor = scanner.nextDouble();
                scanner.nextLine(); // Consumir quebra de linha pendente

                if (valor > saldo) {
                    System.out.println("Saldo insuficiente.");
                } else {
                    System.out.println("Transferir para: ");
                    String destinatario = scanner.nextLine();
                    saldo -= valor;
                    System.out.println("Valor transferido: R$" + valor + " para " + destinatario);
                    System.out.println("Saldo Atual: R$" + saldo);
                }
            } else if (opcao == 3) {
                System.out.println("Valor do saque:");
                double saque = scanner.nextDouble();
                if (saque > saldo) {
                    System.out.println("Saldo insuficiente.");
                } else {
                    saldo -= saque;
                    System.out.println("Saldo Atual: R$" + saldo);
                }
            }
        }
    }
}