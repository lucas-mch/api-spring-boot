package com.attornatus.model.pessoa;

import com.attornatus.enterprise.BasicRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends BasicRepository<Pessoa, Long> {
}
