package sephiraandy.adventurer.predicates;

import sephiraandy.adventurer.Adventurer;

import java.util.function.Predicate;

public class FullyRested implements Predicate<Adventurer> {
    @Override
    public boolean test(Adventurer adventurerState) {
        return adventurerState.isFullyRested();
    }
}