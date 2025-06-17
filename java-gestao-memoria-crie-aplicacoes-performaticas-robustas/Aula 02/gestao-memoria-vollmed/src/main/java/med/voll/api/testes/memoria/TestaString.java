package med.voll.api.testes.memoria;

public class TestaString {
    public static void main(String[] args) throws InterruptedException {
        StringBuffer resultado = new StringBuffer();

        var thread1 = new Thread(()->
        {
            for(int i = 1; i<=100; i++){
                resultado.append(i);
                resultado.append(" ");
            }
        });

        var thread2 = new Thread(()->
        {
            for(int i = 101; i<=200; i++){
                resultado.append(i);
                resultado.append(" ");
            }
        });

        thread1.start();
        thread1.join(); // aguarda thread1 terminar
        thread2.start();
        thread2.join();

        System.out.println(resultado);

    }
}
