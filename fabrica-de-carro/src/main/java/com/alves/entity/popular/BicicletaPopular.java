package com.alves.entity.popular;

import com.alves.entity.veiculoAbstrato.BicicletaAbstrata;

public class BicicletaPopular  implements BicicletaAbstrata {

    @Override
    public String descricao() {
        return "Bicicleta popular";
    }
    
    
}
