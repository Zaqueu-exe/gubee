package com.alves.model.dao.impl;

import com.alves.model.anotation.Transaction;
import com.alves.model.dao.PessoaDao;
import com.alves.model.entities.Pessoa;

import java.lang.reflect.Method;
import java.util.List;

public class Proxy implements PessoaDao {
    private PessoaDao service;

    public Proxy(PessoaDao pessoaDao) {
        this.service = pessoaDao;
    }

    @Override
    public void insert(Pessoa pessoa) {
        Runnable runnable = () -> service.insert(pessoa);
        this.executeInsert(runnable);
    }

    @Override
    public Pessoa findById(Long id) {
        return service.findById(id);
    }

    @Override
    public List<Pessoa> findAll() {
        return service.findAll();
    }

    private void executeInsert(Runnable runnable) {
        Method method = null;
        try {
            method = service.getClass().getDeclaredMethod("insert", Pessoa.class);
            if (method.isAnnotationPresent(Transaction.class)) {
                System.out.println("Iniciando execução do método " + method);
                runnable.run();
                System.out.println("Finalizando execução do método" + method + " com sucesso");
                return;
            }
            runnable.run();
        } catch (NoSuchMethodException | RuntimeException e) {
            System.out.println("Finalizando execução do método" + method + " com erro");
            throw new RuntimeException(e);
        }
    }
}
