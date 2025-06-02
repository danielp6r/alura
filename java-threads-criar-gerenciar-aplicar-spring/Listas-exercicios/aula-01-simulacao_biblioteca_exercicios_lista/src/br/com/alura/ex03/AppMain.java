package br.com.alura.ex03;

//3 - Altere as prioridades da atividade anterior, para que agora a thread 1 seja executada o mais rápido possível.

public class AppMain {
    public static void main(String[] args) {
        var impressora1 = new Impressora(1);
        var impressora2 = new Impressora(2);

        Thread thread1 = new Thread(impressora1);
        Thread thread2 = new Thread(impressora2);
        
        thread1.setPriority(10);

        thread1.start();
        thread2.start();

    }
}
