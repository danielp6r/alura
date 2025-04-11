package br.com.alura.gerenciador_pedidos.models;

import jakarta.persistence.*;

// 01 - Crie uma classe chamada Produto com os seguintes atributos: id (Long, chave primária)
// nome (String) preco (Double). Anote a classe com @Entity e mapeie o atributo id como chave primária com @Id.
// A classe deve ter um construtor e os getters.

// 02 - Modifique o exercício anterior para usar a anotação @GeneratedValue no campo id, com a estratégia
// de geração automática de identificadores (GenerationType.IDENTITY).

// 03 - Agora, iremos usar vários parâmetros da anotação @Column. Acrescente os seguintes requisitos à classe Produto:
// O atributo nome deve ser único e não nulo. O atributo preco deve ser armazenado em uma coluna chamada valor.

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nome;
    @Column(name = "valor")
    private Double preco;

    // Construtor padrão para JPA.
    public Produto() {

    }

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

}
