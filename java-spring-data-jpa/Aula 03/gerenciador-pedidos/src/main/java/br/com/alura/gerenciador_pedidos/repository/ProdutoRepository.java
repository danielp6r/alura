package br.com.alura.gerenciador_pedidos.repository;

import br.com.alura.gerenciador_pedidos.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
