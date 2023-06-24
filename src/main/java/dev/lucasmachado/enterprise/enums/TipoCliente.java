package dev.lucasmachado.enterprise.enums;

import org.hibernate.ObjectNotFoundException;

public enum TipoCliente {

    PESSOA_FISICA(1,"Pessoa fisica"),
    PESSOA_JURIDICA(2, "Pessoa juridica");

    private int codigo;
    private String descricao;

    TipoCliente(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente toEnum(Integer codigo) {
        if(codigo == null) {
            throw new ObjectNotFoundException("Tipo cliente não encontrado", TipoCliente.class.getName());
        }
        for(TipoCliente tipoCliente : TipoCliente.values()){
            if(codigo.equals(tipoCliente.getCodigo())){
                return tipoCliente;
            }
        }
        throw new IllegalArgumentException("Código inválido " + codigo);
    }

}
