package testutils;

import java.util.concurrent.ThreadLocalRandom;

import org.cartdf.Car.CarBuilder;

public final class CarTestdataFactory {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static CarBuilder createCarBuilder() {

        return new CarBuilder()
                .mileageInKm(0)
                .color("Grey")
                .cabinTemperatureInDegC(25.0);
    }

    public static CarBuilder createRandomCarBuilder() {

        return new CarBuilder()
                .mileageInKm(RANDOM.nextInt(Integer.MAX_VALUE))
                .color("Color_" + RANDOM.nextInt())   // Ideally color would be an enum and then randomly selected
                .cabinTemperatureInDegC(RANDOM.nextInt(50));
    }
}
