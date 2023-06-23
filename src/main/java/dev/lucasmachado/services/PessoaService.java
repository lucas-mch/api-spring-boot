package dev.lucasmachado.services;

import dev.lucasmachado.model.Pessoa;
import dev.lucasmachado.repositories.EnderecoRepository;
import dev.lucasmachado.repositories.PessoaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Pessoa save(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }
    public Pessoa update(Pessoa pessoa) {
        return save(pessoa);
    }
    public Pessoa findById(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.orElseThrow (
                ()-> new ObjectNotFoundException("Nenhuma pessoa encontrada com o id : " + id, Pessoa.class.getName())
        );
    }
    public List<Pessoa> findAll(){ return pessoaRepository.findAll(); }

}
