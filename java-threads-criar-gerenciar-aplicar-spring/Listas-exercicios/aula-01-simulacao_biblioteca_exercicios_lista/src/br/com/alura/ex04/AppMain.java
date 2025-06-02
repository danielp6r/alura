package br.com.alura.ex04;

/*
4 - Vamos conferir o estado de uma thread. Crie um Runnable cujo metodo run apenas imprima “Olá, mundo”, e crie
uma thread na classe principal, usando esse runnable. Antes de utilizar o metodo start() na thread criada, vamos
usar um outro metodo, o isAlive(). Ele mostra um boolean, que diz “true” se a thread está ativa, e “false” caso esteja inativa.
Assim, antes do start, imprima o valor de isAlive(), e repita o procedimento depois de chamar o start(). Veja o que é impresso.
 */

public class AppMain {
    public static void main(String[] args) {
        var ola = new OlaMundo();

        Thread thread1 = new Thread(ola);

        System.out.println(thread1.isAlive());
        thread1.start();
        System.out.println(thread1.isAlive());

    }
}
