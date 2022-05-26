package com.alves.entity.madeira;

import com.alves.entity.abstractEntity.AbstractCadeira;

public class CadeiraMadeira implements AbstractCadeira {
    @Override
    public String descricao() {
        return "Cadeira feita de madeira";
    }
}
