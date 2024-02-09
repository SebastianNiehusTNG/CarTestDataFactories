package org.cartdf;

import java.util.List;

public class TrafficJam {

    private final boolean isTerribleJam;

    public TrafficJam(boolean isTerribleJam) {

        this.isTerribleJam = isTerribleJam;
    }

    public boolean isTerribleJam() {

        return this.isTerribleJam;
    }

    public static TrafficJam createTrafficJam(List<Car> carsInTrafficJam) {

        double averageCabinTemperature =
                carsInTrafficJam.stream()
                        .map(Car::getCabinTemperatureInDegC)
                        .mapToDouble(Double::doubleValue)
                        .average()
                        .orElse(Double.NaN);

        final boolean isTerribleTrafficJam = averageCabinTemperature > 30.0 || carsInTrafficJam.size() > 99;

        return new TrafficJam(isTerribleTrafficJam);
    }
}
