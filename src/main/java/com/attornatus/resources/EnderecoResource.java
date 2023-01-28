package com.attornatus.resources;

import com.attornatus.model.endereco.Endereco;
import com.attornatus.model.pessoa.Pessoa;
import com.attornatus.services.EnderecoServiceImp;
import com.attornatus.services.PessoaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/endereco")
public class EnderecoResource {

    private final EnderecoServiceImp enderecoService;

    @Autowired
    public EnderecoResource(EnderecoServiceImp enderecoService) { this.enderecoService = enderecoService; }

    @RequestMapping(method = RequestMethod.GET)
    public List<Endereco> getEnderecos(){ return enderecoService.findAll(); }

    @RequestMapping(method =  RequestMethod.POST)
    public Endereco Post(@RequestBody Endereco endereco)
    {
        return enderecoService.save(endereco);
    }
}
