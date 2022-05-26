package com.alves.entity.madeira;

import com.alves.entity.abstractEntity.AbstractMesa;

public class MesaMadeira  implements AbstractMesa {
    @Override
    public String descricao() {
        return "Mesa feita de madeira";
    }
}
