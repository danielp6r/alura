package br.com.alura.screenmatch.desafios;

public class Cachorro extends Animal{
    @Override
    public void emitirSom() {
        System.out.println("Latido...");
    }

    public void abanarRabo() {
        System.out.println("Abanando rabo... ");
    }
}
