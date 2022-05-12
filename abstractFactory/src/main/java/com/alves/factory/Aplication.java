package com.alves.factory;

import com.alves.factory.abstractProduct.Cadeira;
import com.alves.factory.abstractProduct.Porta;
import com.alves.factory.factoryProduct.FactoryProduct;

public class Aplication {
    private FactoryProduct factory;

    public Aplication(FactoryProduct factory) {
        this.factory = factory;
    }

    public FactoryProduct getFactory() {
        return factory;
    }

    public Porta createPorta(){
        return factory.createPorta();
    }
    public Cadeira createCadeira(){
        return factory.createCadeira();
    }
}
