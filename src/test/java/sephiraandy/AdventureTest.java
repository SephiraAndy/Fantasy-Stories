package sephiraandy;

import org.junit.jupiter.api.Test;
import sephiraandy.adventurer.Adventurer;
import sephiraandy.adventurer.behaviours.Adventure;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventureTest {
    @Test
    void shouldStartAdventuresInTheGoblinCaves() {
        final var mockAdventurerState = new MockAdventurerState(null, null);
        final var adventurer = new Agent<Adventurer>(mockAdventurerState);

        adventurer.setBehaviour(new Adventure());

        assertEquals("The Goblin Cave", mockAdventurerState.location);
    }

    @Test
    void shouldCollectLootWhenAdventuring() {
        final var mockAdventurerState = new MockAdventurerState(null, null);
        final var adventurer = new Agent<Adventurer>(mockAdventurerState);
        adventurer.setBehaviour(new Adventure());

        adventurer.update();
        adventurer.update();

        assertEquals(2, mockAdventurerState.loot);
    }

    @Test
    void shouldTireWhenAdventuring() {
        final var mockAdventurerState = new MockAdventurerState(null, null);
        final var adventurer = new Agent<Adventurer>(mockAdventurerState);
        adventurer.setBehaviour(new Adventure());

        adventurer.update();
        adventurer.update();

        assertEquals(2, mockAdventurerState.fatigue);
    }
}