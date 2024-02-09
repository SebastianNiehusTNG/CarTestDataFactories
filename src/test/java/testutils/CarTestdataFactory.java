package testutils;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

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

    public List<CarBuilder> createCarBuilderList(int count) {

        return IntStream.range(0, count)
                .mapToObj(i -> createCarBuilder())
                .collect(toList());
    }
}
