package com.alves;

import com.alves.model.dao.enums.PessoaType;
import com.alves.model.dao.AbstractFactory;
import com.alves.model.entities.Pessoa;
import com.alves.model.entities.abstractPessoa.PessoaAbstrata;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        
        var sdf = new SimpleDateFormat("dd-MM-yyyy");

        var proxy = AbstractFactory.createProxy(PessoaType.PESSOA);
        proxy.insert(new Pessoa(null, "Joana", sdf.parse("02-06-1965")));

       // System.out.println();

        proxy.findAll().stream().forEach(System.out::println);


       // var pessoa = AbstractFactory.createPessoa(PessoaType.PESSOA);
    }
}