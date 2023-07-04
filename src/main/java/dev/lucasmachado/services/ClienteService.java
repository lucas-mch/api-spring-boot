package dev.lucasmachado.services;

import dev.lucasmachado.dto.CategoriaDTO;
import dev.lucasmachado.dto.ClienteDTO;
import dev.lucasmachado.enterprise.enums.TipoPerfil;
import dev.lucasmachado.enterprise.exceptions.DataIntegrityException;
import dev.lucasmachado.enterprise.security.UserSpringSecurity;
import dev.lucasmachado.model.Categoria;
import dev.lucasmachado.model.Cliente;
import dev.lucasmachado.model.Pessoa;
import dev.lucasmachado.repositories.ClienteRepository;
import org.apache.kafka.common.errors.AuthorizationException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(Long id){
        return clienteRepository.findById(id).orElseThrow(
                ()-> new ObjectNotFoundException("Nenhum cliente encontrado com o id : " + id, Cliente.class.getName())
        );
    }

    public ClienteDTO save(ClienteDTO clienteDTO){
        return toDTO(clienteRepository.save(this.fromDTO(clienteDTO)));
    }

    public ClienteDTO update(ClienteDTO clienteDTO) {
        Cliente toSave = findById(clienteDTO.getId());
        return this.save(clienteDTO);
    }

    public List<ClienteDTO> listClientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    public Page<ClienteDTO> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        Sort sort = Sort.by(Sort.Direction.fromString(direction), orderBy);
        PageRequest pageRequest = PageRequest.of(page,linesPerPage, sort);
        return clienteRepository.findAll(pageRequest).map(ClienteDTO::new);
    }

    public void delete(Long id) {
        if (clienteRepository.existsById(id)) {
            try {
                clienteRepository.deleteById(id);
            } catch (DataIntegrityViolationException e) {
                throw new DataIntegrityException("Existem produtos atrelados a categoria id: " + id);
            }
        } else {
            throw new ObjectNotFoundException(Categoria.class, "Cliente com o id : " + id + " nao encontrado");
        }
    }

    public Cliente fromDTO(ClienteDTO clienteDTO){
        return new Cliente(clienteDTO.getId(),clienteDTO.getNome(), clienteDTO.getEmail(), null,null);
    }

    public ClienteDTO toDTO(Cliente cliente){
        return new ClienteDTO(cliente);
    }

    public Cliente findByEmail(String email) {
        UserSpringSecurity user = UserService.authenticated();
        if (user == null || !user.hasRole(TipoPerfil.ADMIN) && !email.equals(user.getUsername())) {
            throw new AuthorizationException("Acesso negado");
        }

        Cliente obj = clienteRepository.findByEmail(email);
        if (obj == null) {
            throw new EntityNotFoundException(
                    "Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + Cliente.class.getName());
        }
        return obj;
    }


}
