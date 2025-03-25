//03 - Desenvolva uma classe Produto com os atributos privados nome e preco.
//Utilize métodos getters e setters para acessar e modificar esses atributos.
//Adicione um metodo aplicarDesconto que recebe um valor percentual e reduz o preço do produto.

public class Produto {
    private String nome;
    private double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void aplicarDesconto(double percentual) {
        this.setPreco(this.getPreco() - (this.getPreco() * percentual / 100));
    }
}
