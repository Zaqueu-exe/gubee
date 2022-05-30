package com.alves.service;

import com.alves.Objects.User;
import com.alves.service.interfac.EventListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SmsAlert implements EventListener {
    private String formatDate = "dd/MM/yyyy HH:mm:ss";
    private User user;

    public SmsAlert(User user){
        this.user = user;
    }

    @Override
    public void update(LocalDateTime data) {
        System.out.println("SMS ALERT:  Uma mensagem foi enviado para o cliente: " + user.getEmail() + " " + data.format(DateTimeFormatter.ofPattern(formatDate)));
    }
}
