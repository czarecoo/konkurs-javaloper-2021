package com.czareg.service.mail;

import com.czareg.service.model.Weather;

public interface MailSender {
    void send(Weather weather);
}