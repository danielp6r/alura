//Declare uma variável do tipo double valorEmDolares. Atribua um valor em dólares a essa variável.
//Considere que o valor de 1 dólar é equivalente a 4.94 reais.
//Realize a conversão do valor em dólares para reais e imprima o resultado formatado.

public class Ex05Dolar {
    public static void main(String[] args) {
        double valorEmDolares = 10.00;
        double valorEmReais = valorEmDolares * 4.94;
        System.out.printf("US$ %.2f equivalem a R$ %.2f", valorEmDolares, valorEmReais);
    }
}
