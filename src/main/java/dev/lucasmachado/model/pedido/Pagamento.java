package dev.lucasmachado.model.pedido;

import dev.lucasmachado.enterprise.entities.AbstractEntity;
import dev.lucasmachado.enterprise.enums.EstadoPagamento;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento extends AbstractEntity {

    private EstadoPagamento estado;

    @OneToOne
    @JoinColumn(name = "i_pedidos", referencedColumnName = "pedidos")
    @MapsId
    private Pedido pedido;

}
