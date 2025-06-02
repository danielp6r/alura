package br.com.alura.ex01;

//1 - Vamos imprimir números paralelamente? Temos a classe Impressora:
//Crie uma classe main, duas impressoras e duas threads, cada uma delas usando uma impressora.
//É ideal que as impressoras tenham IDs diferentes. Veja o que acontece com a ordem da impressão dos números.

public class AppMain {
    public static void main(String[] args) {
        var impressora1 = new Impressora(1);
        var impressora2 = new Impressora(2);

        Thread thread1 = new Thread(impressora1);
        Thread thread2 = new Thread(impressora2);

        thread1.start();
        thread2.start();

    }
}
