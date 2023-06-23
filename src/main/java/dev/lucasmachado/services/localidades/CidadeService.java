package dev.lucasmachado.services.localidades;

import dev.lucasmachado.model.localidades.Cidade;
import dev.lucasmachado.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade save(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }
}
