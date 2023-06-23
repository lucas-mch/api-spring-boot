package dev.lucasmachado.model.localidades;

import dev.lucasmachado.enterprise.entities.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "cidades")
public class Cidade extends AbstractEntity {

    private String nome;

    @ManyToOne
    @JoinColumn(name = "i_estados")
    private Estado estado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade() {
    }

}
