package com.alves.factory.product;

import com.alves.factory.abstractProduct.Porta;

public class PortaDePedra implements Porta {

    private String descric = "Porta feita com pedra";

    @Override
    public String descriçao() {
        return descric;
    }
}
