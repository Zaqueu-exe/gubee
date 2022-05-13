package com.alves.factoryMaker;

import com.alves.entities.abstractComputer.Computer;
import com.alves.factory.FactoryNotebook;
import com.alves.factory.FactoryDesktop;
import com.alves.factory.abstractFactory.Factory;

public class FactoryMaker {

    public static Computer makeFactory(TipoComputer type) {
        Factory factory = null;
        switch (type) {
            case NOTEBOOK -> factory = new FactoryNotebook();
            case DESKTOP -> factory = new FactoryDesktop();
        }
        return factory.createComputer();
    }
}
