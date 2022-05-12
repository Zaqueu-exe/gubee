package com.alves.factory.factoryProduct;

import com.alves.factory.abstractProduct.Cadeira;
import com.alves.factory.abstractProduct.Porta;

public interface FactoryProduct {

    Porta createPorta();

    Cadeira createCadeira();
}
