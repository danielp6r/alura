package br.com.alura.ex01;

public class Impressora implements Runnable {
    private int id;
    public Impressora(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Impressora " + id + "	valor:	" + i);
        }
    }
}
