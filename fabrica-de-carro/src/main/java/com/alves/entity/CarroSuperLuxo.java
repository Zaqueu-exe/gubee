package com.alves.entity;

import com.alves.entity.carroAbstrato.CarroAbstrato;

public class CarroSuperLuxo implements CarroAbstrato {

    private String marca;

    public CarroSuperLuxo(String marca) {
        this.marca = marca;
    }

    @Override
    public String descricao() {
        return "Carro super luxo, Marca " + marca;
    }

}
