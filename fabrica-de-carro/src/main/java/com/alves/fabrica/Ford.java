package com.alves.fabrica;

import com.alves.entity.CarroLuxo;
import com.alves.entity.CarroPopular;
import com.alves.entity.CarroSuperLuxo;
import com.alves.entity.carroAbstrato.CarroAbstrato;
import com.alves.fabrica.enums.TipoCarro;

public class Ford implements FabricaAbstrata {

    private String marca = "Ford";

    @Override
    public CarroAbstrato criarCarro(TipoCarro tipo) {
        return switch (tipo){
            case POPULAR -> new CarroPopular(marca);
            case LUXO -> new CarroLuxo(marca);
            case SUPERLUXO -> new CarroSuperLuxo(marca);
        };
    }
}
