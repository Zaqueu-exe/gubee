package com.alves.entity.aco;

import com.alves.entity.abstractEntity.AbstractMesa;

public class MesaAco implements AbstractMesa {
    @Override
    public String descricao() {
        return "Mesa feita de aço";
    }
}
