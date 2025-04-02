package br.com.alura.contador.desafios;

public class Servico implements Avaliavel {
    private String descricao;

    public Servico(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String getNome() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Serviço: " + descricao;
    }
}
