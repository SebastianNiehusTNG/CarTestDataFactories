package testutils;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;


/**
 * Class for management and modification of multiple test data factories.
 */
public class ListModifier<BuilderType, ObjectType> {

    private final List<BuilderType> builders;
    private final Function<BuilderType, ObjectType> buildFunction;

    public ListModifier(List<BuilderType> builders, Function<BuilderType, ObjectType> buildFunction) {

        this.builders = builders;
        this.buildFunction = buildFunction;
    }

    /**
     * Method that applies the same Modifier to all builders
     *
     * @param modifier Modifier to apply on all builders of the ListModifier
     * @return ListModifier<ObjectBuilderType, ObjectType> with modifier applied to all builders.
     */
    public ListModifier<BuilderType, ObjectType> withSameModificationForAll(Consumer<BuilderType> modifier) {

        builders.forEach(modifier);
        return this;
    }

    /**
     * Apply the given Modifiers to each builder of the ListModifier individually
     * The i-th builder will be modified by the i-th Modifier in modifierList.
     *
     * @param modifierList List<Modifier> to apply. The i-th Modifier will be applied to the i-th builder.
     * @return ListModifier<ObjectBuilderType, ObjectType>
     * where the i-th builder has been modifier by the i-th Modifier in modifierList
     */
    public ListModifier<BuilderType, ObjectType> withIndividualModification(List<Consumer<BuilderType>> modifierList) {

        if (modifierList.size() != builders.size()) {
            throw new IllegalArgumentException("Modifier list must have same size as builder list");
        }

        builders.forEach(builder -> modifierList.get(builders.indexOf(builder)).accept(builder));

        return this;
    }

    /**
     * Execute the build() method of all managed builders and return a List of the resulting objects.
     *
     * @return List<ObjectType> as returned by the builder.build() function
     */
    public List<ObjectType> build() {

        return builders.stream().map(buildFunction).collect(toList());
    }
}

