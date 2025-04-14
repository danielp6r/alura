package br.com.alura.gerenciador_pedidos;

import br.com.alura.gerenciador_pedidos.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorPedidosApplication  implements CommandLineRunner {

	@Autowired
	private Principal principal; // Aqui o Spring vai injetar a dependência

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorPedidosApplication.class, args);
	}

	// O bd gerenciador-pedidos deve existir.
	// Caso já existam, as seguintes tabelas devem ser apagadas antes de executar:
	// drop table pedido_produto;
	// drop table pedido;
	// drop table produto;
	// drop table fornecedor;
	// drop table categoria;
	@Override
	public void run(String... args) throws Exception {
		principal.principal();
	}
}
