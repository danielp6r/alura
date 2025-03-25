package br.com.alura.screenmatch.desafios;

public class ContaCorrente extends ContaBancaria{
    public void cobrarTarifaMensal() {
        if (saldo < 35) {
            System.out.println("Saldo insuficiente para cobrar tarifa! ");
        } else {
            saldo -= 35;
            System.out.println("Tarifa descontada com sucesso! Saldo Atual: R$" + saldo);
        }
    }
}
