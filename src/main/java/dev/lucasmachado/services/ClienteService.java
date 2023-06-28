package dev.lucasmachado.services;

import dev.lucasmachado.model.Cliente;
import dev.lucasmachado.model.Pessoa;
import dev.lucasmachado.repositories.ClienteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(Long id){
        return clienteRepository.findById(id).orElseThrow(
                ()-> new ObjectNotFoundException("Nenhum cliente encontrado com o id : " + id, Cliente.class.getName())
        );
    }

    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        return this.save(cliente);
    }

}
