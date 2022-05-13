package com.alves.model.dao;

import com.alves.model.entities.Pessoa;

import java.util.List;

public interface PessoaDao {

    void insert(Pessoa pessoa);

    Pessoa findById(Long id);

    List<Pessoa> findAll();
}
