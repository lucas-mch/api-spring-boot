package dev.lucasmachado.resources;

import dev.lucasmachado.model.Categoria;
import dev.lucasmachado.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> listarCategorias() {
        return categoriaService.listarCategorias();
    }

}
