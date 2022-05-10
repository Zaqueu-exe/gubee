package model.dao.impl;

import model.anotation.Transaction;
import model.dao.PessoaDao;
import model.entities.Pessoa;

import java.lang.reflect.Method;
import java.util.HashSet;

public class PessoaDaoCache implements PessoaDao {
    private PessoaDao service;
    private Pessoa pessoaCache;
    private HashSet<Pessoa> pessoasCache = new HashSet<>();

    public PessoaDaoCache(PessoaDao pessoaDao) {
        this.service = pessoaDao;
    }

    @Override
    public void insert(Pessoa pessoa) {
        service.insert(pessoa);
    }

    @Override
    public Pessoa findById(Long id) {
        if (id == pessoaCache.getId()) {
            return pessoaCache;
        }
        return service.findById(id);
    }

    @Override
    public HashSet<Pessoa> findAll() {
        if (pessoasCache.isEmpty()) {
            Method method = null;

            try {
                method = service.getClass().getDeclaredMethod("findAll");
                if (method.isAnnotationPresent(Transaction.class)) {
                    System.out.println("Iniciando execução do método " + method);
                    pessoasCache.addAll(service.findAll());
                    System.out.println("Finalizando execução do método" + method + " com sucesso");
                    return pessoasCache;
                }
            } catch (NoSuchMethodException | RuntimeException e) {
                System.out.println("Finalizando execução do método" + method + " com erro");
                throw new RuntimeException(e);
            }
            pessoasCache.addAll(service.findAll());
        }
        return pessoasCache;
    }
}
