package br.com.alura.gerenciador_pedidos.repository;

import br.com.alura.gerenciador_pedidos.models.Pedido;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT p FROM Pedido p WHERE p.data BETWEEN :dataInicial AND :dataFinal")
    List<Pedido> buscarEntreAsDatas(LocalDate dataInicial, LocalDate dataFinal);

}
