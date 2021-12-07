package sephiraandy;

import org.junit.jupiter.api.Test;

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

    private static class MockAdventurerState extends AdventurerState {
        public boolean rested = false;
        private boolean hasSetUpCamp = false;

        public MockAdventurerState() {
            super(null, null);
        }

        @Override
        public void setUpCamp() {
            hasSetUpCamp = true;
        }

        @Override
        public void rest() {
            rested = true;
        }
    }
}