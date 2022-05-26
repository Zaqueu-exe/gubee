package com.alves;

import com.alves.entity.abstractEntity.AbstractCadeira;
import com.alves.entity.abstractEntity.AbstractMesa;
import com.alves.factory.enums.TipoFabrica;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        var factoryMadeira = Init.criarFabrica(TipoFabrica.MADEIRA);
        var factoryAco = Init.criarFabrica(TipoFabrica.ACO);

        List<AbstractCadeira> cadeiras = Arrays.asList(
                factoryMadeira.createCadeira(),
                factoryAco.createCadeira()
        );

        cadeiras.stream().map(x -> x.descricao()).forEach(System.out::println);

        List<AbstractMesa> mesas = Arrays.asList(
                factoryAco.createMesa(),
                factoryMadeira.createMesa()
        );

        mesas.stream().map(x -> x.descricao()).forEach(System.out::println);

    }
}