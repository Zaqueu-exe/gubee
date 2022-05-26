package com.alves.entity;

import com.alves.entity.carroAbstrato.CarroAbstrato;

public class CarroLuxo implements CarroAbstrato {
    @Override
    public String descricao() {
        return "Carro de luxo";
    }
}
