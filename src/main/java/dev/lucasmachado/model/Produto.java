package dev.lucasmachado.model;

import dev.lucasmachado.enterprise.entities.AbstractEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produtos")
public class Produto extends AbstractEntity {

    private String nome;
    private Double preco;

    @ManyToMany
    @JoinTable(name = "PRODUTOS_CATEGORIAS",
               joinColumns = @JoinColumn(name = "i_produtos"),
               inverseJoinColumns = @JoinColumn(name = "i_categorias")
    )
    private List<Categoria> categorias = new ArrayList<>();

    public Produto() {
        super();
    }

    public Produto(Long id, String nome, Double preco) {
        super(id);
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }


}
