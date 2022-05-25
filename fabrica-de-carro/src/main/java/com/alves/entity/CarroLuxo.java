package com.alves.entity;

import com.alves.entity.carroAbstrato.CarroAbstrato;

public class CarroLuxo implements CarroAbstrato {

    private String marca;

    public CarroLuxo(String marca) {
        this.marca = marca;
    }

    @Override
    public String descricao() {
        return "Carro de luxo, Marca " + marca;
    }
}
