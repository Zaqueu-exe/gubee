package model.dao;


import model.anotation.Transaction;
import model.entities.Pessoa;

import java.util.HashSet;

public interface PessoaDao {

    void insert(Pessoa pessoa);

    Pessoa findById(Long id);

    HashSet<Pessoa> findAll();
}
