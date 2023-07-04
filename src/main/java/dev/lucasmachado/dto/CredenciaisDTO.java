package dev.lucasmachado.dto;

import dev.lucasmachado.enterprise.entities.AbstractDTO;

public class CredenciaisDTO extends AbstractDTO {

    private String username;

    private String password;

    public CredenciaisDTO() {
    }

    public CredenciaisDTO(Long id, String username, String password) {
        super(id);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
