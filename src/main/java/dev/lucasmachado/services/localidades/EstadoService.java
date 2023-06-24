package dev.lucasmachado.services.localidades;

import dev.lucasmachado.model.localidades.Estado;
import dev.lucasmachado.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado save(Estado estado) {
        return estadoRepository.save(estado);
    }

    public List<Estado> listEstados(){ return estadoRepository.findAll(); }
}
