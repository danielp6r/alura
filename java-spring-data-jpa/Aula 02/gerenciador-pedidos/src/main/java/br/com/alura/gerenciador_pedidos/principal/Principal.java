package br.com.alura.gerenciador_pedidos.principal;


/* 01 - Crie uma classe chamada Produto com os seguintes atributos: id (Long, chave primária)
nome (String) preco (Double). Anote a classe com @Entity e mapeie o atributo id como chave primária com @Id.
A classe deve ter um construtor e os getters.

02 - Modifique o exercício anterior para usar a anotação @GeneratedValue no campo id, com a estratégia
de geração automática de identificadores (GenerationType.IDENTITY).

03 - Agora, iremos usar vários parâmetros da anotação @Column. Acrescente os seguintes requisitos à classe Produto:
O atributo nome deve ser único e não nulo. O atributo preco deve ser armazenado em uma coluna chamada valor.

04 - Crie uma classe Categoria com os atributos: id (Long, chave primária) nome (String) A classe deve
ter um construtor e os getters. Transforme a classe em entidade.

05 - Crie uma classe Pedido com os seguintes atributos: id (Long, chave primária) data (LocalDate)
A classe deve ter um construtor e os getters. Transforme a classe em entidade.

06 - Execute a aplicação e veja se todas as tabelas foram criadas corretamente.
Quando estiver tudo certo, podemos ir para o próximo passo.

07 - Agora, iremos querer salvar dados no banco. Por isso, você deve criar vários repositórios diferentes:
um para Pedido, outro para Produto e outro para Categoria.

08 - Para finalizar, crie um objeto de cada classe e use os repositórios para salvar os dados. Tudo certo para executar
os dados? Provavelmente faltará um passo bem importante. Tente se lembrar do que acontece na aula e fazer este último
passo. Você também pode analisar o log de erro :) Caso ainda precise de ajuda, na “Opinião do instrutor” terá uma dica
para te ajudar.

*/

import br.com.alura.gerenciador_pedidos.models.Categoria;
import br.com.alura.gerenciador_pedidos.models.Pedido;
import br.com.alura.gerenciador_pedidos.models.Produto;
import br.com.alura.gerenciador_pedidos.repository.CategoriaRepository;
import br.com.alura.gerenciador_pedidos.repository.PedidoRepository;
import br.com.alura.gerenciador_pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Principal {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public void executar() {
        Produto produto = new Produto("Monitor de Áudio", 700.00);
        Categoria categoria = new Categoria(1L, "Áudio");
        Pedido pedido = new Pedido(1L, LocalDate.now());

        produtoRepository.save(produto);
        categoriaRepository.save(categoria);
        pedidoRepository.save(pedido);

        System.out.println("Dados salvos com sucesso!");
    }
}
