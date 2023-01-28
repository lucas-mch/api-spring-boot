package com.attornatus.resources;

import com.attornatus.model.pessoa.Pessoa;
import com.attornatus.model.pessoa.PessoaService;
import com.attornatus.services.PessoaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/pessoa")
public class PessoaResource {

    private final PessoaServiceImp pessoaService;

    @Autowired
    public PessoaResource(PessoaServiceImp pessoaService) { this.pessoaService = pessoaService; }

    @RequestMapping(method = RequestMethod.GET)
    public List<Pessoa> getPessoas(){ return pessoaService.findAll(); }

    @RequestMapping(method =  RequestMethod.POST)
    public Pessoa Post(@RequestBody Pessoa pessoa)
    {
        return pessoaService.save(pessoa);
    }

}
