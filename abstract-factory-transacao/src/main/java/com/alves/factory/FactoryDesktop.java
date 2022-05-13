package com.alves.factory;

import com.alves.entities.Desktop;
import com.alves.entities.abstractComputer.Computer;
import com.alves.factory.abstractFactory.Factory;

public class FactoryDesktop implements Factory {

    @Override
    public Computer createComputer() {
        return new Desktop();
    }
}
