package com.alves.fabrica;

import com.alves.entity.carroAbstrato.CarroAbstrato;
import com.alves.fabrica.enums.MarcaCarro;
import com.alves.fabrica.enums.TipoCarro;

public interface FabricaAbstrata {

    public static FabricaAbstrata escolherMarca(MarcaCarro marca){
        return switch (marca){
            case FORD -> new Ford();
            case HONDA -> new Honda();
            case CHERRY -> new Cherry();
        };
    }

    CarroAbstrato criarCarro(TipoCarro tipo);
}
