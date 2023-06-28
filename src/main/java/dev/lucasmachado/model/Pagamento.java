package dev.lucasmachado.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dev.lucasmachado.enterprise.entities.AbstractEntity;
import dev.lucasmachado.enterprise.enums.EstadoPagamento;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento extends AbstractEntity {

    private EstadoPagamento estado;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "i_pedidos", referencedColumnName = "pedidos")
    @MapsId
    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(Long id, EstadoPagamento estado, Pedido pedido) {
        super(id);
        this.estado = estado;
        this.pedido = pedido;
    }
}
