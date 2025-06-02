package br.com.alura.simulacao_biblioteca;

public class OperacaoReserva implements Runnable{

    private Livro livro;

    public OperacaoReserva(Livro livro) {
        this.livro = livro;
    }

    public synchronized void reservarLivro() {
        System.out.println("Iniciando reserva");

        if (!livro.isReservado()) {
            livro.reservar();
            System.out.println("Reserva efetuada com sucesso! Aproveite a leitura, " + Thread.currentThread().getName());
        } else {
            System.out.println("O livro já foi reservado, " + Thread.currentThread().getName());
        }

    }

    @Override
    public void run() {
        reservarLivro();
    }
}
