package com.alves;

import com.alves.fabrica.FabricaAbstrata;
import com.alves.fabrica.enums.MarcaCarro;
import com.alves.fabrica.enums.TipoCarro;

public class Main {
    public static void main(String[] args) {

        var fabricaFord = FabricaAbstrata.escolherMarca(MarcaCarro.FORD);

        var fordPopular = fabricaFord.criarCarro(TipoCarro.POPULAR);
        var fordLuxo = fabricaFord.criarCarro(TipoCarro.LUXO);
        var fordSuperLuxo = fabricaFord.criarCarro(TipoCarro.SUPERLUXO);

        System.out.println(fordPopular.descricao());
        System.out.println(fordLuxo.descricao());
        System.out.println(fordSuperLuxo.descricao());

        System.out.println("--------------------------------------------------------------------");


        var fabricaHonda = FabricaAbstrata.escolherMarca(MarcaCarro.HONDA);

        var hondaPopular = fabricaHonda.criarCarro(TipoCarro.POPULAR);
        var hondaLuxo = fabricaHonda.criarCarro(TipoCarro.LUXO);
        var hondaSuperLuxo = fabricaHonda.criarCarro(TipoCarro.SUPERLUXO);

        System.out.println(hondaPopular.descricao());
        System.out.println(hondaLuxo.descricao());
        System.out.println(hondaSuperLuxo.descricao());

        System.out.println("--------------------------------------------------------------------");


        var fabricaCherry = FabricaAbstrata.escolherMarca(MarcaCarro.CHERRY);

        var cherryPopular = fabricaCherry.criarCarro(TipoCarro.POPULAR);
        var cherryLuxo = fabricaCherry.criarCarro(TipoCarro.LUXO);
        var cherrySuperLuxo = fabricaCherry.criarCarro(TipoCarro.SUPERLUXO);

        System.out.println(cherryPopular.descricao());
        System.out.println(cherryLuxo.descricao());
        System.out.println(cherrySuperLuxo.descricao());

    }
}