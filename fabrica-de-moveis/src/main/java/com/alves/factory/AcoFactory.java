package com.alves.factory;

import com.alves.entity.aco.CadeiraAco;
import com.alves.entity.aco.MesaAco;
import com.alves.entity.abstractEntity.AbstractCadeira;
import com.alves.entity.abstractEntity.AbstractMesa;

public class AcoFactory implements AbstractFactory{
    @Override
    public AbstractMesa createMesa() {
        return new MesaAco();
    }

    @Override
    public AbstractCadeira createCadeira() {
        return new CadeiraAco();
    }
}
