package com.alves.factory;

import com.alves.entity.madeira.CadeiraMadeira;
import com.alves.entity.madeira.MesaMadeira;
import com.alves.entity.abstractEntity.AbstractCadeira;
import com.alves.entity.abstractEntity.AbstractMesa;

public class MadeiraFactory implements AbstractFactory{
    @Override
    public AbstractMesa createMesa() {
        return new MesaMadeira();
    }

    @Override
    public AbstractCadeira createCadeira() {
        return new CadeiraMadeira();
    }
}
