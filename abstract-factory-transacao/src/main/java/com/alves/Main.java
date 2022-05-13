package com.alves;

import com.alves.entities.abstractComputer.Computer;
import com.alves.factoryMaker.FactoryMaker;
import com.alves.factoryMaker.TipoComputer;

public class Main {
    public static void main(String[] args) {

            Computer notebook = FactoryMaker.makeFactory(TipoComputer.NOTEBOOK);
            Computer desktop = FactoryMaker.makeFactory(TipoComputer.DESKTOP);

            System.out.println(notebook.getDescricao());
            System.out.println(desktop.getDescricao());
    }
}