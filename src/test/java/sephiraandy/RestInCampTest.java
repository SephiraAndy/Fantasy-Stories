package sephiraandy;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class RestInCampTest {

    @Test
    void shouldSetUpCamp() {
        final var rest = new RestInCamp();
        final var adventurerState = new MockAdventurerState();

        rest.start(adventurerState);

        assertTrue(adventurerState.hasSetUpCamp);
    }

    private static class MockAdventurerState extends AdventurerState {
        private boolean hasSetUpCamp = false;

        public MockAdventurerState() {
            super(null, null);
        }

        @Override
        public void setUpCamp() {
            hasSetUpCamp = true;
        }
    }
}