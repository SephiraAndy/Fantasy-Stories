package sephiraandy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sephiraandy.adventurer.AdventurerState;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class AdventurerStateTest {

    private MockOutput output;
    private AdventurerState adventurer;

    @BeforeEach
    void setUp() {
        output = new MockOutput();
        String name = "Adventurer";
        adventurer = new AdventurerState(output, name, 10);
    }

    @Test
    void shouldExpressLocationChange() {
        String location = "Some Location";
        adventurer.setLocation(location);
        assertEquals("Adventurer is now at Some Location.", output.text);
    }

    @Test
    void shouldExpressCollectingLoot() {
        adventurer.collectLoot();
        assertEquals("Adventurer collected some loot. Now they have 1 piece of loot.", output.text);
    }

    @Test
    void shouldExpressCollectingMoreLoot() {
        adventurer.collectLoot();
        adventurer.collectLoot();

        assertEquals("Adventurer collected some loot. Now they have 2 pieces of loot.", output.text);
    }

    @Test
    void shouldExpressGettingTired() {
        adventurer.tire();
        assertEquals("Adventurer gained fatigue. Their tiredness level is at 1.", output.text);
    }

    @Test
    void shouldExpressGettingMoreTired() {
        adventurer.tire();
        adventurer.tire();

        assertEquals("Adventurer gained fatigue. Their tiredness level is at 2.", output.text);
    }

    @Test
    void shouldNotBeTiredAt6Fatigue() {
        for (int i = 0; i < 6; i++) {
            adventurer.tire();
        }
        assertFalse(adventurer.isTired());
    }

    @Test
    void shouldBeTiredAt7Fatigue() {
        for (int i = 0; i < 7; i++) {
            adventurer.tire();
        }
        assertTrue(adventurer.isTired());
    }

    @Test
    void shouldBeTiredAt8Fatigue() {
        for (int i = 0; i < 8; i++) {
            adventurer.tire();
        }
        assertTrue(adventurer.isTired());
    }

    @Test
    void shouldExpressSettingUpCamp() {
        adventurer.setUpCamp();
        assertEquals("Adventurer is setting up camp.", output.text);
    }

    @Test
    void shouldExpressResting() {
        adventurer.rest();
        assertEquals("Adventurer is resting.", output.text);
    }

    @Test
    void shouldBecomeFullyRestedAfterRestingLongEnough() {
        adventurer.tire();
        adventurer.tire();

        adventurer.rest();

        assertTrue(adventurer.isFullyRested());
    }

    @Test
    void shouldNotBeFullyRestedWhenTired() {
        adventurer.tire();
        assertFalse(adventurer.isFullyRested());
    }

    @Test
    void shouldBeFullyRestedWhenPartiallyTired() {
        adventurer.tire();
        adventurer.rest();
        assertTrue(adventurer.isFullyRested());
    }

    @Test
    void shouldBePartiallyTiredTiringAfterPartialRest() {
        adventurer.tire();
        adventurer.rest();
        adventurer.tire();
        assertFalse(adventurer.isFullyRested());
    }

    @Test
    void shouldExpressPackingUpCamp() {
        adventurer.packUpCamp();
        assertEquals("Adventurer is packing up their camp.", output.text);
    }

    @Test
    void shouldTellThatBagsAreNotFullWhenAlmostFull() {
        adventurer.collectLoot();
        adventurer.collectLoot();
        adventurer.collectLoot();
        adventurer.collectLoot();
        adventurer.collectLoot();
        adventurer.collectLoot();
        adventurer.collectLoot();
        adventurer.collectLoot();
        adventurer.collectLoot();

        assertFalse(adventurer.bagsAreFull());
    }

    @Test
    void shouldTellThatBagsArFullWhenFull() {
        adventurer.collectLoot();
        adventurer.collectLoot();
        adventurer.collectLoot();
        adventurer.collectLoot();
        adventurer.collectLoot();
        adventurer.collectLoot();
        adventurer.collectLoot();
        adventurer.collectLoot();
        adventurer.collectLoot();
        adventurer.collectLoot();

        assertTrue(adventurer.bagsAreFull());
    }

    private static class MockOutput implements Consumer<String> {
        private String text;
        @Override
        public void accept(String s) {
            text = s;
        }
    }
}