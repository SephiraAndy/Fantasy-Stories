package sephiraandy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdventureTest {

    private static String location;

    @Test
    void shouldStartAdventuresInTheGoblinCaves() {
        location = null;
        final var mockAdventurerState = new MockAdventurerState();
        final var adventurer = new Agent<AdventurerState>(mockAdventurerState);

        adventurer.setBehaviour(new Adventure());

        assertEquals("The Goblin Cave", location);
    }

    private static class MockAdventurerState extends AdventurerState {
        @Override
        public void setLocation(String nextLocation) {
            location = nextLocation;
        }
    }

}