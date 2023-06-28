package dev.lucasmachado.model.pedido;

import dev.lucasmachado.enterprise.entities.AbstractEntity;
import dev.lucasmachado.model.Cliente;
import dev.lucasmachado.model.localidades.Endereco;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pedidos")
public class Pedido extends AbstractEntity {

    private Date instante;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;
    @ManyToOne
    @JoinColumn(name = "i_clientes")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "i_enderecos_entregas")
    private Endereco enderecoEntrega;

    public Pedido() {
    }

    public Date getInstante() {
        return instante;
    }

    public void setInstante(Date instante) {
        this.instante = instante;
    }

}
