package com.alves.entity;

import com.alves.entity.carroAbstrato.CarroAbstrato;

public class CarroPopular implements CarroAbstrato {
    @Override
    public String descricao() {
        return "Carro popular";
    }
}
