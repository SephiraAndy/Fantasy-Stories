package sephiraandy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FullyRestedTest {
    @Test
    void shouldPassAdventurerFullyRestedness() {

        final var fullyRested = new FullyRested();

        final var state = new AdventurerState(null, null) {
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

        final var state = new AdventurerState(null, null) {
            @Override
            public boolean isFullyRested() {
                return false;
            }
        };

        var isFullyRested = fullyRested.test(state);

        assertFalse(isFullyRested);
    }
}