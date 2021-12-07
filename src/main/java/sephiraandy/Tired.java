package sephiraandy;

import java.util.function.Predicate;

public class Tired implements Predicate<AdventurerState> {
    @Override
    public boolean test(AdventurerState adventurerState) {
        return false;
    }
}
