package com.attornatus.repositories;

import com.attornatus.enterprise.repositories.BasicRepository;
import com.attornatus.model.Pessoa;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends BasicRepository<Pessoa, Long> {
}
