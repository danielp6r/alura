package br.com.alura.gerenciador_pedidos.models;

// 04 - Crie uma classe Categoria com os atributos: id (Long, chave primária) nome (String) A classe deve
//ter um construtor e os getters. Transforme a classe em entidade.

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Categoria {
    @Id
    private Long id;
    private String nome;

    //Construtor vazio para JPA.
    public Categoria() {

    }

    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
