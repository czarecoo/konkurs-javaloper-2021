package com.czareg.service.model;

import lombok.NonNull;
import lombok.Value;

@Value
public class Weather {
    @NonNull
    Location location;
    @NonNull
    Temperature temperature;
}