package com.spring.heloisa.service;

import java.util.List;
import java.util.Optional;

import com.spring.heloisa.interfaces.InterfacePessoa;
import com.spring.heloisa.interfaceservice.InterfacePessoaService;
import com.spring.heloisa.model.Pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService implements InterfacePessoaService {
    
    
    @Autowired
    private InterfacePessoa data;
    @Override
    public List<Pessoa> listar() {
        return (List<Pessoa>)data.findAll();
        
    }

    @Override
    public Optional<Pessoa> listarId(int id) {
        return data.findById(id);
        
    }

    @Override
    public int save(Pessoa person) {
        int res = 0;
        Pessoa p = data.save(person);
        if(!p.equals(null)){
            res = 1;
        }
        return res;
        
        
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}