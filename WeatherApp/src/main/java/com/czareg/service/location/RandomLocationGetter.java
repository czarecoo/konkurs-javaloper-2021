package com.czareg.service.location;

import com.czareg.service.model.Location;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Component
public class RandomLocationGetter implements LocationGetter {
    private final List<Location> locations;
    private final Random random;

    public RandomLocationGetter() {
        random = new Random();
        locations = Stream.of("Tokyo", "Warsaw", "London")
                .map(Location::new)
                .collect(toList());
    }

    @Override
    public Location get() {
        int max = locations.size();
        int randomIndex = random.nextInt(max);
        return locations.get(randomIndex);
    }
}