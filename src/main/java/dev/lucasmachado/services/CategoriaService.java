package dev.lucasmachado.services;

import dev.lucasmachado.model.Categoria;
import dev.lucasmachado.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarCategorias() throws EntityNotFoundException {
        return categoriaRepository.findAll();
    }

}
