package br.com.alura.gerenciador_pedidos.principal;

import br.com.alura.gerenciador_pedidos.models.Categoria;
import br.com.alura.gerenciador_pedidos.models.Fornecedor;
import br.com.alura.gerenciador_pedidos.models.Pedido;
import br.com.alura.gerenciador_pedidos.models.Produto;
import br.com.alura.gerenciador_pedidos.repository.CategoriaRepository;
import br.com.alura.gerenciador_pedidos.repository.FornecedorRepository;
import br.com.alura.gerenciador_pedidos.repository.PedidoRepository;
import br.com.alura.gerenciador_pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/* Decidir em qual dos repositórios essa busca melhor se encaixa, e criar a derived query correspondente.

01 - Retorne todos os produtos com o nome exato fornecido.

02 - Retorne todos os produtos associados a uma categoria específica.

03 - Retorne produtos com preço maior que o valor fornecido.

04 - Retorne produtos com preço menor que o valor fornecido.

05 - Retorne produtos cujo nome contenha o termo especificado.

06 - Retorne pedidos que ainda não possuem uma data de entrega.

07 - Retorne pedidos com data de entrega preenchida.

08 - Retorne produtos de uma categoria ordenados pelo preço de forma crescente.

09 - Retorne produtos de uma categoria ordenados pelo preço de forma decrescente.

10 - Retorne a contagem de produtos em uma categoria específica.

11 - Retorne a contagem de produtos cujo preço seja maior que o valor fornecido.

12 - Retorne produtos com preço menor que o valor fornecido ou cujo nome contenha o termo especificado.

13 - Retorne pedidos feitos após uma data específica.

14 - Retorne pedidos feitos antes de uma data específica. , 15 - Retorne pedidos feitos em um intervalo de datas.

16 - Retorne os três produtos mais caros.

17 - Retorne os cinco produtos mais baratos de uma categoria.

*/

@Component
public class Principal {

    private Scanner leitura = new Scanner(System.in);

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                
                1 - Retorne todos os produtos com o nome exato fornecido 
                2 - Retorne todos os produtos associados a uma categoria específica
                3 - Retorne produtos com preço maior que o valor fornecido
                4 - Retorne produtos com preço menor que o valor fornecido
                5 - Retorne produtos cujo nome contenha o termo especificado
                6 - Retorne pedidos que ainda não possuem uma data de entrega
                7 - Retorne pedidos com data de entrega preenchida
                8 - Retorne produtos de uma categoria ordenados pelo preço de forma crescente
                9 - Retorne produtos de uma categoria ordenados pelo preço de forma decrescente
                10 - Retorne a contagem de produtos em uma categoria específica
                11 - Retorne a contagem de produtos cujo preço seja maior que o valor fornecido
                12 - Retorne produtos com preço menor que o valor fornecido ou cujo nome contenha o termo especificado
                13 - Retorne pedidos feitos após uma data específica
                14 - Retorne pedidos feitos antes de uma data específica
                15 - Retorne pedidos feitos em um intervalo de datas
                16 - Retorne os três produtos mais caros
                17 - Retorne os cinco produtos mais baratos de uma categoria
                0 - Sair                                 
                """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarPorNome();
                    break;
                case 2:
                    buscarPorCategoria();
                    break;
                case 3:
                    buscarPorPrecoMaiorQue();
                    break;
                case 4:
                    buscarPorPrecoMenorQue();
                    break;
                case 5:
                    buscarPorTermo();
                    break;
                case 6:
                    buscarPorSemDataEntrega();
                    break;
                case 7:
                    buscarPorDataEntrega();
                    break;
                case 8:
                    buscarPorCategoriaPrecoAsc();
                    break;
                case 9:
                    buscarPorCategoriaPrecoDesc();
                    break;
                case 10:
                    contagemPorCategoria();
                    break;
                case 11:
                    contagemPorValorMaiorQue();
                    break;
                case 12:
                    buscarPorTermoComPrecoMenorQue();
                    break;
                case 13:
                    buscarPorDataDepoisDe();
                    break;
                case 14:
                    buscarPorDataAntesDe();
                    break;
                case 15:
                    buscarPorDatasEntre();
                    break;
                case 16:
                    buscar3MaisCaros();
                    break;
                case 17:
                    buscar5MaisBaratosPorCategoria();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

    }

    private void buscarPorNome() {
        System.out.println("Digite o nome do produto a ser buscado: ");
        var nomeProduto = leitura.nextLine();
        List<Produto> produtos = produtoRepository.findByNome(nomeProduto);
        produtos.forEach(produto -> System.out.println(produto.getNome()));
    }

    private void buscarPorCategoria() {
        System.out.println("Digite a categoria a ser buscada: ");
        var categoriaNome = leitura.nextLine();
        List<Produto> produtos = produtoRepository.findByCategoriaNome(categoriaNome);
        produtos.forEach(p -> System.out.println(p.getNome()));
    }

    private void buscarPorPrecoMaiorQue() {
        System.out.println("Produtos com preço maior que: ");
        var preco = leitura.nextDouble();
        List<Produto> produtos = produtoRepository.findByPrecoGreaterThan(preco);
        produtos.forEach(produto -> System.out.println(produto.getNome() + " - Preco: R$" + produto.getPreco()));
    }

    private void buscarPorPrecoMenorQue() {
        System.out.println("Produtos com preço menor que: ");
        var preco = leitura.nextDouble();
        List<Produto> produtos = produtoRepository.findByPrecoLessThan(preco);
        produtos.forEach(produto -> System.out.println(produto.getNome() + " - Preco: R$" + produto.getPreco()));
    }

    private void buscarPorTermo() {
        System.out.println("Digite o termo a ser buscado: ");
        var termo = leitura.nextLine();
        List<Produto> produtos = produtoRepository.findByNomeContaining(termo);
        produtos.forEach(p -> System.out.println(p.getNome()));
    }

    private void buscarPorSemDataEntrega() {
        List<Pedido> pedidos = pedidoRepository.findByDataEntregaIsNull();
        pedidos.forEach(p -> System.out.println("Pedido número " + p.getId() + " - Sem data de entrega."));
    }

    private void buscarPorDataEntrega() {
        List<Pedido> pedidos = pedidoRepository.findByDataEntregaIsNotNull();
        pedidos.forEach(p -> System.out.println("Pedido número " + p.getId() + " - Data de entrega: " + p.getDataEntrega()));
    }

    private void buscarPorCategoriaPrecoAsc() {
        System.out.println("Digite a categoria a ser buscada: ");
        var categoria = leitura.nextLine();
        List<Produto> produtos = produtoRepository.findByCategoriaNomeOrderByPrecoAsc(categoria);
        produtos.forEach(p -> System.out.println(p.getNome() + "Preço: " + p.getPreco()));
    }

    private void buscarPorCategoriaPrecoDesc() {
        System.out.println("Digite a categoria a ser buscada: ");
        var categoria = leitura.nextLine();
        List<Produto> produtos = produtoRepository.findByCategoriaNomeOrderByPrecoDesc(categoria);
        produtos.forEach(p -> System.out.println(p.getNome() + "Preço: " + p.getPreco()));
    }

    private void contagemPorCategoria() {
        System.out.println("Digite a categoria a ser buscada: ");
        var categoria = leitura.nextLine();
        var contagem = produtoRepository.countByCategoriaNome(categoria);
        System.out.println(contagem + " produto(s) encontrados na categoria " + categoria);
    }

    private void contagemPorValorMaiorQue() {
        System.out.println("Contar produtos com preço maior que: ");
        var preco = leitura.nextDouble();
        var contagem = produtoRepository.countByPrecoGreaterThan(preco);
        System.out.println(contagem + " produto(s) encontrados com preço maior que R$" + preco);
    }

    private void buscarPorTermoComPrecoMenorQue() {
        System.out.println("Digite o termo a ser buscado: ");
        var termo = leitura.nextLine();
        System.out.println("Produtos com preço menor que: ");
        var preco = leitura.nextDouble();
        List<Produto> produtos = produtoRepository.findByPrecoLessThanOrNomeContaining(preco, termo);
        produtos.forEach(p -> System.out.println(p.getNome() + " - Preço: R$" + p.getPreco()));
    }

    private void buscarPorDataDepoisDe() {
        System.out.println("Buscar pedidos depois da data: (yyyy-mm-dd)");
        LocalDate data = LocalDate.parse(leitura.nextLine());
        List<Pedido> pedidos = pedidoRepository.findByDataAfter(data);
        pedidos.forEach(p -> System.out.println("Pedido " + p.getId() + " - Data: " + p.getData()));
    }

    private void buscarPorDataAntesDe() {
        System.out.println("Buscar pedidos antes da data: (yyyy-mm-dd)");
        LocalDate data = LocalDate.parse(leitura.nextLine());
        List<Pedido> pedidos = pedidoRepository.findByDataBefore(data);
        pedidos.forEach(p -> System.out.println("Pedido " + p.getId() + " - Data: " + p.getData()));
    }

    private void buscarPorDatasEntre() {
        System.out.println("Digite a data Inicial: (yyyy-mm-dd)");
        LocalDate dataInicial = LocalDate.parse(leitura.nextLine());
        System.out.println("Digite a data Final: (yyyy-mm-dd)");
        LocalDate dataFinal = LocalDate.parse(leitura.nextLine());
        List<Pedido> pedidos = pedidoRepository.findByDataBetween(dataInicial, dataFinal);
        pedidos.forEach(p -> System.out.println("Pedido " + p.getId() + " - data: " + p.getData()));

    }

    private void buscar3MaisCaros() {
        List<Produto> produtos = produtoRepository.findTop3ByOrderByPrecoDesc();
        produtos.forEach(p -> System.out.println(p.getNome() + " - Preço: R$" + p.getPreco()));
    }

    private void buscar5MaisBaratosPorCategoria() {
        System.out.println("Digite a categoria: ");
        var categoria = leitura.nextLine();
        List<Produto> produtos = produtoRepository.findTop5ByCategoriaNomeOrderByPrecoAsc(categoria);
        produtos.forEach(p -> System.out.println(p.getNome() + " - Preço: R$" + p.getPreco()));
    }

    public void executar() {
        // Criando categorias
        Categoria categoriaEletronicos = new Categoria(null, "Eletrônicos");
        Categoria categoriaLivros = new Categoria(null, "Livros");
        // Salvando categorias (cascateia produtos automaticamente, se configurado)
        categoriaRepository.saveAll(List.of(categoriaEletronicos, categoriaLivros));

        // Criando fornecedores
        Fornecedor fornecedorTech = new Fornecedor("Tech Supplier");
        Fornecedor fornecedorLivros = new Fornecedor("Livraria Global");
        fornecedorRepository.saveAll(List.of(fornecedorTech, fornecedorLivros));

        // Criando produtos e associando às categorias
        Produto produto1 = new Produto("Notebook", 3500.0, categoriaEletronicos, fornecedorTech);
        Produto produto2 = new Produto("Smartphone", 2500.0, categoriaEletronicos, fornecedorTech);
        Produto produto3 = new Produto("Livro de Java", 100.0, categoriaLivros, fornecedorLivros);
        Produto produto4 = new Produto("Livro de Spring Boot", 150.0, categoriaLivros, fornecedorLivros);
        produtoRepository.saveAll(List.of(produto1, produto2, produto3, produto4));

        // Criando pedidos e associando produtos
        Pedido pedido1 = new Pedido(LocalDate.now());
        pedido1.setProdutos(List.of(produto1, produto3));
        Pedido pedido2 = new Pedido(LocalDate.now().minusDays(1));
        pedido2.setProdutos(List.of(produto2));
        pedidoRepository.saveAll(List.of(pedido1, pedido2));

        // Testando consultas e verificando os relacionamentos
        System.out.println("Produtos na categoria Eletrônicos:");
        categoriaRepository.findById(1L).ifPresent(categoria ->
                categoria.getProdutos().forEach(produto ->
                        System.out.println(" - " + produto.getNome())
                )
        );

        System.out.println("\nPedidos e seus produtos:");
        pedidoRepository.findAll().forEach(pedido -> {
            System.out.println("Pedido " + pedido.getId() + ":");
            pedido.getProdutos().forEach(produto ->
                    System.out.println(" - " + produto.getNome())
            );
        });

        System.out.println("\nProdutos e seus fornecedores:");
        produtoRepository.findAll().forEach(produto ->
                System.out.println("Produto: " + produto.getNome() +
                        ", Fornecedor: " + produto.getFornecedor().getNome())
        );
    }
}
