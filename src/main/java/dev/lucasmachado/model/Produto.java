package dev.lucasmachado.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.lucasmachado.enterprise.entities.AbstractEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "produtos")
public class Produto extends AbstractEntity {

    private String nome;
    private Double preco;

    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "PRODUTOS_CATEGORIAS",
               joinColumns = @JoinColumn(name = "i_produtos"),
               inverseJoinColumns = @JoinColumn(name = "i_categorias")
    )
    private List<Categoria> categorias = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> itens = new HashSet<>();

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
