package dev.lucasmachado.enterprise.enums;

import org.hibernate.ObjectNotFoundException;

public enum EstadoPagamento {
    PENDENTE(1,"PAGAMENTO_PENDENTE"),
    QUITADO(2,"PAGAMENTO_QUITADO"),
    CANCELADO(3,"PAGAMENTO_CANCELADO");

    private int codigo;
    private String descricao;

    EstadoPagamento(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoPagamento toEnum(Integer codigo) {
        if(codigo == null) {
            throw new ObjectNotFoundException("Tipo cliente não encontrado", EstadoPagamento.class.getName());
        }
        for(EstadoPagamento estadoPagamento : EstadoPagamento.values()){
            if(codigo.equals(estadoPagamento.getCodigo())){
                return estadoPagamento;
            }
        }
        throw new IllegalArgumentException("Código inválido " + codigo);
    }
}
