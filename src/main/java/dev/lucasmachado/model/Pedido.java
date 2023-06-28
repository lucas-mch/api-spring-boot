package dev.lucasmachado.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.lucasmachado.enterprise.entities.AbstractEntity;
import dev.lucasmachado.model.Cliente;
import dev.lucasmachado.model.ItemPedido;
import dev.lucasmachado.model.Pagamento;
import dev.lucasmachado.model.localidades.Endereco;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pedidos")
public class Pedido extends AbstractEntity {

    private Date instante;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "i_clientes")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "i_enderecos_entregas")
    private Endereco enderecoEntrega;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    public Pedido() {
    }

    public Date getInstante() {
        return instante;
    }

    public void setInstante(Date instante) {
        this.instante = instante;
    }

}
