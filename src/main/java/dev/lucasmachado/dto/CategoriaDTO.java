package dev.lucasmachado.dto;

import dev.lucasmachado.enterprise.entities.AbstractDTO;
import dev.lucasmachado.model.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class CategoriaDTO extends AbstractDTO {

    @NotEmpty(message = "Preenchimento obrigatorio")
    @Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 a 80 caracteres.")
    private String nome;

    public CategoriaDTO() {
    }
    public CategoriaDTO(Categoria categoria) {
        super(categoria.getId());
        this.nome = categoria.getNome();
    }
    public CategoriaDTO(Long id, String nome) {
        super(id);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
