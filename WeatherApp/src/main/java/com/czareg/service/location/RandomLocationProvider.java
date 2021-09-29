package com.czareg.service.location;

import com.czareg.service.model.Location;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Component
public class RandomLocationProvider implements LocationProvider {
    private final List<Location> locations;
    private final Random random;

    public RandomLocationProvider() {
        random = new Random();
        locations = Stream.of("Cracow", "Warsaw", "London", "Lodz", "Kielce", "Tokyo", "NewYork", "Buenos Aires", "Rzeszow")
                .map(Location::new)
                .collect(toList());
    }

    @Override
    public Location provide() {
        int max = locations.size();
        int randomIndex = random.nextInt(max);
        return locations.get(randomIndex);
    }
}