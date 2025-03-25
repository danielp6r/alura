import br.com.alura.screenmatch.modelos.Filme;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.setNome("O poderoso chefão");
        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(180);

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        System.out.println(meuFilme.pegaMedia());
        System.out.println("Total de avaliações: " + meuFilme.getTotalAvaliacoes());

        Produto meuProduto = new Produto();
        meuProduto.setPreco(100.00);
        meuProduto.aplicarDesconto(12.5);
        System.out.println(meuProduto.getPreco());

        Livro meuLivro = new Livro();
        meuLivro.setTitulo("O Senhor dos Anéis");
        meuLivro.setAutor("J.R.R. Tolkien");

        meuLivro.exibirDetalhes();
    }
}