package com.alves.pedido.service;

import com.alves.pedido.Domain.Pessoa;
import com.alves.pedido.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> findAll(){
        return repository.findAll();
    }

    public Pessoa findById(String id){
        Optional<Pessoa> obj = repository.findById(id);
        return obj.get();
    }

    public Pessoa insert(Pessoa pessoa){
        return repository.insert(pessoa);
    }
}
