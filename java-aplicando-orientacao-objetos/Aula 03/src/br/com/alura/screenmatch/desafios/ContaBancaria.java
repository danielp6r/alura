//03 - Crie uma classe ContaBancaria com métodos para realizar operações bancárias como depositar(),
//sacar() e consultarSaldo().
//Em seguida, crie uma subclasse ContaCorrente que herda da classe ContaBancaria. Adicione um metodo específico
//para a subclasse, como cobrarTarifaMensal(), que desconta uma tarifa mensal da conta corrente.

package br.com.alura.screenmatch.desafios;

public class ContaBancaria {
    protected double saldo;

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Valor depositado: R$" + valor);
    }

    public void sacar(double valor) {
        if (saldo < valor) {
            System.out.println("Saldo indisponível! ");
        } else {
            saldo -= valor;
            System.out.println("Valor sacado: R$" + valor);
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo Atual: R$" + saldo);
    }
}
