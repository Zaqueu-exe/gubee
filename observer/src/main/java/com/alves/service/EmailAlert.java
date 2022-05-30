package com.alves.service;

import com.alves.Objects.User;
import com.alves.service.interfac.EventListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmailAlert implements EventListener {
    private String formatDate = "dd/MM/yyyy HH:mm:ss";
    private User user;

    public EmailAlert(User user){
        this.user = user;
    }

    @Override
    public void update(LocalDateTime data) {
        System.out.println("E-MAIL ALERT: Uma mensagem foi enviado para o cliente: " + user.getEmail() + " " + data.format(DateTimeFormatter.ofPattern(formatDate)));
    }
}
