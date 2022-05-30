package com.alves.manager;

import com.alves.service.interfac.EventListener;

import java.time.LocalDateTime;
import java.util.*;

public class Publisher {

    private Map<String, List<EventListener>> listeners;

    public Publisher(String... events) {
        listeners = new HashMap<>();
        for (String event : events) {
            listeners.put(event, new ArrayList<>());
        }
    }

    public void subscribe(String event, EventListener emailAlert) {
        List<EventListener> emails = listeners.get(event);
        emails.add(emailAlert);
    }

    public void unsubscribe(String event, EventListener emailAlert) {
        List<EventListener> emails = listeners.get(event);
        emails.remove(emailAlert);
    }

    public void notifyListeners(String event, LocalDateTime date) {
        List<EventListener> emails = listeners.get(event);
        emails.stream()
                .forEach(x -> {
                    x.update(date);
                });
    }
}
