package com.attornatus.model.pessoa;

import com.attornatus.enterprise.AbstractEntity;
import com.attornatus.model.endereco.Endereco;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Pessoa extends AbstractEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Date dataNascimento;
    @OneToMany(mappedBy="pessoa")
    private List<Endereco> enderecos = new ArrayList<>();

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return id.equals(pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static final class Builder  {

        protected Pessoa entity;

        private Builder(Pessoa entity) {
            this.entity = entity;
        }

        public static Builder create() {
            return new Builder(new Pessoa());
        }

        public Builder id(Long id) {
            entity.id = id;
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
