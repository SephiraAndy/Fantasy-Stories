package sephiraandy;

import java.util.function.Predicate;

public class BagsAreFull implements Predicate<AdventurerState> {
    @Override
    public boolean test(AdventurerState adventurerState) {
        return adventurerState.areBagsFull();
    }
}
