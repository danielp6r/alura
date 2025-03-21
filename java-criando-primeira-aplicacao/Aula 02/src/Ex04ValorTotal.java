//Declare uma variável do tipo double precoProduto e uma variável do tipo int (quantidade).
//Calcule o valor total multiplicando o preço do produto pela quantidade e apresente o resultado em uma mensagem.

public class Ex04ValorTotal {
    public static void main(String[] args) {
        double precoProduto = 2.50;
        int quantidade = 4;
        double valorTotal = precoProduto * quantidade;
        System.out.printf("O valor total da compra é: R$ %.2f%n", valorTotal);
    }
}
