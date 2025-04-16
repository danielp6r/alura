package br.com.alura.gerenciador_pedidos.repository;

import br.com.alura.gerenciador_pedidos.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByDataEntregaIsNull();

    List<Pedido> findByDataEntregaIsNotNull();

    List<Pedido> findByDataAfter(LocalDate data);

    List<Pedido> findByDataBefore(LocalDate data);

    List<Pedido> findByDataBetween(LocalDate dataInicio, LocalDate dataFim);
}
