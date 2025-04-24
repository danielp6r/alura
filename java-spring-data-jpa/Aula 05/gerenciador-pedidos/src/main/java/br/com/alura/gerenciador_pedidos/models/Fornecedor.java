package br.com.alura.gerenciador_pedidos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Construtor Vazio para JPA
    public Fornecedor() {

    }

    public Fornecedor(String nome) {
        this.nome=nome;
    }

    public Long getId() {
        return  id;
    }

    public String getNome() {
        return nome;
    }

}
