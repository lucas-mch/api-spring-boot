package dev.lucasmachado.model.localidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.lucasmachado.enterprise.entities.AbstractEntity;
import dev.lucasmachado.model.Cliente;
import dev.lucasmachado.model.Pessoa;

import javax.persistence.*;

@Entity
@Table(name = "enderecos")
public class Endereco extends AbstractEntity {
    private String logradouro;
    private Integer CEP;
    private Integer numero;
    @ManyToOne
    @JoinColumn(name="i_cidades", referencedColumnName = "id")
    private Cidade cidade;
    @Column(name = "fl_principal")
    private Boolean isPrincipal = Boolean.FALSE;
    @ManyToOne
    @JoinColumn(name="i_pessoas", referencedColumnName = "id")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name="i_clientes", referencedColumnName = "id")
    @JsonBackReference
    private Cliente cliente;

    public Endereco() {
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

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Boolean getPrincipal() { return isPrincipal; }

    public void setPrincipal(Boolean principal) { isPrincipal = principal; }

    public Pessoa getPessoa() { return pessoa; }

    public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }

    public static final class Builder  {

        protected Endereco entity;

        private Builder(Endereco entity) {
            this.entity = entity;
        }

        public static Builder create() {
            return new Builder(new Endereco());
        }

        public Builder id(Long id) {
            entity.setId(id);
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
        public Builder cidade(Cidade cidade) {
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
