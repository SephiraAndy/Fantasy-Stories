package sephiraandy;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class AdventurerStateTest {

    @Test
    void shouldExpressLocationChange() {
        final var output = new MockOutput();
        final var name = "Adventurer";
        final var adventurer = new AdventurerState(output, name);
        String location = "Some Location";

        adventurer.setLocation(location);

        assertEquals("Adventurer is now at Some Location.", output.text);
    }

    @Test
    void shouldExpressCollectingLoot() {
        final var output = new MockOutput();
        final var name = "Adventurer";
        final var adventurer = new AdventurerState(output, name);

        adventurer.collectLoot();

        assertEquals("Adventurer collected some loot. Now they have 1 piece of loot.", output.text);
    }

    @Test
    void shouldExpressCollectingMoreLoot() {
        final var output = new MockOutput();
        final var name = "Another Adventurer";
        final var adventurer = new AdventurerState(output, name);

        adventurer.collectLoot();
        adventurer.collectLoot();

        assertEquals("Another Adventurer collected some loot. Now they have 2 pieces of loot.", output.text);
    }

    @Test
    void shouldExpressGettingTired() {
        final var output = new MockOutput();
        final var name = "Adventurer";
        final var adventurer = new AdventurerState(output, name);

        adventurer.tire();

        assertEquals("Adventurer gained fatigue. Their tiredness level is at 1.", output.text);
    }

    @Test
    void shouldExpressGettingMoreTired() {
        final var output = new MockOutput();
        final var name = "Another Adventurer";
        final var adventurer = new AdventurerState(output, name);

        adventurer.tire();
        adventurer.tire();

        assertEquals("Another Adventurer gained fatigue. Their tiredness level is at 2.", output.text);
    }

    @Test
    void shouldNotBeTiredAt6Fatigue() {
        final var output = new MockOutput();
        final var name = "Adventurer";
        final var adventurer = new AdventurerState(output, name);

        for (int i = 0; i < 6; i++) {
            adventurer.tire();
        }

        assertFalse(adventurer.isTired());
    }

    @Test
    void shouldBeTiredAt7Fatigue() {
        final var output = new MockOutput();
        final var name = "Adventurer";
        final var adventurer = new AdventurerState(output, name);

        for (int i = 0; i < 7; i++) {
            adventurer.tire();
        }

        assertTrue(adventurer.isTired());
    }

    @Test
    void shouldBeTiredAt8Fatigue() {
        final var output = new MockOutput();
        final var name = "Adventurer";
        final var adventurer = new AdventurerState(output, name);

        for (int i = 0; i < 8; i++) {
            adventurer.tire();
        }

        assertTrue(adventurer.isTired());
    }

    private static class MockOutput implements Consumer<String> {
        private String text;
        @Override
        public void accept(String s) {
            text = s;
        }
    }
}