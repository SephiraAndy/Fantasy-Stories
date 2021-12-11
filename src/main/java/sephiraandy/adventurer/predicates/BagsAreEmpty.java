package sephiraandy.adventurer.predicates;

import sephiraandy.adventurer.Adventurer;

import java.util.function.Predicate;

public class BagsAreEmpty implements Predicate<Adventurer> {
    @Override
    public boolean test(Adventurer adventurerState) {
        return false;
    }
}
