package com.czareg.service;

import com.czareg.service.collector.WeatherCollector;
import com.czareg.service.mail.MailSender;
import com.czareg.service.model.Location;
import com.czareg.service.model.Weather;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WeatherService {
    private final WeatherCollector weatherCollector;
    private final MailSender mailSender;

    @Async
    public void processWeather(Location location) {
        Weather weather = weatherCollector.collect(location);
        mailSender.send(weather);
    }
}