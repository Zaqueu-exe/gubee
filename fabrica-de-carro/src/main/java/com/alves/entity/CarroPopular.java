package com.alves.entity;

import com.alves.entity.carroAbstrato.CarroAbstrato;

public class CarroPopular implements CarroAbstrato {
    private String marca;

    public CarroPopular(String marca) {
        this.marca = marca;
    }
    @Override
    public String descricao() {
        return "Carro popular, Marca " + marca;
    }
}
