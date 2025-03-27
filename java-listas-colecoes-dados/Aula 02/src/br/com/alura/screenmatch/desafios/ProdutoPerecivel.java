package br.com.alura.screenmatch.desafios;

public class ProdutoPerecivel extends Produto {
    private String dataValidade;

    public ProdutoPerecivel(String nome, double preco, int quantidade, String dataValidade) {
        super(nome, preco, quantidade);
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return super.toString() +
                "dataValidade='" + dataValidade + '\'' +
                '}';
    }
}
