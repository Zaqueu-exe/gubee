package com.alves.service;

import com.alves.service.interfac.Notificar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmailService implements Notificar {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private String email;

    public EmailService(String email){
        this.email = email;
    }

    @Override
    public void notificar(Date data) {
        System.out.println("Um email foi enviado para o cliente: " + email + " " + sdf.format(data));
    }
}
