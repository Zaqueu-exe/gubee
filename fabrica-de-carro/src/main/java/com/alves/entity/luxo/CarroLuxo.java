package com.alves.entity.luxo;

import com.alves.entity.veiculoAbstrato.CarroAbstrato;

public class CarroLuxo implements CarroAbstrato {
    @Override
    public String descricao() {
        return "Carro de luxo";
    }
}
