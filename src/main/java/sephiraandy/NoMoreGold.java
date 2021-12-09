package sephiraandy;

import java.util.function.Predicate;

public class NoMoreGold implements Predicate<AdventurerState> {
    @Override
    public boolean test(AdventurerState adventurerState) {
        return false;
    }
}
