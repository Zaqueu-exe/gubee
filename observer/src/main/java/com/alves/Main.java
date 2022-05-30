package com.alves;

import com.alves.manager.Publicador;
import com.alves.service.EmailService;
import com.alves.service.interfac.Notificar;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Publicador publicador = new Publicador();

        EmailService e1 = new EmailService("j4@gmail.com");
        EmailService e2 = new EmailService("gh5@gmail.com");
        EmailService e3 = new EmailService("nvg76@gmail.com");
        EmailService e4 = new EmailService("lpt678@gmail.com");
        EmailService e5 = new EmailService("games01@gmail.com");
        EmailService e6 = new EmailService("gfd3@gmail.com");
        EmailService e7 = new EmailService("pl90@gmail.com");
        EmailService e8 = new EmailService("ihjt5@gmail.com");

        List<Notificar> notificars = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8);

        publicador.escrever(notificars);

        //não é para inserir
        publicador.escrever(notificars);

        publicador.notificarTodos();

    }
}