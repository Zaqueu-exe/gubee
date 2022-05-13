package com.alves;

import com.alves.factoryMaker.FactoryMaker;
import com.alves.factoryMaker.enums.PessoaType;
import com.alves.model.entities.Pessoa;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        
        var sdf = new SimpleDateFormat("dd-MM-yyyy");

        var proxy = FactoryMaker.createProxy(PessoaType.PESSOA);

        //proxy.insert(new Pessoa(null, "Patricia", sdf.parse("05-05-1995")));

        System.out.println();

        proxy.findAll().stream().forEach(System.out::println);

        var pessoa = FactoryMaker.createPessoa(PessoaType.PESSOA);
    }
}