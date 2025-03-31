//01 - Crie uma classe Pessoa com atributos como nome, idade,
//e um metodo toString que represente esses atributos.

package br.com.alura.screenmatch.modelos;

public class Pessoa {
    private String nome;
    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "; " + this.getIdade() + " anos.";
    }
}