package model.dao;

import model.entities.Pessoa;

import java.util.HashSet;

public class PessoaManager {
    private PessoaDao service;

    public PessoaManager(PessoaDao service) {
        this.service = service;
    }

    public HashSet<Pessoa> findAll(){
        return service.findAll();
    }

    public void insert(Pessoa pessoa){
        service.insert(pessoa);
    }

    public Pessoa findById(Long id){
        return service.findById(id);
    }
}
