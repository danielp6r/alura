package br.com.alura.contador.desafios;

public class Tarefa {
    private String descricao;
    private boolean concluida;
    private String pessoaResponsavel;

    // Construtor vazio necessário para a serialização
    public Tarefa() {
    }

    public Tarefa(String descricao, boolean concluida, String pessoaResponsavel) {
        this.descricao = descricao;
        this.concluida = concluida;
        this.pessoaResponsavel = pessoaResponsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public String getPessoaResponsavel() {
        return pessoaResponsavel;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "descricao='" + descricao + '\'' +
                ", concluida=" + concluida +
                ", pessoaResponsavel='" + pessoaResponsavel + '\'' +
                '}';
    }
}
