package com.attornatus.enterprise;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface AbstractService <T extends AbstractEntity, ID extends Serializable>{
    public T save(T entity);
    public List<T> findAll();
    public Optional<T> findById(ID entityId);
    public T update(T entity);
    public T updateById(T entity, ID entityId);
    public void delete(T entity);
    public void deleteById(ID entityId);

}