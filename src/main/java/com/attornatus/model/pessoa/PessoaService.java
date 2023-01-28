package com.attornatus.model.pessoa;

import com.attornatus.enterprise.AbstractService;
import com.attornatus.enterprise.BasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface PessoaService extends AbstractService<Pessoa, Long> {

}
