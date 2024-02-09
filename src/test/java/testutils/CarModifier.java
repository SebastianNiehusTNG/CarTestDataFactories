package testutils;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.Consumer;

import org.cartdf.Car;
import org.cartdf.Car.CarBuilder;


public class CarModifier {

    // Modifiers for single values
    public static Consumer<CarBuilder> mileageInKm(int mileage) {

        return builder -> builder.mileageInKm(mileage);
    }

    public static Consumer<CarBuilder> color(String color) {

        return builder -> builder.color(color);
    }

    // Modifiers for other fields of Car
    // ...

    // Methods for creating modifier lists with multiple different values
    public static List<Consumer<CarBuilder>> mileageInKm(List<Integer> mileageList) {

        return mileageList.stream().map(CarModifier::mileageInKm).collect(toList());
    }

    public static List<Consumer<CarBuilder>> color(List<String> colorList) {

        return colorList.stream().map(CarModifier::color).collect(toList());
    }

    // Modifiers for other fields of Car
    // ...

    // Class that manages the creation and modification of lists of CarBuilders
    public static class CarListModifier extends ListModifier<CarBuilder, Car> {

        CarListModifier(List<CarBuilder> builders) {

            super(builders, CarBuilder::build);
        }
    }
}