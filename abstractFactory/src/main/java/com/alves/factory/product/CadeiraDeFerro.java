package com.alves.factory.product;

import com.alves.factory.abstractProduct.Cadeira;
import com.alves.factory.abstractProduct.Porta;

public class CadeiraDeFerro implements Cadeira {

    private String descric = "Cadeira feita com minerio de ferro";

    @Override
    public String descriçao() {
        return descric;
    }
}
