package com.alves.model.entities.abstractPessoa;

import java.util.Date;

public interface PessoaAbstrata {


    Long getId();

    void setId(Long id);

    String getNome();

    void setNome(String nome);

    Date getDataNascimento();

    void setDataNascimento(Date DataNascimento);
}
