package dev.lucasmachado.resources;

import dev.lucasmachado.model.Categoria;
import dev.lucasmachado.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Categoria categoriaToFind = categoriaService.findById(id);
        return ResponseEntity.ok().body(categoriaToFind);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public  ResponseEntity<?> listarCategorias() {
        List<Categoria> categorias = categoriaService.listarCategorias();
        return ResponseEntity.ok().body(categorias);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Categoria categoria) {
        categoria.setId(null);
        categoria = categoriaService.save(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody Categoria categoria) {
        categoria.setId(id);
        categoria = categoriaService.update(categoria);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public  ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
