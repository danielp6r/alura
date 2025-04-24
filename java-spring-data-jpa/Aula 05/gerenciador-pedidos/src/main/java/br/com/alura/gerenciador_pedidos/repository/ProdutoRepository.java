package br.com.alura.gerenciador_pedidos.repository;

import br.com.alura.gerenciador_pedidos.models.Categoria;
import br.com.alura.gerenciador_pedidos.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Query("SELECT p FROM Produto p WHERE p.preco > :preco")
    List<Produto> buscarPorPrecoMaior(double preco);

    @Query("SELECT p FROM Produto p ORDER BY p.preco ASC")
    List<Produto> buscarPorPrecoCrescente();

    @Query("SELECT p FROM Produto p ORDER BY p.preco DESC")
    List<Produto> buscarPorPrecoDecrescente();

    @Query("SELECT p FROM Produto p WHERE p.nome LIKE :letra%")
    List<Produto> buscarPorLetraInicial(String letra);

    @Query("SELECT AVG(p.preco) FROM Produto p")
    Double CalcularMediaPrecos();

    @Query("SELECT MAX(p.preco) FROM Produto p WHERE p.categoria.nome = :categoria")
    Double buscarPrecoMaxPorCategoria(String categoria);

    @Query("SELECT c.nome, COUNT(p) FROM Produto p JOIN p.categoria c GROUP BY c.nome")
    List<Object[]> contarProdutosPorCategoria();

    @Query("SELECT c.nome, COUNT(p) FROM Produto p JOIN p.categoria c GROUP BY c.nome HAVING COUNT(p) >= :quantidade")
    List<Object[]> categoriasComMaisDe(@Param("quantidade") long quantidade);

    @Query("SELECT p FROM Produto p WHERE (:nome IS NULL OR p.nome = :nome) AND (:categoria IS NULL OR p.categoria.nome = :categoria)")
    List<Produto> buscarProdutosFiltrados(@Param("nome") String nome, @Param("categoria") String categoria);

    @Query(value = "SELECT * FROM produto ORDER BY valor DESC LIMIT 5", nativeQuery = true)
    List<Produto> buscarTop5ProdutosMaisCaros();


}
