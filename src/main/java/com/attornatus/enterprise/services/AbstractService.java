package com.attornatus.enterprise.services;

import com.attornatus.enterprise.entities.AbstractEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface AbstractService <T extends AbstractEntity, ID extends Serializable>{
    T save(T entity);
    List<T> findAll();
    Optional<T> findById(ID entityId);
    T update(T entity);
    T updateById(T entity, ID entityId);
    void delete(T entity);
    void deleteById(ID entityId);

}