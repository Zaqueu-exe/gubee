package com.alves.entity.aco;

import com.alves.entity.abstractEntity.AbstractCadeira;

public class CadeiraAco implements AbstractCadeira {
    @Override
    public String descricao() {
        return "Cadeira feita de aço";
    }
}
