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

/* 01 - Relacione Categoria e Produto usando @OneToMany, permitindo que uma categoria tenha vários produtos. Assim,
estamos definindo um relacionamento 1:n do lado da categoria. Aqui, ao salvarmos uma categoria, queremos salvar seus
produtos automaticamente também. Faça a configuração necessária para atender a esse requisito.

02 - Repare que o relacionamento criado é unidirecional: somente a classe Categoria o enxerga. Podemos deixá-lo
bidirecional, configurando um relacionamento do tipo n:1 do lado do Produto, com a anotação @ManyToOne.

03 - Na sua classe Principal, você pode criar várias categorias e produtos diferentes e fazer as associações
correspondentes.  Extra (pra quem quer mergulhar mesmo): Agora, iremos trabalhar com um novo tipo de relacionamento:
o relacionamento muitos para muitos, que usa a anotação @ManyToMany.

04 - Crie uma nova classe Fornecedor, com os atributos id e nome. Transforme a classe em entidade.

05 - Configure um relacionamento unidirecional entre Fornecedor e Produto. O relacionamento deve ser mapeado na classe
Produto. Logo, é nessa classe que deverá ter a anotação de relacionamento. Qual é a melhor anotação para usarmos neste caso?

06 - Faça as devidas associações entre Fornecedor e Produto na sua classe Principal.

*/

@Component
public class Principal {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public void principal() {
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
