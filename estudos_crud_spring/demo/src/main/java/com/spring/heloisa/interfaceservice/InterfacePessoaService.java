package com.spring.heloisa.interfaceservice;

import java.util.List;
import java.util.Optional;

import com.spring.heloisa.model.Pessoa;

public interface InterfacePessoaService {
    public List<Pessoa>listar();
    public Optional<Pessoa>listarId(int id);
    public int save(Pessoa person);
    public void delete(int id);

}