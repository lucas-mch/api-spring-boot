package dev.lucasmachado.model.localidades;

import dev.lucasmachado.enterprise.entities.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "estados")
public class Estado extends AbstractEntity {

    private String nome;
    private String sigla;

    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades;

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

}
