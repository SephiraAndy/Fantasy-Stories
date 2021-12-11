package sephiraandy;

import org.junit.jupiter.api.Test;
import sephiraandy.adventurer.AdventurerState;
import sephiraandy.adventurer.behaviours.RestInCamp;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RestInCampTest {

    @Test
    void shouldSetUpCamp() {
        final var rest = new RestInCamp();
        final var adventurerState = new MockAdventurerState();

        rest.start(adventurerState);

        assertTrue(adventurerState.hasSetUpCamp);
    }

    @Test
    void shouldRest() {
        final var rest = new RestInCamp();
        final var adventurerState = new MockAdventurerState();

        rest.conduct(adventurerState);

        assertTrue(adventurerState.rested);
    }

    @Test
    void shouldEndByPackingUpCamp() {
        final var rest = new RestInCamp();
        final var adventurerState = new MockAdventurerState();

        rest.end(adventurerState);

        assertTrue(adventurerState.packedUpCamp);
    }

    private static class MockAdventurerState extends AdventurerState {
        public boolean rested = false;
        private boolean hasSetUpCamp = false;
        private boolean packedUpCamp = false;

        public MockAdventurerState() {
            super(null, null, 0);
        }

        @Override
        public void setUpCamp() {
            hasSetUpCamp = true;
        }

        @Override
        public void rest() {
            rested = true;
        }

        @Override
        public void packUpCamp() {
            packedUpCamp = true;
        }
    }
}