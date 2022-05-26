package com.alves.fabrica;

import com.alves.entity.popular.BicicletaPopular;
import com.alves.entity.popular.CarroPopular;
import com.alves.entity.veiculoAbstrato.BicicletaAbstrata;
import com.alves.entity.veiculoAbstrato.CarroAbstrato;

public class PopularFactory implements FabricaAbstrata {

    @Override
    public CarroAbstrato criarCarro() {
        return new CarroPopular();
    }

    @Override
    public BicicletaAbstrata criarBicicleta() {
        return new BicicletaPopular();
    }
    
}
