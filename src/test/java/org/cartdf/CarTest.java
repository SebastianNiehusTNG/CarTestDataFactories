package org.cartdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import testutils.CarTestdataFactory;

class CarTest {

    @Test
    void mileageShouldIncreaseWhenDriving() {

        // Given
        Car myCar = CarTestdataFactory.createCarBuilder().build();
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
        Car blackCar = CarTestdataFactory.createCarBuilder().color("Black").build();
        Car whiteCar = CarTestdataFactory.createCarBuilder().color("White").build();

        // When
        final int parkingTimeInHours = 2;
        blackCar.parkInSunnySpotForGivenHours(parkingTimeInHours);
        whiteCar.parkInSunnySpotForGivenHours(parkingTimeInHours);

        // Then
        assertTrue(blackCar.getCabinTemperatureInDegC() > whiteCar.getCabinTemperatureInDegC());
    }

}