package com.czareg.service.mail;

import com.czareg.service.model.Weather;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DelayedFakeMailSender implements MailSender {
    public static final long MAIL_SENDING_MILLIS = 2000L;

    @Override
    public void send(Weather weather) {
        log.info("Sending {}", weather);
        try {
            Thread.sleep(MAIL_SENDING_MILLIS);
            log.info("Successfully sent {}", weather);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Sending {} interrupted", weather);
        }
    }
}