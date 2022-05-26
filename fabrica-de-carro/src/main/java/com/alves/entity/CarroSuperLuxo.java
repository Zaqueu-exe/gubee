package com.alves.entity;

import com.alves.entity.carroAbstrato.CarroAbstrato;

public class CarroSuperLuxo implements CarroAbstrato {

    @Override
    public String descricao() {
        return "Carro super luxo";
    }

}
