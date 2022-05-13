package com.alves.entities;

import com.alves.entities.abstractComputer.Computer;

public class Notebook implements Computer {
    private String descricao = "Notebook com a vantagem de ser portatil";

    @Override
    public String getDescricao() {
        return descricao;
    }
}
