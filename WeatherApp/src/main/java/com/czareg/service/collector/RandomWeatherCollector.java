package com.czareg.service.collector;

import com.czareg.service.model.Location;
import com.czareg.service.model.Temperature;
import com.czareg.service.model.Weather;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomWeatherCollector implements WeatherCollector {
    public static final int HIGHEST_TEMPERATURE = 40;
    private final Random random;

    public RandomWeatherCollector() {
        random = new Random();
    }

    @Override
    public Weather collect(Location location) {
        float randomTemperature = getRandomTemperature();
        Temperature temperature = new Temperature(randomTemperature);
        return new Weather(location, temperature);
    }

    private float getRandomTemperature() {
        return HIGHEST_TEMPERATURE * random.nextFloat();
    }
}