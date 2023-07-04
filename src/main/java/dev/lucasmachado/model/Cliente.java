package dev.lucasmachado.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import dev.lucasmachado.enterprise.entities.AbstractEntity;
import dev.lucasmachado.enterprise.enums.TipoCliente;
import dev.lucasmachado.enterprise.enums.TipoPerfil;
import dev.lucasmachado.model.localidades.Endereco;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "clientes")
public class Cliente extends AbstractEntity implements Cloneable {

    @NotNull
    private String nome;
    @NotNull
    private String email;
    @Column(name = "cliente_cpf_cnpj")
    private String cpfOuCnpj;
    @Column(name = "tipo_cliente")
    private Integer tipoCliente;
    @JsonIgnore
    private String senha;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();
    @ElementCollection
    @CollectionTable(name = "telefones",
            joinColumns = @JoinColumn(name = "i_clientes", referencedColumnName = "id")
    )
    @Column(name = "nome")
    private Set<String> telefones = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "cliente_perfil")
    private Set<Integer> perfis = new HashSet<>();

    public Cliente() {
        addPerfis(TipoPerfil.CLIENTE);
    }

    public Cliente(Long id, String nome, String email, String cpfOuCnpj, Integer tipoCliente) {
        super(id);
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipoCliente = tipoCliente;
        addPerfis(TipoPerfil.CLIENTE);
    }

    public Cliente(Long id, String nome, String email, String cpfOuCnpj, Integer tipoCliente,String senha) {
        super(id);
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipoCliente = tipoCliente;
        this.senha = senha;
        addPerfis(TipoPerfil.CLIENTE);
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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

    public Set<TipoPerfil> getPerfis() {
        return perfis.stream().map(TipoPerfil::toEnum).collect(Collectors.toSet());
    }

    public void addPerfis(TipoPerfil tipoPerfil) {
        this.perfis.add(tipoPerfil.getCodigo());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
