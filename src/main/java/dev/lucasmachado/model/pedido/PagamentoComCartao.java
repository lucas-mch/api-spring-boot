package dev.lucasmachado.model.pedido;

import javax.persistence.Entity;

@Entity
public class PagamentoComCartao extends Pagamento{
    private Integer numeroDeParcelas;

    public PagamentoComCartao() {
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }

}
