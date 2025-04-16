package br.com.alura.gerenciador_pedidos.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "pedido_produto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;

    private LocalDate data;

    private LocalDate dataEntrega;

    // Construtor padrão para JPA
    public Pedido() {

    }

    public Pedido(LocalDate data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setProdutos(List<Produto> produto1) {
        this.produtos = produto1;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }
}
