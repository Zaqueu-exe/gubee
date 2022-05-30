package com.alves;

import com.alves.Objects.User;
import com.alves.service.EmailAlert;
import com.alves.service.SmsAlert;

public class Main {
    public static void main(String[] args) {

        AlertBox alertBox = new AlertBox();

        User user1 = new User("Joao", "joao@gmail.com");
        User user2 = new User("Pedro", "pedro@gmail.com");

        EmailAlert emailAlert = new EmailAlert(user1);
        EmailAlert emailAlert1 = new EmailAlert(user2);

        SmsAlert smsAlert = new SmsAlert(user1);
        SmsAlert smsAlert1 = new SmsAlert(user2);

        alertBox.addEmail("EMERGENCIA", emailAlert);
        alertBox.addEmail("URGENCIA", smsAlert);

        alertBox.addEmail("EMERGENCIA", emailAlert1);
        alertBox.addEmail("URGENCIA", smsAlert1);

        alertBox.notifyEvery("EMERGENCIA");
        alertBox.notifyEvery("URGENCIA");

    }
}