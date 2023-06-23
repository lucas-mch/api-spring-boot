package dev.lucasmachado.resources;

import dev.lucasmachado.model.localidades.Cidade;
import dev.lucasmachado.services.localidades.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin
@RequestMapping("/cidades")
public class CidadeResource {

    @Autowired
    private CidadeService cidadeService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insertCidade(@RequestBody Cidade cidade) {
        cidade = cidadeService.save(cidade);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(cidade.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
