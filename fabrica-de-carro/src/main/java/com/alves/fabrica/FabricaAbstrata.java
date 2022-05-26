package com.alves.fabrica;

import com.alves.entity.carroAbstrato.CarroAbstrato;
import com.alves.fabrica.enums.TipoCarro;

public interface FabricaAbstrata {

    public static FabricaAbstrata escolherTipo(TipoCarro marca){
        return switch (marca){
            case POPULAR -> new Popular();
            case LUXO -> new Luxo();
            case SUPERLUXO -> new SuperLuxo();
        };
    }

    CarroAbstrato criarCarro();
}
