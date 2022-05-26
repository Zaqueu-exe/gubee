package com.alves;

import com.alves.factory.AbstractFactory;
import com.alves.factory.AcoFactory;
import com.alves.factory.MadeiraFactory;
import com.alves.factory.enums.TipoFabrica;

public interface Init {

    public static AbstractFactory criarFabrica(TipoFabrica tipo){
        return switch (tipo){
            case ACO -> new AcoFactory();
            case MADEIRA -> new MadeiraFactory();
        };
    }
}
