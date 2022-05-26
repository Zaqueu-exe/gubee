package com.alves.fabrica;

import com.alves.entity.veiculoAbstrato.BicicletaAbstrata;
import com.alves.entity.veiculoAbstrato.CarroAbstrato;

public interface FabricaAbstrata {

    CarroAbstrato criarCarro();

    BicicletaAbstrata criarBicicleta();
}
