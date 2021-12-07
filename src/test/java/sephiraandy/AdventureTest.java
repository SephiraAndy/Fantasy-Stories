package sephiraandy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdventureTest {

    private static String location;
    private static int loot;

    @BeforeEach
    void setUp() {
        location = null;
        loot = 0;
    }

    @Test
    void shouldStartAdventuresInTheGoblinCaves() {
        final var mockAdventurerState = new MockAdventurerState();
        final var adventurer = new Agent<AdventurerState>(mockAdventurerState);

        adventurer.setBehaviour(new Adventure());

        assertEquals("The Goblin Cave", location);
    }

    @Test
    void shouldCollectLootWhenAdventuring() {
        final var mockAdventurerState = new MockAdventurerState();
        final var adventurer = new Agent<AdventurerState>(mockAdventurerState);
        adventurer.setBehaviour(new Adventure());

        adventurer.update();
        adventurer.update();

        assertEquals(2, loot);
    }

    private static class MockAdventurerState extends AdventurerState {
        @Override
        public void setLocation(String nextLocation) {
            location = nextLocation;
        }

        @Override
        public void collectLoot() {
            ++loot;
        }
    }
}