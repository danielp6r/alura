package br.com.alura.ex05;

/*
5 - Por fim, na classe anterior, depois de chamar o metodo start(), chame o join, para depois
imprimir o valor de isAlive(). Qual a diferença entre os dois? Por que você acha que isso aconteceu?
 */

public class AppMain {
    public static void main(String[] args) throws InterruptedException {
        var ola = new OlaMundo();

        Thread thread1 = new Thread(ola);

        System.out.println(thread1.isAlive());
        thread1.start();
        thread1.join();
        System.out.println(thread1.isAlive());
    }

    /*
    Agora, aparecem dois falses, com a mensagem entre eles. Isso ocorre porque antes estávamos rodando tanto a thread
    main quanto a thread1 ao mesmo tempo. Então, era impresso que a thread1 estava ativa. Depois, passamos a esperar a
    thread1 parar de rodar para só aí imprimir se estava ativa ou não. Assim, dava tempo de ela ser desativada,
    aparecendo false nas duas impressões.
     */
}
