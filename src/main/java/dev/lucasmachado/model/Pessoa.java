package dev.lucasmachado.model;

import dev.lucasmachado.enterprise.entities.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.lucasmachado.model.localidades.Endereco;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pessoas")
public class Pessoa extends AbstractEntity {
    @Column(name = "nome")
    private String nome;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name="data_nascimento")
    private Date dataNascimento;
    @OneToMany(mappedBy="pessoa")
    @JsonIgnore
    private List<Endereco> enderecos = new ArrayList<>();

    public Pessoa() {
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Endereco> getEnderecos() { return enderecos; }

    public void addEndereco(Endereco endereco){ enderecos.add(endereco); }

    public static final class Builder  {

        protected Pessoa entity;

        private Builder(Pessoa entity) {
            this.entity = entity;
        }

        public static Builder create() {
            return new Builder(new Pessoa());
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }

        public Builder nome(String nome) {
            entity.nome = nome;
            return this;
        }

        public Builder dataNascimento(Date dataNascimento) {
            entity.dataNascimento = dataNascimento;
            return this;
        }

        public Pessoa build(){
            return entity;
        }

    }

}
