package dev.lucasmachado.enterprise.entities;

import java.io.Serializable;

public abstract class AbstractDTO implements Serializable {

    private Long id;

    public AbstractDTO(Long id) {
        this.id = id;
    }

    public AbstractDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
