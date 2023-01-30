package com.attornatus.enterprise.repositories;

import com.attornatus.enterprise.entities.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
@NoRepositoryBean
public interface BasicRepository<T extends AbstractEntity, ID extends Serializable> extends JpaRepository<T, ID> {

}
