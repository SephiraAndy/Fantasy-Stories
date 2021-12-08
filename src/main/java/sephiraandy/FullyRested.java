package sephiraandy;

import java.util.function.Predicate;

public class FullyRested implements Predicate<AdventurerState> {
    @Override
    public boolean test(AdventurerState adventurerState) {
        return adventurerState.isFullyRested();
    }
}
