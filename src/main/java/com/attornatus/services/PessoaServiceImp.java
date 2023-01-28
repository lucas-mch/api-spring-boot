package com.attornatus.services;

import com.attornatus.enterprise.AbstractBaseRepositoryImpl;
import com.attornatus.enterprise.BasicRepository;
import com.attornatus.model.pessoa.Pessoa;
import com.attornatus.model.pessoa.PessoaService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PessoaServiceImp extends AbstractBaseRepositoryImpl<Pessoa, Long> implements PessoaService {
    private PessoaService pessoaService;
    public PessoaServiceImp(BasicRepository<Pessoa, Long> abstractBaseRepository) { super(abstractBaseRepository); }

}