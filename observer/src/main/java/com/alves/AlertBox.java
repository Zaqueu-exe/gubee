package com.alves;

import com.alves.manager.Publisher;
import com.alves.service.EmailAlert;
import com.alves.service.interfac.EventListener;

import java.time.LocalDateTime;

public class AlertBox {
    private Publisher publisher;

    public AlertBox(){
        publisher = new Publisher("EMERGENCIA", "URGENCIA");
    }

    public void removeEmail(String event, EventListener listener){
        publisher.unsubscribe(event, listener);
    }
    public void addEmail(String event, EventListener listener){
        publisher.subscribe(event, listener);
    }

    public void notifyEvery(String event){
        publisher.notifyListeners(event, LocalDateTime.now());
    }
}
