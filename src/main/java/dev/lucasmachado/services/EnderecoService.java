package dev.lucasmachado.services;

import dev.lucasmachado.model.Endereco;
import dev.lucasmachado.model.Pessoa;
import dev.lucasmachado.repositories.EnderecoRepository;
import dev.lucasmachado.repositories.PessoaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaService pessoaService;

    public Endereco save(Endereco endereco){ return enderecoRepository.save(endereco); }
    public Endereco saveToPessoa(Endereco endereco, Long pessoaId){
        Pessoa pessoaToSave = pessoaService.findById(pessoaId);
        endereco.setPessoa(pessoaToSave);
        Endereco enderecoSalvo = this.save(endereco);
        if(enderecoSalvo.getPrincipal()){
            setEnderecoPrincipal(pessoaToSave.getId(), endereco.getId());
        }
        return enderecoSalvo;
    }
    public List<Endereco> findAllFromPessoa(Long pessoaId) {
        Pessoa pessoaToSave = pessoaService.findById(pessoaId);
        List<Endereco> pessoaEnderecoList = enderecoRepository.findAllFromPessoa(pessoaId);
        if(pessoaEnderecoList == null || pessoaEnderecoList.size() == 0) {
            throw new ObjectNotFoundException("Nenhum endereço encontrado para a pessoa com id : " + pessoaId, Endereco.class.getName());
        }
        return pessoaEnderecoList;
    }
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
