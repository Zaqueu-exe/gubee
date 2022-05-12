package com.alves;

import com.alves.model.dao.AbstractFactory;
import com.alves.model.dao.PessoaDao;
import com.alves.model.entities.Pessoa;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        
        var sdf = new SimpleDateFormat("dd-MM-yyyy");

        PessoaDao proxy = AbstractFactory.createProxy();

        proxy.insert(new Pessoa(null, "Luciano", sdf.parse("11-01-2012")));

        proxy.findAll().forEach(System.out::println);

    }
}