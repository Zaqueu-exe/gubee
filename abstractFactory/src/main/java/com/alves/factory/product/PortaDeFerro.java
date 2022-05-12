package com.alves.factory.product;

import com.alves.factory.abstractProduct.Porta;

public class PortaDeFerro implements Porta {

    private String descric = "Porta feita com minerio de ferro";

    @Override
    public String descriçao() {
        return descric;
    }
}
