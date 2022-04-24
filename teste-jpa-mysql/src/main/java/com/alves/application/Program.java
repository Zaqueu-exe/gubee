package com.alves.application;

import com.alves.entities.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(null, "Marco", "marco@gmail.com");
        Pessoa p2 = new Pessoa(null, "Maria", "maria@gmail.com");
        Pessoa p3 = new Pessoa(null, "Davi", "davi@gmail.com");
        Pessoa p4 = new Pessoa(null, "Branca", "branca@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("teste-jpa");
        EntityManager em = emf.createEntityManager();

        ///em.getTransaction().begin();

        /*em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(p4);*/

        Pessoa p = em.find(Pessoa.class, 4);
        System.out.println(p);

        //em.getTransaction().commit();

        System.out.println("Operação realizada");


        em.close();
        emf.close();
    }
}
