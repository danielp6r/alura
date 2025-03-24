public class Filme {
    String nome;
    int anoDeLancamento;
    boolean incluidoNoPlano;
    double somaDasAvaliacoes;
    int totalAvaliacoes;
    int duracaoEmMinutos;

    void exibeFichaTecnica() {
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);

    }

    void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totalAvaliacoes ++;
    }

    double pegaMedia() {
        return somaDasAvaliacoes / totalAvaliacoes;
    }
}
