package com.alves.pedido.config;

import com.alves.pedido.Domain.Pessoa;
import com.alves.pedido.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public void run(String... args) throws Exception {
        pessoaRepository.deleteAll();
        Pessoa p1 = new Pessoa(null, "Jose", "jose@hmail.com", "5599994444");
        pessoaRepository.save(p1);
    }
}
