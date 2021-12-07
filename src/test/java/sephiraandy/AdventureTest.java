package sephiraandy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class AdventureTest {

    private static String location;
    private static int loot;
    private static int fatigue;

    @BeforeEach
    void setUp() {
        location = null;
        loot = 0;
    }

    @Test
    void shouldStartAdventuresInTheGoblinCaves() {
        final var mockAdventurerState = new MockAdventurerState(null, null);
        final var adventurer = new Agent<AdventurerState>(mockAdventurerState);

        adventurer.setBehaviour(new Adventure());

        assertEquals("The Goblin Cave", location);
    }

    @Test
    void shouldCollectLootWhenAdventuring() {
        final var mockAdventurerState = new MockAdventurerState(null, null);
        final var adventurer = new Agent<AdventurerState>(mockAdventurerState);
        adventurer.setBehaviour(new Adventure());

        adventurer.update();
        adventurer.update();

        assertEquals(2, loot);
    }

    @Test
    void shouldTireWhenAdventuring() {
        final var mockAdventurerState = new MockAdventurerState(null, null);
        final var adventurer = new Agent<AdventurerState>(mockAdventurerState);
        adventurer.setBehaviour(new Adventure());

        adventurer.update();
        adventurer.update();

        assertEquals(2, fatigue);
    }

    private static class MockAdventurerState extends AdventurerState {
        public MockAdventurerState(Consumer<String> output, String name) {
            super(output, name);
        }

        @Override
        public void setLocation(String nextLocation) {
            location = nextLocation;
        }

        @Override
        public void collectLoot() {
            ++loot;
        }

        @Override
        public void tire() {
            ++fatigue;
        }
    }
}