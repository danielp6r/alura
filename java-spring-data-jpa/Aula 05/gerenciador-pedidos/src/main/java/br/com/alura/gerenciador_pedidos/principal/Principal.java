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
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/* Decidir em qual dos repositórios essa busca melhor se encaixa, e criar a derived query correspondente.

01 - Crie uma consulta que retorne os produtos com preço maior que um valor

02 - Crie uma consulta que retorne os produtos ordenados pelo preço crescente.

03 - Crie uma consulta que retorne os produtos ordenados pelo preço decrescente.

04 - Crie uma consulta que retorne os produtos que comecem com uma letra específica.

05 - Crie uma consulta que retorne os pedidos feitos entre duas datas.

06 - Crie uma consulta que retorne a média de preços dos produtos.

07 - Crie uma consulta que retorne o preço máximo de um produto em uma categoria

08 - Crie uma consulta para contar o número de produtos por categoria.

09 - Crie uma consulta para filtrar categorias com mais de 10 produtos.

10 - Crie uma consulta para retornar os produtos filtrados por nome ou por categoria.

11 - Crie uma consulta nativa para buscar os cinco produtos mais caros
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
                
                1 - Retorne os produtos com preço maior que um valor
                2 - Retorne os produtos ordenados pelo preço crescente.
                3 - Retorne os produtos ordenados pelo preço decrescente.
                4 - Retorne os produtos que comecem com uma letra específica.
                5 - Retorne os pedidos feitos entre duas datas.
                6 - Retorne a média de preços dos produtos.
                7 - Retorne o preço máximo de um produto em uma categoria
                8 - Contar o número de produtos por categoria.
                9 - Filtrar categorias com mais de 10 produtos.
                10 - Retornar os produtos filtrados por nome ou por categoria.
                11 - Consulta nativa para buscar os cinco produtos mais caros
               
                0 - Sair                                 
                """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarPorPrecoMaior();
                    break;
                case 2:
                    buscarPorPrecoCrescente();
                    break;
                case 3:
                    buscarPorPrecoDecrescente();
                    break;
                case 4:
                    buscarPorLetraInicial();
                    break;
                case 5:
                    buscarEntreAsDatas();
                    break;
                case 6:
                    CalcularMediaPrecos();
                    break;
                case 7:
                    buscarPrecoMaxPorCategoria();
                    break;
                case 8:
                    contarProdutosPorCategoria();
                    break;
                case 9:
                    categoriasComMaisDe();
                    break;
                case 10:
                    buscarProdutosFiltrados();
                    break;
                case 11:
                    buscarTop5ProdutosMaisCaros();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

    }

    private void buscarTop5ProdutosMaisCaros() {
        List<Produto> produtos = produtoRepository.buscarTop5ProdutosMaisCaros();

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            produtos.forEach(p -> System.out.println("Produto: " + p.getNome() + ", Preço: " + p.getPreco()));
        }
    }

    private void buscarProdutosFiltrados() {
        System.out.println("Digite o nome do produto (deixe vazio para ignorar):");
        String nome = leitura.nextLine();

        System.out.println("Digite a categoria do produto (deixe vazio para ignorar):");
        String categoria = leitura.nextLine();

        // Chama o método de busca filtrada no repositório
        List<Produto> produtos = produtoRepository.buscarProdutosFiltrados(
                nome.isEmpty() ? null : nome,  // Se nome estiver vazio, passa null
                categoria.isEmpty() ? null : categoria  // Se categoria estiver vazia, passa null
        );

        // Exibe os resultados
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            produtos.forEach(p -> System.out.println("Produto: " + p.getNome() + ", Categoria: " + p.getCategoria().getNome()));
        }
    }

    private void categoriasComMaisDe() {
        System.out.println("Digite o número mínimo de produtos:");
        long quantidade = Long.parseLong(leitura.nextLine());  // Recebe o número de produtos (X)

        List<Object[]> lista = produtoRepository.categoriasComMaisDe(quantidade);  // Chama o método do repositório

        // Exibe as categorias que têm "quantidade" ou mais produtos
        lista.forEach(obj -> {
            System.out.println("Categoria: " + obj[0] + " - Quantidade de produtos: " + obj[1]);
        });
    }

    private void contarProdutosPorCategoria() {
        var lista = produtoRepository.contarProdutosPorCategoria();
        for (Object[] obj : lista) {
            System.out.println("Categoria: " + obj[0] + " - Quantidade de produtos: " + obj[1]);
        }
    }

    private void buscarPrecoMaxPorCategoria() {
        System.out.println("Digite a categoria:");
        var categoriaEscolhida = leitura.nextLine();
        Double precoMax = produtoRepository.buscarPrecoMaxPorCategoria(categoriaEscolhida);
        if (precoMax != null) {
            System.out.println("Preço máximo na categoria " + categoriaEscolhida + ": R$" + precoMax);
        } else {
            System.out.println("Nenhum preço encontrado para a categoria " + categoriaEscolhida);
        }
    }

    private void CalcularMediaPrecos() {
        var media = produtoRepository.CalcularMediaPrecos();
        System.out.println("R$" + media);
    }

    private void buscarEntreAsDatas() {
        System.out.println("Digite a data inicial (yyyy-MM-dd):");
        LocalDate dataInicial = LocalDate.parse(leitura.nextLine());
        System.out.println("Digite a data final (yyyy-MM-dd):");
        LocalDate dataFinal = LocalDate.parse(leitura.nextLine());
        List<Pedido> pedidosEncontrados = pedidoRepository.buscarEntreAsDatas(dataInicial, dataFinal);
        pedidosEncontrados.forEach(p -> System.out.println("Pedido número " + p.getId() + " - Data: " + p.getData()));
    }

    private void buscarPorLetraInicial() {
        System.out.println("Digite a letra inicial:");
        var letra = leitura.nextLine();
        List<Produto> produtosEncontrados = produtoRepository.buscarPorLetraInicial(letra);
        produtosEncontrados.forEach(produto -> System.out.println(produto.getNome()));
    }

    private void buscarPorPrecoDecrescente() {
        List<Produto> produtosEncontrados = produtoRepository.buscarPorPrecoDecrescente();
        produtosEncontrados.forEach(System.out::println);
    }

    private void buscarPorPrecoCrescente() {
        List<Produto> produtosEncontrados = produtoRepository.buscarPorPrecoCrescente();
        produtosEncontrados.forEach(System.out::println);
    }

    private void buscarPorPrecoMaior() {
        System.out.println("Produtos com valor maior que:");
        var valor = leitura.nextDouble();
        List<Produto> produtosEncontrados = produtoRepository.buscarPorPrecoMaior(valor);
        produtosEncontrados.forEach(System.out::println);
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
