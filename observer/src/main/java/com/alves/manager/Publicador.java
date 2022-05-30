package com.alves.manager;

import com.alves.service.interfac.Notificar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Publicador {

    private List<Notificar> notificars = new ArrayList<>();

    public void escrever(List<Notificar> emailService) {
        emailService.stream().forEach((x) -> {
                    if (!notificars.contains(x)) {
                        notificars.add(x);
                    }
                }
        );
    }

    public void remover(Notificar emailService) {
        notificars.remove(emailService);
    }

    public void notificarTodos() {
        notificars.stream()
                .forEach(x -> {
                    x.notificar(new Date());
                });
    }
}
