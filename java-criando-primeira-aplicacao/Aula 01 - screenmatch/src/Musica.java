//Crie uma classe Musica com atributos titulo, artista, anoLancamento, avaliacao e numAvaliacoes,
//e métodos para exibir a ficha técnica, avaliar a música e calcular a média de avaliações.

public class Musica {
    String titulo;
    String artista;
    int anoLancamento;
    double avaliacao;
    int numAvaliacoes;

    void exibeFichaTecnica() {
        System.out.println(titulo);
        System.out.println(artista);
        System.out.println(anoLancamento);
    }

    void avalia(double nota) {
        avaliacao += nota;
        numAvaliacoes ++;
    }

    double calculaMedia() {
        return avaliacao / numAvaliacoes;
    }

}
