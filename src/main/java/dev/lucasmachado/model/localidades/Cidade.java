package dev.lucasmachado.model.localidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.lucasmachado.enterprise.entities.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cidades")
public class Cidade extends AbstractEntity {

    private String nome;

    @ManyToOne
    @JoinColumn(name = "i_estados")
    private Estado estado;

    @OneToMany(mappedBy="cidade")
    @JsonIgnore
    private List<Endereco> enderecos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cidade() {
    }

}
