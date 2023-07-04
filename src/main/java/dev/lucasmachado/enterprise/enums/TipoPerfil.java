package dev.lucasmachado.enterprise.enums;

import org.hibernate.ObjectNotFoundException;

public enum TipoPerfil {
    ADMIN(1,"ROLE_ADMIN"),
    CLIENTE(2, "ROLE_CLIENTE");

    private int codigo;
    private String descricao;

    TipoPerfil(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoPerfil toEnum(Integer codigo) {
        if(codigo == null) {
            throw new ObjectNotFoundException("Tipo perfil não encontrado", TipoPerfil.class.getName());
        }
        for(TipoPerfil tipoPerfil : TipoPerfil.values()){
            if(codigo.equals(tipoPerfil.getCodigo())){
                return tipoPerfil;
            }
        }
        throw new IllegalArgumentException("Código inválido " + codigo);
    }



}
