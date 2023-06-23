package dev.lucasmachado.resources;

import dev.lucasmachado.model.Categoria;
import dev.lucasmachado.model.localidades.Estado;
import dev.lucasmachado.services.localidades.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/estados")
public class EstadoResource {

    @Autowired
    private EstadoService estadoService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insertEstado(@RequestBody Estado estado) {
        estado = estadoService.save(estado);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(estado.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Estado> listarEstados() {
        return estadoService.listEstados();
    }

}
