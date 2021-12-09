package sephiraandy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagsAreFullTest {

    @Test
    void shouldTellIfBagsAreFull() {
        final var bagsAreFull = new BagsAreFull();
        final var adventurer = new AdventurerState(null, null, 0) {
            @Override
            public boolean areBagsFull() {
                return true;
            }
        };

        var areBagsFull = bagsAreFull.test(adventurer);

        assertTrue(areBagsFull);
    }

    @Test
    void shouldTellIfBagsAreNotFull() {
        final var bagsAreFull = new BagsAreFull();
        final var adventurer = new AdventurerState(null, null, 0) {
            @Override
            public boolean areBagsFull() {
                return false;
            }
        };

        var areBagsFull = bagsAreFull.test(adventurer);

        assertFalse(areBagsFull);
    }
}