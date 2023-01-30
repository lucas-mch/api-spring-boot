package com.attornatus.services;

import com.attornatus.enterprise.repositories.AbstractBaseRepositoryImpl;
import com.attornatus.enterprise.repositories.BasicRepository;
import com.attornatus.enterprise.services.EnderecoService;
import com.attornatus.model.Endereco;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EnderecoServiceImp extends AbstractBaseRepositoryImpl<Endereco, Long> implements EnderecoService {
    public EnderecoServiceImp(BasicRepository<Endereco, Long> abstractBaseRepository) { super(abstractBaseRepository); }

}
