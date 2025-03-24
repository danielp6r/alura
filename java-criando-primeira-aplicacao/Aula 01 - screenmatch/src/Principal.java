public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.nome = "O poderoso chefão";
        meuFilme.anoDeLancamento = 1970;
        meuFilme.duracaoEmMinutos = 180;

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        System.out.println(meuFilme.pegaMedia());

        Pessoa pessoa = new Pessoa();
        pessoa.ola();

        Calculadora calculadora =  new Calculadora();
        System.out.println(calculadora.dobra(5));

        Aluno aluno1 = new Aluno();
        aluno1.nome = "Daniel";
        aluno1.idade = 30;

        aluno1.informacoes();
    }
}