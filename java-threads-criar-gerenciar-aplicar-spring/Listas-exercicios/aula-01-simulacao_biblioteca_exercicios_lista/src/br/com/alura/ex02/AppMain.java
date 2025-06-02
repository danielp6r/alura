package br.com.alura.ex02;

//2 - Agora, suponha que temos que ter uma ordem de prioridade nas impressoras: queremos sempre que a thread 2
//rode o mais rápido possível. Podemos usar o metodo setPriority() para configurar a prioridade,
//passando como parâmetro o valor da prioridade que queremos dar à thread, sendo 10 a maior prioridade e 1 a menor prioridade.

public class AppMain {
    public static void main(String[] args) {
        var impressora1 = new Impressora(1);
        var impressora2 = new Impressora(2);

        Thread thread1 = new Thread(impressora1);
        Thread thread2 = new Thread(impressora2);

        thread2.setPriority(10);

        thread1.start();
        thread2.start();

    }
}
