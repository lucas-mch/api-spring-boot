package com.attornatus.services;

import com.attornatus.enterprise.repositories.AbstractBaseRepositoryImpl;
import com.attornatus.enterprise.repositories.BasicRepository;
import com.attornatus.enterprise.services.PessoaService;
import com.attornatus.model.Endereco;
import com.attornatus.model.Pessoa;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class PessoaServiceImp extends AbstractBaseRepositoryImpl<Pessoa, Long> implements PessoaService {
     public PessoaServiceImp(BasicRepository<Pessoa, Long> abstractBaseRepository) {
          super(abstractBaseRepository);
     }

     @Autowired
     private EnderecoServiceImp enderecoService;

     @Override
     public Optional<Pessoa> findById(Long entityId) {
          Optional<Pessoa> pessoa = super.findById(entityId);
          return Optional.ofNullable(pessoa.orElseThrow(() -> new ObjectNotFoundException(entityId, Pessoa.class.getName())));
     }

     @Override
     public Pessoa save(Pessoa entity) {
          entity.setId(null);
          return super.save(entity);
     }

     @Override
     public Pessoa update(Pessoa entity) {
          findById(entity.getId());
          Endereco enderecoToSave = new Endereco();
          //todo implementar no EnderecoServiceImp xD
          if (entity.getEnderecos() != null) {
               for (int i = 0; i < entity.getEnderecos().size(); i++) {
                    enderecoToSave = entity.getEnderecos().get(i);
                    enderecoToSave.setPessoa(entity);
                    enderecoService.update(enderecoToSave);
               }
          }
          return super.update(entity);
     }
}