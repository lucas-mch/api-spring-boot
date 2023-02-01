package com.attornatus.services;

import com.attornatus.model.Endereco;
import com.attornatus.model.Pessoa;
import com.attornatus.repositories.EnderecoRepository;
import com.attornatus.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Endereco save(Endereco endereco){ return enderecoRepository.save(endereco); }
    public Endereco saveToPessoa(Endereco endereco, Long pessoaId){
        Optional<Pessoa> toSave = pessoaRepository.findById(pessoaId);
        endereco.setPessoa(toSave.get());
        return save(endereco);
    }
    public List<Endereco> findAllFromPessoa(Long pessoaId){ return enderecoRepository.findAllFromPessoa(pessoaId); }

    public Endereco setEnderecoPrincipal(Long pessoaId, Long enderecoId){
        inativaTodosEnderecos(pessoaId);
        Optional<Endereco> enderecoToSetPrincipal = enderecoRepository.findById(enderecoId);
        enderecoToSetPrincipal.get().setPrincipal(true);
        return save(enderecoToSetPrincipal.get());
    }

    public void inativaTodosEnderecos(Long pessoaId){
        List<Endereco> enderecos = findAllFromPessoa(pessoaId);
        for(Endereco endereco : enderecos){
            endereco.setPrincipal(false);
        }
        enderecoRepository.saveAll(enderecos);
    }


}
