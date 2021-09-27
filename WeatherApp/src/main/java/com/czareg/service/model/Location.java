package com.czareg.service.model;

import lombok.Value;
import org.springframework.util.StringUtils;

@Value
public class Location {
    public Location(String raw) {
        if (!StringUtils.hasText(raw)) {
            throw new IllegalArgumentException("Location can't be null or empty");
        }
        this.raw = raw;
    }

    String raw;
}