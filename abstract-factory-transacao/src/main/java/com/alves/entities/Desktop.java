package com.alves.entities;

import com.alves.entities.abstractComputer.Computer;

public class Desktop implements Computer {
    private String descricao = "Desktop com a vantagem de ter um processamento melhor";

    @Override
    public String getDescricao() {
        return descricao;
    }
}
