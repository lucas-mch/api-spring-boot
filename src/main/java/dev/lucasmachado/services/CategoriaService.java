package dev.lucasmachado.services;

import dev.lucasmachado.dto.CategoriaDTO;
import dev.lucasmachado.enterprise.exceptions.DataIntegrityException;
import dev.lucasmachado.model.Categoria;
import dev.lucasmachado.repositories.CategoriaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> listarCategorias() throws EntityNotFoundException {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream().map(CategoriaDTO::new).collect(Collectors.toList());
    }

    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException(Categoria.class, "Categoria com o id : " + id + " nao encontrada.")
        );
    }

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Categoria categoria) {
        findById(categoria.getId());
        return categoriaRepository.saveAndFlush(categoria);
    }

    public void delete(Long id) {
        if (categoriaRepository.existsById(id)) {
            try {
                categoriaRepository.deleteById(id);
            } catch (DataIntegrityViolationException e) {
                throw new DataIntegrityException("Existem produtos atrelados a categoria id: " + id);
            }
        } else {
            throw new ObjectNotFoundException(Categoria.class, "Categoria com o id : " + id + " nao encontrada");
        }
    }

    public Page<CategoriaDTO> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        Sort sort = Sort.by(Sort.Direction.fromString(direction), orderBy);
        PageRequest pageRequest = PageRequest.of(page,linesPerPage, sort);
        return categoriaRepository.findAll(pageRequest).map(CategoriaDTO::new);
    }


}
