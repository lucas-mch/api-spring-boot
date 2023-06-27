package dev.lucasmachado.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.lucasmachado.enterprise.entities.AbstractEntity;
import dev.lucasmachado.enterprise.enums.TipoCliente;
import dev.lucasmachado.model.localidades.Endereco;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "clientes")
public class Cliente extends AbstractEntity implements Cloneable  {

    private String nome;
    private String email;
    private String cpfOuCnpj;
    private Integer tipoCliente;
    @OneToMany(mappedBy="cliente")
    @JsonIgnore
    private List<Endereco> enderecos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "telefones")
    private Set<String> telefones = new HashSet<>();

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public TipoCliente getTipoCliente() {
        return TipoCliente.toEnum(this.tipoCliente);
    }

    public void setTipoCliente(Integer tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
