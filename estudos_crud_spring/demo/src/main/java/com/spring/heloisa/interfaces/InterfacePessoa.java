package com.spring.heloisa.interfaces;

import com.spring.heloisa.model.Pessoa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfacePessoa extends CrudRepository<Pessoa, Integer>{
    
}