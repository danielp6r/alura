//Declare uma variável do tipo double precoOriginal. Atribua um valor em reais a essa variável,
//representando o preço original de um produto. Em seguida, declare uma variável do tipo double percentualDesconto
//e atribua um valor percentual de desconto ao produto (por exemplo, 10 para 10%).
//Calcule o valor do desconto em reais, aplique-o ao preço original e imprima o novo preço com desconto.

public class Ex06Desconto {
    public static void main(String[] args) {
        double precoOriginal = 10.90;
        double percentualDesconto = 10;
        double valorFinal = precoOriginal - (precoOriginal * percentualDesconto / 100);

        System.out.printf("Preço original: R$ %.2f%n", precoOriginal);
        System.out.printf("Desconto aplicado: %.2f%%%n", percentualDesconto);
        System.out.printf("Preço com desconto: R$ %.2f%n", valorFinal);
    }
}
