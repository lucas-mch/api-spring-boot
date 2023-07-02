package dev.lucasmachado.dto;

import dev.lucasmachado.enterprise.entities.AbstractDTO;
import dev.lucasmachado.model.Cliente;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class ClienteDTO extends AbstractDTO {
    @NotEmpty(message = "Preenchimento obrigatorio")
    @Length(min=5, max = 120, message = "O tamanho deve ser entre 5 a 120 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatorio")
    @Email(message = "Email invalido")
    private String email;

    public ClienteDTO(Long id) {
        super(id);
    }

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        super(cliente.getId());
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
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
}
