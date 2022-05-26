package com.alves;

import com.alves.fabrica.FabricaAbstrata;
import com.alves.fabrica.LuxoFactory;
import com.alves.fabrica.PopularFactory;
import com.alves.fabrica.SuperLuxoFactory;
import com.alves.fabrica.enums.TipoFabrica;

public interface Init {
    

    public static FabricaAbstrata criarFabrica(TipoFabrica tipo){
        return switch (tipo) {
            case LUXO -> new LuxoFactory();
            case POPULAR -> new PopularFactory();
            case SUPERLUXO -> new SuperLuxoFactory(); 
        };
    }
}
