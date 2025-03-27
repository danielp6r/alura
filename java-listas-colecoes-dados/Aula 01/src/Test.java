import br.com.alura.screenmatch.modelos.Pessoa;

public class Test {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Daniel");
        pessoa.setIdade(30);

        System.out.println(pessoa.toString());

    }
}
