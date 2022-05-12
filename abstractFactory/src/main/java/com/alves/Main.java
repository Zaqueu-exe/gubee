package com.alves;

import com.alves.factory.Aplication;
import com.alves.factory.abstractProduct.Porta;
import com.alves.factory.factoryProduct.FactoryProduct;
import com.alves.factory.factoryProduct.FerroFactory;
import com.alves.factory.factoryProduct.PedraFactory;

public class Main {
    public static void main(String[] args) {

        //O que quer fazer?    Cadeira
        String tipo = "cadeira";
        //de qual material quer fazer?    Cadeira
        String material = "pedra";

        if(material.equals("pedra")){
            FactoryProduct factoryPedra = new PedraFactory();

            if(tipo.equals("cadeira")){
                Aplication aplicationFabricar = new Aplication(new PedraFactory());
                System.out.println(tipo + " em construção");
                System.out.print(aplicationFabricar.createCadeira().descriçao());
                System.out.println(" Concluida");
            }

        }

       /* FactoryProduct factoryPedra = new PedraFactory();
        FactoryProduct factoryFerro = new FerroFactory();

        Aplication aplication = new Aplication(factoryFerro);
        System.out.println(aplication.createPorta().descriçao());
        System.out.println(aplication.createCadeira().descriçao());
        System.out.println();

        Aplication aplication1 = new Aplication(factoryPedra);
        System.out.println(aplication1.createPorta().descriçao());
        System.out.println(aplication1.createCadeira().descriçao());
        System.out.println();

        Porta porta = aplication.createPorta();
        System.out.println(porta.descriçao());*/
    }
}