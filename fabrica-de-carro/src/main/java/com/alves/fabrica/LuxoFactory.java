package com.alves.fabrica;

import com.alves.entity.luxo.BicicletaLuxo;
import com.alves.entity.luxo.CarroLuxo;
import com.alves.entity.veiculoAbstrato.BicicletaAbstrata;
import com.alves.entity.veiculoAbstrato.CarroAbstrato;

public class LuxoFactory implements FabricaAbstrata {

    @Override
    public CarroAbstrato criarCarro() {
        return new CarroLuxo();
    }

    @Override
    public BicicletaAbstrata criarBicicleta() {
        return new BicicletaLuxo();
    }
    
}
