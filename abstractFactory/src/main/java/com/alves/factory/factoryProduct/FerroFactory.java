package com.alves.factory.factoryProduct;

import com.alves.factory.abstractProduct.Cadeira;
import com.alves.factory.abstractProduct.Porta;
import com.alves.factory.product.CadeiraDeFerro;
import com.alves.factory.product.PortaDeFerro;

public class FerroFactory implements FactoryProduct{

    @Override
    public Porta createPorta() {
        return new PortaDeFerro();
    }

    @Override
    public Cadeira createCadeira() {
        return new CadeiraDeFerro();
    }
}
