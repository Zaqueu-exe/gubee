package com.alves.entity.popular;

import com.alves.entity.veiculoAbstrato.CarroAbstrato;

public class CarroPopular implements CarroAbstrato {
    @Override
    public String descricao() {
        return "Carro popular";
    }
}
