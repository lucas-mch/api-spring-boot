package dev.lucasmachado.resources;

import dev.lucasmachado.dto.CategoriaDTO;
import dev.lucasmachado.dto.ClienteDTO;
import dev.lucasmachado.model.Cliente;
import dev.lucasmachado.model.Pessoa;
import dev.lucasmachado.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id){
        Cliente toFind = clienteService.findById(id);
        return ResponseEntity.ok().body(toFind);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody ClienteDTO clienteDTO) {
        clienteDTO = clienteService.save(clienteDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(clienteDTO.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody ClienteDTO cliente, @PathVariable Long id) {
        cliente.setId(id);
        clienteService.update(cliente);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public  ResponseEntity<?> listarCategorias() {
        List<ClienteDTO> clientes = clienteService.listClientes();
        return ResponseEntity.ok().body(clientes);
    }


    @RequestMapping(value = "page", method = RequestMethod.GET)
    public  ResponseEntity<Page<ClienteDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                        @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                                        @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
                                                        @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<ClienteDTO> clientes = clienteService.findPage(page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(clientes);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public  ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
