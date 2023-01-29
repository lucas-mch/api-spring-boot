package com.attornatus.resources;

import com.attornatus.model.pessoa.Pessoa;
import com.attornatus.services.PessoaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/pessoa")
public class PessoaResource {

    private final PessoaServiceImp pessoaService;

    @Autowired
    public PessoaResource(PessoaServiceImp pessoaService) {
        this.pessoaService = pessoaService;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaService.findById(id);
        return ResponseEntity.ok().body(pessoa);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Pessoa pessoa) {
        pessoa = pessoaService.save(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Pessoa pessoa, @PathVariable Long id) {
        pessoa.setId(id);
        pessoa = pessoaService.update(pessoa);
        return ResponseEntity.noContent().build();
    }


}
