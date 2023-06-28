package dev.lucasmachado.services;

import dev.lucasmachado.model.Pedido;
import dev.lucasmachado.repositories.PedidoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido findById(Long id){
        return pedidoRepository.findById(id).orElseThrow(
                ()-> new ObjectNotFoundException("Nenhum pedido encontrado com o id : " + id, Pedido.class.getName())
        );
    }

}
