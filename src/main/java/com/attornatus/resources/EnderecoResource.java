package com.attornatus.resources;

import com.attornatus.model.Endereco;
import com.attornatus.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/endereco")
public class EnderecoResource {

    @Autowired
    private EnderecoService enderecoService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insertEndereco(@RequestBody Endereco endereco, @RequestParam Long pessoaId) {
        endereco = enderecoService.saveToPessoa(endereco, pessoaId);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAllEnderecos(@RequestParam Long pessoaId) {
        List<Endereco> list = enderecoService.findAllFromPessoa(pessoaId);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/principal",method = RequestMethod.GET)
    public Endereco setEnderecoPrincipal(@RequestParam Long pessoaId, @RequestParam Long enderecoId) {
        return enderecoService.setEnderecoPrincipal(pessoaId, enderecoId);
    }

}
