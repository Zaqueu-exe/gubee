package com.alves.factory.factoryProduct;

import com.alves.factory.abstractProduct.Cadeira;
import com.alves.factory.abstractProduct.Porta;
import com.alves.factory.product.CadeiraDePedra;
import com.alves.factory.product.PortaDePedra;

public class PedraFactory implements FactoryProduct {
    @Override
    public Porta createPorta() {
        return new PortaDePedra();
    }

    @Override
    public Cadeira createCadeira() {
        return new CadeiraDePedra();
    }
}
