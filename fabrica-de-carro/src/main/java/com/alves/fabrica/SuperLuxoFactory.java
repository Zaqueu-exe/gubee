package com.alves.fabrica;

import com.alves.entity.superLuxo.BicicletaSuperLuxo;
import com.alves.entity.superLuxo.CarroSuperLuxo;
import com.alves.entity.veiculoAbstrato.BicicletaAbstrata;
import com.alves.entity.veiculoAbstrato.CarroAbstrato;

public class SuperLuxoFactory implements FabricaAbstrata {

    @Override
    public CarroAbstrato criarCarro() {
        return new CarroSuperLuxo();
    }

    @Override
    public BicicletaAbstrata criarBicicleta() {
        return new BicicletaSuperLuxo();
    }
    
}
