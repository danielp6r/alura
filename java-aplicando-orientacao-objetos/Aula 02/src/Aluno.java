//04 - Desenvolva uma classe Aluno com os atributos privados nome e notas.
//Utilize métodos getters e setters para acessar e modificar esses atributos.
//Adicione um metodo calcularMedia que retorna a média das notas do aluno.

public class Aluno {
    private String nome;
    private double[] notas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public double calcularMedia() {

        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }
}
