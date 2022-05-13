package com.alves.factory;

import com.alves.entities.Notebook;
import com.alves.entities.abstractComputer.Computer;
import com.alves.factory.abstractFactory.Factory;

public class FactoryNotebook implements Factory {

    @Override
    public Computer createComputer() {
        return new Notebook();
    }
}
