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

        var proxy = AbstractFactory.createPessoaDaoProxy(PessoaType.PESSOA);
       // proxy.insert(new Pessoa(null, "Ze", sdf.parse("01-04-1986")));

       // System.out.println();

        proxy.findAll().stream().forEach(System.out::println);


       // var pessoa = AbstractFactory.createPessoa(PessoaType.PESSOA);
    }
}