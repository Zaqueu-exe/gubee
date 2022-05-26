package com.alves.factory;

import com.alves.entity.abstractEntity.AbstractCadeira;
import com.alves.entity.abstractEntity.AbstractMesa;

public interface AbstractFactory {


    AbstractMesa createMesa();

    AbstractCadeira createCadeira();

}
