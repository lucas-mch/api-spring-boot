package com.attornatus.services;

import com.attornatus.enterprise.AbstractBaseRepositoryImpl;
import com.attornatus.enterprise.BasicRepository;
import com.attornatus.model.endereco.Endereco;
import com.attornatus.model.endereco.EnderecoService;
import com.attornatus.model.pessoa.Pessoa;
import com.attornatus.model.pessoa.PessoaService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EnderecoServiceImp extends AbstractBaseRepositoryImpl<Endereco, Long> implements EnderecoService {
    public EnderecoServiceImp(BasicRepository<Endereco, Long> abstractBaseRepository) { super(abstractBaseRepository); }

}
