package dev.lucasmachado.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.lucasmachado.enterprise.entities.AbstractEntity;

import javax.persistence.Column;

public class User extends AbstractEntity {

    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String cpf;
    @JsonIgnore
    private String password;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


}
