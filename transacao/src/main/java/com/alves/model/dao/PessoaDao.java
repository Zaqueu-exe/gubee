package com.alves.model.dao;

import com.alves.model.entities.abstractPessoa.PessoaAbstrata;

import java.util.List;

public interface PessoaDao {

    void insert(PessoaAbstrata pessoa);

    PessoaAbstrata findById(Long id);

    List<PessoaAbstrata> findAll();
}
