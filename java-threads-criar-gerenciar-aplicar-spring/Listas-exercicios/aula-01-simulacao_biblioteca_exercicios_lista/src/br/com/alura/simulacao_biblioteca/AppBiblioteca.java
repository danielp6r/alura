package br.com.alura.simulacao_biblioteca;

public class AppBiblioteca {
    public static void main(String[] args) {
        var livro = new Livro("LOTR");
        var operacao = new OperacaoReserva(livro);

        Thread reservarJoao = new Thread(operacao, "João");
        Thread reservarMaria = new Thread(operacao, "Maria");

        reservarMaria.start();
        reservarJoao.start();

        try {
            reservarJoao.join();
            reservarMaria.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Reservas finalizadas!");

    }
}
