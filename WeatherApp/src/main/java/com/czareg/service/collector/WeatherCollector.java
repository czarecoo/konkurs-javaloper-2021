package com.czareg.service.collector;

import com.czareg.service.model.Location;
import com.czareg.service.model.Weather;

public interface WeatherCollector {
    Weather collect(Location location);
}