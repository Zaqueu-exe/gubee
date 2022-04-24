package com.alves.application;

import com.alves.dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(null, "Joao", "joao@gmail.com");
        Pessoa p2 = new Pessoa(null, "Paulo", "paulo@gmail.com");
        Pessoa p3 = new Pessoa(null, "Ana", "Ana@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        /*em.getTransaction().begin();

        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();*/
        Pessoa p = em.find(Pessoa.class, 2);
        System.out.println(p);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();

        em.clear();
        emf.close();
        System.out.println("--------------------");


        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);


    }
}
