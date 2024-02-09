package org.cartdf;

import java.util.Objects;

public class Car {

    private int mileageInKm;
    private String color;
    private double cabinTemperatureInDegC;

    public void drive(int distanceInKm) {

        if (distanceInKm < 0)
            throw new IllegalArgumentException("Nice try. drive distance must be positive.");

        this.mileageInKm += distanceInKm;
    }

    public void parkInSunnySpotForGivenHours(int parkingTimeInHours) {

        if (parkingTimeInHours < 0)
            throw new IllegalArgumentException("How is this supposed to work? Parking time bust be positive.");

        // Will not work with the current naive random test data factory implementation, but you get the idea.
        final double heatingFactor = Objects.equals(getColor().toLowerCase(), "black") ? 1.5 : 1.0;

        this.cabinTemperatureInDegC += parkingTimeInHours * heatingFactor; // Much physics
    }

    public int getMileageInKm() {

        return this.mileageInKm;
    }

    public String getColor() {

        return this.color;
    }

    public double getCabinTemperatureInDegC() {

        return this.cabinTemperatureInDegC;
    }

    public void setMileageInKm(int mileageInKm) {

        this.mileageInKm = mileageInKm;
    }

    public void setColor(String color) {

        this.color = color;
    }

    public void setCabinTemperatureInDegC(double cabinTemperatureInDegC) {

        this.cabinTemperatureInDegC = cabinTemperatureInDegC;
    }

    public static class CarBuilder {

        private final Car car;

        public CarBuilder() {

            this.car = new Car();
        }

        public CarBuilder mileageInKm(int mileage) {

            this.car.setMileageInKm(mileage);
            return this;
        }

        public CarBuilder color(String color) {

            this.car.setColor(color);
            return this;
        }

        public CarBuilder cabinTemperatureInDegC(double temperatureInDegC) {

            this.car.setCabinTemperatureInDegC(temperatureInDegC);
            return this;
        }

        public Car build() {

            return this.car;
        }
    }
}
