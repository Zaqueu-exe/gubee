package com.alves.factory.product;

import com.alves.factory.abstractProduct.Cadeira;
import com.alves.factory.abstractProduct.Porta;

public class CadeiraDePedra implements Cadeira {

    private String descric = "Cadeira feita de pedra";

    @Override
    public String descriçao() {
        return descric;
    }
}