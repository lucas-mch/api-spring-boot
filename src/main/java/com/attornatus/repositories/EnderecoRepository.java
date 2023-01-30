package com.attornatus.repositories;

import com.attornatus.enterprise.repositories.BasicRepository;
import com.attornatus.model.Endereco;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends BasicRepository<Endereco,Long> {
}
