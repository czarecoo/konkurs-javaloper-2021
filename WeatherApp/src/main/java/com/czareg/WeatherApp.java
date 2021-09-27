package com.czareg;

import com.czareg.service.WeatherService;
import com.czareg.service.location.LocationGetter;
import com.czareg.service.model.Location;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@AllArgsConstructor
@SpringBootApplication
public class WeatherApp implements CommandLineRunner {
    private final LocationGetter locationGetter;
    private final WeatherService weatherService;

    public static void main(String[] args) {
        SpringApplication.run(WeatherApp.class, args);
    }

    @Override
    public void run(String... args) {
        for (int i = 0; i <= 50; i++) {
            Location location = locationGetter.get();
            weatherService.processWeather(location);
        }
    }
}