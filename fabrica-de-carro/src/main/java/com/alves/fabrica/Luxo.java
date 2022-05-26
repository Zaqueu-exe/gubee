package com.alves.fabrica;

import com.alves.entity.CarroLuxo;
import com.alves.entity.CarroPopular;
import com.alves.entity.carroAbstrato.CarroAbstrato;
import com.alves.fabrica.enums.TipoCarro;

public class Luxo implements FabricaAbstrata {
    @Override
    public CarroAbstrato criarCarro() {
        return new CarroLuxo();
    }
}
