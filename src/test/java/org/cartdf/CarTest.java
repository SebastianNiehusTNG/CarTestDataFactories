package org.cartdf;

import static org.cartdf.TrafficJam.createTrafficJam;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static testutils.CarTestdataFactory.createCarBuilder;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void mileageShouldIncreaseWhenDriving() {

        // Given
        Car myCar = createCarBuilder().build();
        final int initialMileageInKm = myCar.getMileageInKm();

        // When
        final int drivingDistanceInKm = 100;
        myCar.drive(drivingDistanceInKm);

        // Then
        int expectedMileage = initialMileageInKm + drivingDistanceInKm;
        assertEquals(myCar.getMileageInKm(), expectedMileage);
    }

    @Test
    void blackCarShouldHeatUpMoreThenWhiteCarInTheSun() {

        // Given
        Car blackCar = createCarBuilder().color("Black").build();
        Car whiteCar = createCarBuilder().color("White").build();

        // When
        final int parkingTimeInHours = 2;
        blackCar.parkInSunnySpotForGivenHours(parkingTimeInHours);
        whiteCar.parkInSunnySpotForGivenHours(parkingTimeInHours);

        // Then
        assertTrue(blackCar.getCabinTemperatureInDegC() > whiteCar.getCabinTemperatureInDegC());
    }

    @Test
    void createTrafficJamShouldCauseTerribleJam() {
        // Note: This test method would normally belong into a test class for TrafficJam, but let's just leave it
        // here for the sake of simplicity

        // Given
        final int numberOfCars = 100;
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(createCarBuilder().build());
        }

        // When
        TrafficJam resultingTrafficJam = createTrafficJam(cars);

        // Then
        assertTrue(resultingTrafficJam.isTerribleJam());
    }

}