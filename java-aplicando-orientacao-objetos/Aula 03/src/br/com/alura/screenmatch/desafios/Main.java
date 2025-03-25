package br.com.alura.screenmatch.desafios;

public class Main {
    public static void main(String[] args) {
        ModeloCarro meuCarro = new ModeloCarro();
        meuCarro.setModelo("Sportage");
        meuCarro.setPrecoAno1(50000);
        meuCarro.setPrecoAno2(60000);
        meuCarro.setPrecoAno3(70000);
        meuCarro.exibirInfo();

        Cachorro preta = new Cachorro();
        preta.emitirSom();
        preta.abanarRabo();

        Gato perola = new Gato();
        perola.emitirSom();
        perola.arranharMoveis();

        Animal silvestre = new Animal();
        silvestre.emitirSom();

        ContaCorrente nubank = new ContaCorrente();
        nubank.depositar(1000);
        nubank.consultarSaldo();
        nubank.sacar(200);
        nubank.consultarSaldo();
        nubank.cobrarTarifaMensal();

        VerificadorPrimo verificador = new VerificadorPrimo();
        verificador.verificarSeEhPrimo(5);

        GeradorPrimo gerador = new GeradorPrimo();
        int proximoPrimo = gerador.gerarProximoPrimo(5);
        System.out.println("O próximo primo é: " + proximoPrimo);

        NumerosPrimos numerosPrimos = new NumerosPrimos();
        numerosPrimos.listarPrimos(30);
    }
}
