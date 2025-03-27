//05 - Crie uma interface Calculavel com um metodo double calcularPrecoFinal().
//Implemente essa interface nas classes Livro e ProdutoFisico, cada uma retornando o preço final
//considerando descontos ou taxas adicionais.

package Desafios;

public interface Calculavel {
    double calcularPrecoFinal(double precoInicial);
}
