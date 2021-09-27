package com.czareg.service.model;

import lombok.Value;

@Value
public class Temperature {
    public Temperature(float raw) {
        if (raw < -100 || raw > 70) {
            // Earths lowest recorded temperature is -89.2°C
            // Earths highest recorded temperature is 56.7°C
            throw new IllegalArgumentException("Temperature can't be lower than -100 or higher than 70");
        }
        this.raw = raw;
    }

    float raw;
}