package sephiraandy;

import org.junit.jupiter.api.Test;
import sephiraandy.adventurer.AdventurerState;
import sephiraandy.adventurer.predicates.FullyRested;

import static org.junit.jupiter.api.Assertions.*;

class FullyRestedTest {
    @Test
    void shouldPassAdventurerFullyRestedness() {

        final var fullyRested = new FullyRested();

        final var state = new AdventurerState(null, null, 0) {
            @Override
            public boolean isFullyRested() {
                return true;
            }
        };

        var isFullyRested = fullyRested.test(state);

        assertTrue(isFullyRested);
    }

    @Test
    void shouldPassAdventurerNotFullyRestedness() {

        final var fullyRested = new FullyRested();

        final var state = new AdventurerState(null, null, 0) {
            @Override
            public boolean isFullyRested() {
                return false;
            }
        };

        var isFullyRested = fullyRested.test(state);

        assertFalse(isFullyRested);
    }
}