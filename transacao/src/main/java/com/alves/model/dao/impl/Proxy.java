package com.alves.model.dao.impl;

import com.alves.model.anotation.Transaction;
import com.alves.model.dao.PessoaDao;
import com.alves.model.entities.Pessoa;
import com.alves.model.entities.abstractPessoa.PessoaAbstrata;

import java.lang.reflect.Method;
import java.util.List;

public class Proxy implements PessoaDao {
    private PessoaDao service;

    public Proxy(PessoaDao pessoaDao) {
        this.service = pessoaDao;
    }

    @Override
    public void insert(PessoaAbstrata pessoa) {
        Runnable runnable = () -> service.insert(pessoa);
        this.execute(runnable);
    }

    @Override
    public PessoaAbstrata findById(Long id) {
        return service.findById(id);
    }

    @Override
    public List<PessoaAbstrata> findAll() {
        return service.findAll();
    }

    private void execute(Runnable runnable) {
        Method method = null;
        try {
            method = service.getClass().getDeclaredMethod("insert", PessoaAbstrata.class);
            if (method.isAnnotationPresent(Transaction.class)) {
                System.out.println("Iniciando execução do método " + method);
                System.out.println();
                runnable.run();
                System.out.println("Finalizando execução do método " + method + " com sucesso");
            } else {
                runnable.run();
            }
        } catch (NoSuchMethodException | RuntimeException e) {
            System.out.println("Finalizando execução do método " + method + " com erro");
            throw new RuntimeException(e);
        }
    }
}
