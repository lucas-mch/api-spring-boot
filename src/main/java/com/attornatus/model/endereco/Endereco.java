package com.attornatus.model.endereco;

import com.attornatus.enterprise.AbstractEntity;
import com.attornatus.model.pessoa.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Endereco extends AbstractEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private Integer CEP;
    private Integer numero;
    private String cidade;
    private Boolean isPrincipal = Boolean.FALSE;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="i_pessoa")
    private Pessoa pessoa;

    public Endereco() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getCEP() {
        return CEP;
    }

    public void setCEP(Integer CEP) {
        this.CEP = CEP;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Boolean getPrincipal() { return isPrincipal; }

    public void setPrincipal(Boolean principal) { isPrincipal = principal; }

    public Pessoa getPessoa() { return pessoa; }

    public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return id.equals(endereco.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static final class Builder  {

        protected Endereco entity;

        private Builder(Endereco entity) {
            this.entity = entity;
        }

        public static Builder create() {
            return new Builder(new Endereco());
        }

        public Builder id(Long id) {
            entity.id = id;
            return this;
        }
        public Builder logradouro(String logradouro) {
            entity.logradouro = logradouro;
            return this;
        }
        public Builder CEP(Integer CEP) {
            entity.CEP = CEP;
            return this;
        }
        public Builder numero(Integer numero) {
            entity.numero = numero;
            return this;
        }
        public Builder cidade(String cidade) {
            entity.cidade = cidade;
            return this;
        }
        public Builder isPrincipal(Boolean isPrincipal) {
            entity.isPrincipal = isPrincipal;
            return this;
        }
        public Endereco build(){
            return entity;
        }



    }
}
