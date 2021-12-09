package sephiraandy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TiredTest {
    @Test
    void shouldPassAdventurerTiredness() {

        final var tired = new Tired();

        final var state = new AdventurerState(null, null, 0) {
            @Override
            public boolean isTired() {
                return true;
            }
        };

        var isTired = tired.test(state);

        assertTrue(isTired);
    }

    @Test
    void shouldPassAdventurerUntiredness() {

        final var tired = new Tired();

        final var state = new AdventurerState(null, null, 0) {
            @Override
            public boolean isTired() {
                return false;
            }
        };

        var isTired = tired.test(state);

        assertFalse(isTired);
    }
}