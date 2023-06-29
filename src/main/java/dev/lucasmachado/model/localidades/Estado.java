package dev.lucasmachado.model.localidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.lucasmachado.enterprise.entities.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estados")
public class Estado extends AbstractEntity {

    private String nome;
    private String sigla;

    @OneToMany(mappedBy = "estado")
    @JsonIgnore
    private List<Cidade> cidades = new ArrayList<>();

    public Estado() {
    }

    public Estado(Long id, String nome, String sigla) {
        super(id);
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }
}
