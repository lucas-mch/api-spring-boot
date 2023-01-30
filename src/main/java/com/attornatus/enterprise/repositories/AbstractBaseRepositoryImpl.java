package com.attornatus.enterprise.repositories;

import com.attornatus.enterprise.entities.AbstractEntity;
import com.attornatus.enterprise.services.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public abstract class AbstractBaseRepositoryImpl<T extends AbstractEntity, ID extends Serializable> implements AbstractService<T, ID> {


    private BasicRepository<T, ID> abstractBaseRepository;

    public AbstractBaseRepositoryImpl(BasicRepository<T, ID> abstractBaseRepository) {
        this.abstractBaseRepository = abstractBaseRepository;
    }

    @Override
    public T save(T entity) {
        return (T) abstractBaseRepository.save(entity);
    }

    @Override
    public List<T> findAll() {
        return abstractBaseRepository.findAll();
    }

    @Override
    public Optional<T> findById(ID entityId) {
        return abstractBaseRepository.findById(entityId);
    }

    @Override
    public T update(T entity) {
        return (T) abstractBaseRepository.save(entity);
    }

    @Override
    public T updateById(T entity, ID entityId) {
        Optional<T> optional = abstractBaseRepository.findById(entityId);
        if(optional.isPresent()){
            return (T) abstractBaseRepository.save(entity);
        }else{
            return null;
        }
    }

    @Override
    public void delete(T entity) {
        abstractBaseRepository.delete(entity);
    }

    @Override
    public void deleteById(ID entityId) {
        abstractBaseRepository.deleteById(entityId);
    }

}