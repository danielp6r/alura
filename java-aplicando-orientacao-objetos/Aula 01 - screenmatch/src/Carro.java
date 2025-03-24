//Crie uma classe Carro com atributos modelo, ano, cor e métodos para exibir a ficha técnica e
//calcular a idade do carro.

public class Carro {
    String modelo;
    int ano;
    String cor;

    void fichaTecnica() {
        System.out.println(modelo);
        System.out.println(ano);
        System.out.println(cor);
    }

    int calcularIdade() {
        return 2025 - ano;
    }
}
